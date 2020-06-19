package br.com.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.model.Permissao;
import br.com.repository.Permissoes;
import br.com.util.jpa.Transactional;

public class PermissaoService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Permissoes permissoes;
	
	@Transactional
	public void salvar(Permissao permissao){
		permissoes.salvar(permissao);
	}

	@Transactional
	public Permissao porCodigo(Integer codigo) {
		return permissoes.porCodigo(codigo);
	}
	
	@Transactional
	public void remover(Permissao permissao) {
		permissoes.remover(permissao);
	}
	
	@Transactional
	public List<Permissao> listar() {
		return permissoes.listar();
	}
	
	
}
