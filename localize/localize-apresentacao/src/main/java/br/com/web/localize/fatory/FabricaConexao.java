package br.com.web.localize.fatory;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {

	private static String url = "jdbc:postgresql://pgsql.localize.kinghost.net/localize";
	private static String usuario = "localize";
	private static String senha = "localize123";

	public static Connection getConexao() {

		try {
			Class.forName("org.postgresql.Driver");
			
			return DriverManager.getConnection(url, usuario, senha);
			
		} catch (Exception e) {
			
			System.out.println("--------Erro ao conectar-------------");
			
			return null;
			
		}

	}

}
