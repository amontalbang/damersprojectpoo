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
	 * Implementaci�n del m�todo tipoCliente()
	 * @return el tipo de cliente
	 */
	
	public String tipoCliente() {
		String tipo = "premium";
		return tipo;
	}
	
	/**
	 * Implementaci�n del m�todo calcAnual()
	 * @return 
	 */
	
	public float calcAnual() {
		float calc = 30;
		return calc;
	}
	
	/**
	 * Implementaci�n del m�todo descuentoEnv()
	 * @return 
	 */

	public float descuentoEnv() {
		float descuento = 20;
		return descuento;
	}

}
