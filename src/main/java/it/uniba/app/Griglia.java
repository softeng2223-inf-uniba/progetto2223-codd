package it.uniba.app;

import java.util.ArrayList;
import java.util.List;

/**
 * <Entity>
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
        }

        /**
         * Costruttore che inizializza riga e colonna della cella.
         * @param x
         * @param y
         */
        public Cella(final int x, final int y) {
            this.riga = x;
            this.colonna = y;
        }

        /**
         * Getter della variabile booleana colpita.
         * @return colpita
         */
        public boolean isColpita() {
            return this.colpita;
        }

        /**
         * Setter della variabile booleana colpita.
         * @param colp
         */
        public void setColpita(final boolean colp) {
            this.colpita = colp;
        }

        /**
         * Metodo che controlla se la cella è occupata da una nave.
         * @return true se la cella è occupata, false altrimenti.
         */
        public boolean isOccupata() {
            return (naveOspitata != null);
        }


        /**
         * Metodo che controlla se la cella successiva è disponibile
         * ad ospitare una nave.
         * @param direzione in cui si vuole controllare
         * @return true se la cella è disponibile, false altrimenti.
         */
        public boolean isSuccDisponibile(final Direzione direzione) {

            Cella cellaSucc = getCellaSucc(direzione);
            if (cellaSucc == null) {
                return false;
            }
            return !cellaSucc.isOccupata();
        }

        /**
         * Metodo che restituisce la cella successiva.
         * @param direzione della cella che si vuole ottenere
         * @return cellaSucc
         */
        public Cella getCellaSucc(final Direzione direzione) {

            Cella cellaSucc = null;

            switch (direzione) {
                case ALTO:
                    cellaSucc = Griglia.this.getCella(riga - 1, colonna);
                break;
                case BASSO:
                    cellaSucc = Griglia.this.getCella(riga + 1, colonna);
                break;
                case SINISTRA:
                    cellaSucc = Griglia.this.getCella(riga, colonna - 1);
                break;
                case DESTRA:
                    cellaSucc = Griglia.this.getCella(riga, colonna + 1);
                break;
                default:
                break;
            }
            return cellaSucc;
        }

    }

    /**
     * Enumerativo che rappresenta le direzioni in cui posizionare le navi.
     */
    public enum Direzione {
        ALTO, BASSO, SINISTRA, DESTRA;
    }

    private int dimensione;
    private Cella[][] campo;
    private List<Nave> listaNaviPresenti = inizializzaNavi();


    /**
     * Costruttore che inizializza le celle della griglia.
     * @param dim
     */
    public Griglia(final int dim) {
        this.dimensione = dim;
        this.campo = inizializzaCelle();
    }


    /**
     * Metodo che restituisce la cella corrispondente alle coordinate passate.
     * @param x
     * @param y
     * @return campo[x - 1][y - 1]
     */
    public Cella getCella(final int x, final int y) {
        if (!esisteCella(x, y)) {
            return null;
        }
        return campo[x - 1][y - 1];
    }

    /**
     * Metodo che verifica l'esistenza di una cella
     * in relazione alle coordinate passate.
     * @param x
     * @param y
     * @return true se la cella esiste, false altrimenti
     */
    private boolean esisteCella(final int x, final int y) {
        final int dim = this.dimensione;
        return ((x > 0 && x <= dim) && (y > 0 && y <= dim));
    }


    /**
     * Metodo che inizializza le celle, impostando
     * i corrispondenti valori di riga e colonna.
     * @return campo
     */
    private Cella[][] inizializzaCelle() {

        final int dim = this.dimensione;
        Cella[][] campo = new Cella[dim][dim];

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                campo[i][j] = new Cella(i + 1, j + 1);
            }
        }
        return campo;
    }

    /**
     * Metodo che inizializza la lista delle navi presenti inizialmente nella griglia.
     * @return listaNavi
     */
    private List<Nave> inizializzaNavi() {

        List<Nave> listaNavi = new ArrayList<>();

        for (int i = 0; i < Portaerei.getNumeroEsemplari(); i++) {
            listaNavi.add(new Portaerei());
        }
        for (int i = 0; i < Corazzata.getNumeroEsemplari(); i++) {
            listaNavi.add(new Corazzata());
        }
        for (int i = 0; i < Incrociatore.getNumeroEsemplari(); i++) {
            listaNavi.add(new Incrociatore());
        }
        for (int i = 0; i < Cacciatorpediniere.getNumeroEsemplari(); i++) {
            listaNavi.add(new Cacciatorpediniere());
        }
        return listaNavi;
    }
}

