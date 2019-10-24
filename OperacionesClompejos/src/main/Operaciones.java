package main;

public class Operaciones {
	
	/***
	 * Conjugado de un complejo
	 * @param C1
	 * @return C1´
	 */
	public Complejo Conjugado(Complejo C1) {
		return new Complejo (C1.real, (-1)*C1.imag);
	}
	
	
	/***
	 * Modulo de un complejo
	 * @param C1
	 * @return double valor de modulo
	 */
	public double Modulo(Complejo C1) {
		return Math.sqrt((C1.real*C1.real) + (C1.imag*C1.imag));
	}
	
	
	/***
	 * Sumar 2 Complejos
	 * @param C1
	 * @param C2
	 * @return C1+C2
	 */
	public static Complejo Sum(Complejo C1, Complejo C2) {
		
		return new Complejo (C1.real + C2.real , C1.imag + C2.imag);
	}
	
	
	/***
	 * Restar 2 Complejos
	 * @param C1
	 * @param C2
	 * @return C1-C2
	 */
	public Complejo Resta (Complejo C1, Complejo C2) {
		
		return new Complejo (C1.real - C2.real , C1.imag - C2.imag);
	}
	
	/***
	 * Multiplicar 2 complejos
	 * en base a la formula z*w = (a+bi) * (c+di) = (a*c-b*d) + (a*d+b+c)i
	 * @param C1
	 * @param C2
	 * @return C1*C2
	 */
	public static Complejo Mult(Complejo C1, Complejo C2) {
		
		return new Complejo (((C1.real*C2.real) - (C1.imag * C2.imag)) , ((C1.real * C2.imag)+(C1.imag *C2.real)));
	}
	
	/***
	 * Divide 2 complejos, si devuelve 0 es por la inicializacion de las variables x , y
	 * @param C1
	 * @param C2
	 * @return C1/C2
	 */
	public Complejo Div(Complejo C1, Complejo C2) {
		double x = 0,y = 0;
		
		if(Modulo(C2) == 0) {
			//lanzamos un error de div por 0
		}else {
			double aux = ((C2.real * C2.real) + (C2.imag* C2.imag));
			x = (((C1.real*C2.real)+(C1.imag*C2.imag))/aux);
			y = (((C1.imag*C2.real)-(C1.real*C2.imag))/aux);
		}
		return new Complejo(x,y);
	}
	
	/***
	 * Pasar de numero complejo a polar
	 * @param C1
	 * @return polar
	 */
	public Complejo complejo_Polar(Complejo C1) {
		double valTeta = Math.atan2(C1.imag,C1.real);
		double valorPfea = Math.sqrt(Math.pow(C1.real, 2) + Math.pow(C1.imag, 2));
		return new Complejo(valorPfea, valTeta);
	}
	
	/***
	 * Pasar de polar a complejo o cartesiano
	 * @param C1
	 * @return complejo
	 */
	public Complejo Polar_complejo(Complejo C1) {
		double A = (C1.real*(Math.cos(C1.imag)));
		double B = (C1.real*(Math.sin(C1.imag)));
		System.out.println(A);
        System.out.println(B);

		return new Complejo((C1.real*(Math.cos(C1.imag))),(C1.real*(Math.sin(C1.imag))));
	}
	
	
	/***
	 * Verifica si 2 numeros complejos son iguales
	 * @param C1
	 * @param C2
	 * @return true o false si es o no igual 
	 */
	public static boolean igualdadComplejos(Complejo C1, Complejo C2) {
		
		if(C1.real == C2.real && C1.imag == C2.imag) 
			return true;
		else
			return false;
	}
	
	/***
	 * Fase de un numero complejo
	 * 
	 * @param C1 numero complejo
	 * @return fase del numero
	 */
	public double phase(Complejo number) {
		double rad = Math.atan(number.imag/number.real);  
        return Math.toDegrees(rad);
	}
	
	
	
	
	/*** ================================= Operaciones con Vectores ==========================
	 * 
	 */
	
	
	/****
	 * 
	 * @param vectorA
	 * @param vectorB
	 * @return vector de complejos de la suma entre A y B
	 */
	public Complejo[] sumVector (Complejo[] vectorA,Complejo[] vectorB){
		Complejo[] result = new Complejo[vectorA.length];        
        for (int i = 0; i < vectorA.length; i++){
            result[i] = Sum(vectorA[i], vectorB[i]);
        }
        return result;
    }
	
