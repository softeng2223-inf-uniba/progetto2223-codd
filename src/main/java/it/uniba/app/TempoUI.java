package it.uniba.app;

/**
 * <Boundary>
 * Classe che gestisce l'interfaccia utente per il tempo di gioco.
 */
public final class TempoUI {

    private TempoController tempController = null;

    /**
     * Costruttore della classe TempoUI.
     * @param tempContr
     */
    public TempoUI(final TempoController tempContr) {
        this.tempController = tempContr;
    }

    /**
     * Metodo che imposta il tempo massimo di gioco.
     * @param comando
     */
    public void impostaTempoDiGioco(final String[] comando) {
        int minuti = Integer.parseInt(comando[1]);
        this.tempController.impostaTempo(minuti);
        System.out.println("\n: Ok.");
    }

    /**
     * Metodo che mostra il tempo trascorso e quello rimanente.
     */
    public void displayTempo() {
        int[] temp = this.tempController.ottieniTempoTrascorso();
        System.out.println("\n: Sono trascorsi: " + temp[0] + " minuti : " + temp[1] + " secondi.");
        temp = this.tempController.ottieniTempoRestante();
        System.out.println("\n: Ti rimangono a disposizione: " + temp[0] + " minuti : " + temp[1] + " secondi.");
    }
}
