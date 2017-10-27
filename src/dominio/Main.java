package dominio;

import java.sql.SQLException;
//import java.util.Properties;

import persistencia.ConsultaDAOSQL;
//import persistencia.InsertDAOSQL;

public class Main {
	
	//static Diretas rota = new Diretas(1, "R01", 3, 5.5, 80.0, "A", "B");
	
	//static InsertDAOSQL insert = new InsertDAOSQL();
	
	static ConsultaDAOSQL consulta = new ConsultaDAOSQL();
	
	public static void main(String[] args) throws Exception {
		//LerProps prop = new LerProps();
		//Properties config = new LerProps().getConfig();
		//System.out.println(config.getProperty("URI"));
		
		//insert.InserirRota(rota);
		
		System.out.println(consulta.listarOrigens());
		System.out.println(consulta.mostrarCaminhos("A", "C"));
	}

}
