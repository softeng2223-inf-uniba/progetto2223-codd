package it.uniba.app;

/**
 * Classe che rappresenta la partita.
 */
public class Partita {

    private int numeroTentativiFalliti = 0;

    /**
     * Enumerativo per rappresentare lo stato della partita.
     */
    public enum StatoPartita {
        IN_CORSO, NON_INIZIATA;
    }

    /**
     * Costruttore vuoto per la classe Partita.
     */
    public Partita() {
        //do nothing
    }

    /**
     * Setter per il numero di tentativi falliti.
     * @param numTentativiFalliti
     */
    public void setNumeroTentativiFalliti(final int numTentativiFalliti) {
        this.numeroTentativiFalliti = numTentativiFalliti;
    }

    /**
     * Getter per il numero di tentativi falliti.
     * @return numeroTentativiFalliti
     */
    public int getNumeroTentativiFalliti() {
        return numeroTentativiFalliti;
    }
}
