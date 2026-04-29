package A;

// Hereda lo que tiene ArbolBinarioDeBusqueda
public class ArbolBinarioDeBusquedaEnteros extends ArbolBinarioDeBusqueda<Integer> {

    // Sobrescribimos este metodo para que, cuando se creen subárboles, sean también de tipo ArbolBinarioDeBusquedaEnteros y no del árbol genérico
    @Override
    protected ArbolBinarioDeBusqueda<Integer> crearNuevoArbol() {
        return new ArbolBinarioDeBusquedaEnteros();
    }

    // Calcula la suma de todos los datos guardados en el árbol
    public int getSuma() {
        // Si el árbol está vacío, no hay nada que sumar
        if (esVacio()) return 0;
        // Empezamos sumando el dato del nodo actual
        int suma = this.dato;
        if (izquierdo != null) suma += ((ArbolBinarioDeBusquedaEnteros)izquierdo).getSuma();    // Si existe hijo izquierdo, sumamos recursivamente todos sus nodos
        if (derecho != null) suma += ((ArbolBinarioDeBusquedaEnteros)derecho).getSuma();     // Si existe hijo derecho, sumamos también todos sus nodos
        return suma;    // Devolvemos la suma total del nodo actual + subárbol izquierdo + subárbol derecho
    }
}
