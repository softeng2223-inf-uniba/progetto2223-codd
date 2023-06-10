package it.uniba.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProprietaControllerTest {

    private Proprieta prop;
    private ProprietaController controller;


    @BeforeEach
    void setUp {
        prop = new Proprieta();
        controller = new ProprietaController(prop);
    }

    @Test
    @DisplayName ("Assicura che la dimensione della griglia sia la dimensione standard")
    public void testImpostaGrigliaStandard() {
        final int DIMENSIONE_STANDARD = 10;
        controller.impostaGrigliaStandard();
        int dimensioniGriglia = prop.getDimensioniGriglia();
        assertEquals(DIMENSIONE_STANDARD, dimensioniGriglia,
        "la dimensione della griglia è 10");
    }

    @Test
    @DisplayName ("Assicura che la dimensione della griglia sia la dimensione large")
    public void testImpostaGrigliaLarge() {
        final int DIMENSIONE_LARGE = 18;
        controller.impostaGrigliaLarge();
        int dimensioniGriglia = prop.getDimensioniGriglia();
        assertEquals(DIMENSIONE_LARGE, dimensioniGriglia,
        "la dimensione della griglia è 18");
    }

    @Test
    @DisplayName ("Assicura che la dimensione della griglia sia la dimensione extralarge")
    public void testImpostaGrigliaExtralarge() {
        final int DIMENSIONE_EXTRALARGE = 26;
        controller.impostaGrigliaExtralarge();
        int dimensioniGriglia = prop.getDimensioniGriglia();
        assertEquals(DIMENSIONE_EXTRALARGE, dimensioniGriglia,
        "la dimensione della griglia è 26");
    }
}

