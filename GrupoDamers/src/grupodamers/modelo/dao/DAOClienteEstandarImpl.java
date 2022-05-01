package grupodamers.modelo.dao;

import java.util.ArrayList;

import org.hibernate.Session;

import grupodamers.modelo.Cliente;
import grupodamers.modelo.ClienteEstandar;

public class DAOClienteEstandarImpl extends DAOClienteImpl {

	public DAOClienteEstandarImpl() {
	}

	@Override
	public ArrayList<Cliente> getAll() throws Exception {
		try {
			Session session = UtilHibernate.getSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			ArrayList<Cliente> list = (ArrayList<Cliente>) session.createQuery("from ClienteEstandar").list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void add(Cliente t) throws Exception {
		try {
			ClienteEstandar cliente = (ClienteEstandar) t;
			Session session = UtilHibernate.getSession();
			session.beginTransaction();
			session.save(cliente);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Cliente t) throws Exception {
		try {
			ClienteEstandar cliente = (ClienteEstandar) t;
			Session session = UtilHibernate.getSession();
			session.beginTransaction();
			session.delete(cliente);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}

}
