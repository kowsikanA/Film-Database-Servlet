package ca.seneca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FilmServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DBConnectivity db = new DBConnectivity();
		String search = req.getParameter("search");
		try {
			ResultSet rs;
			if (search != null && !search.trim().isEmpty()) {
				search = search.trim();
				rs = db.executeQuery("SELECT first_name, last_name, email FROM customer " +
                        "WHERE first_name LIKE '%" + search + "%' OR last_name LIKE '%" + search + "%' OR email LIKE '%" + search + "%'");
			} else {
				rs = db.executeQuery("SELECT first_name, last_name, email FROM customer");
			}
			List<Film> films = fetchFilms(rs);
			
			req.setAttribute("films", films);
			req.getRequestDispatcher("index.jsp").forward(req,resp);
		} catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	

	private List<Film> fetchFilms(ResultSet rs) throws SQLException{
		List<Film> films = new ArrayList<>();
		
		while(rs.next()) {
			films.add(new Film(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email")));
		}
		return films;
	}
	
	
	
	
}
