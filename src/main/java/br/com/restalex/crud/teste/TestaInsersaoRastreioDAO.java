package br.com.restalex.crud.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.restalex.crud.dao.RastreioDAO;
import br.com.restalex.crud.db.ConnectionDB;
import br.com.restalex.crud.modelo.Rastreio;

public class TestaInsersaoRastreioDAO {
	public static void main(String[] args) {
		Rastreio rastreio = new Rastreio(0L,                  
				"ENCOM.TESTE",        
				"UMA ENCOMENDA",     
				"NF.ENCOM",       
				"UMA_SITU",    
				"21/01/2022 14:26",         
				"usu");	

		try (Connection con = ConnectionDB.getConnetion()) {
			RastreioDAO rastreiodao = new RastreioDAO(con);
			rastreiodao.inserir(rastreio);

		} catch (SQLException e) {
			throw new RuntimeException("Não foi possivel conectar ao PostgreSQL ! Exception: " + e.getMessage());
		}

	}
}
