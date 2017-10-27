package dominio;

import java.util.Properties;

public class Main {
	
		
	public static void main(String[] args) {
		//LerProps prop = new LerProps();
		Properties config = new LerProps().getConfig();
		System.out.println(config.getProperty("URI"));
	}

}
