package grupodamers.modelo;

import java.util.ArrayList;

public class Datos {
	
	ListaArticulos listaArticulos = new ListaArticulos();
	ListaClientes listaClientes = new ListaClientes();
	ListaPedidos listaPedidos = new ListaPedidos();

	public Datos() {}
	
	public void addArticulo(String descripcion, double precioVenta, double gastoEnvio, int tiempoPreparacion ) throws Exception {
		this.listaArticulos.addElement(new Articulo());
	}
	
	public void addPedido(String cliente, String articulo, int cantidad, String fecha) throws Exception {
		this.listaPedidos.addElement(new Pedido());
	}
	
	public void addCliente (String nombre, String domicilio, String nif, String email, boolean isPremium) throws Exception {
		
		if (isPremium) {
			ClientePremium cliente = new ClientePremium(nombre, domicilio, nif, email);
			System.out.println(cliente.toString());
			this.listaClientes.addElement(cliente);
		} else {
			ClienteEstandar cliente = new ClienteEstandar(nombre, domicilio, nif, email);
			this.listaClientes.addElement(cliente);
		}
	}
	
	public ArrayList<Articulo> getArticulos() {
		return this.listaArticulos.getLista();
	}
	
	public ArrayList<Pedido> getPedidos() {
		return this.listaPedidos.getLista();
	}
	
	public ArrayList<Cliente> getClientes() {
		return this.listaClientes.getLista();
	}
	
	public boolean existeElemento(String identificador, String elemento) {
		boolean existe = false;
		
		switch(elemento) {
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
	
	public void deletePedido (String numPedido) throws Exception {
		
		
		Pedido pedido = this.listaPedidos.getPedidoByNumPedido(numPedido);
		this.listaPedidos.deleteElement(pedido);
	}

}
