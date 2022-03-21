package grupodamers.controlador;

import java.util.ArrayList;
import java.util.HashMap;

import grupodamers.modelo.*;
import grupodamers.vista.GestionOS;

public class Controlador {

	Datos datos;
	GestionOS vista;

	public Controlador(Datos datos, GestionOS vista) {
		this.datos = datos;
		this.vista = vista;
	}

	public void gestionMenu() {
		String opt = "0";

		while (!opt.equals("11")) {
			opt = this.vista.gestionMenu();
			switch (opt) {
			case "0":
				this.gestionMenu();
				break;
			case "1":
				this.addCliente();
				break;
			case "2":
				this.addPedido();
				break;
			case "3":
				this.addArticulo();
				break;
			case "4":
				this.deletePedido();
				break;
			case "5":
				this.mostrarClientes();
				break;
			case "6":
				this.mostrarPremium();
				break;
			case "7":
				this.mostrarEstandar();
				break;
			case "8":
				this.mostrarArticulos();
				break;
			case "9":
				this.mostrarPedidosPendientes();
				break;
			case "10":
				this.mostrarPedidosEnviados();
				break;
			case "11":
				break;
			default:
				this.vista.mostrarInfoError("La opcion introducida no coincide con ninguna de las disponibles");
				break;
			}
		}
		System.out.println("La opcion escogida es " + opt);
	}

	public void addCliente() {
		HashMap<String, String> entrada;
		String nombre, domicilio, email, nif;
		boolean isPremium;

		entrada = this.vista.registerCliente(false);
		nombre = entrada.get("nombre");
		domicilio = entrada.get("domicilio");
		email = entrada.get("email");
		nif = entrada.get("nif");
		if (entrada.get("isPremium").equals("S")) {
			isPremium = true;
		} else {
			isPremium = false;
		}
		try {
			this.datos.addCliente(nombre, domicilio, nif, email, isPremium);
			this.vista.mostrarInfo("El cliente ha sido registrado satisfactoriamente.");
		} catch (Exception e) {
			this.vista.mostrarInfoError(e.getMessage());
		}
	}

	public void addPedido() {
		HashMap<String, String> entrada;
		String nif, numArticulo, cantidad, fecha, numPedido;
		int cantidadInt;
		Cliente cliente;
		Articulo articulo;

		entrada = this.vista.registerPedido();
		numPedido = entrada.get("numPedido");
		nif = entrada.get("nif");
		numArticulo = entrada.get("numArticulo");
		cantidad = entrada.get("cantidad");
		fecha = entrada.get("fecha");
		cantidadInt = 0;

		try {
			cantidadInt = Integer.parseInt(cantidad);
			if (!this.datos.existeElemento(numArticulo, "articulo")) {
				this.vista.mostrarInfoError("El articulo que desea introducir en el pedido no existe.");
			} else if (!this.datos.existeElemento(nif, "cliente")) {
				this.vista.registerCliente(true);
				cliente = this.datos.getClienteByNif(nif);
				articulo = this.datos.getArticuloByCodigo(numArticulo);
				this.datos.addPedido(numPedido, cliente, articulo, cantidadInt, fecha);
				this.vista.mostrarInfo("El pedido ha sido registrado correctamente.\n");
			} else {
				cliente = this.datos.getClienteByNif(nif);
				articulo = this.datos.getArticuloByCodigo(numArticulo);
				this.datos.addPedido(numPedido, cliente, articulo, cantidadInt, fecha);
				this.vista.mostrarInfo("El pedido ha sido registrado correctamente.\n");
			}
		} catch (NumberFormatException e) {
			System.out.println("El formato del campo 'Cantidad' no es valido, revíselo\n");
		} catch (Exception e) {
			this.vista.mostrarInfoError(e.getMessage());
		}
	}

	private void addArticulo() {
		HashMap<String, String> entrada;
		String descripcion, precioVenta, gastosEnvio, tiempoPrep, codigo;
		int tiempoPrepInt;
		double precioVentaInt, gastosEnvioInt;

		entrada = this.vista.registerArticulo();
		codigo = entrada.get("codigo");
		descripcion = entrada.get("descripcion");
		precioVenta = entrada.get("precioVenta");
		gastosEnvio = entrada.get("gastosEnvio");
		tiempoPrep = entrada.get("tiempoPreparacion");
		try {
			precioVentaInt = Double.parseDouble(precioVenta);
			gastosEnvioInt = Double.parseDouble(gastosEnvio);
			tiempoPrepInt = Integer.parseInt(tiempoPrep);
			this.datos.addArticulo(codigo, descripcion, precioVentaInt, gastosEnvioInt, tiempoPrepInt);
			this.vista.mostrarInfo("El articulo ha sido registrado correctamente.");
		} catch (NumberFormatException e) {
			this.vista.mostrarInfoError("El formato de los campos no es valido, revíselo\n");
			e.printStackTrace();
		} catch (Exception e) {
			this.vista.mostrarInfoError(e.getMessage());
			e.printStackTrace();
		}
	}

