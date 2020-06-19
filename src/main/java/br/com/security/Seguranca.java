package br.com.security;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Named
@RequestScoped
public class Seguranca {

	@Inject
	private ExternalContext externalContext;
	
	public String getNomeUsuario() {
		String nome = null;
		
		UsuarioSistema usuarioLogado = getUsuarioLogado();
		
		if (usuarioLogado != null) {
			nome = usuarioLogado.getUsuario().getNome();
		}
		
		return nome;
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
	
	
	public boolean isAcessoCadastroPermitido() {
		return externalContext.isUserInRole("ADICIONAR")
				|| externalContext.isUserInRole("ROLE_ADMIN");
				
	}
	
	public boolean isAcessoEdicaoPermitido() {
		return externalContext.isUserInRole("ADICIONAR");
				//|| externalContext.isUserInRole("CONSULTA");
	}
	
	public boolean isAcessoRemocaoPermitido() {
		return externalContext.isUserInRole("REMOVER"); 
				//|| externalContext.isUserInRole("CONSULTA");
	}
	
	public boolean isAcessoListarPermitido() {
		return externalContext.isUserInRole("LISTAR")
				|| externalContext.isUserInRole("ADMIN");
	}
	
	
}
