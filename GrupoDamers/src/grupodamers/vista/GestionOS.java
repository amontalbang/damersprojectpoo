package grupodamers.vista;

import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GestionOS {

	/**
	 * Esta clase contiene los elementos de la clase GestionOS
	 * 
	 * @author DAMERs Project POO
	 */

	static Scanner lector = new Scanner(System.in);
	static HashMap<String, String> cliente = new HashMap<String, String>();
	static HashMap<String, String> pedido = new HashMap<String, String>();
	static HashMap<String, String> articulo = new HashMap<String, String>();

	public GestionOS() {
	}

	/**
	 * Metodo de gestion del menu
	 */

	public String gestionMenu() {
		String opt = "0";

		this.showMenu();
		opt = lector.nextLine();
		return opt;
	}
	
	/**
	 * Metodo que nuestra el menu
	 */

	private void showMenu() {
		System.out.println("\n********* MENU *********\n");
		System.out.println("1. Introducir Articulo");
		System.out.println("2. Mostrar articulos");
		System.out.println("3. Introducir Cliente");
		System.out.println("4. Mostra clientes");
		System.out.println("5. Mostra clientes estándar");
		System.out.println("6. Mostra clientes premium");
		System.out.println("7. Introducir Pedido");
		System.out.println("8. Eliminar pedido");
		System.out.println("9. Mostrar pedidos pendientes");
		System.out.println("10. Mostrar pedidos enviados");
		System.out.println("11. Salir\n");
		System.out.println("Escoja una opcion: ");
	}
	
	/**
	 * Metodo utilizado para contener datos del articulo
	 * @return articulo
	 */

	public HashMap<String, String> registerArticulo() {
		String entrada = "";
		articulo.clear();

		System.out.println("\nIntroduce el codigo del articulo: ");
		entrada = lector.nextLine();
		articulo.put("codigo", entrada);
		System.out.println("\nIntroduce descripcion del articulo: ");
		entrada = lector.nextLine();
		articulo.put("descripcion", entrada);
		System.out.println("\nIntroduce precio de venta del articulo: ");
		entrada = lector.nextLine();
		articulo.put("precioVenta", entrada);
		System.out.println("\nIntroduce gastos de envio del articulo: ");
		entrada = lector.nextLine();
		articulo.put("gastosEnvio", entrada);
		System.out.println("\nIntroduce tiempo de preparacion del articulo: ");
		entrada = lector.nextLine();
		articulo.put("tiempoPreparacion", entrada);

		return articulo;
	}
	
	/**
	 * Metodo utilizado para contener datos del cliente
	 * @return cliente
	 */

	public HashMap<String, String> registerCliente() {
		String entrada = "";
		cliente.clear();

		System.out.println("\nIntroduce nombre del cliente: ");
		entrada = lector.nextLine();
		cliente.put("nombre", entrada);
		System.out.println("\nIntroduce domicilio del cliente: ");
		entrada = lector.nextLine();
		cliente.put("domicilio", entrada);
		System.out.println("\nIntroduce nif del cliente: ");
		entrada = lector.nextLine().toUpperCase();
		cliente.put("nif", entrada);
		System.out.println("\nIntroduce email del cliente: ");
		entrada = lector.nextLine();
		cliente.put("email", entrada);
		System.out.println("\n¿El cliente es premium? (S / N)");
		entrada = lector.nextLine().toUpperCase();
		cliente.put("isPremium", entrada);

		return cliente;
	}
	
	/**
	 * Metodo utilizado para contener datos del pedido
	 * @return pedido
	 */

	public HashMap<String, String> registerPedido() {
		String entrada = "";
		pedido.clear();
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

		// System.out.println("\nIntroduce el numero de pedido: ");
		// entrada = lector.nextLine();
		// pedido.put("numPedido", entrada);
		System.out.println("\nIntroduce el nif del cliente que realiza el pedido: ");
		entrada = lector.nextLine();
		pedido.put("nif", entrada);
		System.out.println("\nIntroduce el numero de articulo: ");
		entrada = lector.nextLine();
		pedido.put("numArticulo", entrada);
		System.out.println("\nIntroduce la cantidad: ");
		entrada = lector.nextLine();
		pedido.put("cantidad", entrada);
		entrada = date.format(fmt);
		pedido.put("fecha", entrada);

		return pedido;
	}
	
	/**
	 * Metodo para borrar pedido
	 * @return numero de pedido
	 */

	public String deletePedido() {
		String numPedido;

		System.out.println("\nIntroduce el numero del pedido que queremos eliminar: ");
		numPedido = lector.nextLine();
		return numPedido;
	}
	
	/**
	 * Metodo para mostrar mensaje de error
	 */

	public void mostrarInfoError(String texto) {
		System.out.println(texto);
	}
	
	/**
	 * Metodo para mostrar informacion
	 */

	public void mostrarInfo(String texto) {
		System.out.println(texto);
	}
	
	/**
	 * Metodo para mostrar listado de clientes, articulos y pedidos
	 */

	public void mostrarListado(ArrayList<String> contenido, String titulo) {
		switch (titulo) {
		case "cliente":
			System.out.println("\n***********CLIENTES***********\n");
			break;
		case "articulo":
			System.out.println("\n***********ARTICULOS***********\n");
			break;
		case "pedido":
			System.out.println("\n***********PEDIDOS*************\n");
			break;
		}
		contenido.forEach((e) -> {
			System.out.println(e);
		});
	}
	
	/**
	 * Metodo para aplicar filtros en el muestreo de clientes
	 */

	public String filtroListadoPedidos() throws Exception {
		String filtro1, filtro2 = "ninguno";

		System.out.println("\nDesea filtrar por cliente (S / N): ");
		filtro1 = lector.nextLine().toUpperCase();
		if (!filtro1.equals("S") && !filtro1.equals("N")) {
			throw new Exception("*** Opcion no contemplada ***");
		} else {
			if (filtro1.equals("S")) {
				System.out.println("\nIntroduzca el nif del cliente por el que quiere filtrar: ");
				filtro2 = lector.nextLine().toUpperCase();
				return filtro2;
			}
		}
		return filtro2;
	}
}
