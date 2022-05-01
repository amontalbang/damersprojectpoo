package grupodamers.modelo.dao;

import java.util.ArrayList;

import org.hibernate.query.Query;
import org.hibernate.Session;

import grupodamers.modelo.Cliente;
import grupodamers.modelo.ClienteEstandar;
import grupodamers.modelo.ClientePremium;
import grupodamers.modelo.interfaces.DAO;

public abstract class DAOClienteImpl extends Conexion implements DAO<Cliente>{

	public DAOClienteImpl() {
	}

	@Override
	public abstract void add(Cliente t) throws Exception;
	
	@Override
	public abstract void delete(Cliente t) throws Exception;

	@SuppressWarnings("unchecked")
	@Override
	public Cliente get(String id) throws Exception {
		try {
			Session session = UtilHibernate.getSession();
			session.beginTransaction();
			Query<Object[]> consulta;
			if (id.contains("@")) {
				consulta = session.createSQLQuery("select * from cliente where Email =:id");
			} else {
				consulta = session.createSQLQuery("select * from cliente where NIF =:id");
			}
			consulta.setParameter("id", id);
			Object[] object = consulta.uniqueResult();
			session.getTransaction().commit();
			if (object != null) {
				Cliente cliente;
				if (object[4].toString().equals("1")) {
					cliente = new ClientePremium();
					cliente.setEmail(object[0].toString());
					cliente.setNombre(object[1].toString());
					cliente.setDomicilio(object[2].toString());
					cliente.setNif(object[3].toString());
				} else {
					cliente = new ClienteEstandar();
					cliente.setEmail(object[0].toString());
					cliente.setNombre(object[1].toString());
					cliente.setDomicilio(object[2].toString());
					cliente.setNif(object[3].toString());
				}
				return cliente;				
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		}
	};

	@Override
	public abstract ArrayList<Cliente> getAll() throws Exception;

	

}
