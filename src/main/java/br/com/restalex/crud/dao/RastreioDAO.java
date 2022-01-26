package br.com.restalex.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.restalex.crud.modelo.Rastreio;

public class RastreioDAO {
	
	private Connection con;

	public RastreioDAO(Connection con) {
		this.con = con;
	}

	public void inserir(Rastreio rastreio) {
		
		String sql =		
		"INSERT INTO testejava.rastrear " +
		"  (id, " +
		"  id_encomenda, " +
		"  descr_encomenda, " +
		"  nota_fiscal, " +
		"  situacao_rastreio, " +
		"  dt_rastreio )  " +
		"VALUES " +
		"  (nextval('testejava_rastrear'), " +
		"   ?, ? , ? , ? , ? )";  

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, rastreio.getId_encomenda() );
			stmt.setString(2, rastreio.getDescr_encomenda());
			stmt.setString(3, rastreio.getNota_fiscal());
			stmt.setString(4, rastreio.getSituacao_rastreio());
			stmt.setString(5, rastreio.getDt_rastreio());
			stmt.execute();
			stmt.close();
			this.con.close();
			System.out.println("Dados incluidos. ");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Rastreio> listar() throws SQLException {
		List<Rastreio> rastreios = new ArrayList<>();
		String sql = "select id as \"id\", id_encomenda as \"id_encomenda\", descr_encomenda as \"descr_encomenda\", nota_fiscal as \"nota_fiscal\", situacao_rastreio as \"situacao_rastreio\", dt_rastreio as \"dt_rastreio\" FROM testejava.rastrear ";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					System.out.println("GetId["+rs.getLong("id")+"]");
					Rastreio rastr = new Rastreio(rs.getLong("id"),                  
							rs.getString("id_encomenda"),        
							rs.getString("descr_encomenda"),     
							rs.getString("nota_fiscal"),       
							rs.getString("situacao_rastreio"),    
							rs.getString("dt_rastreio"));  	
					rastreios.add(rastr);
				}
				rs.close();
			}
			stmt.close();
			this.con.close();
		}
		return rastreios;
	}

	public void atualizar(Rastreio rastreio) throws SQLException {
		String sql = "UPDATE testejava.rastrear SET id_encomenda = ?, descr_encomenda = ?, nota_fiscal = ?, situacao_rastreio = ?, dt_rastreio = ? WHERE id = ?";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			
			System.out.println("Id"+rastreio.getId()); 
			
			stmt.setString(1,rastreio.getId_encomenda());        
			stmt.setString(2,rastreio.getDescr_encomenda());     
			stmt.setString(3,rastreio.getNota_fiscal());       
			stmt.setString(4,rastreio.getSituacao_rastreio());    
			stmt.setString(5,rastreio.getDt_rastreio());         
			stmt.setLong(6,rastreio.getId()) ;
			
			stmt.execute();
			
			stmt.close();
			
			this.con.close();
		}
	}

	public void excluir(Long id) throws SQLException {
		if (id == 0L) {
			throw new IllegalStateException("Preciso do id para excluir.");
		}

		String sql = "DELETE FROM testejava.rastrear WHERE id = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
			this.con.close();
			System.out.println("Excluido com sucesso!");
		}

	}

}
