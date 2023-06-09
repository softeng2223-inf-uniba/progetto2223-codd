package it.uniba.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
            // do nothing
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
    private List<Nave> listaNaviPresenti = inizializzaNavi();

    private Random rand = new Random();

    /**
     * Costruttore che inizializza le celle della griglia e
     * predispone le navi in essa, calcolando randomicamente il loro posizionamento.
     */
    public Griglia() {
        inizializzaCelle();
    }


    /**
     * Metodo che restituisce la cella corrispondente alle coordinate passate.
     * @param x
     * @param y
     * @return campo[x][y]
     */
    public Cella getCella(final int x, final int y) {
        if (!esisteCella(x, y)) {
            return null;
        } else {
            return campo[x][y];
        }
    }

    /**
     * Metodo che verifica l'esistenza di una cella
     * in relazione alle coordinate passate.
     * @param x
     * @param y
     * @return true se la cella esiste, false altrimenti
     */
    private boolean esisteCella(final int x, final int y) {
        return ((x >= 0 && x < DIMENSIONE) && (y >= 0 && y < DIMENSIONE));
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

    /**
     * Metodo che inizializza le celle, impostando
     * i corrispondenti valori di riga e colonna.
     */
    private void inizializzaCelle() {

        for (int i = 0; i < DIMENSIONE; i++) {
            for (int j = 0; j < DIMENSIONE; j++) {
                campo[i][j] = new Cella(i, j);
            }
        }
    }

}

