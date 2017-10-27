package persistencia;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import dominio.LerProps;

import java.sql.Connection;

public abstract class GenericDAOSQL{
	private static Properties config = new LerProps().getConfig();
	
	private static final String URI = config.getProperty("URI");
	private static final String USER = config.getProperty("LOGIN");
	private static final String PASS = config.getProperty("PASS");
	private static final String DRIVE = config.getProperty("DRIVE");
	
	
	private static Connection conn = null;
	
	protected static Connection getConnection(){
		try {
			if(conn != null) {
				System.out.println("Conectado");
				return conn;
			}
			//DriverManager.registerDriver(new org.postgresql.Driver());
			Class.forName(DRIVE);
			conn = DriverManager.getConnection(GenericDAOSQL.URI,
			 								        GenericDAOSQL.USER,
											        GenericDAOSQL.PASS);
			System.out.println("Conexão iniciada com sucesso...");
			return conn;
        } catch (SQLException e) {
        	System.out.println("Erro ao iniciar a conexão...");
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}