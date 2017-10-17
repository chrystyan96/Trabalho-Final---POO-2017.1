package interfaceUI;

import dominio.Localidade;

public interface IRotas {

	public abstract double calcularRotas(Localidade origem, Localidade destino, double peso);
	
}
