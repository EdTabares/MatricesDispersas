package matricesdispersas;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MatricesDispersas {

    public static void main(String[] args) {

        menuppal();
    }

    public static void menuppal() {
        int opcion = 0;
        String menu = "***MENU PRINCIPAL MATRICES DISPERSAS***\n"
                + "1- MD Tripleta\n"
                + "2- MD Forma 1\n"
                + "3- MD Forma 2\n"
                + "0- Salir";
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcion) {
                    case 1:
                        menuTripleta();
                        break;
                    case 2:
                        menuForma1();
                        break;
                    case 3:
                        menuForma2();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Opción no válida");
            }
        } while (opcion != 0);
    }

    public static void menuTripleta() {
        int[][] mat = leerArchivo("Matriz.txt");
        int row, col, data;
        Tripleta T = new Tripleta(mat);
        int opcion = -1;
        String menu = "***MENU TRIPLETA***\n"
                + "1- Mostrar Tripleta\n"
                + "2- Suma de Filas\n"
                + "3- Suma de Columnas\n"
                + "4- Insertar Dato\n"
                + "5- Eliminar Dato\n"
                + "6- Sumar 2 tripletas\n"
                + "7- Volver al menú anterior\n"
                + "0- Salir";

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcion) {
                    case 1:
                        T.mostrarTripleta();
                        break;
                    case 2:
                        T.sumarFilas();
                        break;
                    case 3:
                        T.sumarColumnas();
                        break;
                    case 4:
                        row = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de fila (Considerela desde 0)"));
                        col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de Columna (Considerela desde 0)"));
                        data = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato"));
                        if (row > T.getFilas() || col > T.getColumnas()) {
                            JOptionPane.showMessageDialog(null, "La fila o Columna esta por fuera del tamaño de la Matriz");
                        } else {
                            T.insertarDato(row, col, data);
                        }
                        break;
                    case 5:
                        int op = -1;
                        String menudos = "***ELIMINAR***\n"
                                + "1- Eliminar por posición\n"
                                + "2- Eliminar por dato\n"
                                + "3- Volver al menú anterior\n"
                                + "0- Salir";

                        do {
                            try {
                                op = Integer.parseInt(JOptionPane.showInputDialog(menudos));
                                switch (op) {
                                    case 1:
                                        row = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de fila (Considerela desde 0)"));
                                        col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de Columna (Considerela desde 0)"));
                                        if (row > T.getFilas() || col > T.getColumnas()) {
                                            JOptionPane.showMessageDialog(null, "La fila o Columna esta por fuera del tamaño de la Matriz");
                                        } else {
                                            T.eliminar(row, col);
                                        }
                                        break;
                                    case 2:
                                        data = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato que desea eliminar"));
                                        if (data == 0) {
                                            JOptionPane.showMessageDialog(null, "Ingrese un valor diferente de cero");
                                        } else {
                                            T.eliminar(data);
                                        }
                                        break;
                                    case 3:
                                        menuTripleta();
                                        break;
                                    case 0:
                                        System.exit(0);
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "opcion no válida");
                                }
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "opcion no válida");
                            }
                        } while (op != 0);
                    case 6:
                        int[][] mat2 = leerArchivo("MatrizDos.txt");
                        Tripleta T2 = new Tripleta(mat2);
                        if (T.getFilas() != T2.getFilas() || T.getColumnas() != T.getColumnas()) {
                            JOptionPane.showMessageDialog(null, "No válido. Las matrices deben tener el mismo tamaño");
                        } else {
                            T.sumarTripleta(T2);
                        }
                        break;
                    case 7:
                        menuppal();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "opcion no válida");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "opcion no válida");
            }
        } while (opcion != 0);
    }

    public static void menuForma1() {
        int[][] mat = leerArchivo("Matriz.txt");
        int row = mat.length;
        int col = mat[0].length;
        int data;
        Forma1 F1 = new Forma1();
        F1.generarForma1(mat, row, col);
        int opcion = -1;
        String menu = "***MENU FORMA 1***\n"
                + "1- Mostrar Forma 2\n"
                + "2- Suma de Filas\n"
                + "3- Suma de Columnas\n"
                + "4- Insertar Dato\n"
                + "5- Eliminar Dato\n"
                + "6- Sumar 2 Matrices\n"
                + "7- Volver al menú anterior\n"
                + "0- Salir";

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcion) {
                    case 1:
                        F1.mostrar();
                        break;
                    case 2:
                        F1.sumarFilas();
                        break;
                    case 3:
                        F1.sumarColumnas();
                        break;
                    case 4:
                        row = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de fila (Considerela desde 0)"));
                        col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de Columna (Considerela desde 0)"));
                        data = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato"));

                        if (row > F1.getPunta().getFila() || col > F1.getPunta().getColumna()) {
                            JOptionPane.showMessageDialog(null, "La fila o Columna esta por fuera del tamaño de la Matriz");
                        } else {
                            F1.insertarDato(row, col, data);
                        }
                        break;
                    case 5:
                        int op = -1;
                        String menudos = "***ELIMINAR***\n"
                                + "1- Eliminar por posición\n"
                                + "2- Eliminar por dato\n"
                                + "3- Volver al menú anterior\n"
                                + "0- Salir";
                        do {
                            try {
                                op = Integer.parseInt(JOptionPane.showInputDialog(menudos));
                                switch (op) {
                                    case 1:
                                        row = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de fila (Considerela desde 0)"));
                                        col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de Columna (Considerela desde 0)"));
                                        if (row > F1.getPunta().getFila() || col > F1.getPunta().getColumna()) {
                                            JOptionPane.showMessageDialog(null, "La fila o Columna esta por fuera del tamaño de la Matriz");
                                        } else {
                                            F1.eliminar(row, col);
                                        }
                                        break;
                                    case 2:
                                        data = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato que desea eliminar"));
                                        if (data == 0) {
                                            JOptionPane.showMessageDialog(null, "Ingrese un valor diferente de cero");
                                        } else {
                                            F1.eliminar(data);
                                        }
                                        break;
                                    case 3:
                                        menuForma2();
                                        break;
                                    case 0:
                                        System.exit(0);
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "opcion no válida");
                                }
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "opcion no válida");
                            }
                        } while (op != 0);
                    case 6:
                        int[][] mat2 = leerArchivo("MatrizDos.txt");
                        row = mat2.length;
                        col = mat2[0].length;
                        Forma1 X = new Forma1();
                        X.generarForma1(mat, row, col);
                        if (F1.getPunta().getFila() != X.getPunta().getFila() || F1.getPunta().getColumna() != X.getPunta().getColumna()) {
                            JOptionPane.showMessageDialog(null, "No válido. Las matrices deben tener el mismo tamaño");
                        } else {
                            F1.sumarForma1(X);
                        }
                        break;
                    case 7:
                        menuppal();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "opcion no válida");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "opcion no válida");
            }
        } while (opcion != 0);

    }

    public static void menuForma2() {

        int[][] mat = leerArchivo("Matriz.txt");
        int row = mat.length;
        int col = mat[0].length;
        int data;
        Forma2 F2 = new Forma2();
        F2.generarForma2(mat, row, col);
        int opcion = -1;
        String menu = "***MENU FORMA 2***\n"
                + "1- Mostrar Forma 2\n"
                + "2- Suma de Filas\n"
                + "3- Suma de Columnas\n"
                + "4- Insertar Dato\n"
                + "5- Eliminar Dato\n"
                + "6- Sumar 2 Matrices\n"
                + "7- Volver al menú anterior\n"
                + "0- Salir";

        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
                switch (opcion) {
                    case 1:
                        F2.mostrar();
                        break;
                    case 2:
                        F2.sumarFilas();
                        break;
                    case 3:
                        F2.sumarColumnas();
                        break;
                    case 4:
                        row = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de fila (Considerela desde 0)"));
                        col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de Columna (Considerela desde 0)"));
                        data = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato"));
                        System.out.println(F2.getPunta().getFila() + " " + F2.getPunta().getColumna());
                        if (row > F2.getPunta().getFila() || col > F2.getPunta().getColumna()) {
                            JOptionPane.showMessageDialog(null, "La fila o Columna esta por fuera del tamaño de la Matriz");
                        } else {
                            F2.insertarDato(row, col, data);
                        }
                        break;
                    case 5:
                        int op = -1;
                        String menudos = "***ELIMINAR***\n"
                                + "1- Eliminar por posición\n"
                                + "2- Eliminar por dato\n"
                                + "3- Volver al menú anterior\n"
                                + "0- Salir";
                        do {
                            try {
                                op = Integer.parseInt(JOptionPane.showInputDialog(menudos));
                                switch (op) {
                                    case 1:
                                        row = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de fila (Considerela desde 0)"));
                                        col = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de Columna (Considerela desde 0)"));
                                        if (row > F2.getPunta().getFila() || col > F2.getPunta().getColumna()) {
                                            JOptionPane.showMessageDialog(null, "La fila o Columna esta por fuera del tamaño de la Matriz");
                                        } else {
                                            F2.eliminar(row, col);
                                        }
                                        break;
                                    case 2:
                                        data = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dato que desea eliminar"));
                                        if (data == 0) {
                                            JOptionPane.showMessageDialog(null, "Ingrese un valor diferente de cero");
                                        } else {
                                            F2.eliminar(data);
                                        }
                                        break;
                                    case 3:
                                        menuForma2();
                                        break;
                                    case 0:
                                        System.exit(0);
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "opcion no válida");
                                }
                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(null, "opcion no válida");
                            }
                        } while (op != 0);
                    case 6:
                        int[][] mat2 = leerArchivo("MatrizDos.txt");
                        row = mat2.length;
                        col = mat2[0].length;
                        Forma2 X = new Forma2();
                        X.generarForma2(mat, row, col);
                        if (F2.getPunta().getFila() != X.getPunta().getFila() || F2.getPunta().getColumna() != X.getPunta().getColumna()) {
                            JOptionPane.showMessageDialog(null, "No válido. Las matrices deben tener el mismo tamaño");
                        } else {
                            F2.sumarForma2(X);
                        }
                        break;
                    case 7:
                        menuppal();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "opcion no válida");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "opcion no válida");
            }
        } while (opcion != 0);
    }

    public static int[][] leerArchivo(String nameFile) {
        int[][] matrix = null;
        try {
            FileReader r = new FileReader(nameFile);
            BufferedReader buffer = new BufferedReader(r);

            String temp = "";
            ArrayList<String> lines = new ArrayList<>();

            while ((temp = buffer.readLine()) != null) {
                lines.add(temp);
            }
            String[] numbers = lines.get(0).split(",");
            int x = lines.size(); // Cantidad de lineas (Filas)
            int y = numbers.length; //Cantidad de números por linea (Columnas)            
            matrix = new int[x][y];

            //Llenamos la matriz linea por linea 
            for (int i = 0; i < x; i++) {
                String[] line = lines.get(i).split(",");
                for (int j = 0; j < y; j++) {
                    matrix[i][j] = Integer.parseInt(line[j]);
                    System.out.print(matrix[i][j] + " | ");
                }
                System.out.println("\n");
            }
            //  Tripleta t = new Tripleta(matrix);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Warning");
        }
        return matrix;
    }

}
