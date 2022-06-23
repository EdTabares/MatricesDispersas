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
        String message = "Ligado Filas\n";
        Nodo p = punta.getLf();
        while (p != punta) {
            message =   message +" [ "+ p.getDato() + " ] "+ " ---> ";
            p= p.getLf();
        }
        
        message = message + "\n\n"+"Ligado Columnas\n";
        p = punta.getLc();
        while (p != punta) {
            message =   message +" [ "+ p.getDato() + " ] "+ " ---> ";
            p= p.getLc();
        }
        
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


    public void insertarDato(int row, int col, int data) {
        Nodo p = punta.getLf(), antF = punta, antC = punta;
        while (p != punta && p.getFila() < row) {
            antF = p;
            p = p.getLf();
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
        mostrar();
    }

    public void eliminar(int dato) { 
        Nodo p = new Nodo(), antF = punta, antC = punta;
        int aux = 0;
        p = punta.getLf();

        do {
            if (p.getDato() == dato) {
                antF.setLf(p.getLf());
                aux++;
            }
            antF = p;
            p = p.getLf();
        } while (p != punta);

        p = p.getLc();
        do {
            if (p.getDato() == dato) {
                antC.setLc(p.getLc());
                aux++;
            }
            antC = p;
            p = p.getLc();
        } while (p != punta);

        if (aux != 0) {
            mostrar();
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el dato");
        }
        mostrar();
    }

    public void eliminar(int row, int col) {
        Nodo p = new Nodo();
        Nodo antF = new Nodo();
        Nodo antC = new Nodo();
        Nodo q = new Nodo();
        p = punta.getLf();

        while (p != punta && p.getFila() < row) {
            p = p.getLf();
        }

        while (p != punta && p.getFila() == row && p.getColumna() < col) {
            p = p.getLf();
        }

        if (p != punta && p.getFila() == row && p.getColumna() == col && p.getDato() != 0) {
            q = p;
            antF = q;
            p = p.getLf();
            while (q != p) {
                antF = p;
                p = p.getLf();
            }
            antF.setLf(p.getLf());

            antC = q;
            p = p.getLc();
            while (q != p) {
                antC = p;
                p = p.getLc();
            }
            antC.setLc(p.getLc());
        } else {
            JOptionPane.showMessageDialog(null, "En la posición indicada no existe dato");
        }
        mostrar();
    }

    public void sumarForma2(Forma2 X) {
         JOptionPane.showMessageDialog(null, " Minimo un 5.0 ");
    }
    

}


