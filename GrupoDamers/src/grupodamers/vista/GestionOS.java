package grupodamers.vista;

import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GestionOS {
	
	static Scanner lector = new Scanner(System.in);
	static HashMap<String, String> cliente = new HashMap<String, String>();
	static HashMap<String, String> pedido = new HashMap<String, String>();
	static HashMap<String, String> articulo = new HashMap<String, String>();
	
	public GestionOS() {}
	
	public String gestionMenu() {
		String opt = "0";
		
		this.showMenu();
		opt = lector.nextLine();
		return opt;
	}
	
	private void showMenu() {
		System.out.println("1. Introducir Cliente");
		System.out.println("2. Introducir Pedido");
		System.out.println("3. Introducir Articulo");
		System.out.println("4. Eliminar pedido");
		System.out.println("5. Mostra clientes");
		System.out.println("6. Mostra clientes premium");
		System.out.println("7. Mostra clientes estándar");
		System.out.println("8. Mostrar articulos");
		System.out.println("9. Mostrar pedidos pendientes");
		System.out.println("10. Mostrar pedidos enviados");
		System.out.println("11. Salir");
		System.out.println("Escoja una opcion: ");
	}
	
	public HashMap<String, String> registerArticulo() {
		String entrada = "";
		articulo.clear();
		
		System.out.println("Introduce el codigo del articulo: ");
		entrada = lector.nextLine();
		articulo.put("codigo", entrada);
		System.out.println("Introduce descripcion del articulo: ");
		entrada = lector.nextLine();
		articulo.put("descripcion", entrada);
		System.out.println("Introduce precio de venta del articulo: ");
		entrada = lector.nextLine();
		articulo.put("precioVenta", entrada);
		System.out.println("Introduce gastos de envio del articulo: ");
		entrada = lector.nextLine();
		articulo.put("gastosEnvio", entrada);
		System.out.println("Introduce tiempo de preparacion del articulo: ");
		entrada = lector.nextLine();
		articulo.put("tiempoPreparacion", entrada);
		
		return articulo;
	}
	
	public HashMap<String, String> registerCliente(boolean showInfo) {
		String entrada = "";
		cliente.clear();
		
		if (showInfo) {
			System.out.println("El cliente no existe y debe registrarlo previamente.");
		}
		

		System.out.println("Introduce nombre del cliente: ");
		entrada = lector.nextLine();
		cliente.put("nombre", entrada);
		System.out.println("Introduce domicilio del cliente: ");
		entrada = lector.nextLine();
		cliente.put("domicilio", entrada);
		System.out.println("Introduce nif del cliente: ");
		entrada = lector.nextLine();
		cliente.put("nif", entrada);
		System.out.println("Introduce email del cliente: ");
		entrada = lector.nextLine();
		cliente.put("email", entrada);
		System.out.println("¿El cliente es premium? (S / N)");
		entrada = lector.nextLine();
		cliente.put("isPremium", entrada);
		
		return cliente;
	}
	
	public HashMap<String, String> registerPedido() {
		String entrada = "";
		pedido.clear();
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		
		System.out.println("Introduce el numero de pedido: ");
		entrada = lector.nextLine();
		pedido.put("numPedido", entrada);
		System.out.println("Introduce el nif del cliente que realiza el pedido: ");
		entrada = lector.nextLine();
		pedido.put("nif", entrada);
		System.out.println("Introduce el numero de articulo: ");
		entrada = lector.nextLine();
		pedido.put("numArticulo", entrada);
		System.out.println("Introduce la cantidad: ");
		entrada = lector.nextLine();
		pedido.put("cantidad", entrada);
		entrada = date.format(fmt);
		pedido.put("fecha", entrada);
		
		return pedido;
	}
	
	public String deletePedido() {
		String numPedido;
		
		System.out.println("Introduce el numero del pedido que queremos eliminar: ");
		numPedido = lector.nextLine();
		return numPedido;
	}
	
	public void mostrarInfoError (String texto) {
		System.out.println(texto);
	}
	
	public void mostrarInfo (String texto) {
		System.out.println(texto);
	}
	
	public void mostrarListado (ArrayList<String> contenido, String titulo) {
		switch (titulo) {
		case "cliente":
			System.out.println("***********CLIENTES***********");
			break;
		case "articulo":
			System.out.println("***********ARTICULOS***********");
			break;
		case "pedido":
			System.out.println("***********PEDIDOS*************");
			break;
		}
		contenido.forEach((e) -> {
			System.out.println(e);
		});
	}
	
	public String filtroListadoPedidos() throws Exception{
		String filtro1, filtro2 = "ninguno";
		
		System.out.println("Desea filtrar por tipo de cliente (S / N): ");
		filtro1 = lector.nextLine().toUpperCase();
		if(!filtro1.equals("S") && !filtro1.equals("N")) {
			throw new Exception("Opcion no contemplada");
		} else {
			if (filtro1 == "S") {
				System.out.println("Seleccione el tipo (premium / estandar): ");
				filtro2 = lector.nextLine().toLowerCase();
				if(!filtro2.equals("premium") && !filtro2.equals("estandar")) {
					throw new Exception("Opcion no contemplada");
				} else {
					return filtro2;
				}
			}
		}
		return filtro2;
	}
}
