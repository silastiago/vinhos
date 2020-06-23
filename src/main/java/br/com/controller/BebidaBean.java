package br.com.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.model.Bebida;
import br.com.service.BebidaService;


@Named
@ViewScoped
public class BebidaBean implements Serializable{


	private static final long serialVersionUID = 1L;

	@Inject
	private BebidaService bebidaService;
	
	private Bebida bebida = new Bebida();
	private Bebida bebidaSelecionada;
	private List<Bebida> listaBebidas = new ArrayList<Bebida>();	
	

	public void cadastrar(){
		System.out.println("Bebida: "+ bebida.getNome());
		bebidaService.salvar(bebida);

		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Consulta/Bebida.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editar(){
		//Esta linha salva a entidade grupo.
		bebidaService.salvar(bebida);

		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Consulta/Bebida.xhtml");
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
		bebidaService.remover(bebidaSelecionada);
		//Atualizar a lista de grupos
		
		bebidaSelecionada = null;
		listar();
	}

	/** Este metodo lista todos os grupos cadastrados.
	 * 	@return retorna a lista de todos os grupos cadastradas no sistema.
	 */
	public List<Bebida> listar(){
		//Esta linha lista os grupos e joga em uma lista de grupos.
		listaBebidas = bebidaService.listar();
		//Retorna a lista de grupos
		return listaBebidas;
	}	

	public void novo(){
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Novo/Bebida.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void edicao(){
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Edicao/Bebida.xhtml?codigo="+bebidaSelecionada.getCodigo());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public BebidaService getBebidaService() {
		return bebidaService;
	}

	public void setBebidaService(BebidaService bebidaService) {
		this.bebidaService = bebidaService;
	}

	public Bebida getBebida() {
		return bebida;
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}

	public Bebida getBebidaSelecionada() {
		return bebidaSelecionada;
	}

	public void setBebidaSelecionada(Bebida bebidaSelecionada) {
		this.bebidaSelecionada = bebidaSelecionada;
	}

	public List<Bebida> getListaBebidas() {
		return listaBebidas;
	}

	public void setListaBebidas(List<Bebida> listaBebidas) {
		this.listaBebidas = listaBebidas;
	}	
}