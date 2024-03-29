package it.uniba.controllers;

import it.uniba.entities.Partita;
import it.uniba.entities.Griglia;
import it.uniba.entities.Nave;
import it.uniba.entities.Tempo;
import java.util.List;

/**
 * <Control>
 * Classe che gestisce la fine della partita.
 */
public final class FinePartitaController {

    private Partita partita = null;

    /**
     * Enumerativo che rappresenta l'esito di una partita.
     */
    public enum Esito {
        VITTORIA, SCONFITTA, TEMPO_SCADUTO;
    }

    /**
     * Costruttore che inizializza l'attributo partita.
     * @param part
     */
    public FinePartitaController(final Partita part) {
        this.partita = part;
    }

    /**
     * Metodo che verifica se la partita è terminata e ne restituisce l'esito.
     * @return esito
     */
    public Esito verificaPartitaTerminata() {
        if (isTempoTerminato()) {
            return Esito.TEMPO_SCADUTO;
        }
        if (isTentativiTerminati()) {
            return Esito.SCONFITTA;
        }
        if (isAllNaviAffondate()) {
            return Esito.VITTORIA;
        }
        return null;
    }

    /**
     * Metodo che verifica se i tentativi sono terminati.
     * @return true se i tentativi sono terminati, false altrimenti
     */
    public boolean isTentativiTerminati() {
        final int tentFall = this.partita.getTentFalliti();
        final int maxTent = this.partita.getMaxTent();
        return tentFall == maxTent;
    }

    /**
     * Metodo che verifica se tutte le navi sono state affondate.
     * @return true se la lista delle navi è vuota, false altrimenti
     */
    public boolean isAllNaviAffondate() {
        Griglia griglia = this.partita.getGriglia();
        List<Nave> listaNavi = griglia.getListaNaviPresenti();
        return listaNavi.isEmpty();
    }

    /**
     * Metodo che verifica se il tempo è terminato.
     * @return true se il tempo è terminato, false altrimenti
     */
    public boolean isTempoTerminato() {
        ProprietaController propContr = new ProprietaController();
        if (propContr.isTempoImpostato()) {
            Tempo tempo = this.partita.getTempo();
            TempoController tempContr = new TempoController(tempo);
            return tempContr.isTempoScaduto();
        }
        return false;
    }

    /**
     * Metodo che verifica se la partita è terminata.
     * @return true se la partita è terminata, false altrimenti
     */
    public boolean isPartitaTerminata() {
        return isTentativiTerminati() || isAllNaviAffondate() || isTempoTerminato();
    }

    /**
     * Metodo che termina la partita.
     */
    public void terminaPartita() {
        ProprietaController propContr = new ProprietaController();
        propContr.reimpostaTempo();
    }
}
