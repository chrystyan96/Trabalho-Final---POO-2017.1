package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import GUI.IConfirmarViagem;
import dominio.Diretas;
import dominio.Rotas;
import exception.RotaNaoEncontradaException;

public class ViagemDAOSQL extends GenericDAO implements IConfirmarViagem {

	private static final String SELECT_ROTAS = "select nome, tempoDias, custoGrama, capacidadeTotal" + "from ROTA"
											 + "where origem = '?' and destino = '?'";

	private Connection conn = this.getConnection();
	
	private List<Rotas> listRotas = new ArrayList<>();

	@Override
	public boolean confirmarViagem(String origem, String destino) throws SQLException, RotaNaoEncontradaException {
		Rotas rota = null;
		try {
			PreparedStatement stmt = conn.prepareStatement(ViagemDAOSQL.SELECT_ROTAS);
			stmt.setString(1, origem);
			stmt.setString(2, destino);
			ResultSet rSet = stmt.executeQuery();
			while(rSet.next()) {
				rota = new Diretas(rSet.getString("id_rota"), rSet.getString("nome"), rSet.getInt("tempoDias"), 
								   rSet.getDouble("custoGrama"), rSet.getDouble("capacidadeTotal"), origem, destino);
				this.listRotas.add(rota);
			}
		} catch (SQLException e) {
			throw new RotaNaoEncontradaException();
		}
		return this.listRotas.size() > 0;
	}

	@Override
	public List<String> exibirRotas(double peso) throws SQLException, RotaNaoEncontradaException {
		List<String> lista = new ArrayList<>();
		
		for (int i = 0; i < this.listRotas.size(); i++) {
			if(this.listRotas.get(i).verificarPeso(peso))
				lista.add(this.listRotas.get(i).toString());
		}
		return lista;
	}

}
