package GUI;

import java.sql.SQLException;

import dominio.Fracionadas;
import dominio.Rotas;

public interface IInserirRotas {

	public abstract void InserirRota(Rotas rota) throws SQLException;
	public abstract void InserirCaminho(Fracionadas fracionada) throws SQLException;
	
}
