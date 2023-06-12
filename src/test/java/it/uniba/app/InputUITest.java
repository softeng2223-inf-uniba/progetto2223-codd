package it.uniba.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Classe di test di InputUITest.
 */
class InputUITest {

    private InputUI inputUI;

    /**
     * Metodo che istanzia l'oggetto della classe InputUI.
     */
    @BeforeEach
    void setUp() {
        inputUI = new InputUI();
    }

    /**
     * Test del metodo AcquisisciConferma della classe InputUITest.
     * Il valore aspettato è vero qualora l'input sia SI.
     */
    @Test
    @DisplayName("Restituisce vero se l'input è 'si'")
    void testAcquisisciConfermaSi() {
        String input = "SI";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        assertTrue(inputUI.acquisisciConferma(new Scanner(System.in, "UTF-8")), "L'input deve essere 'si'");

    }

    /**
     * Test del metodo AcquisisciConferma della classe InputUITest.
     * Il valore aspettato è falso qualora l'input sia NO.
     */
    @Test
    @DisplayName("Restituisce falso se l'input è 'no'")
    void testAcquisisciConfermaNo() {
        String input = "NO";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        assertFalse(inputUI.acquisisciConferma(new Scanner(System.in, "UTF-8")), "L'input deve essere 'no'");
    }

    /**
     * Test del metodo isTentativo della classe InputUITest.
     * Il valore aspettato è vero qualora il tentativo sia valido.
     */
    @Test
    @DisplayName("Restituisce true se il tentativo è valido")
    void testIsTentativoValido() {
        String[] comando = {"b", "5"};
        assertTrue(inputUI.isTentativo(comando), "Il tentativo deve essere valido");
    }

    /**
     * Test del metodo isTentativo della classe InputUITest.
     * Il valore aspettato è falso qualora il tentativo sia non valido.
     */
    @Test
    @DisplayName("Restituisce false se il tentativo non è valido")
    void testIsTentativoNonValido() {
        String[] comando = {"/mostranavi"};
        assertFalse(inputUI.isTentativo(comando), "Il tentativo non deve essere valido");
    }

    /**
     * Test del metodo AcquisisciComando della classe InputUITest.
     * Ci si aspetta che la stringa inserita in input
     * sia utlizzabile in sessione.
     */
    @Test
    @DisplayName("Assicura che il comando sia valido in sessione")
    void testAcquisisciComandoAzioneValidaInSessione() {
        String input = "/help";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        String[] expected = {"/help", null};
        assertArrayEquals(expected, inputUI.acquisisciComando(new Scanner(System.in, "UTF-8"),
        InputUI.StatoGioco.SESSIONE), "Il comando deve essere valido in sessione");
    }

    /**
     * Test del metodo AcquisisciComando della classe InputUITest.
     * Ci si aspetta che la stringa inserita in input
     * sia utilizzabile in partita.
     */
    @Test
    @DisplayName("Assicura che il comando sia valido in partita")
    void testAcquisisciComandoAzioneValidaInPartita() {
        String input = "/mostranavi";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        String[] expected = {"/mostranavi", null};
        assertArrayEquals(expected, inputUI.acquisisciComando(new Scanner(System.in, "UTF-8"),
        InputUI.StatoGioco.PARTITA), "Il comando deve essere valido in partita");
    }

    /**
     * Test del metodo AcquisisciComando della classe InputUITest.
     * Ci si aspetta che la stringa inserita in input
     * sia un tentativo valido in partita.
     */
    @Test
    @DisplayName("Assicura che il tentativo sia valido in partita")
    void testAcquisisciComandoTentativoValido() {
        String input = "A-1";
        InputStream in = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        String[] expected = {"a", "1"};
        assertArrayEquals(expected, inputUI.acquisisciComando(new Scanner(System.in, "UTF-8"),
        InputUI.StatoGioco.PARTITA), "Il tentativo deve essere valido in partita");
    }

    /**
     * Test del metodo AcquisisciComando della classe InputUITest.
     * Ci si aspetta che la stringa inserita in input
     * sia un comando con numero valido in sessione.
     */
    @Test
    @DisplayName("Assicura che il comando con numero sia valido in sessione")
    void testAcquisisciComandoConNumeroSessioneValido() {
        String input = "/tentativi 10";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        String[] result = inputUI.acquisisciComando(scanner, InputUI.StatoGioco.SESSIONE);
        assertArrayEquals(new String[]{"/tentativi", "10"}, result,
        "Il comando con numero deve essere valido in sessione");
    }

}

