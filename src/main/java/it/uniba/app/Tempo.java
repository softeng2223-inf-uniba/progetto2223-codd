package it.uniba.app;

import java.lang.Thread;

/**
 * <Entity>
 * Classe che rappresenta il tempo di gioco.
 */
public final class Tempo extends Thread {

    private int minutiTrascorsi = 0;
    private int secondiTrascorsi = 0;
    private int minutiImpostati = 0;

    private boolean isTempoScaduto = false;
    
    private static Tempo istanza = null;

    /**
     * Costruttore privato per implementare il pattern Singleton.
     */
    private Tempo() {
        // Costruttore vuoto
    }

    /**
     * Metodo che restituisce l'istanza della classe Tempo.
     * Implementa il pattern Singleton.
     * @return istanza
     */
    public static Tempo getIstanza() {
        if (istanza == null) {
            istanza = new Tempo();
        }
        return istanza;
    }

    /**
     * Setter dei minuti trascorsi.
     * @param minuti
     */
    public void setMinutiTrascorsi(final int minuti) {
        this.minutiTrascorsi = minuti;
    }

    /**
     * Getter dei minuti trascorsi
     * @return minutiTrascorsi
     */
    public int getMinutiTrascorsi() {
        return this.minutiTrascorsi;
    }

    /**
     * Setter dei secondi trascorsi.
     * @param secondi
     */
    public void setSecondiTrascorsi(final int secondi) {
        this.secondiTrascorsi = secondi;
    }

    /**
     * Getter dei secondi trascorsi.
     * @return secondiTrascorsi
     */
    public int getSecondiTrascorsi() {
        return this.secondiTrascorsi;
    }

    /**
     * Setter dei minuti impostati.
     * @param minuti
     */
    public void setMinutiImpostati(final int minuti) {
        this.minutiImpostati = minuti;
    }

    /**
     * Getter dei minuti impostati.
     * @return minutiImpostati
     */
    public int getMinutiImpostati() {
        return this.minutiImpostati;
    }

    /**
     * Getter della variabile booleana isTemposcaduto.
     * @return isTempoScaduto
     */
    public boolean isTempoScaduto() {
        return this.isTempoScaduto;
    }

    /**
     * Metodo che resetta il tempo.
     */
    public void reset() {
        this.minutiTrascorsi = 0;
        this.secondiTrascorsi = 0;
        this.isTempoScaduto = false;
    }

    /**
     * Metodo che avvia il thread.
     */
    @Override
    public void run() {
        while (!isTempoScaduto) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.secondiTrascorsi == 59) {
                this.secondiTrascorsi = 0;
                this.minutiTrascorsi++;
            } else {
                this.secondiTrascorsi++;
            }
            if (this.minutiTrascorsi == this.minutiImpostati) {
                isTempoScaduto = true;
            }
        }
    }
}
