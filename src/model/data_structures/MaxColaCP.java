package model.data_structures;


public class MaxColaCP <T  extends Comparable<T>>{

	private int tamano;

	private Nodo<T> primero;

	private Nodo<T> ultimo;

	public MaxColaCP()
	{
		primero = null;
		ultimo = null;
		tamano = 0;

	}

	public int darNumElementos()
	{ q1
		return tamano;
	}

	public void agregar(T elemento)
	{
		Nodo<T> nuevo = new Nodo<T> (elemento);
		T actual = primero.getActual();
		if(tamano == 0){
			primero = nuevo;
			ultimo = nuevo;
			tamano++;
		}
		else if(tamano == 1)
		{
			if(actual.compareTo(elemento) == 0)
			{
				
			}
		}
		else {
			boolean y = false;
			while(y != true){
				T actual = (T) primero;
				int x = actual.compareTo(elemento);
				if (x > 0)
				{

				}


			}
		}
	}

	public T sacarMax()
	{
		Nodo<T> eliminar = primero;
		if (tamano == 0)
		{
			return null;
			
		}
		else if(tamano == 1)
		{ 
			primero = null;
		}
		else if(tamano != 0)
		{
			while(primero.getSiguiente() != null)
			{
				if(primero.getActual())
			
				
				
				primero = primero.getSiguiente();
			}
			
		}
	
		tamano--;
		return eliminar;
	}

	public T darMax()
	{
		return primero.getActual();
	}

	public boolean esVacia()
	{
		if(tamano == 0)return true;
		else return false;
	}

}
