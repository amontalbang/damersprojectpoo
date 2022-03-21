package grupodamers.controlador;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ControladorTest {
	
	HashMap<String, String> map;

	@Before
	public void setUp() throws Exception {
		System.out.println("Se inician las pruebas");
		HashMap<String, String> cliente = new HashMap<String, String>();
		cliente.put("nombre", "Alberto");
		cliente.put("domicilio", "Calle Plaza Bambola");
		cliente.put("nif", "20918145J");
		cliente.put("email", "amontalguaisadjsh");
		cliente.put("isPremium", "S");
		this.map = cliente;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddCliente() throws Exception {
		HashMap<String, String> entrada;
		String nombre, domicilio, email, nif;
		boolean isPremium;

		entrada = this.map;
		if (entrada.isEmpty()) {
			fail("La entrada no se ha registrado correctamente");
		}
		nombre = entrada.get("nombre");
		assertTrue("Alberto".equals(nombre));
		domicilio = entrada.get("domicilio");
		assertTrue("Calle Plaza Bambola".equals(domicilio));
		email = entrada.get("email");
		assertTrue("amontalguaisadjsh".equals(email));
		nif = entrada.get("nif");
		assertTrue("20918145J".equals(nif));
		if (entrada.get("isPremium").equals("S")) {
			isPremium = true;
		} else {
			isPremium = false;
		}
		assertTrue(isPremium == true);
	}
}
