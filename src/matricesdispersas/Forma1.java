package matricesdispersas;

import javax.swing.JOptionPane;

public class Forma1 {

    Nodo punta;

    public void Forma1() {

    }

    public Nodo getPunta() {
        return punta;
    }

    public void generarForma1(int mat[][], int row, int col) {

    }

    public void mostrar() {
        String message = "Ligado Filas\n";
        Nodo p = punta.getLf();
        while (p != punta) {
            message = message + " [ " + p.getDato() + " ] " + " ---> ";
            p = p.getLf();
        }

        message = message + "\n\n" + "Ligado Columnas\n";
        p = punta.getLc();
        while (p != punta) {
            message = message + " [ " + p.getDato() + " ] " + " ---> ";
            p = p.getLc();
        }

        JOptionPane.showMessageDialog(null, "*** FORMA1 ***\n\n" + message);

    }

    public void sumarFilas() {

    }

    public void sumarColumnas() {

    }

    public void insertarDato(int row, int col, int data) {

    }

    public void eliminar(int dato) {

    }

    public void eliminar(int row, int col) {

    }

    public void sumarForma1(Forma1 X) {

    }

}
