package grupodamers.vista;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import grupodamers.controlador.Controlador;
import grupodamers.modelo.Articulo;
import grupodamers.modelo.Cliente;
import grupodamers.modelo.Pedido;
import javafx.geometry.NodeOrientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GestionOS {

	/**
	 * Esta clase contiene los elementos de la clase GestionOS
	 * 
	 * @author DAMERs Project POO
	 */
	
	private Stage mainStage;
	private Scene scene;
	private AnchorPane mainRoot;
	private Controlador controlador;

	static Scanner lector = new Scanner(System.in);
	static HashMap<String, String> cliente = new HashMap<String, String>();
	static HashMap<String, String> pedido = new HashMap<String, String>();
	static HashMap<String, String> articulo = new HashMap<String, String>();
	static String currentOption = "Menu";

	public GestionOS(Stage stage, String title) {
		this.mainStage = stage;
		this.mainStage.setResizable(false);
		this.mainStage.setTitle(title);
		this.mainRoot = new AnchorPane();
		// this.mainRoot.setPrefSize(640, 400);
		this.scene = new Scene(this.mainRoot);
		this.mainStage.setScene(this.scene);
	}
	
	/**
	 * Metodo para obtener el stage de la aplicación
	 * @return
	 */
	
	public Stage getStage() {
		return this.mainStage;
	}
	
	/**
	 * Método para setear el stage de la aplicación
	 * @param stage
	 */
	
	public void setStage(Stage stage) {
		this.mainStage = stage;
	}

	/**
	 * @return the controlador
	 */
	public Controlador getControlador() {
		return controlador;
	}

	/**
	 * @param controlador the controlador to set
	 */
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	
	/**
	 * Metodo que nuestra el menu
	 */

	public AnchorPane showMenu() {
		AnchorPane root = new AnchorPane();
		root.setPrefSize(640, 400);
		
		Label titulo = UtilsVista.createLabel("MENU PRINCIPAL", 268, 25);
		Button buttonMC = UtilsVista.createButton("Mostrar clientes", 128, 231, 25, 173);
		Button buttonMA = UtilsVista.createButton("Mostrar articulos", 340, 149, 25, 173);
		Button buttonRC = UtilsVista.createButton("Registrar cliente", 128, 67, 25, 173);
		Button buttonRA = UtilsVista.createButton("Registrar articulo", 128, 109, 25, 173);
		Button buttonRP = UtilsVista.createButton("Registrar pedido", 128, 149, 25, 173);
		Button buttonMCE = UtilsVista.createButton("Mostrar clientes estándar", 340, 67, 25, 173);
		Button buttonMCP = UtilsVista.createButton("Mostrar clientes premium", 340, 109, 25, 173);
		Button buttonMPP = UtilsVista.createButton("Mostrar pedidos pendientes", 340, 190, 25, 173);
		Button buttonMPE = UtilsVista.createButton("Mostrar pedidos enviados", 340, 231, 25, 173);
		Button buttonEP = UtilsVista.createButton("Eliminar pedido", 128, 190, 25, 173);
		Button buttonClose = UtilsVista.createButton("Salir", 234, 283, 25, 173);
		root.getChildren().addAll(titulo, buttonRC, buttonMA, buttonMC, buttonRA, buttonRP, buttonMCE, buttonMCP, buttonMPP, buttonMPE, buttonEP, buttonClose);
		this.chargeScene(root);
		return root;
	}
	
	/**
	 * Metodo utilizado para contener datos del articulo
	 * @return articulo
	 */

	public Pane registerArticulo() {
		AnchorPane root = new AnchorPane();
		root.setPrefSize(640, 400);
		
		Label titulo = UtilsVista.createLabel("FORMULARIO REGISTRO ARTÍCULO", 231, 31);
		Label codigo = UtilsVista.createLabel("Código del articulo:", 145, 78);
		Label descripcion = UtilsVista.createLabel("Descripción:", 182, 104);
		Label precioVenta = UtilsVista.createLabel("Precio de venta:", 162, 133);
		Label gastosEnvio = UtilsVista.createLabel("Gastos de envío:", 161, 160);
		Label tiempoPreparacion = UtilsVista.createLabel("Tiempo de preparación (minutos):", 69, 187);
		TextField campoCodigo = UtilsVista.createTextField(260, 72);
		TextField campoDescripcion = UtilsVista.createTextField(260, 100);
		TextField campoPV = UtilsVista.createTextField(260, 129);
		TextField campoGE = UtilsVista.createTextField(260, 158);
		TextField campoTP = UtilsVista.createTextField(260, 187);
		
		Button enviar = UtilsVista.createButton("ENVIAR", 309, 267, 25, 57);
		
		root.getChildren().addAll(titulo, codigo, descripcion, precioVenta, gastosEnvio, tiempoPreparacion, campoCodigo, campoDescripcion, campoPV, campoGE, campoTP, enviar);
		
		this.chargeScene(root);
		return root;
	}
	
	/**
	 * Metodo utilizado para contener datos del cliente
	 * @return cliente
	 */

	public Pane registerCliente() {
		AnchorPane root = new AnchorPane();
		root.setPrefSize(640, 400);
		
		Label titulo = UtilsVista.createLabel("FORMULARIO REGISTRO CLIENTE", 231, 31);
		Label nombre = UtilsVista.createLabel("Nombre:", 202, 78);
		Label domicilio = UtilsVista.createLabel("Domicilio:", 195, 104);
		Label nif = UtilsVista.createLabel("NIF:", 228, 133);
		Label email = UtilsVista.createLabel("Correo electrónico:", 149, 160);
		TextField campoNombre = UtilsVista.createTextField(260, 72);
		TextField campoDomicilio = UtilsVista.createTextField(260, 100);
		TextField campoNif = UtilsVista.createTextField(260, 129);
		TextField campoEmail = UtilsVista.createTextField(260, 158);
		CheckBox premium = new CheckBox();
		premium.setLayoutX(142);
		premium.setLayoutY(199);
		premium.setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
		premium.setText("¿Es cliente premium? ");
		
		Button enviar = UtilsVista.createButton("ENVIAR", 309, 267, 25, 57);
		
		root.getChildren().addAll(titulo, nombre, domicilio, nif, email, campoNombre, campoDomicilio, campoNif, campoEmail, premium, enviar);
		
		this.chargeScene(root);
		
		return root;
	}
	
	/**
	 * Metodo utilizado para contener datos del pedido
	 * @return pedido
	 */

	public Pane registerPedido() {
		AnchorPane root = new AnchorPane();
		root.setPrefSize(640, 400);
		
		Label titulo = UtilsVista.createLabel("FORMULARIO REGISTRO PEDIDO", 231, 31);
		Label nif = UtilsVista.createLabel("NIF:", 225, 78);
		Label numArticulo = UtilsVista.createLabel("Código del artículo:", 145, 104);
		Label cantidad = UtilsVista.createLabel("Cantidad:", 198, 133);
		TextField campoNif = UtilsVista.createTextField(260, 72);
		TextField campoArticulo = UtilsVista.createTextField(260, 100);
		TextField campoCantidad = UtilsVista.createTextField(260, 129);
		Button enviar = UtilsVista.createButton("ENVIAR", 309, 220, 25, 57);
		
		root.getChildren().addAll(titulo, nif, numArticulo, cantidad, campoNif, campoArticulo, campoCantidad, enviar);
		this.chargeScene(root);
		return root;
	}
	
	/**
	 * Metodo para borrar pedido
	 * @return numero de pedido
	 */

	public Pane deletePedido() {
		AnchorPane root = new AnchorPane();
		root.setPrefSize(640, 400);
		
		Label titulo = UtilsVista.createLabel("ELIMINAR PEDIDO", 261, 31);
		Label pedido = UtilsVista.createLabel("Numero de pedido:", 145, 76);
		
		TextField campo = UtilsVista.createTextField(260, 72);
		
		Button delete = UtilsVista.createButton("BORRAR", 280, 156, 25, 62);
		
		root.getChildren().addAll(titulo, campo, pedido, delete);
		this.chargeScene(root);
		return root;
	}
	
	/**
	 * Metodo para mostrar los mensajes en la aplicacion
	 * @throws InterruptedException 
	 */

	public void mostrarDialog(String texto, String type) throws InterruptedException {
		Alert alert = new Alert(AlertType.NONE);
		alert.setTitle("Online Store");
		switch(type) {
		case "info":
			alert.setAlertType(AlertType.INFORMATION);
			alert.setHeaderText("INFO");
			alert.setContentText(texto);
			alert.showAndWait();
			break;
		case "error":
			alert.setAlertType(AlertType.ERROR);
			alert.setHeaderText("Error");
			alert.setContentText(texto);
			alert.showAndWait();
			break;
		case "exit":
			alert.setAlertType(AlertType.NONE);
			alert.setHeaderText(texto);
			alert.setContentText("Esperamos tenerle de vuelta");
			alert.getButtonTypes().add(ButtonType.CLOSE);
			alert.showAndWait();
			break;
		default:
			alert.setAlertType(AlertType.INFORMATION);
			alert.setHeaderText("");
			alert.showAndWait();
			break;
		}
	}
	
	/**
	 * Metodo para cerrar el dialog
	 * @param dialog
	 */
	
	public void cerrarDialog(Pane dialog) {
		this.mainRoot.getChildren().remove(1);
	}
	
	/**
	 * Metodo para mostrar listado de clientes, articulos y pedidos
	 */

	public Pane mostrarListado(String tipoListado) {
		Double x = 33.0, y = 39.0, width = 577.0, height = 273.0;
		AnchorPane root = new AnchorPane();
		root.setPrefSize(640, 400);
		Label titulo = UtilsVista.createLabel("Listado", 296, 14);
		Button buscar = UtilsVista.createButton("Buscar", 33, 324, 25, 51);
		Button volver = UtilsVista.createButton("Volver al menú principal", 465, 324, 25, 145);
		switch (tipoListado) {
		case "cliente":
		case "cliente premium":
		case "cliente estandar":
			String[] columnsCliente = {"Nombre", "Nif", "Domicilio", "Email"};
			Map<String, String> propertiesCliente = Map.of("Nombre", "nombre", "Domicilio", "domicilio", "Nif", "nif", "Email", "email");
			TableConfig configCliente = new TableConfig(x, y, columnsCliente, width, height);
			if (tipoListado.equals("cliente premium")) {
				titulo.setText("Clientes Premium");
			} else if (tipoListado.equals("cliente estandar")) {
				titulo.setText("Clientes Estándar");
			} else {
				titulo.setText("Clientes");				
			}
			TableView<Cliente> tableC = UtilsVista.createTableCliente(configCliente, propertiesCliente);
			root.getChildren().addAll(titulo, tableC, buscar, volver);
			this.chargeScene(root);
			return root;
		case "articulo":
			String[] columnsArticulo = {"Código", "Descripción", "PVP", "Gastos de envío", "Tiempo de preparación (min)"};
			Map<String, String> propertiesArticulo = Map.of("Código", "codigo", "Descripción", "descripcion", "PVP", "precioVenta", "Gastos de envío", "gastosEnvio", "Tiempo de preparación (min)", "tiempoPrep");
			TableConfig configArticulo = new TableConfig(x, y, columnsArticulo, width, height);
			titulo.setText("Articulo");
			TableView<Articulo> tableA = UtilsVista.createTableArticulo(configArticulo, propertiesArticulo);
			root.getChildren().addAll(titulo, tableA, buscar, volver);
			this.chargeScene(root);
			return root;
		case "pedido":
			String[] columnsPedido = {"Número de pedido", "Cliente", "Artículo", "Cantidad", "Fecha y hora", "Precio envío", "Precio total"};
			Map<String, String> propertiesPedido = Map.of("Número de pedido", "numPedido", "Cliente", "email", "Artículo", "codArticulo", "Cantidad", "cantidad", "Fecha y hora", "fecha", "Precio envío", "precioEnvio", "Precio total", "precioTotal");
			TableConfig configPedido = new TableConfig(x, y, columnsPedido, width, height);
			titulo.setText("Pedidos");
			TableView<Pedido> tableP = UtilsVista.createTablePedido(configPedido, propertiesPedido);
			CheckBox selectNif = new CheckBox();
			selectNif.setText("Filtrar por NIF:");
			selectNif.setLayoutX(119);
			selectNif.setLayoutY(326);
			TextField campo = UtilsVista.createTextField(222, 324);
			root.getChildren().addAll(titulo, tableP, selectNif, campo, buscar, volver);
			this.chargeScene(root);
			return root;
		default:
			return null;
		}
	}
	
	/**
	 * Método que carga la información en el listado correspondiente
	 */
	
	public void cargarDatosListado(TableView table, int index) {
		Pane root = (Pane) this.mainStage.getScene().getRoot();
		Pane subroot = (Pane) root.getChildren().get(0);
		subroot.getChildren().set(index, table);
	}
	
	/**
	 * Metodo para cerrar la aplicacion
	 */
	
	public void closeApp() {
		this.mainStage.close();
	}
	
	/**
	 * Metodo para cargar el mainStage
	 * @param root
	 */
	
	private void chargeScene(Pane root) {
		this.mainRoot.getChildren().clear();
		this.mainRoot.getChildren().add(root);
		this.mainStage.show();
	}
}
