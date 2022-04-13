package grupodamers.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import grupodamers.modelo.Cliente;
import grupodamers.modelo.ClienteEstandar;
import grupodamers.modelo.ClientePremium;
import grupodamers.modelo.interfaces.DAO;

public abstract class DAOClienteImpl extends Conexion implements DAO<Cliente>{

	public DAOClienteImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract void add(Cliente t) throws Exception;
	
	@Override
	public abstract void delete(Cliente t) throws Exception;

	@Override
	public abstract void update(Cliente t) throws Exception;

	@Override
	public Cliente get(String id) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM cliente WHERE Codigo_cliente = ?");
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.getString(5).equals("1")) {
				ClientePremium cliente = new ClientePremium();
				cliente.setEmail(rs.getString(1));
				cliente.setNombre(rs.getString(2));
				cliente.setDomicilio(rs.getString(3));
				cliente.setNif(rs.getString(4));
				return cliente;
			} else {
				ClienteEstandar cliente = new ClienteEstandar();
				cliente.setEmail(rs.getString(1));
				cliente.setNombre(rs.getString(2));
				cliente.setDomicilio(rs.getString(3));
				cliente.setNif(rs.getString(4));
				return cliente;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
	};

	@Override
	public abstract int getTotalCount() throws Exception;

	@Override
	public abstract ArrayList<Cliente> getAll() throws Exception;

	

}
