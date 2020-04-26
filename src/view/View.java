package view;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");

			System.out.println("\n 0) Requerimiento 0: Cargar datos");
			
			System.out.println("\n 1) Requerimiento 1A. Consultar el primer comparendo por Localidad (ANTONIO_NARIÑO, BARRIOS_UNIDOS, BOSA, CANDELARIA, CHAPINERO, ENGATIVA, FONTIBON, KENNEDY, MARTIRES, PUENTE_ARANDA, RAFAEL_URIBE, SAN_CRISTOBAL, SANTA_FE, SUBA, SUMAPAZ, TEUSAQUILLO, TUNJUELITO, USAQUEN, USME");
			System.out.println("\n 2) Requerimiento 2A. Consultar los comparendos por Fecha (Escribir con formato: yyyy-MM-dd)");
			System.out.println("\n 3) Requerimiento 3A. Comparar los comparendos por cada codigo Infraccion, en dos Fechas (Cada Fecha debe estar en formato: yyyy-MM-dd)");

			System.out.println("\n 4) Requerimiento 1B. Consultar el primer comparendo por codigo Infraccion");
			System.out.println("\n 5) Requerimiento 2B. Consultar los comparendos por codigo Infraccion");
			System.out.println("\n 6) Requerimiento 3B. Comparar los comparendos por cada código Infraccion en los Tipos de Servicio: Particular y Publico");
			
			System.out.println("\n 7) Requerimiento 1C. Mostrar el número de comparendos por cada código Infraccion en una Localidad dada, para un periodo de tiempo dado por: Fecha inicial y Fecha Final. (Cada Fecha debe estar en formato: yyyy-MM-dd)");
			System.out.println("\n 8) Requerimiento 2C. Consultar la información de los N códigos INFRACCION con más infracciones ordenados de mayor a menor en un periodo de tiempo dado por: Fecha Inicial y Fecha Final. (Cada Fecha debe estar en formato: yyyy-MM-dd)");
			System.out.println("\n 9) Requerimiento 3C. Generar gráfica ASCII (Histograma) que muestre el número total de comparendos por cada Localidad ");
			
			System.out.println("\n 10) Salir del programa");
		}

		public void printMessage(String mensaje) 
		{
			System.out.println(mensaje);
		}		
}