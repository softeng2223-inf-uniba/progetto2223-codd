package it.uniba.controllers;
import it.uniba.entities.Partita;
import it.uniba.entities.Griglia;
import it.uniba.entities.Tempo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Classe di test di FinePartitaController.
 */
class FinePartitaControllerTest {

    private Partita partita;
    private FinePartitaController finePartitaController;
    /**
     * Metodo che istanzia l'oggetto della classe Partita.
     */
    @BeforeEach
    void setUp() {
        ProprietaController propContr = new ProprietaController();
        final int minuti = 10;
        propContr.impostaTempo(minuti);
        partita = new Partita();
        finePartitaController = new FinePartitaController(partita);
    }

    /**
     * Test del metodo verificaPartitaTerminata() della classe FinePartitaController.
     * Assicura che la partita sia terminata per sconfitta quando i tentativi
     * falliti sono pari al massimo consentito.
     */
    @Test
    @DisplayName("Assicura che la partita sia terminata per sconfitta quando i tentativi"
    + " falliti sono pari al massimo consentito")
    void testVerificaPartitaTerminataTentativiTerminati() {
        partita.setTentFalliti(partita.getMaxTent());  // Imposta i tentativi falliti al massimo consentito
        assertEquals(FinePartitaController.Esito.SCONFITTA, finePartitaController.verificaPartitaTerminata(),
        "La partita è terminata per sconfitta");
    }

    /**
     * Test del metodo verificaPartitaTerminata() della classe FinePartitaController.
     * Assicura che la partita sia terminata per vittoria quando tutte le navi
     * presenti nella griglia sono state affondate.
     */
    @Test
    @DisplayName("Assicura che la partita sia terminata per vittoria quando tutte le navi"
    + " presenti nella griglia sono state affondate")
    void testVerificaPartitaTerminataAllNaviAffondate() {
        Griglia griglia = partita.getGriglia();
        griglia.getListaNaviPresenti().clear();  // Rimuove tutte le navi dalla griglia
        assertEquals(FinePartitaController.Esito.VITTORIA, finePartitaController.verificaPartitaTerminata(),
        "La partita è terminata per vittoria");
    }

    /**
     * Test del metodo verificaPartitaTerminata() della classe FinePartitaController.
     * Assicura che la partita sia terminata per tempo scaduto quando il tempo
     * è scaduto.
     */
    @Test
    @DisplayName("Assicura che la partita sia terminata per tempo scaduto quando il tempo"
    + " è scaduto")
    void testVerificaPartitaTerminataTempoScaduto() {
        Tempo tempo = partita.getTempo();
        tempo.setScaduto(true);
        assertEquals(FinePartitaController.Esito.TEMPO_SCADUTO, finePartitaController.verificaPartitaTerminata(),
        "La partita è terminata per tempo scaduto");
    }
}

