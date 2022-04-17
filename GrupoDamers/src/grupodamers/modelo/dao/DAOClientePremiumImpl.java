package grupodamers.modelo.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import grupodamers.modelo.Cliente;
import grupodamers.modelo.ClientePremium;

public class DAOClientePremiumImpl extends DAOClienteImpl {

	public DAOClientePremiumImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getTotalCount() throws Exception {
		try {
			this.conectar();
			// PreparedStatement st = this.conexion.prepareStatement("SELECT COUNT(Email) FROM cliente WHERE isPremium = 1");
			CallableStatement st = this.conexion.prepareCall("{ call total_count_cliente() }");
			ResultSet rs = st.executeQuery();
			return rs.getInt(1);
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
	}

	@Override
	public ArrayList<Cliente> getAll() throws Exception {
		ArrayList<Cliente> registros = new ArrayList<>();
		try {
			this.conectar();
			// PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM cliente WHERE isPremium = 1");
			CallableStatement st = this.conexion.prepareCall("{ call show_clientes() }");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				ClientePremium cliente = new ClientePremium();
				cliente.setEmail(rs.getString(1));
				cliente.setNombre(rs.getString(2));
				cliente.setDomicilio(rs.getString(3));
				cliente.setNif(rs.getString(4));
				registros.add(cliente);
			}
			return registros;
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
	}

	@Override
	public void add(Cliente t) throws Exception {
		try {
			this.conectar();
			// PreparedStatement st = this.conexion.prepareStatement("INSERT INTO cliente (Email, Nombre, Domicilio, NIF, isPremium) VALUES (?, ?, ?, ?, 1)");
			CallableStatement st = this.conexion.prepareCall("{ call add_cliente(?,?,?,?,?) }");
			st.setString(1, t.getEmail());
			st.setString(2, t.getNombre());
			st.setString(3, t.getDomicilio());
			st.setString(4, t.getNif());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
	}

	@Override
	public void delete(Cliente t) throws Exception {
		try {
			this.conectar();
			// PreparedStatement st = this.conexion.prepareStatement("DELETE * FROM cliente WHERE NIF = ?");
			CallableStatement st = this.conexion.prepareCall("{ call delete_cliente(?) }");
			st.setString(1, t.getNif());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}	
	}

}
