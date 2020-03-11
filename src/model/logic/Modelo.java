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

import model.data_structures.Comparendo;
import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;
import model.data_structures.Nodo;


/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo <T> {

	public static String PATH = "./data/comparendos_dei_2018_small.geojson"; 
	
	private ArrayList<Comparendo> arreglo;


	public Modelo()
	{
		maxCola = new MaxColaCP();
		maxHeap = new MaxHeapCP(0);
		arreglo = new ArrayList<Comparendo>();
	}

	public int darNumElementos()
	{
		return maxCola.darNumElementos();
	}

	public void agregar(Comparendo dato)
	{	
		maxCola.agregar(dato);
	}

	public Comparendo darPrimero()
	{
		return maxCola.darPrimero().getActual();
	}

	public Comparendo darUltimo()
	{
		return maxCola.darUltimo().getActual();
	}
	
	public Comparendo sacarMax()
	{
		return maxCola.sacarMax();
	}
	
	public Comparendo darMax()
	{
		return maxCola.darMax();
	}
	
	public boolean esVacia()
	{
		return maxCola.esVacia();
	}
	

	public void cargarDatos() {
		
		
		if(maxCola.esVacia()){
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

					arreglo.add(c);
	
				}
			} catch (FileNotFoundException | ParseException e) {
				e.printStackTrace();
			}
		}
		else
			System.out.println("---");
	}
	
	public void generarMuestraCola(int n)
	{
		MaxColaCP copiaComp = new MaxColaCP();
		int[] numeros = new int[n];
		for (int i = 0; i < numeros.length; i++) 
		{
			numeros[i] = (int) Math.random();
		}
		
		for (int i = 0; i < arreglo.size(); i++) {
			
		}
						
	}	
}
