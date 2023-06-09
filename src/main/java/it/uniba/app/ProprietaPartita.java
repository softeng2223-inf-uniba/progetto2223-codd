package it.uniba.app;

/**
 * <Entity>
 * Classe che rappresenta le proprietà generali della successiva
 * partita da giocare.
 */
public final class ProprietaPartita {

    private Tempo tempo = null;
    private Livello livello = null;
    private static final DIMENSIONI_GRIGLIA_DEFAULT = 10;
    private int dimensioniGriglia = DIMENSIONI_GRIGLIA_DEFAULT;

    private static ProprietaPartita istanza = null;

    /**
     * Costruttore privato della classe ProprietaPartita.
     */
    private ProprietaPartita() {
        this.livello = Livello.getIstanza();
    }


    /**
     * Metodo statico che restituisce l'unica istanza di ProprietaPartita,
     * implementando il pattern Singleton.
     * @return istanza
     */
    public static ProprietaPartita getIstanza() {

        if (istanza == null) {
            istanza = new ProprietaPartita();
        }
        return istanza;
    }
}
