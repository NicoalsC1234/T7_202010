package model.logic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

	public static String PATH = "./data/estacionpolicia.geojson";
	
	public static String PATHvertices = "./data/bogota_vertices.txt";
	
	public static String PATHarcos = "./data/bogota_arcos.txt";

	public Queue<Comparendo> cola;
	
	public MiGrafo<Integer, Lugar> grafito;



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
				
		
				

			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return "\nCarga completa \nEl número total de comparendos es: "+ cola.size() +"\n\nEl comparendo con mayor OBJECTID es: \n";
	}
	
	
	public void cargaVertices() 
	{
		
		 
		try {
			FileReader reader;
			reader = new FileReader(PATHvertices);
		
         BufferedReader bufferedReader = new BufferedReader(reader);
         Queue<String> vertices = new Queue<String>();
         String line = "";
         while ((line = bufferedReader.readLine()) != null) {
             String datos = line;
             vertices.enqueue(datos);
             }
         grafito = new MiGrafo<>(vertices.size());
         while (vertices.size() != 0) {
        	 String[] completo = vertices.dequeue().split(",");
             int id = Integer.parseInt(completo[0]); 
             double latitud = Double.parseDouble(completo[1]);
             double longitud = Double.parseDouble(completo[2]);
             Lugar lugar = new Lugar(latitud, longitud);
             grafito.addVertex(id, lugar);
             
		}
         
         reader.close();
         
         
         
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void cargarArcos()
    {
         try {
                FileReader reader = new FileReader(PATHarcos);
                BufferedReader bufferedReader = new BufferedReader(reader);

                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    String[] datos = line.split(" ");
                   //sexo 
                    int primero = Integer.parseInt(datos[0]);
                    double startLat = grafito.getInfoVertex(primero).getLatitud();
					double startLong = grafito.getInfoVertex(primero).getLongitud();
                    for (int i = 1; i <= datos.length; i++) {
						
						int segundo = Integer.parseInt(datos[i]);
						double endLat = grafito.getInfoVertex(primero).getLatitud();
						double endLong = grafito.getInfoVertex(segundo).getLongitud();
						Haversine peso = new Haversine();
						grafito.addEdge(primero, segundo, peso.distance(startLat, startLong, endLat, endLong));
					}
                }
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
    }
	
	
	
	
}