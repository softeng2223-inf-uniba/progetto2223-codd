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

        System.out.println("Ok.");
    }

    public boolean isImpostazioneLivello(final String[] comando) {

        if (comando[1] == null) {
            return true;
        }
        return false;
    }

    public void impostaTentativiLivello(final String[] comando) {

    }
}
