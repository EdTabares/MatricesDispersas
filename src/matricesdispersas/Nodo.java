package matricesdispersas;

public class Nodo {

    private int dato;
    private int fila;
    private int columna;
    private Nodo lc;
    private Nodo lf;
    private Nodo liga;

    public Nodo() {
        dato = 0;
        fila = 0;
        columna = 0;
        lc = null;
        lf = null;
        liga = null;
    }

    public Nodo(int row, int col, int data) {
        dato = data;
        fila = row;
        columna = col;
        lc = null;
        lf = null;
        liga = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public Nodo getLc() {
        return lc;
    }

    public void setLc(Nodo lc) {
        this.lc = lc;
    }

    public Nodo getLf() {
        return lf;
    }

    public void setLf(Nodo lf) {
        this.lf = lf;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }
    
    

}
