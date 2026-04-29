package B;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AristaTest {

    @Test
    void getOrigen() {
        Nodo origen = new Nodo("A");
        Nodo destino = new Nodo("B");
        Arista arista = new Arista(origen, "conoce", destino);

        assertEquals(origen, arista.getOrigen());
    }

    @Test
    void getRelacion() {
        Nodo origen = new Nodo("A");
        Nodo destino = new Nodo("B");
        Arista arista = new Arista(origen, "conoce", destino);

        assertEquals("conoce", arista.getRelacion());
    }

    @Test
    void getDestino() {
        Nodo origen = new Nodo("A");
        Nodo destino = new Nodo("B");
        Arista arista = new Arista(origen, "conoce", destino);

        assertEquals(destino, arista.getDestino());
    }
}