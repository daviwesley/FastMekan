package fastmekan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.widgets.Display;

import DAO.Conexao;
import fastmekan.view.TelaPrincipal;

public class LoginModel {

	public static Boolean verificarLogin(String usuario, String senha) throws SQLException {
		Connection conn = new Conexao().conectarBD();
		String queryString = "SELECT nome,login,senha FROM funcionario where login="+usuario+" and senha="+senha;
	    PreparedStatement ps;
		try {
			ps = conn.prepareStatement(queryString);
		    ResultSet results = ps.executeQuery();
		    if (results.next()) {
		    	conn.close();
		    	return true;
		    }else{
		    	conn.close();
		    	return false;
		    }
		} catch (SQLException cc) {
			// TODO Auto-generated catch block
			cc.printStackTrace();
		}
		conn.close();
		return null;

	}
}
