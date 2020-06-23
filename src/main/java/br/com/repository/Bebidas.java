package br.com.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.interfaces.IBebida;
import br.com.model.Bebida;

public class Bebidas implements Serializable, IBebida{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	public List<Bebida> listar() {
		
		List<Bebida> listaBebida = null;
		Query query = manager.createQuery("Select b from Bebida b");
		listaBebida = query.getResultList();
		
		return listaBebida;
	}

	public Bebida porCodigo(Integer codigo) {		
		
		String jpql = "Select b from Bebida b "
						+ "where b.codigo = :codigo";


		return manager.createQuery(jpql, Bebida.class)
						.setParameter("codigo", codigo)
						.getSingleResult(); 
	}

	public void salvar(Bebida bebida) {
		manager.merge(bebida);
	}

	public void remover(Bebida bebida) {
		manager.remove(manager.getReference(Bebida.class, bebida.getCodigo()));
	}

	@Override
	public List<Bebida> porSKU(String sku) {
		
		
		
		List<Bebida> listaBebida = null;
		Query query = manager.createQuery("from Bebida where sku = :sku");
		query.setParameter("sku", sku);
		listaBebida = query.getResultList();

			return listaBebida; 
	}

	@Override
	public List<Bebida> porNacionalidade(String nacionalidade) {
		
		List<Bebida> listaBebida = null;
		Query query = manager.createQuery("from Bebida where nacionalidade = :nacionalidade");
		query.setParameter("nacionalidade", nacionalidade);
		listaBebida = query.getResultList();

			return listaBebida; 
	}

	@Override
	public List<Bebida> porCategoria(String categoria) {
		
		System.out.println("Categoria: "+categoria);
		
		List<Bebida> listaBebida = null;
		Query query = manager.createQuery("SELECT b FROM Bebida b JOIN FETCH  b.categoria  c where c.categoria = :categoria");
		query.setParameter("categoria", categoria);
		listaBebida = query.getResultList();

		return listaBebida; 
	}
}
