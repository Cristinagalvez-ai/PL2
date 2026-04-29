package A;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioDeBusquedaEnterosTest {

    @Test
    void crearNuevoArbol() {
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();

        ArbolBinarioDeBusqueda<Integer> nuevo = arbol.crearNuevoArbol();

        assertNotNull(nuevo);
        assertTrue(nuevo instanceof ArbolBinarioDeBusquedaEnteros);
        assertTrue(nuevo.esVacio());
    }

    @Test
    void getSuma() {
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();

        assertEquals(0, arbol.getSuma());

        arbol.add(5);
        arbol.add(3);
        arbol.add(7);
        arbol.add(1);

        assertEquals(16, arbol.getSuma());
    }
}