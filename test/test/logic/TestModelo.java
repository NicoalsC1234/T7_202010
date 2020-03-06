package test.logic;

import static org.junit.Assert.*;

import model.data_structures.Comparendo;
import model.logic.Modelo;
import view.View;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	
	private Modelo modelo;
	
	
	
	public void setUp1() {
		
		modelo= new Modelo();
	
	}

	public void testModelo()
	{
		
	}
	
	public void testShell()
	{
		int[] a = null;
		int[] b = null;
	 
		for(int i = 0; i < 1000; i++)
		{
			a[i] = (int)Math.random();
		}
		for(int i = 0; i < 1000; i--)
		{
			a[i] = (int)Math.random();
		}
		
		Comparable copia_Comparendos [ ] = modelo.copiarComparendos();
		modelo.shellSort( copia_Comparendos );
		long startTime = System.currentTimeMillis(); 
		long endTime = System.currentTimeMillis(); 
		long duration = endTime - startTime; 
		View.printMessage("Tiempo de ordenamiento shell: " + duration + " milisegundos");
		
		//* Falta
		
		
	}
	
	public void testMerge()
	{
		Comparendo primer = new Comparendo();
		Comparendo segundo = new Comparendo();
		Comparendo tercer = new Comparendo();
		segundo.FECHA_HORA = tercer.FECHA_HORA;
		primer.FECHA_HORA = segundo.FECHA_HORA;
		primer.OBJECTID = 1;
		segundo.OBJECTID = 2;
		tercer.OBJECTID = 3;
		
		
		Comparable copia_Comparendos1 [ ] = {segundo, primer};
		modelo.mergeSort(copia_Comparendos1);
		
		for (int i = 0; i < copia_Comparendos1.length; i++) {
			assertTrue(copia_Comparendos1[0] == primer);
		}
		
		Comparable copia_Comparendos2 [ ] = {primer, segundo};
		modelo.mergeSort(copia_Comparendos2);
		
		for (int i = 0; i < copia_Comparendos2.length; i++) {
			assertTrue(copia_Comparendos2[0] == primer);
		}
		
		Comparable copia_Comparendos3 [ ] = {segundo, primer, tercer};
		modelo.mergeSort(copia_Comparendos3);
		
		for (int i = 0; i < copia_Comparendos3.length; i++) {
			assertTrue(copia_Comparendos3[0] == primer);
		}
	
		Comparable copia_Comparendos4 [ ] = modelo.copiarComparendos();
		modelo.mergeSort(copia_Comparendos4);
		long startTime = System.currentTimeMillis(); 
		long endTime = System.currentTimeMillis(); 
		long duration = endTime - startTime; 
		View.printMessage("Tiempo de ordenamiento merge: " + duration + " milisegundos");
	}
	
	public void testQuick()
	{
		//* Falta
		Comparendo primer = new Comparendo();
		Comparendo segundo = new Comparendo();
		primer.FECHA_HORA = segundo.FECHA_HORA;
		primer.OBJECTID = 1;
		segundo.OBJECTID = 2;
		
		
		Comparable copia_Comparendos2 [ ] = modelo.copiarComparendos();
		modelo.quick_srt(copia_Comparendos2, 0, 2);
		long startTime = System.currentTimeMillis(); 
		long endTime = System.currentTimeMillis(); 
		long duration = endTime - startTime; 
		View.printMessage("Tiempo de ordenamiento: " + duration + " milisegundos");
		
		assertTrue(copia_Comparendos2[0] == primer);
		assertTrue(copia_Comparendos2[1] == segundo);
	}

}
