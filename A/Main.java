package A;

import A.lista.ListaSimplementeEnlazada;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE ÁRBOL BINARIO ===");

        // Creamos un árbol binario de búsqueda de enteros que permite insertar números y luego hacer operaciones con ellos
        ArbolBinarioDeBusquedaEnteros arb = new ArbolBinarioDeBusquedaEnteros();

        int[] datosParaInsertar = {7, 3, 10, 1, 5, 8, 12};

        // Recorremos el array e insertamos cada número en el árbol
        for (int n : datosParaInsertar) {
            arb.add(n);
        }

        imprimirResultados(arb, 5);
    }

    private static void imprimirResultados(ArbolBinarioDeBusquedaEnteros arb, int val) {
        // Imprime la suma de todos los nodos del árbol
        System.out.println("Suma total de los nodos: " + arb.getSuma());
        // Imprime la altura del árbol
        System.out.println("Altura del árbol: " + arb.getAltura());

        // Obtiene el camino desde la raíz hasta el valor indicado
        ListaSimplementeEnlazada<Integer> cam = arb.getCamino(val);

        // Muestra el camino para llegar al valor
        System.out.print("Camino para llegar al " + val + ": ");
        cam.mostrarLista();
        // Muestra cuántos nodos hay en ese camino
        System.out.println("Número de nodos en el camino: " + cam.size());
        // Indica si el árbol es homogéneo o no
        System.out.println("¿Es un árbol homogéneo?: " + arb.isArbolHomogeneo());

        // Muestra el recorrido en orden central del árbol
        System.out.println("Recorrido en Orden Central:");
        arb.getListaOrdenCentral().mostrarLista();
    }
}