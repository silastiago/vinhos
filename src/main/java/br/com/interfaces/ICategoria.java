package br.com.interfaces;

import java.util.List;

import br.com.model.Categoria;

public interface ICategoria {

	
	public List<Categoria> listar();
		
	public Categoria porCodigo(Integer codigo);
		
	public void salvar(Categoria categoria);
	
	
	public void remover(Categoria categoria);
}