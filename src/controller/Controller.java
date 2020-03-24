 package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.data_structures.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller <T extends Comparable<T>>{

	private Modelo modelo;
	
	private View view;
	
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
	
	 public void run() throws InputMismatchException {

	        try {

	            Scanner reader = new Scanner(System.in);

	            boolean end = false;



	            while (!end) {

	                view.printMenu();

	                int option = reader.nextInt();

	                switch (option) {



	                    case 1:
	              
	                    	modelo.cargarDatosEnSeparate();
	                    	view.printMessage("Se ha creado la Tabla de Separate Hash");
	                    	int numero1 = reader.next().;
	                    	view.printMessage("El numero de datos leidos es : " + numero);
	                    	view.printMessage(modelo.darUltimo().toString());
	                    	view.printMessage(modelo.darPrimero().toString());
	                    case 2:
	                    	modelo.cargarDatosEnLinear();
	                    	view.printMessage("Se ha creado la Tabla de Linear Hash");
	                    	int numero2 = reader.next().;
	                    	view.printMessage("El numero de datos leidos es : " + numero);
	                    	
	                    
	                    	// falta.
	                } 
	                
	                
	            }
	        }
	                
	            
	            catch (InputMismatchException e) {

	            run();

	        }

	    }

	 }