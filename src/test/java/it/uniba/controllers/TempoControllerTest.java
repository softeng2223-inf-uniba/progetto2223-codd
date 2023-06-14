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
        tempo = Tempo.getIstanza();
        tempo.reset();
        tempoController = new TempoController();
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

    /**
     * Test del metodo reimpostaTempo della classe TempoController.
     * Assicura che i minuti impostati siano uguali a zero.
     */
    @Test
    @DisplayName("Assicura che i minuti vengano reimpostati a zero")
    void testReimpostaTempoMinuti() {
        final int minuti = 5;
        tempo.setMinutiImpostati(minuti);
        tempoController.reimpostaTempo();
        assertEquals(0, tempo.getMinutiImpostati(), "I minuti devono essere reimpostati a zero");
    }

    /**
     * Test del metodo reimpostaTempo della classe TempoController.
     * Il valore atteso è falso se il tempo non è scaduto.
     */
    @Test
    @DisplayName("Assicura che il tempo non sia scaduto")
    void testReimpostaTempoScaduto() {
        tempo.setScaduto(true);
        tempoController.reimpostaTempo();
        assertFalse(tempo.isScaduto(), "Il tempo non deve essere scaduto");
    }

    /**
     * Test del metodo reimpostaTempo della classe TempoController.
     * Il valore atteso è falso se il tempo non è stato impostato.
     */
    @Test
    @DisplayName("Assicura che il tempo non sia stato impostato")
    void testReimpostaTempoImpostato() {
        tempo.setImpostato(true);
        tempoController.reimpostaTempo();
        assertFalse(tempo.isImpostato(), "Il tempo non deve essere impostato");
    }
}

