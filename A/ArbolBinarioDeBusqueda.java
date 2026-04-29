package A;

import A.lista.ListaSimplementeEnlazada;

public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {
    // Dato que guarda el nodo actual
    protected T dato;
    // Subárbol izquierdo y derecho
    protected ArbolBinarioDeBusqueda<T> izquierdo;
    protected ArbolBinarioDeBusqueda<T> derecho;

    // Metodo para crear un nuevo árbol vacío
    protected ArbolBinarioDeBusqueda<T> crearNuevoArbol() {
        return new ArbolBinarioDeBusqueda<>();
    }

    // Verificamos si el nodo actual tiene información o no
    public boolean esVacio() { return dato == null; }

    // Devuelve una lista con el recorrido en orden central
    public ListaSimplementeEnlazada<T> getListaOrdenCentral() {
        ListaSimplementeEnlazada<T> lista = new ListaSimplementeEnlazada<>();
        llenarOrdenCentral(lista);  // llama al metodo recursivo
        return lista;
    }

    // Metodo recursivo para recorrer el árbol en orden de izquierda a derecha
    private void llenarOrdenCentral(ListaSimplementeEnlazada<T> lista) {
        if (esVacio()) return;  // si está vacío, no hace nada
        if (izquierdo != null) izquierdo.llenarOrdenCentral(lista);
        lista.insertarUltimo(this.dato);
        if (derecho != null) derecho.llenarOrdenCentral(lista);
    }

    // Metodo que busca un valor y devuelve la lista de nodos por los que pasó
    public ListaSimplementeEnlazada<T> getCamino(T objetivo) {
        ListaSimplementeEnlazada<T> lista = new ListaSimplementeEnlazada<>();
        llenarCamino(lista, objetivo);  // metodo recursivo
        return lista;
    }

    // Metodo recursivo para construir el camino
    private boolean llenarCamino(ListaSimplementeEnlazada<T> lista, T objetivo) {
        if (esVacio()) return false;
        lista.insertarUltimo(this.dato); // añadimos el nodo actual al camino
        if (this.dato.equals(objetivo)) return true;    // Si encontramos el objetivo, terminamos

        // Si el objetivo es menor entonces vamos a la izquierda
        if (objetivo.compareTo(this.dato) < 0 && izquierdo != null) {
            return izquierdo.llenarCamino(lista, objetivo);
        } else if (objetivo.compareTo(this.dato) > 0 && derecho != null) {  // Si es mayor entonces vamos a la derecha
            return derecho.llenarCamino(lista, objetivo);
        }
        // Si no está, devolvemos false
        return false;
    }

    // Inserta un nuevo dato en el árbol manteniendo el orden
    public void add(T nuevoDato) {
        if (esVacio()) {
            this.dato = nuevoDato;  // si está vacío, añade el dato
        } else {
            int comp = nuevoDato.compareTo(this.dato);
            if (comp < 0) {
                if (izquierdo == null) izquierdo = crearNuevoArbol();
                izquierdo.add(nuevoDato);
            } else if (comp > 0) {
                if (derecho == null) derecho = crearNuevoArbol();
                derecho.add(nuevoDato);
            }
        }
    }

    // Calcula la altura del árbol
    public int getAltura() {
        if (esVacio()) return -1;   // árbol vacío
        int hI;
        if (izquierdo != null) {
            hI = izquierdo.getAltura();
        } else {
            hI = -1;
        }
        int hD;
        if (derecho != null) {
            hD = derecho.getAltura();
        } else {
            hD = -1;
        }
        return 1 + Math.max(hI, hD);
    }

    // Comprueba si el árbol es homogéneo (todos los nodos tienen 0 o 2 hijos)
    public boolean isArbolHomogeneo() {
        if (esVacio() || (izquierdo == null && derecho == null)) return true;
        if (izquierdo != null && derecho != null)
            return izquierdo.isArbolHomogeneo() && derecho.isArbolHomogeneo();
        return false;   // si solo tiene un hijo, no es homogéneo
    }
}
