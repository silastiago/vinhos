package br.com.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.model.Categoria;
import br.com.repository.Categorias;
import br.com.util.jpa.Transactional;

public class CategoriaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Categorias categorias;
	
	@Transactional
	public void salvar(Categoria categoria){
		categorias.salvar(categoria);
	}

	@Transactional
	public Categoria porCodigo(Integer codigo) {
		return categorias.porCodigo(codigo);
	}
	
	@Transactional
	public void remover(Categoria categoria) {
		categorias.remover(categoria);
	}
	
	@Transactional
	public List<Categoria> listar() {
		return categorias.listar();
	}
	
	
}
