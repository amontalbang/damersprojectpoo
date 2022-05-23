package grupodamers.vista;

import grupodamers.modelo.Cliente;

import java.util.Map;

import grupodamers.modelo.Articulo;
import grupodamers.modelo.Pedido;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class UtilsVista {

	public static Button createButton(String title, double x, double y, double h, double w) {
		Button button = new Button(title);
		button.setPrefHeight(h);
		button.setPrefWidth(w);
		button.setLayoutX(x);
		button.setLayoutY(y);
		return button;
	}
	
	public static Label createLabel(String title, double x, double y) {
		Label label = new Label(title);
		label.setLayoutX(x);
		label.setLayoutY(y);
		return label;
	}
	
	public static TextField createTextField(double x, double y) {
		TextField text = new TextField();
		text.setLayoutX(x);
		text.setLayoutY(y);
		return text;
	}
	
	public static TableView<Cliente> createTableCliente(TableConfig config, Map<String, String> properties) {
		TableView<Cliente> table = new TableView<Cliente>();
		table.setLayoutX(config.getLayoutX());
		table.setLayoutY(config.getLayoutY());
		table.setPrefWidth(config.getWidth());
		table.setPrefHeight(config.getHeight());
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		for(String name: config.getColumns()) {
			TableColumn<Cliente, String> column = new TableColumn<Cliente, String>(name);
			column.setCellValueFactory(new PropertyValueFactory<Cliente, String>(properties.get(name)));
			table.getColumns().add(column);
		}
		table.setEditable(false);
		return table;
	}
	
	public static TableView<Pedido> createTablePedido(TableConfig config, Map<String, String> properties) {
		TableView<Pedido> table = new TableView<Pedido>();
		table.setLayoutX(config.getLayoutX());
		table.setLayoutY(config.getLayoutY());
		table.setPrefWidth(config.getWidth());
		table.setPrefHeight(config.getHeight());
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		for(String name: config.getColumns()) {
			TableColumn<Pedido, String> column = new TableColumn<Pedido, String>(name);
			column.setCellValueFactory(new PropertyValueFactory<Pedido, String>(properties.get(name)));
			table.getColumns().add(column);
		}
		table.setEditable(false);
		return table;
	}
	
	public static TableView<Articulo> createTableArticulo(TableConfig config, Map<String, String> properties) {
		TableView<Articulo> table = new TableView<Articulo>();
		table.setLayoutX(config.getLayoutX());
		table.setLayoutY(config.getLayoutY());
		table.setPrefWidth(config.getWidth());
		table.setPrefHeight(config.getHeight());
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		for(String name: config.getColumns()) {
			TableColumn<Articulo, String> column = new TableColumn<Articulo, String>(name);
			column.setCellValueFactory(new PropertyValueFactory<Articulo, String>(properties.get(name)));
			table.getColumns().add(column);
		}
		table.setEditable(false);
		return table;
	}
}
