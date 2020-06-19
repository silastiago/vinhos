package br.com.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.model.Permissao;
import br.com.repository.Permissoes;
import br.com.util.cdi.CDIServiceLocator;


@FacesConverter(value="permissaoConverter")
public class PermissaoConversor implements Converter{

	private Permissoes permissoes;

	public PermissaoConversor() {
		permissoes = CDIServiceLocator.getBean(Permissoes.class);
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Permissao retorno = null;			
		if (value != null) {
			retorno = permissoes.porCodigo(new Integer(value));
		}

		return retorno;
	}


	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Permissao permissao = (Permissao) value;
			return permissao.getCodigo() == null ? null : permissao.getCodigo().toString();

		}

		return null;
	}

}