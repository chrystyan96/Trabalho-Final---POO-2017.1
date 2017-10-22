package persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.Connection;

public abstract class GenericDAOSQL{
	private static final String URI = "jdbc:postgresql://localhost:5432/postgres";
	private static final String USER = "trabPoo2017";	
	private static final String PWD = "1234";
	
	private Connection conn = null;
	
	public Connection getConnection(){
		try {
			if(this.conn != null)
				return this.conn;
			DriverManager.registerDriver(new org.postgresql.Driver());
			this.conn = DriverManager.getConnection(GenericDAOSQL.URI,
			 								        GenericDAOSQL.USER,
											        GenericDAOSQL.PWD);
			System.out.println("Conexão iniciada com sucesso...");
			return this.conn;
        } catch (SQLException e) {
        	System.out.println("Erro ao iniciar a conexão...");
            throw new RuntimeException(e);
        }
	}
}