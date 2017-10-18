package dominio;

public class Main {

	static Localidade l1 = new Localidade("t01", "Maceió");
	static Localidade l2 = new Localidade("t02", "Rondônia");
	static Localidade l3 = new Localidade("t03", "Rondônia");
	static Localidade l4 = new Localidade("t04", "Maranhão");
	
	static Diretas d1 = new Diretas("e200", 3, l1, l2, 10.0, 20.0, 0.15);
	static Diretas d2 = new Diretas("e201", 2, l3, l4, 15.0, 25.0, 0.30);
	static Diretas d3 = new Diretas("e202", 1, l4, l1, 17.0, 21.0, 0.50);
	
	static Fracionadas f1 = new Fracionadas("e300", l1, l4, d3);
	
	
	public static void main(String[] args) {
		f1.addRota(d1);
		f1.addRota(d2);
		
		System.out.println(f1.tempoEntrega());
		System.out.println(f1.capacidadeTrasnporte());
		System.out.println(f1.custoRota());
		
		//System.out.println(f1.getOrigemRota());
	}

}
