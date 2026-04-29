package A.lista;

/** Elemento para lista simplemente enlazada
 */
public class ElementoSE<T> {
    // dato de tipo genético T
    public T dato;
    // referencia al siguiente elemento de la lista
    public ElementoSE<T> siguiente;

    /** Constructor que enlaza los elementos formando la estructura de lista
     */
    public ElementoSE(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
