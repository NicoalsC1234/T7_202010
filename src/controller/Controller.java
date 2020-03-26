package controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.data_structures.*;

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

					modelo.cargarDatos();
					view.printMessage("Se han creado las tablas y se han leido los datos");
					int numero = reader.next().;
					view.printMessage("El numero de datos leidos es : " + numero);
					view.printMessage("Primero: " + modelo.darPrimero());
					view.printMessage("Primero: " + modelo.darUltimo());

				case 2:


					// falta.
				} 


			}
		}


		catch (InputMismatchException e) {

			run();

		}

	}

}