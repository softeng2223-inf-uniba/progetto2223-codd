package it.uniba.controllers;
import it.uniba.entities.Livello;
import it.uniba.entities.Proprieta;


/**
 * <Control>
 * Classe che gestisce gli interventi sulla difficoltà del gioco.
 */
public final class LivelloController {

    private Livello livello = null;


    /**
     * Costruttore che inizializza la variabile livello.
     * @param liv
     */
    public LivelloController(final Livello liv) {
        this.livello = liv;
    }


    /**
     * Metodo che imposta il livello passato come corrente.
     * @param liv
     */
    public void impostaLivelloCorrente(final Livello.Tipo liv) {

        this.livello.setLivCorrente(liv);
    }

    /**
     * Metodo che, dato un livello e un numero di tentativi, associa questi ultimi
     * al come numero di tentativi di default del primo.
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
     * imposta il numero di tentativi ad esso associato.
     * @param tent
     */
    public void impostaTentativiPersonalizzato(final int tent) {

        this.livello.setLivCorrente(Livello.Tipo.PERSONALIZZATO);
        this.livello.setTentPersonalizzati(tent);
    }

    /**
     * Metodo che ottiene il livello correntemente impostato.
     * @return livello impostato
     */
    public Livello.Tipo ottieniLivelloCorrente() {

        return this.livello.getLivCorrente();
    }

    /**
     * Metodo che ottiene il numero di tentativi impostato
     * a seconda del livello corrente.
     * @return tent
     */
    public int ottieniTentativiCorrenti() {

        final Livello.Tipo liv = this.livello.getLivCorrente();
        int tent = 0;

        switch (liv) {
            case FACILE:
                tent = this.livello.getTentFacile();
            break;
            case MEDIO:
                tent = this.livello.getTentMedio();
            break;
            case DIFFICILE:
                tent = this.livello.getTentDifficile();
            break;
            case PERSONALIZZATO:
                tent = this.livello.getTentPersonalizzati();
            break;
            default:
            break;
        }
        return tent;
    }

    /**
     * Metodo booleano che verifica se il numero di tentativi inserito
     * sia valido o meno.
     * @param tent
     * @return true se il numero di tentativi è valido, false altrimenti.
     */
    public boolean isTentativiValidi(final int tent) {
        ProprietaController propContr = new ProprietaController(Proprieta.getIstanza());
        int dim = propContr.ottieniDimGriglia();
        dim *= dim;

        if (tent > dim) {
            return false;
        }
        return true;
    }
}
