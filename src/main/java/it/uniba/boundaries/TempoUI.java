package it.uniba.boundaries;

import it.uniba.controllers.TempoController;


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
     * Metodo che mostra il tempo trascorso e quello rimanente.
     */
    public void displayTempo() {
        if (this.tempController.isTempoImpostato()) {
            int[] temp = this.tempController.ottieniTempoTrascorso();
            System.out.println("\n: Sono trascorsi: " + temp[0] + " minuti : " + temp[1] + " secondi.");
            temp = this.tempController.ottieniTempoRestante();
            System.out.println("\n: Ti rimangono a disposizione: " + temp[0] + " minuti : " + temp[1] + " secondi.");
        } else {
            System.out.println("\n: Non hai impostato alcun tempo di gioco.");
        }
    }
}
