package persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;

public abstract class GenericDAO{
	private static final String URI = "jdbc:mysql://localhost/rotas";
	private static final String USER = "root";
	private static final String PASS = "";
	
	private Connection conn = null;
	
	protected Connection getConnection() {
        try {
        	if(this.conn != null)
        		return this.conn;
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            this.conn = DriverManager.getConnection(GenericDAO.URI, GenericDAO.USER, GenericDAO.PASS);
            return this.conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}