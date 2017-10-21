package dominio;

public class Main {
	
	static Localidade l1 = new Localidade("t01", "A");
	static Localidade l2 = new Localidade("t02", "B");
	
	static Localidade l3 = new Localidade("t03", "C");
	static Localidade l4 = new Localidade("t04", "D");
	
	static Localidade l5 = new Localidade("t05", "E");
	static Localidade l6 = new Localidade("t06", "F");
	
	
	static Diretas d1 = new Diretas("e200", 3, l1, l2, 10.0, 20.0, 0.15);
	static Diretas d2 = new Diretas("e201", 2, l3, l4, 15.0, 25.0, 0.30);
	static Diretas d3 = new Diretas("e202", 4, l5, l6, 30.00, 50.0, 0.40);
	
	static Fracionadas f1 = new Fracionadas("e300", d1);
	static Fracionadas f2 = new Fracionadas("e301", f1);
	static Fracionadas f3 = new Fracionadas("e302", f2);
	//static Fracionadas f2 = new Fracionadas("e301", d3, d2);
	//static Fracionadas f3 = new Fracionadas("f45", l1, l2);
	
	
	public static void main(String[] args) {
		f1.addRota(d1);
		f1.addRota(d2);
		
		f2.addRota(f1);
		f2.addRota(d3);
		
		f3.addRota(f2);
		
		System.out.println("Tempo de Entrega: " + f1.tempoEntrega());
		System.out.println("Capacidade de transporte: " + f1.capacidadeTrasnporte());
		System.out.println("Custo da rota: " + f1.custoRota());
		
		System.out.println(f1.getOrigemRota());
		System.out.println(f1.getDestinoRota());
		
		System.out.println(f1.verificaRotas("A", "D"));
		
		System.out.println(f1.mostrarRotas("A", "D"));
		
		System.out.println(f2.getOrigemRota());
		System.out.println(f2.getDestinoRota());
		
		
		System.out.println(f3.getOrigemRota());
		System.out.println(f3.getDestinoRota());
		
		System.out.println(f2.mostrarRotas("A", "F"));
		
		//System.out.println(f1.mostrarOrigemRota());
		//System.out.println(f1.getOrigemRota());
	}

}
