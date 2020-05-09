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

import model.data_structures.*;


public class Modelo {

	public static String PATH = "./data/Comparendos_DEI_2018_Bogotá_D.C.geojson";

	public Queue<Comparendo> cola;

	

	public int tamano;

	int max;

	public Modelo()
	{
		cola = new Queue<Comparendo>();
		
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
				int EPOCOD_PLAN = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOCOD_PLAN").getAsInt();
				String EPOCOD_ENT = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOCOD_ENT").getAsString();
				String EPOCOD_PROY = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOCOD_PROY").getAsString();
				int EPOANIO_GEO = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOANIO_GEO").getAsInt();
				double EPOANIO_INI = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOANIO_INI").getAsDouble();
				double EPOANIO_FIN = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOANIO_FIN").getAsDouble();
				String EPODESCRIP = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPODESCRIP").getAsString();
				String EPOEST_PROY = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOEST_PROY").getAsString();
				String EPOINTERV_ESP = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOINTERV_ESP").getAsString();
				String EPODIR_SITIO = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPODIR_SITIO").getAsString();
				String EPOCOD_SITIO = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOCOD_SITIO").getAsString();
				double EPOLATITUD = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOLATITUD").getAsDouble();
				double EPOLONGITU = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOLONGITU").getAsDouble();
				String EPOIUUPLAN = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOIUUPLAN").getAsString();
				String EPOIUSCATA = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOIUSCATA").getAsString();
				String EPOIULOCAL = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOIULOCAL").getAsString();
				String EPOEASOCIA = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOEASOCIA").getAsString();
				String EPOFUNCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOFUNCION").getAsString();
				String EPOTEQUIPA = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOTEQUIPA").getAsString();
				String EPONOMBRE = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPONOMBRE").getAsString();
				String EPOIDENTIF = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOIDENTIF").getAsString();
				double EPOFECHA_C = e.getAsJsonObject().get("properties").getAsJsonObject().get("EPOFECHA_C").getAsDouble();
				
				Comparendo c = new Comparendo(OBJECTID);
				cola.enqueue(c);
				

			}
		} 
		catch (FileNotFoundException | ParseException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return "\nCarga completa \nEl número total de comparendos es: "+ cola.size() +"\n\nEl comparendo con mayor OBJECTID es: \n";
	}
	
}