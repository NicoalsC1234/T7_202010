package model.data_structures;

import sun.misc.Queue;

//Tomado y modificado de https://github.com/kevin-wayne/algs4/blob/master/src/main/java/edu/princeton/cs/algs4/SeparateChainingHashST.java

public class SeparateChaining <Key, Value> {
	
	private static final int INIT_CAPACITY = 4;

    private int n;                               
    private int m;                               
    private BusquedaSecuencial<Key, Value>[] st; 


   
    public SeparateChaining() {
        this(INIT_CAPACITY);
    } 

    
    public SeparateChaining(int m) {
        this.m = m;
        st = (BusquedaSecuencial<Key, Value>[]) new BusquedaSecuencial[m];
        for (int i = 0; i < m; i++)
            st[i] = new BusquedaSecuencial<Key, Value>();
    } 

   
    private void resize(int chains) {
        SeparateChaining<Key, Value> temp = new SeparateChaining<Key, Value>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m  = temp.m;
        this.n  = temp.n;
        this.st = temp.st;
    }

    
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    } 

   
    public int size() {
        return n;
    } 

   
    public boolean isEmpty() {
        return size() == 0;
    } 

    
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int i = hash(key);
        return st[i].get(key);
    } 

    
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

       
        if (n >= 10*m) resize(2*m);

        int i = hash(key);
        if (!st[i].contains(key)) n++;
        st[i].put(key, val);
    } 

    
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");

        int i = hash(key);
        if (st[i].contains(key)) n--;
        st[i].delete(key);

        if (m > INIT_CAPACITY && n <= 2*m) resize(m/2);
    } 

    
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return (Iterable<Key>) queue;
    } 
    
    public BusquedaSecuencial<Key, Value> darUltimo()
    {
    	for(int i = st.length; i < 0; i--)
    	{
    		if(!st[i].isEmpty()) return st[i];
    	}
    	return null;
    }
    
    public BusquedaSecuencial<Key, Value> darPrimero()
    {
    	for(int i = 0; i < st.length; i++)
    	{
    		if(!st[i].isEmpty()) return st[i];
    	}
    	return null;
    }

}