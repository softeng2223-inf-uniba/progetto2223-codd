package it.uniba.controllers;

import it.uniba.entities.Tempo;

/**
 * <Control>
 * Classe Control che gestisce il tempo di gioco.
 */
public final class TempoController {

    private Tempo tempo = null;

    private static final int SECONDI = 60;

    /**
     * Costruttore della classe TempoController.
     * @param temp
     */
    public TempoController(final Tempo temp) {
        this.tempo = temp;
    }

    /**
     * Metodo che imposta i minuti.
     */
    public void impostaMinuti(final int minuti) {
        this.tempo.setMinutiImpostati(minuti);
    }

    /**
     * Metodo che restituisce il tempo trascorso.
     * @return temp
     */
    public int[] ottieniTempoTrascorso() {
        int[] temp = new int[2];
        temp[0] = this.tempo.getMinutiTrascorsi();
        temp[1] = this.tempo.getSecondiTrascorsi();
        return temp;
    }

    /**
     * Metodo che restituisce il tempo rimanente.
     * @return temp
     */
    public int[] ottieniTempoRestante() {
        int tempoImpostato = (this.tempo.getMinutiImpostati() * SECONDI);
        int tempoTrascorso = (this.tempo.getMinutiTrascorsi() * SECONDI) + this.tempo.getSecondiTrascorsi();
        int differenza = tempoImpostato - tempoTrascorso;
        return new int[] {differenza / SECONDI, differenza % SECONDI};
    }

    /**
     * Metodo che verifica se il tempo è scaduto.
     * @return scaduto
     */
    public boolean isTempoScaduto() {
        return this.tempo.isScaduto();
    }

    /**
     * Metodo che avvia il tempo.
     */
    public void avviaTempo() {
        try {
            this.tempo.start();
        } catch (IllegalThreadStateException e) {
            System.out.println("Tempo già avviato.");
        }
    }

}
