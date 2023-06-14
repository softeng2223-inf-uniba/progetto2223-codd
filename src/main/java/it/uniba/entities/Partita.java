package it.uniba.entities;

import it.uniba.controllers.LivelloController;
import it.uniba.controllers.ProprietaController;

/**
 * <Entity>
 * Classe che rappresenta la singola partita.
 */
public final class Partita {

    private Griglia griglia = null;
    private Tempo tempo = null;

    private int tentEffettuati = 0;
    private int tentFalliti = 0;
    private final int maxTent;


    /**
     * Costruttore che inizializza la griglia e il numero massimo di tentativi
     * associati alla partita.
     */
    public Partita() {
        LivelloController livContr = new LivelloController();
        this.maxTent = livContr.ottieniTentativiCorrenti();

        ProprietaController propContr = new ProprietaController();
        final int dim = propContr.ottieniDimGriglia();
        this.griglia = new Griglia(dim);
        this.tempo = new Tempo();
    }

    /**
     * Getter della griglia.
     * @return griglia
     */
    public Griglia getGriglia() {
        return this.griglia;
    }

    /**
     * Getter dei tentativi effettuati.
     * @return tentEffettuati
     */
    public int getTentEffettuati() {
        return this.tentEffettuati;
    }

    /**
     * Setter dei tentativi effettuati.
     * @param tent
     */
    public void setTentEffettuati(final int tent) {
        this.tentEffettuati = tent;
    }

    /**
     * Getter dei tentativi falliti.
     * @return tentFalliti
     */
    public int getTentFalliti() {
        return this.tentFalliti;
    }

    /**
     * Setter dei tentativi falliti.
     * @param tent
     */
    public void setTentFalliti(final int tent) {
        this.tentFalliti = tent;
    }

    /**
     * Getter del numero massimo di tentativi fallibili.
     * @return maxTent
     */
    public int getMaxTent() {
        return this.maxTent;
    }

    /**
     * Getter del tempo della partita.
     * @return tempo
     */
    public Tempo getTempo() {
        return this.tempo;
    }
}
