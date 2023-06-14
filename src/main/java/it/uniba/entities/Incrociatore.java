package it.uniba.entities;

/**
 * <Entity>
 * Classe che estende Nave rappresentante un Incrociatore.
 */
public class Incrociatore extends Nave {

    private static final int NUMERO_CELLE = 3;
    private static final int NUMERO_ESEMPLARI_INIZIALE = 3;
    private static int numeroEsemplari = NUMERO_ESEMPLARI_INIZIALE;

    /**
     * Override del costruttore vuoto di Nave che imposta il numero delle celle.
     */
    public Incrociatore() {
        super(NUMERO_CELLE);
    }

    /**
     * Getter del numero di esemplari di Incrociatore in partita.
     * @return numeroEsemplari
     */
    public static int getNumeroEsemplari() {
        return Incrociatore.numeroEsemplari;
    }

    /**
     * Setter del numero di esemplari di Incrociatore in partita.
     * @param numEsemplari
     */
    public static void setNumeroEsemplari(final int numEsemplari) {
        Incrociatore.numeroEsemplari = numEsemplari;
    }

    /**
     * Override del metodo toString di Object.
     * @return una stringa che descrive la nave
     */
    public String toString() {
        return " - Incrociatore\t\t[X][X][X]\t\tEsemplari: " + Incrociatore.numeroEsemplari;
    }
}
