package fastmekan.model;

public class Utilidades {
	public static StringBuffer colocaAspaSimples(String e){
		StringBuffer texto = new StringBuffer();
		texto.append("\'");
		texto.append(e);
		texto.append("\'");
		return texto;
	}

}
