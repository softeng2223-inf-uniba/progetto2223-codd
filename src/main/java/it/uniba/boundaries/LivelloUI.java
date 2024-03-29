package it.uniba.boundaries;
import it.uniba.controllers.LivelloController;
import it.uniba.entities.Livello;

/**
 * <Boudary>
 * Classe che gestisce l'impostazione del livello.
 */
public final class LivelloUI {

    private LivelloController livController = null;

    private static final String BLACK = "\u001B[30m";
    private static final String YELLOW_BC = "\u001B[43m";
    private static final String WHITE_BC = "\u001B[47m";
    private static final String RESET = "\u001B[0m";


    /**
     * Costruttore che prende in input un istanza di LivelloController.
     */
    public LivelloUI(final LivelloController livContr) {
        this.livController = livContr;
    }


    /**
     * Metodo che gestisce l'impostazione del livello in base
     * al comando inserito dall'utente.
     * @param comando
     */
    public void impostaLivello(final String[] comando) {

        switch (comando[0]) {
            case "/facile":
                this.livController.impostaLivelloCorrente(Livello.Tipo.FACILE);
            break;
            case "/medio":
                this.livController.impostaLivelloCorrente(Livello.Tipo.MEDIO);
            break;
            case "/difficile":
                this.livController.impostaLivelloCorrente(Livello.Tipo.DIFFICILE);
            break;
            default:
            break;
        }

        System.out.println("\n: Ok.");
    }

    /**
     * Metodo che verifica se un comando è un'impostazione di livello.
     * @param comando
     * @return true se il comando è un'impostazione di livello, false altrimenti.
     */
    public boolean isImpostazioneLivello(final String[] comando) {

        if (comando[1] == null) {
            return true;
        }
        return false;
    }

    /**
     * Metodo che imposta i tentativi associati ad un certo livello.
     * @param comando
     */
    public void impostaTentativiPerLivello(final String[] comando) {

        int tent = Integer.parseInt(comando[1]);
        boolean isTentValido = this.livController.isTentativiValidi(tent);

        if (!isTentValido) {
            System.out.println("\n" + YELLOW_BC + BLACK
            + ": Non puoi impostare un numero di tentativi maggiore della grandezza della griglia!" + RESET);
        } else {
            switch (comando[0]) {
                case "/facile":
                    this.livController.impostaTentativiLivello(Livello.Tipo.FACILE, tent);
                break;
                case "/medio":
                    this.livController.impostaTentativiLivello(Livello.Tipo.MEDIO, tent);
                break;
                case "/difficile":
                    this.livController.impostaTentativiLivello(Livello.Tipo.DIFFICILE, tent);
                break;
                default:
                break;
            }
            System.out.println("\n: Ok.");
        }
    }

    /**
     * Metodo che permette di impostare un numero di tentativi personalizzato.
     * @param comando
     */
    public void impostaTentativiPerLivelloPersonalizzato(final String[] comando) {

        int tent = Integer.parseInt(comando[1]);
        boolean isTentValido = this.livController.isTentativiValidi(tent);

        if (!isTentValido) {
            System.out.println("\n" + YELLOW_BC + BLACK
            + ": Non puoi impostare un numero di tentativi maggiore della grandezza della griglia!" + RESET);
        } else {
            this.livController.impostaTentativiPersonalizzato(tent);
            System.out.println("\n: Ok.");
        }
    }

    /**
     * Metodo che stampa sulla console del terminale il livello impostato
     * e il numero di tentativi associato.
     */
    public void displayLivelloCorrente() {

        System.out.println("\n: Il livello impostato è: " + this.livController.ottieniLivelloCorrente()
        + "\n: Hai a disposizione: " + this.livController.ottieniTentativiCorrenti() + " tentativi.");
    }
}
