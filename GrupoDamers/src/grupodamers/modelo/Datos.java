package grupodamers.modelo;

import java.util.ArrayList;

/**
 * Metodo que contiene los metodos genericos de la clase Datos
 */

public class Datos {

	ListaArticulos listaArticulos = new ListaArticulos();
	ListaClientes listaClientes = new ListaClientes();
	ListaPedidos listaPedidos = new ListaPedidos();

	public Datos() {
	}

	/**
	 * Metodo para añadir una articulo a la lista de articulos
	 */

	public void addArticulo(String codigo, String descripcion, double precioVenta, double gastoEnvio,
			int tiempoPreparacion) throws Exception {
		Articulo articulo = new Articulo(codigo, descripcion, precioVenta, gastoEnvio, tiempoPreparacion);
		this.listaArticulos.addElement(articulo);
	}

	/**
	 * Metodo para añadir un pedido a la lista de pedidos
	 */

	public void addPedido(String numPedido, Cliente cliente, Articulo articulo, int cantidad, String fecha)
			throws Exception {
		Pedido pedido = new Pedido(numPedido, cliente, articulo, cantidad, fecha);
		this.listaPedidos.addElement(pedido);
	}

	/**
	 * Metodo para añadir un cliente a la alista de clientes
	 */

	public void addCliente(String nombre, String domicilio, String nif, String email, boolean isPremium)
			throws Exception {

		if (isPremium) {
			ClientePremium cliente = new ClientePremium(nombre, domicilio, nif, email);
			this.listaClientes.addElement(cliente);
		} else {
			ClienteEstandar cliente = new ClienteEstandar(nombre, domicilio, nif, email);
			this.listaClientes.addElement(cliente);
		}
	}

	/**
	 * Metodo para obtener la lista de articulos
	 */

	public ArrayList<Articulo> getArticulos() {
		return this.listaArticulos.getLista();
	}

	/**
	 * Metodo para obtener la lista de pedidos
	 */

	public ArrayList<Pedido> getPedidos() {
		return this.listaPedidos.getLista();
	}

	/**
	 * Metodo para obtener la lista de clientes
	 */

	public ArrayList<Cliente> getClientes() {
		return this.listaClientes.getLista();
	}

	/**
	 * Metodo generico que comprueba si existe un elemento
	 */

	public boolean existeElemento(String identificador, String elemento) {
		boolean existe = false;

		switch (elemento) {
		case "cliente":
			existe = this.listaClientes.existe(identificador);
			break;
		case "pedido":
			existe = this.listaPedidos.existe(identificador);
			break;
		case "articulo":
			existe = this.listaArticulos.existe(identificador);
			break;
		default:
			break;
		}
		return existe;
	}

	/**
	 * Metodo para eliminar un pedido
	 */

	public void deletePedido(String numPedido) throws Exception {

		Pedido pedido = this.listaPedidos.getPedidoByNumPedido(numPedido);
		this.listaPedidos.deleteElement(pedido);
	}

	/**
	 * Metodo que obtiene un cliente dado un NIF
	 * @throws Exception 
	 */

	public Cliente getClienteByNif(String nif) throws Exception {
		return this.listaClientes.getClienteByNif(nif);
	}

	/**
	 * Metodo que obtiene un articulo dado un codigo de articulo
	 * @throws Exception 
	 */

	public Articulo getArticuloByCodigo(String codigo) throws Exception {
		return this.listaArticulos.getArticuloByCodigo(codigo);
	}

	/**
	 * Metodo que obtiene un pedido dado un numero de pedido
	 */

	public Pedido getPedidoByNumPedido(String numPedido) {
		return this.listaPedidos.getPedidoByNumPedido(numPedido);
	}

}
