package grupodamers.controlador;

import java.util.ArrayList;
import java.util.HashMap;

import grupodamers.modelo.*;
import grupodamers.vista.GestionOS;

/**
 * Metodo que contiene los metodos de la clase Controlador
 */

public class Controlador {

	Datos datos;
	GestionOS vista;

	public Controlador(Datos datos, GestionOS vista) {
		this.datos = datos;
		this.vista = vista;
	}
	
	/**
	 * Metodo que implementa el menu principal
	 */

	public void gestionMenu() {
		String opt = "0";

		while (!opt.equals("11")) {
			opt = this.vista.gestionMenu();
			switch (opt) {
			case "0":
				this.gestionMenu();
				break;
			case "1":
				this.addArticulo();				
				break;
			case "2":
				this.mostrarArticulos();
				break;
			case "3":
				this.addCliente();
				break;
			case "4":
				this.mostrarClientes();				
				break;
			case "5":
				this.mostrarEstandar();
				break;
			case "6":
				this.mostrarPremium();
				break;
			case "7":
				this.addPedido();
				break;
			case "8":
				this.deletePedido();
				break;
			case "9":
				this.mostrarPedidosPendientes();
				break;
			case "10":
				this.mostrarPedidosEnviados();
				break;
			case "11":
				this.vista.mostrarInfo("\n***Gracias por utilizar nuestra aplicación.***\n");
				break;
			default:
				this.vista.mostrarInfoError("\n*** La opcion introducida no coincide con ninguna de las disponibles ***");
				break;
			}
		}
	}
	
	/**
	 * Metodo que implementa la adicion de un cliente
	 */

	public void addCliente() {
		HashMap<String, String> entrada;
		String nombre, domicilio, email, nif;
		boolean isPremium = false, valido = true;

		entrada = this.vista.registerCliente();
		nombre = entrada.get("nombre");
		domicilio = entrada.get("domicilio");
		email = entrada.get("email");
		nif = entrada.get("nif");
		if (entrada.get("isPremium").equals("S")) {
			isPremium = true;
		} else if (entrada.get("isPremium").equals("N")){
			isPremium = false;
		} else {
			valido = false;
			this.vista.mostrarInfoError("\n***El tipo del cliente no es válido***\n");
		}
		if (valido) {
			try {
				if (this.datos.existeElemento(nif, "cliente")) {
					this.vista.mostrarInfoError("\n*** El cliente ya existe en la base de datos ***\n");
				} else {
					this.datos.addCliente(nombre, domicilio, nif, email, isPremium);
					this.vista.mostrarInfo("\n--> El cliente ha sido registrado satisfactoriamente.");					
				}
			} catch (Exception e) {
				// this.vista.mostrarInfoError(e.getMessage());
				this.vista.mostrarInfoError("\n*** El cliente no ha podido registrarse debido a un fallo de la aplicacion ***\n");
			}			
		}
	}
	
	/**
	 * Metodo que implementa la adicion de un pedido
	 */

	public void addPedido() {
		HashMap<String, String> entrada;
		String nif, numArticulo, cantidad, fecha;
		int cantidadInt;
		Cliente cliente;
		Articulo articulo;

		entrada = this.vista.registerPedido();
		// numPedido = entrada.get("numPedido");
		nif = entrada.get("nif");
		numArticulo = entrada.get("numArticulo");
		cantidad = entrada.get("cantidad");
		fecha = entrada.get("fecha");
		cantidadInt = 0;

		try {
			cantidadInt = Integer.parseInt(cantidad);
			if(this.datos.existeElemento(numArticulo, "articulo")) {
				if (!this.datos.existeElemento(nif, "cliente")) {
					this.vista.mostrarInfoError("\n***El cliente no existe y debe ser registrado***\n");
					this.addCliente();
					cliente = this.datos.getClienteByNif(nif);
					articulo = this.datos.getArticuloByCodigo(numArticulo);
					this.datos.addPedido(cliente, articulo, cantidadInt, fecha);
					this.vista.mostrarInfo("\n--> El pedido ha sido registrado correctamente.\n");
				} else {
					cliente = this.datos.getClienteByNif(nif);
					articulo = this.datos.getArticuloByCodigo(numArticulo);
					this.datos.addPedido(cliente, articulo, cantidadInt, fecha);
					this.vista.mostrarInfo("\n--> El pedido ha sido registrado correctamente.\n");
				}				
			} else {
				this.vista.mostrarInfoError("\n*** El articulo no existe ***\n");
			}
		} catch (NumberFormatException e) {
			this.vista.mostrarInfoError("\n*** El formato del campo 'Cantidad' no es valido, revíselo ***");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			this.vista.mostrarInfoError("\n*** El pedido no ha podido registrarse en la base de datos ***\n");
		}
	}
	
