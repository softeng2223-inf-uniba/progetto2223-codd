package it.uniba.controllers;

import it.uniba.entities.Proprieta;

/**
 * <Control>
 * Classe che gestisce le proprietà della partita.
 */
public final class ProprietaController {

    private Proprieta proprieta = null;

    private static final int DIMENSIONI_GRIGLIA_STANDARD = 10;
    private static final int DIMENSIONI_GRIGLIA_LARGE = 18;
    private static final int DIMENSIONI_GRIGLIA_EXTRALARGE = 26;

    /**
     * Costruttore della classe ProprietaController.
     */
    public ProprietaController() {
        this.proprieta = Proprieta.getIstanza();
    }

    /**
     * Metodo che imposta la dimensione della griglia a standard.
     */
    public void impostaGrigliaStandard() {
        this.proprieta.setDimensioniGriglia(DIMENSIONI_GRIGLIA_STANDARD);
    }

    /**
     * Metodo che imposta la dimensione della griglia a large.
     */
    public void impostaGrigliaLarge() {
        this.proprieta.setDimensioniGriglia(DIMENSIONI_GRIGLIA_LARGE);
    }

    /**
     * Metodo che imposta la dimensione della griglia a extralarge.
     */
    public void impostaGrigliaExtralarge() {
        this.proprieta.setDimensioniGriglia(DIMENSIONI_GRIGLIA_EXTRALARGE);
    }

    /**
     * Metodo che ottiene la dimensione della griglia impostata correntemente.
     * @return dimensioni impostate
     */
    public int ottieniDimGriglia() {
        return this.proprieta.getDimensioniGriglia();
    }

    /**
     * Metodo che imposta i minuti trascorsi e setta il tempo come impostato.
     * @param minuti
     */
    public void impostaTempo(final int minuti) {
        this.proprieta.setMinutiImpostati(minuti);
        this.proprieta.setTempoImpostato(true);
    }

    /**
     * Metodo che ottiene i minuti impostati.
     * @return minutiImpostati
     */
    public int ottieniMinutiImpostati() {
        return this.proprieta.getMinutiImpostati();
    }

    /**
     * Metodo che verifica se il tempo è impostato.
     */
    public boolean isTempoImpostato() {
        return this.proprieta.isTempoImpostato();
    }
}

