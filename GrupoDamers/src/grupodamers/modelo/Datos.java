package grupodamers.modelo;

import java.util.ArrayList;

import grupodamers.modelo.factory.DAOFactory;
import grupodamers.modelo.dao.*;

/**
 * Metodo que contiene los metodos genericos de la clase Datos
 */

public class Datos {

	public Datos() {}

	/**
	 * Metodo para añadir una articulo a la lista de articulos
	 */

	public void addArticulo(String codigo, String descripcion, double precioVenta, double gastoEnvio,
			int tiempoPreparacion) throws Exception {
		Articulo articulo = new Articulo(codigo, descripcion, precioVenta, gastoEnvio, tiempoPreparacion);
		DAOArticuloImpl daoArticulo = DAOFactory.getArticulo();
		daoArticulo.add(articulo);
	}

	/**
	 * Metodo para añadir un pedido a la lista de pedidos
	 */

	public void addPedido(Cliente cliente, Articulo articulo, int cantidad, String fecha)
			throws Exception {
		Pedido pedido = new Pedido(cliente, articulo, cantidad, fecha);
		DAOPedidoImpl daoPedido = DAOFactory.getPedido();
		daoPedido.add(pedido);
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
		} else {
			ClienteEstandar cliente = new ClienteEstandar(nombre, domicilio, nif, email);
			DAOClienteEstandarImpl daoEstandar = DAOFactory.getClienteEstandar();
			daoEstandar.add(cliente);
		}
	}

	/**
	 * Metodo para obtener la lista de articulos
	 * @throws Exception 
	 */

	public ArrayList<Articulo> getArticulos() throws Exception {
		DAOArticuloImpl daoArticulo = DAOFactory.getArticulo();
		return daoArticulo.getAll();
	}

	/**
	 * Metodo para obtener la lista de pedidos
	 * @throws Exception 
	 */

	public ArrayList<Pedido> getPedidos() throws Exception {
		DAOPedidoImpl daoPedido = DAOFactory.getPedido();
		return daoPedido.getAll();
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
			DAOClienteImpl daoCliente = DAOFactory.getClienteEstandar();
			Cliente cliente = daoCliente.get(identificador);
			if(cliente != null) {
				return true;
			} else {
				return false;
			}
		case "pedido":
			DAOPedidoImpl daoPedido = DAOFactory.getPedido();
			Pedido pedido = daoPedido.get(identificador);
			if(pedido != null) {
				return true;
			} else {
				return false;
			}
		case "articulo":
			DAOArticuloImpl daoArticulo = DAOFactory.getArticulo();
			Articulo articulo = daoArticulo.get(identificador);
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
		Pedido pedido = daoPedido.get(numPedido);
		daoPedido.delete(pedido);
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
	}

	/**
	 * Metodo que obtiene un pedido dado un numero de pedido
	 * @throws Exception 
	 */

	public Pedido getPedidoByNumPedido(String numPedido) throws Exception {
		DAOPedidoImpl daoPedido = DAOFactory.getPedido();
		return daoPedido.get(numPedido);
	}

}