	/***
	 * 
	 * @param vectorA
	 * @return vector inverso de A
	 */
	public Complejo[] inversoVector(Complejo[] vectorA){
		Complejo[] result = new Complejo[vectorA.length];
        for (int i = 0; i < vectorA.length; i++){
            result[i] = new Complejo(vectorA[i].real*-1, vectorA[i].imag*-1);
        }
        return result;
    }
	
	
	/***
	 * 
	 * @param number
	 * @param vectorA
	 * @return Vector resultante de la multiplicacion
	 */
	public Complejo[] scalarMultVector (Complejo number, Complejo[] vectorA){
		Complejo[] result = new Complejo[vectorA.length];
        for (int i = 0; i < vectorA.length; i++){
           result[i] = (Mult(number, vectorA[i]));
        }
        return result;
    } 
	
	
	/***
	 * 
	 * @param vector
	 * @return la norma del vector
	 */
	public double NormaVector (double[] vector){
        float sum = 0;
        for(int i = 0; i < vector.length; i++){
            sum += vector[i]*vector[i];
        }
        return Math.sqrt(sum);
    }

	
	/***
	 * 
	 * @param vectorA
	 * @param vectorB
	 * @return retorna la distancia entre los 2 vectores si tienen la msima cantidad de componentes
	 * @throws Exception si no tienen la misma cantidad de componentes
	 */
	 public double Distancia(double[] vectorA, double[] vectorB) throws Exception{
	    if (vectorA.length != vectorB.length) {
	        throw new Exception("Los vectores no tienen los mismos componentes");
		} else {
            double sum = 0;
            for (int i = 0; i < vectorA.length; i++){
                sum += Math.pow((vectorB[i] - vectorA[i]),2);
            }
            return Math.sqrt(sum);
	    }
	 }
	 
	 
	 
	 
	 /***
	  * ========================= Matrices ======================================
	  */
	
	 
	 
	 /***
	  * 
	  * @param matrixA
	  * @param matrixB
	  * @return retorna la suma de 2 matrices
	  */
	 public Complejo[][] sumMatriz (Complejo[][] matrizA, Complejo[][] matrizB){
		 Complejo[][] result = null;
	        for (int i=0 ; i < matrizA.length; i++){
	            for (int j=0; j < matrizA[i].length; j++){
	                result[i][j] = Sum(matrizA[i][j], matrizB[i][j]);
	            }
	        }
	        return result;
    }
	 
	 public Complejo[][] restaMat (Complejo[][] matrixA, double[][] matrixB){
		 Complejo [][] result = new Complejo[matrixA.length][matrixB[0].length];
	        for (int i=0 ; i < matrixA.length; i++){
	            for (int j=0; j < matrixA[i].length; j++){
	                result[i][j] = Sum(matrixA[i][j], matrixA[i][j]);
	            }
	        }
	        return matrixA;
	    }
	 
	 
	/***
	 * 
	 * @param matrizA
	 * @return inversa de la amtriz 
	 */
	 public Complejo[][] inversoMatriz(Complejo[][] matrizA){
		Complejo[][] result = null;
        for (int i=0; i < matrizA.length; i++){
            for (int j=0; j < matrizA[i].length; i++){
                result[i][j]= new Complejo(matrizA[i][j].real * -1, matrizA[i][j].imag * -1);
            }
        }
        return result;
     }
	 
	 
	 /***
	  * 
	  * @param matrizA
	  * @param matrizB
	  * @return resultadod e multiplicar 2 matrices
	  * @throws Exception que las matricers no sean aptas para multiplicarse
	  */
	 public Complejo[][] MultMatriz(Complejo[][] matrizA, Complejo[][] matrizB) throws Exception {
	        if (matrizA.length != matrizB[0].length) {
	            throw new Exception("Las  matrices no son compatibles");
	        } else {
	        	Complejo[][] result = new Complejo[matrizA.length][matrizB[0].length];
	        	Complejo item = new Complejo(0, 0);
	            for (int m = 0; m < matrizA.length; m++) {
	                for (int n = 0; n < matrizA[0].length; n++) {
	                    for (int i = 0; i < matrizA.length; i++) {
	                    	Complejo temp = Mult(matrizA[m][i], matrizB[i][n]);
	                        item = Sum(item, temp);
	                    }
	                    result[m][n] = item;
	                    item = new Complejo(0, 0);
	                }
	            }
	            return result;
	        }
	    }
	 
	 
	 
