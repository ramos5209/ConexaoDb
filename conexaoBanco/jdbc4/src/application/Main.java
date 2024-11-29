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

public class Main {

	public static void main(String[] args) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		Connection com = null;
		PreparedStatement st = null;
		
		try {
			com = DB.getConnection();

			
			st = com.prepareStatement(
					"UPDATE vendedor "
					+"SET salarioBase = salarioBase + ? "
					+ "WHERE "
					+ "(idDepartamento = ?)"
					);
			
//			st = com.prepareStatement("INSERT INTO departamento (nome) VALUES ");
			
			
			
			
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			int registros = st.executeUpdate();
			
			System.out.println("Finalizado! Registros alterados: "+ registros);
			
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
			
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
