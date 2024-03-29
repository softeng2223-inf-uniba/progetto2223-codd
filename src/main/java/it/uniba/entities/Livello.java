package it.uniba.entities;


/**
 * <Entity>
 * Classe che rappresenta il livello di difficoltà del gioco.
 */
public final class Livello {

    private static final int TENT_INIZIALE_FACILE = 50;
    private static final int TENT_INIZIALE_MEDIO = 30;
    private static final int TENT_INIZIALE_DIFFICILE = 10;


    /**
     * Enumerativo che rappresenta i diversi livelli di difficoltà impostabili.
     */
    public enum Tipo {
        FACILE, MEDIO, DIFFICILE, PERSONALIZZATO;
    }


    private int tentFacile = TENT_INIZIALE_FACILE;
    private int tentMedio = TENT_INIZIALE_MEDIO;
    private int tentDifficile = TENT_INIZIALE_DIFFICILE;
    private int tentPersonalizzati = 0;

    private Tipo livCorrente = Tipo.FACILE;

    private static Livello istanza = null;


    /**
     * Costruttore vuoto.
     */
    private Livello() {
    }

    /**
     * Metodo che restituisce l'unica istanza di Livello, implementando il pattern Singleton.
     * @return istanza
     */
    public static Livello getIstanza() {
        if (istanza == null) {
            istanza = new Livello();
        }
        return istanza;
    }


    /**
     * Getter dei tentativi associati al livello FACILE.
     * @return tentFacile
     */
    public int getTentFacile() {
        return this.tentFacile;
    }

    /**
     * Getter dei tentativi associati al livello MEDIO.
     * @return tentMedio
     */
    public int getTentMedio() {
        return this.tentMedio;
    }

    /**
     * Getter dei tentativi associati al livello DIFFICILE.
     * @return tentDifficile
     */
    public int getTentDifficile() {
        return this.tentDifficile;
    }

    /**
     * Getter dei tentativi associati al livello PERSONALIZZATO.
     * @return tentPersonalizzati
     */
    public int getTentPersonalizzati() {
        return this.tentPersonalizzati;
    }

    /**
     * Getter del livello correntemente impostato.
     * @return livCorrente
     */
    public Tipo getLivCorrente() {
        return this.livCorrente;
    }


    /**
     * Setter dei tentativi associati al livello FACILE.
     * @param tent
     */
    public void setTentFacile(final int tent) {
        this.tentFacile = tent;
    }

    /**
     * Setter dei tentativi associati al livello MEDIO.
     * @param tent
     */
    public void setTentMedio(final int tent) {
        this.tentMedio = tent;
    }

    /**
     * Setter dei tentativi associati al livello DIFFICILE.
     * @param tent
     */
    public void setTentDifficile(final int tent) {
        this.tentDifficile = tent;
    }

    /**
     * Setter dei tentativi associati al livello PERSONALIZZATO.
     * @param tent
     */
    public void setTentPersonalizzati(final int tent) {
        this.tentPersonalizzati = tent;
    }

    /**
     * Setter del livello corrente.
     * @param liv
     */
    public void setLivCorrente(final Tipo liv) {
        this.livCorrente = liv;
    }

}
