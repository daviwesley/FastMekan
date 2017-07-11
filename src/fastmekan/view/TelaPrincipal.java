package fastmekan.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import DAO.Conexao;
import fastmekan.model.Utilidades;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;

public class TelaPrincipal extends Shell {
	private Table table;
	private Text textserv_id;
	private Text textserv_nome;
	private Text textserv_preco;
	private Table table_servicos;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	

	/**
	 * Launch the application.
	 * @param args
	 */
	
	/**
	 * Create the shell.
	 * @param display
	 */
	public TelaPrincipal(Display display) {
		super(display, SWT.CLOSE | SWT.MIN | SWT.TITLE);
		addShellListener(new ShellAdapter() {
			@Override
			public void shellClosed(ShellEvent arg0) {
				System.exit(1);
			}
		});
		setImage(SWTResourceManager.getImage(TelaPrincipal.class, "/toolbar/mechanic.png"));
		setLayout(new FormLayout());
		
		Menu menu = new Menu(this, SWT.BAR);
		setMenuBar(menu);
		
		MenuItem mntmArquivo = new MenuItem(menu, SWT.CASCADE);
		mntmArquivo.setText("Arquivo");
		
		Menu menu_1 = new Menu(mntmArquivo);
		mntmArquivo.setMenu(menu_1);
		
		MenuItem mntmSair = new MenuItem(menu_1, SWT.NONE);
		mntmSair.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				System.exit(1);
			}
		});
		mntmSair.setImage(SWTResourceManager.getImage(TelaPrincipal.class, "/toolbar/error (1).png"));
		mntmSair.setText("Sair");
		
		MenuItem mntmAjuda = new MenuItem(menu, SWT.CASCADE);
		mntmAjuda.setText("Ajuda");
		
		Menu menu_2 = new Menu(mntmAjuda);
		mntmAjuda.setMenu(menu_2);
		
		MenuItem mntmSobre = new MenuItem(menu_2, SWT.NONE);
		mntmSobre.setText("Sobre");
		
		TabFolder tabFolder = new TabFolder(this, SWT.NONE);
		FormData fd_tabFolder = new FormData();
		fd_tabFolder.top = new FormAttachment(0);
		fd_tabFolder.left = new FormAttachment(0);
		fd_tabFolder.right = new FormAttachment(100);
		fd_tabFolder.bottom = new FormAttachment(100);
		tabFolder.setLayoutData(fd_tabFolder);
		
		TabItem abaFuncionarios = new TabItem(tabFolder, SWT.NONE);
		abaFuncionarios.setText("Clientes");
		
		Composite composite = new Composite(tabFolder, SWT.NONE);
		abaFuncionarios.setControl(composite);
		
		table = new Table(composite, SWT.MULTI | SWT.BORDER| SWT.FULL_SELECTION);
		table.setToolTipText("Informa\u00E7\u00F5es dos clientes cadastrados");
		table.setBounds(10, 0, 85, 45);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		Menu menuTable = new Menu(table);
		table.setMenu(menuTable);

		// Create menu item
		MenuItem miTest = new MenuItem(menuTable, SWT.NONE);
		miTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Connection conn = new Conexao().conectarBD();
				TableItem[] selection = table.getSelection();
				String nome = selection[0].getText();
				String queryString = "DELETE FROM cliente "
						+            "where nome ="+"'"+nome+"'";
				System.out.println(queryString);
				PreparedStatement ps;
				try {
					ps = conn.prepareStatement(queryString);
					ps.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   
				
			}
		});
		miTest.setImage(SWTResourceManager.getImage(TelaPrincipal.class, "/toolbar/garbage.png"));
		miTest.setText("Excluir");

		// Do not show menu, when no item is selected
		table.addListener(SWT.MenuDetect, new Listener() {
		  @Override
		  public void handleEvent(Event event) {
		    if (table.getSelectionCount() <= 0) {
		      event.doit = false;
		    }
		  }
		});
		String[] colunas = {"Nome","Cpf","Telefone","E-mail","Rua","Bairro","Cidade"};
		for (int i = 0; i < colunas.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(colunas[i]);
		}
				
		Connection conn = new Conexao().conectarBD();
		String queryString = "SELECT * FROM cliente";
	    PreparedStatement ps;
		try {
			ps = conn.prepareStatement(queryString);
		    ResultSet rs = ps.executeQuery();
		    while (rs.next()) {
				TableItem item = new TableItem(table, SWT.NONE);
				item.setText(0, rs.getString("nome"));
				item.setText(1, rs.getString("cpf"));
				item.setText(2, rs.getString("telefone"));
				item.setText(3, rs.getString("email"));
				item.setText(4, rs.getString("rua"));
				item.setText(5, rs.getString("bairro"));
				item.setText(6, rs.getString("cidade"));
		    }
		} catch (SQLException cc) {
			// TODO Auto-generated catch block
			cc.printStackTrace();
		}
		for (int i = 0; i < colunas.length; i++) {
			table.getColumn(i).pack();
		}
		table.setSize(table.computeSize(SWT.DEFAULT, 200));
		
		Group grpCadastarClientes = new Group(composite, SWT.NONE);
		grpCadastarClientes.setText("Cadastar clientes");
		grpCadastarClientes.setBounds(10, 221, 493, 133);
		
		Label lblNome_cliente = new Label(grpCadastarClientes, SWT.NONE);
		lblNome_cliente.setBounds(10, 21, 33, 15);
		lblNome_cliente.setText("Nome");
		
		text = new Text(grpCadastarClientes, SWT.BORDER);
		text.setBounds(49, 18, 186, 21);
		
		Label lblNewLabel = new Label(grpCadastarClientes, SWT.NONE);
		lblNewLabel.setBounds(10, 52, 33, 15);
		lblNewLabel.setText("CPF");
		
		text_1 = new Text(grpCadastarClientes, SWT.BORDER);
		text_1.setBounds(49, 45, 186, 21);
		
		Label lblEmail = new Label(grpCadastarClientes, SWT.NONE);
		lblEmail.setBounds(10, 76, 33, 15);
		lblEmail.setText("E-mail");
		
		text_2 = new Text(grpCadastarClientes, SWT.BORDER);
		text_2.setBounds(49, 73, 186, 21);
		
		Label lblRua = new Label(grpCadastarClientes, SWT.NONE);
		lblRua.setBounds(251, 21, 20, 15);
		lblRua.setText("Rua");
		
		text_3 = new Text(grpCadastarClientes, SWT.BORDER);
		text_3.setBounds(302, 18, 181, 21);
		
		Label lblBairro = new Label(grpCadastarClientes, SWT.NONE);
		lblBairro.setBounds(251, 52, 33, 15);
		lblBairro.setText("Bairro");
		
		text_4 = new Text(grpCadastarClientes, SWT.BORDER);
		text_4.setBounds(302, 46, 181, 21);
		
		Label lblCidade = new Label(grpCadastarClientes, SWT.NONE);
		lblCidade.setBounds(251, 76, 42, 15);
		lblCidade.setText("Cidade");
		
		text_5 = new Text(grpCadastarClientes, SWT.BORDER);
		text_5.setBounds(302, 73, 181, 21);
		
		Button btnNewButton = new Button(grpCadastarClientes, SWT.NONE);
		btnNewButton.setBounds(180, 98, 175, 25);
		btnNewButton.setText("Cadastrar");
		
		TabItem abaClientes = new TabItem(tabFolder, SWT.NONE);
		abaClientes.setText("Servi\u00E7os");
		
		Composite composite_1 = new Composite(tabFolder, SWT.NONE);
		abaClientes.setControl(composite_1);
		
		Label lblId = new Label(composite_1, SWT.NONE);
		lblId.setBounds(10, 10, 23, 15);
		lblId.setText("id");
		
		Label lblNome = new Label(composite_1, SWT.NONE);
		lblNome.setBounds(10, 37, 33, 15);
		lblNome.setText("Nome");
		
		Label lblPreo = new Label(composite_1, SWT.NONE);
		lblPreo.setBounds(10, 58, 33, 15);
		lblPreo.setText("Pre\u00E7o");
		
		textserv_id = new Text(composite_1, SWT.BORDER);
		textserv_id.setBounds(49, 7, 76, 21);
		
		textserv_nome = new Text(composite_1, SWT.BORDER);
		textserv_nome.setBounds(49, 31, 76, 21);
		
		textserv_preco = new Text(composite_1, SWT.BORDER);
		textserv_preco.setBounds(49, 55, 76, 21);
		
		Button btnserv_cadastrar = new Button(composite_1, SWT.NONE);
		btnserv_cadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Connection connection = new Conexao().conectarBD();
				new Utilidades();
				new Utilidades();
				new Utilidades();
				String sql = "INSERT INTO servico" + 
				            "(nome,valor,pk_id)"
						+ "VALUES ("+Utilidades.colocaAspaSimples(textserv_nome.getText())+","+
		                            Utilidades.colocaAspaSimples(textserv_preco.getText())+","+
						            Utilidades.colocaAspaSimples(textserv_id.getText())+")";
				
				try {
					PreparedStatement exec = connection.prepareStatement(sql);
					exec.executeQuery();
					exec.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					MessageBox msg = new MessageBox(new Shell().getShell());
					msg.setMessage(e.getMessage());
					msg.open();
				}
				
			}
		});
		btnserv_cadastrar.setBounds(142, 27, 75, 25);
		btnserv_cadastrar.setText("Cadastrar ");
		
		Label label = new Label(composite_1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(10, 116, 493, 4);
		
		table_servicos = new Table(composite_1,  SWT.MULTI | SWT.BORDER| SWT.FULL_SELECTION);
		table_servicos.setBounds(10, 134, 85, 45);
		table_servicos.setHeaderVisible(true);
		table_servicos.setLinesVisible(true);
		String[] colunas1 = {"Id","Nome","Preço"};
		for (int i = 0; i < colunas1.length; i++) {
			TableColumn column = new TableColumn(table_servicos, SWT.NONE);
			column.setText(colunas1[i]);
		}
		Connection conn1 = new Conexao().conectarBD();
		String queryString1 = "SELECT * FROM servico";
	    PreparedStatement ps1;
		try {
			ps1 = conn1.prepareStatement(queryString1);
		    ResultSet rs1 = ps1.executeQuery();
		    while (rs1.next()) {
				TableItem item = new TableItem(table_servicos, SWT.NONE);
				item.setText(0, rs1.getString("pk_id"));
				item.setText(1, rs1.getString("nome"));
				item.setText(2, rs1.getString("valor"));
		    }
		} catch (SQLException cc) {
			// TODO Auto-generated catch block
			cc.printStackTrace();
		}
		
		for (int i = 0; i < colunas1.length; i++) {
			table_servicos.getColumn(i).pack();
		}

		table_servicos.setSize(table_servicos.computeSize(SWT.DEFAULT, 150));

		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Fast Mekan - Gerenciador de Oficina");
		Rectangle bounds = Display.getCurrent().getBounds();
	    Rectangle rect = new Shell().getBounds();
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    setLocation(x, y);
		setSize(519, 435);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
