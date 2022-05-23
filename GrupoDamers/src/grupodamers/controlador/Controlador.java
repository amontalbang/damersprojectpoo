package grupodamers.controlador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import grupodamers.modelo.*;
import grupodamers.vista.GestionOS;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * Metodo que contiene los metodos de la clase Controlador
 */

public class Controlador {

	private Datos datos;
	private GestionOS vista;
	
	public Controlador(Datos datos, GestionOS vista) {
		this.datos = datos;
		this.vista = vista;
	}
	
	/**
	 * Metodo que implementa el menu principal
	 */

	public void gestionMenu() {
		AnchorPane root = this.vista.showMenu();
		root.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Button buttonSelected = (Button) event.getTarget();
				String selection = buttonSelected.getText();
				switch (selection) {
				case "Registrar articulo":
					addArticulo();				
					break;
				case "Mostrar articulos":
					mostrarArticulos();
					break;
				case "Registrar cliente":
					addCliente(false);
					break;
				case "Mostrar clientes":
					mostrarClientes();				
					break;
				case "Mostrar clientes estándar":
					mostrarEstandar();
					break;
				case "Mostrar clientes premium":
					mostrarPremium();
					break;
				case "Registrar pedido":
					addPedido();
					break;
				case "Eliminar pedido":
					deletePedido();
					break;
				case "Mostrar pedidos pendientes":
					mostrarPedidosPendientes();
					break;
				case "Mostrar pedidos enviados":
					mostrarPedidosEnviados();
					break;
				case "Salir":
					messageController("exit", "Gracias por utilizar nuestra aplicación.");
					closeApp();
					break;
				default:
					messageController("error", "La opcion introducida no coincide con ninguna de las disponibles");
					break;
				}

			}
		});		
	}
	
	/**
	 * Metodo que implementa la adicion de un cliente
	 */

	public void addCliente(boolean fromPedido) {
		Pane root = this.vista.registerCliente();
		TextField campoNombre = (TextField) root.getChildren().get(5);
		TextField campoDomicilio = (TextField) root.getChildren().get(6);
		TextField campoNif = (TextField) root.getChildren().get(7);
		TextField campoEmail = (TextField) root.getChildren().get(8);
		CheckBox premium = (CheckBox) root.getChildren().get(9);
		Button button = (Button) root.getChildren().get(10);
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String nombre, domicilio, email, nif;
				boolean isPremium = false;
				nombre = campoNombre.getText();
				domicilio = campoDomicilio.getText();
				email = campoEmail.getText();
				nif = campoNif.getText();
				if(premium.isSelected()) {
					isPremium = true;
				}
				try {
					if (datos.existeElemento(nif, "cliente") || datos.existeElemento(email, "cliente")) {
						messageController("error", "El cliente ya existe en la base de datos.");
					} else {
						datos.addCliente(nombre, domicilio, nif, email, isPremium);
						messageController("info", "El cliente ha sido registrado satisfactoriamente.");					
					}
				} catch (Exception e) {
					messageController("error", "El cliente no ha podido registrarse debido a un fallo de la aplicacion.");
				} finally {
					if (fromPedido) {
						addPedido();
					} else {
						gestionMenu();						
					}
				}
			}
			
		});
	}
	
	/**
	 * Metodo que implementa la adicion de un pedido
	 */

	public void addPedido() {
		Pane root = this.vista.registerPedido();
		TextField campoNif = (TextField) root.getChildren().get(4);
		TextField campoArticulo = (TextField) root.getChildren().get(5);
		TextField campoCantidad = (TextField) root.getChildren().get(6);
		Button button = (Button) root.getChildren().get(7);
		
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String nif, numArticulo, fecha;
				int cantidad;
				Cliente cliente;
				Articulo articulo;
				LocalDateTime date = LocalDateTime.now();
				DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
				
				nif = campoNif.getText();
				numArticulo = campoArticulo.getText();
				System.out.println(numArticulo);
				cantidad = Integer.parseInt(campoCantidad.getText());
				fecha = date.format(fmt);
				try {
					if(datos.existeElemento(numArticulo, "articulo")) {
						if (!datos.existeElemento(nif, "cliente")) {
							messageController("info", "El cliente no existe y debe ser registrado.");
							addCliente(false);
						} else {
							cliente = datos.getClienteByNif(nif);
							articulo = datos.getArticuloByCodigo(numArticulo);
							datos.addPedido(cliente, articulo, cantidad, fecha);
							messageController("info", "El pedido ha sido registrado correctamente.");
							gestionMenu();
						}				
					} else {
						messageController("error", "El articulo no existe.");
						gestionMenu();
					}
				} catch (NumberFormatException e) {
					messageController("info", "El formato del campo 'Cantidad' no es valido, revíselo.");
					gestionMenu();
				} catch (Exception e) {
					messageController("error", "El pedido no ha podido registrarse en la base de datos.");
					gestionMenu();
				}
			}
			
		});
	}
	
	/**
	 * Metodo que implementa la adicion de un articulo
	 */

	public void addArticulo() {
		Pane root = this.vista.registerArticulo();
		TextField campoCodigo = (TextField) root.getChildren().get(6);
		TextField campoDescripcion = (TextField) root.getChildren().get(7);
		TextField campoPV = (TextField) root.getChildren().get(8);
		TextField campoGE = (TextField) root.getChildren().get(9);
		TextField campoTP = (TextField) root.getChildren().get(10);
		Button button = (Button) root.getChildren().get(11);
		
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String descripcion, precioVenta, gastosEnvio, tiempoPrep, codigo;
				int tiempoPrepInt;
				double precioVentaInt, gastosEnvioInt;
				
				codigo = campoCodigo.getText();
				descripcion = campoDescripcion.getText();
				precioVenta = campoPV.getText();
				gastosEnvio = campoGE.getText();
				tiempoPrep = campoTP.getText();
				
				try {
					precioVentaInt = Double.parseDouble(precioVenta);
					gastosEnvioInt = Double.parseDouble(gastosEnvio);
					tiempoPrepInt = Integer.parseInt(tiempoPrep);
					if(!datos.existeElemento(codigo, "articulo")) {
						datos.addArticulo(codigo, descripcion, precioVentaInt, gastosEnvioInt, tiempoPrepInt);
						messageController("info", "El articulo ha sido registrado correctamente.");				
					} else {
						messageController("error", "El articulo que desea registrar ya existe en la base de datos.");
					}
				} catch (NumberFormatException e) {
					messageController("error", "El formato de los campos no es valido, revíselo.");
				} catch (Exception e) {
					messageController("info", "El articulo no ha podido registrarse correctamente en la base de datos.");
				} finally {
					gestionMenu();
				}
			}
			
		});
	}
	
	/**
	 * Metodo que implementa la eliminacion de un pedido
	 */

	public void deletePedido() {
		Pane root = this.vista.deletePedido();
		TextField text = (TextField) root.getChildren().get(1);
		Button delete = (Button) root.getChildren().get(3);
		
		delete.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				String numPedido = text.getText();
				try {
					if (datos.existeElemento(numPedido, "pedido")) {
						datos.deletePedido(numPedido);
						messageController("info", "El pedido se ha eliminado correctamente.");
					} else {
						messageController("error", "El pedido introducido no existe.");
					}		
				} catch (Exception e) {
					messageController("error", "El pedido no ha podido ser borrado.");
				} finally {
					gestionMenu();
				}
			}
			
		});
	}

	/**
	 * Metodo implementa el muestreo de clientes
	 * @throws Exception 
	 */
	
	public void mostrarClientes() {
		Pane root = this.vista.mostrarListado("cliente");
		Button buttonBuscar = (Button) root.getChildren().get(2);
		@SuppressWarnings("unchecked")
		TableView<Cliente> table = (TableView<Cliente>) root.getChildren().get(1);
		
		root.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(event.getTarget().equals(buttonBuscar)) {
					ArrayList<Cliente> clientes;
					ObservableList<Cliente> data = FXCollections.observableArrayList();
					try {
						clientes = datos.getClientes();
						for (Cliente cliente : clientes) {
							data.add(cliente);
						}
						if(data.isEmpty()) {
							messageController("info", "No hay clientes para mostrar.");
						} else {
							table.setItems(data);
							vista.cargarDatosListado(table, 1);							
						}
					} catch (Exception e) {
						messageController("error", "El listado no puedo ser mostrado por un fallo de conexión con la base de datos.");
					}
				} else {
					gestionMenu();
				}
			}
			
		});
	}
	
	/**
	 * Metodo que implementa el muestreo de clientes Estandar
	 * @throws Exception 
	 */

	public void mostrarEstandar() {
		Pane root = this.vista.mostrarListado("cliente");
		Button buttonBuscar = (Button) root.getChildren().get(2);
		@SuppressWarnings("unchecked")
		TableView<Cliente> table = (TableView<Cliente>) root.getChildren().get(1);
		
		root.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(event.getTarget().equals(buttonBuscar)) {
					ArrayList<Cliente> clientes;
					ObservableList<Cliente> data = FXCollections.observableArrayList();
					try {
						clientes = datos.getClientes();
						for (Cliente cliente : clientes) {
							if (cliente.tipoCliente().equals("estandar")) {
								data.add(cliente);
							}
						}
						if(data.isEmpty()) {
							messageController("info", "No hay clientes para mostrar.n");
						} else {
							table.setItems(data);
							vista.cargarDatosListado(table, 1);							
						}
					} catch (Exception e) {
						messageController("error", "El listado no puedo ser mostrado por un fallo de conexión con la base de datos.");
					}
				} else {
					gestionMenu();
				}
			}
			
		});
	}
	
	/**
	 * Metodo que implementa el muestreo de clientes Premium
	 */

	public void mostrarPremium() {
		Pane root = this.vista.mostrarListado("cliente");
		Button buttonBuscar = (Button) root.getChildren().get(2);
		@SuppressWarnings("unchecked")
		TableView<Cliente> table = (TableView<Cliente>) root.getChildren().get(1);
		
		root.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(event.getTarget().equals(buttonBuscar)) {
					ArrayList<Cliente> clientes;
					ObservableList<Cliente> data = FXCollections.observableArrayList();
					try {
						clientes = datos.getClientes();
						for (Cliente cliente : clientes) {
							if (cliente.tipoCliente().equals("premium")) {
								data.add(cliente);
							}
						}
						if(data.isEmpty()) {
							messageController("info", "No hay clientes para mostrar.");
						} else {
							table.setItems(data);
							vista.cargarDatosListado(table, 1);							
						}
					} catch (Exception e) {
						messageController("error", "El listado no puedo ser mostrado por un fallo de conexión con la base de datos.");
					}
				} else {
					gestionMenu();
				}
			}
			
		});
	}
	
	/**
	 * Metodo que implementa el muestreo de articulos
	 */
	
	public void mostrarArticulos() {
		Pane root = this.vista.mostrarListado("articulo");
		Button buttonBuscar = (Button) root.getChildren().get(2);
		@SuppressWarnings("unchecked")
		TableView<Articulo> table = (TableView<Articulo>) root.getChildren().get(1);
		
		root.addEventFilter(ActionEvent.ACTION, new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(event.getTarget().equals(buttonBuscar)) {
					ArrayList<Articulo> articulos;
					ObservableList<Articulo> data = FXCollections.observableArrayList();
					
					try {
						articulos = datos.getArticulos();
						if(articulos.isEmpty()) {
							messageController("info", "No hay articulos para mostrar.");
						} else {
							for (Articulo articulo: articulos) {
								data.add(articulo);
							}
							table.setItems(data);
							vista.cargarDatosListado(table, 1);
						}
					} catch (Exception e) {
						e.printStackTrace();
						messageController("error", "El listado no puedo ser mostrado por un fallo de conexión con la base de datos.");
					}
				} else {
					gestionMenu();
				}
			}
			
		});

	}
	
	/**
	 * Metodo que implementa el muestreo de pedidos pendientes
	 */

	public void mostrarPedidosPendientes() {
		Pane root = this.vista.mostrarListado("pedido");
		Button buttonBuscar = (Button) root.getChildren().get(4);
		Button buttonVolver = (Button) root.getChildren().get(5);
		CheckBox checkBox = (CheckBox) root.getChildren().get(2);
		TextField input = (TextField) root.getChildren().get(3);
		@SuppressWarnings("unchecked")
		TableView<Pedido> table = (TableView<Pedido>) root.getChildren().get(1);
		
		buttonBuscar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ArrayList<Pedido> pedidos;
				ObservableList<Pedido> data = FXCollections.observableArrayList();
				try {
					pedidos = datos.getPedidos();
					System.out.println(checkBox.isSelected());
					if (checkBox.isSelected()) {
						Cliente cliente = datos.getClienteByNif(input.getText());
						pedidos.forEach((pedido) -> {
							if (pedido.getCliente().getNif().equals(cliente.getNif()) && !pedido.pedidoEnviado()) {
								pedido.setCodArticulo(null);
								pedido.setEmail(null);
								data.add(pedido);
							}
						});
					} else {
						pedidos.forEach((pedido) -> {
							if (!pedido.pedidoEnviado()) {
								pedido.setCodArticulo(null);
								pedido.setEmail(null);
								data.add(pedido);
							}
						});
					}
					if (data.isEmpty()) {
						messageController("info", "No hay ningún pedido que coincida con los parámetros de búsqueda");
					} else {
						table.setItems(data);
						vista.cargarDatosListado(table, 1);
					}
				} catch (Exception e){
					messageController("error", "El listado no puedo ser mostrado por un fallo de la aplicación.");
				}
			}
			
		});
		
		buttonVolver.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				gestionMenu();
			}
			
		});
	}
	
	/**
	 * Metodo que implementa el muestreo de pedidos enviados
	 */

	public void mostrarPedidosEnviados() {
		Pane root = this.vista.mostrarListado("pedido");
		Button buttonBuscar = (Button) root.getChildren().get(4);
		Button buttonVolver = (Button) root.getChildren().get(5);
		CheckBox checkBox = (CheckBox) root.getChildren().get(2);
		TextField input = (TextField) root.getChildren().get(3);
		@SuppressWarnings("unchecked")
		TableView<Pedido> table = (TableView<Pedido>) root.getChildren().get(1);
		
		buttonBuscar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				ArrayList<Pedido> pedidos;
				ObservableList<Pedido> data = FXCollections.observableArrayList();
				try {
					pedidos = datos.getPedidos();
					if (checkBox.isSelected()) {
						Cliente cliente = datos.getClienteByNif(input.getText());
						pedidos.forEach((pedido) -> {
							if (pedido.getCliente().getNif().equals(cliente.getNif()) && pedido.pedidoEnviado()) {
								pedido.setCodArticulo(null);
								pedido.setEmail(null);
								data.add(pedido);
							}
						});
					} else {
						pedidos.forEach((pedido) -> {
							if (pedido.pedidoEnviado()) {
								pedido.setCodArticulo(null);
								pedido.setEmail(null);
								data.add(pedido);
							}
						});
					}
					if (data.isEmpty()) {
						messageController("info", "No hay ningún pedido que coincida con los parámetros de búsqueda");
					} else {
						table.setItems(data);
						vista.cargarDatosListado(table, 1);
					}
				} catch (Exception e){
					messageController("error", "El listado no puedo ser mostrado por un fallo de la aplicación.");
				}
			}
			
		});
		
		buttonVolver.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				gestionMenu();
			}
			
		});
	}
	
	public void closeApp() {
		this.vista.closeApp();
	}
	
	public void messageController(String type, String message) {
		try {
			this.vista.mostrarDialog(message, type);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
