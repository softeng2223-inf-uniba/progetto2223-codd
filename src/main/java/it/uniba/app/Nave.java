package it.uniba.app;

import java.util.ArrayList;
import java.util.List;

/**
 * classe astratta che rappresenta la nave.
 */
public abstract class Nave {

    private int numeroCelleOccupate;
    private boolean affondata = false;
    private List<Griglia.Cella> listaCelleOccupate = new ArrayList<>();

    /**
     * costruttore vuoto.
     */
    public Nave() {
        // do nothing
    }

    /**
     * costruttore che imposta il numero di celle occupate dalla nave.
     * @param numCelleOccupate
     */
    public Nave(final int numCelleOccupate) {
        setNumeroCelleOccupate(numCelleOccupate);
    }

    /**
     * getter del numero delle celle occupate dalla nave.
     * @return numeroCelleOccupate
     */
    public final int getNumeroCelleOccupate() {
        return numeroCelleOccupate;
    }

    /**
     * metodo che restituisce true se la nave è stata affondata, false altrimenti.
     * @return affondata
     */
    public final boolean isAffondata() {
        return affondata;
    }

    /**
     * setter del numero delle celle occupate dalla nave.
     * @param numCelleOccupate
     */
    public final void setNumeroCelleOccupate(final int numCelleOccupate) {
        this.numeroCelleOccupate = numCelleOccupate;
    }

    /**
     * setter dell'attributo booleano affondata.
     * @param isAffondata
     */
    public final void setAffondata(final boolean isAffondata) {
        this.affondata = isAffondata;
    }

    /**
     * Metodo che aggiunge la cella passata alla lista di celle occupate dalla nave.
     * @param cella
     */
    public final void addToListaCelleOccupate(final Griglia.Cella cella) {
        this.listaCelleOccupate.add(cella);
    }


}
