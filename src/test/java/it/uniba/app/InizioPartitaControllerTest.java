package it.uniba.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InizioPartitaControllerTest {

    private InizioPartitaController controller;
    private Tempo tempo;
    private Partita partita;

    @BeforeEach
    public void setUp() {
        controller = new InizioPartitaController(partita);
        tempo = Tempo.getIstanza();
        partita = new Partita();
    }

    @Test
    @DisplayName ("Assicura che le navi siano disposte lungo la griglia")
    void testDisponiNavi() {
        controller.disponiNavi();
        Griglia griglia = partita.getGriglia();
        for (Nave nave : griglia.getListaNavi()) {
            for (Griglia.Cella cella : nave.getListaCelleOccupate()) {
                assertTrue(cella.isOccupata(), "vero se la cella è occupata");
            }
        }
    }

    @Test
    @DisplayName ("Assicura che il tempo di gioco sia stato avviato")
    void testAvviaTempoDiGioco() {
        controller.avviaTempoDiGioco();
        assertTrue(tempo.isAlive(), "vero se il tempo è partito");
    }
}

