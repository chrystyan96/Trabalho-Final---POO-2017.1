package dominio;


import java.util.ArrayList;

public class Fracionadas extends Rotas{
	
	private int id;
	private Rotas origem;
	private Rotas destino;
	
	protected ArrayList<Rotas> rotas = new ArrayList<Rotas>();
	
	public Fracionadas (int id, Rotas origem, Rotas destino) {
		this.setId(id);
		this.setRotaOrigem(origem);
		this.setRotaDestino(destino);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Rotas getRotaOrigem() {
		return this.origem;
	}

	public void setRotaOrigem(Rotas origem) {
		this.origem = origem;
	}

	public Rotas getRotaDestino() {
		return destino;
	}

	public void setRotaDestino(Rotas destino) {
		this.destino = destino;
	}

	public void addRota(Rotas rota) {
		this.rotas.add(rota);
	}

	
	
	@Override
	public double capacidadeTrasnporte() {
		//rever a documentação 
		double menorCusto = this.rotas.get(0).capacidadeTrasnporte();
		for (int i = 1; i < this.rotas.size(); i++) {
			if(this.rotas.get(i).capacidadeTrasnporte() < menorCusto) {
				menorCusto = this.rotas.get(i).capacidadeTrasnporte();
			}
		}
		return menorCusto;
	}
	
	@Override
	public double custoRota() {
		double soma = 0;
		for (Rotas atual : this.rotas) {
			soma += atual.custoRota();
		}
		return soma - ((soma/100) * 20);
	}
	
	@Override
	public int tempoEntrega() {
		int tempo = 0;
		for (Rotas atual : this.rotas) {
			tempo += atual.tempoEntrega();
		}
		return tempo + this.rotas.size() - 1;
	}
	
	/*
	public String getOrigemRota() {
		return this.rotas.get(0).origem.getNome();
	}
	
	public String getDestinoRota() {
		int tamanho = this.rotas.size() - 1;
		return this.rotas.get(tamanho).destino.getNome();
	}
	*/
	
	/*
	public boolean verificaRotas(String origem, String destino) {
		if(origem == this.getOrigemRota()) {
			if(destino == this.getDestinoRota())
				return true;
		}
		return false;
	}
	
	public String mostrarRotas(String origem, String destino) {
		if(origem == this.getOrigemRota()) {
			if(destino == this.getDestinoRota())
				return this.rotas.get(0).toString();
		} 
		return null;
	}*/

	
	public String toString() {
		return super.getIdFracionadas();
	}
}
