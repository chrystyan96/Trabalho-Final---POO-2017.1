package dominio;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LerProps {
	
	public Properties getConfig(){
		try {
			Properties props = new Properties();
			InputStream file = getClass().getResourceAsStream("/configs/config.properties");
			props.load(file);
			return props;
		}catch(IOException e){
			System.out.println("Erro ==> " + e);
		}
		return null;
	}
	
	public Properties getDados(){
		try {
			Properties props = new Properties();
			InputStream file = getClass().getResourceAsStream("/configs/dados.properties");
			props.load(file);
			return props;
		}catch(IOException e){
			System.out.println("Erro...");
		}
		return null;
	}
}
