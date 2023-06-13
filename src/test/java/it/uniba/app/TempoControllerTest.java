package it.uniba.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe di test di TempoController.
 */
class TempoControllerTest {

    private TempoController tempoController;

    /**
     * Metodo che istanzia gli oggetti delle classi
     * Tempo e TempoController.
     */
    @BeforeEach
    void setUp() {
        Tempo tempo = Tempo.getIstanza();
        tempo.reset();
        tempoController = new TempoController(tempo);
    }

    /**
     * Test del metodo ImpostaTempo della classe TempoController.
     * Il valore atteso è vero se il tempo è impostato ad un numero
     * di minuti determinato dall'utente.
     */
    @Test
    @DisplayName("Assicura che il tempo venga impostato a 5 minuti")
    void testImpostaTempo() {
        final int minuti = 5;
        tempoController.impostaTempo(minuti);
        final int minutiImpostati = tempo.getMinutiImpostati();
        assertEquals(minuti, minutiImpostati, "Il tempo deve essere impostato a 5 minuti");
    }

    /**
     * Test del metodo AvviaTempo della classe TempoController.
     * Il valore atteso è falso se il tempo non è scaduto.
     */
    @Test
    @DisplayName("Assicura che il tempo venga avviato")
    void testAvviaTempo() {
        final int minuti = 1;
        tempoController.impostaTempo(minuti);
        tempoController.avviaTempo();
        assertFalse(tempoController.isTempoScaduto(), "Il tempo non deve essere scaduto");
    }

    /**
     * Test del metodo IsTempoScaduto della classe TempoController.
     * Il valore atteso è vero se il tempo è scaduto.
     */
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

