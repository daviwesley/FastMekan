package fastmekan.model;

public class PessoaModel {

	private String nome;

	private int telefone1;

	private int telefone2;

	protected String cpf;

	private EnderecoModel endereco;

	private String email;

	private int codigo;

	private String senha;
	

	public PessoaModel(String nome, int telefone1, String cpf, EnderecoModel endereco, String email, int codigo,
			String senha) {
		super();
		this.nome = nome;
		this.telefone1 = telefone1;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.codigo = codigo;
		this.senha = senha;
	}

	public void getInformacao(PessoaModel p) {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(int telefone1) {
		this.telefone1 = telefone1;
	}

	public int getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(int telefone2) {
		this.telefone2 = telefone2;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public EnderecoModel getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoModel endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
