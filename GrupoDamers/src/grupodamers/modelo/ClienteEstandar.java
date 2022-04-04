package grupodamers.modelo;

/**
 * Metodo que contiene los metodos de la clase cliente Estandar
 */

public class ClienteEstandar extends Cliente{
	
	/**
	 * Contructor de clase
	 * @param nombre
	 * @param domicilio
	 * @param nif
	 * @param email
	 */

	public ClienteEstandar(String nombre, String domicilio, String nif, String email) {
		super(nombre, domicilio, nif, email);
	}
	
	/**
	 * Contructor vacio
	 */
	
	public ClienteEstandar() {
		super();
	}
	
	/**
	 * Implementación del método tipoCliente()
	 * @return el tipo de cliente
	 */
	
	public String tipoCliente() {
		String tipo = "estandar";
		return tipo;
	}
	
	/**
	 * Implementación del método calcAnual()
	 * @return float calcAnual
	 */
	
	public float calcAnual() {
		float calc = 0;
		return calc;
	}
	
	/**
	 * Implementación del método descuentoEnv()
	 * @return float descuentoEnv
	 */

	public float descuentoEnv() {
		float descuento = 0;
		return descuento;
	}
	
	/**
	 * Metodo para mostrar datos de un articulo
	 */ 
	    
	public String toString() {
    	return "Los datos del cliente estandar son: [nombre= " + super.getNombre() + 
    			" domicilio= " + super.getDomicilio() + 
    			" nif= " + super.getNif() + 
    			" email= " + super.getEmail() + "]\n";
    }
}
