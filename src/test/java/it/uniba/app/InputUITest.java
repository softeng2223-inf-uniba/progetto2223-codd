package it.uniba.app;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

    @Test
    public void testAcquisisciConfermaSi() {
        InputUI inputUI = new InputUI();
        String input = "SI";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertTrue(inputUI.acquisisciConferma(new Scanner(System.in)));
    }

    @Test
    public void testAcquisisciConfermaNo() {
        InputUI inputUI = new InputUI();
        String input = "NO";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertFalse(inputUI.acquisisciConferma(new Scanner(System.in)));
    }

    @Test
    public void testIsTentativoValido() {
        InputUI inputUI = new InputUI();
        String[] comando = {"A", "1"};
        assertTrue(inputUI.isTentativo(comando));
    }

    @Test
    public void testIsTentativoNonValido() {
        InputUI inputUI = new InputUI();
        String[] comando = {"/mostranavi"};
        assertFalse(inputUI.isTentativo(comando));
    }

    @Test
    public void testAcquisisciComandoAzioneValidaInSessione() {
        InputUI inputUI = new InputUI();
        String input = "/help";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] expected = {"/help", null};
        assertArrayEquals(expected, inputUI.acquisisciComando(new Scanner(System.in), InputUI.StatoGioco.SESSIONE));
    }

    @Test
    public void testAcquisisciComandoAzioneValidaInPartita() {
        InputUI inputUI = new InputUI();
        String input = "/mostranavi";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] expected = {"/mostranavi", null};
        assertArrayEquals(expected, inputUI.acquisisciComando(new Scanner(System.in), InputUI.StatoGioco.PARTITA));
    }

    @Test
    public void testAcquisisciComandoTentativoValido() {
        InputUI inputUI = new InputUI();
        String input = "A-1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String[] expected = {"A", "1"};
        assertArrayEquals(expected, inputUI.acquisisciComando(new Scanner(System.in), InputUI.StatoGioco.PARTITA, 10));
    }


    @Test
    public void testAcquisisciComandoConNumeroSessioneValido() {
        String input = "/tentativi 10";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        InputUI inputUI = new InputUI();
        String[] result = inputUI.acquisisciComando(scanner, InputUI.StatoGioco.SESSIONE, 10);
        assertEquals("/tentativi", result[0]);
        assertEquals("10", result[1]);
    }

}
