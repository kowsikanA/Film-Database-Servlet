package ca.seneca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectivity {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/sakila";// accesses the mysql server and obtains
																				// the sakila database
	private static final String USER = "root";
	private static final String PASS = "Abiraami#23";

	public Connection getConnection() throws SQLException { //
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}

	public ResultSet searchByName(String firstName) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(
				"SELECT first_name, last_name, email from customer where first_name = '" + firstName + "'"); // MARY

	}

	public ResultSet executeQuery(String query) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(query);

	}

	public ResultSet searchByIDs(int first, int last) throws SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = conn.prepareStatement(
				"SELECT customer_id, first_name, last_name, email from customer where customer_id between ? and ?");
		pstmt.setInt(1, first);
		pstmt.setInt(2, last);
		return pstmt.executeQuery();
	}

	public void closeResources(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

}
