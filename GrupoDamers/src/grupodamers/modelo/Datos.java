package grupodamers.modelo;

import java.util.ArrayList;

import grupodamers.modelo.factory.DAOFactory;
import grupodamers.modelo.dao.*;

/**
 * Metodo que contiene los metodos genericos de la clase Datos
 */

public class Datos {

	// ListaArticulos listaArticulos = new ListaArticulos();
	// ListaClientes listaClientes = new ListaClientes();
	// ListaPedidos listaPedidos = new ListaPedidos();

	public Datos() {}

	/**
	 * Metodo para añadir una articulo a la lista de articulos
	 */

	public void addArticulo(String codigo, String descripcion, double precioVenta, double gastoEnvio,
			int tiempoPreparacion) throws Exception {
		Articulo articulo = new Articulo(codigo, descripcion, precioVenta, gastoEnvio, tiempoPreparacion);
		DAOArticuloImpl daoArticulo = DAOFactory.getArticulo();
		daoArticulo.add(articulo);
		
		// this.listaArticulos.addElement(articulo);
	}

	/**
	 * Metodo para añadir un pedido a la lista de pedidos
	 */

	public void addPedido(Cliente cliente, Articulo articulo, int cantidad, String fecha)
			throws Exception {
		Pedido pedido = new Pedido(cliente, articulo, cantidad, fecha);
		DAOPedidoImpl daoPedido = DAOFactory.getPedido();
		daoPedido.add(pedido);
		
		// this.listaPedidos.addElement(pedido);
	}

	/**
	 * Metodo para añadir un cliente a la alista de clientes
	 */

	public void addCliente(String nombre, String domicilio, String nif, String email, boolean isPremium)
			throws Exception {

		if (isPremium) {
			ClientePremium cliente = new ClientePremium(nombre, domicilio, nif, email);
			DAOClientePremiumImpl daoPremium = DAOFactory.getClientePremium();
			daoPremium.add(cliente);
			
			// this.listaClientes.addElement(cliente);
		} else {
			ClienteEstandar cliente = new ClienteEstandar(nombre, domicilio, nif, email);
			DAOClienteEstandarImpl daoEstandar = DAOFactory.getClienteEstandar();
			daoEstandar.add(cliente);
			
			// this.listaClientes.addElement(cliente);
		}
	}

	/**
	 * Metodo para obtener la lista de articulos
	 * @throws Exception 
	 */

	public ArrayList<Articulo> getArticulos() throws Exception {
		DAOArticuloImpl daoArticulo = DAOFactory.getArticulo();
		return daoArticulo.getAll();
		// return this.listaArticulos.getLista();
	}

	/**
	 * Metodo para obtener la lista de pedidos
	 * @throws Exception 
	 */

	public ArrayList<Pedido> getPedidos() throws Exception {
		DAOPedidoImpl daoPedido = DAOFactory.getPedido();
		return daoPedido.getAll();
		// return this.listaPedidos.getLista();
	}

	/**
	 * Metodo para obtener la lista de clientes
	 * @throws Exception 
	 */

	public ArrayList<Cliente> getClientes() throws Exception {
		ArrayList<Cliente> clientes = new ArrayList<>();
		DAOClientePremiumImpl daoClientePremium = DAOFactory.getClientePremium();
		DAOClienteEstandarImpl daoClienteEstandar = DAOFactory.getClienteEstandar();
		
		for (Cliente cliente : daoClientePremium.getAll()) {
			clientes.add(cliente);
		}
		for (Cliente cliente : daoClienteEstandar.getAll()) {
			clientes.add(cliente);
		}
		
		return clientes;
	}

	/**
	 * Metodo generico que comprueba si existe un elemento
	 * @throws Exception 
	 */

	public boolean existeElemento(String identificador, String elemento) throws Exception {

		switch (elemento) {
		case "cliente":
			// existe = this.listaClientes.existe(identificador);
			DAOClienteImpl daoCliente = DAOFactory.getClienteEstandar();
			Cliente cliente = daoCliente.get(identificador);
			/*if(!cliente.getNif().isEmpty() && cliente.getNif().equalsIgnoreCase(identificador)) {
				return true;
			} else {
				return false;
			}*/
			if(cliente != null) {
				return true;
			} else {
				return false;
			}
		case "pedido":
			// existe = this.listaPedidos.existe(identificador);
			DAOPedidoImpl daoPedido = DAOFactory.getPedido();
			Pedido pedido = daoPedido.get(identificador);
			/*if(!pedido.getNumPedido().isEmpty() && pedido.getNumPedido().equalsIgnoreCase(identificador)) {
				return true;
			} else {
				return false;
			}*/
			if(pedido != null) {
				return true;
			} else {
				return false;
			}
		case "articulo":
			// existe = this.listaArticulos.existe(identificador);
			DAOArticuloImpl daoArticulo = DAOFactory.getArticulo();
			Articulo articulo = daoArticulo.get(identificador);
			/*if(!articulo.getCodigo().isEmpty() && articulo.getCodigo().equalsIgnoreCase(identificador)) {
				return true;
			} else {
				return false;
			}*/
			if(articulo != null) {
				return true;
			} else {
				return false;
			}
		default:
			return false;
		}
	}

	/**
	 * Metodo para eliminar un pedido
	 */

	public void deletePedido(String numPedido) throws Exception {
		DAOPedidoImpl daoPedido = DAOFactory.getPedido();
		// Pedido pedido = this.listaPedidos.getPedidoByNumPedido(numPedido);
		Pedido pedido = daoPedido.get(numPedido);
		daoPedido.delete(pedido);

		// this.listaPedidos.deleteElement(pedido);
	}

	/**
	 * Metodo que obtiene un cliente dado un NIF
	 * @throws Exception 
	 */

	public Cliente getClienteByNif(String nif) throws Exception {
		DAOClienteImpl daoCliente = DAOFactory.getClienteEstandar();
		Cliente cliente = daoCliente.get(nif);
		return cliente;
	}

	/**
	 * Metodo que obtiene un articulo dado un codigo de articulo
	 * @throws Exception 
	 */

	public Articulo getArticuloByCodigo(String codigo) throws Exception {
		DAOArticuloImpl daoArticulo = DAOFactory.getArticulo();
		return daoArticulo.get(codigo);

		// return this.listaArticulos.getArticuloByCodigo(codigo);
	}

	/**
	 * Metodo que obtiene un pedido dado un numero de pedido
	 * @throws Exception 
	 */

	public Pedido getPedidoByNumPedido(String numPedido) throws Exception {
		DAOPedidoImpl daoPedido = DAOFactory.getPedido();
		return daoPedido.get(numPedido);
		
		// return this.listaPedidos.getPedidoByNumPedido(numPedido);
	}

}
