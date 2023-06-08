package it.uniba.app;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {

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
    public void testParseInputComandoValido() {
        InputUI inputUI = new InputUI();
        boolean result = inputUI.parseInput("/gioca", InputUI.StatoGioco.SESSIONE);
        assertTrue(result);
    }

    @Test
    public void testParseInputComandoConTreToken() {
        InputUI inputUI = new InputUI();
        boolean result = inputUI.parseInput("/comando param1 param2", InputUI.StatoGioco.SESSIONE);
        assertFalse(result);
    }

    @Test
    public void testAcquisisciComandoPartitaValido() {
        String input = "/svelagriglia";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        InputUI inputUI = new InputUI();
        String[] result = inputUI.acquisisciComando(scanner, InputUI.StatoGioco.PARTITA);
        assertEquals("/svelagriglia", result[0]);
        assertNull(result[1]);
    }

    @Test
    public void testAcquisisciComandoSessioneValido() {
        String input = "/gioca";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        InputUI inputUI = new InputUI();
        String[] result = inputUI.acquisisciComando(scanner, InputUI.StatoGioco.SESSIONE);
        assertEquals("/gioca", result[0]);
        assertNull(result[1]);
    }

    @Test
    public void testAcquisisciComandoTentativoValido() {
        String input = "A-1";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(inputStream);
        InputUI inputUI = new InputUI();
        String[] result = inputUI.acquisisciComando(scanner, InputUI.StatoGioco.PARTITA, 10);
        assertEquals("A", result[0]);
        assertEquals("1", result[1]);
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

    @Test
    void testVerificaComandoValidoInSessione() {

	    InputUI inputUI = new InputUI();
        String[] comando = {"/gioca", null};

        InputUI.StatoGioco contesto = InputUI.StatoGioco.SESSIONE;

        boolean result = InputUI.verificaComando(comando, contesto);

        assertTrue(result);
    }

    @Test
    void testVerificaComandoValidoInPartita() {

	    InputUI inputUI = new InputUI();
        String[] comando = {"/mostranavi", null};
        InputUI.StatoGioco contesto = InputUI.StatoGioco.PARTITA;

        boolean result = InputUI.verificaComando(comando, contesto);

        assertTrue(result);
    }

    @Test
    void testVerificaComandoInvalidoInSessione() {

	    InputUI inputUI = new InputUI();
        String[] comando = {"/nonvalido", null};
        InputUI.StatoGioco contesto = InputUI.StatoGioco.SESSIONE;

        boolean result = InputUI.verificaComando(comando, contesto);

        assertFalse(result);
    }

    @Test
    void testVerificaComandoInvalidoInPartita() {

	    InputUI inputUI = new InputUI();
        String[] comando = {"/nonvalido", null};
        InputUI.StatoGioco contesto = InputUI.StatoGioco.PARTITA;

        boolean result = InputUI.verificaComando(comando, contesto);

        assertFalse(result);
    }

    @Test
    void testVerificaComandoNonPermessoInSessione() {
	
	    InputUI inputUI = new InputUI();
        String[] comando = {"/svelagriglia", null};
        InputUI.StatoGioco contesto = InputUI.StatoGioco.SESSIONE;

        boolean result = InputUI.verificaComando(comando, contesto);

        assertFalse(result);
    }

    @Test
    void testVerificaComandoNonPermessoInPartita() {

	    InputUI inputUI = new InputUI();
        String[] comando = {"/gioca", null};
        InputUI.StatoGioco contesto = InputUI.StatoGioco.PARTITA;

        boolean result = InputUI.verificaComando(comando, contesto);

        assertFalse(result);
    }

    @Test
    void testVerificaComandoSpecialeSenzaNumero() {

	    InputUI inputUI = new InputUI();
        String[] comando = {"/tentativi", null};
        InputUI.StatoGioco contesto = InputUI.StatoGioco.SESSIONE;

        boolean result = InputUI.verificaComando(comando, contesto);

        assertFalse(result);
    }

    @Test
    void testVerificaComandoSpecialeConNumeroNegativo() {

	    InputUI inputUI = new InputUI();
        String[] comando = {"/tentativi", "-5"};
        InputUI.StatoGioco contesto = InputUI.StatoGioco.SESSIONE;

        boolean result = InputUI.verificaComando(comando, contesto);

        assertFalse(result);
    }

    @Test
    void testVerificaComandoSpecialeConNumero() {

	    InputUI inputUI = new InputUI();
        String[] comando = {"/tentativi", "15"};
        InputUI.StatoGioco contesto = InputUI.StatoGioco.SESSIONE;

        boolean result = InputUI.verificaComando(comando, contesto);

        assertTrue(result);
    }

    @Test
    void testVerificaComandoValidoAncheConNumero() {

	    InputUI inputUI = new InputUI();
        String[] comando = {"/facile", "10"};
        InputUI.StatoGioco contesto = InputUI.StatoGioco.SESSIONE;

        boolean result = InputUI.verificaComando(comando, contesto);

        assertTrue(result);
    }

    @Test
    void testVerificaComandoValidoAncheSenzaNumero() {

	    InputUI inputUI = new InputUI();
        String[] comando = {"/facile", null};
        InputUI.StatoGioco contesto = InputUI.StatoGioco.SESSIONE;

        boolean result = InputUI.verificaComando(comando, contesto);

        assertTrue(result);
    }

    @Test
    void testVerificaComandoNonValidoConNumero() {

	    InputUI inputUI = new InputUI();
        String[] comando = {"/gioca", "10"};
        InputUI.StatoGioco contesto = InputUI.StatoGioco.SESSIONE;

        boolean result = InputUI.verificaComando(comando, contesto);

        assertTrue(result);
    }


    @Test
    void testVerificaNumeroValido() {

	    InputUI inputUI = new InputUI();
        String numero = "10";

        boolean result = InputUI.verificaNumero(numero);

        assertTrue(result);
    }

    @Test
    void testVerificaNumeroInvalido() {

	    InputUI inputUI = new InputUI();
        String numero = "-5";

        boolean result = InputUI.verificaNumero(numero);

        assertFalse(result);
    }
}