package fastmekan.model;

public class RecepcionistaModel extends EmpregadoModel {

	public RecepcionistaModel(String nome, int telefone1, String cpf, EnderecoModel endereco, String email, int codigo,
			String senha) {
		super(nome, telefone1, cpf, endereco, email, codigo, senha);
		// TODO Auto-generated constructor stub
	}

	private String login;

	private String senha;

	public void visualizarCliente() {

	}

	public void agendarServico() {

	}

	public void notificarCliente() {

	}

	public int calcularDescontoServico() {
		return 0;
	}

	public void calcularPrecoServico() {

	}

}
