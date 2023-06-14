package it.uniba.controllers;

import it.uniba.entities.Tempo;

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
    private Tempo tempo;

    /**
     * Metodo che istanzia gli oggetti delle classi
     * Tempo e TempoController.
     */
    @BeforeEach
    void setUp() {
        tempo = new Tempo();
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
        final int millisecondi = 63000;
        tempoController.impostaTempo(minuti);
        tempoController.avviaTempo();
        try {
            Thread.sleep(millisecondi);  // Aspetta 63 secondi
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(tempoController.isTempoScaduto(), "Il tempo deve essere scaduto");
    }

}