	public void deletePedido() {
		String numPedido;

		numPedido = this.vista.deletePedido();
		if (this.datos.existeElemento(numPedido, "pedido")) {
			try {
				this.datos.deletePedido(numPedido);
				this.vista.mostrarInfo("El pedido se ha eliminado correctamente.");
			} catch (Exception e) {
				this.vista.mostrarInfoError(e.getMessage());
			}
		} else {
			this.vista.mostrarInfoError("El pedido introducido no existe.");
		}
	}

	public void mostrarClientes() {
		ArrayList<Cliente> clientes;
		ArrayList<String> contenido = new ArrayList<>();

		clientes = this.datos.getClientes();
		for (Cliente cliente : clientes) {
			contenido.add(cliente.toString());
		}
		this.vista.mostrarListado(contenido, "cliente");
	}

	public void mostrarEstandar() {
		ArrayList<Cliente> clientes;
		ArrayList<String> contenido = new ArrayList<>();

		clientes = this.datos.getClientes();
		for (Cliente cliente : clientes) {
			if (cliente.tipoCliente().equals("estandar")) {
				contenido.add(cliente.toString());
			}
		}
		this.vista.mostrarListado(contenido, "cliente");
	}

	public void mostrarPremium() {
		ArrayList<Cliente> clientes;
		ArrayList<String> contenido = new ArrayList<>();

		clientes = this.datos.getClientes();
		for (Cliente cliente : clientes) {
			if (cliente.tipoCliente().equals("premium")) {
				contenido.add(cliente.toString());
			}
		}
		this.vista.mostrarListado(contenido, "cliente");
	}
	
	public void mostrarArticulos() {
		ArrayList<Articulo> articulos;
		ArrayList<String> contenido = new ArrayList<>();

		articulos = this.datos.getArticulos();
		for (Articulo articulo: articulos) {
			contenido.add(articulo.toString());
		}
		this.vista.mostrarListado(contenido, "articulo");
	}

	public void mostrarPedidosPendientes() {
		ArrayList<Pedido> pedidos;
		ArrayList<String> contenido = new ArrayList<>();
		String filtro;

		pedidos = this.datos.getPedidos();
		try {
			filtro = this.vista.filtroListadoPedidos();
			if (filtro.equals("premium")) {
				pedidos.forEach((pedido) -> {
					if (pedido.getCliente().tipoCliente().equals("premium") && !pedido.pedidoEnviado()) {
						contenido.add(pedido.toString());
					}
				});
			} else if (filtro.equals("estandar")) {
				pedidos.forEach((pedido) -> {
					if (pedido.getCliente().tipoCliente().equals("estandar") && !pedido.pedidoEnviado()) {
						contenido.add(pedido.toString());
					}
				});
			} else {
				pedidos.forEach((pedido) -> {
					if (!pedido.pedidoEnviado()) {
						contenido.add(pedido.toString());
					}
				});
			}
			this.vista.mostrarListado(contenido, "pedido");
		} catch (Exception e) {
			this.vista.mostrarInfoError(e.getMessage());
			e.printStackTrace();
		}
	}

	public void mostrarPedidosEnviados() {
		ArrayList<Pedido> pedidos;
		ArrayList<String> contenido = new ArrayList<>();
		String filtro;

		pedidos = this.datos.getPedidos();
		try {
			filtro = this.vista.filtroListadoPedidos();
			if (filtro.equals("premium")) {
				pedidos.forEach((pedido) -> {
					if (pedido.getCliente().tipoCliente().equals("premium") && pedido.pedidoEnviado()) {
						contenido.add(pedido.toString());
					}
				});
			} else if (filtro.equals("estandar")) {
				pedidos.forEach((pedido) -> {
					if (pedido.getCliente().tipoCliente().equals("estandar") && pedido.pedidoEnviado()) {
						contenido.add(pedido.toString());
					}
				});
			} else {
				pedidos.forEach((pedido) -> {
					if (pedido.pedidoEnviado()) {
						contenido.add(pedido.toString());
					}
				});
			}
			this.vista.mostrarListado(contenido, "pedido");
		} catch (Exception e) {
			this.vista.mostrarInfoError(e.getMessage());
		}
	}

}
