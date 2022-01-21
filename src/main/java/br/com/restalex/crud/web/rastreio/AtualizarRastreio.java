package br.com.restalex.crud.web.rastreio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.restalex.crud.dao.RastreioDAO;
import br.com.restalex.crud.db.ConnectionDB;
import br.com.restalex.crud.modelo.Rastreio;

@WebServlet(urlPatterns = "/atualizarRastreio")
public class AtualizarRastreio extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		Long id = Long.parseLong(req.getParameter("id"));
		String  id_encomenda = req.getParameter("id_encomenda");       
		String  descr_encomenda = req.getParameter("descr_encomenda");
		String  nota_fiscal = req.getParameter("nota_fiscal"); 
		String  situacao_rastreio = req.getParameter("situacao_rastreio");   
		String  dt_rastreio = req.getParameter("dt_rastreio");        
		String  usu_rastreio = req.getParameter("usu_rastreio");        
		
		Rastreio rastreio = new Rastreio(0L,                 
				id_encomenda,        
				descr_encomenda,     
				nota_fiscal,       
				situacao_rastreio,    
				dt_rastreio,         
				usu_rastreio) ;
		
		try (Connection con = ConnectionDB.getConnetion()) {
			RastreioDAO dao = new RastreioDAO(con);
				dao.atualizar(rastreio);
				req.getRequestDispatcher("/WEB-INF/views/rasteio/atualizarRastreio.jsp").forward(req,
						resp);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
