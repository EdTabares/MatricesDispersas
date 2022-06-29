package matricesdispersas;

import javax.swing.JOptionPane;

public class Forma1 {

    Nodo punta;

    public void Forma1() {
        punta = null;
    }

    public Nodo getPunta() {
        return punta;
    }

    public void generarForma1(int M[][], int n, int m) {
        paso1(n, m);
        paso2(M);
        paso3();
    }

    private void paso1(int n, int m) {

        int may = 0;
        Nodo x, p;

        if (n < m) {
            may = m;
        } else {
            may = n;
        }

        punta = new Nodo(n, m, 0);
        p = punta;
        for (int i = 0; i < may; i++) {
            x = new Nodo(i, i, 0); //fila, columna, dato
            p.setLiga(x);
            p = x;
        }
        p.setLiga(punta);
    }

    private void paso2(int Mat[][]) {

        Nodo x, p = punta.getLiga(), q = p;

        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[i].length; j++) {
                if (Mat[i][j] != 0) {
                    x = new Nodo(i, j, Mat[i][j]); //fila, columna, dato
                    x.setLf(x);
                    x.setLc(x);
                    q.setLf(x);
                    q = x;
                }
            }
            q.setLf(p);
            p = p.getLiga();
            q = p;
        }
    }

    private void paso3() {

        Nodo RC = punta.getLiga(), ant = RC, p = RC, q = p.getLf();
        while (RC != punta) {
            p = punta.getLiga();
            while (p != punta) {
                q = p.getLf();

                while (q != p) {
                    if (q.getColumna() == RC.getColumna()) {
                        ant.setLc(q);
                        ant = q;
                    }
                    q = q.getLf();
                }
                p = p.getLiga();
            }
            q.setLc(ant);
            RC = RC.getLiga();
            ant = RC;
        }
    }

    public void mostrar() {

        Nodo p = punta.getLiga(), q = p.getLf();
        String message = "Punta: --->";
        while (p != punta) {
            q = p.getLf();
            while (q != p) {
                message = message + "|" + q.getDato() + "| --->";
                q = q.getLf();
            }
            message = message + " ";
            p = p.getLiga();
        }

        JOptionPane.showMessageDialog(null, "*** FORMA1 ***\n\n" + message);

    }

    public void sumarFilas() {
        Nodo p = punta.getLiga(), rc;
        int cont = 0, suma = 0;
        String aux = "", message = "";

        while (p != punta) {
            rc = p;
            p = p.getLf();
            suma = 0;
            while (p != rc) {
                suma = suma + p.getDato();
                p = p.getLf();
            }
            message = "La suma de la Fila " + cont + " es: " + suma;
            aux += String.valueOf(message) + "\n";
            cont++;
            p = rc.getLiga();
        }
        JOptionPane.showMessageDialog(null, "**** SUMAS FILAS ****\n\n" + aux);

    }

    public void sumarColumnas() {
        Nodo p = punta.getLiga(), rc;
        int cont = 0, suma = 0;
        String aux = "", message = "";

        while (p != punta) {
            rc = p;
            p = p.getLc();
            suma = 0;
            while (p != rc) {
                suma = suma + p.getDato();
                p = p.getLc();
            }
            message = "La suma de la Columna " + cont + " es: " + suma;
            aux += String.valueOf(message) + "\n";
            cont++;
            p = rc.getLiga();
        }
        JOptionPane.showMessageDialog(null, "**** SUMAS COLUMNAS ****\n\n" + aux);
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
