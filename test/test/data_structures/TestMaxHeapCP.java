package test.data_structures;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import model.data_structures.MaxHeapCP;


public class TestMaxHeapCP {
	
	public void crearHeap()
	{
		ArrayList<Integer> a = new ArrayList<>();
		a.add(25);
		a.add(10);
		a.add(30);
		a.add(35);
		a.add(40);
		
		Integer[] esperado = new Integer[11];
		esperado[1] = 40;
		esperado[2] = 35;
		esperado[3] = 30;
		esperado[4] = 25;
		esperado[5] = 10;
		
		MaxHeapCP<Integer> b = new MaxHeapCP<Integer>(a.size());
		assertEquals(5, b.darNumElementos());
	}
	
	public void testOrganizado()
	{
		crearHeap();
		
		
	}
		
	
		
		
		
	}
	




