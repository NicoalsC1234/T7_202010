package model.data_structures;

public class Vertice<Key, Value> {

	private Key llave;
	
	private Value valores;
	
	private boolean marca;
	
	public void cambiarValores(Value valor)
	{
		valores = valor;
	}
	
	public void marcador()
	{
		marca = true;
	}
	
	public void desmarcador()
	{
		marca = false; 
	}

	public Key getLlave() {
		return llave;
	}

	public void setLlave(Key llave) {
		this.llave = llave;
	}


	public void setValores(Value valores) {
		this.valores = valores;
	}
	
}
