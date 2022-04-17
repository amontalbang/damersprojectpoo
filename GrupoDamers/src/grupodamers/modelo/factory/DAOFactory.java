package grupodamers.modelo.factory;

import grupodamers.modelo.dao.*;

public class DAOFactory {
	
	public static DAOClientePremiumImpl getClientePremium() {
		return new DAOClientePremiumImpl();
	}
	
	public static DAOClienteEstandarImpl getClienteEstandar() {
		return new DAOClienteEstandarImpl();
	}
	
	public static DAOArticuloImpl getArticulo() {
		return new DAOArticuloImpl();
	}
	
	public static DAOPedidoImpl getPedido() {
		return new DAOPedidoImpl();
	}

}
