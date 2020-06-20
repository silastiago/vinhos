package br.com.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.model.Grupo;
import br.com.repository.Grupos;
import br.com.util.cdi.CDIServiceLocator;


@FacesConverter(value="grupoConverter")
public class GrupoConversor implements Converter{

	private Grupos grupos;

	public GrupoConversor() {
		grupos = CDIServiceLocator.getBean(Grupos.class);
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Grupo retorno = null;			
		
		if (value != null) {
			
			retorno = grupos.porCodigo(new Integer(value));	
			System.out.println("getAsObject: "+ retorno.getNome());
			
		}

		return retorno;
	}


	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Grupo grupo = (Grupo) value;
			System.out.println("getAsString: "+ grupo.getNome());
			return grupo.getCodigo() == null ? null : grupo.getCodigo().toString();

		}

		return null;
	}

}