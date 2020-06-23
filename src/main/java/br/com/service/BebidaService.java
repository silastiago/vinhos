package br.com.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import br.com.model.Bebida;
import br.com.repository.Bebidas;
import br.com.util.jpa.Transactional;

public class BebidaService implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Bebidas bebidas;
	
	@Transactional
	public void salvar(Bebida categoria){
		bebidas.salvar(categoria);
	}

	@Transactional
	public Bebida porCodigo(Integer codigo) {
		return bebidas.porCodigo(codigo);
	}
	
	@Transactional
	public void remover(Bebida bebida) {
		bebidas.remover(bebida);
	}
	
	@Transactional
	public List<Bebida> listar() {
		return bebidas.listar();
	}
	
	@Transactional
	public List<Bebida> porSKU(String sku) {
		return bebidas.porSKU(sku);
	}
	
	@Transactional
	public List<Bebida> porNacionalidade(String nacionalidade) {
		return bebidas.porNacionalidade(nacionalidade);
	}
	
	@Transactional
	public List<Bebida> porCategoria(String categoria) {
		return bebidas.porCategoria(categoria);
	}
	
	
}
