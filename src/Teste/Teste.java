package Teste;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import fastmekan.view.TelaLogin;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Display display = new Display();
        final Shell shell = new Shell(display);
		TelaLogin login = new TelaLogin(shell, 0);
		login.open();
	}

}
