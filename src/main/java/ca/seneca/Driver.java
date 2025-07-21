package ca.seneca;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Driver {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnectivity db = new DBConnectivity();
		try {
			ResultSet rs = db.executeQuery("SELECT first_name, last_name, email FROM customer");

			printResults(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void printResults(ResultSet rs) throws SQLException {
		while (rs.next()) {
			System.out.print("First Name: " + rs.getString("first_name"));
			System.out.print(" | Last Name: " + rs.getString("last_name"));
			System.out.println(" | Email: " + rs.getString("email"));

		}
	}
}
