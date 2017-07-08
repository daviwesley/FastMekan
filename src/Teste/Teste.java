package Teste;

import java.sql.SQLException;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import DAO.Conexao;
import fastmekan.model.GerenteModel;
import fastmekan.model.PessoaModel;
import fastmekan.view.TelaLogin;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new Conexao().conectarBD();
		/*PessoaModel p = new PessoaModel("Jeane", 883777389, "047.467.456.43",null, "jeane@gmail.com", 3, null);
		GerenteModel davi = new GerenteModel("000.000.000-00", 0, "043.073.153-16", null, null, 0, null);
		try {
			davi.CadastrarFuncionario(p, "jeane", "mecanica");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		final Display display = new Display();
        final Shell shell = new Shell(display);
		TelaLogin login = new TelaLogin(shell, 0);
		login.open();
		
	}

}
