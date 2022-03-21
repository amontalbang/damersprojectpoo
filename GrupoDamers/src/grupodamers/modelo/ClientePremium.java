package grupodamers.modelo;

public class ClientePremium extends Cliente{
	
	/**
	 * Contructor de clase
	 * @param nombre
	 * @param domicilio
	 * @param nif
	 * @param email
	 */

	public ClientePremium(String nombre, String domicilio, String nif, String email) {
		super(nombre, domicilio, nif, email);
	}
	
	/**
	 * Implementación del método tipoCliente()
	 * @return el tipo de cliente
	 */
	
	public String tipoCliente() {
		String tipo = "premium";
		return tipo;
	}
	
	/**
	 * Implementación del método calcAnual()
	 * @return 
	 */
	
	public float calcAnual() {
		float calc = 30;
		return calc;
	}
	
	/**
	 * Implementación del método descuentoEnv()
	 * @return 
	 */

	public float descuentoEnv() {
		float descuento = 20;
		return descuento;
	}

}
