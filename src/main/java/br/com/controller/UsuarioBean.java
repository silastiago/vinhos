package br.com.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.model.Usuario;
import br.com.security.UsuarioSistema;
import br.com.service.UsuarioService;
import br.com.util.FacesUtil;


@Named
@ViewScoped
public class UsuarioBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioService usuarioService;	
	
	private Usuario usuario = new Usuario();
	private Usuario usuarioSelecionado;
	private List<Usuario> listausuarios = new ArrayList<Usuario>();

	public void cadastrar() {
		
		String senha = this.usuario.getSenha();
		System.out.println("Usuario: "+usuario.getNome());

		System.out.println("Usuario: "+usuario.getGrupos().get(0).getNome());
		
		this.usuario.setSenha(FacesUtil.md5(senha));
		usuarioService.salvar(usuario);
		
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Consulta/Usuario.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void editar() {
		
		usuarioService.salvar(usuario);

		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Consulta/Usuario.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void alterarPropriaSenha() {

		String senha = this.usuario.getSenha();
		usuario = this.getUsuarioLogado().getUsuario();
		this.usuario.setSenha(FacesUtil.md5(senha));
		usuarioService.salvar(usuario);

		FacesContext.getCurrentInstance().addMessage("message" , new FacesMessage(FacesMessage.SEVERITY_INFO, "","Senha alterada com sucesso"));
		
	}

	public void alterarSenha() {

		String senha = this.usuario.getSenha();
		this.usuario.setSenha(FacesUtil.md5(senha));
		usuarioService.salvar(usuario);

		FacesContext.getCurrentInstance().addMessage("message" , new FacesMessage(FacesMessage.SEVERITY_INFO, "","Senha alterada com sucesso"));
	}

	public void alteracaoSenha(){
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Edicao/UsuarioSenha.xhtml?codigo="+usuarioSelecionado.getCodigo());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private UsuarioSistema getUsuarioLogado() {
		UsuarioSistema usuario = null;
		
		UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) 
				FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
		
		if (auth != null && auth.getPrincipal() != null) {
			usuario = (UsuarioSistema) auth.getPrincipal();
		}
		
		return usuario;
	}
	
	public void excluir(){
		usuarioService.remover(usuarioSelecionado);
		usuarioSelecionado = null;
		listar();
	}

	public List<Usuario> listar(){
		//Esta linha lista os tipos e joga em uma lista de tipos.
		listausuarios = usuarioService.listar();
		//retorna a lista de tipos.
		return listausuarios;
	}
	

	public void novo(){
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Novo/UsuarioNovo.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void edicao(){
		FacesContext fc = FacesContext.getCurrentInstance();

		try {
			fc.getExternalContext().redirect("../Edicao/UsuarioEdicao.xhtml?codigo="+usuarioSelecionado.getCodigo());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

	public List<Usuario> getListausuarios() {
		return listausuarios;
	}

	public void setListausuarios(List<Usuario> listausuarios) {
		this.listausuarios = listausuarios;
	}	
	
}