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

@WebServlet(urlPatterns = "/excluirRastreio")
public class ExcluirRastreio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));

		try(Connection con = ConnectionDB.getConnetion()){
			RastreioDAO dao = new RastreioDAO(con);
			dao.excluir(id);
			req.getRequestDispatcher("/WEB-INF/views/rastreio/excluirRastreio.jsp").forward(req, resp);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