	/**
	 * Metodo que implementa la adicion de un articulo
	 */

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
			if(!this.datos.existeElemento(codigo, "articulo")) {
				this.datos.addArticulo(codigo, descripcion, precioVentaInt, gastosEnvioInt, tiempoPrepInt);
				this.vista.mostrarInfo("\n--> El articulo ha sido registrado correctamente.");				
			} else {
				this.vista.mostrarInfoError("\n*** El articulo que desea registrar ya existe en la base de datos ***\n");
			}
		} catch (NumberFormatException e) {
			this.vista.mostrarInfoError("\n*** El formato de los campos no es valido, revíselo ***\n");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			this.vista.mostrarInfoError("\n*** El articulo no ha podido registrarse correctamente en la base de datos***\n");
		}
	}
	
	/**
	 * Metodo que implementa la eliminacion de un pedido
	 */

	public void deletePedido() {
		String numPedido;
		
		try {
			numPedido = this.vista.deletePedido();
			if (this.datos.existeElemento(numPedido, "pedido")) {
				this.datos.deletePedido(numPedido);
				this.vista.mostrarInfo("--> El pedido se ha eliminado correctamente.");
			} else {
				this.vista.mostrarInfoError("*** El pedido introducido no existe. ***");
			}		
		} catch (Exception e) {
			this.vista.mostrarInfoError("\n*** El pedido no ha podido ser borrado ***\n");
		}

	}

	/**
	 * Metodo implementa el muestreo de clientes
	 * @throws Exception 
	 */
	
	public void mostrarClientes() {
		ArrayList<Cliente> clientes;
		ArrayList<String> contenido = new ArrayList<>();
		
		try {
			clientes = this.datos.getClientes();
			for (Cliente cliente : clientes) {
				contenido.add(cliente.toString());
			}
			if(contenido.isEmpty()) {
				this.vista.mostrarInfo("\n*** No hay clientes para mostrar ***\n");
			} else {
				this.vista.mostrarListado(contenido, "cliente");							
			}
		} catch (Exception e) {
			this.vista.mostrarInfoError("\n*** El listado no puedo ser mostrado por un fallo de conexión con la base de datos ***\n");
		}

	}
	
	/**
	 * Metodo que implementa el muestreo de clientes Estandar
	 * @throws Exception 
	 */

	public void mostrarEstandar() {
		ArrayList<Cliente> clientes;
		ArrayList<String> contenido = new ArrayList<>();
		
		try {
			clientes = this.datos.getClientes();
			for (Cliente cliente : clientes) {
				if (cliente.tipoCliente().equals("estandar")) {
					contenido.add(cliente.toString());
				}
			}
			if(contenido.isEmpty()) {
				this.vista.mostrarInfo("\n*** No hay clientes estándar para mostrar ***\n");
			} else {
				this.vista.mostrarListado(contenido, "cliente");							
			}
		} catch (Exception e) {
			this.vista.mostrarInfoError("\n*** El listado no puedo ser mostrado por un fallo de conexión con la base de datos ***\n");
		}

	}
	
	/**
	 * Metodo que implementa el muestreo de clientes Premium
	 */

	public void mostrarPremium() {
		ArrayList<Cliente> clientes;
		ArrayList<String> contenido = new ArrayList<>();
		
		try {
			clientes = this.datos.getClientes();
			for (Cliente cliente : clientes) {
				if (cliente.tipoCliente().equals("premium")) {
					contenido.add(cliente.toString());
				}
			}
			if(contenido.isEmpty()) {
				this.vista.mostrarInfo("\n*** No hay clientes premium para mostrar ***\n");
			} else {
				this.vista.mostrarListado(contenido, "cliente");							
			}
		} catch (Exception e) {
			this.vista.mostrarInfoError("\n*** El listado no puedo ser mostrado por un fallo de conexión con la base de datos ***\n");
		}

	}
	/**
	 * Metodo que implementa el muestreo de articulos
	 */
	
	public void mostrarArticulos() {
		ArrayList<Articulo> articulos;
		ArrayList<String> contenido = new ArrayList<>();
		
		try {
			articulos = this.datos.getArticulos();
			if(articulos.isEmpty()) {
				this.vista.mostrarInfo("\n*** No hay articulos para mostrar ***\n");
			} else {
				for (Articulo articulo: articulos) {
					contenido.add(articulo.toString());
				}
				this.vista.mostrarListado(contenido, "articulo");							
			}
		} catch (Exception e) {
			this.vista.mostrarInfoError("\n*** El listado no puedo ser mostrado por un fallo de conexión con la base de datos ***\n");
		}

	}
	
	/**
	 * Metodo que implementa el muestreo de pedidos pendientes
	 */

	public void mostrarPedidosPendientes() {
		ArrayList<Pedido> pedidos;
		ArrayList<String> contenido = new ArrayList<>();
		String filtro;

		try {
			pedidos = this.datos.getPedidos();
			filtro = this.vista.filtroListadoPedidos();
			if (!filtro.equals("ninguno")) {
				Cliente cliente = this.datos.getClienteByNif(filtro);
				pedidos.forEach((pedido) -> {
					if (pedido.getCliente().getNif().equals(cliente.getNif()) && !pedido.pedidoEnviado()) {
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
			if(contenido.isEmpty()) {
				this.vista.mostrarInfo("\n*** No hay pedidos para mostrar ***\n");
			} else {
				this.vista.mostrarListado(contenido, "pedido");				
			}
		} catch (Exception e) {
			this.vista.mostrarInfoError("\n*** El listado no puedo ser mostrado por un fallo de conexión con la base de datos ***\n");
		}
	}
	
	/**
	 * Metodo que implementa el muestreo de pedidos enviados
	 */

	public void mostrarPedidosEnviados() {
		ArrayList<Pedido> pedidos;
		ArrayList<String> contenido = new ArrayList<>();
		String filtro;

		try {
			pedidos = this.datos.getPedidos();
			filtro = this.vista.filtroListadoPedidos();
			if (!filtro.equals("ninguno")) {
				Cliente cliente = this.datos.getClienteByNif(filtro);
				pedidos.forEach((pedido) -> {
					if (pedido.getCliente().getNif().equals(cliente.getNif()) && pedido.pedidoEnviado()) {
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
			this.vista.mostrarInfoError("\n*** El listado no puedo ser mostrado por un fallo de conexión con la base de datos ***\n");
		}
	}

}
