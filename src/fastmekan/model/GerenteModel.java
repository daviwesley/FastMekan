package fastmekan.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO.Conexao;

public class GerenteModel extends RecepcionistaModel {

	public GerenteModel(String nome, int telefone1, String cpf, EnderecoModel endereco, String email, int codigo,
			String senha) {
		super(nome, telefone1, cpf, endereco, email, codigo, senha);
		// TODO Auto-generated constructor stub
	}

	private CadastroModel acao;
	private Connection connection;

	
	public int calcularSalario() {
		return 0;
	}
	
	public void CadastrarFuncionario(PessoaModel p, String usuario, String cargo) throws SQLException{
		this.connection = new Conexao().conectarBD();
		String sql = "INSERT INTO funcionario"+
		             "(nome,cpf,telefone,login,senha,cargo,cpfsupervisor)"+
				     "VALUES (?,?,?,?,?,?,?)";
		PreparedStatement exec = connection.prepareStatement(sql);
		exec.setString(1, p.getNome());
		exec.setString(2, p.getCpf());
		exec.setInt(3, p.getTelefone1());
		exec.setString(4, usuario);
		exec.setString(5, "123456");
		exec.setString(6, cargo);
		exec.setString(7, this.getCpf());
		exec.executeQuery();
		exec.close();
		
	}

	public void demitirFuncionario() {

	}

}
