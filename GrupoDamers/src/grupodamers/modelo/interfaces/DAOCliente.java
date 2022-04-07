package grupodamers.modelo.interfaces;

import grupodamers.modelo.Cliente;

public interface DAOCliente {
	
	public void addCliente(Cliente cliente) throws Exception;
	public void deleteCliente(Cliente cliente) throws Exception;
	public void getNumeroClientes() throws Exception;
	public void existeCliente(Cliente cliente) throws Exception;
	public void getClienteByNif(String nif) throws Exception;
	public void getListaClientes() throws Exception;
	
}
