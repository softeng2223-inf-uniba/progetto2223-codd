package it.uniba.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InputTest {

    @Test
    @DisplayName("Restituisce vero se l'input è 'si'")
    void testAcquisisciConfermaSi() {
        InputUI inputUI = new InputUI();
        String input = "SI";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertTrue(inputUI.acquisisciConferma(new Scanner(System.in,"UTF-8")));
    }

    @Test
    @DisplayName("Restituisce falso se l'input è 'no'")
    void testAcquisisciConfermaNo() {
        InputUI inputUI = new InputUI();
        String input = "NO";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertFalse(inputUI.acquisisciConferma(new Scanner(System.in,"UTF-8")));
    }

    @Test
    @DisplayName("Restituisce true se il tentativo è valido")
    void testIsTentativoValido() {
        InputUI inputUI = new InputUI();
        String[] comando = {"A", "1"};
        assertTrue(inputUI.isTentativo(comando));
    }

    @Test
    @DisplayName("Restituisce false se il tentativo non è valido")
    void testIsTentativoNonValido() {
        InputUI inputUI = new InputUI();
        String[] comando = {"/mostranavi"};
        assertFalse(inputUI.isTentativo(comando));
    }

    @Test
    @DisplayName("Assicura che il comando sia valido in sessione")
    void testAcquisisciComandoAzioneValidaInSessione() {
        InputUI inputUI = new InputUI();
        String input = "/help";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] expected = {"/help", null};
        assertArrayEquals(expected, inputUI.acquisisciComando(new Scanner(System.in,"UTF-8"), InputUI.StatoGioco.SESSIONE));
    }

    @Test
    @DisplayName("Assicura che il comando sia valido in partita")
    void testAcquisisciComandoAzioneValidaInPartita() {
        InputUI inputUI = new InputUI();
        String input = "/mostranavi";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] expected = {"/mostranavi", null};
        assertArrayEquals(expected, inputUI.acquisisciComando(new Scanner(System.in,"UTF-8"), InputUI.StatoGioco.PARTITA));
    }

    @Test
    @DisplayName("Assicura che il tentativo sia valido in partita")
    void testAcquisisciComandoTentativoValido() {
        InputUI inputUI = new InputUI();
        String input = "A-1";
        int limite = 10;
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] expected = {"A", "1"};
        assertArrayEquals(expected, inputUI.acquisisciComando(new Scanner(System.in,"UTF-8"), InputUI.StatoGioco.PARTITA, limite));
    }


    @Test
    @DisplayName("Assicura che il comando con numero sia valido in sessione")
    void testAcquisisciComandoConNumeroSessioneValido() {
        String input = "/tentativi 10";
        int limite = 10;
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        InputUI inputUI = new InputUI();
        String[] result = inputUI.acquisisciComando(scanner, InputUI.StatoGioco.SESSIONE, limite);
        assertEquals("/tentativi", result[0]);
        assertEquals("10", result[1]);
    }

}
