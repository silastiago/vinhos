package br.com.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.model.Categoria;
import br.com.service.CategoriaService;


@Named
@ViewScoped
public class CategoriaBean implements Serializable{


	private static final long serialVersionUID = 1L;

	@Inject
	private CategoriaService categoriaService;
	
	private Categoria categoria = new Categoria();
	private Categoria categoriaSelecionada;
	private List<Categoria> listaCategorias = new ArrayList<Categoria>();	
	

	public void cadastrar(){
		categoriaService.salvar(categoria);

		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Consulta/Categoria.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editar(){
		//Esta linha salva a entidade grupo.
		categoriaService.salvar(categoria);

		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Consulta/Categoria.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/** Este metodo Remove um grupo.
	 *  @param grupo, Este grupo � o objeto Grupo que voc� ir� remover.
	 */
	public void excluir(){
		//Esta linha remove o grupo.
		categoriaService.remover(categoriaSelecionada);
		//Atualizar a lista de grupos
		
		categoriaSelecionada = null;
		listar();
	}

	/** Este metodo lista todos os grupos cadastrados.
	 * 	@return retorna a lista de todos os grupos cadastradas no sistema.
	 */
	public List<Categoria> listar(){
		//Esta linha lista os grupos e joga em uma lista de grupos.
		listaCategorias = categoriaService.listar();
		//Retorna a lista de grupos
		return listaCategorias;
	}	

	public void novo(){
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Novo/Categoria.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void edicao(){
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Edicao/Categoria.xhtml?codigo="+categoriaSelecionada.getCodigo());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public CategoriaService getCategoriaService() {
		return categoriaService;
	}

	public void setCategoriaService(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Categoria getCategoriaSelecionada() {
		return categoriaSelecionada;
	}

	public void setCategoriaSelecionada(Categoria categoriaSelecionada) {
		this.categoriaSelecionada = categoriaSelecionada;
	}

	public List<Categoria> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
}