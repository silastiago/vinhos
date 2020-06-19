package br.com.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.model.Permissao;
import br.com.service.PermissaoService;



/** Esta � uma Classe concreta que une as implementacoes das interfaces e das paginas xhtml referentes a entidade Grupo.
 *   
 * @author 
 * @since 
 */

@Named
@ViewScoped
public class PermissaoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private PermissaoService permissaoService;
	
	private Permissao permissao = new Permissao();
	private Permissao permissaoSelecionada;
	private List<Permissao> listaPermissoes = new ArrayList<Permissao>();

	
	
	
	/** Este metodo cadastra um Grupo.
	 */
	public void cadastrar(){
		//Esta linha salva a entidade grupo.
		permissaoService.salvar(permissao);

		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Consulta/Permissao.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}	
	
	public void editar(){
		//Esta linha salva a entidade grupo.
		permissaoService.salvar(permissao);

		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Consulta/Permissao.xhtml");
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
		permissaoService.remover(permissaoSelecionada);
		//Atualizar a lista de grupos
		
		permissaoSelecionada = null;
		listar();
	}

	/** Este metodo lista todos os grupos cadastrados.
	 * 	@return retorna a lista de todos os grupos cadastradas no sistema.
	 */
	public List<Permissao> listar(){
		//Esta linha lista os grupos e joga em uma lista de grupos.
		listaPermissoes = permissaoService.listar();
		//Retorna a lista de grupos
		return listaPermissoes;
	}	

	public void novo(){
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Novo/PermissaoNovo.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void edicao(){
		FacesContext fc = FacesContext.getCurrentInstance();
		System.out.println("Permissao Selecionada: " + permissaoSelecionada.getNome());
		try {
			fc.getExternalContext().redirect("../Edicao/PermissaoEdicao.xhtml?codigo="+permissaoSelecionada.getCodigo());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public Permissao getPermissaoSelecionada() {
		return permissaoSelecionada;
	}

	public void setPermissaoSelecionada(Permissao permissaoSelecionada) {
		this.permissaoSelecionada = permissaoSelecionada;
	}

	public List<Permissao> getListaPermissoes() {
		return listaPermissoes;
	}

	public void setListaPermissoes(List<Permissao> listaPermissoes) {
		this.listaPermissoes = listaPermissoes;
	}
}