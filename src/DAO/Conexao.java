package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection conectarBD(){
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/FastMekan", "postgres", "dwos12");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
