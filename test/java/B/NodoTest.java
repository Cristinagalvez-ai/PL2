package B;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class NodoTest {

    @Test
    void getNombre() {
        Nodo nodo = new Nodo("A");
        assertEquals("A", nodo.getNombre());
    }
}