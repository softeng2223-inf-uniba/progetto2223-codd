package it.uniba.app;

/**
 * classe che estende Nave rappresentante un cacciatorpediniere.
 */
public class Cacciatorpediniere extends Nave {

    private static final int NUMERO_CELLE = 2;
    private static final int NUMERO_ESEMPLARI_INIZIALE = 4;
    private static int numeroEsemplari = NUMERO_ESEMPLARI_INIZIALE;

    /**
     * override del costruttore vuoto di Nave che imposta il numero delle celle.
     */
    public Cacciatorpediniere() {
        super(NUMERO_CELLE);
    }

    /**
     * getter del numero di esemplari di cacciatorpediniere in partita.
     * @return numeroEsemplari
     */
    public static int getNumeroEsemplari() {
        return numeroEsemplari;
    }

    /**
     * setter del numero di esemplari di cacciatorpediniere in partita.
     * @param numEsemplari
     */
    public static void setNumeroEsemplari(final int numEsemplari) {
        Cacciatorpediniere.numeroEsemplari = numEsemplari;
    }

    /**
     * override del metodo toString di Object.
     * @return una stringa che descrive la nave
     */
    public String toString() {
        return " - Cacciatorpediniere\t[X][X]\t\t\tEsemplari: " + this.numeroEsemplari;
    }
}
