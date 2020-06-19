package br.com.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.interfaces.IPermissao;
import br.com.model.Permissao;

public class Permissoes implements Serializable, IPermissao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Permissao> listar() {
		
		List<Permissao> listaPermissoes = null;
		Query query = manager.createQuery("Select p from Permissao p");
		listaPermissoes = query.getResultList();
		
		return listaPermissoes;
	}

	public Permissao porCodigo(Integer codigo) {
		Permissao permissao = manager.find(Permissao.class, codigo);
		return permissao;
	}

	public void salvar(Permissao permissao) {
		manager.merge(permissao);
	}

	public void remover(Permissao permissao) {
		manager.remove(manager.getReference(Permissao.class, permissao.getCodigo()));
	}
}
