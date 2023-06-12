package it.uniba.app;

/**
 * <Entity>
 * Classe che rappresenta la singola partita.
 */
public final class Partita {

    private Griglia griglia = null;

    private int tentEffettuati = 0;
    private int tentFalliti = 0;
    private final int maxTent;


    /**
     * Costruttore che inizializza la griglia e il numero massimo di tentativi
     * associati alla partita.
     */
    public Partita() {
        LivelloController livContr = new LivelloController(Livello.getIstanza());
        this.maxTent = livContr.ottieniTentativiCorrenti();

        Proprieta prop = Proprieta.getIstanza();
        int dim = prop.getDimensioniGriglia();
        this.griglia = new Griglia(dim);
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

}
