package it.uniba.app;

/**
 * Classe che rappresenta il campo da gioco sotto forma di griglia.
 */
public final class Griglia {

    /**
     * Classe interna che rappresenta la singola cella.
     */
    public final class Cella {

        private final int riga;
        private final int colonna;
        private boolean colpita = false;

        /**
         * Costruttore vuoto.
         */
        private Cella() {
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


}
