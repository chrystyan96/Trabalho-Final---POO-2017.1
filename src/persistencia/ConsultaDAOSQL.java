package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import GUI.IConsultaRotas;

import java.sql.SQLException;
import java.util.ArrayList;


//import dominio.Rotas;

public class ConsultaDAOSQL extends GenericDAOSQL implements IConsultaRotas{
	
  	
	private static final String SELECT_ORIGENS = "select distinct origem from ROTA order by origem";

    private static final String SELECT_DESTINOS = "select distinct destino from ROTA order by destino";	
    
    private static final String SELECT_ROTAS =  "select nome, tempoDias, custoGrama, capacidadeTotal from ROTA where origem = ? and destino = ?";
    
    
    private List<String> listOrigens = new ArrayList<>();
    private List<String> listDestinos = new ArrayList<>();
    private List<String> listRotas = new ArrayList<>();
    
    private Connection conn = getConnection();
    //private DadosSQL dados = new DadosSQL();
    


	@Override
	public List<String> listarOrigens() throws Exception {
		try {
	    	PreparedStatement stmt = conn.prepareStatement(SELECT_ORIGENS);
	    	ResultSet rSet = stmt.executeQuery();
	    	while(rSet.next()) {
	    		String localOrigem = rSet.getString("origem");
	    		this.listOrigens.add(localOrigem);
	    	}
	    	rSet.close();
	    	stmt.close();
    	} catch (SQLException e){
    		e.getMessage();
    	}
    	return this.listOrigens;
	}

	@Override
	public List<String> listarDestinos() throws Exception {
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_DESTINOS);
			ResultSet rSet = stmt.executeQuery();
			while(rSet.next()) {
				String localDestino = rSet.getString("destino");
				this.listDestinos.add(localDestino);
			}
			rSet.close();
	    	stmt.close();
		} catch (SQLException e) {
			e.getMessage();
		}
    	return listDestinos;
	}
	
	public List<String> mostrarCaminhos(String origem, String destino) throws Exception{
		try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_ROTAS);
			stmt.setString(1, origem);
			stmt.setString(2, destino);
			ResultSet rSet = stmt.executeQuery();
			while(rSet.next()) {
				String rotas = rSet.getString("nome") + (" - Dias ") + rSet.getString("tempoDias") + (" - Custo - ") + 
							   rSet.getString("custoGrama") + (" - Capacidade ") + rSet.getString("capacidadeTotal") + "\n";
				this.listRotas.add(rotas);
			}
			rSet.close();
	    	stmt.close();
		} catch (SQLException e) {
			e.getMessage();
		}
    	return listRotas;
	}
}
