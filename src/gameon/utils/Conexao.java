package gameon.utils;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao {
    public static Connection conectar() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + Config.get("DB_HOST") + "/" + Config.get("DB_DATABASE");
            return DriverManager.getConnection(url, Config.get("DB_USER"), Config.get("DB_PASS"));
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }
}