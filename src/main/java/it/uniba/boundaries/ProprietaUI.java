package it.uniba.boundaries;
import it.uniba.controllers.ProprietaController;

/**
 * <Boundary>
 * Classe che gestisce l'interazione con l'utente per la modifica delle proprietà del gioco.
 */
public final class ProprietaUI {

    private ProprietaController propController = null;

    /**
     * Costruttore di ProprietaUI.
     * @param propContr
     */
    public ProprietaUI(final ProprietaController propContr) {
        this.propController = propContr;
    }

    /**
     * Metodo che imposta le dimensioni della griglia.
     * @param comando
     */
    public void impostaDimensioniGriglia(final String[] comando) {

        switch (comando[0]) {
            case "/standard":
                this.propController.impostaGrigliaStandard();
            break;
            case "/large":
                this.propController.impostaGrigliaLarge();
            break;
            case "/extralarge":
                this.propController.impostaGrigliaExtralarge();
            break;
            default:
            break;
        }
        System.out.println("\n: Ok.");
    }
}
