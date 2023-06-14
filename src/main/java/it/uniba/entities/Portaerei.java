package it.uniba.entities;

/**
 * <Entity>
 * Classe che estende Nave rappresentante un Portaerei.
 */
public class Portaerei extends Nave {

    private static final int NUMERO_CELLE = 5;
    private static final int NUMERO_ESEMPLARI_INIZIALE = 1;
    private static int numeroEsemplari = NUMERO_ESEMPLARI_INIZIALE;

    /**
     * Override del costruttore vuoto di Nave che imposta il numero delle celle.
     */
    public Portaerei() {
        super(NUMERO_CELLE);
    }

    /**
     * Getter del numero di esemplari di Portaerei in partita.
     * @return numeroEsemplari
     */
    public static int getNumeroEsemplari() {
        return Portaerei.numeroEsemplari;
    }

    /**
     * Setter del numero di esemplari di Portaerei in partita.
     * @param numEsemplari
     */
    public static void setNumeroEsemplari(final int numEsemplari) {
        Portaerei.numeroEsemplari = numEsemplari;
    }

    /**
     * Override del metodo toString di Object.
     * @return una stringa che descrive la nave
     */
    public String toString() {
        return " - Portaerei\t\t[X][X][X][X][X]\t\tEsemplari: " + Portaerei.numeroEsemplari;
    }
}
