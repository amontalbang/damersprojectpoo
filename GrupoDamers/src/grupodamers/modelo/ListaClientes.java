package grupodamers.modelo;

import java.util.ArrayList;

public class ListaClientes extends Lista<Cliente> {

	public void addElement(Cliente cliente) throws Exception{
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		if (existe(cliente.getNif())) {
			throw new Exception("Ya existe un cliente registrado con ese NIF.");
		} else {
			this.lista.add(cliente);
		}
	}
	
	public boolean existe(String nif) {
		boolean existe = false;
		
		for (Cliente cliente: this.lista) {
			if (cliente.getNif().equals(nif)) {
				existe = true;
				return existe;
			}
		}
		
		return existe;
	}

}
