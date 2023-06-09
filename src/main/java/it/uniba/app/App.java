package it.uniba.app;

import java.util.Scanner;

/**
 * Classe Main dell'applicazione.
 */
public final class App {

    /**
     * Ottiene una stringa di saluto.
     *
     * @return La stringa "Ciao dal gioco della Battaglia Navale!".
     */
    public String getGreeting() {
        return "Ciao dal gioco della Battaglia Navale!";
    }

    /**
     * Metodo main dell'applicazione.
     * @param args Argomenti linea di comando.
     */
    public static void main(final String[] args) {

        ProprietaPartita prop = ProprietaPartita.getIstanza();
        Livello liv = Livello.getIstanza();

        mainEngine(prop, liv);
    }

    /**
     * Metodo che rappresenta il motore del gioco.
     * @param prop
     * @param liv
     */
    private static void mainEngine(final ProprietaPartita prop, final Livello liv) {

        Scanner tastiera = new Scanner(System.in, "utf-8");
        String[] comando = new String[2];
        InputUI input = new InputUI();
        InputUI.StatoGioco contesto = InputUI.StatoGioco.SESSIONE;

        LivelloUI livUI;
        LivelloController livContr;

        while (true) {
            comando = input.acquisisciComando(tastiera, contesto);

            switch (comando[0]) {
                case "/facile":
                case "/medio":
                case "/difficile":
                    livContr = new LivelloController(liv);
                    livUI = new LivelloUI(livContr);
                    if (livUI.isImpostazioneLivello(comando)) {
                        livUI.impostaLivello(comando);
                    } else {
                        livUI.impostaTentativiPerLivello(comando);
                    }
                break;
                case "/tentativi":
                    livContr = new LivelloController(liv);
                    livUI = new LivelloUI(livContr);
                    livUI.impostaTentativiPerLivelloPersonalizzato(comando);
                break;
                case "/mostralivello":
                    livContr = new LivelloController(liv);
                    livUI = new LivelloUI(livContr);
                    livUI.displayLivelloCorrente();
                break;
                case "/esci":
                    if (input.acquisisciConferma(tastiera)) {
                        return;
                    }
                break;
                default:
                break;
            }
        }
    }
}

