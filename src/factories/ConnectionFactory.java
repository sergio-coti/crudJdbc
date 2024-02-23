package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//atributos para conexão com o banco de dados
	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://localhost:5432/bd_aula04";
	private static String user = "postgres";
	private static String password = "coti";
	
	//método para abrir e retornar a conexão do banco de dados
	public static Connection getConnection() throws Exception {
		
		//Abrindo conexão com o banco de dados
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);
		
		//retornando a conexão
		return connection;
	}
}
