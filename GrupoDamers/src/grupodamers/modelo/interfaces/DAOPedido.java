package grupodamers.modelo.interfaces;

import grupodamers.modelo.Pedido;

public interface DAOPedido {

	public void addPedido(Pedido pedido) throws Exception;
	public void deletePedido(Pedido pedido) throws Exception;
	public void existePedido(String numPedido) throws Exception;
	public void getPedidoByNumPedido(String numPedido) throws Exception;
	public void getListaPedidos() throws Exception;
	
}
