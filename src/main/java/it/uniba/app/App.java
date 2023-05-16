package it.uniba.app;

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

        if (args.length != 0) {
            if (args[0].equals("--help") || args[0].equals("-h")) {
                Output.stampaHelp();
                System.exit(0);
            }
        }
        Output.stampaInizioGioco();

        do {
            String comando = Input.acquisisci(Partita.StatoPartita.NON_INIZIATA);

            switch (comando) {
                case "/gioca":

                break;

                case "/esci":
                if (Input.acquisisciConferma()) {
                    System.exit(0);
                }
                break;

                case "/facile":
                    LivelloSessione.setCorrente(Livello.FACILE);
                    System.out.println("\nOK.");
                break;

                case "/medio":
                    LivelloSessione.setCorrente(Livello.MEDIO);
                    System.out.println("\nOK.");
                break;

                case "/difficile":
                    LivelloSessione.setCorrente(Livello.DIFFICILE);
                    System.out.println("\nOK.");
                break;

                case "/mostralivello":
                    System.out.println("\nIl livello impostato è " + LivelloSessione.getCorrente()
                    + ".\nPuoi fallire un massimo di "
                    + LivelloSessione.getCorrente().getMaxTentativi() + " tentativi.");
                break;

                case "/help":
                    Output.stampaHelp();
                break;

                default:
                break;
            }

        } while (true);
    }

}
