package it.uniba.app;

import com.mycompany.battaglianavale.Griglia;

/**
 * Classe che rappresenta la partita.
 */
public final class Partita {

    private int numeroTentativiFalliti = 0;
    private Livello livello;
    private Griglia griglia;

    /**
     * Enumerativo per rappresentare lo stato della partita.
     */
    public enum StatoPartita {
        IN_CORSO, NON_INIZIATA;
    }

    /**
     * Costruttore vuoto per la classe Partita.
     */
    private Partita() {
        //do nothing
    }

    /**
     * Costruttore che imposta una nuova griglia e il livello della partita da iniziare.
     * @param livelloCorrente livello al quale impostare la partita.
     */
    public Partita(final Livello livelloCorrente) {
        this.griglia = new Griglia();
        setLivello(livelloCorrente);
    }

    /**
     * Setter per il numero di tentativi falliti.
     * @param numTentativiFalliti
     */
    public void setNumeroTentativiFalliti(final int numTentativiFalliti) {
        this.numeroTentativiFalliti = numTentativiFalliti;
    }

    /**
     * Setter del livello relativo alla partita.
     * @param livelloCorrente
     */
    public void setLivello(final Livello livelloCorrente) {
        this.livello = livelloCorrente;
    }

    /**
     * Getter del livello relativo alla partita.
     * @return livello
     */
    public Livello getLivello() {
        return livello;
    }

    /**
     * Getter per il numero di tentativi falliti.
     * @return numeroTentativiFalliti
     */
    public int getNumeroTentativiFalliti() {
        return numeroTentativiFalliti;
    }

    /**
     * Metodo che permette di giocare la partita.
     */
    public void gioca() {

        System.out.println("\nHai iniziato una nuova partita!\n\n(In partita...)\n");

        do {
            String comando = Input.acquisisci(StatoPartita.IN_CORSO);

            switch (comando) {
                case "/esci":
                    if (Input.acquisisciConferma()) {
                        System.exit(0);
                    }
                break;

                case "/svelagriglia":

                break;

                case "/mostranavi":

                break;

                case "/mostralivello":
                    System.out.println("\nIl livello impostato è " + LivelloSessione.getCorrente()
                    + ". Puoi fallire un massimo di "
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

