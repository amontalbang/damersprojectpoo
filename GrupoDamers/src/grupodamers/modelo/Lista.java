package grupodamers.modelo;

import java.util.ArrayList;

/**
 * Metodo que contiene los metodos de la clase Lista
 */

public class Lista<T> {
	
	protected ArrayList<T> lista;
	
	public Lista() {
		lista = new ArrayList<>();
	}
	
	/**
	 * Metodo para obtener el tamaño de una lista
	 */
	
	public int getSize() {
		return this.lista.size();
	}
	
	/**
	 * Metodo que añade un elemento a una lista
	 */
	
	public void addElement(T elemento) throws Exception {
		this.lista.add(elemento);
	}
	
	/**
	 * Metodo que elimina un elemento de una lista
	 */
	
	public void deleteElement(T element) throws Exception {
		this.lista.remove(element);
	}
	
	/**
	 * Metodo que muestra el elemento de una lista
	 */
	
	public T getElem(int position) {
		return this.lista.get(position);
	}
	
	/**
	 * Metodo que comprueba si una lista esta vacia
	 */
	
	public boolean isEmpty() {
		return lista.isEmpty();
	}
	
	/**
	 * Metodo que devuelve una lista
	 */
	
	public ArrayList<T> getLista() {
		return this.lista;
	}

}
