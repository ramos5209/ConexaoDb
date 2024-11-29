package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Main {

	public static void main(String[] args) {
		Connection com = null;
		Statement st =  null;
		ResultSet rs = null;
		
		try {
			com = DB.getConnection();
			
			st = com.createStatement();
			
			rs = st.executeQuery("SELECT * from departamento");
			
			while(rs.next()) {
				System.out.println(rs.getInt("id") + "," + rs.getString("nome"));
			}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
			
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}
			
		
	}

}