	 /***
	  * 
	  * @param matrizA
	  * @param matrizB
	  * @return Resultado de multiplicar una matriz y un numero real
	  * @throws Exception que las matricers no sean aptas para multiplicarse
	  */
	 public double[][] MultRealMatriz(double[][] matrizA, double[][] matrizB) throws Exception {
	        if (matrizA.length != matrizB[0].length) {
	            throw new Exception("Las  matrices no son compatibles");
	        } else {
	            double[][] result = new double[matrizA.length][matrizB[0].length];
	            double item = 0;
	            for (int m = 0; m < matrizA.length; m++) {
	                for (int n = 0; n < matrizA[0].length; n++) {
	                    for (int i = 0; i < matrizA.length; i++) {
	                        double temp = matrizA[m][i] * matrizB[i][n];
	                        item = item + temp;
	                    }
	                    result[m][n] = item;
	                    item = 0;
	                }
	            }
	            return result;
	        }
	    }
	 
	 
	 /***
	  * 
	  * @param number
	  * @param matrixA
	  * @return Multiplicacion entre scalar y una martriz
	  */
	 public Complejo[][] MultScalarMatriz(Complejo number, Complejo[][] matrizA){
		 Complejo[][] result = null;
         for (int i=0; i < matrizA.length; i++){
             for (int j=0; j < matrizA[i].length; i++){
                 result[i][j] = new Complejo(number.real * matrizA[i][j].real, number.imag * matrizA[i][j].imag);
             }
         }
         return result;
     }
	 
	 
	 
	 /***
	  * 
	  * @param matrizA
	  * @return la trnaspuesta de una matriz
	  */
	 public Complejo[][] TranspuestaMatriz(Complejo[][] matrizA){
	        for (int i=0; i < matrizA.length; i++){
	            for (int j=0; j < matrizA[i].length; i++){
	                matrizA[i][j] = matrizA[j][i];
	            }
	        }
	        return matrizA;
     }
	 
	 
	 /***
	  * 
	  * @param matrizA
	  * @return conjugado de la matriz
	  */
	 public Complejo[][] ConjugadoMatriz(Complejo[][] matrizA){
		 Complejo[][] result = null;
	        for (int i=0; i < matrizA.length; i++){
	            for (int j=0; j < matrizA[i].length; i++){
	                result[i][j]= new Complejo(matrizA[i][j].real, matrizA[i][j].imag*-1);
	            }
	        }
	        return result;
	 }
	 
	 
	 /***
	  * 
	  * @param matrizA
	  * @return retorna la adjunta de la matriz
	  */
	 public Complejo[][] MatrizAdjunta(Complejo[][] matrizA){
		 Complejo[][] transposed = null;
	        transposed = TranspuestaMatriz(matrizA);
	        return ConjugadoMatriz(transposed);
	}
	 
	 
	 /***
	  * 
	  * @param matriz
	  * @param vector
	  * @return vector de numeros complejos resultado de multiplicar una matriz por un vector
	  * @throws Exception
	  */
	 public  Complejo[] MultMatrizVector(Complejo[][] matriz,Complejo[] vector) throws Exception{
	        if (matriz[0].length != vector.length) {
	            throw new Exception("Matriz y vector no son compatibles");
		} else {
			Complejo[] result = new Complejo[vector.length];  
			Complejo item = new Complejo(0,0);
	            for (int i = 0; i < vector.length; i++) {
	                for (int j = 0; j < matriz[0].length; j++) {
	                	Complejo prod = Mult(vector[j], matriz[i][j]);
	                    item = Sum(item, prod);
			}
			result[i] = item;
			item = new Complejo(0,0);
	            }
	            return result;
		}
    }
	 
	 /***
	  * 
	  * @param matriz
	  * @param vector
	  * @return vector de numeros complejos resultado de multiplicar una matriz por un vector
	  * @throws Exception
	  */
	 public  double[] MultMatrizVectorReal(double[][] matriz,double[] vector) throws Exception{
	        if (matriz[0].length != vector.length) {
	            throw new Exception("Matriz y vector no son compatibles");
		} else {
	            double[] result = new double[vector.length];  
	            double item = 0;
	            for (int i = 0; i < vector.length; i++) {
	                for (int j = 0; j < matriz[0].length; j++) {
	                    double prod = vector[j] * matriz[i][j];
	                    item = item + prod;
			}
			result[i] = item;
			item = 0;
	            }
	            return result;
		}
	    }
	 
	 

