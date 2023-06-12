package it.uniba.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe di test di PartitaInCorsoController.
 */
class PartitaInCorsoControllerTest {

    private Partita partita;
    private PartitaInCorsoController controller;

    /**
     * Metodo che istanzia gli oggetti delle classi
     * Partita e PartitaInCorsoController.
     */
    @BeforeEach
    void setup() {
        partita = new Partita();
        controller = new PartitaInCorsoController(partita);
    }

    /**
     * Test del metodo gestisciTentativo della classe PartitaInCorsoController.
     * Assicura che se effettuo un tentativo in una cella vuota, il risultato
     * sia ACQUA.
     */
    @Test
    @DisplayName("Assicura che se effettuo un tentativo in una cella vuota,il risultato sia ACQUA.")
    void testGestisciTentativoAcqua() {
        Griglia griglia = partita.getGriglia();
        final int coordinata = 1;
        Griglia.Cella cella = griglia.getCella(coordinata, coordinata);
        PartitaInCorsoController.Esito risultato = controller.gestisciTentativo(cella);
        assertEquals(PartitaInCorsoController.Esito.ACQUA, risultato, "Il risultato deve essere ACQUA");
    }

    /**
     * Test del metodo gestisciTentativo della classe PartitaInCorsoController.
     * Assicura che se effettuo un tentativo in una cella già colpita, il risultato
     * sia GIA_COLPITO.
     */
	@Test
    @DisplayName("Assicura che se effettuo un tentativo in una cella già colpita, il risultato sia GIA_COLPITO.")
	void testGestisciTentativoGiàColpito() {
   	Griglia griglia = partita.getGriglia();
    final int coordinata = 1;
    Griglia.Cella cella = griglia.getCella(coordinata, coordinata);
    cella.setColpita(true); // Imposta la cella come già colpita
    PartitaInCorsoController.Esito risultato = controller.gestisciTentativo(cella);
    assertEquals(PartitaInCorsoController.Esito.GIA_COLPITO, risultato, "Il risultato deve essere GIA_COLPITO");
}

    /**
     * Test del metodo gestisciTentativo della classe PartitaInCorsoController.
     * Assicura che se effettuo un tentativo in una cella occupata da una nave,
     * il risultato sia COLPITO.
     */
    @Test
    @DisplayName("Assicura che se effettuo un tentativo in una cella occupata da una nave, il risultato sia COLPITO.")
    void testGestisciTentativoColpito() {
        Griglia griglia = partita.getGriglia();
        final int coordinata1 = 1;
        final int coordinata2 = 2;
        Griglia.Cella cella1 = griglia.getCella(coordinata1, coordinata1);
        Griglia.Cella cella2 = griglia.getCella(coordinata1, coordinata2);
        Nave nave = new Cacciatorpediniere();
        cella1.setNaveOspitata(nave);
        cella2.setNaveOspitata(nave);
        nave.aggiungiAListaCelleOccupate(cella1);
        nave.aggiungiAListaCelleOccupate(cella2);
        PartitaInCorsoController.Esito risultato = controller.gestisciTentativo(cella1);
        assertEquals(PartitaInCorsoController.Esito.COLPITO, risultato, "Il risultato deve essere COLPITO");
    }

    /**
     * Test del metodo gestisciTentativo della classe PartitaInCorsoController.
     * Assicura che se effettuo un tentativo nell'ultima cella occupata da una nave,
     * il risultato sia AFFONDATO.
     */
    @Test
    @DisplayName("Assicura che se effettuo un tentativo nell'ultima cella occupata da una nave"
    + "il risultato sia AFFONDATO.")
    void testGestisciTentativoAffondato() {
        Griglia griglia = partita.getGriglia();
        final int coordinata1 = 1;
        final int coordinata2 = 2;
        Griglia.Cella cella1 = griglia.getCella(coordinata1, coordinata1);
        Griglia.Cella cella2 = griglia.getCella(coordinata1, coordinata2);
        Nave nave = new Cacciatorpediniere();
        cella1.setNaveOspitata(nave);
        cella2.setNaveOspitata(nave);
        nave.aggiungiAListaCelleOccupate(cella1);
        nave.aggiungiAListaCelleOccupate(cella2);
	    cella1.setColpita(true);
        PartitaInCorsoController.Esito risultato = controller.gestisciTentativo(cella2);
	    assertEquals(PartitaInCorsoController.Esito.AFFONDATO, risultato, "Il risultato deve essere AFFONDATO");
    }
}

