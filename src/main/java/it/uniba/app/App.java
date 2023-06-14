package it.uniba.app;
import it.uniba.boundaries;
import it.uniba.controllers;
import it.uniba.entities;

import java.util.Scanner;

/**
 * Classe Main dell'applicazione.
 */
public final class App {

    /**
     * Ottiene una stringa di saluto.
     *
     * @return La stringa "Ciao dal gioco della Battaglia Navale!".
     */
    public String getGreeting() {
        return "Ciao dal gioco della Battaglia Navale!";
    }

    /**
     * Metodo main dell'applicazione.
     * @param args Argomenti linea di comando.
     */
    public static void main(final String[] args) {
        HelpUI helpUI = new HelpUI();
        if (args.length > 0) {
            if (args[0].equals("--help") || args[0].equals("-h")) {
                helpUI.displayHelp();
                return;
            }
        }
        helpUI.displayHelp();
        Scanner tastiera = new Scanner(System.in, "utf-8");

        Proprieta prop = Proprieta.getIstanza();
        Livello liv = Livello.getIstanza();
        Tempo temp = Tempo.getIstanza();

        mainEngine(tastiera, prop, liv, temp);
        tastiera.close();
    }

    /**
     * Metodo che rappresenta il motore del gioco.
     * @param prop
     * @param liv
     * @param temp
     */
    private static void mainEngine(final Scanner tastiera,
        final Proprieta prop, final Livello liv, final Tempo temp) {

        String[] comando;
        InputUI input = new InputUI();
        InputUI.StatoGioco contesto = InputUI.StatoGioco.SESSIONE;

        LivelloController livContr = new LivelloController(liv);
        TempoController tempContr = new TempoController(temp);
        ProprietaController propContr = new ProprietaController(prop);

        LivelloUI livUI = new LivelloUI(livContr);
        TempoUI tempUI = new TempoUI(tempContr);
        ProprietaUI propUI = new ProprietaUI(propContr);
        HelpUI helpUI = new HelpUI();

        while (true) {
            comando = input.acquisisciComando(tastiera, contesto);
            switch (comando[0]) {
                case "/facile":
                case "/medio":
                case "/difficile":
                    if (livUI.isImpostazioneLivello(comando)) {
                        livUI.impostaLivello(comando);
                    } else {
                        livUI.impostaTentativiPerLivello(comando);
                    }
                break;
                case "/tentativi":
                    livUI.impostaTentativiPerLivelloPersonalizzato(comando);
                break;
                case "/mostralivello":
                    livUI.displayLivelloCorrente();
                break;
                case "/tempo":
                    tempUI.impostaTempoDiGioco(comando);
                break;
                case "/standard":
                case "/large":
                case "/extralarge":
                    propUI.impostaDimensioniGriglia(comando);
                break;
                case "/esci":
                    if (input.acquisisciConferma(tastiera)) {
                        return;
                    }
                break;
                case "/help":
                    helpUI.displayHelp();
                break;
                case "/gioca":
                    enginePartita(tastiera, liv, temp);
                break;
                default:
                break;
            }
        }
    }

    /**
     * Metodo che rappresenta il motore della partita.
     * @param tastiera
     * @param liv
     * @param temp
     */
    private static void enginePartita(final Scanner tastiera, final Livello liv, final Tempo temp) {

        String[] comando;
        InputUI input = new InputUI();
        InputUI.StatoGioco contesto = InputUI.StatoGioco.PARTITA;

        Partita partita = new Partita();

        TempoController tempContr = new TempoController(temp);
        LivelloController livContr = new LivelloController(liv);
        InizioPartitaController ipContr = new InizioPartitaController(partita);
        PartitaInCorsoController pcContr = new PartitaInCorsoController(partita);
        FinePartitaController fpContr = new FinePartitaController(partita);

        GrigliaUI grigliaUI = new GrigliaUI(pcContr);
        PartitaUI partitaUI = new PartitaUI(ipContr, pcContr, fpContr);
        TempoUI tempUI = new TempoUI(tempContr);
        LivelloUI livUI = new LivelloUI(livContr);
        HelpUI helpUI = new HelpUI();

        partitaUI.inizia();
        while (true) {
            comando = input.acquisisciComando(tastiera, contesto);
            if (input.isTentativo(comando)) {
                partitaUI.effettuaTentativo(comando);
            } else {
                switch (comando[0]) {
                    case "/mostratentativi":
                        partitaUI.displayTentativi();
                    break;
                    case "/mostratempo":
                        tempUI.displayTempo();
                    break;
                    case "/mostralivello":
                        livUI.displayLivelloCorrente();
                    break;
                    case "/mostragriglia":
                        grigliaUI.displayGriglia();
                    break;
                    case "/svelagriglia":
                        grigliaUI.displayGrigliaSvelata();
                    break;
                    case "/mostranavi":
                        partitaUI.displayNavi();
                    break;
                    case "/abbandona":
                        if (partitaUI.abbandona(tastiera)) {
                            return;
                        }
                    break;
                    case "/help":
                        helpUI.displayHelp();
                    break;
                    default:
                    break;
                }
            }
            if (partitaUI.isTerminata()) {
                break;
            }
        }

    }
}

