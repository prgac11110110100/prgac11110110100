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

@WebServlet(urlPatterns = "/formAtualizarRastreio")
public class FormAtualizarRastreio extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Recebendo Id: " + req.getParameter("id"));

		Rastreio rastreio = new Rastreio();
		rastreio.setId(Long.parseLong(req.getParameter("id")) );
		rastreio.setId_encomenda(req.getParameter("id_encomenda"));       
		rastreio.setDescr_encomenda( req.getParameter("descr_encomenda") );
		rastreio.setNota_fiscal(  req.getParameter("nota_fiscal") );
		rastreio.setSituacao_rastreio(  req.getParameter("situacao_rastreio") );   
		rastreio.setDt_rastreio( req.getParameter("dt_rastreio") );        
		req.setAttribute("rastreio", rastreio);
		
		
		try (Connection con = ConnectionDB.getConnetion()) {
			con.setAutoCommit(false);
		    RastreioDAO dao = new RastreioDAO(con);
		            dao.atualizar(rastreio);
		            con.commit();
		    		System.out.println("Dispatcher.." + rastreio.getId());
					req.getRequestDispatcher("/WEB-INF/views/rastreio/form/formAtualizarRastreio.jsp").forward(req, resp);
					
		} catch (SQLException e) {
		        throw new RuntimeException(e.getMessage());
		}

	}
	
}
	
