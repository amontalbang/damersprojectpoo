package grupodamers.modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import grupodamers.modelo.Cliente;
import grupodamers.modelo.Pedido;
import grupodamers.modelo.Articulo;
import grupodamers.modelo.interfaces.DAO;

public class DAOPedidoImpl extends Conexion implements DAO<Pedido>{

	public DAOPedidoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getTotalCount() throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("SELECT COUNT(Num_Pedido) FROM pedido");
			ResultSet rs = st.executeQuery();
			return rs.getInt(1);
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
	}

	@Override
	public ArrayList<Pedido> getAll() throws Exception {
		ArrayList<Pedido> registros = new ArrayList<>();
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM pedido");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Pedido pedido = new Pedido();
				pedido.setNumPedido(Integer.toString(rs.getInt(1)));
				// pedido.setCliente(rs.getString(2));
				// pedido.setpedido(rs.getString(3));
				pedido.setCantidad(rs.getInt(4));
				// pedido.setFecha(rs.getDate(5)); PARSE A STRING
				registros.add(pedido);
			}
			return registros;
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
	}

	@Override
	public void add(Pedido t) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("INSERT INTO pedido (Cliente, Codigo_Articulo, Cantidad, Precio_Envio, Precio_Total) VALUES (?, ?, ?, ?, ?)");
			st.setString(2, t.getCliente().getNif());
			st.setString(3,  t.getArticulo().getCodigo());
			st.setInt(4, t.getCantidad());
			st.setDouble(5, t.getPrecioEnvio());
			st.setDouble(6, t.getPrecioTotal());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
	}

	@Override
	public void delete(Pedido t) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("DELETE * FROM pedido WHERE Num_Pedido = ?");
			st.setString(1, t.getNumPedido());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}	
	}

	@Override
	public void update(Pedido t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pedido get(String id) throws Exception {
		Pedido pedido = new Pedido();
		DAOClienteImpl daoCliente = new DAOClienteEstandarImpl();
		DAOArticuloImpl daoArticulo = new DAOArticuloImpl();
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM pedido WHERE Codigo_pedido = ?");
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			pedido.setNumPedido(Integer.toString(rs.getInt(1)));
			String nif = rs.getString(2);
			String codigoArt = rs.getString(3);
			pedido.setCantidad(rs.getInt(4));
			pedido.setFecha(rs.getString(5));
			pedido.setPrecioEnvio(rs.getDouble(6));
			pedido.setPrecioTotal(rs.getDouble(7));
			
			Cliente cliente = daoCliente.get(nif);
			pedido.setCliente(cliente);
			Articulo articulo = daoArticulo.get(codigoArt);
			pedido.setArticulo(articulo);
			
			return pedido;
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
	}
}
