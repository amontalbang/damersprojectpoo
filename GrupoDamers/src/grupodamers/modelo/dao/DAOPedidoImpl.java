package grupodamers.modelo.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import grupodamers.modelo.Cliente;
import grupodamers.modelo.Pedido;
import grupodamers.modelo.factory.DAOFactory;
import grupodamers.modelo.Articulo;
import grupodamers.modelo.interfaces.DAO;

public class DAOPedidoImpl extends Conexion implements DAO<Pedido>{

	public DAOPedidoImpl() {
	}

	@Override
	public int getTotalCount() throws Exception {
		try {
			this.conectar();
			CallableStatement st = this.conexion.prepareCall("{call get_count_pedido()}");
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
		DAOClienteImpl daoCliente = DAOFactory.getClienteEstandar();
		DAOArticuloImpl daoArticulo = DAOFactory.getArticulo();
		try {
			this.conectar();
			CallableStatement st = this.conexion.prepareCall("{ call show_pedidos() }");
			ResultSet rs = st.executeQuery();
			while(rs.next()) {
				Pedido pedido = new Pedido();
				pedido.setNumPedido(Integer.toString(rs.getInt(1)));
				String nif = rs.getString(2);
				String codigoArt = rs.getString(3);
				pedido.setCantidad(rs.getInt(4));
				pedido.setFecha(rs.getString(5));
				Cliente cliente = daoCliente.get(nif);
				pedido.setCliente(cliente);
				Articulo articulo = daoArticulo.get(codigoArt);
				pedido.setArticulo(articulo);
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
			CallableStatement st = this.conexion.prepareCall("{ call add_pedido(?,?,?,?,?,?) }");
			st.setString(1, t.getCliente().getNif());
			st.setString(2,  t.getArticulo().getCodigo());
			st.setInt(3, t.getCantidad());
			st.setString(4, t.getFecha());
			st.setDouble(5, t.precioEnvio());
			st.setDouble(6, t.precioTotal());
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
			CallableStatement st = this.conexion.prepareCall("{ call delete_pedido(?) }");
			st.setString(1, t.getNumPedido());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}	
	}

	@Override
	public Pedido get(String id) throws Exception {
		Pedido pedido = new Pedido();
		DAOClienteImpl daoCliente = new DAOClienteEstandarImpl();
		DAOArticuloImpl daoArticulo = new DAOArticuloImpl();
		try {
			this.conectar();
			CallableStatement st = this.conexion.prepareCall("{ call get_pedido(?) }");
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			if(rs.next()) {
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
			} else {
				return null;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.desconectar();
		}
	}
}
