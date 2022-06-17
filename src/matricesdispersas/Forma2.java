
package matricesdispersas;


public class Forma2 {
    
    Nodo punta;
    
    public void Forma2(){
        punta = null;
    }
    
    public Nodo getPunta(){
        return punta;
    }
    
    public void generarForma1(int mat[], int row, int col){
        int i=0, j, cont=0;
        Nodo primer = new Nodo();
        Nodo p = new Nodo();
        Nodo ant = new Nodo();
        primer.setFila(row);
        primer.setColumna(col);
        punta = primer;
        p = punta;
        
        while(j < mat.length){
            if (mat[i][j] != 0) {
                Nodo x = new Nodo();
                x.setFila(i);
                x.setColumna(j);
                
            }
        }
    }
    
    
}
