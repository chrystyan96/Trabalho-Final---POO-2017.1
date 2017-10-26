package GUI;

import java.util.List;

public interface IConsultaRotas {

	public abstract List<String> listarOrigens()throws Exception;
	public abstract List<String> listarDestinos()throws Exception;
	
}
