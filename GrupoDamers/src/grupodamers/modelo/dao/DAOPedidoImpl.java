package grupodamers.modelo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;

import grupodamers.modelo.Cliente;
import grupodamers.modelo.Pedido;
import grupodamers.modelo.factory.DAOFactory;
import grupodamers.modelo.Articulo;
import grupodamers.modelo.interfaces.DAO;

public class DAOPedidoImpl extends Conexion implements DAO<Pedido>{

	public DAOPedidoImpl() {
	}

	@Override
	public ArrayList<Pedido> getAll() throws Exception {
		try {
			Session session = UtilHibernate.getSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			ArrayList<Pedido> list = (ArrayList<Pedido>) session.createQuery("from Pedido").list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void add(Pedido t) throws Exception {
		try {
			Session session = UtilHibernate.getSession();
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Pedido t) throws Exception {
		try {
			Session session = UtilHibernate.getSession();
			session.beginTransaction();
			session.delete(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Pedido get(String id) throws Exception {
		DAOClienteImpl daoCliente = DAOFactory.getClienteEstandar();
		DAOArticuloImpl daoArticulo = DAOFactory.getArticulo();
		try {
			Session session = UtilHibernate.getSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			Query<Object[]> consulta = session.createSQLQuery("select * from pedido where Num_Pedido =:id");
			consulta.setParameter("id", id);
			Object[] object = consulta.uniqueResult();
			session.getTransaction().commit();
			if (object != null) {
				Pedido pedido = new Pedido();
				pedido.setNumPedido(id);
				Cliente cliente = daoCliente.get(object[1].toString());
				pedido.setCliente(cliente);
				Articulo articulo = daoArticulo.get(object[2].toString());
				pedido.setArticulo(articulo);
				pedido.setCantidad((int) object[3]);
				pedido.setFecha(object[4].toString());
				pedido.setPrecioEnvio(((BigDecimal) object[5]).doubleValue());
				pedido.setPrecioTotal(((BigDecimal) object[6]).doubleValue());
				return pedido;				
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
