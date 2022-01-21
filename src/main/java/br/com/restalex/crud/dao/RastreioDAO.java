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
		"  dt_rastreio,  " +
		"  usu_rastreio )  " +
		"VALUES " +
		"  (nextval('testejava_rastrear'), " +
		"   ?, ? , ? , ? , ? ,  ? )";  

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			
			System.out.println( "***INSERT RASTREIO: Conexao aberta ? :" + (con.isClosed()?" Nao.":" Sim.") );
			
			stmt.setString(1, rastreio.getId_encomenda() );
			stmt.setString(2, rastreio.getDescr_encomenda());
			stmt.setString(3, rastreio.getNota_fiscal());
			stmt.setString(4, rastreio.getSituacao_rastreio());
			stmt.setString(5, rastreio.getDt_rastreio());
			stmt.setString(6, rastreio.getUsu_rastreio());
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
		String sql = "SELECT * FROM testejava.rastrear ";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.execute();
			try (ResultSet rs = stmt.getResultSet()) {
				while (rs.next()) {
					Rastreio rastr = new Rastreio(rs.getLong("id"),                  
							rs.getString("id_encomenda"),        
							rs.getString("descr_encomenda"),     
							rs.getString("nota_fiscal"),       
							rs.getString("situacao_rastreio"),    
							rs.getString("dt_rastreio"),         
							rs.getString("usu_rastreio"));  	
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
		String sql = "UPDATE testejava.rastrear SET nome = ?, sobrenome = ?, email = ? WHERE id = ?";
		
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setString(1,rastreio.getId_encomenda());        
			stmt.setString(2,rastreio.getDescr_encomenda());     
			stmt.setString(3,rastreio.getNota_fiscal());       
			stmt.setString(4,rastreio.getSituacao_rastreio());    
			stmt.setString(5,rastreio.getDt_rastreio());         
			stmt.setString(6,rastreio.getUsu_rastreio());
			stmt.setLong(7,rastreio.getId()) ;
			
			stmt.execute();
			stmt.close();
			this.con.close();
			System.out.println("Atualizado com Sucesso!");
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