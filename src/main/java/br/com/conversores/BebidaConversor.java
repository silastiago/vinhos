package br.com.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.model.Bebida;
import br.com.repository.Bebidas;
import br.com.util.cdi.CDIServiceLocator;


@FacesConverter(value="bebidaConverter")
public class BebidaConversor implements Converter{

	private Bebidas bebidas;

	public BebidaConversor() {
		bebidas = CDIServiceLocator.getBean(Bebidas.class);
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Bebida retorno = null;			
		
		if (value != null) {
			
			retorno = bebidas.porCodigo(new Integer(value));
			
		}

		return retorno;
	}


	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Bebida bebida = (Bebida) value;
			return bebida.getCodigo() == null ? null : bebida.getCodigo().toString();

		}

		return null;
	}

}