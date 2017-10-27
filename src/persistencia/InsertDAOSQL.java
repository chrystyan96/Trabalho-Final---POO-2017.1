package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import GUI.IInserirRotas;
import dominio.Fracionadas;
import dominio.Rotas;

public class InsertDAOSQL extends GenericDAOSQL implements IInserirRotas{

	private static final String INSERT_ROTA = "insert into Rota (nome, tempoDias, custoGrama, capacidadeTotal, origem, destino)" + 
			  "values (?, ?, ?, ?, ?, ?)";

	private static final String INSERT_CAMINHO = "insert into Caminho (id_rotaPai, id_rotaFilho)" + 
			 "values (?, ?)";
	
	//popular tabela rotas
	ArrayList<String> nomeRotas = new DadosSQL().getNomeRotas();
	ArrayList<Integer> tempoRotas = new DadosSQL().getTempoRotas();
	ArrayList<Double> custoRotas = new DadosSQL().getCustoRotas();
	ArrayList<Double> capacidadeRotas = new DadosSQL().getCapacidadeRotas();
	ArrayList<String> origemRotas = new DadosSQL().getOrigemRotas();
	ArrayList<String> destinoRotas = new DadosSQL().getDestinoRotas();
	
	private Connection conn = getConnection();
	
	@Override
	public void InserirRota() throws SQLException{
		PreparedStatement stmt = conn.prepareStatement(InsertDAOSQL.INSERT_ROTA);
		conn.setAutoCommit(false);
		try {
			for(int i = 0; i < this.nomeRotas.size(); i++){
				stmt.setString(1, this.nomeRotas.get(i));
				stmt.setInt(2, this.tempoRotas.get(i));
				stmt.setDouble(3, this.custoRotas.get(i));
				stmt.setDouble(4, this.capacidadeRotas.get(i));
				stmt.setString(5, this.origemRotas.get(i));
				stmt.setString(6, this.destinoRotas.get(i));
				stmt.addBatch();
			}
			int[] result = stmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		}finally{
		    closeConnection(conn, stmt, null);
		}
	}

	//popular tabela caminho
	ArrayList<Integer> paiCaminhos = new DadosSQL().getPaiCaminhos();
	ArrayList<Integer> filhoCaminhos = new DadosSQL().getFilhoCaminhos();

	@Override
	public void InserirCaminho() throws SQLException{
		PreparedStatement stmt = conn.prepareStatement(InsertDAOSQL.INSERT_CAMINHO);
		conn.setAutoCommit(false);
		try {
			for(int i = 0; i < this.paiCaminhos.size(); i++){
				stmt.setInt(1, this.paiCaminhos.get(i));
				stmt.setInt(2, this.filhoCaminhos.get(i));
				stmt.addBatch();
			}
			int[] result = stmt.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			conn.rollback();
		}finally{
		    closeConnection(conn, stmt, null);
		}
	}			
}
