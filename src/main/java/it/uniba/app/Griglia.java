package it.uniba.app;

/**
 * Classe che rappresenta il campo da gioco sotto forma di griglia.
 */
public final class Griglia {

    /**
     * Classe interna che rappresenta la singola cella.
     */
    public final class Cella {

        private final int riga = 0;
        private final int colonna = 0;
        private boolean colpita = false;

        /**
         * Costruttore vuoto.
         */
        private Cella() {
            // do nothing
        }

        /**
         * Costruttore che inizializza riga e colonna della cella.
         * @param rigaX
         * @param colonnaY
         */
        public Cella(final int rigaX, final int colonnaY) {
            this.riga = rigaX;
            this.colonna = colonnaY;
        }

    }

    private static final int DIMENSIONE = 10;
    private Cella[][] campo = new Cella[DIMENSIONE][DIMENSIONE];

    /**
     * Costruttore vuoto.
     */
    private Griglia() {
    }

}
