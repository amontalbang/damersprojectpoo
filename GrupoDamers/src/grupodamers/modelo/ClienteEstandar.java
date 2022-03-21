package grupodamers.modelo;

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
	 * Implementaci�n del m�todo tipoCliente()
	 * @return el tipo de cliente
	 */
	
	public String tipoCliente() {
		String tipo = "estandar";
		return tipo;
	}
	
	/**
	 * Implementaci�n del m�todo calcAnual()
	 * @return 
	 */
	
	public float calcAnual() {
		float calc = 0;
		return calc;
	}
	
	/**
	 * Implementaci�n del m�todo descuentoEnv()
	 * @return 
	 */

	public float descuentoEnv() {
		float descuento = 0;
		return descuento;
	}
	
	/**
	 * Metodo para mostrar datos de un articulo
	 * @return 
	 */ 
	    
	public String toString() {
    	return "Los datos del cliente estandar son: [nombre= " + super.getNombre() + 
    			" domicilio= " + super.getDomicilio() + 
    			" nif= " + super.getNif() + 
    			" email= " + super.getEmail() + "]";
    }
}
