package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.sun.corba.se.impl.orbutil.RepositoryIdUtility;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import model.data_structures.Cola;
import model.data_structures.Comparendo;
import model.data_structures.Nodo;


/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo <T> {

	public static String PATH = "./data/comparendos_dei_2018_small.geojson"; 

	private Cola<Comparendo> cola;


	public Modelo()
	{
		cola = new Cola<Comparendo>();
	}

	public int darTamano()
	{
		return cola.darTamano();
	}

	public void enqueue(Comparendo dato)
	{	
		cola.enqueue(dato);
	}

	public Comparendo darPrimero()
	{
		return cola.darPrimero().getActual();
	}

	public Comparendo darUltimo()
	{
		return cola.darUltimo().getActual();
	}

	public Nodo<Comparendo> dequeue()
	{
		return cola.dequeue();
	}


	public void cargarDatos() {
		
		if(cola.esVacio()){
			JsonReader reader;
			try {
				reader = new JsonReader(new FileReader(PATH));
				JsonElement elem = JsonParser.parseReader(reader);
				JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();


				SimpleDateFormat parser=new SimpleDateFormat("yyyy/MM/dd");

				for(JsonElement e: e2) {
					Comparendo c = new Comparendo();
					c.OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

					String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
					c.FECHA_HORA = parser.parse(s); 

					c.MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
					c.CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
					c.TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
					c.INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
					c.DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
					c.LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

					c.longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
							.get(0).getAsDouble();

					c.latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
							.get(1).getAsDouble();

					enqueue(c);
		

				}


			} catch (FileNotFoundException | ParseException e) {
				e.printStackTrace();
			}
		}
		else
			System.out.println("---");
	}
	
	public Comparable[] copiarComparendos()
	{
		Comparable<Comparendo>[] copiaComp = new Comparable[cola.darTamano()];
		Nodo<Comparendo> x = null;
		
		for(int i = 0; i < cola.darTamano(); i++)
		{
			x = cola.darPrimero();
			copiaComp[i] =x.getActual();
			x = x.getSiguiente();
		}
		return copiaComp;		
				
	}
	
	
	public void shellSort(Comparable datos[])
	{
		datos = copiarComparendos();
		int a = datos.length;
		Comparable aux;
		boolean cond;
		 while(a > 0)
		 {
			 a = a/2;
			 cond = true;
			 
			 while(cond)
			 {
				 cond = false;
				 int i = 0;
				 
				 while((i + a) <= datos.length-1)
				 {
					 if(datos[i].compareTo(datos[i+a]) == 1 ) 
					 {
						 aux = datos[i];
						 datos[i] = datos[i+a];
						 datos[i+a] = aux;
						 cond = true;
						 
					 }
					 
					 i = i + 1;
				 }
			 }
		}
   }
	
	public static void mergeSort(Comparable[] arreglo)
	{
		Comparable[] aux = new Comparable[arreglo.length];
		merge(arreglo, aux, 0, arreglo.length);
		
	}
	
	public static void merge(Comparable[] d, Comparable[] aux, int lo, int hi)
	{
		
		if(lo>= hi)
		{
			return;
		}
		
		int mid = (lo+hi)/2;
		merge(d,aux,lo,mid);
		merge(d,aux,mid+1,hi);
		mergeHalves(d, aux, lo,hi);
		
	}
	
	public static void mergeHalves(Comparable[] d, Comparable[] aux, int lo, int hi)
	{
		 	int leftEnd = (hi + lo) / 2;
	        int rightStart = leftEnd + 1;
	        int size = hi - lo + 1;

	        int left = lo;
	        int right = rightStart;
	        int index = lo;

	        while (left <= leftEnd && right <= hi) {

	            if (d[left].compareTo(d[right]) == -1) {
	                aux[index] = d[left];
	                left++;
	            } else {
	                aux[index] = d[right];
	                right++;

	            }
	            index++;
	        }
	}
	
	
	public static long quick_srt(Comparable arreglo[],int low, int n){
	      long startTime = System.currentTimeMillis();
		int lo = low;
	      int hi = n;
	      if (lo >= n) {
	          return startTime;
	      }
	      int mid = (lo + hi) / 2;
	      while (lo < hi) {
	          while (lo<hi && arreglo[lo].compareTo(mid) < 0) {
	              lo++;
	          }
	          while (lo<hi && arreglo[hi].compareTo(mid) > 0) {
	              hi--; }
	          if (lo < hi) {
	              int T = (int) arreglo[lo];
	              arreglo[lo] = arreglo[hi];
	              arreglo[hi] = T;
	          }
	      }
	      if (hi < lo) {
	          int T = hi;
	          hi = lo;
	          lo = T;
	      }
	      quick_srt(arreglo, low, lo);
	      quick_srt(arreglo, lo == low ? lo+1 : lo, n);
	      long endTime = System.currentTimeMillis();
	      return startTime - endTime;
	   }
	

	 
	
		
	
}




