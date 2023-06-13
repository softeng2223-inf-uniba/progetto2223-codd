package it.uniba.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe di test di InizioPartitaController.
 */
class InizioPartitaControllerTest {

    private InizioPartitaController controller;
    private Tempo tempo;
    private Partita partita;

    /**
     * Metodo che istanzia gli oggetti della classi Partita, Tempo
     * e InizioPartitaController.
     */
    @BeforeEach
    void setUp() {
        partita = new Partita();
        controller = new InizioPartitaController(partita);
        tempo = Tempo.getIstanza();
        tempo.setImpostato(true);
    }

    /**
     * Test del metodo DisponiNavi della classe InizioPartitaController.
     * Il valore aspettato è vero se le celle di ogni nave sono occupate
     * dalla nave stessa.
     */
    @Test
    @DisplayName ("Assicura che le navi siano disposte lungo la griglia")
    void testDisponiNavi() {
        controller.disponiNavi();
        Griglia griglia = partita.getGriglia();
        for (Nave nave : griglia.getListaNaviPresenti()) {
            for (Griglia.Cella cella : nave.getListaCelleOccupate()) {
                assertTrue(cella.isOccupata(), "vero se la cella è occupata");
            }
        }
    }

    /**
     * Test del metodo DisponiNavi della classe InizioPartitaController.
     * Il valore aspettato è vero se il numero di navi disposte nella griglia è uguale
     * a 10.
     */
    @Test
    @DisplayName ("Assicura che il numero di navi disposte sia uguale a 10")
    void testDisponiNaviNumeroNavi() {
        controller.disponiNavi();
        Griglia griglia = partita.getGriglia();
        final int numeroNavi = 10;
        assertTrue(griglia.getListaNaviPresenti().size() == numeroNavi, "vero se il numero di navi è uguale a 10");
    }

    /**
     * Test del metodo DisponiNavi della classe InizioPartitaController.
     * Il valore aspettato è vero se il numero di celle occupate dalle navi
     * è uguale a 30.
     */
    @Test
    @DisplayName ("Assicura che il numero di celle occupate dalle navi sia uguale a 30")
    void testDisponiNaviNumeroCelle() {
        controller.disponiNavi();
        Griglia griglia = partita.getGriglia();
        int numeroCelle = 0;
        final int numeroCelleTotali = 30;
        for (Nave nave : griglia.getListaNaviPresenti()) {
            numeroCelle += nave.getListaCelleOccupate().size();
        }
        assertTrue(numeroCelle == numeroCelleTotali, "vero se il numero di celle occupate è uguale a 30");
    }

    /**
     * Test del metodo AvviaTempoDiGioco della classe InizioPartitaController.
     * Il valore aspettato è vero se il tempo di gioco è avviato.
     */
    @Test
    @DisplayName ("Assicura che il tempo di gioco sia stato avviato")
    void testAvviaTempoDiGioco() {
        controller.avviaTempoDiGioco();
        assertTrue(tempo.isAlive(), "vero se il tempo è partito");
    }
}

