package grupodamers.vista;

import java.util.HashMap;
import java.util.Scanner;

public class GestionOS {
	
	Scanner lector = new Scanner(System.in);
	HashMap<String, String> cliente = new HashMap<String, String>();
	HashMap<String, String> pedido = new HashMap<String, String>();
	HashMap<String, String> articulo = new HashMap<String, String>();
	
	public GestionOS() {}
	
	public int gestionMenu() {
		int opt = 0;
		
		this.showMenu();
		opt = lector.nextInt();
		return opt;
	}
	
	private void showMenu() {
		System.out.println("1. Introducir Cliente");
		System.out.println("2. Introducir Pedido");
		System.out.println("3. Introducir Articulo");
		System.out.println("4. Salir");
		System.out.println("Escoja una opcion: ");
	}
	
	public HashMap<String, String> registerArticulo() {
		String entrada = "";
		
		System.out.println("Introduce descripcion del articulo: ");
		entrada = lector.nextLine();
		cliente.put("descripcion", entrada);
		System.out.println("Introduce precio de venta del articulo: ");
		entrada = lector.nextLine();
		cliente.put("precioVenta", entrada);
		System.out.println("Introduce gastos de envio del articulo: ");
		entrada = lector.nextLine();
		cliente.put("gastosEnvio", entrada);
		System.out.println("Introduce tiempo de preparacion del articulo: ");
		entrada = lector.nextLine();
		cliente.put("tiempoPreparacion", entrada);
		
		return this.articulo;
	}
	
	public HashMap<String, String> registerCliente() {
		String entrada = "";
		
		System.out.println("Introduce nombre del cliente: ");
		entrada = lector.nextLine();
		cliente.put("nombre", entrada);
		System.out.println("Introduce domicilio del cliente: ");
		entrada = lector.nextLine();
		cliente.put("domicilio", entrada);
		// meter un excepción de formato de nif
		System.out.println("Introduce nif del cliente: ");
		entrada = lector.nextLine();
		cliente.put("nif", entrada);
		// excepcion de formato de email
		System.out.println("Introduce email del cliente: ");
		entrada = lector.nextLine();
		cliente.put("email", entrada);
		// excepcion de formato S o N
		System.out.println("¿El cliente es premium? (S / N)");
		entrada = lector.nextLine();
		cliente.put("esPremium", entrada);
		
		return this.cliente;
	}
	
	public HashMap<String, String> registerPedido() {
		String entrada = "";
		
		System.out.println("Introduce el nif del cliente que realiza el pedido: ");
		entrada = lector.nextLine();
		cliente.put("nif", entrada);
		System.out.println("Introduce el numero de articulo: ");
		entrada = lector.nextLine();
		cliente.put("numArticulo", entrada);
		System.out.println("Introduce la cantidad: ");
		entrada = lector.nextLine();
		cliente.put("cantidad", entrada);
		System.out.println("Introduce la fecha del pedido (formato dd/mm/yyyy): ");
		entrada = lector.nextLine();
		cliente.put("fecha", entrada);
		
		return this.pedido;
	}
	
	public void errorPedido() {
		System.out.println("El codigo de articulo introducido no coincide con ninguno de la base de datos.\n");
	}

}
