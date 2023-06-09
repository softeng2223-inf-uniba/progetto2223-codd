package it.uniba.app;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <Boundary>
 * Classe che fornisce una interfaccia generica di acquisizione corretta dei
 * comandi
 * dell'utente da tastiera.
 */
public class InputUI {

    private static final List<String> LISTA_COMANDI_COMPLETA = Arrays.asList(
            "/gioca", "/esci", "/facile", "/medio", "/difficile",
            "/help", "/mostralivello", "/mostranavi", "/svelagriglia", "/tentativi",
            "/standard", "/large", "/extralarge", "/tempo",
            "/mostratempo", "/mostragriglia", "/mostratentativi", "/abbandona");
    private static final List<String> LISTA_COMANDI_AMMESSI_SESSIONE = Arrays.asList(
            "/gioca", "/esci", "/facile", "/medio", "/difficile",
            "/help", "/mostralivello", "/mostranavi", "/tentativi",
            "/standard", "/large", "/extralarge", "/tempo");
    private static final List<String> LISTA_COMANDI_AMMESSI_PARTITA = Arrays.asList(
            "/help", "/mostralivello", "/mostranavi", "/svelagriglia",
            "/mostratempo", "/mostragriglia", "/mostratentativi", "/abbandona");
    private static final List<String> LISTA_COMANDI_CON_NUMERO = Arrays.asList("/facile", "/medio", "/difficile",
            "/tentativi", "/tempo");
    private static final List<String> LISTA_COMANDI_CON_NUMERO_SPECIALI = Arrays.asList("/tentativi", "/tempo");

    private static final List<String> LETTERE = Arrays.asList("abcdefghijklmnopqrstuvwxyz".split(""));
    private static final Pattern TENTATIVO_REGEX = Pattern.compile("[a-zA-Z]-[0-9]{1,2}");

    /**
     * Enumerativo che rappresenta lo stato corrente del gioco
     * distinguendo due contesti: PARTITA e SESSIONE.
     */
    public enum StatoGioco {
        PARTITA, SESSIONE;
    }

    /**
     * Enumerativo che rappresenta il tipo di comando inserito
     * dall'utente, distinguendo: AZIONE o TENTATIVO.
     */
    public enum TipoComando {
        AZIONE, TENTATIVO;
    }

    /**
     * Costruttore vuoto.
     */
    public InputUI() {
    }

    /**
     * Metodo che acquisisce un comando dell'utente da tastiera (AZIONE o TENTATIVO)
     * e ne controlla la correttezza relativamente al contesto.
     * Nel caso di un tentativo, verifica che sia corretto rispetto alle dimensioni
     * della griglia, date da limite.
     * Restituisce il comando letto suddiviso in due token.
     *
     *
     * @param tastiera
     * @param contesto
     * @param limite
     *
     * @return array di 2 stringhe, ciascuna un token del comando letto.
     */
    public String[] acquisisciComando(final Scanner tastiera, final StatoGioco contesto, final int limite) {

        String[] comando = new String[2];
        String input;

        while (true) {
            System.out.print("\n\n\n> Inserisci a capo un comando:\n-> ");
            input = tastiera.nextLine().toLowerCase().trim();
            String[] inputTokens;

            Matcher m = TENTATIVO_REGEX.matcher(input);
            if (!m.matches()) {
                inputTokens = input.split("\\s");
                int numTokens = inputTokens.length;
                if (numTokens > 2) {
                    System.out.println("\n: Il comando inserito ha troppe parole!");
                } else {
                    if (numTokens == 2) {
                        comando = inputTokens;
                    } else {
                        comando[0] = inputTokens[0];
                        comando[1] = null;
                    }
                    if (verificaComando(comando, contesto)) {
                        break;
                    }
                }

            } else if (contesto == StatoGioco.PARTITA) {
                inputTokens = input.split("-");

                int colonna = LETTERE.indexOf(inputTokens[0]);
                int riga = Integer.parseInt(inputTokens[1]) - 1;

                if (colonna < limite && (riga >= 0 && riga < limite)) {
                    comando = inputTokens;
                    break;
                } else {
                    System.out.println("\n: Le coordinate specificate sono fuori dalla griglia!");
                }
            } else {
                System.out.println("\n: Per effettuare un tentativo devi prima iniziare una partita!");
            }
        }

        return comando;
    }

