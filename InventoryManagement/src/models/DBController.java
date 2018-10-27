package models;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.*;
import com.mysql.jdbc.MySQLConnection;
import java.sql.Statement;


public class DBController {
	private Connection con;
	
	boolean createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopmanagement?" + "user=root&password=");
			return true;
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	boolean closeConnection() {
		try {
			con.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public Object returnAuthLevel(String query) {
		try {
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			return rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
