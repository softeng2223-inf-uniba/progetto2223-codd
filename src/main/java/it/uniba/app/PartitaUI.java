package it.uniba.app;

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
        System.out.println("\n: Hai iniziato una nuova partita.\n");
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
                System.out.println("\n: ACQUA.");
            break;
            case COLPITO:
                System.out.println("\n: COLPITO.");
            break;
            case AFFONDATO:
                System.out.println("\n: COLPITO E AFFONDATO.");
            break;
            case GIA_COLPITO:
                System.out.println("\n: Hai già colpito questa cella!");
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

        System.out.println("\n: Ecco la lista delle navi ancora presenti nella griglia:"
        + "\n   - Cacciatorpediniere:\t\t[X][X]\t\tEsemplari: " + numNavi[0]
        + "\n   - Incrociatore:\t\t[X][X][X]\t\tEsemplari: " + numNavi[1]
        + "\n   - Corazzata:\t\t[X][X][X][X]\t\tEsemplari: " + numNavi[2]
        + "\n   - Portaerei:\t\t[X][X][X][X][X]\t\tEsemplari: " + numNavi[3]
        + "\n");
    }

    /**
     * Metodo di abbandono della partita.
     * @param tastiera
     * @return true se l'utente conferma l'abbandono, false altrimenti
     */
    public boolean abbandona(final Scanner tastiera) {
        InputUI input = new InputUI();
        return input.acquisisciConferma(tastiera);
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
                    System.out.println("\n: HAI VINTO!");
                break;
                case SCONFITTA:
                    System.out.println("\n: HAI FINITO I TENTATIVI!");
                break;
                case TEMPO_SCADUTO:
                    System.out.println("\n: TEMPO SCADUTO!");
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
