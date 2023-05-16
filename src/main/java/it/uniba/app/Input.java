
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

        Scanner tastiera = new Scanner(System.in);
        String input;
        boolean corretto;

        do {
            corretto = false;
            System.out.print("\nInserisci a capo un comando: \n> ");
            input = tastiera.nextLine().toLowerCase();

            if (!listaCompletaComandi.contains(input)) {
                System.out.print("\nNon capisco, usa un comando tra quelli disponibili... "
                + "(scrivere /help per visualizzare la lista dei comandi)\n");
            } else {

                switch (stato) {
                    case IN_CORSO:
                        if (!listaComandiPartitaInCorso.contains(input)) {
                            System.out.println("\nNon puoi usare questo comando ora!\n");
                        } else {
                            corretto = true;
                        }
                    break;
                    case NON_INIZIATA:
                        if (!listaComandiPartitaNonIniziata.contains(input)) {
                            System.out.println("\nNon puoi usare questo comando ora!\n");
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
     * Metodo che riempie una lista con le stringhe passate in input.
     * @param comandi stringhe con le quali riempire la lista.
     * @return la lista contenente le stringhe passate.
     */
    public static List<String> riempiComandi(final String... comandi) {

        List<String> listaComandi = new ArrayList<>();
        listaComandi = Arrays.asList(comandi);

        return listaComandi;
    }


}
