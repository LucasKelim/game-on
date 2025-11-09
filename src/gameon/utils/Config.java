package gameon.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
	private static final Properties props = new Properties();
	
	static {
		try {
			props.load(new FileInputStream("src/config.properties"));
		} catch (IOException e) {
			throw new RuntimeException("Erro ao carregar config.properties");
		}
	}
	
	public static String get(String key) {
		return props.getProperty(key);
	}
}
