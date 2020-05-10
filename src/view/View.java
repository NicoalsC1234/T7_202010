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
			
			
		}

		public void printMessage(String mensaje) 
		{
			System.out.println(mensaje);
		}		
}