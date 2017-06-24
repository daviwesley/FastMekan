package fastmekan.view;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

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
		shlLoginFastmekan.setImage(SWTResourceManager.getImage("img\\mechanic.png"));
		shlLoginFastmekan.setSize(450, 300);
		shlLoginFastmekan.setText("Login - FastMekan");
		//Centraliza a janela ;
	        Rectangle bounds = Display.getCurrent().getBounds();
	        Rectangle rect = shlLoginFastmekan.getBounds();
	        int x = bounds.x + (bounds.width - rect.width) / 2;
	        int y = bounds.y + (bounds.height - rect.height) / 2;
	        shlLoginFastmekan.setLocation(x, y);
		
		Label imgLogo = new Label(shlLoginFastmekan, SWT.NONE);
		imgLogo.setImage(SWTResourceManager.getImage("img\\mechanic.png"));
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
		text.setBounds(159, 90, 158, 21);
		
		text_1 = new Text(shlLoginFastmekan, SWT.BORDER | SWT.PASSWORD);
		//Tecla ENTER dispara a verificação do login
		text_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.keyCode == SWT.CR){
					if(text.getText().matches("davi") && text_1.getText().matches("123456")){
						infoLabel.setText("Login efetuado com sucesso!");
						infoLabel.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_GREEN));
					}else{
						infoLabel.setText("Usuário/Senha incorretos!");
						infoLabel.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
					}
				}
			}
		});
		text_1.setBounds(159, 124, 158, 21);
		
		Button btnNewButton = new Button(shlLoginFastmekan, SWT.NONE);
		//Verificação de Login
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				if(text.getText().matches("davi") && text_1.getText().matches("123456")){
					infoLabel.setText("Login efetuado com sucesso!");
				}else{
					infoLabel.setText("Usuário/Senha incorretos!");
					infoLabel.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
				}
			}
		});
		btnNewButton.setBounds(159, 151, 75, 25);
		btnNewButton.setText("Logar");
		
		Button btnNewButton_1 = new Button(shlLoginFastmekan, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
				TelaCadastro tela = new TelaCadastro(Display.getCurrent());
				tela.open();
				shlLoginFastmekan.setVisible(false);			
			}
		});
		btnNewButton_1.setBounds(242, 151, 75, 25);
		btnNewButton_1.setText("Cancelar");
		
		

	}
}
