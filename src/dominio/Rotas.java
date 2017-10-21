package dominio;


public abstract class Rotas {

	protected String id;
	protected String idFracionadas;
	protected int tempoEntrega;
	protected Localidade origem;
	protected Localidade destino;
	protected double capacidadeAlocada;
	protected double capacidadeTotal;
	protected double custoGrama;
	
	public abstract double capacidadeTrasnporte();
	public abstract double custoRota();
	public abstract int tempoEntrega();
	
	
	public Rotas(String id, int tempoEntrega, Localidade origem, Localidade destino, double capacidadeAlocada,
				 double capacidadeTotal, double custoGrama) {
		this.setId(id);
		this.setTempoEntrega(tempoEntrega);
		this.setCapacidadeAlocada(capacidadeAlocada);
		this.setCapacidadeTotal(capacidadeTotal);
		this.setCustoGrama(custoGrama);
		this.setOrigem(origem);
		this.setDestino(destino);
	}
	
	public Rotas() {}

	
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
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
	public double getCapacidadeAlocada() {
		return capacidadeAlocada;
	}
	public void setCapacidadeAlocada(double capacidadeAlocada) {
		this.capacidadeAlocada = capacidadeAlocada;
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
	
	public void setOrigem(Localidade origem) {
		this.origem = origem;
	}
	
	public String getOrigem() {
		return origem.getId();
	}
	
	public void setDestino(Localidade destino) {
		this.destino = destino;
	}
	
	public String getDestino() {
		return destino.getId();
	}
	
	
}
