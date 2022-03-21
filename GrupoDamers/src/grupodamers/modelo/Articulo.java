/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupodamers.modelo;

/**
 * Esta clase contiene los atributos y metodos de la clase Articulo
    * @author DAMERs Project POO
 */

public class Articulo {
    
    private String codigo;
    private String descripcion;
    private double precioVenta;
    private double gastosEnvio;
    private int tiempoPrep;
    
    /**
     * Metodo constructor por defecto
     */
    
    public Articulo(){
    }
    
    /**
    * Metodos constructores parametrizados
        * @param codigo Codigo del articulo
        * @param descripcion Descripcion del articulo
        * @param precioVenta Precio de enta del articulo
        * @param gastosEnvio Gastos de envio para el articulo
        * @param tiempoPrep tiempo de preparacion del envio
    */ 
    
    public Articulo(String codigo, String descripcion, double precioVenta, double gastosEnvio, int tiempoPrep){
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precioVenta = precioVenta; 
        this.gastosEnvio = gastosEnvio;
        this.tiempoPrep = tiempoPrep;
    }  
    
    public Articulo(String codigo, double precioVenta, double gastosEnvio, int tiempoPrep){
        this.codigo = codigo;
        this.precioVenta = precioVenta; 
        this.gastosEnvio = gastosEnvio;
        this.tiempoPrep = tiempoPrep;
    }  
    
     /**
    * Metodo para obtener el codigo de un articulo
        * @return  Devuelve un string con el codigo
    */
    
    public String getCodigo(){
        return this.codigo;
    }
    
    /**
    * Metodo para registrar el codigo de un articulo
        * @param codigo Codigo del articulo
    */ 
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
     /**
    * Metodo para obtener la descripcion de un articulo
        * @return  Devuelve un string con la descripcion
    */
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    /**
    * Metodo para registrar la descripcion de un articulo
        * @param descripcion Descripcion del articulo
    */ 
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
     /**
    * Metodo para obtener el precio de venta de un articulo
        * @return  Devuelve un double con el precio de venta
    */
    
    public double getPrecioVenta(){
        return this.precioVenta;
    }
    
    /**
    * Metodo para registrar el precio de venta de un articulo
        * @param precioVenta Descripcion del articulo
    */ 
    
    public void setPrecioVenta(double precioVenta){
        this.precioVenta = precioVenta;
    }
    
     /**
    * Metodo para obtener los gastos de envio de un articulo
        * @return  Devuelve un double con los gastos de envio
    */
    
    public double getGastosEnvio(){
        return this.gastosEnvio;
    }
    
    /**
    * Metodo para registrar los gastos de envio de un articulo
        * @param gastosEnvio Descripcion del articulo
    */ 
    
    public void setGastosEnvio(double gastosEnvio){
        this.gastosEnvio = gastosEnvio;
    }
    
     /**
    * Metodo para obtener el tiempo de preparacion de envio de un articulo
        * @return  Devuelve un int con el tiempo de preparacion
    */
    
    public int getTiempoPrep(){
        return this.tiempoPrep;
    }
    
    /**
    * Metodo para registrar el tiempo de preparacion de envio de un articulo
        * @param tiempoPrep Descripcion del articulo
    */ 
    
    public void setTiempoPrep(int tiempoPrep){
        this.tiempoPrep = tiempoPrep;
    }
    
    /**
    * Metodo para mostrar datos de un articulo
    */ 
    
     public String toString() {
        return "Articulo [codigo= " + this.codigo + ", descripcion= " + this.descripcion + ",  precioVenta= " + this.precioVenta + "€, gastosEnvio= " + this.gastosEnvio + "€, tiempoPrep= " + this.tiempoPrep + "minutos]\n";
    }
}