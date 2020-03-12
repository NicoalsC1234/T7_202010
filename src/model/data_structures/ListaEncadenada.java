package model.data_structures;

public class ListaEncadenada <T extends Comparable <T>>{
	private Nodo<T> primero;

	private int largo;
	
	

	public ListaEncadenada(){
		largo = 0;
		primero = null;
	}
	
	public Nodo darPrimero()
	{
		return primero;
	}

	public T buscar(int i)
	{
		Nodo<T> nodo = primero;
		int contador = 0;
		while(nodo != null)
		{
			if(i == contador)
			{
				return nodo.getActual();
			}
			nodo = nodo.getSiguiente();
			contador ++;
		}
		return null;
	}

	public T eliminar(int i)
	{
		Nodo<T> nodo = primero;
		int contador = 0;
		T retorno = null;
		if(i == 0)
		{
			primero = nodo.getSiguiente();
			largo --;
			retorno = buscar(i);
		}
		else
		{
			while(nodo != null)
			{
				if(i == contador+1)
				{
					nodo.setSiguiente(nodo.getSiguiente().getSiguiente());
					largo --;
					retorno = buscar(i);
					break;
				}
				nodo = nodo.getSiguiente();
				contador ++;
			}
		}
		
		return retorno;
		
		
	}

	public void agregar(T dato)
	{
		Nodo<T> nodo = primero;
		Nodo<T> nuevo = new Nodo<T>(dato);
		while(nodo.getSiguiente() != null)
		{
			nodo = nodo.getSiguiente();
		}
		nodo.setSiguiente(nuevo);
		largo ++;
	}
	
	public int darLargo()
	{
		return largo;
	}

	public boolean esVacia()
	{
		if(largo == 0)
		{
			return false;
		}
		return true;
	}
}
