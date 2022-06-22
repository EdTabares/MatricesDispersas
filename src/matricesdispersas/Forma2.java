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
        String message = "";
        Nodo p = punta.getLf();
        while (p != punta) {
            for (int i = 0; i < punta.getFila(); i++) {
                for (int j = 0; j < punta.getColumna(); j++) {
                    if (p.getFila() ==i && p.getColumna() == j) {
                        message = message + p.getDato() + "   ";
                        p = p.getLf();
                    } else{
                        message+=0+"   ";
                    }                   
                }
                message+="\n";
            }
            p=punta;
        }
        //JOptionPane.showMessageDialog(null, message, "***FORMA 2***", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "*** FORMA2 ***\n\n" + message);
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

    public void insertarDato() {
//        int k = 0;
//        Nodo p = punta.getLf();
//        Nodo ant = new Nodo();
//        ant=punta;
//        Nodo x = new Nodo();
//        x.setFila(row);
//        x.setColumna(col);
//        x.setDato(data);
//
//        while (p != punta) {
//            if (p.getFila() == row && p.getColumna() == col) {
//                JOptionPane.showMessageDialog(null, "Ya existe un dato en la posición indicada");
//            } else if (p.getFila() == x.getFila()) {
//                if (p.getColumna() > x.getColumna()) {
//                    ant.setLf(x);
//                    x.setLf(p);
//                } else {
//                    ant = p;
//                    p = p.getLf();
//                }
//            } else {
//                ant = p;
//                p = p.getLf();
//            }
//        }
//        
//        while (p != punta){
//            
//        }
    } //Primer Intento de insertar, Malo
    
    public void insertarDato(int row, int col, int data) {
        Nodo p = punta.getLf(), antF = punta, antC = punta;
        while (p != punta && p.getFila() < row) {
            antF = p;
            p.getLf();
        }
        while (p != punta && p.getFila() == row && p.getColumna() < col) {
            antF = p;
            p = p.getLf();
        }
        p = punta.getLc();
        while (p != punta && p.getColumna() < col) {
            antC = p;
            p = p.getLc();
        }
        while (p != punta && p.getColumna() == col && p.getFila() < row) {
            antC = p;
            p = p.getLc();
        }
        if (p != punta && p.getColumna() == col && p.getFila() == row) {
            JOptionPane.showMessageDialog(null, "Ya existe un dato en la posición indicada");
        } else {
            Nodo x = new Nodo(row, col, data);
            x.setLf(antF.getLf());
            antF.setLf(x);
            x.setLc(p);
            antC.setLc(x);
        }
    }
    
    public void eliminar(int dato){
        
    }
}
