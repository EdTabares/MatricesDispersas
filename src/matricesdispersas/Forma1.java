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

//    public Nodo generarForma1(int mat[][], int row, int col) {
//        int cont=0, aux=0, i=0, j=0;
//        Nodo primer = new Nodo(), registro, p, q, a;
//        punta = primer;
//        p = punta;
//        punta.setFila(row);
//        punta.setColumna(col);
//        
//        
//        //Step1 Generar lista de registro cabeza
//        if(row<=col){
//            while (i < col) {                
//                Nodo x = new Nodo();
//                p.setLiga(x);
//                x.setFila(i);
//                x.setColumna(j);
//                p=x;
//                i++;
//                j++;                        
//            }
//        } else{
//            while (i < row) {                
//                Nodo x = new Nodo();
//                p.setLiga(x);
//                x.setFila(i);
//                x.setColumna(j);
//                p=x;
//            }
//        }        
//        p.setLiga(punta);
//
//        //Step 2 Ligar por Fila
//        p=punta.getLiga();
//        while (p != punta) {            
//            if (p.getFila()==cont) {
//                if (cont < row && cont < col) {
//                    i = cont;
//                    registro = p;
//                    j= 0;
//                    while (j < col) {                        
//                        if (mat[i][j] != 0) {
//                            Nodo x = new Nodo();
//                            x.setFila(i);
//                            x.setColumna(j);
//                            x.setDato(mat[i][j]);
//                            p.setLf(x);
//                            p=x;
//                        }
//                        j++;
//                    }
//                    p.setLf(registro);
//                    p  = registro;
//                }
//            }
//            p = p.getLiga();
//            cont++;
//        }
//        
//        // Step 3 Liga por Columna
//        registro = punta.getLiga();
//        cont=0;
//        while (registro != punta) {            
//            p = punta.getLiga();
//            a = registro;
//            q = p.getLf();
//            while (p != punta) {                
//                while (q != p) {                    
//                    if (registro.getColumna() == q.getColumna()) {
//                        a.setLc(q);
//                        a = q;
//                    }
//                    q = q.getLf();
//                }
//                p= p.getLiga();
//                q = p.getLf();
//                if (p.getLf() == null) {
//                    p.setLf(p);
//                }
//            }
//            a.setLc(registro);
//            registro = registro.getLiga();
//        }
//        return punta;
//    }
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
        String message = "Punta: \n";
        message = message + "[ "+punta.getDato()+" ]";
        while (p != punta) { 
            q = p.getLf();
            message = message + " [ " + p.getDato() + " ] " + " ---> ";
            while (q != p) {   
                message = message + "\n";
                message = message + "Liga: " + q + "->" + "|" + q.getDato() + "|" + "-->" + q.getLf();
                q=q.getLf();
            }
            message = message + " ";
            p = p.getLiga();
        }

//        message = message + "\n\n" + "Ligado Columnas\n";
//        p = punta.getLc();
//        while (p != punta) {
//            message = message + " [ " + p.getDato() + " ] " + " ---> ";
//            p = p.getLc();
//        }

        JOptionPane.showMessageDialog(null, "*** FORMA1 ***\n\n" + message);

    }
    
    public void mostrar2() {

        Nodo p = punta.getLiga(), q = p.getLf();
        System.out.println("Punta:");
        System.out.println("|" + punta.getDato() + "|");
        while (p != punta) {
            q = p.getLf();
            System.out.print("|" + p.getDato() + "|->");
            while (q != p) {
                System.out.print("Liga: " + q + "->" + "|" + q.getDato() + "|" + "-->" + q.getLf());
                q = q.getLf();
            }
            System.out.println("");
            p = p.getLiga();
        }
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
