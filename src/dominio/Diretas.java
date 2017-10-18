package dominio;

public class Diretas extends Rotas{

	private Localidade origem;
	private Localidade destino;
	
	public Diretas(String id, int tempoEntrega, Localidade origem, Localidade destino, double capacidadeAlocada,
			 	   double capacidadeTotal, double custoGrama ) {
		super(id, tempoEntrega, origem, destino, capacidadeAlocada, capacidadeTotal, custoGrama);
	}
	
	public Diretas() {
		super();
	}
	
	@Override
	public double capacidadeTrasnporte() {
		return this.getCapacidadeTotal() - this.getCapacidadeAlocada();
	}
	
	@Override
	public double custoRota() {
		return this.capacidadeTrasnporte() * super.getCustoGrama();
	}
	
	@Override
	public int tempoEntrega() {
		return this.getTempoEntrega();
	}

	public String origemRota() {
		return origem.toString();
	}

	public String destinoRota() {
		return destino.toString();
	}
	
	
	
	
}
