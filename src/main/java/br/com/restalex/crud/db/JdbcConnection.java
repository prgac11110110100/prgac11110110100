package br.com.restalex.crud.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class JdbcConnection {

	
	
	private String bduser;
	private String bdpasswd;
	private String bddriver;
	private String bdurl;
	private String database;
	
	public void getProps() {
		Properties props = new Properties();
		
		try {
			String dirhome = System.getProperty("user.home");
			String dirworkspace = "/mydev/sandbox1/alexclemente-testejava/";
			String arqproperties = "/properties/config.xml";
			String strpath = dirhome + dirworkspace + arqproperties;
			System.out.println("\n " + dirhome +
					"\n" + dirworkspace + 
					"\n" + arqproperties );

			// Setamos o arquivo que será lido
			FileInputStream fis = new FileInputStream(strpath);
			// método load faz a leitura através do objeto fis
			props.loadFromXML(fis);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.out.println("O arquivo não foi encontrado!!!");
		}
		// Captura o valor da propriedade, através do nome da propriedade(Key)
		this.setUser(props.getProperty("jdbc.user"));
		this.setPasswd(props.getProperty("jdbc.passwd"));
		this.setDriver(props.getProperty("jdbc.driver"));
		this.setUrl(props.getProperty("jdbc.url"));
		this.setDatabase(props.getProperty("jdbc.dataBase"));
		
	}
	
	public String getUser() {
		return bduser;
	}
	
	public void setUser(String user) {
		this.bduser = user;
	}
	
	public String getPasswd() {
		return bdpasswd;
	}
	
	public void setPasswd(String passwd) {
		this.bdpasswd = passwd;
	}
	
	public String getDriver() {
		return bddriver;
	}

	public void setDriver(String driver) {
		this.bddriver = driver;
	}
	
	public String getUrl() {
		return bdurl;
	}
	
	public void setUrl(String url) {
		this.bdurl = url;
	}
	
	public String getDatabase() {
		return database;
	}
	
	public void setDatabase(String database) {
		this.database = database;
	}
	
}
