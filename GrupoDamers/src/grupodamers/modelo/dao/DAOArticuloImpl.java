package grupodamers.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import grupodamers.modelo.Articulo;
import grupodamers.modelo.interfaces.DAO;

public class DAOArticuloImpl extends Conexion implements DAO<Articulo>{

	public DAOArticuloImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getTotalCount() throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("SELECT COUNT(Codigo_Articulo) FROM articulo");
			ResultSet rs = st.executeQuery();
			return rs.getInt(1);
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
	}

	@Override
	public ArrayList<Articulo> getAll() throws Exception {
		ArrayList<Articulo> registros = new ArrayList<>();
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM articulo");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Articulo articulo = new Articulo();
				articulo.setCodigo(rs.getString(1));
				articulo.setDescripcion(rs.getString(2));
				articulo.setPrecioVenta(rs.getDouble(3));
				articulo.setGastosEnvio(rs.getDouble(4));
				articulo.setTiempoPrep(rs.getInt(5));
				registros.add(articulo);
			}
			return registros;
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
	}

	@Override
	public void add(Articulo t) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("INSERT INTO articulo (Codigo_Articulo, Descripcion, PVP, Gastos_Envio, Tiempo_Preparacion) VALUES (?, ?, ?, ?, ?)");
			st.setString(1, t.getCodigo());
			st.setString(2, t.getDescripcion());
			st.setDouble(3, t.getPrecioVenta());
			st.setDouble(4, t.getGastosEnvio());
			st.setInt(5, t.getTiempoPrep());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
	}

	@Override
	public void delete(Articulo t) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("DELETE * FROM articulo WHERE Codigo_Articulo = ?");
			st.setString(1, t.getCodigo());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}	
	}

	@Override
	public void update(Articulo t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Articulo get(String id) throws Exception {
		Articulo articulo = new Articulo();
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM articulo WHERE Codigo_Articulo = ?");
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			articulo.setCodigo(rs.getString(1));
			articulo.setDescripcion(rs.getString(2));
			articulo.setPrecioVenta(rs.getDouble(3));
			articulo.setGastosEnvio(rs.getDouble(4));
			articulo.setTiempoPrep(rs.getInt(5));
			return articulo;
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
	}

}
