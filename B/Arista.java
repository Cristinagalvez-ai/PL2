package B;

public class Arista {
    private Nodo origen;    // Nodo desde el que sale la arista
    private String relacion;    // Relación que hay entre origen y destino
    private Nodo destino;   // Nodo al que llega la arista

    // Constructor de la arista
    public Arista(Nodo origen, String relacion, Nodo destino) {
        this.origen = origen;
        this.relacion = relacion;
        this.destino = destino;
    }

    public Nodo getOrigen() { return origen; }
    public String getRelacion() { return relacion; }
    public Nodo getDestino() { return destino; }
}
