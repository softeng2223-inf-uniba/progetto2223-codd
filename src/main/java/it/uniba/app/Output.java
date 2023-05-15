package it.uniba.app;

/**
 * classe che si occupa di definire le stringhe di output e stamparle.
 */
public final class Output {

    private static final String BENVENUTO =
    "                             BENVENUTO NEL GIOCO DELLA BATTAGLIA NAVALE                             \n";

    private static final String DESCRIZIONE =
      " +-------------------------------------------------------------------------------------------------+\n"
    + "|                                                                                                  |\n"
    + "|          Il gioco della battaglia navale prevede la generazione di una griglia 10 x 10,          |\n"
    + "|                    all'interno della quale saranno posizionate 10 navi.                          |\n"
    + "|                  L'obiettivo del gioco è quello di trovarle e affondarle,                        |\n"
    + "|                indicando ad ogni turno le coordinate della cella che vuoi colpire.               |\n"
    + "|          Se riuscirai ad affondarle tutte, entro il numero massimo di tentativi falliti          |\n"
    + "|              (sarà impostato di default il livello facile), avrai vinto la partita.              |\n"
    + "|                  Mi raccomando! Le coordinate devono essere espresse nella forma:                |\n"
    + "|                                         [colonna][riga]                                          |\n"
    + "| (dove le colonne sono inidicate dalle lettere dalla A alla J, e le righe dai numeri da 1 a 10).  |\n"
    + "+--------------------------------------------------------------------------------------------------+";

    private static final String COMANDI =
      "|                                                                                                  |\n"
    + "|                                               COMANDI                                            |\n"
    + "|                Di seguito ti lascio una lista dei COMANDI che potrai utilizzare:                 |\n"
    + "|                      - /help : per visualizzare di nuovo questo messaggio.                       |\n"
    + "|                      - /gioca : per avviare una nuova partita                                    |\n"
    + "|                      - /esci : per uscire dal gioco                                              |\n"
    + "|                      - /facile : per impostare il livello della partita a facile                 |\n"
    + "|                                  (MAX 50 tentativi falliti)                                      |\n"
    + "|                      - /medio : per impostare il livello della partita a media                   |\n"
    + "|                                 (MAX 30 tentativi falliti)                                       |\n"
    + "|                      - /difficile : per impostare il livello della partita a difficile           |\n"
    + "|                                    (MAX 10 tentativi falliti)                                    |\n"
    + "|                      - /mostralivello : per mostrare il livello di difficoltà impostato          |\n"
    + "|                      - /mostranavi : per mostrare il tipo, la dimensione e il numero             |\n"
    + "|                                      delle navi che devi ancora affondare                        |\n"
    + "|                      - /svelagriglia : per mostrare la griglia e tutte le navi posizionate       |\n"
    + "+--------------------------------------------------------------------------------------------------+\n\n";

    /**
     * costruttore vuoto privato (non è necessario istanziare la classe).
     */
    private Output() {
    }

    /**
     * stampa la stringa di Benvenuto.
     */
    public static void stampaBenvenuto() {
        System.out.println(BENVENUTO);
    }

    /**
     * stampa la stringa della descrizione del gioco.
     */
    public static void stampaDescrizione() {
        System.out.println(DESCRIZIONE);
    }

    /**
     * stampa la stringa dei comandi del gioco.
     */
    public static void stampaComandi() {
        System.out.println(COMANDI);
    }

    /**
     * stampa la descrizione del gioco e dei comandi (da usare col comando /help).
     */
    public static void stampaHelp() {
        stampaDescrizione();
        stampaComandi();
    }

    /**
     * stampa le stringhe di benvenuto, descrizione e comandi del gioco ad inizio partita.
     */
    public static void stampaInizioGioco() {
        stampaBenvenuto();
        stampaDescrizione();
        stampaComandi();
    }
}
