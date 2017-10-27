package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import GUI.IInserirRotas;
import dominio.Fracionadas;
import dominio.Rotas;

public class InsertDAOSQL extends GenericDAOSQL implements IInserirRotas{

	private static final String INSERT_ROTA = "insert into Rota (id_rota, nome, tempoDias, custoGrama, capacidadeTotal, origem, destino, tipo)" + 
			  								  "values (?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String INSERT_CAMINHO = "insert into Caminho (id_rotaPai, id_rotaFilho)" + 
				 								 "values (?, ?)";
	
	private static Connection conn = getConnection();
	
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
				e.printStackTrace();
			}
	    }
	
	 

	    public void insertFracionada(Fracionadas frac){
	    	try {
	    		//ArrayList dadosSQL = this.dados.addValuesFracionadas(frac);
				PreparedStatement stmt = conn.prepareStatement(INSERT_CAMINHO);
				stmt.setString(1, frac.getId());  
				stmt.setString(2, frac.getRotaOrigem().getId());
				stmt.setString(3, frac.getRotaDestino().getId());
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }



		@Override
		public void InserirRota(Rotas rota) throws SQLException {
			// TODO Auto-generated method stub
			
		}



		@Override
		public void InserirCaminho(Fracionadas fracionada) throws SQLException {
			// TODO Auto-generated method stub
			
		}
}
