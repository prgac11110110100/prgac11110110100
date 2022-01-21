package br.com.restalex.crud.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.restalex.crud.db.ConnectionDB;


public class TestaConexao {

	public static void main(String[] args) {
		try {
			Connection conn = ConnectionDB.getConnetion();
			System.out.println("Acessando a conexão com PostgreSQL !");
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException("Não consegui conectar ao PostgreSQL ! Exception:" + e.getMessage());
		}

	}
	
	
	
}
