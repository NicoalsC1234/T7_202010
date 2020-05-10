package model.data_structures;

import java.util.ArrayList;
import java.util.Iterator;

import algs4.*;


public class MiGrafo<K, V> {

	private EdgeWeightedGraph grafo;
	private SeparateChainingHashST<K, Integer> llaveAEntero;
	private SeparateChainingHashST<Integer, K> enteroALlave;
	private SeparateChainingHashST<K, Vertice<K, V>> llaveAInfoVertex;

	private int V = 0;

	public MiGrafo(int tamano) {
		grafo = new EdgeWeightedGraph(tamano);
		llaveAEntero = new SeparateChainingHashST<K, Integer>();
		llaveAInfoVertex = new SeparateChainingHashST<K, Vertice<K,V>>();
		enteroALlave = new SeparateChainingHashST<Integer, K>();
	}

	public int V()
	{
		return grafo.V();
	}

	public int E()
	{
		return grafo.E();
	}

	public void addEdge(K from, K to, double peso) {

		if(!llaveAEntero.contains(from)) {
			llaveAEntero.put(from, V);
			enteroALlave.put(V, from);
			V++;
		}
		int fromEntero = llaveAEntero.get(from);

		if(!llaveAEntero.contains(to)) {
			llaveAEntero.put(to, V);
			enteroALlave.put(V, to);
			V++;
		}
		int toEntero = llaveAEntero.get(to);

		grafo.addEdge(new Edge(fromEntero, toEntero, peso));
	}

	public Vertice getInfoVertex(K key) {
		return llaveAInfoVertex.get(key);
	}

	public void setInfoVertex(K key, Vertice info)
	{
		llaveAInfoVertex.put(key, info);
	}
	
	public void uncheck()
	{
		Iterable<K> iter = llaveAInfoVertex.keys();
		for (K k : iter) {
			llaveAInfoVertex.get(k).desmarcador();
		}
	}

	public void addVertex(K key, Vertice info) {
		llaveAInfoVertex.put(key, info);
		if(!llaveAEntero.contains(key)) {
			llaveAEntero.put(key, V);
			enteroALlave.put(V, key);
			V++;
		}
	}

	public Iterable<K> getCC(K key) {
		CC cc = new CC (grafo);
		ArrayList<K> lista = new ArrayList<K>();

		for(int v = 0; v < grafo.V(); v++) {
			if(cc.id(v) == cc.id(llaveAEntero.get(key))) {
				lista.add(enteroALlave.get(v));
			}
		}
		return lista;
	}


	public Iterable<K> adj(K key) {
		Iterable<Edge> a = grafo.adj(llaveAEntero.get(key));

		ArrayList<K> resultado = new ArrayList<K>();
		for(Edge e: a) {
			int v = e.other(llaveAEntero.get(key));
			resultado.add(enteroALlave.get(v));
		}
		return resultado;
	}



}