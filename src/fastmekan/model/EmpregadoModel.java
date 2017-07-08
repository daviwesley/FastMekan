package fastmekan.model;

import java.util.Date;

public class EmpregadoModel extends PessoaModel {

	public EmpregadoModel(String nome, int telefone1, String cpf, EnderecoModel endereco, String email, int codigo,
			String senha) {
		super(nome, telefone1, cpf, endereco, email, codigo, senha);
		// TODO Auto-generated constructor stub
	}

	private int salario;

	private Date dataEntrada;

	private int faltas;

	private int desconto;

}
