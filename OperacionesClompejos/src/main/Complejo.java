package main;

public class Complejo {
	public double real;
	public double imag;
	   
	   
    public Complejo(double re, double im)
    {
      this.real = re;
      this.imag = im;
    }
    
    public Complejo Conjugado(){
        double imaginarioN = imag * (-1);
        Complejo NumeroCNuevo = new Complejo(real, imaginarioN);
        return NumeroCNuevo;
    }
	   
}
