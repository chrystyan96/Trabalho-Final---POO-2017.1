package persistencia;

import java.util.ArrayList;
import java.util.Properties;

import dominio.LerProps;

public class DadosSQL {
	private static Properties dados = new LerProps().getDados();
	
	//array rotas
	ArrayList<String> nomeRotas = new ArrayList<String>();
	ArrayList<Integer> tempoRotas = new ArrayList<Integer>();
	ArrayList<Double> custoRotas = new ArrayList<Double>();
	ArrayList<Double> capacidadeRotas = new ArrayList<Double>();
	ArrayList<String> origemRotas = new ArrayList<String>();
	ArrayList<String> destinoRotas = new ArrayList<String>();
	
	//retorno das rotas
	public ArrayList<String> getNomeRotas(){
		this.nomeRotas.add(dados.getProperty("d1"));
		this.nomeRotas.add(dados.getProperty("d2"));
		this.nomeRotas.add(dados.getProperty("d3"));
		this.nomeRotas.add(dados.getProperty("d4"));
		this.nomeRotas.add(dados.getProperty("d5"));
		this.nomeRotas.add(dados.getProperty("d6"));
		this.nomeRotas.add(dados.getProperty("d7"));
		this.nomeRotas.add(dados.getProperty("d8"));
		this.nomeRotas.add(dados.getProperty("d9"));
		this.nomeRotas.add(dados.getProperty("d10"));
		this.nomeRotas.add(dados.getProperty("d11"));
		this.nomeRotas.add(dados.getProperty("d12"));
		return this.nomeRotas;
	}
	
	public ArrayList<Integer> getTempoRotas(){
		this.tempoRotas.add(Integer.parseInt(dados.getProperty("t1")));
		this.tempoRotas.add(Integer.parseInt(dados.getProperty("t2")));
		this.tempoRotas.add(Integer.parseInt(dados.getProperty("t3")));
		this.tempoRotas.add(Integer.parseInt(dados.getProperty("t4")));
		this.tempoRotas.add(Integer.parseInt(dados.getProperty("t5")));
		this.tempoRotas.add(Integer.parseInt(dados.getProperty("t6")));
		this.tempoRotas.add(Integer.parseInt(dados.getProperty("t7")));
		this.tempoRotas.add(Integer.parseInt(dados.getProperty("t8")));
		this.tempoRotas.add(Integer.parseInt(dados.getProperty("t9")));
		this.tempoRotas.add(Integer.parseInt(dados.getProperty("t10")));
		this.tempoRotas.add(Integer.parseInt(dados.getProperty("t11")));
		this.tempoRotas.add(Integer.parseInt(dados.getProperty("t12")));
		return this.tempoRotas;
	}
	
	public ArrayList<Double> getCustoRotas(){
		this.custoRotas.add(Double.parseDouble(dados.getProperty("c1")));
		this.custoRotas.add(Double.parseDouble(dados.getProperty("c2")));
		this.custoRotas.add(Double.parseDouble(dados.getProperty("c3")));
		this.custoRotas.add(Double.parseDouble(dados.getProperty("c4")));
		this.custoRotas.add(Double.parseDouble(dados.getProperty("c5")));
		this.custoRotas.add(Double.parseDouble(dados.getProperty("c6")));
		this.custoRotas.add(Double.parseDouble(dados.getProperty("c7")));
		this.custoRotas.add(Double.parseDouble(dados.getProperty("c8")));
		this.custoRotas.add(Double.parseDouble(dados.getProperty("c9")));
		this.custoRotas.add(Double.parseDouble(dados.getProperty("c10")));
		this.custoRotas.add(Double.parseDouble(dados.getProperty("c11")));
		this.custoRotas.add(Double.parseDouble(dados.getProperty("c12")));
		return this.custoRotas;
	}
	
