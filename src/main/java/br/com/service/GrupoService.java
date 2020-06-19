package br.com.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.model.Grupo;
import br.com.repository.Grupos;
import br.com.util.jpa.Transactional;

public class GrupoService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Grupos grupos;
	
	@Transactional
	public void salvar(Grupo grupo){
		grupos.salvar(grupo);
	}

	@Transactional
	public Grupo porCodigo(Integer codigo) {
		return grupos.porCodigo(codigo);
	}
	
	@Transactional
	public void remover(Grupo grupo) {
		grupos.remover(grupo);
	}
	
	@Transactional
	public List<Grupo> listar() {
		return grupos.listar();
	}
	
	
}
