package grupodamers.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ListaPedidos extends Lista<Pedido> {
	
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
	
	public void deleteElement(Pedido pedido) throws Exception {
		if(validDelete(pedido)) {
			this.lista.remove(pedido);			
		} else {
			throw new Exception("El pedido no puede ser cancelado");
		}
	}
	
	private boolean validDelete(Pedido pedido) {
		LocalDateTime fechaLimite;
		DateTimeFormatter fmt = DateTimeFormatter.ISO_LOCAL_DATE;
		
		fechaLimite = LocalDateTime.parse(pedido.getFecha(), fmt);
		fechaLimite = fechaLimite.plusMinutes(pedido.getArticulo().getTiempoPrep());
		
		if (fechaLimite.isBefore(LocalDateTime.now())) {
			return false;
		} else {
			return true;
		}
	}
}
