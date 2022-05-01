package grupodamers.modelo.dao;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.query.Query;

import grupodamers.modelo.Articulo;
import grupodamers.modelo.interfaces.DAO;

public class DAOArticuloImpl extends Conexion implements DAO<Articulo>{

	public DAOArticuloImpl() {
	}

	@Override
	public ArrayList<Articulo> getAll() throws Exception {
		try {
			Session session = UtilHibernate.getSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			ArrayList<Articulo> list = (ArrayList<Articulo>) session.createQuery("from Articulo").list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void add(Articulo t) throws Exception {
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
	public void delete(Articulo t) throws Exception {
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
	public Articulo get(String id) throws Exception {
		try {
			Session session = UtilHibernate.getSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			Query<Object[]> consulta = session.createSQLQuery("select * from articulo where Codigo_Articulo =:id");
			consulta.setParameter("id", id);
			Object[] object = consulta.uniqueResult();
			session.getTransaction().commit();
			if (object != null) {
				Articulo articulo = new Articulo();
				articulo.setCodigo(object[0].toString());
				articulo.setDescripcion(object[1].toString());
				articulo.setGastosEnvio(((BigDecimal) object[2]).doubleValue());
				articulo.setPrecioVenta(((BigDecimal) object[3]).doubleValue());
				articulo.setTiempoPrep((int) object[4]);
				return articulo;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
