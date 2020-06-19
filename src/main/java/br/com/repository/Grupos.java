package br.com.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.interfaces.IGrupo;
import br.com.model.Grupo;

public class Grupos implements Serializable, IGrupo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Grupo> listar() {
		List<Grupo> listaGrupo = null;
		Query query = manager.createQuery("Select c from Grupo c");
		listaGrupo = query.getResultList();
		return listaGrupo;
	}

	public Grupo porCodigo(Integer codigo) {
		//Grupo grupo = manager.find(Grupo.class, codigo);
		
		
		String jpql = "Select g from Grupo g join fetch g.permissoes "
				+ "where g.codigo = :codigo";


		return manager.createQuery(jpql, Grupo.class)
					.setParameter("codigo", codigo)
					.getSingleResult(); 
	}

	public void salvar(Grupo grupo) {
		manager.merge(grupo);
	}

	public void remover(Grupo grupo) {
		manager.remove(manager.getReference(Grupo.class, grupo.getCodigo()));
	}
}
