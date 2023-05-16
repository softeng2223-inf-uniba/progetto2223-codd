package it.uniba.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
