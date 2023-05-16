package it.uniba.app;

/**
 * Classe che rappresenta il livello della sessione corrente di gioco.
 */
public final class LivelloSessione {

    /**
     * Stato del livello corrente.
     */
    private static Livello corrente = Livello.FACILE;

    /**
     * costruttore vuoto (la classe non verrà istanziata).
     */
    private LivelloSessione() {
    }

    /**
     * getter del livello corrente.
     * @return corrente
     */
    public static Livello getCorrente() {
        return corrente;
    }

    /**
     * setter del livello corrente.
     * @param livCorrente
     */
    public static void setCorrente(final Livello livCorrente) {
        LivelloSessione.corrente = livCorrente;
    }

}
