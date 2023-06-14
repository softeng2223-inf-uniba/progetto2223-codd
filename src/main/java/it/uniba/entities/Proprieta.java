package it.uniba.entities;

/**
 * <Entity>
 * Classe che rappresenta le proprietà generali della successiva
 * partita da giocare.
 */
public final class Proprieta {

    private static final int DIMENSIONI_GRIGLIA_DEFAULT = 10;
    private int dimensioniGriglia = DIMENSIONI_GRIGLIA_DEFAULT;
    private int minutiImpostati = 0;
    private boolean tempoImpostato = false;

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

    /**
     * Getter della variabile booleana tempoImpostato.
     * @return tempoImpostato
     */
    public boolean isTempoImpostato() {
        return this.tempoImpostato;
    }

    /**
     * Setter della variabile booleana tempoImpostato.
     * @param isImpostato
     */
    public void setTempoImpostato(final boolean isImpostato) {
        this.tempoImpostato = isImpostato;
    }

    /**
     * Setter dei minuti impostati.
     * @param minuti
     */
    public void setMinutiImpostati(final int minuti) {
        this.minutiImpostati = minuti;
    }

    /**
     * Getter dei minuti impostati.
     * @return minutiImpostati
     */
    public int getMinutiImpostati() {
        return this.minutiImpostati;
    }
}
