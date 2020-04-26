package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.management.Query;

import model.data_structures.Comparendo;
import model.data_structures.Queue;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() throws ParseException 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";
		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option)
			{
			case 0 :
				view.printMessage("--------- \nCarga de datos \nCargando comparendos...");
				modelo = new Modelo( );
				long startTimeCarga = System.currentTimeMillis();
				view.printMessage(modelo.agregar() + "\n---------");
				long endTimeCarga = System.currentTimeMillis();
				long durationCarga = endTimeCarga - startTimeCarga;
				view.printMessage("Tiempo de carga: " + durationCarga + " milisegundos");
				view.printMessage("Proceso terminado");
				break;

			case 1 :
				// Requerimiento 1A
				view.printMessage("Ingresar el numero de elementos a ingresar");
				String numero1A = lector.next();
				int m = Integer.parseInt(numero1A);
				Queue<Comparendo> res = new Queue<>();
				res = modelo.req1a(m);
				for (Comparendo iterabl : res) {
				view.printMessage(iterabl.darDatos());
				}

				break;

			case 2 :
				// Requerimiento 2A
				view.printMessage("Escribir el numero del mes (1-12) del cual quiere saber los comparendos");
				int primer = Integer.parseInt(lector.next());
				view.printMessage("Escribir el numero del dia (1-7) del cual quiere saber los comparendos");
				int segundo = Integer.parseInt(lector.next());
				view.printMessage("Estos son los datos de los comparendos de la fecha: ");
				
				for (int i = 0; i < modelo.buscarComparendosPorMesyDia(primer, segundo).size(); i++) {
					view.printMessage("OBJECTID: " + modelo.buscarComparendosPorMesyDia(primer, segundo).get(i).darId() );
					view.printMessage("TIPO SERVICIO: " + modelo.buscarComparendosPorMesyDia(primer, segundo).get(i).darTipo() );
					view.printMessage("INFRACCION: " + modelo.buscarComparendosPorMesyDia(primer, segundo).get(i).darInfraccion());
					view.printMessage("FECHA - HORA: " + modelo.buscarComparendosPorMesyDia(primer, segundo).get(i).darFechaHora());
					view.printMessage("CLASE VEHI: " + modelo.buscarComparendosPorMesyDia(primer, segundo).get(i).darClase());
				

				break;
				}

			case 3 : 
				// Requerimiento 3A
				view.printMessage("Ingresar una localidad");
				String localidad = lector.next();
				view.printMessage("Ingresar la primera fecha");
				String fecha1 = lector.next();
				SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
				Date f1 = new Date();
				f1=	sdf.parse(fecha1);
				view.printMessage("Ingresar la Segunda fecha");
				String fecha2 = lector.next();
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyy-MM-dd");
				Date f2 = new Date();
				f2=	sdf2.parse(fecha2);
				Queue<Comparendo> respuestaa = new Queue<>();
				respuestaa = modelo.req3A(f1,f2,localidad);
				for (Comparendo iterabl : respuestaa) {
					view.printMessage(iterabl.darDatos());
				}
				break;

			case 4 : 
				view.printMessage("Ingresar el numero de comparendos que desea revisar cercanos a la estación de policia del campin");
				int gg = Integer.parseInt(lector.next());
				view.printMessage("Estos son los comparendos mas cercanos a la estación: ");
				Queue<Comparendo> respuestaaa = new Queue<>();
				respuestaaa = modelo.req1b(gg);
				for(Comparendo itr: respuestaaa)
				{
					view.printMessage(itr.darDatos());
				}

				break;	

			case 5 :
				// Requerimiento 2B
				view.printMessage("Ingresar una localidad");
				String localidad2b = lector.next();
				view.printMessage("Ingresar una medio de detecion");
				String detecion = lector.next();
				view.printMessage("Ingresar un tipo");
				String tipo = lector.next();
				view.printMessage("Ingresar una clase");
				String clase = lector.next();
				respuestaa = modelo.req2B(detecion, clase, tipo, localidad2b);
				for (Comparendo iterabl : respuestaa) {
					view.printMessage(iterabl.darDatos());
				}
				break;
				
			case 6 :
				//Requerimiento 3B
				view.printMessage("Ingresar un tipo");
				String tipo3B = lector.next();
				view.printMessage("Ingresar la primera latitud");
				String lat1 = lector.next();
				double latitud1 = Double.parseDouble(lat1);
				view.printMessage("Ingresar la segunda latitud");
				String lat2 = lector.next();
				double latitud2 = Double.parseDouble(lat2);
				Queue<Comparendo> respuestaas = new Queue<>();
				respuestaa = modelo.req3B(latitud1, latitud2, tipo3B);
				for (Comparendo iterabl : respuestaas) {
					view.printMessage(iterabl.darDatos());
				}
				break;

			case 7 : 
				// Requerimiento 1C
			
				break;

			case 8 :
				// Requerimiento 2C
			
				break;

			case 9  :  
				// Requerimiento 3C
				

			case 10 :
				view.printMessage("--------- \n Bye bye \n---------"); 
				lector.close();
				fin = true;
				break;

			default: 
				view.printMessage("--------- \n Opcion Invalida \n---------");
				break;
			}
		}

	}	
}