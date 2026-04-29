package B;

import A.lista.ListaSimplementeEnlazada;    // Importamos nuestra lista
import B.cola.Cola; // Importamos nuuestra cola
import java.util.*;

public class Grafo {
    // Lista donde guardamos todos los nodos del grafo
    private ListaSimplementeEnlazada<Nodo> listaNodos = new ListaSimplementeEnlazada<>();
    // Lista donde guardamos todas las aristas del grafo
    private ListaSimplementeEnlazada<Arista> listaAristas = new ListaSimplementeEnlazada<>();

    public void insertarTripleta(String nombreOrigen, String relacion, String nombreDestino) {
        Nodo origen = buscarOCrearNodo(nombreOrigen);   // Buscamos el nodo origen, y si no existe, se crea
        Nodo destino = buscarOCrearNodo(nombreDestino); // Ahora buscamos el nodo destino, y si no existe, se crea
        Arista arista = new Arista(origen, relacion, destino);  // Creamos una arista que conecta origen con destino mediante una relación
        listaAristas.insertarPrimero(arista);   // Insertamos la arista en la lista de aristas
    }

    // Busca un nodo por su nombre, si existe, lo devuelve; si no existe, lo crea, lo mete en la lista y lo devuelve.
    private Nodo buscarOCrearNodo(String nombre) {
        // Recorremos todos los nodos ya creados
        for (Nodo n : listaNodos) {
            if (n.getNombre().equals(nombre)) return n; // Si encontramos uno con el mismo nombre, lo devolvemos
        }
        // Si no se ha encontrado, creamos un nodo nuevo y lo insertamos en la lista de nodos
        Nodo nuevo = new Nodo(nombre);
        listaNodos.insertarPrimero(nuevo);
        return nuevo;   // Devolvemos el nodo creado
    }

    // MÉTODOS PARA LAS PREGUNTAS

    // Comprueba si el grafo es disjunto, es decir, si hay alguna parte del grafo que está separada de otra
    public boolean esDisjunto() {
        // Creamos un iterador para recorrer los nodos
        Iterator<Nodo> it = listaNodos.iterator();
        if (!it.hasNext()) return false;    // Si no hay nodos, devolvemos false

        Set<Nodo> visitados = new HashSet<>();  // Conjunto donde guardamos los nodos ya visitados
        Cola<Nodo> colaPropia = new Cola<>();   // Cola propia para hacer un recorrido en anchura

        Nodo inicial = it.next();   // Cogemos el primer nodo como punto de inicio
        colaPropia.enqueue(inicial);    // Metemos el nodo inicial en la cola
        visitados.add(inicial); // Marcamos el nodo inicial como visitado

        // Mientras la cola no esté vacía, seguimos recorriéndola
        while (colaPropia.peek() != null) {
            Nodo actual = colaPropia.dequeue(); // Sacamos el primer nodo de la cola
            // Recorremos todas las aristas del grafo
            for (Arista a : listaAristas) {
                // Si la arista sale del nodo actual y el destino no ha sido visitado, visitamos el destino y lo metemos en la cola
                if (a.getOrigen().equals(actual) && !visitados.contains(a.getDestino())) {
                    visitados.add(a.getDestino());
                    colaPropia.enqueue(a.getDestino());
                }
                // También comprobamos el caso contrario para tratar el grafo como no dirigido
                if (a.getDestino().equals(actual) && !visitados.contains(a.getOrigen())) {
                    visitados.add(a.getOrigen());
                    colaPropia.enqueue(a.getOrigen());
                }
            }
        }

        // Contamos cuántos nodos hay en total
        int totalNodos = 0;
        for (Nodo n : listaNodos) totalNodos++;
        return visitados.size() < totalNodos;   // Si los visitados son menos que el total de nodos, significa que hay nodos a los que no se puede llegar, por tanto, el grafo es disjunto
    }

    // Calcula el camino mínimo desde un nodo A hasta un nodo B
    public List<Nodo> caminoMinimo(String nombreA, String nombreB) {
        Nodo inicio = buscarNodo(nombreA);  // Buscamos el nodo inicial
        if (inicio == null) return null;    // Si el nodo inicial no existe, no puede haber camino

        // Cola para hacer recorrido en anchura
        Cola<Nodo> colaPropia = new Cola<>();
        // Mapa que guarda el padre de cada nodo, sirve para reconstruir el camino al final
        Map<Nodo, Nodo> padres = new HashMap<>();

        colaPropia.enqueue(inicio); // Metemos el nodo inicial en la cola
        padres.put(inicio, null);   // El nodo inicial no tiene padre, por eso ponemos null

        while (colaPropia.peek() != null) { // Mientras la cola no esté vacía
            Nodo actual = colaPropia.dequeue(); // Sacamos el primer nodo
            // Si el nodo actual es el destino, reconstruimos y devolvemos el camino
            if (actual.getNombre().equals(nombreB)) return reconstruirCamino(padres, actual);

            // Recorremos las aristas buscando vecinos del nodo actual
            for (Arista a : listaAristas) {
                // Si la arista sale del nodo actual y el destino todavía no tiene padre, significa que todavía no lo hemos visitado
                if (a.getOrigen().equals(actual) && !padres.containsKey(a.getDestino())) {
                    padres.put(a.getDestino(), actual); // Guardamos que el padre del destino es el nodo actual
                    colaPropia.enqueue(a.getDestino()); // Metemos el destino en la cola para seguir buscando
                }
            }
        }
        return null;    // Si no encontramos camino, devolvemos null
    }

    // Busca un nodo por su nombre
    private Nodo buscarNodo(String nombre) {
        // Recorremos la lista de nodos
        for (Nodo n : listaNodos) {
            // Si el nombre coincide, devolvemos ese nodo
            if (n.getNombre().equals(nombre)) return n;
        }
        return null;    // Si no existe, devolvemos null
    }

    // Reconstruye el camino usando el mapa de padres
    private List<Nodo> reconstruirCamino(Map<Nodo, Nodo> padres, Nodo fin) {
        // Lista donde guardaremos el camino final
        List<Nodo> camino = new ArrayList<>();
        Nodo actual = fin;  // Empezamos desde el nodo final
        while (actual != null) {    // Vamos retrocediendo desde el final hasta el inicio
            camino.add(0, actual);  // Insertamos cada nodo al principio de la lista
            actual = padres.get(actual);  // Pasamos al padre del nodo actual
        }
        return camino;  // Devolvemos el camino ordenado desde inicio hasta el final
    }
}
