package br.com.interfaces;

import java.util.List;

import br.com.model.Bebida;

public interface IBebida {

	
	public List<Bebida> listar();
		
	public Bebida porCodigo(Integer codigo);
		
	public void salvar(Bebida bebida);
	
	public void remover(Bebida bebida);
	
	public List<Bebida> porSKU(String sku);
	
	public List<Bebida> porNacionalidade(String nacionalidade);	
	
	public List<Bebida> porCategoria(String nacionalidade);
	
}