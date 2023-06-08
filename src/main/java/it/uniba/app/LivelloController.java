package it.uniba.app;


/**
 * <Control>
 * Classe che gestisce gli interventi sulla difficoltà del gioco.
 */
public final class LivelloController {

    private Livello livello = null;


    /**
     * Costruttore che inizializza la variabile livello.
     *
     * @param liv
     */
    public LivelloController(final Livello liv) {
        this.livello = liv;
    }


    /**
     * Metodo che imposta il livello passato come corrente e aggiorna contestualmente
     * anche il numero dei tentativi associato.
     *
     * @param liv
     */
    public void impostaLivelloCorrente(final Livello.Tipo liv) {

        this.livello.setLivCorrente(liv);

        switch (liv) {
            case FACILE:
                this.livello.setTentCorrenti(this.livello.getTentFacile());
            break;
            case MEDIO:
                this.livello.setTentCorrenti(this.livello.getTentMedio());
            break;
            case DIFFICILE:
                this.livello.setTentCorrenti(this.livello.getTentDifficile());
            break;
            default:
            break;
        }
    }

    /**
     * Metodo che, dato un livello e un numero di tentativi, associa questi ultimi
     * al come numero di tentativi di default del primo.
     *
     * @param liv
     * @param tent
     */
    public void impostaTentativiLivello(final Livello.Tipo liv, final int tent) {

        switch (liv) {
            case FACILE:
                this.livello.setTentFacile(tent);
            break;
            case MEDIO:
                this.livello.setTentMedio(tent);
            break;
            case DIFFICILE:
                this.livello.setTentDifficile(tent);
            break;
            default:
            break;
        }
    }

    /**
     * Metodo che imposta il livello a PERSONALIZZATO, e contestualmente
     * imposta il numero massimo di tentativi corrente.
     *
     * @param tent
     */
    public void impostaTentativiPersonalizzato(final int tent) {

        this.livello.setLivCorrente(Livello.Tipo.PERSONALIZZATO);
        this.livello.setTentCorrenti(tent);
    }

    /**
     * Metodo che ottiene il livello correntemente impostato.
     *
     * @return livello impostato.
     */
    public Livello.Tipo ottieniLivelloCorrente() {

        return this.livello.getLivCorrente();
    }

    /**
     * Metodo che ottiene il numero di tentativi impostato.
     *
     * @return numero di tentativi.
     */
    public int ottieniTentativiCorrenti() {

        return this.livello.getTentCorrenti();
    }
}
