package test.data_structures;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import model.data_structures.MaxColaCP;
import model.data_structures.Nodo;

public class TestMaxColaCP {

	
		private MaxColaCP cola;
		private Nodo primero;
		private Nodo ultimo;
		
		public void setUp1() {
			cola = new MaxColaCP();
			primero = (Nodo) cola.darPrimero();
			ultimo = (Nodo) cola.darUltimo();
		}

		public void setUp2() {
			Integer a = new Integer (1);
			cola.agregar(a);
		}
	
		public void testCola(){
			
			setUp1();
			setUp2();
			String elemento = "";
			Integer elemento2 = new Integer(1);
			Nodo a = new Nodo(elemento2);
			
		
			assertEquals(primero,cola.darPrimero());
			assertEquals(ultimo,cola.darUltimo());
			assertEquals("", cola.agregar(elemento));
		
			
			
			
	}
	
}
