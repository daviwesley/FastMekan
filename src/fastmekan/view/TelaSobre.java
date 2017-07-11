package fastmekan.view;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Control;

public class TelaSobre extends Dialog {

	protected Object result;
	protected Shell shlSobre;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public TelaSobre(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shlSobre.open();
		shlSobre.layout();
		Display display = getParent().getDisplay();
		while (!shlSobre.isDisposed()) {
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
		shlSobre = new Shell(getParent(), SWT.CLOSE | SWT.TITLE | SWT.SYSTEM_MODAL);
		shlSobre.setImage(SWTResourceManager.getImage(TelaSobre.class, "/toolbar/mechanic.png"));
		shlSobre.setSize(450, 291);
		shlSobre.setText("Sobre");
		
		Label lblNewLabel = new Label(shlSobre, SWT.NONE);
		lblNewLabel.setBounds(10, 42, 92, 15);
		lblNewLabel.setText("Desenvolvedores:");
		
		Label lblNewLabel_1 = new Label(shlSobre, SWT.NONE);
		lblNewLabel_1.setBounds(108, 42, 68, 15);
		lblNewLabel_1.setText("Davi Wesley");
		
		Label lblNewLabel_2 = new Label(shlSobre, SWT.NONE);
		lblNewLabel_2.setBounds(108, 63, 99, 15);
		lblNewLabel_2.setText("Gutemberg Filho");
		
		Label lblNewLabel_3 = new Label(shlSobre, SWT.NONE);
		lblNewLabel_3.setBounds(108, 84, 85, 15);
		lblNewLabel_3.setText("Carlos Henrique");
		
		Label lblMatheusSilva = new Label(shlSobre, SWT.NONE);
		lblMatheusSilva.setBounds(108, 105, 85, 15);
		lblMatheusSilva.setText("Matheus Silva");
		
		Label lblNewLabel_4 = new Label(shlSobre, SWT.NONE);
		lblNewLabel_4.setBounds(108, 126, 85, 15);
		lblNewLabel_4.setText("Joaquim Costa");
		
		Label label = new Label(shlSobre, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(259, 42, 2, 99);
		
		Label lblNewLabel_5 = new Label(shlSobre, SWT.NONE);
		lblNewLabel_5.setImage(SWTResourceManager.getImage(TelaSobre.class, "/toolbar/mechanic.png"));
		lblNewLabel_5.setBounds(311, 63, 74, 78);
		
		Link link = new Link(shlSobre, SWT.NONE);
		link.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.ITALIC));
		link.setBounds(10, 246, 59, 15);
		link.setText("<a>Github</a>");
		
		Label lblNewLabel_6 = new Label(shlSobre, SWT.SHADOW_IN);
		lblNewLabel_6.setBounds(398, 246, 36, 15);
		lblNewLabel_6.setText("v1.0.0");
		
		Label lblNewLabel_7 = new Label(shlSobre, SWT.NONE);
		lblNewLabel_7.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblNewLabel_7.setBounds(108, 0, 264, 26);
		lblNewLabel_7.setText("Fast Mekan - Gerenciador de Oficinas");
		shlSobre.setTabList(new Control[]{link});

	}
}
