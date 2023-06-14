package it.uniba.boundaries;

import it.uniba.controllers.PartitaInCorsoController;
import it.uniba.controllers.ProprietaController;
import java.util.List;
import java.util.Arrays;

/**
 * <Boundary>
 * Classe che gestisce la visualizzazione della griglia sul terminale.
 */
public final class GrigliaUI {

    private PartitaInCorsoController pcContr = null;

    private static final List<String> LETTERE = Arrays.asList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));

    private static final String WHITE = "\u001B[37m";
    private static final String CYAN = "\u001B[36m";
    private static final String RESET = "\u001B[0m";
    private static final String RED_BC = "\u001B[41m";
    private static final String GREEN_BC = "\u001B[42m";
    private static final String YELLOW_BC = "\u001B[43m";

    /**
     * Costruttore che inizializza il controller.
     * @param pc
     */
    public GrigliaUI(final PartitaInCorsoController pc) {
        this.pcContr = pc;
    }


    /**
     * Metodo che stampa sul terminale la griglia che mostra le celle e le navi colpite.
     */
    public void displayGriglia() {
        ProprietaController propContr = new ProprietaController();
        final int dim = propContr.ottieniDimGriglia();

        System.out.println("");
        stampaSeparatoreGriglia(dim);
        System.out.print("\n   |      |");
        for (int i = 1; i <= dim; i++) {
            System.out.print(" " + LETTERE.get(i - 1) + " |");
        }
        stampaSeparatoreGriglia(dim);
        for (int i = 1; i <= dim; i++) {
            System.out.print("\n");
            System.out.format("   |  %02d  |", i);
            for (int j = 1; j <= dim; j++) {
                if (this.pcContr.isCellaColpita(i, j)) {
                    if (this.pcContr.isCellaOccupata(i, j)) {
                        System.out.print(GREEN_BC + " X " + RESET + "|");
                    } else {
                        System.out.print(RED_BC + " X " + RESET + "|");
                    }
                } else {
                    System.out.print(CYAN + " O " + RESET + "|");
                }
            }
            stampaSeparatoreGriglia(dim);
        }
        System.out.print("\n");
    }

    /**
     * Metodo che stampa sul terminale la griglia con tutte le navi posizionate.
     */
    public void displayGrigliaSvelata() {
        ProprietaController propContr = new ProprietaController();
        final int dim = propContr.ottieniDimGriglia();

        System.out.println("");
        stampaSeparatoreGriglia(dim);
        System.out.print("\n   |      |");
        for (int i = 1; i <= dim; i++) {
            System.out.print(" " + LETTERE.get(i - 1) + " |");
        }
        stampaSeparatoreGriglia(dim);
        for (int i = 1; i <= dim; i++) {
            System.out.print("\n");
            System.out.format("   |  %02d  |", i);
            for (int j = 1; j <= dim; j++) {
                if (this.pcContr.isCellaOccupata(i, j)) {
                    System.out.print(YELLOW_BC + " X " + RESET + "|");
                } else {
                    System.out.print(CYAN + " O " + RESET + "|");
                }
            }
            stampaSeparatoreGriglia(dim);
        }
        System.out.print("\n");
    }

    /**
     * Metodo che stampa sul terminale la griglia vuota.
     */
    public void displayGrigliaVuota() {
        ProprietaController propContr = new ProprietaController();
        final int dim = propContr.ottieniDimGriglia();

        System.out.println("");
        stampaSeparatoreGriglia(dim);
        System.out.print("\n   |      |");
        for (int i = 1; i <= dim; i++) {
            System.out.print(" " + LETTERE.get(i - 1) + " |");
        }
        stampaSeparatoreGriglia(dim);
        for (int i = 1; i <= dim; i++) {
            System.out.print("\n");
            System.out.format("   |  %02d  |", i);
            for (int j = 1; j <= dim; j++) {
                System.out.print("   |");
            }
            stampaSeparatoreGriglia(dim);
        }
        System.out.print("\n");
    }

    /**
     * Metodo che stampa un separatore nella griglia.
     * @param dim
     */
    private void stampaSeparatoreGriglia(final int dim) {
        System.out.print("\n   +------+");
        for (int i = 1; i <= dim; i++) {
            System.out.print("---+");
        }
    }
}
