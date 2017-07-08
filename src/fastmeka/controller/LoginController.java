package fastmeka.controller;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

import fastmekan.model.LoginModel;
import fastmekan.view.TelaLogin;

public class LoginController {
	TelaLogin view;
	LoginModel model;
	
	public LoginController(TelaLogin view, LoginModel model){
		this.view = view;
		this.model = model;
	}
	
	
	public void setEvent(SelectionEvent e) {
		if (((Button)e.getSource()).getText().equals("Logar")){
			System.out.println("button Logar apertado via controller");	
			
		}		
	}


	public TelaLogin getView() {
		return view;
	}


	public void setView(TelaLogin view) {
		this.view = view;
	}


	public LoginModel getModel() {
		return model;
	}


	public void setModel(LoginModel model) {
		this.model = model;
	}
	
	


}
