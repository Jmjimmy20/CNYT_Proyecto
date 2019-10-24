package main;

import java.text.DecimalFormat;

public class Main {
	Operaciones oper = new Operaciones();
	static Main main = new Main();
	double [] vectorA = {0,0,0,0.050,0.050,0.050,0.050,0.050,0.050,0,0.175,0,0.1,0,0.050,0.050,0.050,0.050,0.050,0.050};
	double ams = 13.1;  
    static double valor = 1.9;  
    double mean = 1;
	
	
	//======================= Funciones ===============================
	
	
	/**
     * Calcula la posición de una partícula en una recta.
     * @param vector VectorComplejo
     * @param points número de puntos sobre la recta
     * @return probabilidad
     */
    private double PartRec(Complejo[] vec, int punto) {
        Double n = 0.0;
        for(int i = 0; i < vec.length;i++) {
            n += Math.pow(oper.Modulo(vec[i]), 2);
        }
        Double norm = Math.sqrt(n);
        Double prob = Math.pow(oper.Modulo(vec[punto-1]),2) / Math.pow(norm, 2);
        main.ImprimirResultados(vectorA, punto);
        return prob;
    }
	
	
	
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
	
	
	public Complejo valorMed(Complejo[] vecX, Complejo[][] ob) throws Exception{
        Complejo[] ket = oper.MultMatrizVector(ob, vecX);
        Complejo ans = oper.productoInterno(ket, vecX);
        return ans;
    }
	
	public Complejo varianza(Complejo[] vector, Complejo[][] observable) throws Exception {
		Complejo meam = valorMed(vector, observable);
        double[][] identity = {  {1,0,0,0},
                                 {0,1,0,0},
                                 {0,0,1,0},
                                 {0,0,0,1},
                              };
        double[][] mult = oper.MultMatrizRealxReal(mean, identity);
        Complejo[][] temp = oper.restaMat(observable, mult);
        Complejo[] act = oper.MultMatrizVector(temp, vector);
        Complejo ans = oper.productoInterno(vector, act);
        System.out.println("Varianza = " + ams);
        return ans;

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
		
		
		//---------- Prueba 1 -------------
		
		Complejo A1 = new Complejo(2,-1);
		Complejo A2 = new Complejo(-1.5,2.5);
		Complejo A3 = new Complejo(-3.5,5);
		Complejo A4 = new Complejo(-4,6);
		Complejo A5 = new Complejo(-3.5,2.5);
		Complejo A6 = new Complejo(0,0);
		Complejo A7 = new Complejo(-3.5,2.5);
		Complejo A8 = new Complejo(6,-4);
		Complejo A9 = new Complejo(0,2.5);
		Complejo A10 = new Complejo(-1,1);
		
		Complejo [] Vec1 = {A1,A2,A3,A4,A5,A6,A7,A8,A9,A10};
		double resp = main.PartRec(Vec1, 10);
		
		//---------- Prueba 2 -------------
		
		Complejo B1 = new Complejo(0,0);
		Complejo B2 = new Complejo(0,-0.5);
		Complejo B3 = new Complejo(0,-1);
		Complejo B4 = new Complejo(-3.5,0);
		Complejo B5 = new Complejo(0,0.5);
		Complejo B6 = new Complejo(0,0);
		Complejo B7 = new Complejo(3.5,0);
		Complejo B8 = new Complejo(0,-1);
		Complejo B9 = new Complejo(0,1);
		Complejo B10 = new Complejo(3.5,0);
		Complejo B11 = new Complejo(0,0);
		Complejo B12 = new Complejo(0,-3.5);
		Complejo B13 = new Complejo(-3.5,0);
		Complejo B14 = new Complejo(0,1);
		Complejo B15 = new Complejo(0,0.5);
		Complejo B16 = new Complejo(0,0);
		
		
		Complejo [][] MatrizO = {  {B1,B2,B3,B4},
                							{B5,B6,B7,B8},
                							{B9,B10,B11,B12},
                							{B13,B14,B15,B16}
											};
		
		Complejo C1 = new Complejo(-2, 1);
		Complejo C2 = new Complejo(1, 0);
		Complejo C3 = new Complejo(0, -1);
		Complejo C4 = new Complejo(3, 2);
		
		Complejo[] estadoInicial = {C2,C2,C3,C4};   
		main.valorMed(estadoInicial, MatrizO);
		System.out.println("Valor esperado = " + valor);
		main.varianza(estadoInicial, MatrizO);
		
		
        
		/*
		
		
		
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
        
          */
    }
	
	

	
}
