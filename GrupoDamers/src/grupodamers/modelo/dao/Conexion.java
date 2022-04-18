package grupodamers.modelo.dao;

import java.sql.*;

public class Conexion {
	
	protected Connection conexion = null;
	private final String DB_URL="jdbc:mysql://localhost:3306/onlinestore";
	
	// Credenciales acceso
	private final String user="root";
	private final String password="root";
	
	/**
	 * Metodo que permite establecer la conexion con la base de datos
	 * @throws Exception
	 */
	
	public void conectar() throws Exception {
		try {
			conexion = DriverManager.getConnection(DB_URL, user, password);
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * Metodo que permite realizar la desconexion de la base de datos
	 * @throws SQLException
	 */
	
	public void desconectar() throws SQLException {
		if(conexion != null) {
			if(!conexion.isClosed()) {
				conexion.close();
			}
		}
	}

}
