package grupodamers.modelo.dao;

import java.sql.*;

public class Conexion {
	
	protected Connection conexion;
	
	// Datos conexion base datos
	private final String JDBC_Driver ="";
	private final String DB_URL="";
	
	// Credenciales acceso
	private final String user="root";
	private final String password="root";
	
	public void conectar() throws Exception {
		try {
			conexion = DriverManager.getConnection(DB_URL, user, password);
			Class.forName(JDBC_Driver);
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
