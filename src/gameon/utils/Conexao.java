package gameon.utils;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao {
	final static String BANCO = "gameon";
	
    public static Connection conectar() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + BANCO;
            return DriverManager.getConnection(url, "root", "root");
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }
}