	 /***
	  * 
	  * @param matrix
	  * @return Daga de una matriz
	  */
	 public Complejo[][] DagaMatriz(Complejo[][] matriz){
		Complejo[][] trans = TranspuestaMatriz(matriz);
        return ConjugadoMatriz(trans);
    }
	 
	 
	 
	 /***
	  * 
	  * @param matrix
	  * @return si es hermitania o no una matriz
	  * @throws Exception
	  */
	 public boolean EsHermitania (Complejo[][] matriz) throws Exception{
	        if (matriz.length != matriz[0].length) {
	            throw new Exception("Matriz no cuadrada");
		} else {
	            return matriz.equals(DagaMatriz(matriz));
		}
    }
	 
	 /***
	  * 
	  * @param matriz
	  * @return si es una matriz unitaria
	  * @throws Exception
	  */
	 public boolean EsUnitaria (Complejo[][] matriz) throws Exception{
	        if (matriz.length != matriz[0].length) {
	            throw new Exception("Matriz no cuadrada");
	        } else {
	            Complejo[][] mult = MultMatriz(matriz, DagaMatriz(matriz));
	            return matriz.equals(MultMatriz(matriz, mult));
	        }
    }
	 
	 
	 
	 /***
	  * 
	  * @param matrix1
	  * @param matrix2
	  * @return producto tensorial entre 2 matrices
	  */
	 public  Complejo[][] ProducTensorial(Complejo[][] matriz1, Complejo[][] matriz2) {
		 Complejo[][] result = new Complejo[matriz1.length * matriz2.length][ matriz1[0].length * matriz2[0].length];
		 Complejo[][] item;
		int m = 0;
		int n = 0;
		for (int i = 0; i < matriz1.length; i++) {
	            for (int j = 0; j < matriz1[0].length; j++) {
	                item = this.MultScalarMatriz( matriz1[i][j], matriz2);
			for(int k = 0; k < item.length; k++) {
	                    for(int l = 0; l < item[0].length; l++) {
	                        result[m][n] = item[k][l];
				n++;
	                    }
	                    m++;
	                    n = j * matriz2[0].length;
			}
	                m = i * matriz2.length;
			n = (j + 1) * matriz2[0].length;
	            }
	            m = (i + 1) * matriz2.length;
	            n = 0;
	        }
		return result;
     }
	 
	 
	 
	 public  double[][] ProductoTensorialReal(double[][] matriz1, double[][] matriz2) {
	        double[][] result = new double[matriz1.length * matriz2.length][ matriz1[0].length * matriz2[0].length];
			double[][] item;
			int m = 0;
			int n = 0;
			for (int i = 0; i < matriz1.length; i++) {
		            for (int j = 0; j < matriz1[0].length; j++) {
		                item = this.MultMatrizRealxReal( matriz1[i][j], matriz2);
				for(int k = 0; k < item.length; k++) {
		                    for(int l = 0; l < item[0].length; l++) {
		                        result[m][n] = item[k][l];
					n++;
		                    }
		                    m++;
		                    n = j * matriz2[0].length;
				}
		                m = i * matriz2.length;
				n = (j + 1) * matriz2[0].length;
		            }
		            m = (i + 1) * matriz2.length;
		            n = 0;
		        }        
			return result;
	    }
	 
	 
	 public double[][] MultMatrizRealxReal(double number, double[][] matrizA){
	        double [][] result = new double[matrizA.length][matrizA[0].length];
	        for (int i=0; i < matrizA.length; i++){
	            for (int j=0; j < matrizA[i].length; j++){
	                result[i][j] = number * matrizA[i][j];
	            }
	        }
	        return result;
	    }
	 
	 public Complejo productoInterno(Complejo[] v1, Complejo[] v2){
		 Complejo r = new Complejo(0,0);
	        for (int i = 0; i < v1.length;i++) {
	            r = Sum(r, Mult(Conjugado(v1[i]), Conjugado(v2[i])));
	        }
	        return r;
	    }
}
