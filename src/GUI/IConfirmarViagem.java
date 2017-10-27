package GUI;

import java.sql.SQLException;
import java.util.List;

import exception.RotaNaoEncontradaException;

public interface IConfirmarViagem {

	public abstract boolean confirmarViagem(String origem, String destino) throws SQLException, RotaNaoEncontradaException;
	public abstract List<String> exibirRotas(double peso) throws SQLException, RotaNaoEncontradaException;
	
}
