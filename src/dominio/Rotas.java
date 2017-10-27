package dominio;


public abstract class Rotas {

	protected String id;
	protected String nome;
	protected String idFracionadas;
	protected int tempoEntrega;
	protected String origem;
	protected String destino;
	protected double capacidadeTotal;
	protected double custoGrama;
	
	public abstract double capacidadeTrasnporte();
	public abstract double custoRota();
	public abstract int tempoEntrega();
	
	
	public Rotas(String id, String nome, int tempoEntrega, double custoGrama,
				 double capacidadeTotal, String origem, String destino) {
		this.setId(id);
		this.setTempoEntrega(tempoEntrega);
		this.setCustoGrama(custoGrama);
		this.setCapacidadeTotal(capacidadeTotal);
		this.setOrigem(origem);
		this.setDestino(destino);
	}
	
	public Rotas() {}
	
	public boolean verificarPeso(double peso) {
		return peso < this.capacidadeTrasnporte();
	}
	
	public String toString(double peso) {
		return this.getNome() + " - " + this.tempoEntrega() + " dias - R$ " + this.calcularCustoPeso(peso);
	}
	
	public double calcularCustoPeso(double peso) {
		return peso * this.getCustoGrama();
	}
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdFracionadas() {
		return this.idFracionadas;
	}
	
	public void setIdFracionadas(String id) {
		this.idFracionadas = id;
	}
	
	public int getTempoEntrega() {
		return tempoEntrega;
	}
	public void setTempoEntrega(int tempoEntrega) {
		this.tempoEntrega = tempoEntrega;
	}

	public double getCapacidadeTotal() {
		return capacidadeTotal;
	}
	public void setCapacidadeTotal(double capacidadeTotal) {
		this.capacidadeTotal = capacidadeTotal;
	}
	public double getCustoGrama() {
		return custoGrama;
	}
	public void setCustoGrama(double custoGrama) {
		this.custoGrama = custoGrama;
	}
	
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	public String getOrigem() {
		return origem;
	}
	
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public String getDestino() {
		return destino;
	}
	
	
}
