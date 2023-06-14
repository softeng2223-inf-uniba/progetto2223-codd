package it.uniba.entities;

/**
 * <Entity>
 * Classe che rappresenta le proprietà generali della successiva
 * partita da giocare.
 */
public final class Proprieta {

    private static final int DIMENSIONI_GRIGLIA_DEFAULT = 10;
    private int dimensioniGriglia = DIMENSIONI_GRIGLIA_DEFAULT;

    private static Proprieta istanza = null;

    /**
     * Costruttore privato della classe Proprieta.
     */
    private Proprieta() {
    }


    /**
     * Metodo statico che restituisce l'unica istanza di Proprieta,
     * implementando il pattern Singleton.
     * @return istanza
     */
    public static Proprieta getIstanza() {

        if (istanza == null) {
            istanza = new Proprieta();
        }
        return istanza;
    }

    /**
     * Getter di dimensioniGriglia.
     * @return dimensioniGriglia
     */
    public int getDimensioniGriglia() {
        return this.dimensioniGriglia;
    }

    /**
     * Setter di dimensionigriglia.
     * @param dim
     */
    public void setDimensioniGriglia(final int dim) {
        this.dimensioniGriglia = dim;
    }
}
