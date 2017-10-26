package dominio;

public class Diretas extends Rotas{

	
	public Diretas(String id, String nome, int tempoEntrega,  double custoGrama,
			 	   double capacidadeTotal, String origem, String destino) {
		super(id, nome, tempoEntrega, custoGrama, capacidadeTotal, origem, destino);
	}
	
	@Override
	public double capacidadeTrasnporte() {
		return this.getCapacidadeTotal();
	}
	
	@Override
	public double custoRota() {
		return this.capacidadeTrasnporte() * super.getCustoGrama();
	}
	
	@Override
	public int tempoEntrega() {
		return this.getTempoEntrega();
	}	
	
	public String getOrigem() {
		return super.getOrigem();
	}
	
	public String getDestino() {
		return super.getDestino();
	}
	
	public String toString() {
		return super.getId();
	}
	
}
