package br.com.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.model.Usuario;
import br.com.repository.Usuarios;
import br.com.util.jpa.Transactional;

public class UsuarioService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Usuarios usuarios;
	
	@Transactional
	public List<Usuario> listar() {
		return usuarios.listar();
	}
	
	@Transactional
	public Usuario porCodigo(Integer codigo) {
		return usuarios.porCodigo(codigo);
	}

	@Transactional
	public void salvar(Usuario usuario) {
		usuarios.salvar(usuario);
	}
	
	
	@Transactional
	public void remover(Usuario usuario) {
		usuarios.remover(usuario);
	}
}