package it.uniba.app;

import java.util.List;

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
                rimuoviDaListaCelleOccupate(nave, cella);

                if (isListaCelleOccupateVuota(nave)) {
                    nave.setAffondata(true);
                    rimuoviDaListaNaviPresenti(griglia, nave);
                    return Esito.AFFONDATO;
                } else {
                    return Esito.COLPITO;
                }
            }
        }
    }

    /**
     * Metodo che rimuove la cella passata dalla lista di celle occupate dalla nave.
     * @param nave
     * @param cella
     */
    public void rimuoviDaListaCelleOccupate(final Nave nave, final Griglia.Cella cella) {
        List<Griglia.Cella> listaCelle = nave.getListaCelleOccupate();
        listaCelle.remove(cella);
    }

    /**
     * Metodo che rimuove la nave passata dalla lista di navi presenti nella griglia.
     * @param griglia
     * @param nave
     */
    public void rimuoviDaListaNaviPresenti(final Griglia griglia, final Nave nave) {
        List<Nave> listaNavi = griglia.getListaNaviPresenti();
        listaNavi.remove(nave);
    }

    /**
     * Metodo che verifica se la lista di celle occupate da una nave passata è vuota.
     * @param nave
     * @return true se la lista è vuota, false altrimenti
     */
    public boolean isListaCelleOccupateVuota(final Nave nave) {
        List<Griglia.Cella> listaCelle = nave.getListaCelleOccupate();
        return listaCelle.isEmpty();
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


    /**
     * Metodo che verifica se la cella alle coordinate date è occupata da una nave.
     * @param x
     * @param y
     * @return true se ospita una nave, false altrimenti
     */
    public boolean isCellaOccupata(final int x, final int y) {
        Griglia griglia = this.partita.getGriglia();
        Griglia.Cella cella = griglia.getCella(x, y);
        return cella.isOccupata();
    }

    /**
     * Metodo che verifica se la cella alle coordinate date è stata colpita.
     * @param x
     * @param y
     * @return true se la cella è stata colpita, false altrimenti
     */
    public boolean isCellaColpita(final int x, final int y) {
        Griglia griglia = this.partita.getGriglia();
        Griglia.Cella cella = griglia.getCella(x, y);
        return cella.isColpita();
    }

    /**
     * Metodo che ottiene il numero di esemplari di ciascun tipo di nave.
     * @return numNavi
     */
    public int[] ottieniNumNaviPresenti() {
        Griglia griglia = this.partita.getGriglia();
        final int num = 4;
        final int numCelleCP = 2;
        final int numCelleIN = 3;
        final int numCelleCR = 4;
        final int numCellePA = 5;
        final int pos0 = 0;
        final int pos1 = 1;
        final int pos2 = 2;
        final int pos3 = 3;
        int[] numNavi = new int[num];

        for (Nave nave : griglia.getListaNaviPresenti()) {
            int numCelle = nave.getNumeroCelleOccupate();
            switch (numCelle) {
                case numCelleCP:
                    numNavi[pos0]++;
                break;
                case numCelleIN:
                    numNavi[pos1]++;
                break;
                case numCelleCR:
                    numNavi[pos2]++;
                break;
                case numCellePA:
                    numNavi[pos3]++;
                break;
                default:
                break;
            }
        }

        return numNavi;
    }
}
