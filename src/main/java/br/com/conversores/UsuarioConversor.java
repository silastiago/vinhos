package br.com.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.model.Usuario;
import br.com.repository.Usuarios;
import br.com.util.cdi.CDIServiceLocator;

@FacesConverter(value="usuarioConverter")
public class UsuarioConversor implements Converter{

	private Usuarios usuarios;

	public UsuarioConversor() {
		usuarios = CDIServiceLocator.getBean(Usuarios.class);
	}
	
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Usuario retorno = null;
			
		if (value != null) {
			retorno = usuarios.porCodigo(new Integer(value));
		}

		return retorno;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		
		if (value != null) {
			Usuario usuario = (Usuario) value;
			return usuario.getCodigo() == null ? null : usuario.getCodigo().toString();

		}

		return null;
	}

}
