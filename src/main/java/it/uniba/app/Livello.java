package it.uniba.app;

/**
 * Enumerativo complesso, con livelli di difficoltà e
 * massimo numero di tentativi.
 */
public enum Livello {

    /**
     * Imposto maxTentativi a 50 per il livello FACILE.
     */
    FACILE(50),
    /**
     * Imposto maxTentativi a 30 per il livello MEDIO.
     */
    MEDIO(30),
    /**
     * Imposto maxTentativi a 10 per il livello DIFFICILE.
     */
    DIFFICILE(10);

    /**
     * Numero massimo di tentativi fallibili.
     */
    private final int maxTentativi;

    /**
     * Costruttore che imposta le costanti
     * di tentativi a seconda del livello.
     * @param maxNumTentativi
     */
    Livello(final int maxNumTentativi) {
            this.maxTentativi = maxNumTentativi;
    }

    /**
     * Getter del numero massimo di tentativi
     * associati al livello.
     * @return maxTentativi
     */
    public int getMaxTentativi() {
            return maxTentativi;
    }
}

