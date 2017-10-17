package dominio;

import interfaceUI.IRotas;

public class Fracionadas extends Rotas implements IRotas{

	private Rotas[] rotas;
	private Fracionadas[] caminhos;	
	
	public Fracionadas(String id, Localidade origem, Localidade destino) {
		super(id, origem, destino);
		this.rotas = new Rotas[0];
		this.caminhos = new Fracionadas[0];
	}
	
	
	public void addRota(Diretas rota) {
		Rotas[] novo = new Rotas[this.rotas.length + 1];
		for (int i = 0; i < this.rotas.length; i++) {
			novo[i] = this.rotas[i];
		}
		novo[novo.length - 1] = rota;
		this.rotas = novo;
	}
	
	//public String origemCaminho() {
		// to do
	//}
	
	@Override
	public double capacidadeTrasnporte() {
		double menorCusto = this.rotas[0].capacidadeTrasnporte();
		for (Rotas atual : this.rotas) {
			if(atual.capacidadeTrasnporte() < menorCusto) {
				menorCusto = atual.capacidadeTrasnporte();
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
		return tempo + this.rotas.length - 1;
	}
	
	public void addCaminho(Fracionadas caminho){
		Fracionadas[] novo = new Fracionadas[this.caminhos.length + 1];
		for (int i = 0; i < this.caminhos.length; i++) {
			novo[i]= this.caminhos[i];
		}
		novo[novo.length - 1] = caminho;
		this.caminhos = novo;
	}
	
	
	
	@Override
	public double calcularRotas(Localidade origem, Localidade destino, double peso) {
		
		return 0;
	}
	
}