    /**
     * Metodo che acquisisce un comando dell'utente da tastiera (solo AZIONE) e ne
     * controlla la correttezza relativamente al contesto.
     * Restituisce il comando letto suddiviso in due token.
     *
     * @param tastiera
     * @param contesto
     *
     * @return array di 2 stringhe, ciascuna un token del comando letto.
     */
    public String[] acquisisciComando(final Scanner tastiera, final StatoGioco contesto) {

        String[] comando = new String[2];
        String input;

        while (true) {
            System.out.print("\n\n\n> Inserisci a capo un comando:\n-> ");
            input = tastiera.nextLine().toLowerCase().trim();
            String[] inputTokens;

            Matcher m = TENTATIVO_REGEX.matcher(input);
            if (!m.matches()) {
                inputTokens = input.split("\\s");
                int numTokens = inputTokens.length;
                if (numTokens > 2) {
                    System.out.println("\n: Il comando inserito ha troppe parole!");
                } else {
                    if (numTokens == 2) {
                        comando = inputTokens;
                    } else {
                        comando[0] = inputTokens[0];
                        comando[1] = null;
                    }
                    if (verificaComando(comando, contesto)) {
                        break;
                    }
                }

            } else {
                System.out.println("\n: Per effettuare un tentativo devi prima iniziare una partita!");
            }
        }

        return comando;
    }


    /**
     * Metodo che, dato un comando e il contesto di gioco, verifica che il comando
     * sia corretto prima
     * rispetto al contesto, e poi sintatticamente.
     *
     * @param comando
     * @param contesto
     *
     * @return true se il comando è corretto, false altrimenti.
     */
    private boolean verificaComando(final String[] comando, final StatoGioco contesto) {

        if (!LISTA_COMANDI_COMPLETA.contains(comando[0])) {
            System.out.println("\n: Il comando inserito non esiste!");
            return false;
        }
        switch (contesto) {
            case PARTITA:
                if (!LISTA_COMANDI_AMMESSI_PARTITA.contains(comando[0])) {
                    System.out.println("\n: Il comando inserito non può essere utilizzato in questo contesto!");
                    return false;
                }
                break;
            case SESSIONE:
                if (!LISTA_COMANDI_AMMESSI_SESSIONE.contains(comando[0])) {
                    System.out.println("\n: Il comando inserito non può essere utilizzato in questo contesto!");
                    return false;
                }
                break;
            default:
                break;
        }
        if (!LISTA_COMANDI_CON_NUMERO.contains(comando[0]) && comando[1] != null) {
            System.out.println("\n: Il comando inserito non può essere accompagnato da un numero!");
            return false;
        }
        if (LISTA_COMANDI_CON_NUMERO_SPECIALI.contains(comando[0]) && comando[1] == null) {
            System.out.println("\n: Il comando inserito non può essere utilizzato senza specificare un numero!");
            return false;
        }
        if (LISTA_COMANDI_CON_NUMERO.contains(comando[0]) && comando[1] != null) {
            return verificaNumero(comando[1]);
        }

        return true;
    }

    /**
     * Metodo che, data una stringa, verifica che la stringa contenga effettivamente
     * un numero positivo.
     *
     * @param numero
     *
     * @return true se la stringa contiene un numero positivo, false altrimenti.
     */
    private boolean verificaNumero(final String numero) {

        try {
            int i = Integer.parseInt(numero);
            if (i > 0) {
                return true;
            } else {
                System.out.println("\n: Il numero inserito non può essere negativo!");
                return false;
            }
        } catch (NumberFormatException e) {
            System.out.println("\n: Il comando inserito prevede che accanto sia specificato un numero, non altro!");
            return false;
        }
    }

    /**
     * Metodo che verifica se un comando passato è o meno un TENTATIVO.
     *
     * @param comando
     *
     * @return true se il comando è un tentativo, false altrimenti.
     */
    public boolean isTentativo(final String[] comando) {

        if (LETTERE.contains(comando[0])) {
            return true;
        }
        return false;
    }

    /**
     * Metodo che acquisisce una conferma dell'utente, relativamente ad una
     * richiesta.
     *
     * @param tastiera
     *
     * @return true se la conferma è positiva, false altrimenti.
     */
    public boolean acquisisciConferma(final Scanner tastiera) {

        String input;
        boolean conferma = false;

        while (true) {
            System.out.println("\n> Inserisci SI per confermare, altrimenti NO:\n-> ");
            input = tastiera.nextLine().toLowerCase().trim();

            if (input.equals("si")) {
                conferma = true;
                break;
            } else if (input.equals("no")) {
                conferma = false;
                break;
            } else {
                System.out.println("\n: Non capisco...");
            }
        }

        return conferma;
    }
}
