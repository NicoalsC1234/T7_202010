package model.data_structures;

// Implementaciuón de max heap tomada y modificada de internet. URL: https://www.geeksforgeeks.org/max-heap-in-java/

public class MaxHeapCP<T extends Comparable<T>> { 

	private T[] Heap; 
	private int tamano; 
	private int max; 


	public MaxHeapCP(int maxsize) 
	{ 
		this.max = maxsize; 
		this.tamano = 0; 
		Heap = (T[]) new Object [this.max + 1]; 

	} 
	
	public int darNumElementos()
	{
		return tamano;
	}


	private int padre(int pos) 
	{ 
		return pos / 2; 
	} 

	private int hijoIzquierdo(int pos) 
	{ 
		return (2 * pos); 
	} 
	private int hijoDerecho(int pos) 
	{ 
		return (2 * pos) + 1; 
	} 


	private boolean esHoja(int pos) 
	{ 
		if (pos >= (tamano / 2) && pos <= tamano) { 
			return true; 
		} 
		return false; 
	} 

	private void swap(int fpos, int spos) 
	{ 
		Integer tmp; 
		tmp = (int) Heap[fpos]; 
		Heap[fpos] = Heap[spos]; 
		Heap[spos] = (T) tmp; 
	} 
 
	private void maxHeapify(int pos) 
	{ 
		if (esHoja(pos)) 
			return; 

		if (Heap[pos].compareTo(Heap[hijoIzquierdo(pos)]) == -1 ||  
				Heap[pos].compareTo(Heap[hijoDerecho(pos)]) == -1) { 

			if (Heap[hijoIzquierdo(pos)].compareTo(Heap[(pos)]) == 1) { 
				swap(pos, hijoIzquierdo(pos)); 
				maxHeapify(hijoDerecho(pos)); 
			} 
			else { 
				swap(pos, hijoDerecho(pos)); 
				maxHeapify(hijoIzquierdo(pos)); 
			} 
		} 
	} 


	public void agregar(T element) 
	{ 
		Heap[++tamano] = element; 

		int current = tamano; 
		while (Heap[current].compareTo(Heap[padre(current)]) == 1) { 
			swap(current, padre(current)); 
			current = padre(current); 
		} 
	} 

	public T sacarMax() 
	{ 
		T popped = Heap[1]; 
		Heap[1] = Heap[tamano--]; 
		maxHeapify(1); 
		return popped;
	}
	
	public boolean esVacia()
	{
		return tamano == 0? true:false;
	}
}