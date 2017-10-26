package GUI;

import java.sql.SQLException;

import dominio.Rotas;

public interface IInserirRotas {

	public abstract void InserirRota(Rotas rota) throws SQLException;
	public abstract void InserirCaminho(Rotas pai, Rotas filho) throws SQLException;
	
}
