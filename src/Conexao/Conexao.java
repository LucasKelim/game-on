package Conexao;

import java.sql.DriverManager;
import java.sql.Connection;

public class Conexao {

	final static String NOME_DO_BANCO = "java";
    public static Connection conectar() {
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/" + NOME_DO_BANCO + "?characterEncoding=UTF-8";
            return DriverManager.getConnection(url,"root","root");
        } catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }
}