package it.uniba.controllers;
import it.uniba.entities.Partita;
import it.uniba.entities.Griglia;
import it.uniba.entities.Griglia.Cella;
import it.uniba.entities.Nave;
import it.uniba.entities.Cacciatorpediniere;

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
        final int coordinata = 1;
        PartitaInCorsoController.Esito risultato = controller.gestisciTentativo(coordinata, coordinata);
        assertEquals(PartitaInCorsoController.Esito.ACQUA, risultato, "Il risultato deve essere ACQUA");
    }

    /**
     * Test del metodo gestisciTentativo della classe PartitaInCorsoController.
     * Assicura che se effettuo un tentativo in una cella già colpita, il risultato
     * sia GIA_COLPITO.
     */
    @Test
    @DisplayName("Assicura che se effettuo un tentativo in una cella già colpita, il risultato sia GIA_COLPITO.")
    void testGestisciTentativoGiaColpito() {
        Griglia griglia = partita.getGriglia();
        final int coordinata = 1;
        Griglia.Cella cella = griglia.getCella(coordinata, coordinata);
        cella.setColpita(true); // Imposta la cella come già colpita
        PartitaInCorsoController.Esito risultato = controller.gestisciTentativo(coordinata, coordinata);
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
        InizioPartitaController ipContr = new InizioPartitaController(partita);
        final int coordinata1 = 1;
        final int coordinata2 = 2;
        Griglia.Cella cella1 = griglia.getCella(coordinata1, coordinata1);
        Griglia.Cella cella2 = griglia.getCella(coordinata1, coordinata2);
        Nave nave = new Cacciatorpediniere();
        cella1.setNaveOspitata(nave);
        cella2.setNaveOspitata(nave);
        ipContr.aggiungiAListaCelleOccupate(nave, cella1);
        ipContr.aggiungiAListaCelleOccupate(nave, cella2);
        PartitaInCorsoController.Esito risultato = controller.gestisciTentativo(coordinata1, coordinata1);
        assertEquals(PartitaInCorsoController.Esito.COLPITO, risultato, "Il risultato deve essere COLPITO");
    }

    /**
     * Test del metodo gestisciTentativo della classe PartitaInCorsoController.
     * Assicura che se effettuo un tentativo nell'ultima cella occupata da una nave,
     * il risultato sia AFFONDATO.
     */
    @Test
    @DisplayName("Assicura che se effettuo un tentativo nell'ultima cella occupata da una nave "
    + "il risultato sia AFFONDATO.")
    void testGestisciTentativoAffondato() {
        Griglia griglia = partita.getGriglia();
        InizioPartitaController ipContr = new InizioPartitaController(partita);
        final int coordinata1 = 1;
        final int coordinata2 = 2;
        Griglia.Cella cella1 = griglia.getCella(coordinata1, coordinata1);
        Griglia.Cella cella2 = griglia.getCella(coordinata1, coordinata2);
        Nave nave = new Cacciatorpediniere();
        cella1.setNaveOspitata(nave);
        cella2.setNaveOspitata(nave);
        ipContr.aggiungiAListaCelleOccupate(nave, cella1);
        ipContr.aggiungiAListaCelleOccupate(nave, cella2);
        cella1.setColpita(true);
        controller.rimuoviDaListaCelleOccupate(nave, cella1);
        PartitaInCorsoController.Esito risultato = controller.gestisciTentativo(coordinata1, coordinata2);
        assertEquals(PartitaInCorsoController.Esito.AFFONDATO, risultato, "Il risultato deve essere AFFONDATO");
    }
}
