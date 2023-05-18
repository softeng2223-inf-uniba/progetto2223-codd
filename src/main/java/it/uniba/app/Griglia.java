package it.uniba.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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
    private List<Nave> listaNaviPresenti = inizializzaNavi();

    private Random rand = new Random();

    /**
     * Costruttore che inizializza le celle della griglia e
     * predispone le navi in essa, calcolando randomicamente il loro posizionamento.
     */
    public Griglia() {
        inizializzaCelle();
        predisponiNavi();
    }


    /**
     * Getter della lista di navi presenti nella griglia.
     * @return listaNaviPresenti
     */
    public List<Nave> getListaNaviPresenti() {
        return listaNaviPresenti;
    }

    /**
     * Setter della lista di navi presenti nella griglia.
     * @param listaNavi
     */
    public void setListaNaviPresenti(final List<Nave> listaNavi) {
        this.listaNaviPresenti = listaNavi;
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
     * Metodo che predispone randomicamente le navi nella griglia al momento della sua creazione.
     */
    private void predisponiNavi() {

        boolean posizionata;

        for (Nave naveCorrente : listaNaviPresenti) {

            do {
                posizionata = false;

                int rigaRandom = rand.nextInt(DIMENSIONE);
                int colonnaRandom = rand.nextInt(DIMENSIONE);

                Cella cellaRandom = getCella(rigaRandom, colonnaRandom);

                if (!cellaRandom.isOccupata()) {

                    Direzione[] direzioni = {Direzione.ALTO, Direzione.BASSO, Direzione.SINISTRA, Direzione.DESTRA};
                    List<Direzione> listaDirezioni = Arrays.asList(direzioni);
                    Collections.shuffle(listaDirezioni);

                    for (Direzione direzioneCorrente : listaDirezioni) {

                        if (isNavePosizionabile(naveCorrente, direzioneCorrente, cellaRandom)) {
                            posizionaNave(naveCorrente, direzioneCorrente, cellaRandom);
                            posizionata = true;
                            break;
                        }
                    }
                }
            } while (!posizionata);
        }
    }

    /**
     * Metodo che verifica se la naveCorrente passata è posizionabile
     * a partire dalla cellaIniziale passata, lungo la direzioneCorrente.
     * @param naveCorrente
     * @param direzioneCorrente
     * @param cellaIniziale
     * @return true se la nave è posizionabile, false altrimenti
     */
    private boolean isNavePosizionabile(final Nave naveCorrente,
    final Direzione direzioneCorrente, final Cella cellaIniziale) {

        int lunghezzaNave = naveCorrente.getNumeroCelleOccupate();
        Cella cellaCorrente = cellaIniziale;
        int cont = 1;

        while (cellaCorrente.isSuccessivaDisponibile(direzioneCorrente) && cont < lunghezzaNave) {
            cellaCorrente = cellaCorrente.getCellaSuccessiva(direzioneCorrente);
            cont++;
        }

        return (cont == lunghezzaNave);
    }

    /**
     * Metodo che posiziona la naveCorrente passata nella griglia
     * a partire dalla cellaIniziale passata e lungo la direzioneCorrente.
     * @param naveCorrente
     * @param direzioneCorrente
     * @param cellaIniziale
     */
    private void posizionaNave(final Nave naveCorrente, final Direzione direzioneCorrente, final Cella cellaIniziale) {

        int lunghezzaNave = naveCorrente.getNumeroCelleOccupate();
        List<Cella> listaCelleNave = naveCorrente.getListaCelleOccupate();
        Cella cellaCorrente = cellaIniziale;
        int cont = 0;

        while (cont < lunghezzaNave) {
            cellaCorrente.setNaveOspitata(naveCorrente);
            listaCelleNave.add(cellaCorrente);
            cellaCorrente = cellaCorrente.getCellaSuccessiva(direzioneCorrente);
            cont++;
        }

        naveCorrente.setListaCelleOccupate(listaCelleNave);
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

    /**
     * metodo che mostra la griglia con le navi posizionate.
     */
    public void svelaGriglia() {

        System.out.println("\n+----------------------------------------------+");
        System.out.println("|      | A |" + " B |" + " C |" + " D |" + " E |" + " F |"
        + " G |" + " H |" + " I |" + " J |");

        for (int i = 0; i < DIMENSIONE; i++) {

            System.out.print("+------+---+---+---+---+---+---+---+---+---+---+\n");

            if (i != DIMENSIONE - 1) {
                System.out.print("|  " + (i + 1) + "   ");
            } else {
                System.out.print("|  " + (i + 1) + "  ");
            }

            for (int j = 0; j < DIMENSIONE; j++) {

                if (getCella(i, j).isOccupata()) {
                    System.out.print("| N ");
                } else {
                    System.out.print("| ~ ");
                }

                if (j == DIMENSIONE - 1) {
                        System.out.print("|");
                }
            }
            System.out.println("");
        }
        System.out.println("+------+---+---+---+---+---+---+---+---+---+---+");
    }

    /**
     * Metodo che stampa la griglia vuota.
     */
    public void stampaGrigliaVuota() {

        System.out.println("\n+----------------------------------------------+");
        System.out.println("|      | A |" + " B |" + " C |" + " D |" + " E |" + " F |"
        + " G |" + " H |" + " I |" + " J |");

        for (int i = 0; i < DIMENSIONE; i++) {

            System.out.print("+------+---+---+---+---+---+---+---+---+---+---+\n");
            if (i != DIMENSIONE - 1) {
                System.out.print("|  " + (i + 1) + "   ");
            } else {
                System.out.print("|  " + (i + 1) + "  ");
            }
            for (int j = 0; j < DIMENSIONE; j++) {
                System.out.print("|   ");
                if (j == DIMENSIONE - 1) {
                        System.out.print("|");
                }
            }
            System.out.println("");
        }
        System.out.println("+------+---+---+---+---+---+---+---+---+---+---+");
    }
}

