package B;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GrafoTest {

    @Test
    void insertarTripleta() {
        Grafo g = new Grafo();

        // No podemos acceder a las listas internas, pero comprobamos que no rompe
        g.insertarTripleta("A", "rel", "B");

        // Si no lanza excepción → correcto
        assertTrue(true);
    }

    @Test
    void esDisjunto() {
        Grafo g = new Grafo();

        // Grafo conectado
        g.insertarTripleta("A", "rel", "B");
        g.insertarTripleta("B", "rel", "C");

        assertFalse(g.esDisjunto()); // NO es disjunto

        // Añadimos parte separada
        g.insertarTripleta("D", "rel", "E");

        assertTrue(g.esDisjunto()); // ahora SÍ es disjunto
    }

    @Test
    void caminoMinimo() {
        Grafo g = new Grafo();

        g.insertarTripleta("A", "rel", "B");
        g.insertarTripleta("B", "rel", "C");

        List<Nodo> camino = g.caminoMinimo("A", "C");

        assertNotNull(camino);
        assertEquals(3, camino.size());
        assertEquals("A", camino.get(0).getNombre());
        assertEquals("C", camino.get(2).getNombre());
    }

    @Test
    void caminoMinimoInexistente() {
        Grafo g = new Grafo();

        g.insertarTripleta("A", "rel", "B");

        List<Nodo> camino = g.caminoMinimo("A", "Z");

        assertNull(camino);
    }

    @Test
    void caminoMinimoNodoNoExiste() {
        Grafo g = new Grafo();

        List<Nodo> camino = g.caminoMinimo("X", "Y");

        assertNull(camino);
    }
}