package it.uniba.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProprietaControllerTest {

    private ProprietaController proprietaController;
    private Proprieta proprieta;


    @BeforeEach
    void setUp() {
        proprieta = Proprieta.getIstanza();
        proprietaController = new ProprietaController(proprieta);
    }

    @Test
    @DisplayName ("Assicura che la dimensione della griglia sia la dimensione standard")
    public void testImpostaGrigliaStandard() {
        final int DIMENSIONE_STANDARD = 10;
        proprietaController.impostaGrigliaStandard();
        int dimensioniGriglia = proprieta.getDimensioniGriglia();
        assertEquals(DIMENSIONE_STANDARD, dimensioniGriglia,
        "la dimensione della griglia è 10");
    }

    @Test
    @DisplayName ("Assicura che la dimensione della griglia sia la dimensione large")
    public void testImpostaGrigliaLarge() {
        final int DIMENSIONE_LARGE = 18;
        proprietaController.impostaGrigliaLarge();
        int dimensioniGriglia = proprieta.getDimensioniGriglia();
        assertEquals(DIMENSIONE_LARGE, dimensioniGriglia,
        "la dimensione della griglia è 18");
    }

    @Test
    @DisplayName ("Assicura che la dimensione della griglia sia la dimensione extralarge")
    public void testImpostaGrigliaExtralarge() {
        final int DIMENSIONE_EXTRALARGE = 26;
        proprietaController.impostaGrigliaExtralarge();
        int dimensioniGriglia = proprieta.getDimensioniGriglia();
        assertEquals(DIMENSIONE_EXTRALARGE, dimensioniGriglia,
        "la dimensione della griglia è 26");
    }
}

