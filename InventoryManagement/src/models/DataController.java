package models;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DataController {
	private static DBController dbc;
	
	public DataController() {
		dbc = new DBController();
		System.out.println(dbc.createConnection());
	}
	public int authUser(String uname, String pass) {
		String query = "SELECT auth_level from tbl_login where uname = '" + uname + "' and pwd = '" + pass + "'";
		Object ob = dbc.returnAuthLevel(query);
		if(ob == null) {
			return -1;
		}else {
			return (int)ob;
		}
	}
}
