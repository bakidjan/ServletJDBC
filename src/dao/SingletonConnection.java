package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * le patern Singleton permet d'eviter de creer a chaque foi une connection
 * 
 */
public class SingletonConnection {

	public SingletonConnection() {}
	public static Connection connection;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("JDBC:mysql://localhost:3306/gestionproduits", "root", "");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connection;
	}

}
