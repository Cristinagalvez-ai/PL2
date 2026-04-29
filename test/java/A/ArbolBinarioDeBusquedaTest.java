package A;

import A.lista.ListaSimplementeEnlazada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioDeBusquedaTest {

    @Test
    void crearNuevoArbol() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();

        ArbolBinarioDeBusqueda<Integer> nuevo = arbol.crearNuevoArbol();

        assertNotNull(nuevo);
        assertTrue(nuevo.esVacio());
    }

    @Test
    void esVacio() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();

        assertTrue(arbol.esVacio());

        arbol.add(10);

        assertFalse(arbol.esVacio());
    }

    @Test
    void getListaOrdenCentral() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();

        arbol.add(5);
        arbol.add(3);
        arbol.add(7);
        arbol.add(1);
        arbol.add(4);

        ListaSimplementeEnlazada<Integer> lista = arbol.getListaOrdenCentral();

        String resultado = "";
        for (Integer numero : lista) {
            resultado += numero + " ";
        }

        assertEquals("1 3 4 5 7 ", resultado);
    }

    @Test
    void getCamino() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();

        arbol.add(5);
        arbol.add(3);
        arbol.add(7);
        arbol.add(1);
        arbol.add(4);

        ListaSimplementeEnlazada<Integer> camino = arbol.getCamino(4);

        String resultado = "";
        for (Integer numero : camino) {
            resultado += numero + " ";
        }

        assertEquals("5 3 4 ", resultado);
    }

    @Test
    void add() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();

        arbol.add(10);

        assertFalse(arbol.esVacio());
        assertEquals(0, arbol.getAltura());
    }

    @Test
    void getAltura() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();

        assertEquals(-1, arbol.getAltura());

        arbol.add(5);
        assertEquals(0, arbol.getAltura());

        arbol.add(3);
        arbol.add(1);

        assertEquals(2, arbol.getAltura());
    }

    @Test
    void isArbolHomogeneo() {
        ArbolBinarioDeBusqueda<Integer> arbolVacio = new ArbolBinarioDeBusqueda<>();
        assertTrue(arbolVacio.isArbolHomogeneo());

        ArbolBinarioDeBusqueda<Integer> arbolHomogeneo = new ArbolBinarioDeBusqueda<>();
        arbolHomogeneo.add(5);
        arbolHomogeneo.add(3);
        arbolHomogeneo.add(7);

        assertTrue(arbolHomogeneo.isArbolHomogeneo());

        ArbolBinarioDeBusqueda<Integer> arbolNoHomogeneo = new ArbolBinarioDeBusqueda<>();
        arbolNoHomogeneo.add(5);
        arbolNoHomogeneo.add(3);

        assertFalse(arbolNoHomogeneo.isArbolHomogeneo());
    }
}