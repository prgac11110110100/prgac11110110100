package br.com.restalex.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	public static Connection getConnetion() {
		Connection conect = null;
		try {
			JdbcConnection jdbc = new JdbcConnection();
			
			jdbc.getProps();

			System.out.println("URL[" + jdbc.getUrl() + "]"
			 + "DB[" + jdbc.getDatabase() + "]" 
			 + "usr[" + jdbc.getUser() + "]"
			 + "passw[" + jdbc.getPasswd() + "]" ); 

			
			Class.forName(jdbc.getDriver());
			conect = DriverManager.getConnection(jdbc.getUrl() + "/" + jdbc.getDatabase(),
					jdbc.getUser(), jdbc.getPasswd());
			conect.setSchema("testejava");
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		}
		
		return conect;
	}
}
