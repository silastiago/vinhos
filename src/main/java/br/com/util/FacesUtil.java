package br.com.util;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


/** Esta � uma Classe utilitaria que implementa alguns metodos que servirao para ser reutilizados em algumas classes.
 *   
 * @author 
 * @since 
 */

public class FacesUtil {

	/** Este metodo captura o atributo da requisicao pelo nome .
	 * 	
	 * 	@param name, Este name e o nome do atributo que voce vai pegar.
	 * 	@return retorna o objeto referente aquele name.
	 */
	public static Object getRequestAttribute(String name) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		return request.getAttribute(name);
	}

	public static String md5(String senha) {
		MessageDigest m = null;
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.update(senha.getBytes(),0, senha.length());
		String hash = new BigInteger(1,m.digest()).toString(16);
		return hash;
	}

	public static void addErrorMessage(String message) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
	}

	public static String retornaDataAtual(){
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		return dateFormat.format(date);
	}




}
