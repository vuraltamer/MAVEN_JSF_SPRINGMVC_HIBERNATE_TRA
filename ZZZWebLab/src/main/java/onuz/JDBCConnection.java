package onuz;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class JDBCConnection {

	public static void main(String[] argv) throws SQLException {
		UserController us = new UserController();
		us.setUserName("test");
		us.setUserPassword("123");
		
		System.out.println(getUser(us));

	}

	public static Connection getConnection() {

		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
		}

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oto_test", "root", "1106");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return connection;
	}

	public static boolean getUser(UserController userController) throws SQLException {
		Statement statement;
		ResultSet resultSet = null;
		statement = (Statement) getConnection().createStatement();
		boolean sonuc = false;

		resultSet = statement.executeQuery("select * from oto_test.user where name='" +userController.getUserName()+"' and password='"+userController.getUserPassword()+"'");
		while (resultSet.next()) {
			sonuc = true;
			System.out.println("Basarili kullanici girisi");
		}
	    try {
	        if (resultSet != null) {
	          resultSet.close();
	        }

	        if (statement != null) {
	          statement.close();
	        }

	        if (getConnection() != null) {
	        	getConnection().close();
	        }
	      } catch (Exception e) {

	      }
	    return sonuc;
	}
}
