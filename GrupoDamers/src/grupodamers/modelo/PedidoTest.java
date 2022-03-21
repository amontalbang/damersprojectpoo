package grupodamers.modelo;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

public class PedidoTest {
	
	Pedido pedido;

	@Before
	public void setUp() throws Exception {
		String fecha;
		LocalDateTime fechaActual = LocalDateTime.now();
		DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		fecha = fechaActual.format(fmt);
		System.out.println(fechaActual);
		
		pedido = new Pedido("12", new ClientePremium("Alberto", "Domicilio", "NIF", "Email"), new Articulo(), 5, fecha);
	}

	@Test
	public void testPedidoEnviado() {
		LocalDateTime fechaEnvio;
		DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		boolean enviado = false;
		
		fechaEnvio = LocalDateTime.parse(pedido.getFecha(), fmt);
		fechaEnvio = fechaEnvio.plusMinutes(90);
		System.out.println(fechaEnvio);
		
		if (fechaEnvio.isBefore(LocalDateTime.now())) {
			enviado = true;
		} else {
			enviado = false;
		}
		
		assertTrue(enviado == false);
	}

}
