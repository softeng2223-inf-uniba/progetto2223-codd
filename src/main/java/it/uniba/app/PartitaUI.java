package it.uniba.app;

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
    public PartitaUI(final InizioPartitaController ip, final PartitaInCorsoController pc, final FinePartitaController fp) {
        this.ipContr = ip;
        this.pcContr = pc;
        this.fpContr = fp;
    }

    /**
     * Metodo che inizializza la partita.
     */
    public void inizializza() {
        this.ipContr.disponiNavi();
        this.ipContr.avviaTempoDiGioco();
    }

    /**
     * Metodo che effettua un tentativo dell'utente.
     * @param comando
     */
    public void effettuaTentativo(final String[] comando) {

        final List<String> lettere = "abcdefghijklmnopqrstuvwxyz".split("");
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
            return true;
        } else {
            return false;
        }
    }
}
