package dominio;

import java.util.ArrayList;

public class Caminho {

	private ArrayList<Fracionadas> caminhos = new ArrayList<Fracionadas>();
	
	public void addCaminho(Fracionadas caminho) {
		this.caminhos.add(caminho);
	}
	/*
	public String verificaCaminhos(String origem, String destino) {
		String caminhos = "";
		for (int i = 0; i < this.caminhos.size(); i++) {
			if(this.caminhos.get(i).verificaRotas(origem, destino))
				caminhos += this.caminhos.get(i).id;
		}
		return caminhos;
		
	}
	*/
	
}
