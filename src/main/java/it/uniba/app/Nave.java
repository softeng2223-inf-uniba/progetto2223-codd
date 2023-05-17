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
     * getter della lista delle celle occupate dalla nave.
     * @return listaCelleOccupate
     */
    public final List<Griglia.Cella> getListaCelleOccupate() {
        return listaCelleOccupate;
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
     * setter della lista delle celle occupate dalla nave.
     * @param celleOccupate
     */
    public final void setListaCelleOccupate(final List<Griglia.Cella> celleOccupate) {
        this.listaCelleOccupate = celleOccupate;
    }


}
