package it.uniba.app;

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
     * Metodo che imposta i minuti trascorsi e setta il tempo come impostato.
     * @param minuti
     */
    public void impostaTempo(final int minuti) {
        this.tempo.setMinutiImpostati(minuti);
        this.tempo.setImpostato(true);
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
        int[] temp = new int[2];
        final int diff = this.tempo.getMinutiImpostati() - this.tempo.getMinutiTrascorsi();
        temp[0] = this.tempo.getMinutiImpostati() - this.tempo.getMinutiTrascorsi() - diff;
        temp[1] = SECONDI - this.tempo.getSecondiTrascorsi();
        return temp;
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

    /**
     * Metodo che reimposta il tempo.
     */
    public void reimpostaTempo() {
        this.tempo.setMinutiImpostati(0);
        this.tempo.setScaduto(false);
        this.tempo.setImpostato(false);
    }

    /**
     * Metodo che verifica se il tempo è stato impostato.
     * @return true se il tempo è stato impostato, false altrimenti
     */
    public boolean isTempoImpostato() {
        return this.tempo.isImpostato();
    }

    /**
     * Metodo che avvisa se il tempo è scaduto.
     * @return true se il tempo è scaduto, false altrimenti.
     */
    public boolean isTempoScaduto() {
        return this.tempo.isScaduto();
    }
}
