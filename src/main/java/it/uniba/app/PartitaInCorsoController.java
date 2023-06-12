package it.uniba.app;

/**
 * <Control>
 * Classe che gestisce il corso della partita.
 */
public final class PartitaInCorsoController {

    private Partita partita = null;


    /**
     * Enumerativo che rappresenta l'esito di un tentativo.
     */
    public enum Esito {
        ACQUA, GIA_COLPITO, COLPITO, AFFONDATO;
    }


    /**
     * Costruttore che inizializza l'attributo partita.
     * @param part
     */
    public PartitaInCorsoController(final Partita part) {
        this.partita = part;
    }


    /**
     * Metodo che gestisce un tentativo effettuato dall'utente e ne
     * restituisce l'esito.
     * @param x
     * @param y
     * @return esito
     */
    public Esito gestisciTentativo(final int x, final int y) {

        Griglia griglia = this.partita.getGriglia();
        int tentEff = this.partita.getTentEffettuati();
        int tentFall = this.partita.getTentFalliti();

        Griglia.Cella cella = griglia.getCella(x, y);

        if (cella.isColpita()) {
            return Esito.GIA_COLPITO;
        } else {
            this.partita.setTentEffettuati(tentEff + 1);
            cella.setColpita(true);

            if (!cella.isOccupata()) {
                this.partita.setTentFalliti(tentFall + 1);
                return Esito.ACQUA;
            } else {

                Nave nave = cella.getNaveOspitata();
                nave.rimuoviDaListaCelleOccupate(cella);

                if (nave.isListaCelleOccupateVuota()) {
                    nave.setAffondata(true);
                    griglia.rimuoviDaListaNaviPresenti(nave);
                    return Esito.AFFONDATO;
                } else {
                    return Esito.COLPITO;
                }
            }
        }
    }

    /**
     * Metodo che ottiene la griglia associata alla partita.
     * @return griglia
     */
    public Griglia ottieniGriglia() {

        return this.partita.getGriglia();
    }

    /**
     * Metodo che ottiene il numero di tentativi effettuati, falliti e il
     * massimo numero di tentativi fallibili.
     * @return tent
     */
    public int[] ottieniTentativi() {
        final int dimTent = 3;
        int[] tent = new int[dimTent];
        tent[0] = this.partita.getTentEffettuati();
        tent[1] = this.partita.getTentFalliti();
        tent[2] = this.partita.getMaxTent();

        return tent;
    }
}

