package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;
import java.util.ArrayList;


import dominio.Fracionadas;
import dominio.Localidade;
import dominio.Rotas;

public class ConsultaDAOSQL extends GenericDAOSQL{

    private static final String INSERT_ROTA = "INSERT INTO ROTA (id_rota, tempoDias, custoGrama, capacidadeTotal,"
                                                                +" origem, destino)"
                                                                +" values (?, ?, ?, ?, ?, ?, ?); ";
    
    private static final String INSERT_LOCALIDADE = "INSERT INTO Localidade (idLocalidade, nome) values (?, ?) ";
    
    private static final String INSERT_FRACIONADAS = "INSERT INTO Fracionadas (id_fracionada, id_origem, id_destino)"
                                                    + " values (?, ?, ?) ";
  
    private static final String SELECT_ROTAS_ORIGEM = "SELECT r.origem "
                                                    +" FROM Rota r inner join Localidade l "
                                                    +" ON(r.id_local = l.id_local)";

    private static final String SELECT_ROTAS_DESTINO = "SELECT r.destino "
                                                     +" FROM Rota r inner join Localidade l "
                                                     +" ON(r.id_local = l.id_local)";	
    
    
    private static final String SELECT_LOCALIDADES = "SELECT * FROM localidade";
    private static final String SELECT_TODAS_ROTAS = "SELECT * FROM Diretas";
    
    
    private Connection conn = this.getConnection();
    //private DadosSQL dados = new DadosSQL();
    
    public void insertLocal(Localidade local){
    	try {
    		//ArrayList dadosSQL = this.dados.addValuesLocalidade(local);
			PreparedStatement stmt = conn.prepareStatement(INSERT_LOCALIDADE);
			stmt.setString(1, local.getId());  
			stmt.setString(2, local.getNome());    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void insertRota(Rotas rota){
    	try {
    		//ArrayList dadosSQL = this.dados.addValuesRotas(rota);
			PreparedStatement stmt = conn.prepareStatement(INSERT_ROTA);
			stmt.setString(1, rota.getId());  
			stmt.setInt(2, rota.getTempoEntrega());
			stmt.setDouble(3, rota.getCustoGrama());
			stmt.setDouble(4, rota.getCapacidadeTotal());
            stmt.setString(5, rota.getOrigem());  
            stmt.setString(6, rota.getDestino());              
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void insertFracionada(Fracionadas frac){
    	try {
    		//ArrayList dadosSQL = this.dados.addValuesFracionadas(frac);
			PreparedStatement stmt = conn.prepareStatement(INSERT_FRACIONADAS);
			stmt.setString(1, frac.getId());  
			stmt.setString(2, frac.getRotaOrigem().getId());
			stmt.setString(3, frac.getRotaDestino().getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    /*
    public List<String> getRotaOrigem(){
    public void getRotaOrigem(){

    	ArrayList rotaOrigem = new ArrayList();
    	try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_ROTAS_ORIGEM);
			rotaOrigem.add(stmt.getInt("id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    } */
    
    List<String> listOrigem = new ArrayList<>();
    public List<String> getRotaOrigem(){
    	try {
	    	PreparedStatement stmt = conn.prepareStatement(SELECT_ROTAS_ORIGEM);
	    	ResultSet rSet = stmt.executeQuery();
	    	while(rSet.next()) {
	    		String localOrigem = rSet.getString("r.origem");
	    		this.listOrigem.add(localOrigem);
	    	}
	    	rSet.close();
	    	stmt.close();
    	} catch (SQLException e){
    		e.printStackTrace();
    	}
    	return this.listOrigem;

    }
    
    public List<String> getLocalidades(){
    	try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_LOCALIDADES);
			ResultSet rSet = stmt.executeQuery();
			while(rSet.next()) {
				String localidades = rSet.getString("nome");
				this.listOrigem.add(localidades);
			}
			rSet.close();
	    	stmt.close();
		} catch (SQLException e) {
			e.getMessage();
		}
    	return listOrigem;
    }
    
    private List<String> listDiretas = new ArrayList<>();
    public List<String> getDiretas(){
    	try {
			PreparedStatement stmt = conn.prepareStatement(SELECT_TODAS_ROTAS);
			ResultSet rSet = stmt.executeQuery();
			while(rSet.next()) {
				String localidades = rSet.getString("idDiretas");
				this.listDiretas.add(localidades);
			}
			rSet.close();
	    	stmt.close();
		} catch (SQLException e) {
			e.getMessage();
		}
    	return listDiretas;
    }
}
