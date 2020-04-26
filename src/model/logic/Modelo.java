package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;




import model.data_structures.Comparendo;
import model.data_structures.RedBlackBST;
import model.data_structures.*;


public class Modelo {

	public static String PATH = "./data/Comparendos_DEI_2018_Bogotá_D.C.geojson";

	public Queue<Comparendo> cola;

	private RedBlackBST<Integer, Comparendo> arbol;
	
	public MaxHeapCP<Comparendo> heap;

	public int tamano;

	int max;

	public Modelo()
	{
		cola = new Queue<Comparendo>();
		arbol = new RedBlackBST<Integer, Comparendo>();
		heap = new MaxHeapCP<Comparendo>();
	}


	public  String agregar()
	{
		JsonReader reader;
		try 
		{
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();


			SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

			for(JsonElement e: e2) 
			{
				int OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();
				String almostDate =  s.split("Z") [0];
				String finalDate = almostDate.split("T") [0] + " " + almostDate.split("T") [1];
				Date FECHA_HORA = parser.parse(finalDate); 

				String MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETECCION").getAsString();
				String CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHICULO").getAsString();
				String TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVICIO").getAsString();
				String INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				String DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRACCION").getAsString();	
				String LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				double longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				double latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				Comparendo c = new Comparendo(OBJECTID, FECHA_HORA, DES_INFRAC, MEDIO_DETE, CLASE_VEHI, TIPO_SERVI, INFRACCION, LOCALIDAD, longitud, latitud);
				cola.enqueue(c);
				heap.insert(c);
				arbol.put(c.darId(), c);

			}
		} 
		catch (FileNotFoundException | ParseException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return "\nCarga completa \nEl número total de comparendos es: "+ arbol.size() +"\n\nEl comparendo con mayor OBJECTID es: \n"+ darComparendoMayorId() ;
	}
	public String darComparendoMayorId()
	{		
		String valor = arbol.get(arbol.max()).darDatos();
		return valor;
	}


	//1A
	public Queue<Comparendo> req1a(int m) 
	{
		int contador = 0;
		MaxHeapCP<Comparendo> max = new MaxHeapCP<Comparendo>();
		for (Comparendo comparendo : cola)
		{
			comparendo.cambiarComparador(1);
			max.insert(comparendo);
		}
		Queue<Comparendo> end = new Queue<Comparendo>();
		while(contador <= m)
		{
			end.enqueue(max.delMax());
			contador ++;
		}
		return end;
	}

	// 2A
	public ArrayList<Comparendo> buscarComparendosPorMesyDia(int mes, int dia)
	{
		ArrayList<Comparendo> f = new ArrayList<Comparendo>();
		Date fecha = new Date(118, mes + 1, dia);

		for (int i = 0; i < arbol.size(); i++) {

			if(arbol.get(i).darFechaHora().equals(fecha))
			{
				f.add(arbol.get(i));
			}

		}

		return f;
	}

	//3A
	public Queue<Comparendo> req3A(Date f1, Date f2, String localidad)
	{

		RedBlackBST<Date,Comparendo>arbolRN = new RedBlackBST<Date,Comparendo>();
		for (Comparendo iterable : cola) 
		{
			if(iterable.darLocalidad().equals(localidad))
			{
				arbolRN.put(iterable.darFechaHora(), iterable);
			}

		}
		Iterator<Date> iterator;

		iterator = (Iterator<Date>) arbolRN.keysInRange(f1, f2);

		Queue<Comparendo> end = new Queue<Comparendo>();

		while(iterator.hasNext())
		{
			Date ejarb = iterator.next();		
			end.enqueue(arbolRN.get(ejarb));

		}
		return end;
	}

	//1B
	public Queue<Comparendo> req1b(int M)
	{
		Haversine hav = new Haversine();
		MaxColaCP<Comparendo> end = new MaxColaCP<Comparendo>();
		Queue<Comparendo> ret = new Queue<Comparendo>();
		
		for(int i = 0; i < arbol.size(); i++)
		{
			
			if(hav.distance(4.647586,-74.078122, arbol.get(i).darLatitud(), arbol.get(i).darLongitud()) <= 1)
				{
					arbol.get(i).cambiarComparador(2);
					end.agregar(arbol.get(i));
				
				}
		}
	
		
		while(!end.esVacia() && ret.size() <= M)
		{
			ret.enqueue(end.sacarMax());
		}
		
		return  ret;
		
	}

	//2B
	public Queue<Comparendo> req2B(String detecion, String clase, String tipo, String localidad) {
		RedBlackBST<Date,Comparendo>arbolRN = new RedBlackBST<Date,Comparendo>();
		Queue<Comparendo> end = new Queue<Comparendo>();
		for (Comparendo iterable : cola) 
		{
			if(iterable.darLocalidad().equals(localidad) && iterable.darClase().equals(clase)
					&& iterable.darMedioDete().equals(detecion) && iterable.darTipo().equals(tipo))
			{
				arbolRN.put(iterable.darFechaHora(), iterable);
			}

		}
		Iterator<Date> cambiador = arbolRN.keys();
		while(cambiador.hasNext())
		{
			Date ejarb = cambiador.next();	
			end.enqueue(arbolRN.get(ejarb));
		}
		return end;
	}


	//3B
	public Queue<Comparendo> req3B(double latitud1, double latitud2, String tipo)
	{
		RedBlackBST<Double ,Comparendo>arbolRN = new RedBlackBST<Double,Comparendo>();
		for (Comparendo iterable : cola) 
		{
			if(iterable.darTipo().equals(tipo))
			{
				arbolRN.put(iterable.darLatitud(), iterable);
			}
			
		}
		Iterator<Double> iterator;
		
		iterator = arbolRN.keysInRange(latitud1, latitud2);
		
		Queue<Comparendo> end = new Queue<Comparendo>();
		
		while(iterator.hasNext())
		{
			Double ejarb = iterator.next();		
			end.enqueue(arbolRN.get(ejarb));
			
		}
		return end;
	}
	
	//1C
	public Queue<Comparendo> req1C(int D)
	{
		
		try {
			SimpleDateFormat parser1 = new SimpleDateFormat("yyyy-MM-dd");
			Date fecha1 = parser1.parse("2018-01-01");
			SimpleDateFormat parser2 = new SimpleDateFormat("yyyy-MM-dd");
			
			Date fecha2 = fecha1.setDate(fecha1.getDate( ) + 1);
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}








}