	public ArrayList<Double> getCapacidadeRotas(){
		this.capacidadeRotas.add(Double.parseDouble(dados.getProperty("ct1")));
		this.capacidadeRotas.add(Double.parseDouble(dados.getProperty("ct2")));
		this.capacidadeRotas.add(Double.parseDouble(dados.getProperty("ct3")));
		this.capacidadeRotas.add(Double.parseDouble(dados.getProperty("ct4")));
		this.capacidadeRotas.add(Double.parseDouble(dados.getProperty("ct5")));
		this.capacidadeRotas.add(Double.parseDouble(dados.getProperty("ct6")));
		this.capacidadeRotas.add(Double.parseDouble(dados.getProperty("ct7")));
		this.capacidadeRotas.add(Double.parseDouble(dados.getProperty("ct8")));
		this.capacidadeRotas.add(Double.parseDouble(dados.getProperty("ct9")));
		this.capacidadeRotas.add(Double.parseDouble(dados.getProperty("ct10")));
		this.capacidadeRotas.add(Double.parseDouble(dados.getProperty("ct11")));
		this.capacidadeRotas.add(Double.parseDouble(dados.getProperty("ct12")));
		return this.capacidadeRotas;
	}
	
	public ArrayList<String> getOrigemRotas(){
		this.origemRotas.add(dados.getProperty("or1"));
		this.origemRotas.add(dados.getProperty("or2"));
		this.origemRotas.add(dados.getProperty("or3"));
		this.origemRotas.add(dados.getProperty("or4"));
		this.origemRotas.add(dados.getProperty("or5"));
		this.origemRotas.add(dados.getProperty("or6"));
		this.origemRotas.add(dados.getProperty("or7"));
		this.origemRotas.add(dados.getProperty("or8"));
		this.origemRotas.add(dados.getProperty("or9"));
		this.origemRotas.add(dados.getProperty("or10"));
		this.origemRotas.add(dados.getProperty("or11"));
		this.origemRotas.add(dados.getProperty("or12"));
		return this.origemRotas;
	}
		
	public ArrayList<String> getDestinoRotas(){
		this.destinoRotas.add(dados.getProperty("de1"));
		this.destinoRotas.add(dados.getProperty("de2"));
		this.destinoRotas.add(dados.getProperty("de3"));
		this.destinoRotas.add(dados.getProperty("de4"));
		this.destinoRotas.add(dados.getProperty("de5"));
		this.destinoRotas.add(dados.getProperty("de6"));
		this.destinoRotas.add(dados.getProperty("de7"));
		this.destinoRotas.add(dados.getProperty("de8"));
		this.destinoRotas.add(dados.getProperty("de9"));
		this.destinoRotas.add(dados.getProperty("de10"));
		this.destinoRotas.add(dados.getProperty("de11"));
		this.destinoRotas.add(dados.getProperty("de12"));
		return this.destinoRotas;
	}
	
	//array caminhos
	ArrayList<Integer> paiCaminhos = new ArrayList<Integer>();
	ArrayList<Integer> filhoCaminhos = new ArrayList<Integer>();
	
	public ArrayList<Integer> getPaiCaminhos(){
		this.paiCaminhos.add(Integer.parseInt(dados.getProperty("p1")));
		this.paiCaminhos.add(Integer.parseInt(dados.getProperty("p2")));
		this.paiCaminhos.add(Integer.parseInt(dados.getProperty("p3")));
		this.paiCaminhos.add(Integer.parseInt(dados.getProperty("p4")));
		this.paiCaminhos.add(Integer.parseInt(dados.getProperty("p5")));
		return this.paiCaminhos;
	}
	
	public ArrayList<Integer> getFilhoCaminhos(){
		this.filhoCaminhos.add(Integer.parseInt(dados.getProperty("f1")));
		this.filhoCaminhos.add(Integer.parseInt(dados.getProperty("f2")));
		this.filhoCaminhos.add(Integer.parseInt(dados.getProperty("f3")));
		this.filhoCaminhos.add(Integer.parseInt(dados.getProperty("f4")));
		this.filhoCaminhos.add(Integer.parseInt(dados.getProperty("f5")));
		return this.filhoCaminhos;
	}
}
