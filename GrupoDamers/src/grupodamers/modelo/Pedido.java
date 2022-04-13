/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupodamers.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author DAMERs Project POO
 */
public class Pedido {
    
    private String numPedido;
    private Cliente cliente;
    private Articulo articulo;
    private int cantidad;
    private String fecha;
    private double precioEnvio;
    private double precioTotal;
    
    /**
     * Metodo constructor por defecto
     */
    
    public Pedido(){
    }
    
    /**
    * Metodos constructores parametrizados
        * @param numPedido Numero de Pedido
        * @param cliente Cliente que realiza el pedido
        * @param articulo Articulo que registra el pedido
        * @param cantidad Cantidad de un articulo en el pedido
        * @param fecha fecha en la que se realiza el pedido
    */ 
    
    public Pedido(String numPedido, Cliente cliente, Articulo articulo, int cantidad, String fecha){
        this.numPedido = numPedido;
        this.cliente = cliente;
        this.articulo = articulo; 
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.precioEnvio = this.precioEnvio();
        this.precioTotal = this.precioTotal();
    }
    
    public Pedido(Cliente cliente, Articulo articulo, int cantidad, String fecha){
        this.cliente = cliente;
        this.articulo = articulo; 
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.precioEnvio = this.precioEnvio();
        this.precioTotal = this.precioTotal();
    } 
    
     /**
    * Metodo para obtener el numero de pedido
        * @return  Devuelve un int con el numero
    */
    
    public String getNumPedido(){
        return this.numPedido;
    }
    
    /**
    * Metodo para registrar numero de pedido
        * @param numPedido Numero de pedido
    */ 
    
    public void setNumPedido(String numPedido){
        this.numPedido = numPedido;
    }
    
     /**
    * Metodo para obtener el cliente registrado en un pedido
        * @return  Devuelve un string con el cliente
    */
    
    public Cliente getCliente(){
        return this.cliente;
    }
    
    /**
    * Metodo para registrar cliente registrado en un pedido
        * @param cliente cliente registrado en un pedido
    */ 
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
      /**
    * Metodo para obtener el articulo registrado en un pedido
        * @return  Devuelve un string con el articulo
    */
    
    public Articulo getArticulo(){
        return this.articulo;
    }
    
    /**
    * Metodo para registrar articulo registrado en un pedido
        * @param articulo articulo registrado en un pedido
    */ 
    
    public void setArticulo(Articulo articulo){
        this.articulo = articulo;
    }
    
     /**
    * Metodo para obtener el numero de articulos de un pedido
        * @return  Devuelve un int con la cantidad
    */
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    /**
    * Metodo para registrar numero de articulos de un pedido
        * @param cantidad Numero de articulos de un pedido
    */ 
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
      /**
    * Metodo para obtener la fecha en la que realiza un pedido
        * @return  Devuelve un string con el articulo
    */
    
    public String getFecha(){
        return this.fecha;
    }
    
    /**
    * Metodo para registrar la fecha en la que realiza un pedido
        * @param fecha fecha en la que realiza un pedido
    */ 
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    /**
     * Metodo para setear el precio de envio de un pedido
     * @param precio
     */
    
    public void setPrecioEnvio(Double precio) {
    	this.precioEnvio = precio;
    }
    
    /**
     * Metodo para obtener el precio de envio de un pedido
     * @return precioEnvio
     */
    
    public Double getPrecioEnvio() {
    	return this.precioEnvio;
    }
    
    /**
     * Metodo para setear el precio total de un pedido
     * @param precioTotal
     */
    
    public void setPrecioTotal(Double precioTotal) {
    	this.precioTotal = precioTotal;
    }
    
    /**
     * Metodo para obtener el precio total de un pedido
     * @return precioTotal
     */
    
    public Double getPrecioTotal() {
    	return this.precioTotal;
    }
    
    /**
    * Metodo para mostrar datos de un pedido
    */ 
    
    public String toString() {
    	if(this.pedidoEnviado()) {
    		return "Pedido [numPedido= " + this.numPedido + ", nombre del cliente= " + this.cliente.getNombre() + ", NIF del cliente= " + this.cliente.getNif() + ",  codigo de articulo= " + this.articulo.getCodigo() +
    				", precio del articulo= " + this.articulo.getPrecioVenta() + ", descripcion de articulo= " + this.articulo.getDescripcion() +
    				", coste de envio del articulo= " + this.articulo.getGastosEnvio() + ", cantidad= " + this.cantidad + ", fecha= " + this.fecha + ", el coste total del envio= " +
    				String.format("%.2f", this.precioEnvio) + ", el coste del pedido= " + this.precioTotal + ". El pedido ha sido enviado]\n";
    		
    	} else {
    		return "Pedido [numPedido= " + this.numPedido + ", nombre del cliente= " + this.cliente.getNombre() + ", NIF del cliente= " + this.cliente.getNif() + ",  codigo de articulo= " + this.articulo.getCodigo() +
    				", precio del articulo= " + this.articulo.getPrecioVenta() + ", descripcion de articulo= " + this.articulo.getDescripcion() +
    				", coste de envio del articulo= " + this.articulo.getGastosEnvio() + ", cantidad=" + this.cantidad + ", fecha= " + this.fecha + ", el coste total del envio= " +
    				String.format("%.2f", this.precioEnvio) + ", el coste del pedido= " + this.precioTotal + ". El pedido aun no ha sido enviado]\n";
    	}
    }
    
    /**
     * Metodo que comprueba si un pedido ha sido enviado
     * @return boolean pedidoEnviado
     */
    
    public boolean pedidoEnviado() {
    	LocalDateTime fechaEnvio;
		DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		
		fechaEnvio = LocalDateTime.parse(this.fecha, fmt);
		fechaEnvio = fechaEnvio.plusMinutes(this.articulo.getTiempoPrep());
		
		if (fechaEnvio.isBefore(LocalDateTime.now())) {
			return true;
		} else {
			return false;
		}
    }
    
    /**
     * Metodo para calcular el precio del envio
     * @return double precio
     */
    
    public double precioEnvio() {
    	double precio = 0;
    	String tipoCliente = this.cliente.tipoCliente();
    	
    	if(tipoCliente.equals("premium")) {
    		precio = this.articulo.getGastosEnvio() * 0.8;
    	} else {
    		precio = this.articulo.getGastosEnvio();
    	}
    	return precio;
    }
    
    /**
     * Metodo para calcular el precio total del pedido
     * @return double precioTotal
     */
    
    public double precioTotal() {
    	double precio = 0;
    	
    	precio = this.articulo.getPrecioVenta() * this.cantidad + this.precioEnvio;
    	return precio;
    }
}
