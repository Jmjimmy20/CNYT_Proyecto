package main;

public class Matriz {

	int sizeFilas;
    int sizeColumnas;
    int conteoAnadidos;
    Complejo [][] matriz;
    
    
    public Matriz(int tamFilas, int tamColumnas){
        sizeFilas = tamFilas;
        sizeColumnas = tamColumnas;
        matriz = new Complejo[sizeFilas][sizeColumnas];
    }
    
    public void AddInPosition(int posFila, int posColumna, Complejo valor){
        matriz[posFila][posColumna] = valor;
    }
    
    public Complejo GetPosition(int posFila, int posColumna){
        return matriz[posFila][posColumna];
    }
    
    public Matriz Inverso(){
        double valorReal;
        double valorImaginario;
        Complejo complejoN;
        Matriz matrizNueva = new Matriz(sizeFilas, sizeColumnas);
        for (int i = 0; i < sizeFilas; i++){
            for(int o = 0; o < sizeColumnas; o++){
                valorReal = (matriz[i][o].real * -1);
                valorImaginario = (matriz[i][o].imag * -1);
                complejoN  = new Complejo(valorReal, valorImaginario);
                matrizNueva.AddInPosition(i, o, complejoN);
            }
        }
        return matrizNueva;
    }
    
}
