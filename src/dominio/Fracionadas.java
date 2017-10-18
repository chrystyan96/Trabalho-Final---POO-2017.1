package dominio;

import interfaceUI.IRotas;

import java.util.ArrayList;

public class Fracionadas extends Rotas implements IRotas{

	private Diretas rotaPrincipal;
	private ArrayList<Rotas> rotas;
	
	public Fracionadas(String id, Localidade origem, Localidade destino, Diretas rotaPrincipal) {
		super(id, origem, destino);
		this.setRotaPrincipal(rotaPrincipal);
		this.rotas = new ArrayList<Rotas>();
	}
	
	
	public void addRota(Diretas rota) {
		this.rotas.add(rota);
	}
	
	//public String origemCaminho() {
		// to do
	//}
	
	@Override
	public double capacidadeTrasnporte() {
		double menorCusto = this.rotas.get(0).capacidadeTrasnporte();
		for(int i = 1; i < this.rotas.size(); i++){
			if(this.rotas.get(i).capacidadeTrasnporte() < menorCusto){
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
	
	@Override
	public double calcularRotas(Localidade origem, Localidade destino, double peso) {
		
		return 0;
	}


	public Diretas getRotaPrincipal() {
		return this.rotaPrincipal;
	}


	public void setRotaPrincipal(Diretas rotaPrincipal) {
		this.rotaPrincipal = rotaPrincipal;
	}
	
}
