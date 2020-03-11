package model.data_structures;

public class MaxHeapCP<T extends Comparable<T>> {

	private int tamano;
	
	private Nodo<T> primero;
	
	public MaxHeapCP()
	{
		primero = null;
		tamano = 0;
		
	}
	
	public int darNumElementos()
	{
		return tamano;
	}
	
	public void agregar(T elemento)
	{
		Nodo<T> nuevo = new Nodo<T> (elemento);
		if(tamano == 0){
			primero = nuevo;
			tamano++;
		}
		else {
			
		}
	}
	
	public T sacarMax()
	{
		if(esVacia())return null;
		
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
