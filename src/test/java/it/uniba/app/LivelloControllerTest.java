package it.uniba.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;


class LivelloControllerTest {

    private Livello livello;
    private LivelloController controller;

    @BeforeEach
    void setUp() {
        livello = new Livello();
        controller = new LivelloController(livello);
    }

    @Test
    @DisplayName ("Assicura che il livello corrente venga impostato a facile")
    void testImpostaLivelloCorrenteLivelloFacile() {
        controller.impostaLivelloCorrente(Livello.Tipo.FACILE);
        assertEquals(Livello.Tipo.FACILE, controller.ottieniLivelloCorrente(),
        "Il livello corrente è impostato a facile");
    }

    @Test
    @DisplayName ("Assicura che i tentativi correnti vengano impostati a tentativi correnti di facile")
    void testImpostaLivelloCorrenteTentativiCorrentiPerLivelloFacile() {
        controller.impostaLivelloCorrente(Livello.Tipo.FACILE);
        assertEquals(livello.getTentFacile(), controller.ottieniTentativiCorrenti(),
        "i tentativi correnti sono impostati ai tentativi correnti di facile");
    }


    @Test
    @DisplayName ("Assicura che il livello corrente venga impostato a medio")
    void testImpostaLivelloCorrenteLivelloMedio() {
        controller.impostaLivelloCorrente(Livello.Tipo.MEDIO);
        assertEquals(Livello.Tipo.MEDIO, controller.ottieniLivelloCorrente(),
        "Il livello corrente è impostato a medio");
    }

    @Test
    @DisplayName ("Assicura che i tentativi correnti vengano impostati a tentativi correnti di medio")
    void testImpostaLivelloCorrenteTentativiCorrentiPerLivelloMedio() {
        controller.impostaLivelloCorrente(Livello.Tipo.MEDIO);
        assertEquals(livello.getTentMedio(), controller.ottieniTentativiCorrenti(),
        "i tentativi correnti sono impostati ai tentativi correnti di medio");
    }

    @Test
    @DisplayName ("Assicura che il livello corrente venga impostato a difficile")
    void testImpostaLivelloCorrenteLivelloDifficile() {
        controller.impostaLivelloCorrente(Livello.Tipo.DIFFICILE);
        assertEquals(Livello.Tipo.DIFFICILE, controller.ottieniLivelloCorrente(),
        "Il livello corrente è impostato a difficile");
    }

    @Test
    @DisplayName ("Assicura che i tentativi correnti vengano impostati a tentativi correnti di difficile")
    void testImpostaLivelloCorrenteTentativiCorrentiPerLivelloDifficile() {
        controller.impostaLivelloCorrente(Livello.Tipo.DIFFICILE);
        assertEquals(livello.getTentDifficile(), controller.ottieniTentativiCorrenti(),
        "i tentativi correnti sono impostati ai tentativi correnti di difficile");
    }

    @Test
    @DisplayName("Assicura che i tentativi per livello facile siano impostati correttamente")
    void testImpostaTentativiLivelloFacile() {
        final int tentativi = 10;
        controller.impostaTentativiLivello(Livello.Tipo.FACILE, tentativi);
        assertEquals(tentativi, livello.getTentFacile(), "impostati tentativi di facile");
    }

    @Test
    @DisplayName("Assicura che i tentativi per livello medio siano impostati correttamente")
    void testImpostaTentativiLivelloMedio() {
        final int tentativi = 10;
        controller.impostaTentativiLivello(Livello.Tipo.MEDIO, tentativi);
        assertEquals(tentativi, livello.getTentMedio(), "impostati tentativi di medio");
    }

    @Test
    @DisplayName("Assicura che i tentativi per livello difficile siano impostati correttamente")
    void testImpostaTentativiLivelloDifficile() {
        final int tentativi = 10;
        controller.impostaTentativiLivello(Livello.Tipo.DIFFICILE, tentativi);
        assertEquals(tentativi, livello.getTentDifficile(), "impostati tentativi di difficile");
    }

    @Test
    @DisplayName("Assicura che venga impostato il livello personalizzato con relativi tentativi")
    void impostaTentativiPersonalizzato_DeveImpostareLivelloPersonalizzatoETentativiCorrenti() {
        final int tentativi = 20;
        controller.impostaTentativiPersonalizzato(tentativi);

        assertAll("impostato livello personalizzato con tentativi", () -> {
            assertEquals(Livello.Tipo.PERSONALIZZATO, controller.ottieniLivelloCorrente());
            assertEquals(tentativi, controller.ottieniTentativiCorrenti());
        });
        
    }

}

