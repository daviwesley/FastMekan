package fastmekan.view;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

import DAO.Conexao;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.widgets.Link;

public class TelaLogin extends Dialog {

	protected Object result;
	protected Shell shlLoginFastmekan;
	private Text text;
	private Text text_1;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public TelaLogin(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlLoginFastmekan.open();
		shlLoginFastmekan.layout();
		Display display = getParent().getDisplay();
		while (!shlLoginFastmekan.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shlLoginFastmekan = new Shell(getParent(), SWT.CLOSE | SWT.TITLE);
		shlLoginFastmekan.setImage(SWTResourceManager.getImage(TelaLogin.class, "/toolbar/mechanic.png"));
		shlLoginFastmekan.setSize(450, 300);
		shlLoginFastmekan.setText("Login - FastMekan");
		//Monitor primary = ;
	    Rectangle bounds = Display.getCurrent().getBounds();
	    Rectangle rect = shlLoginFastmekan.getBounds();
	    int x = bounds.x + (bounds.width - rect.width) / 2;
	    int y = bounds.y + (bounds.height - rect.height) / 2;
	    shlLoginFastmekan.setLocation(x, y);
		
		Label imgLogo = new Label(shlLoginFastmekan, SWT.NONE);
		imgLogo.setImage(SWTResourceManager.getImage(TelaLogin.class, "/toolbar/mechanic.png"));
		imgLogo.setAlignment(SWT.CENTER);
		imgLogo.setBounds(194, 20, 89, 64);
		
		Label lblUsurio = new Label(shlLoginFastmekan, SWT.NONE);
		lblUsurio.setBounds(106, 96, 49, 15);
		lblUsurio.setText("Usu\u00E1rio");
		
		Label lblSenha = new Label(shlLoginFastmekan, SWT.NONE);
		lblSenha.setBounds(106, 130, 49, 15);
		lblSenha.setText("Senha");
		
		Label infoLabel = new Label(shlLoginFastmekan, SWT.CENTER);
		infoLabel.setBounds(106, 246, 269, 15);
		
		text = new Text(shlLoginFastmekan, SWT.BORDER);
		text.setBounds(159, 90, 169, 21);
		
		text_1 = new Text(shlLoginFastmekan, SWT.BORDER | SWT.PASSWORD);
		text_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.CR){//tecla ENTER
					Connection conn = new Conexao().conectarBD();
					StringBuffer login = new StringBuffer();
					login.append("\'");
					login.append(text.getText());
					login.append("\'");
					
					StringBuffer senha = new StringBuffer();
					senha.append("\'");
					senha.append(text_1.getText());
					senha.append("\'");
					String queryString = "SELECT nome,login,senha FROM funcionario where login="+login+ " and senha="+senha;
				    PreparedStatement ps;
					try {
						ps = conn.prepareStatement(queryString);
					    ResultSet results = ps.executeQuery();
					    if (results.next()) {
					    	new TelaPrincipal(Display.getCurrent()).open();
							shlLoginFastmekan.setVisible(false);
					    }else{
					    	infoLabel.setText("Usuario/Senha Incorreto");
					    }
					} catch (SQLException cc) {
						// TODO Auto-generated catch block
						cc.printStackTrace();
					}
				}
			}
		});
		text_1.setBounds(159, 124, 169, 21);
		
		Button btnNewButton = new Button(shlLoginFastmekan, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				Connection conn = new Conexao().conectarBD();
				StringBuffer login = new StringBuffer();
				login.append("\'");
				login.append(text.getText());
				login.append("\'");
				
				StringBuffer senha = new StringBuffer();
				senha.append("\'");
				senha.append(text_1.getText());
				senha.append("\'");
				String queryString = "SELECT nome,login,senha FROM funcionario where login="+login+ " and senha="+senha;
			    PreparedStatement ps;
				try {
					ps = conn.prepareStatement(queryString);
				    ResultSet results = ps.executeQuery();
				    if (results.next()) {
				    	new TelaPrincipal(Display.getCurrent()).open();
						shlLoginFastmekan.setVisible(false);
				    }else{
				    	infoLabel.setText("Usuario/Senha Incorreto");
				    
				    }
				} catch (SQLException cc) {
					// TODO Auto-generated catch block
					cc.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(159, 151, 75, 25);
		btnNewButton.setText("Logar");
		
		Button btnNewButton_1 = new Button(shlLoginFastmekan, SWT.NONE);
		btnNewButton_1.setImage(SWTResourceManager.getImage(TelaLogin.class, "/toolbar/error (1).png"));
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				//CadastroCliente tela = new CadastroCliente(Display.getCurrent());
				System.exit(1);
			}
		});
		btnNewButton_1.setBounds(240, 151, 88, 25);
		btnNewButton_1.setText("Cancelar");
		
		Link link = new Link(shlLoginFastmekan, SWT.NONE);
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				TelaCadastroUsuario c = new TelaCadastroUsuario(Display.getCurrent());
				c.open();
				
			}
		});
		link.setBounds(10, 246, 65, 15);
		link.setText("<a>Cadastrar usu\u00E1rio</a>");
		
		

	}
}
