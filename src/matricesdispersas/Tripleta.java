package matricesdispersas;

import javax.swing.JOptionPane;

public class Tripleta {

    private int filas;
    private int columnas;
    private int cantDatos = 0;
    // private int mat[][];
    private int trip[][];

    public Tripleta() {

    }

    public Tripleta(int cantDatos3, int filas, int columnas) {
        trip = new int[cantDatos3][3];
        trip[0][0] = filas;
        trip[0][1] = columnas;
        trip[0][2] = cantDatos3;

    }

    public Tripleta(int[][] mat) {
        // int[][] auxMat = mat;
        cantDatos = calcularCantDatos(mat);
        trip = new int[cantDatos + 1][3];
        columnas = mat.length; // Cambie entre columnas y filas 
        filas = mat[0].length;
        generarTripleta(mat);
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

//    public int[][] getMat() {
//        return mat;
//    }
//
//    public void setMat(int[][] mat) {
//        this.mat = mat;
//    }
    public int[][] getTrip() {
        return trip;
    }

    public void setTrip(int[][] trip) {
        this.trip = trip;
    }

    private int calcularCantDatos(int mat[][]) {
        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (mat[i][j] != 0) {
                    cantDatos++;
                }
            }
        }
        return cantDatos;
    }

    private void generarTripleta(int mat[][]) {
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

    public void redimensionar(int x) {
        cantDatos = cantDatos + x;
        int aux[][] = new int[cantDatos + 1][3];
        aux[0][0] = filas;
        aux[0][1] = columnas;
        aux[0][2] = cantDatos;
        for (int i = 1; i < (cantDatos + 1); i++) {
            for (int j = 0; j < 3; j++) {
                aux[i][j] = trip[i][j];
            }
        }
        trip = aux;
    }

    public void mostrarTripleta() {
        //  for (int i = 0; i <= cantDatos; i++) {
        // System.out.print(trip[i][0] + "\t" + trip[i][1] + "\t" + trip[i][2]);
        //System.out.println("");
        //       }

        String Tripleta = "";
        int i = 0;
        if (trip[i][2] != 0) {
            for (i = 0; i < (cantDatos + 1); i++) {
                for (int j = 0; j < 3; j++) {
                    Tripleta += trip[i][j];
                    Tripleta += "         ";
                }

                Tripleta += "\n";

            }
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

    public void insertarDato(int row, int col, int data) {
        int i = 1;
        while (i < (cantDatos + 1) && trip[i][0] < row) {
            i = i + 1;
        }
        while (i < (cantDatos + 1) && trip[i][0] == row && trip[i][1] < col) {
            i = i + 1;
        }
        if (i < (cantDatos + 1) && trip[i][0] == row && trip[i][1] == col) {
            JOptionPane.showMessageDialog(null, "Ya existe un dato en la posición indicada");
        } else {
            redimensionar(1); //Envia 1 para aumentar en una fila en la tripleta
            for (int k = cantDatos; k > i; k--) {
                trip[k][0] = trip[k - 1][0];
                trip[k][1] = trip[k - 1][1];
                trip[k][2] = trip[k - 1][2];
            }
            trip[i][0] = row;
            trip[i][1] = col;
            trip[i][2] = data;
        }
        mostrarTripleta();
    }

    public void eliminar(int row, int col) {
        int i = 1;
        while (i < (cantDatos + 1) && trip[i][0] < row) {
            i = i + 1;
        }
        while (i < (cantDatos + 1) && trip[i][0] == row && trip[i][1] < col) {
            i = i + 1;
        }
        System.out.println(cantDatos);
        for (int k = i; k < (cantDatos); k++) {
            trip[k][0] = trip[k + 1][0];
            trip[k][1] = trip[k + 1][1];
            trip[k][2] = trip[k + 1][2];
        }
        redimensionar(-1);
        mostrarTripleta();
    }

    public void eliminar(int data) {
        int i = 0;

        while (i < cantDatos) {
            if (i < cantDatos && trip[i][2] == data) {
                for (int k = i; k < (cantDatos); k++) {
                    trip[k][0] = trip[k + 1][0];
                    trip[k][1] = trip[k + 1][1];
                    trip[k][2] = trip[k + 1][2];
                }
                redimensionar(-1);
                mostrarTripleta();
            }
            i++;
        }
    }

    public void sumarTripleta(Tripleta T2) {

        int cantDatos3 = trip[0][0] * trip[0][1];
        Tripleta tripSuma = new Tripleta(cantDatos3, T2.getFilas(), T2.getColumnas());

        int i = 1, j = 1, k = 1;

        while (k < (cantDatos3 + 1) && i < cantDatos || j < T2.cantDatos) {
            if (trip[i][0] == T2.trip[j][0] && trip[i][1] == T2.trip[j][1]) {
                tripSuma.trip[k][0] = trip[i][0];
                tripSuma.trip[k][1] = trip[i][1];
                tripSuma.trip[k][2] = trip[i][2] + T2.trip[j][2];
                if (i < cantDatos || j < T2.cantDatos) {
                    i++;
                    j++;
                    k++;
                }
                

            } else if (trip[i][0] == T2.trip[j][0] && trip[i][1] < T2.trip[j][1]) {
                tripSuma.trip[k][0] = trip[i][0];
                tripSuma.trip[k][1] = trip[i][1];
                tripSuma.trip[k][2] = trip[i][2];
                if (i < cantDatos) {
                    i++;
                    k++;
                }
                

            } else if (trip[i][0] == T2.trip[j][0] && trip[i][1] > T2.trip[j][1]) {
                tripSuma.trip[k][0] = T2.trip[j][0];
                tripSuma.trip[k][1] = T2.trip[j][1];
                tripSuma.trip[k][2] = T2.trip[j][2];
                if (j < T2.cantDatos) {
                    j++;
                    k++;
                }
                

            } else if (trip[i][0] < T2.trip[j][0] && trip[i][1] == T2.trip[j][1]) {
                tripSuma.trip[k][0] = trip[i][0];
                tripSuma.trip[k][1] = trip[i][1];
                tripSuma.trip[k][2] = trip[i][2];
                if (i < cantDatos) {
                    i++;
                    k++;
                }
                

            } else if (trip[i][0] > T2.trip[j][0] && trip[i][1] == T2.trip[j][1]) {
                tripSuma.trip[k][0] = T2.trip[j][0];
                tripSuma.trip[k][1] = T2.trip[j][1];
                tripSuma.trip[k][2] = T2.trip[j][2];
                if (j < T2.cantDatos) {
                    j++;
                    k++;
                }
                

            } else if (trip[i][0] < T2.trip[j][0] && trip[i][1] < T2.trip[j][1]) {
                tripSuma.trip[k][0] = trip[i][0];
                tripSuma.trip[k][1] = trip[i][1];
                tripSuma.trip[k][2] = trip[i][2];
                if (i < cantDatos) {
                    i++;
                    k++;
                }
                

            } else {
                tripSuma.trip[k][0] = T2.trip[j][0];
                tripSuma.trip[k][1] = T2.trip[j][1];
                tripSuma.trip[k][2] = T2.trip[j][2];
                if (j < T2.cantDatos) {
                    j++;
                    k++;
                }
                

            }

        }
        cantDatos3 = k;
        tripSuma.mostrarTripleta();
    }

}
