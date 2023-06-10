package it.uniba.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProprietaControllerTest {

    private ProprietaController proprietaController;
    private Proprieta proprieta;


    @BeforeEach
    void setUp() {
        proprieta = Proprieta.getIstanza();
        proprietaController = new ProprietaController(proprieta);
    }

    @Test
    @DisplayName ("Assicura che la dimensione della griglia sia la dimensione standard")
    void testImpostaGrigliaStandard() {
        final int dimensioneStandard = 10;
        proprietaController.impostaGrigliaStandard();
        int dimensioniGriglia = proprieta.getDimensioniGriglia();
        assertEquals(dimensioneStandard, dimensioniGriglia,
        "la dimensione della griglia è 10");
    }

    @Test
    @DisplayName ("Assicura che la dimensione della griglia sia la dimensione large")
    void testImpostaGrigliaLarge() {
        final int dimensioneLarge = 18;
        proprietaController.impostaGrigliaLarge();
        int dimensioniGriglia = proprieta.getDimensioniGriglia();
        assertEquals(dimensioneLarge, dimensioniGriglia,
        "la dimensione della griglia è 18");
    }

    @Test
    @DisplayName ("Assicura che la dimensione della griglia sia la dimensione extralarge")
     void testImpostaGrigliaExtralarge() {
        final int dimensioneExtralarge = 26;
        proprietaController.impostaGrigliaExtralarge();
        int dimensioniGriglia = proprieta.getDimensioniGriglia();
        assertEquals(dimensioneExtralarge, dimensioniGriglia,
        "la dimensione della griglia è 26");
    }
}

