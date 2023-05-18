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
        private Nave naveOspitata;

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

        /**
         * Getter della nave ospitata nella cella.
         * @return naveOspitata
         */
        public Nave getNaveOspitata() {
            return naveOspitata;
        }

        /**
         * Setter della nave ospitata nella cella.
         * @param nave
         */
        public void setNaveOspitata(final Nave nave) {
            this.naveOspitata = nave;
        }

        /**
         * Getter della variabile booleana colpita.
         * @return colpita
         */
        public boolean isColpita() {
            return colpita;
        }

        /**
         * Setter della variabile booleana colpita.
         * @param isColpita
         */
        public void setColpita(final boolean isColpita) {
            this.colpita = isColpita;
        }

        /**
         * Metodo che controlla se la cella è occupata da una nave.
         * @return true se la cella è occupata, false altrimenti
         */
        public boolean isOccupata() {
            return (naveOspitata != null);
        }

        /**
         * Metodo che controlla se la cella successiva è disponibile
         * ad ospitare una nave.
         * @param direzione in cui si vuole controllare
         * @return true se la cella è disponibile, false altrimenti
         */
        public boolean isSuccessivaDisponibile(final Direzione direzione) {

            Cella cellaSuccessiva = getCellaSuccessiva(direzione);

            if (cellaSuccessiva == null) {
                return false;
            } else {
                return !cellaSuccessiva.isOccupata();
            }
        }

        /**
         * Metodo che restituisce la cella successiva.
         * @param direzione della cella che si vuole ottenere
         * @return cellaSuccessiva
         */
        public Cella getCellaSuccessiva(final Direzione direzione) {

            Cella cellaSuccessiva = null;

            switch (direzione) {
                case ALTO:
                    cellaSuccessiva = Griglia.this.getCella(riga - 1, colonna);
                break;
                case BASSO:
                    cellaSuccessiva = Griglia.this.getCella(riga + 1, colonna);
                break;
                case SINISTRA:
                    cellaSuccessiva = Griglia.this.getCella(riga, colonna - 1);
                break;
                case DESTRA:
                    cellaSuccessiva = Griglia.this.getCella(riga, colonna + 1);
                break;
                default:
                break;
            }

            return cellaSuccessiva;
        }

    }

    /**
     * Enumerazione che rappresenta le direzioni in cui posizionare le navi.
     */
    public enum Direzione {
        ALTO, BASSO, SINISTRA, DESTRA;
    }

    private static final int DIMENSIONE = 10;
    private Cella[][] campo = new Cella[DIMENSIONE][DIMENSIONE];

    /**
     * Costruttore vuoto.
     */
    private Griglia() {
    }

    /**
     * Metodo che restituisce la cella corrispondente alle coordinate passate.
     * @param rigaX
     * @param colonnaY
     * @return campo[rigaX][colonnaY]
     */
    public Cella getCella(final int rigaX, final int colonnaY) {
        if (!esisteCella(rigaX, colonnaY)) {
            return null;
        } else {
            return campo[rigaX][colonnaY];
        }
    }

    /**
     * Metodo che verifica l'esistenza di una cella
     * in relazione alle coordinate passate.
     * @param rigaX
     * @param colonnaY
     * @return true se la cella esiste, false altrimenti
     */
    private boolean esisteCella(final int rigaX, final int colonnaY) {
        return ((rigaX >= 0 && rigaX < DIMENSIONE) && (colonnaY >= 0 && colonnaY < DIMENSIONE));
    }

    /**
     * Metodo che mostra le navi presenti nel gioco con relativa lunghezza e numero esemplari.
     */
    public void mostraNavi() {

        System.out.println("\nEcco la lista delle navi presenti:");

        System.out.println(new Cacciatorpediniere());
        System.out.println(new Incrociatore());
        System.out.println(new Corazzata());
        System.out.println(new Portaerei());
    }

}

