package it.uniba.app;

import java.util.ArrayList;
import java.util.List;

/**
 * <Entity>
 * Classe astratta che rappresenta la nave.
 */
public abstract class Nave {

    private int numeroCelleOccupate;
    private boolean affondata = false;
    private List<Griglia.Cella> listaCelleOccupate = new ArrayList<>();

    /**
     * Costruttore vuoto.
     */
    public Nave() {
        // do nothing
    }

    /**
     * Costruttore che imposta il numero di celle occupate dalla nave.
     * @param numCelleOccupate
     */
    public Nave(final int numCelleOccupate) {
        setNumeroCelleOccupate(numCelleOccupate);
    }

    /**
     * Getter del numero delle celle occupate dalla nave.
     * @return numeroCelleOccupate
     */
    public final int getNumeroCelleOccupate() {
        return this.numeroCelleOccupate;
    }

    /**
     * Metodo che restituisce true se la nave è stata affondata, false altrimenti.
     * @return affondata
     */
    public final boolean isAffondata() {
        return this.affondata;
    }

    /**
     * Setter del numero delle celle occupate dalla nave.
     * @param numCelleOccupate
     */
    public final void setNumeroCelleOccupate(final int numCelleOccupate) {
        this.numeroCelleOccupate = numCelleOccupate;
    }

    /**
     * Setter dell'attributo booleano affondata.
     * @param isAffondata
     */
    public final void setAffondata(final boolean isAffondata) {
        this.affondata = isAffondata;
    }

    /**
     * Getter della lista delle celle occupate dalla nave.
     * @return listaCelleOccupate
     */
    public List<Griglia.Cella> getListaCelleOccupate() {
        return this.listaCelleOccupate;
    }

    /**
     * Metodo che aggiunge una cella data alla lista di celle occupate dalla nave.
     * @param cella
     */
    public void aggiungiAListaCelleOccupate(final Griglia.Cella cella) {
        this.listaCelleOccupate.add(cella);
    }

    /**
     * Metodo che rimuove una cella dalla lista di celle.
     * @param cella
     */
    public void rimuoviDaListaCelleOccupate(final Griglia.Cella cella) {
        int i = -1;
        int cont = 0;
        for (Griglia.Cella c : this.listaCelleOccupate) {
            if (c == cella) {
                i = cont;
            }
            cont++;
        }
        try {
            this.listaCelleOccupate.remove(i);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("La cella non è presente nella lista.");
        }
    }
}
