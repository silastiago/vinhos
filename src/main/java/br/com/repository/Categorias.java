package br.com.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.interfaces.ICategoria;
import br.com.model.Categoria;

public class Categorias implements Serializable, ICategoria{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Categoria> listar() {
		
		List<Categoria> listaCategoria = null;
		Query query = manager.createQuery("Select c from Categoria c");
		listaCategoria = query.getResultList();
		
		return listaCategoria;
	}

	public Categoria porCodigo(Integer codigo) {		
		
		String jpql = "Select c from Categoria c "
						+ "where c.codigo = :codigo";


		return manager.createQuery(jpql, Categoria.class)
						.setParameter("codigo", codigo)
						.getSingleResult(); 
	}

	public void salvar(Categoria categoria) {
		manager.merge(categoria);
	}

	public void remover(Categoria categoria) {
		manager.remove(manager.getReference(Categoria.class, categoria.getCodigo()));
	}
}
