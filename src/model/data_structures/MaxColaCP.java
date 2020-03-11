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
		Nodo nuevo = new Nodo (elemento);
		if(esVacia() == true)
		{
			primero = nuevo;
			ultimo = nuevo;
			tamano++;
		}
		else 
		{
			ultimo.setSiguiente(nuevo);
			ultimo = nuevo;
			tamano ++;
		}

		return elemento;
	}
	

	public T sacarMax() 
	{
		Nodo<T> max = (Nodo<T>) darMax();
		try {
			eliminarNodo(max);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (T) max;
	}
	

	public T darMax()
	{
	
	Nodo<T> max = primero;	
	if (tamano == 0)
		{
			return null;
		}
		else if(tamano == 1)
		{ 
			return (T)max;
		}
		else 
		{
			while(primero.getSiguiente() != null)
			{
				if(primero.getActual().compareTo((T) primero.getSiguiente()) == 1)
				{
					max = (Nodo<T>) primero.getActual();
				}
				else if(primero.getActual().compareTo((T) primero.getSiguiente()) == -1)
				{
					max = (Nodo<T>) primero.getSiguiente();
				}
				else {
				}
				
				primero = primero.getSiguiente();
			}
			
			return (T) max;
		}
	}

	public boolean esVacia()
	{
		if(tamano == 0)return true;
		else return false;
	}
	
	// Métodos localizarNodoAnterior y eliminarNodo fueron tomados y modificados de presentaciones de una sección de APO2.
	
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
	
	public void eliminarNodo( Nodo<T> este ) throws Exception 
	{
		if( primero == null )
		{
			throw new Exception("F");
		}
		
		else if( este == primero.getActual() )
            primero = primero.getSiguiente(  );
		else
		{
			Nodo<T> anterior = localizarNodoAnterior( este );
			Nodo<T> es = anterior.getSiguiente();
		       if( anterior == null )
		       		throw new Exception( "F2" );
		            es = es.getSiguiente();
		 }



	}
	
}
