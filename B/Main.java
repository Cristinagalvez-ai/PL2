package B;

import B.Grafo;
import B.Nodo;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();  // Creamos un grafo vacío

        // Añadimos la tripleta de Antonio, esto crea una relación entre Antonio y su lugar de nacimiento
        g.insertarTripleta("persona:Antonio", "nace_en", "lugar:Villarrubia de los Caballeros");

        // Añadimos varias relaciones al grafo
        g.insertarTripleta("persona:Albert_Einstein", "nacido_en", "lugar:Ulm");
        g.insertarTripleta("persona:Albert_Einstein", "premio", "Nobel_Fisica");
        g.insertarTripleta("persona:Albrecht_Unsold", "nacido_en", "lugar:Ulm");

        // Verificamos si el grafo es disjunto
        System.out.println("¿Es el grafo disjunto?: " + g.esDisjunto());

        // Buscamos el camino mínimo entre Albert Einstein y Ulm
        List<Nodo> camino = g.caminoMinimo("persona:Albert_Einstein", "lugar:Ulm");
        // Si se ha encontrado camino, lo imprimimos
        if(camino != null) {
            // Convertimos cada nodo del camino en su nombre para mostrarlo mejor
            System.out.println("Camino encontrado: " + camino.stream().map(Nodo::getNombre).toList());
        }
    }
}
