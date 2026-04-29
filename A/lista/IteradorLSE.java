package A.lista;

import java.util.Iterator;

public class IteradorLSE<T> implements Iterator<T> {
    private ElementoSE<T> actual;

    /** Constructor del iterador
     */
    public IteradorLSE(ElementoSE<T> primero) {
        actual = primero;
    }

    /** Metodo que comprueba que hay un siguiente elemento
     */
    @Override
    public boolean hasNext() {
        return actual != null;
    }

    /** Metodo que recorre la lista
     */
    @Override
    public T next() {
        if (actual == null) {
            return null;
        }

        T dato = actual.dato;   //guardamos el dato del elemento actual
        actual = actual.siguiente;  //pasamos al siguiente eleme
        return dato;
    }
}
