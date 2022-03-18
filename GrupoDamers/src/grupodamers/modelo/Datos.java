package grupodamers.modelo;

import java.util.ArrayList;

public class Datos {
	
	ListaArticulos listaArticulos;
	ListaClientes listaClientes;
	ListaPedidos listaPedidos;

	public Datos() {}
	
	public void addArticulo(String descripcion, double precioVenta, double gastoEnvio, int tiempoPreparacion ) {
		this.listaArticulos.addElement(new Articulo());
	}
	
	public void addPedido(String cliente, String articulo, int cantidad, String fecha) {
		this.listaPedidos.addElement(new Pedido());
	}
	
	public void addCliente (String nombre, String domicilio, String nif, String email, boolean isPremium) {
		
		if (isPremium) {
			this.listaClientes.addElement(new ClientePremium(nombre, domicilio, nif, email));
		} else {
			this.listaClientes.addElement(new ClienteEstandar(nombre, domicilio, nif, email));
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

}
