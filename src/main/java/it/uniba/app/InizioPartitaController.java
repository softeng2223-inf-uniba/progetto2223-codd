package it.uniba.app;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * <Control>
 * Classe che gestisce l'inizio della partita.
 */
public final class InizioPartitaController {

    private Partita partita = null;

    private Random rand = new Random();


    /**
     * Costruttore del controller che inizializza partita.
     * @param part
     */
    public InizioPartitaController(final Partita part) {
        this.partita = part;
    }


    /**
     * Metodo che dispone randomicamente le navi nella griglia all'inizio della partita.
     */
    public void disponiNavi() {

        Griglia griglia = this.partita.getGriglia();
        final int dim = griglia.getDimensione();
        List<Griglia.Direzione> listaDir = Arrays.asList(
            Griglia.Direzione.ALTO, Griglia.Direzione.BASSO, Griglia.Direzione.SINISTRA, Griglia.Direzione.DESTRA);

        for (Nave nave : griglia.getListaNavi()) {

            boolean posizionata = false;
            while (!posizionata) {

                int x = rand.nextInt(dim) + 1;
                int y = rand.nextInt(dim) + 1;
                Griglia.Cella cella = griglia.getCella(x, y);

                if (!cella.isOccupata()) {
                    Collections.shuffle(listaDir);

                    for (Griglia.Direzione dir : listaDir) {
                        if (isPosizionabile(nave, dir, cella)) {
                            posiziona(nave, dir, cella);
                            posizionata = true;
                            break;
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodo che verifica se la nave passata è posizionabile a partire dalla cellaIniz
     * e lungo la direzione dir.
     * @param nave
     * @param dir
     * @param cellaIniz
     * @return true se la nave è posizionabile, false altrimenti.
     */
    private boolean isPosizionabile(final Nave nave, final Griglia.Direzione dir, final Griglia.Cella cellaIniz) {

        final int lung = nave.getNumeroCelleOccupate();
        Griglia.Cella cella = cellaIniz;
        int cont = 1;

        while (cella.isSuccDisponibile(dir) && cont < lung) {
            cella = cella.getCellaSucc(dir);
            cont++;
        }
        return (cont == lung);
    }

    /**
     * Metodo che posiziona la nave passata a partire dalla cellaIniz e lungo la direzione dir.
     * @param nave
     * @param dir
     * @param cellaIniz
     */
    private void posiziona(final Nave nave, final Griglia.Direzione dir, final Griglia.Cella cellaIniz) {

        final int lung = nave.getNumeroCelleOccupate();
        Griglia.Cella cella = cellaIniz;
        int cont = 0;

        while (cont < lung) {
            cella.setNaveOspitata(nave);
            nave.aggiungiAListaCelleOccupate(cella);
            cella = cella.getCellaSucc(dir);
            cont++;
        }
    }


    /**
     * Metodo che avvia il tempo di gioco della partita.
     */
    public void avviaTempoDiGioco() {

        Tempo temp = Tempo.getIstanza();
        TempoController tempContr = new TempoController(temp);

        tempContr.avviaTempo();
    }
}
