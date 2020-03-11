package model.data_structures;

// Implementaciuón de max heap escalada que encontré en internet

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
	        int tmp; 
	        tmp = Heap[fpos]; 
	        Heap[fpos] = Heap[spos]; 
	        Heap[spos] = tmp; 
	    } 
	  
	    // A recursive function to max heapify the given 
	    // subtree. This function assumes that the left and 
	    // right subtrees are already heapified, we only need 
	    // to fix the root. 
	    private void maxHeapify(int pos) 
	    { 
	        if (isLeaf(pos)) 
	            return; 
	  
	        if (Heap[pos] < Heap[leftChild(pos)] ||  
	            Heap[pos] < Heap[rightChild(pos)]) { 
	  
	            if (Heap[leftChild(pos)] > Heap[rightChild(pos)]) { 
	                swap(pos, leftChild(pos)); 
	                maxHeapify(leftChild(pos)); 
	            } 
	            else { 
	                swap(pos, rightChild(pos)); 
	                maxHeapify(rightChild(pos)); 
	            } 
	        } 
	    } 
	  
	    // Inserts a new element to max heap 
	    public void insert(int element) 
	    { 
	        Heap[++size] = element; 
	  
	        // Traverse up and fix violated property 
	        int current = size; 
	        while (Heap[current] > Heap[parent(current)]) { 
	            swap(current, parent(current)); 
	            current = parent(current); 
	        } 
	    } 
	  
	    public void print() 
	    { 
	        for (int i = 1; i <= size / 2; i++) { 
	            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + 
	                      Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]); 
	            System.out.println(); 
	        } 
	    } 
	  
	    // Remove an element from max heap 
	    public int extractMax() 
	    { 
	        int popped = Heap[1]; 
	        Heap[1] = Heap[size--]; 
	        maxHeapify(1); 
	        return popped; 
	    }