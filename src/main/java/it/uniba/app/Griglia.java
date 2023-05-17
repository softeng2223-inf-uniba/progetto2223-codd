package it.uniba.app;

/**
 * Classe che rappresenta il campo da gioco sotto forma di griglia.
 */
public final class Griglia {

    /**
     * Classe interna che rappresenta la singola cella.
     */
    public final class Cella {

        private int riga;
        private int colonna;
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
            setRiga(rigaX);
            setColonna(colonnaY);
        }


        /**
         * Setter della riga della cella.
         * @param rigaX
         */
        public void setRiga(final int rigaX) {
            this.riga = rigaX;
        }

        /**
         * Setter della colonna della cella.
         * @param colonnaY
         */
        public void setColonna(final int colonnaY) {
            this.colonna = colonnaY;
        }

        /**
         * Getter della riga della cella.
         * @return riga
         */
        public int getRiga() {
            return riga;
        }

        /**
         * Getter della colonna della cella.
         * @return colonna
         */
        public int getColonna() {
            return colonna;
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
