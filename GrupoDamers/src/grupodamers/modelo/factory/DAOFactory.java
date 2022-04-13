package grupodamers.modelo.factory;

import grupodamers.modelo.dao.*;

public class DAOFactory {
	
	public DAOClientePremiumImpl getClientePremium() {
		return new DAOClientePremiumImpl();
	}
	
	public DAOClienteEstandarImpl getClienteEstandar() {
		return new DAOClienteEstandarImpl();
	}
	
	public DAOArticuloImpl getArticulo() {
		return new DAOArticuloImpl();
	}
	
	public DAOPedidoImpl getPedido() {
		return new DAOPedidoImpl();
	}

}
