/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupodamers.modelo;
    
/**
 * Esta clase contiene los atributos y metodos de la clase Cliente
    * @author DAMERs Project POO
 */

public abstract class Cliente {
    
    private String nombre;
    private String domicilio;
    private String nif;
    private String email;
    
    /**
     * Metodo constructor por defecto
     */
    
    public Cliente(){
    }
    
    /**
    * Metodos constructores parametrizados
        * @param nombre Nombre del cliente
        * @param domicilio Dominicilio del cliente
        * @param nif Documento Nacional de Identidad del cliente
        * @param email Direccion email del cliente
    */ 
    
    public Cliente(String nombre, String domicilio, String nif, String email){
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif; 
        this.email = email;
    }  
    
    /**
    * Metodo para obtener el nombre de un Cliente
        * @return  Devuelve un string con el nombre
    */
    
    public String getNombre(){
        return this.nombre;
    }
    
    /**
    * Metodo para registrar el nombre de un Cliente
        * @param nombre Nombre del cliente
    */ 
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
    * Metodo para obtener el domicilio de un Cliente
        * @return  Devuelve un string con el domicilio
    */
    
    public String getDomicilio(){
        return this.domicilio;
    }
    
    /**
    * Metodo para registrar el domicilio de un Cliente
        * @param domicilio domicilio del cliente
    */ 
    
    public void setDomicilio(String domicilio){
        this.domicilio = domicilio;
    }
    
    /**
    * Metodo para obtener el nif de un Cliente
        * @return  Devuelve un string con el nif
    */
    
    public String getNif(){
        return this.nif;
    }
    
    /**
    * Metodo para registrar el nif de un Cliente
        * @param nif nif del cliente
    */ 
    
    public void setNif(String nif){
        this.nif = nif;
    }
    
    /**
    * Metodo para obtener el email de un Cliente
        * @return  Devuelve un string con el email
    */
    
    public String getEmail(){
        return this.email;
    }
    
    /**
    * Metodo para registrar el nif de un Cliente
        * @param email email del cliente
    */ 
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String toString() {
    	return "Los datos del cliente son: [nombre= " + this.nombre + 
    			" domicilio= " + this.domicilio + 
    			" nif= " + this.nif + 
    			" email= " + this.email + "]\n";
    }
     
     /**
      * Metodo para conocer el tipo de cliente
      * @return el tipo de cliente que es "Premium" o "Estandar"
      */
     
     public abstract String tipoCliente();
     
     /**
      * Metodo para obtener el calculo anual
      * @return el calculo del precio anual
      */
     
     public abstract float calcAnual();
     
     /**
      * Metodo para obtener el porcentaje de descuento
      * @return el descuento que se debe aplicar
      */
     
     public abstract float descuentoEnv();
}