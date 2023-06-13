package it.uniba.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Classe di test per la classe LivelloController.
 */
class LivelloControllerTest {

    private Livello livello;
    private LivelloController controller;
    private Proprieta proprieta;

    /**
     * Metodo che istanza gli oggetti delle classi Livello e LivelloController.
     */
    @BeforeEach
    void setUp() {
        livello = Livello.getIstanza();
        controller = new LivelloController(livello);
        proprieta = Proprieta.getIstanza();
    }

    /**
     * Test del metodo impostaLivelloCorrente della classe LivelloController.
     * Ci si aspetta che il livello corrente sia impostato a facile.
     */
    @Test
    @DisplayName ("Assicura che il livello corrente venga impostato a facile")
    void testImpostaLivelloCorrenteLivelloFacile() {
        controller.impostaLivelloCorrente(Livello.Tipo.FACILE);
        assertEquals(Livello.Tipo.FACILE, controller.ottieniLivelloCorrente(),
        "Il livello corrente è impostato a facile");
    }

    /**
     * Test del metodo impostaLivelloCorrente della classe LivelloController.
     * Ci si aspetta che i tentativi correnti siano impostati a tentativi correnti di facile.
     */
    @Test
    @DisplayName ("Assicura che i tentativi correnti vengano impostati a tentativi correnti di facile")
    void testImpostaLivelloCorrenteTentativiCorrentiPerLivelloFacile() {
        controller.impostaLivelloCorrente(Livello.Tipo.FACILE);
        assertEquals(livello.getTentFacile(), controller.ottieniTentativiCorrenti(),
        "i tentativi correnti sono impostati ai tentativi correnti di facile");
    }

    /**
     * Test del metodo impostaLivelloCorrente della classe LivelloController.
     * Ci si aspetta che il livello corrente sia impostato a medio.
     */
    @Test
    @DisplayName ("Assicura che il livello corrente venga impostato a medio")
    void testImpostaLivelloCorrenteLivelloMedio() {
        controller.impostaLivelloCorrente(Livello.Tipo.MEDIO);
        assertEquals(Livello.Tipo.MEDIO, controller.ottieniLivelloCorrente(),
        "Il livello corrente è impostato a medio");
    }

    /**
     * Test del metodo impostaLivelloCorrente della classe LivelloController.
     * Ci si aspetta che i tentativi correnti siano impostati a tentativi correnti di medio.
     */
    @Test
    @DisplayName ("Assicura che i tentativi correnti vengano impostati a tentativi correnti di medio")
    void testImpostaLivelloCorrenteTentativiCorrentiPerLivelloMedio() {
        controller.impostaLivelloCorrente(Livello.Tipo.MEDIO);
        assertEquals(livello.getTentMedio(), controller.ottieniTentativiCorrenti(),
        "i tentativi correnti sono impostati ai tentativi correnti di medio");
    }

    /**
     * Test del metodo impostaLivelloCorrente della classe LivelloController.
     * Ci si aspetta che il livello corrente sia impostato a difficile.
     */
    @Test
    @DisplayName ("Assicura che il livello corrente venga impostato a difficile")
    void testImpostaLivelloCorrenteLivelloDifficile() {
        controller.impostaLivelloCorrente(Livello.Tipo.DIFFICILE);
        assertEquals(Livello.Tipo.DIFFICILE, controller.ottieniLivelloCorrente(),
        "Il livello corrente è impostato a difficile");
    }

    /**
     * Test del metodo impostaLivelloCorrente della classe LivelloController.
     * Ci si aspetta che i tentativi correnti siano impostati a tentativi correnti di difficile.
     */
    @Test
    @DisplayName ("Assicura che i tentativi correnti vengano impostati a tentativi correnti di difficile")
    void testImpostaLivelloCorrenteTentativiCorrentiPerLivelloDifficile() {
        controller.impostaLivelloCorrente(Livello.Tipo.DIFFICILE);
        assertEquals(livello.getTentDifficile(), controller.ottieniTentativiCorrenti(),
        "i tentativi correnti sono impostati ai tentativi correnti di difficile");
    }

