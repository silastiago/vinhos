package br.com.conversores;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.model.Categoria;
import br.com.repository.Categorias;
import br.com.util.cdi.CDIServiceLocator;


@FacesConverter(value="categoriaConverter")
public class CategoriaConversor implements Converter{

	private Categorias categorias;

	public CategoriaConversor() {
		categorias = CDIServiceLocator.getBean(Categorias.class);
	}

	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Categoria retorno = null;			
		
		if (value != null) {
			
			retorno = categorias.porCodigo(new Integer(value));
			System.out.println("getAsObject: "+retorno.getCategoria());
			
		}

		return retorno;
	}


	public String getAsString(FacesContext context, UIComponent component, Object value) {

		if (value != null) {
			Categoria categoria = (Categoria) value;
			System.out.println("getAsObject: "+categoria.getCategoria());
			return categoria.getCodigo() == null ? null : categoria.getCodigo().toString();

		}

		return null;
	}

}