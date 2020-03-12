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
import model.data_structures.ListaEncadenada;
import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;
import model.data_structures.Nodo;


/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo <T> {

	public static String PATH = "./data/comparendos_dei_2018_small.geojson"; 

	public ListaEncadenada<Comparendo> cola;

	public MaxColaCP<Comparendo> colaMax;

	public Modelo(){	
		cola = new ListaEncadenada<Comparendo>();
	}


	public void cargarDatos() 
	{


		if(cola.esVacia()){
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
					SimpleDateFormat dateParser=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
					c.FECHA_HORA = dateParser; 
					

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

					cola.agregar(c);	
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		else
			System.out.println("---");
	}



	public void generarMuestraCola(int n)
	{
		Comparendo[] copiaComp = new Comparendo[cola.darLargo()];

		for(int i = 0; i < cola.darLargo(); i++)
		{
			copiaComp[i] = cola.eliminar(0);
		}

		for (int i = 0; i < n +1; i++) {
			colaMax.agregar(copiaComp[(int) (Math.random()*10)]);
		}
	}

	public String[] datosMasAlNorte(int n, String vehiculo)
	{
		Comparendo comp = colaMax.darPrimero().getActual();
		Nodo<T> iterador = (Nodo<T>) colaMax.darPrimero();
		String[] copiaString = new String[cola.darLargo()];
		for (int i = 0; i < n; i++) {
			if(comp.DES_INFRAC.equals(vehiculo)){
				copiaString[i] = "\n" + colaMax.darPrimero().getActual().toString();
				iterador = iterador.getSiguiente();
				comp = (Comparendo) iterador.getActual();
			}
		}
		return copiaString;
	}
	
	
}
