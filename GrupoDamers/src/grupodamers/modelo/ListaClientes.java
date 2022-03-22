package grupodamers.modelo;

public class ListaClientes extends Lista<Cliente> {
	
	/**
	 * Metodo que añade un cliente a la lista de clientes
	 */

	public void addElement(Cliente cliente) throws Exception{
		if (existe(cliente.getNif())) {
			throw new Exception("\n*** Ya existe un cliente registrado con ese NIF. ***\n");
		} else {
			this.lista.add(cliente);
		}
	}
	
	/**
	 * Metodo que comprrueba si existe un cliente
	 * @return boolean existe
	 */
	
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
	
	/**
	 * Metodo que devuelve un cliente dado un NIF
	 * @return cliente
	 */
	
	public Cliente getClienteByNif(String nif) {
		Cliente cliente = null;
		
		for (Cliente c: this.lista) {
			if (c.getNif().equals(nif)) {
				cliente = c;
				break;
			}
		}
		return cliente;
		
	}

}
