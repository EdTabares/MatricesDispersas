package matricesdispersas;

import javax.swing.JOptionPane;

public class Forma2 {

    Nodo punta;

    public void Forma2() {
        punta = null;
    }

    public Nodo getPunta() {
        return punta;
    }

    public boolean vacia() {
        if (punta == null) {
            return true;
        } else {
            return false;
        }
    }

    public void generarForma2(int mat[][], int row, int col) {
        int i = 0, cont = 0;
        Nodo primer = new Nodo();
        Nodo p = new Nodo();
        Nodo ant = new Nodo(); //where it is used¿?
        primer.setFila(row);
        primer.setColumna(col);
        punta = primer; // Es necesario?
        p = punta;

        while (i < row) { //Creación de Nodos para los datos y se liga por fila (Lf)
            int j = 0;
            while (j < col) {
                if (mat[i][j] != 0) {
                    Nodo x = new Nodo();
                    x.setFila(i);
                    x.setColumna(j);
                    x.setDato(mat[i][j]);
                    p.setLf(x);
                    p = x;
                }
                j++;
            }
            i++;
        }
        p.setLf(punta); //El último nodo se liga a la punta para que quede circular
        ant = punta;

        while (cont < col) { //punta.getColumna()
            p = punta.getLf();
            while (p != punta) {
                if (p.getColumna() == cont) {
                    ant.setLc(p);
                    ant = p;
                }
                p = p.getLf();
            }
            cont++;
        }
        ant.setLc(punta);
    }

    public void mostrar() {

    }

    public void sumarFilas() {
        //System.out.println(punta.getColumna() + " " + punta.getFila());
        Nodo p = punta.getLf();
        int k = 0, suma = 0;
        String aux = "", message = "";

        while (k < punta.getFila()) {
            suma = 0;
            p = punta.getLf();
            while (p != punta) {
                if (k == p.getFila()) {
                    suma = suma + p.getDato();
                }
                p = p.getLf();
            }
            message = "La suma de la Fila " + k + " es: " + suma;
            aux += String.valueOf(message) + "\n";
            k++;
        }
        JOptionPane.showMessageDialog(null, "**** SUMAS FILAS ****\n\n" + aux);
    }

    public void sumarColumnas() {
        Nodo p = punta.getLf();
        int k = 0, suma = 0;
        String aux = "", message = "";

        while (k < punta.getColumna()) {
            suma = 0;
            p = punta.getLc();
            while (p != punta) {
                if (k == p.getColumna()) {
                    suma = suma + p.getDato();
                }
                p = p.getLc();
            }
            message = "La suma de la Columna " + k + " es: " + suma;
            aux += String.valueOf(message) + "\n";
            k++;
        }
        JOptionPane.showMessageDialog(null, "**** SUMAS COLUMNAS ****\n\n" + aux);
    }
    
    public void insertarDato(int row, int col, int data){
        int k=0;
        Nodo p = punta.getLf();
        
        while (p!=punta) {            
            if (p.getFila()==row && p.getColumna()==col) {
                JOptionPane.showMessageDialog(null, "Ya existe un dato en la posición indicada");
            }else{
                Nodo x = new Nodo();
                x.setFila(row);
                x.setColumna(col);
                x.setDato(data);
            }
        }
    }
}
