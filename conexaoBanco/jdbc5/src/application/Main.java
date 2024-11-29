package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;
import db.DbIntegityExeption;

public class Main {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		Connection com = null;
		PreparedStatement st = null;
		
		try {
			com = DB.getConnection();

			
			st = com.prepareStatement(
					"DELETE FROM departamento "
					+ "WHERE "
					+ "id = ?"
					);
			
//			st = com.prepareStatement("INSERT INTO departamento (nome) VALUES ");
			
			
			
			
			st.setInt(1, 2);
			
			int registros = st.executeUpdate();
			
			System.out.println("Finalizado! Registros alterados: "+ registros);
			
			
		}catch(SQLException e) {
			System.out.println(e.fillInStackTrace());
			throw new DbIntegityExeption(e.getMessage());
			
			
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
