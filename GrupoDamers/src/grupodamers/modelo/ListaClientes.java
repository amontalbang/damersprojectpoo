package grupodamers.modelo;

public class ListaClientes extends Lista<Cliente> {

	public void addElement(Cliente cliente) throws Exception{
		if (existe(cliente.getNif())) {
			throw new Exception("Ya existe un cliente registrado con ese NIF.\n");
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
