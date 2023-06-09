package it.uniba.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TempoControllerTest {

    private TempoController tempoController;

    @BeforeEach
    void setUp() {
        Tempo tempo = Tempo.getIstanza();
        tempo.reset();
        tempoController = new TempoController(tempo);
    }

    @Test
    @DisplayName("Assicura che il tempo venga impostato a 5 minuti")
    void testImpostaTempo() {
        final int minuti = 5;
        tempoController.impostaTempo(minuti);
        assertEquals(minuti, tempoController.ottieniTempoRestante()[0], "Il tempo deve essere impostato a 5 minuti");
    }

    @Test
    @DisplayName("Assicura che il tempo venga avviato")
    void testAvviaTempo() {
        final int minuti = 1;
        tempoController.impostaTempo(minuti);
        tempoController.avviaTempo();
        assertFalse(tempoController.isTempoScaduto(), "Il tempo non deve essere scaduto");
    }

    @Test
    @DisplayName("Assicura che il tempo sia scaduto")
    void testIsTempoScaduto() {
        final int minuti = 1;
        final int millisecondi = 65000;
        tempoController.impostaTempo(minuti);
        tempoController.avviaTempo();
        try {
            Thread.sleep(millisecondi);  // Aspetta 65 secondi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(tempoController.isTempoScaduto(), "Il tempo deve essere scaduto");
    }
}

