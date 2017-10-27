package persistencia;

import java.sql.DriverManager;

//import dominio.LerProps;

import java.sql.SQLException;
//import java.util.Properties;
import java.sql.Connection;

public abstract class GenericDAO{
	/*
	static Properties config = new LerProps().getConfig();
	
	private static final String URI = config.getProperty("config.config.URI");
	private static final String USER = config.getProperty("config.config.LOGIN");
	private static final String PASS = config.getProperty("config.config.PASS");
	*/
	
	private static final String URI = "jdbc:postgresql://localhost:5432/trabPoo2017";
	private static final String USER = "postgres";	
	private static final String PASS = "1234";
	
	private Connection conn = null;
	
	protected  Connection getConnection() {
        try {
        	if(this.conn != null)
        		return this.conn;
            DriverManager.registerDriver(new org.postgresql.Driver());
            this.conn = DriverManager.getConnection(GenericDAO.URI, GenericDAO.USER, GenericDAO.PASS);
            return this.conn;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}