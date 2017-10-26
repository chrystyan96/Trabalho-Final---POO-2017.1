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


import dominio.Fracionadas;
import dominio.Localidade;
import dominio.Rotas;

public class ConsultaDAOSQL extends GenericDAOSQL implements IConsultaRotas{
	
  	
    private static final String SELECT_ORIGENS = "select distinct origem from ROTA order by origem";

    private static final String SELECT_DESTINOS = "select distinct destino from ROTA order by destino";	
    
    
    
    private List<String> listOrigens = new ArrayList<>();
    private List<String> listDestinos = new ArrayList<>();
    
    
    private Connection conn = this.getConnection();
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
    
    
}
