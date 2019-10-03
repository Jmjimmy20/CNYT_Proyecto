package main;

import java.text.DecimalFormat;

public class Main {
	Operaciones oper = new Operaciones();
	static Main main = new Main();
	double [] vectorA = {0,0,0,0.050,0.050,0.050,0.050,0.050,0.050,0,0.175,0,0.1,0,0.050,0.050,0.050,0.050,0.050,0.050};
	
	
	
	//======================= Funciones ===============================
	
	
	/***
	 * Sistema probabilistico  real con t clicks
	 * @param dinamyc
	 * @param matrix
	 * @param vector
	 * @param clicks
	 * @return
	 * @throws Exception
	 */
	public double[] SistemaProbabilisticoReal(int dinamyc, double[][] matrix, double[] vector, int clicks) throws Exception{        
        double [][] raisedMatrix = matrix;
        for(int i = 0; i < clicks-1; i++){
            raisedMatrix = oper.MultRealMatriz(raisedMatrix, matrix);
        }        
        double [] result = oper.MultMatrizVectorReal(raisedMatrix, vector);   
        main.ImprimirResultados(result, clicks);
        return result;
    }
	
	/***
	 * Sistema probabilistico  cauntico con t clicks
	 * @param dinamyc
	 * @param matrix
	 * @param vector
	 * @param clicks
	 * @return
	 * @throws Exception
	 */
	public Complejo[] SistemaDinamicoCuantico(int dinamyc, Complejo[][] matrix, Complejo[] vector, int clicks) throws Exception{        
		Complejo [][] raisedMatrix = matrix;
        for(int i = 0; i < clicks-1; i++){
            raisedMatrix = oper.MultMatriz(raisedMatrix, matrix);
        }       
        Complejo [] result = oper.MultMatrizVector(raisedMatrix, vector);
        main.ImprimirResultadosCuanticos(result, clicks);
        return result;
    }
	
	
	/***
	 * 
	 * @param vector1
	 * @param matriz1
	 * @param vector2
	 * @param matriz2
	 * @param clicks
	 * @return ensamblaje de sistema probabilsitico
	 * @throws Exception
	 */
	public double [] EnsamblajeSistemaProb(double[][] vector1, double[][] matriz1, double[][] vector2, double[][] matriz2, int clicks) throws Exception{        
        double [][] MatrizRes = oper.ProductoTensorialReal(matriz1, matriz2);
        double [] vectorRes = oper.ProductoTensorialReal(vector1, vector2)[0];
        
        double [] result = main.SistemaProbabilisticoReal(0, MatrizRes, vectorRes, clicks);        
        return result;
    }
	
	/***
	 * Simulador de experimento de multiples rendijas cuantico
	 * @param numRendijas
	 * @param numBlancosP
	 * @param vector
	 * @param clicks
	 * @return
	 * @throws Exception
	 */
	public double[] MultipleRendijasCuantico(int numRendijas, int numBlancosP, Complejo[] vector, int clicks) throws Exception{
        double [][] matriz = null;
        double [] vector2 = null;        
        main.ImprimirResultados(vectorA,2);
        return null;  
    }
	
	//=============================== Imprimir resultados ===========================
	
	public void ImprimirResultados(double[] vector, int clicks){
        DecimalFormat formato1 = new DecimalFormat("#.00");        
        System.out.println("Resultados despues de " + clicks +" clicks" );
        
        System.out.println("n    Valor");
        for (int i=0; i < vector.length; i++){
            int scale = 1;
            String line = "";
            if (i<10){
                 line = Integer.toString(i) + "  | " ;
            } else{
                 line = Integer.toString(i) + " | " ;
            }
            
            if (vector[i] < 0.2){
                scale = 100;                
            }            
            for(int n=0; n < (int)Math.round(vector[i]*scale); n++){
                line += "*";                
            }
            line += "  (" + String.valueOf(formato1.format(vector[i])) + ")" ;
            System.out.println(line);
        }
    }
	
	
	public void ImprimirResultadosCuanticos(Complejo[] vector, int clicks){
        DecimalFormat formato1 = new DecimalFormat("#.00");
        Operaciones op = new Operaciones();
        System.out.println("Resultados despues de " + clicks +" clicks");
        System.out.println("");
        System.out.println("n  Valor  Barra");
        System.out.println("");
        for (int i=0; i < vector.length; i++){
            double  item = op.Modulo(vector[i]);
            String line = Integer.toString(i+1) + " (" + String.valueOf(formato1.format(item*100)) + ") " ;
            for(int n=0; n < (int)Math.round(item*100); n++){
                line += "*";
            }
            System.out.println(line);
        }
    }
	
	//=============================== Pruebas =====================================
	
	public static void main(String[] args) throws Exception{  
        //DATOS PRUEBA 1
        System.out.println("--------------------------------------- PRUEBA 1 --------------------------------------------------");
        double [][] matriz1 = { {0,0,0,0,0,0,0,0,0,0,0,0,1},
                                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                                {0,0,0,0,0,0,0,0,0,0,0,1,0},
                                {0,0,1,0,0,0,0,0,0,0,0,0,0},
                                {0,0,0,1,0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,1,0,0,0,0,0,0},
                                {0,0,0,0,0,1,0,0,0,1,0,0,0},
                                {0,0,0,0,1,0,0,0,0,0,0,0,0},
                                {0,1,0,0,0,0,0,0,0,0,0,0,0},
                                {1,0,0,0,0,0,0,0,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,1,0,0,0,0},
                                {0,0,0,0,0,0,0,1,0,0,0,0,0},
                                {0,0,0,0,0,0,0,0,0,0,0,0,0}
                              };
        double [] vector1 = {10,4,1,7,2,2,11,0,3,1,0,5,2};        ;    
        double[] res = main.SistemaProbabilisticoReal(0,matriz1, vector1,25);      
        
        //DATOS PRUEBA 2
        System.out.println("--------------------------------------- PRUEBA 2 --------------------------------------------------");
        double [][] matriz2A = { {0,0.2,0.3,0.5},
                                 {0.3,0.2,0.1,0.4},
                                 {0.4,0.3,0.2,0.1},
                                 {0.3,0.3,0.4,0}
                               };
        double [][] vector2A   = {{0.2,0.1,0.6,0.1}};
        
        double [][] matriz2B = { {(double) 0,  (double) 1/6,(double) 5/6},
                                 {(double) 1/3,(double) 1/2,(double) 1/6},
                                 {(double) 2/3,(double) 1/3,(double) 0},
                               };
        double [][] vector2B   = {{0.7,0.15,0.15}};
        double [] res2 = main.EnsamblajeSistemaProb(vector2A,matriz2A,vector2B,matriz2B, 5 );
        
        //DATOS PRUEBA 3
        System.out.println("--------------------------------------- PRUEBA 3 --------------------------------------------------");
        double r = 1/Math.sqrt(22);
        Complejo rr = new Complejo(r,r);
        Complejo _r_r = new Complejo(-r,-r);
        Complejo _rr = new Complejo(-r,r);
        Complejo r_r = new Complejo(r,-r);
        Complejo[] vector3 = {rr, _r_r, _rr, _r_r, r_r, _r_r, _r_r,    _r_r, r_r, r_r, _rr};
        double [] res3 = main.MultipleRendijasCuantico(2, 5, vector3, 2);        
    }
	
	

	
}
