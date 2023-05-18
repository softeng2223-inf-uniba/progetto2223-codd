
package it.uniba.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Classe per l'acquisizione dell'input da tastiera.
 */
public final class Input {

    private static List<String> listaCompletaComandi =
    riempiComandi("/gioca", "/esci", "/facile", "/medio", "/difficile",
    "/help", "/mostralivello", "/mostranavi", "/svelagriglia");

    private static List<String> listaComandiPartitaNonIniziata =
    riempiComandi("/gioca", "/esci", "/facile", "/medio", "/difficile", "/help", "/mostralivello");

    private static List<String> listaComandiPartitaInCorso =
    riempiComandi("/esci", "/help", "/mostralivello", "/mostranavi", "/svelagriglia");


    /**
     * Costruttore privato senza parametri (la classe non è istanziabile).
     */
    private Input() {
    }

    /**
     * Metodo per l'acquisizione corretta dell'input da tastiera con controllo di contesto.
     * @param stato enumerativo che rappresenta lo stato corrente della partita.
     * @return la stringa del comando letta in input.
     */
    public static String acquisisci(final Partita.StatoPartita stato) {

        Scanner tastiera = new Scanner(System.in, "utf-8");
        String input;
        boolean corretto;

        do {
            corretto = false;
            System.out.print("\n\n\nInserisci a capo un comando:\n> ");
            input = tastiera.nextLine().toLowerCase();

            if (!listaCompletaComandi.contains(input)) {
                System.out.println("\nNon capisco, usa un comando tra quelli disponibili... "
                + "\n(scrivere /help per visualizzare la lista dei comandi)");
            } else {

                switch (stato) {
                    case IN_CORSO:
                        if (!listaComandiPartitaInCorso.contains(input)) {
                            System.out.println("\n: Non puoi usare questo comando ora!");
                        } else {
                            corretto = true;
                        }
                    break;
                    case NON_INIZIATA:
                        if (!listaComandiPartitaNonIniziata.contains(input)) {
                            System.out.println("\n: Non puoi usare questo comando ora!");
                        } else {
                            corretto = true;
                        }
                    break;

                    default:
                    break;
                }
            }
        } while (!corretto);

        return input;
    }

    /**
     * Metodo per l'acquisizione corretta della conferma di uscita dal gioco.
     * @return il booleano che rappresenta la risposta (true = SI, false = NO).
     */
    public static boolean acquisisciConferma() {

        Scanner tastiera = new Scanner(System.in, "utf-8");
        String input;
        boolean conferma = false;

        do {
            System.out.print("\nInserisci SI per confermare oppure NO per restare nel gioco:\n> ");
            input = tastiera.nextLine().toLowerCase();

            if (input.equals("si")) {
                conferma = true;
                break;
            } else if (input.equals("no")) {
                conferma = false;
                break;
            } else {
                System.out.println("\nNon capisco...");
            }

        } while (true);

        return conferma;
    }

    /**
     * Metodo che riempie una lista con le stringhe passate in input.
     * @param comandi stringhe con le quali riempire la lista.
     * @return la lista contenente le stringhe passate.
     */
    public static List<String> riempiComandi(final String... comandi) {

        List<String> listaComandi = Arrays.asList(comandi);

        return listaComandi;
    }


}
