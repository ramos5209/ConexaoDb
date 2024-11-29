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
//			st = com.prepareStatement(
//					"INSERT INTO vendedor"
//					+"(nome,email,dataNascimento,salarioBase,idDepartamento)"
//					+ "VALUE"
//					+ "(?,?,?,?,?)"
//					);
			
//			st = com.prepareStatement(
//					"INSERT INTO vendedor"
//					+"(nome,email,dataNascimento,salarioBase,idDepartamento)"
//					+ "VALUE"
//					+ "(?,?,?,?,?)",
//					Statement.RETURN_GENERATED_KEYS);
			
			st = com.prepareStatement("INSERT INTO departamento (nome) VALUES (01), (02);");
			
			
			
//			
//			st.setString(1, "Gilberto Roberto");
//			st.setString(2, "gilber@gmail.com");
//			st.setDate(3, new java.sql.Date(sdf.parse("21/04/1993").getTime()));
//			st.setDouble(4, 5000.0);
//			st.setInt(5, 2);
//			
			
			int registros = st.executeUpdate();
			
			System.out.println("Finalizado! Registros alterados: "+ registros);
			
			if(registros > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Finalizado! Id = "+ id);
				}
			}else {
				System.out.println("Nenhum registro alterado!");
			}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
			
//		}catch(ParseException e ) {
//			e.printStackTrace();
//			
		}finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
