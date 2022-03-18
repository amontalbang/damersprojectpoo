package grupodamers.modelo;

import java.util.ArrayList;

public class Lista<T> {
	
	protected ArrayList<T> lista;

	public Lista(ArrayList<T> lista) {
		this.lista = lista;
	}
	
	public void addElement(T elemento) {
		this.lista.add(elemento);
	}
	
	public ArrayList<T> getLista() {
		return this.lista;
	}

}
