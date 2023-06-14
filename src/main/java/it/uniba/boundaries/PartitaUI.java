package it.uniba.boundaries;

import it.uniba.controllers.FinePartitaController;
import it.uniba.controllers.InizioPartitaController;
import it.uniba.controllers.PartitaInCorsoController;


import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

/**
 * <Boundary>
 * Classe Boundary che gestisce l'interfaccia utente della partita.
 */
public final class PartitaUI {

    private InizioPartitaController ipContr = null;
    private PartitaInCorsoController pcContr = null;
    private FinePartitaController fpContr = null;

    private static final String BLACK = "\u001B[30m";
    private static final String RESET = "\u001B[0m";
    private static final String RED_BC = "\u001B[41m";
    private static final String GREEN_BC = "\u001B[42m";
    private static final String YELLOW_BC = "\u001B[43m";
    private static final String WHITE_BC = "\u001B[47m";


    /**
     * Costruttore che inizializza i controller.
     * @param ip
     * @param pc
     * @param fp
     */
    public PartitaUI(final InizioPartitaController ip,
    final PartitaInCorsoController pc, final FinePartitaController fp) {
        this.ipContr = ip;
        this.pcContr = pc;
        this.fpContr = fp;
    }

    /**
     * Metodo che inizia la partita e stampa la griglia vuota.
     */
    public void inizia() {
        GrigliaUI grigliaUI = new GrigliaUI(this.pcContr);
        this.ipContr.iniziaPartita();
        System.out.println("\n\n" + WHITE_BC + BLACK + ": [ Hai iniziato una nuova partita ]"
        + RESET);
        grigliaUI.displayGrigliaVuota();
    }

    /**
     * Metodo che effettua un tentativo dell'utente e stampa la griglia aggiornata.
     * @param comando
     */
    public void effettuaTentativo(final String[] comando) {

        GrigliaUI grigliaUI = new GrigliaUI(this.pcContr);
        final List<String> lettere = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));
        final int y = lettere.indexOf(comando[0]) + 1;
        final int x = Integer.parseInt(comando[1]);

        PartitaInCorsoController.Esito esito = pcContr.gestisciTentativo(x, y);

        switch (esito) {
            case ACQUA:
                System.out.println("\n" + WHITE_BC + BLACK + ": ACQUA." + RESET);
            break;
            case COLPITO:
                System.out.println("\n" + WHITE_BC + BLACK + ": COLPITO." + RESET);
            break;
            case AFFONDATO:
                System.out.println("\n" + WHITE_BC + BLACK + ": COLPITO E AFFONDATO." + RESET);
            break;
            case GIA_COLPITO:
                System.out.println("\n" + YELLOW_BC + BLACK + ": Hai già colpito questa cella!" + RESET);
            break;
            default:
            break;
        }
        grigliaUI.displayGriglia();
    }

    /**
     * Metodo che mostra la lista aggiornata delle navi presenti nella griglia.
     */
    public void displayNavi() {
        int[] numNavi = this.pcContr.ottieniNumNaviPresenti();
        final int pos0 = 0;
        final int pos1 = 1;
        final int pos2 = 2;
        final int pos3 = 3;

        System.out.println("\n: Ecco la lista delle navi ancora presenti nella griglia:\n"
        + "\n   - Cacciatorpediniere:  [X][X]           Esemplari: " + numNavi[pos0]
        + "\n   - Incrociatore:        [X][X][X]        Esemplari: " + numNavi[pos1]
        + "\n   - Corazzata:           [X][X][X][X]     Esemplari: " + numNavi[pos2]
        + "\n   - Portaerei:           [X][X][X][X][X]  Esemplari: " + numNavi[pos3]
        + "\n");
    }

    /**
     * Metodo che mostra il numero di tentativi effettuati, falliti e massimi.
     */
    public void displayTentativi() {
        int[] tent = this.pcContr.ottieniTentativi();
        System.out.println("\n: Hai effettuato: " + tent[0] + " tentativi."
        + "\n: Hai fallito: " + tent[1] + " tentativi"
        + " su un massimo di " + tent[2] + ".");
    }

    /**
     * Metodo di abbandono della partita.
     * @param tastiera
     * @return true se l'utente conferma l'abbandono, false altrimenti
     */
    public boolean abbandona(final Scanner tastiera) {
        InputUI input = new InputUI();
        boolean conferma = input.acquisisciConferma(tastiera);
        if (conferma) {
            this.fpContr.terminaPartita();
            System.out.println("\n" + WHITE_BC + BLACK + ": PARTITA TERMINATA." + RESET);
        }
        return conferma;
    }

    /**
     * Metodo che verifica se la partita è terminata.
     * @return true se la partita è terminata, false altrimenti
     */
    public boolean isTerminata() {
        if (this.fpContr.isPartitaTerminata()) {
            FinePartitaController.Esito esito = this.fpContr.verificaPartitaTerminata();
            switch (esito) {
                case VITTORIA:
                    System.out.println("\n" + GREEN_BC + ": HAI VINTO!" + RESET);
                break;
                case SCONFITTA:
                    System.out.println("\n" + RED_BC + ": HAI FINITO I TENTATIVI!" + RESET);
                break;
                case TEMPO_SCADUTO:
                    System.out.println("\n" + RED_BC + ": TEMPO SCADUTO!" + RESET);
                break;
                default:
                break;
            }
            this.fpContr.terminaPartita();
            return true;
        } else {
            return false;
        }
    }
}
