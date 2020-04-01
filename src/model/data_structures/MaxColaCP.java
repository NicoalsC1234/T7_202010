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
	{ 
		return tamano;
	}

	public T agregar(T elemento)
	{
		Nodo<T> nuevo = new Nodo<T> (elemento);
		if(esVacia())
		{
			primero = nuevo;
			ultimo = nuevo;
			tamano++;
		}
		else if (tamano == 1)
		{
			if (primero.getActual().compareTo(nuevo.getActual()) < 0)
			{
				ultimo = primero;
				primero = nuevo; 
				primero.setSiguiente(ultimo);
				ultimo.setSiguiente(null);
				tamano++;
			}
			else if (primero.getActual().compareTo(nuevo.getActual()) >= 0)
			{
				ultimo = nuevo;
				primero.setSiguiente(nuevo);
				ultimo.setSiguiente(null);
				tamano ++;
			}	
		}
		else 
		{
			Nodo<T> comparar = primero;
			boolean x = false;
			while(!x)
			{
				if(primero.getActual().compareTo(nuevo.getActual()) < 0)
				{
					nuevo.setSiguiente(primero);
					primero = nuevo;
					x = true;
					tamano++;
				}
				else if(comparar.getActual().compareTo(nuevo.getActual()) < 0 )
				{
					Nodo<T> anterior = localizarNodoAnterior(comparar);
					anterior.setSiguiente(nuevo);
					nuevo.setSiguiente(comparar);
					x = true;
					tamano++;
				}
				else if (comparar.getSiguiente() == null)
				{
					ultimo.setSiguiente(nuevo);
					ultimo = nuevo;
					x = true;
					tamano ++;
				}
				comparar = comparar.getSiguiente();
			}
		}
		return nuevo.getActual();
	}

	public T sacarMax() 
	{
		Nodo<T> devolver = primero;
		if(tamano == 0)return null;
		else if(tamano ==1)
		{
			tamano --;
			ultimo = null;
			primero = null;
		}
		else 
		{
			primero = primero.getSiguiente();
			tamano --;
		}
		return devolver.getActual();
	}


	public T darMax()
	{
		Nodo<T> max = primero;	
		return max.getActual();
	}
	

	public boolean esVacia()
	{
		if(tamano == 0)return true;
		else return false;
	}

	// Método localizarNodoAnterior fue tomado y modificado de presentaciones de una sección de APO2.

	public Nodo localizarNodoAnterior(Nodo este)
	{
		Nodo<T> actual = primero;
		Nodo<T> anterior = null;
		while( actual != null && actual != este)
		{
			anterior = actual;
			actual = actual.getSiguiente(  );
		}
		if( actual != null )
			return anterior;
		else
			return null;
	}

	public Nodo<T> darPrimero() {
		
		return primero;
	}

	public Nodo<T> darUltimo() {
		
		return ultimo;
	}

	

}