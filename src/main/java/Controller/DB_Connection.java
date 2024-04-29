package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.http.HttpServlet;

public class DB_Connection extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static Connection connection;

	public static Connection getConnection() {

		try {
			if (connection == null) {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/sample";
				String user = "root";
				String pass = "";
				connection = DriverManager.getConnection(url, user, pass);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}