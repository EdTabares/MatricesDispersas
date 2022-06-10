package matricesdispersas;

import javax.swing.JOptionPane;

public class Tripleta {

    private int filas;
    private int columnas;
    private int cantDatos = 0;
    private int mat[][];
    private int trip[][];

    public Tripleta() {

    }

    public Tripleta(int n, int m, int cantDatos, int mat[][]) {
        filas = n;
        columnas = m;
        this.cantDatos = cantDatos;
        trip = new int[cantDatos][3];
        trip[0][0] = filas;
        trip[0][1] = columnas;
        trip[0][2] = this.cantDatos; // Validar si lo inicialiamos en cero según el Blog ¿?
    }

    public Tripleta(int[][] mat) {
        this.mat = mat;
        cantDatos = calcularCantDatos();
        trip = new int[cantDatos + 1][3];
        columnas = this.mat.length; // Cambie entre columnas y filas 
        filas = this.mat[0].length;
        generarTripleta();
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getCantDatos() {
        return cantDatos;
    }

    public void setCantDatos(int cantDatos) {
        this.cantDatos = cantDatos;
    }

    public int[][] getMat() {
        return mat;
    }

    public void setMat(int[][] mat) {
        this.mat = mat;
    }

    public int[][] getTrip() {
        return trip;
    }

    public void setTrip(int[][] trip) {
        this.trip = trip;
    }

    private int calcularCantDatos() {
        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != 0) {
                    cantDatos++;
                }
            }
        }
        return cantDatos;
    }

    private void generarTripleta() {
        trip[0][0] = filas;
        trip[0][1] = columnas;
        trip[0][2] = cantDatos;

        int k = 1;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (mat[i][j] != 0 && k <= cantDatos) {
                    trip[k][0] = i;
                    trip[k][1] = j;
                    trip[k][2] = mat[i][j];
                    k++;
                }
            }
        }
    }

    public void mostrarTripleta() {
        //  for (int i = 0; i <= cantDatos; i++) {
        // System.out.print(trip[i][0] + "\t" + trip[i][1] + "\t" + trip[i][2]);
        //System.out.println("");
        //       }

        String Tripleta = "";
        for (int i = 0; i < (cantDatos + 1); i++) {
            for (int j = 0; j < 3; j++) {
                Tripleta += trip[i][j];
                Tripleta += "         ";
            }
            Tripleta += "\n";
        }
        JOptionPane.showMessageDialog(null, "*** TRIPLETA ***\n\n" + Tripleta);
    }

    public void sumarFilas() {
        String aux = "", message = "";
        int k = 0;
        while (k < filas) {
            int sumaFila = 0;
            for (int i = 0; i < (cantDatos + 1); i++) {
                if (trip[i][0] == k) {
                    sumaFila = sumaFila + trip[i][2];
                }
            }
            message = "La suma de la Fila " + k + " es: " + sumaFila;
            aux += String.valueOf(message) + "\n";
            k++;
        }
        JOptionPane.showMessageDialog(null, "**** SUMAS FILAS ****\n\n" + aux);
    }

    public void sumarColumnas() {
        String aux = "", message = "";
        int k = 0;
        while (k < columnas) {
            int sumaCol = 0;
            for (int i = 0; i < (cantDatos + 1); i++) {
                if (trip[i][1] == k) {
                    sumaCol = sumaCol + trip[i][2];
                }
            }
            message = "La suma de la Columna " + k + " es: " + sumaCol;
            aux += String.valueOf(message) + "\n";
            k++;
        }
        JOptionPane.showMessageDialog(null, "**** SUMAS COLUMNAS ****\n\n" + aux);
    }
    
    public void insertarDato(int row, int col, int data){
        //Esto es una prueba de git
    }

}