    /**
     * Test del metodo impostaTentativiLivello della classe LivelloController.
     * Ci si aspetta che i tentativi per livello facile siano impostati correttamente.
     */
    @Test
    @DisplayName("Assicura che i tentativi per livello facile siano impostati correttamente")
    void testImpostaTentativiLivelloFacile() {
        final int tentativi = 10;
        controller.impostaTentativiLivello(Livello.Tipo.FACILE, tentativi);
        assertEquals(tentativi, livello.getTentFacile(), "impostati tentativi di facile");
    }

    /**
     * Test del metodo impostaTentativiLivello della classe LivelloController.
     * Ci si aspetta che i tentativi per livello medio siano impostati correttamente.
     */
    @Test
    @DisplayName("Assicura che i tentativi per livello medio siano impostati correttamente")
    void testImpostaTentativiLivelloMedio() {
        final int tentativi = 10;
        controller.impostaTentativiLivello(Livello.Tipo.MEDIO, tentativi);
        assertEquals(tentativi, livello.getTentMedio(), "impostati tentativi di medio");
    }

    /**
     * Test del metodo impostaTentativiLivello della classe LivelloController.
     * Ci si aspetta che i tentativi per livello difficile siano impostati correttamente.
     */
    @Test
    @DisplayName("Assicura che i tentativi per livello difficile siano impostati correttamente")
    void testImpostaTentativiLivelloDifficile() {
        final int tentativi = 10;
        controller.impostaTentativiLivello(Livello.Tipo.DIFFICILE, tentativi);
        assertEquals(tentativi, livello.getTentDifficile(), "impostati tentativi di difficile");
    }

    /**
     * Test del metodo impostaTentativiPersonalizzato della classe LivelloController.
     * Ci si aspetta che il livello corrente sia impostato a personalizzato.
     */
    @Test
    @DisplayName("Assicura che venga impostato il livello personalizzato")
    void testImpostaTentativiPersonalizzatoLivello() {
        final int tentativi = 20;
        controller.impostaTentativiPersonalizzato(tentativi);
        assertEquals(Livello.Tipo.PERSONALIZZATO, controller.ottieniLivelloCorrente(),
        "imposta livello corrente a personalizzato");
    }

    /**
     * Test del metodo impostaTentativiPersonalizzato della classe LivelloController.
     * Ci si aspetta che i tentativi per livello personalizzato siano impostati correttamente.
     */
    @Test
    @DisplayName("Assicura che i tentativi per livello personalizzato siano impostati correttamente")
    void testImpostaTentativiLivelloPersonalizzatoTentativi() {
        final int tentativi = 20;
        controller.impostaTentativiPersonalizzato(tentativi);
        assertEquals(tentativi, controller.ottieniTentativiCorrenti(),
        "impostati tentativi di personalizzato");
    }

    /**
     * Test del metodo isTentativiValidi della classe LivelloController.
     * Ci si aspetta che i tentativi siano validi.
     */
    @Test
    @DisplayName("Assicura che i tentativi siano validi")
    void testIsTentativiValidiCorretto() {
        final int dimensioneGriglia = 10;
        proprieta.setDimensioniGriglia(dimensioneGriglia);
        int tentativiValidi = dimensioneGriglia * dimensioneGriglia - 1;
        assertTrue(controller.isTentativiValidi(tentativiValidi), "i tentativi sono validi");
    }

    /**
     * Test del metodo isTentativiValidi della classe LivelloController.
     * Ci si aspetta che i tentativi non siano validi.
     */
    @Test
    @DisplayName("Assicura che i tentativi non siano validi")
    void testIsTentativiValidiNonCorretto() {
        final int dimensioneGriglia = 10;
        proprieta.setDimensioniGriglia(dimensioneGriglia);
        int tentativiNonValidi = dimensioneGriglia * dimensioneGriglia + 1;
        assertFalse(controller.isTentativiValidi(tentativiNonValidi), "i tentativi non sono validi");
    }

    /**
     * Test del metodo isTentativiValidi della classe LivelloController.
     * Ci si aspetta che i tentativi siano validi.
     */
    @Test
    @DisplayName("Assicura che i tentativi limite siano validi")
    void testIsTentativiValidiLimiteCorretto() {
        final int dimensioneGriglia = 10;
        proprieta.setDimensioniGriglia(dimensioneGriglia);
        int tentativiValidi = dimensioneGriglia * dimensioneGriglia;
        assertTrue(controller.isTentativiValidi(tentativiValidi), "i tentativi sono validi");
    }
}
