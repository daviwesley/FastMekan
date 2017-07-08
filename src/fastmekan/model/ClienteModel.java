package fastmekan.model;

public class ClienteModel extends PessoaModel {

	public ClienteModel(String nome, int telefone1, String cpf, EnderecoModel endereco, String email, int codigo,
			String senha) {
		super(nome, telefone1, cpf, endereco, email, codigo, senha);
		// TODO Auto-generated constructor stub
	}

	private boolean vip;

	private AutomovelModel automovel;

}
