package it.uniba.boundaries;


/**
 * <Boundary>
 * Classe che contiene la descrizione del gioco e la lista dei comandi.
 */
public class HelpUI {

    private static final String DESCRIZIONE =
      "+--------------------------------------------------------------------------------------------------+\n"
    + "|                                            BATTLESHIP                                            |\n"
    + "|                                                                                                  |\n"
    + "|          Il gioco della battaglia navale prevede la generazione di una griglia                   |\n"
    + "|                    all'interno della quale saranno posizionate 10 navi.                          |\n"
    + "|                  L'obiettivo del gioco è quello di trovarle e affondarle,                        |\n"
    + "|                indicando ad ogni turno le coordinate della cella che vuoi colpire.               |\n"
    + "|          Se riuscirai ad affondarle tutte, entro il numero massimo di tentativi falliti          |\n"
    + "|              (sarà impostato di default il livello facile), avrai vinto la partita.              |\n"
    + "|                  Mi raccomando! Le coordinate devono essere espresse nella forma:                |\n"
    + "|                                       <colonna> - <riga>                                         |\n"
    + "+--------------------------------------------------------------------------------------------------+";

    private static final String COMANDI =
      "|                                             COMANDI                                              |\n"
    + "|                                                                                                  |\n"
    + "|              Di seguito ti lascio una lista dei COMANDI che potrai utilizzare:                   |\n"
    + "|              - /help : per visualizzare di nuovo questo messaggio.                               |\n"
    + "|              - /gioca : per avviare una nuova partita                                            |\n"
    + "|              - /esci : per uscire dal gioco                                                      |\n"
    + "|              - /facile : per impostare il livello della partita a facile                         |\n"
    + "|                         (MAX 50 tentativi falliti)                                               |\n"
    + "|              - /medio : per impostare il livello della partita a media                           |\n"
    + "|                         (MAX 30 tentativi falliti)                                               |\n"
    + "|              - /difficile : per impostare il livello della partita a difficile                   |\n"
    + "|                             (MAX 10 tentativi falliti)                                           |\n"
    + "|              - /mostralivello : per mostrare il livello di difficoltà impostato                  |\n"
    + "|              - /mostranavi : per mostrare il tipo, la dimensione e il numero                     |\n"
    + "|                              delle navi che devi ancora affondare                                |\n"
    + "|              - /svelagriglia : per mostrare la griglia e tutte le navi posizionate               |\n"
    + "|              - /facile <numero> : per impostare a <numero> il numero massimo di                  |\n"
    + "|                                   tentativi falliti per il livello facile                        |\n"
    + "|              - /medio <numero> : per impostare a <numero> il numero massimo di                   |\n"
    + "|                                  tentativi falliti per il livello medio                          |\n"
    + "|              - /difficile <numero> : per impostare a <numero> il numero massimo di               |\n"
    + "|                                      tentativi falliti per il livello difficile                  |\n"
    + "|              - /tentativi <numero>: per impostare a <numero> il numero massimo di                |\n"
    + "|                                     tentativi falliti, indipendentemente                         |\n"
    + "|                                     dal livello                                                  |\n"
    + "|              - /standard : per impostare la dimensione della griglia                             |\n"
    + "|                            a 10 x 10 (il default)                                                |\n"
    + "|              - /large : per impostare la dimensione della griglia a 18 x 18                      |\n"
    + "|              - /extralarge : per impostare la dimensione della griglia a 26 x 26                 |\n"
    + "|              - /tempo <numero> : per impostare a <numero> il numero di minuti                    |\n"
    + "|                                  a disposizione                                                  |\n"
    + "|              - /mostratempo : per visualizzare il numero di minuti trascorsi                     |\n"
    + "|                               nel gioco e il numero di minuti ancora disponibili                 |\n"
    + "|              - <lettera> - <numero> : per effettuare un tentativo per colpire una nave.          |\n"
    + "|                                       Il range varia in base alla dimensione della griglia       |\n"
    + "|                                       - Standard: <A-J>   -   <1-10>  (ad esempio B-7)           |\n"
    + "|                                       - Large:    <A-R>   -   <1-18>  (ad esempio N-16)          |\n"
    + "|                                       - Extralarge: <A-Z> -   <1-26>  (ad esempio U-24)          |\n"
    + "|              - /mostragriglia : per mostrare una griglia durante la partita                      |\n"
    + "|                                 con la situazione attuale delle navi non affondate               |\n"
    + "|              - /mostratentativi : per visualizzare il numero di tentativi già                    |\n"
    + "|                                   effettuati, il numero di tentativi falliti                     |\n"
    + "|                                   e il numero massimo di tentativi falliti                       |\n"
    + "|              - /abbandona : per abbandonare una partita attualmente in corso                     |\n"
    + "+--------------------------------------------------------------------------------------------------+\n\n";

    /**
     * Metodo che stampa a video la descrizione del gioco e la lista dei comandi.
     */
    public void displayHelp() {
        System.out.println(DESCRIZIONE);
        System.out.println(COMANDI);
    }
}
