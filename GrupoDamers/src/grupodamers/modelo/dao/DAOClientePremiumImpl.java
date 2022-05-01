package grupodamers.modelo.dao;

import java.util.ArrayList;

import org.hibernate.Session;

import grupodamers.modelo.Cliente;
import grupodamers.modelo.ClientePremium;

public class DAOClientePremiumImpl extends DAOClienteImpl {

	public DAOClientePremiumImpl() {
	}

	@Override
	public ArrayList<Cliente> getAll() throws Exception {
		try {
			Session session = UtilHibernate.getSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			ArrayList<Cliente> list = (ArrayList<Cliente>) session.createQuery("from ClientePremium").list();
			session.getTransaction().commit();
			return list;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void add(Cliente t) throws Exception {
		try {
			Session session = UtilHibernate.getSession();
			session.beginTransaction();
			ClientePremium cliente = (ClientePremium) t;
			session.save(cliente);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void delete(Cliente t) throws Exception {
		try {
			Session session = UtilHibernate.getSession();
			session.beginTransaction();
			session.delete(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}	
	}

}
