package br.com.restalex.crud.web.rastreio;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.restalex.crud.dao.RastreioDAO;
import br.com.restalex.crud.db.ConnectionDB;
import br.com.restalex.crud.modelo.Rastreio;

@WebServlet(urlPatterns = "/listarRastreios")
public class ListarRastreio extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try (Connection con = ConnectionDB.getConnetion()) {
			RastreioDAO rastreiodao = new RastreioDAO(con);
			List<Rastreio> rastreios = rastreiodao.listar();
			req.setAttribute("rastreios", rastreios);

			req.getRequestDispatcher("/WEB-INF/views/rastreio/listarRastreio.jsp").forward(req, resp);
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
