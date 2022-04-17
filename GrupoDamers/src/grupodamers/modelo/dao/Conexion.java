package grupodamers.modelo.dao;

import java.sql.*;

public class Conexion {
	
	protected Connection conexion = null;
	
	// Datos conexion base datos
	// private final String JDBC_Driver ="com.mysql.cj.jdbc.Driver";
	private final String DB_URL="jdbc:mysql://localhost:3306/onlinestore";
	
	// Credenciales acceso
	private final String user="root";
	private final String password="root";
	
	public void conectar() throws Exception {
		try {
			// Class.forName(JDBC_Driver);
			conexion = DriverManager.getConnection(DB_URL, user, password);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void desconectar() throws SQLException {
		if(conexion != null) {
			if(!conexion.isClosed()) {
				conexion.close();
			}
		}
	}

}
