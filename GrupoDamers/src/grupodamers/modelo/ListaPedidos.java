package grupodamers.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Metodo que contiene los metodos de listaPedidos
 */

public class ListaPedidos extends Lista<Pedido> {
	
	/**
	 * Metodo para añadir un pedido a la lista pedidos
	 */
	
	public void addElement(Pedido pedido) throws Exception{
		if (existe(pedido.getNumPedido())) {
			throw new Exception("\n*** Ya existe un pedido con ese número. ***\n");
		} else {
			this.lista.add(pedido);
		}
	}
	
	/**
	 * Metodo que comprueba si existe un pedido
	 * @return boolean existe
	 */
	
	public boolean existe(String numPedido) {
		boolean existe = false;
		
		for (Pedido pedido: this.lista) {
			if (pedido.getNumPedido().equals(numPedido)) {
				existe = true;
				return existe;
			}
		}
		return existe;
	}
	
	/**
	 * Metodo devuelve un pedido dado un numero de pedido
	 * @return pedido
	 */
	
	public Pedido getPedidoByNumPedido(String numPedido) {
		Pedido pedido = new Pedido();
		
		for (Pedido p: this.lista) {
			if (p.getNumPedido().equals(numPedido)) {
				pedido = p;
				break;
			}
		}
		return pedido;
	}
	
	/**
	 * Metodo que elimina un pedido
	 */
	
	public void deleteElement(Pedido pedido) throws Exception {
		if(validDelete(pedido)) {
			this.lista.remove(pedido);			
		} else {
			throw new Exception("\n*** El pedido no puede ser cancelado ***\n");
		}
	}
	
	/**
	 * Metodo que comprueba si se puede eliminar un pedido
	 * @return boolean validDelete
	 */
	
	private boolean validDelete(Pedido pedido) {
		LocalDateTime fechaLimite;
		DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		
		fechaLimite = LocalDateTime.parse(pedido.getFecha(), fmt);
		fechaLimite = fechaLimite.plusMinutes(pedido.getArticulo().getTiempoPrep());
		
		if (fechaLimite.isBefore(LocalDateTime.now())) {
			return false;
		} else {
			return true;
		}
	}
}
