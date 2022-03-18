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
	
	public void iniciarAplicacion() {
		int opt = 0;
		
		opt = this.vista.gestionMenu();		
		switch (opt) {
		case 1:
			this.addCliente();
			break;
		case 2:
			// llamada al metodo de recogida de datos de pedido
			break;
		case 3:
			// llamada al metodo de recogida de datos de articulo
			break;
		case 4:
			// salida del programa
			break;
		}
		System.out.println("La opcion escogida es " + opt);
	}
	
	private void addCliente() {
		HashMap<String, String> entrada;
		String nombre, domicilio, email, nif;
		boolean isPremium;
		
		entrada = this.vista.registerCliente();
		nombre = entrada.get("nombre");
		domicilio = entrada.get("domicilio");
		email = entrada.get("email");
		nif = entrada.get("nif");
		if ( entrada.get("esPremium") == "S" ) {
			isPremium = true;
		} else {
			isPremium = false;
		}
		this.datos.addCliente(nombre, domicilio, nif, email, isPremium);
	}
	
	private void addPedido() {
		HashMap<String, String> entrada;
		String nif, numArticulo, cantidad, fecha;
		boolean existeCliente, existeArticulo;
		
		entrada = this.vista.registerPedido();
		// comprobar si el cliente esta registrado
		//comprobar si el articulo esta registrado
		// si no existe lanzamos el mensaje de error y redirigimos al menu
		// llamar a la capa de datos para añadir el pedido
		
	}
	
	private void addArticulo() {
		
	}
	
	private boolean existeArticulo(String codArticulo) {
		ArrayList<Articulo> lista;
		boolean existe = false;
		
		lista = this.datos.getArticulos();
		for(Articulo articulo: lista) {
			if (articulo.getCodigo() == codArticulo) {
				existe = true;
				break;
			}
		}
		
		return existe;
	}
	
	private boolean existeCliente(String nif) {
		ArrayList<Cliente> lista;
		boolean existe = false;
		
		lista = this.datos.getClientes();
		for(Cliente cliente: lista) {
			if (cliente.getNif() == nif) {
				existe = true;
				break;
			}
		}
		
		return existe;
	}

}
