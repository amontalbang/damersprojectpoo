/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlinestore;

/**
 *
 * @author DAMERs Project POO
 */
public class Pedido {
    
    private int numPedido;
    private String cliente;
    private String articulo;
    private int cantidad;
    private String fecha;
    
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
    
    public Pedido(int numPedido, String cliente, String articulo, int cantidad, String fecha){
        this.numPedido = numPedido;
        this.cliente = cliente;
        this.articulo = articulo; 
        this.cantidad = cantidad;
        this.fecha = fecha;
    }  
    
     /**
    * Metodo para obtener el numero de pedido
        * @return  Devuelve un int con el numero
    */
    
    public int getNumPedido(){
        return this.numPedido;
    }
    
    /**
    * Metodo para registrar numero de pedido
        * @param numPedido Numero de pedido
    */ 
    
    public void setNumPedido(int numPedido){
        this.numPedido = numPedido;
    }
    
     /**
    * Metodo para obtener el cliente registrado en un pedido
        * @return  Devuelve un string con el cliente
    */
    
    public String getCliente(){
        return this.cliente;
    }
    
    /**
    * Metodo para registrar cliente registrado en un pedido
        * @param cliente cliente registrado en un pedido
    */ 
    
    public void setCliente(String cliente){
        this.cliente = cliente;
    }
    
      /**
    * Metodo para obtener el articulo registrado en un pedido
        * @return  Devuelve un string con el articulo
    */
    
    public String getArticulo(){
        return this.articulo;
    }
    
    /**
    * Metodo para registrar articulo registrado en un pedido
        * @param articulo articulo registrado en un pedido
    */ 
    
    public void setArticulo(String articulo){
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
    * Metodo para mostrar datos de un pedido
    */ 
    
    public String toString() {
        return "Pedido [numPedido=" + numPedido + ", cliente=" + cliente + ",  articulo=" + articulo + ", cantidad=" + cantidad + ", fecha=" + fecha + "]";
    }
}
