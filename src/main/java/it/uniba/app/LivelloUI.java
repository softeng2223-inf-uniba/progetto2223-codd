package it.uniba.app;

/**
 * <Boudary>
 * Classe che gestisce l'impostazione del livello.
 */
public final class LivelloUI {

    private LivelloController livController = null;


    /**
     * Costruttore che prende in input un istanza di LivelloController.
     */
    public LivelloUI(final LivelloController livContr) {
        this.livController = livContr;
    }


    /**
     * Metodo che gestisce l'impostazione del livello in base
     * al comando inserito dall'utente.
     *
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

        Proprieta prop = Proprieta.getIstanza();
        int tent = Integer.parseInt(comando[1]);
        int dim = prop.getDimensioniGriglia() * prop.getDimensioniGriglia();

        if (tent > dim) {
            System.out.println("\n: Non puoi impostare un numero di tentativi maggiore della grandezza della griglia!");
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
        }
    }

    /**
     * Metodo che permette di impostare un numero di tentativi personalizzato.
     * @param comando
     */
    public void impostaTentativiPerLivelloPersonalizzato(final String[] comando) {

        Proprieta prop = Proprieta.getIstanza();
        int tent = Integer.parseInt(comando[1]);
        int dim = prop.getDimensioniGriglia() * prop.getDimensioniGriglia();

        if (tent > dim) {
            System.out.println("\n: Non puoi impostare un numero di tentativi maggiore della grandezza della griglia!");
        } else {
            this.livController.impostaTentativiPersonalizzato(tent);
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
