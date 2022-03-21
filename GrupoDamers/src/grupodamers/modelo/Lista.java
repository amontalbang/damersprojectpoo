package grupodamers.modelo;

import java.util.ArrayList;

public class Lista<T> {
	
	protected ArrayList<T> lista;

	public Lista() {
		lista = new ArrayList<>();
	}
	
	public int getSize() {
		return this.lista.size();
	}
	
	public void addElement(T elemento) throws Exception {
		this.lista.add(elemento);
	}
	
	public void deleteElement(T element) throws Exception {
		this.lista.remove(element);
	}
	
	public T getElem(int position) {
		return this.lista.get(position);
	}
	
	public boolean isEmpty() {
		return lista.isEmpty();
	}
	
	public ArrayList<T> getLista() {
		return this.lista;
	}

}
