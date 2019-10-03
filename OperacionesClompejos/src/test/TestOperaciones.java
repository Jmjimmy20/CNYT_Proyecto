package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*; 
import org.junit.jupiter.api.Test;

import main.Complejo;
import main.Operaciones;


public class TestOperaciones {
	
	@Test
	public void testSumarComplejos() {
		
		boolean flagEsperada = true;
		Operaciones OP = new Operaciones();
		Complejo Esperado = new Complejo(9,10);
		Complejo C1 = new Complejo(5,2);
		Complejo C2 = new Complejo(4,8);
		Complejo Res = OP.Sum(C1, C2);
		boolean flag = OP.igualdadComplejos(Esperado, Res);
		assertEquals(flagEsperada, flag);
		
	}
	
	@Test
	public void testRestarComplejos() {
		boolean flagEsperada = true;
		Operaciones OP = new Operaciones();
		Complejo Esperado = new Complejo(3,2);
		Complejo C1 = new Complejo(7,10);
		Complejo C2 = new Complejo(4,8);
		Complejo Res = OP.Resta(C1, C2);
		boolean flag = OP.igualdadComplejos(Esperado, Res);
		assertEquals(flagEsperada, flag);
		
	}
	
	@Test
	public void testMultComplejos() {
		boolean flagEsperada = true;
		Operaciones OP = new Operaciones();
		Complejo Esperado = new Complejo(7,4);
		Complejo C1 = new Complejo(3,-2);
		Complejo C2 = new Complejo(1,2);
		Complejo Res = OP.Mult(C1, C2);
		boolean flag = OP.igualdadComplejos(Esperado, Res);
		assertEquals(flagEsperada, flag);
		
	}
	
	@Test
	public void testDivComplejos() {
		boolean flagEsperada = true;
		Operaciones OP = new Operaciones();
		Complejo Esperado = new Complejo(0,1);
		Complejo C1 = new Complejo(-2,1);
		Complejo C2 = new Complejo(1,2);
		Complejo Res = OP.Div(C1, C2);
		boolean flag = OP.igualdadComplejos(Esperado, Res);
		assertEquals(flagEsperada, flag);
		
	}
	
	
	@Test
	public void testCartsiano_polar() {
		boolean flagEsperada = true;
		Operaciones OP = new Operaciones();
		Complejo Esperado = new Complejo(1.4142135623730951,0.7853981633974483);
		Complejo C1 = new Complejo(1,1);
		Complejo Res = OP.complejo_Polar(C1);
		boolean flag = OP.igualdadComplejos(Esperado, Res);
		assertEquals(flagEsperada, flag);
	}
	
	@Test
	public void testPolar_Cartesiano() {
		boolean flagEsperada = true;
		Operaciones OP = new Operaciones();
		Complejo Esperado = new Complejo(1,1);
		Complejo C1 = new Complejo(1.4142135623730951,0.7853981633974483);
		
		Complejo Res = OP.Polar_complejo(C1);
		boolean flag = OP.igualdadComplejos(Esperado, Res);
		assertEquals(flagEsperada, flag);
	}
	


}
