package it.uniba.app;

/**
 * classe che estende Nave rappresentante una Corazzata.
 */
public class Corazzata extends Nave {

    private static final int NUMERO_CELLE = 4;
    private static final int NUMERO_ESEMPLARI_INIZIALE = 2;
    private static int numeroEsemplari = NUMERO_ESEMPLARI_INIZIALE;

    /**
     * override del costruttore vuoto di Nave che imposta il numero delle celle.
     */
    public Corazzata() {
        super(NUMERO_CELLE);
    }

    /**
     * getter del numero di esemplari di Corazzata in partita.
     * @return numeroEsemplari
     */
    public static int getNumeroEsemplari() {
        return numeroEsemplari;
    }

    /**
     * setter del numero di esemplari di Corazzata in partita.
     * @param numEsemplari
     */
    public static void setNumeroEsemplari(final int numEsemplari) {
        Corazzata.numeroEsemplari = numEsemplari;
    }

    /**
     * override del metodo toString di Object.
     * @return una stringa che descrive la nave
     */
    public String toString() {
        return " - Corazzata\t\t[X][X][X][X]\t\tEsemplari: " + this.numeroEsemplari;
    }
}
