package it.uniba.app;

public final class PartitaUI {

    private InizioPartitaController ipContr = null;
    private PartitaInCorsoController pcContr = null;
    private FinePartitaController fpContr = null;

    public PartitaUI(final InizioPartitaController ip, final PartitaInCorsoController pc, final FinePartitaController fp) {
        this.ipContr = ip;
        this.pcContr = pc;
        this.fpContr = fp;
    }

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

    public boolean abbandona(final Scanner tastiera) {
        InputUI input = new InputUI();
        return input.acquisisciConferma(tastiera);
    }

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
