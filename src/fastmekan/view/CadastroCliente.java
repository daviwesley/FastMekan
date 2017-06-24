package fastmekan.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class CadastroCliente extends Shell {
	private Text text;
	private Text text_1;
	private Combo combo;
	private Label lblNewLabel;
	private Text text_2;
	private Label lblNewLabel_1;
	private Text text_3;
	private Label lblSenha;
	private Text text_4;
	private Label lblN;
	private Text text_5;
	private Label infoLabel;
	/**
	 * Create the shell.
	 * @param display
	 */
	public CadastroCliente(Display display) {
		super(display, SWT.SHELL_TRIM);
		setImage(SWTResourceManager.getImage("C:\\Users\\Davi Wesley\\workspace\\FastMekan\\img\\mechanic.png"));
		setLayout(new FormLayout());
		
		Label lblNomeCompleto = new Label(this, SWT.NONE);
		FormData fd_lblNomeCompleto = new FormData();
		fd_lblNomeCompleto.top = new FormAttachment(0, 13);
		lblNomeCompleto.setLayoutData(fd_lblNomeCompleto);
		lblNomeCompleto.setText("Nome Completo");
		
		text = new Text(this, SWT.BORDER);
		fd_lblNomeCompleto.right = new FormAttachment(text, -6);
		FormData fd_text = new FormData();
		fd_text.right = new FormAttachment(100, -10);
		fd_text.left = new FormAttachment(0, 105);
		fd_text.top = new FormAttachment(0, 10);
		text.setLayoutData(fd_text);
		
		text_1 = new Text(this, SWT.BORDER);
		FormData fd_text_1 = new FormData();
		fd_text_1.top = new FormAttachment(0, 38);
		text_1.setLayoutData(fd_text_1);
		
		combo = new Combo(this, SWT.READ_ONLY);
		fd_text_1.left = new FormAttachment(0, 105);
		combo.setItems(new String[] {"Rua", "Avenida"});
		FormData fd_combo = new FormData();
		fd_combo.right = new FormAttachment(lblNomeCompleto, 73);
		fd_combo.left = new FormAttachment(lblNomeCompleto, 0, SWT.LEFT);
		fd_combo.top = new FormAttachment(lblNomeCompleto, 8);
		combo.setLayoutData(fd_combo);
		combo.select(0);
		
		lblNewLabel = new Label(this, SWT.NONE);
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.top = new FormAttachment(combo, 14);
		fd_lblNewLabel.left = new FormAttachment(lblNomeCompleto, 0, SWT.LEFT);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("CPF:");
		
		text_2 = new Text(this, SWT.BORDER);
		FormData fd_text_2 = new FormData();
		fd_text_2.top = new FormAttachment(text_1, 8);
		fd_text_2.right = new FormAttachment(lblNewLabel, 166, SWT.RIGHT);
		fd_text_2.left = new FormAttachment(lblNewLabel, 70);
		text_2.setLayoutData(fd_text_2);
		
		lblNewLabel_1 = new Label(this, SWT.NONE);
		FormData fd_lblNewLabel_1 = new FormData();
		fd_lblNewLabel_1.top = new FormAttachment(lblNewLabel, 0, SWT.TOP);
		fd_lblNewLabel_1.left = new FormAttachment(text_2, 6);
		lblNewLabel_1.setLayoutData(fd_lblNewLabel_1);
		lblNewLabel_1.setText("Telefone:");
		
		text_3 = new Text(this, SWT.BORDER);
		text_3.addVerifyListener(new VerifyListener() {
			public void verifyText(VerifyEvent arg0) {
				String string = arg0.text;
		        char[] chars = new char[string.length()];
		        string.getChars(0, chars.length, chars, 0);
		        for (int i = 0; i < chars.length; i++) {
		          if (!('0' <= chars[i] && chars[i] <= '9')) {
		            arg0.doit = false;
		            return;
		          }
		        }
		      }
		});
		text_3.setToolTipText("(99) 99999-9999");
		FormData fd_text_3 = new FormData();
		fd_text_3.top = new FormAttachment(text, 36);
		fd_text_3.right = new FormAttachment(text, 0, SWT.RIGHT);
		fd_text_3.left = new FormAttachment(lblNewLabel_1, 6);
		text_3.setLayoutData(fd_text_3);
		
		lblSenha = new Label(this, SWT.NONE);
		FormData fd_lblSenha = new FormData();
		fd_lblSenha.top = new FormAttachment(lblNewLabel, 6);
		fd_lblSenha.left = new FormAttachment(lblNomeCompleto, 0, SWT.LEFT);
		lblSenha.setLayoutData(fd_lblSenha);
		lblSenha.setText("E-mail");
		
		text_4 = new Text(this, SWT.BORDER);
		FormData fd_text_4 = new FormData();
		fd_text_4.right = new FormAttachment(text, 0, SWT.RIGHT);
		fd_text_4.top = new FormAttachment(text_2, 6);
		fd_text_4.left = new FormAttachment(text, 0, SWT.LEFT);
		text_4.setLayoutData(fd_text_4);
		
		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setImage(SWTResourceManager.getImage("C:\\Users\\Davi Wesley\\workspace\\FastMekan\\img\\plus.png"));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent arg0) {
			}
		});
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.left = new FormAttachment(0, 105);
		fd_btnNewButton.top = new FormAttachment(text_4, 26);
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("Cadastrar");
		
		Button btnNewButton_1 = new Button(this, SWT.NONE);
		fd_btnNewButton.right = new FormAttachment(btnNewButton_1, -6);
		btnNewButton_1.setImage(SWTResourceManager.getImage("C:\\Users\\Davi Wesley\\workspace\\FastMekan\\img\\error (1).png"));
		btnNewButton_1.setSelection(true);
		btnNewButton_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		FormData fd_btnNewButton_1 = new FormData();
		fd_btnNewButton_1.top = new FormAttachment(btnNewButton, 0, SWT.TOP);
		fd_btnNewButton_1.right = new FormAttachment(text, 0, SWT.RIGHT);
		fd_btnNewButton_1.left = new FormAttachment(0, 271);
		btnNewButton_1.setLayoutData(fd_btnNewButton_1);
		btnNewButton_1.setText("Cancelar");
		
		lblN = new Label(this, SWT.NONE);
		fd_text_1.right = new FormAttachment(lblN, -6);
		FormData fd_lblN = new FormData();
		fd_lblN.top = new FormAttachment(text, 10);
		lblN.setLayoutData(fd_lblN);
		lblN.setText("N\u00BA");
		
		text_5 = new Text(this, SWT.BORDER);
		fd_lblN.right = new FormAttachment(text_5, -6);
		FormData fd_text_5 = new FormData();
		fd_text_5.right = new FormAttachment(100, -10);
		fd_text_5.top = new FormAttachment(0, 38);
		text_5.setLayoutData(fd_text_5);
		
		infoLabel = new Label(this, SWT.NONE);
		FormData fd_infoLabel = new FormData();
		fd_infoLabel.left = new FormAttachment(text, 0, SWT.LEFT);
		fd_infoLabel.right = new FormAttachment(text, 0, SWT.RIGHT);
		fd_infoLabel.bottom = new FormAttachment(100, -10);
		fd_infoLabel.top = new FormAttachment(89);
		infoLabel.setLayoutData(fd_infoLabel);
		String[] ITEMS = { "Rua", "Avenida"};

		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("Cadastrar Usuario");
		setSize(450, 300);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
