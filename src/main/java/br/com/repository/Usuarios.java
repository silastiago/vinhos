package br.com.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.interfaces.IUsuario;
import br.com.model.Usuario;

public class Usuarios implements Serializable, IUsuario{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;

	@SuppressWarnings("unchecked")
	public List<Usuario> listar() {
		
		List<Usuario> listaUsuario = null;
		Query query = manager.createQuery("Select c from Usuario c");
		listaUsuario = query.getResultList();
		
		return listaUsuario;
	}

	public Usuario porCodigo(Integer codigo) {
		
		String jpql = "Select u from Usuario u join fetch u.grupos "
						+ "where u.codigo = :codigo";
		
		
		return manager.createQuery(jpql, Usuario.class)
				.setParameter("codigo", codigo)
				.getSingleResult(); 
	}

	public void salvar(Usuario Usuario) {
		manager.merge(Usuario);
	}

	public void remover(Usuario Usuario) {
		manager.remove(manager.getReference(Usuario.class, Usuario.getCodigo()));
	}
	
	public Usuario porLogin(String login) {
		Query query = manager.createQuery("from Usuario where login = :login ");
		query.setParameter("login", login);
		
		Usuario usuario = null; 
		usuario = (Usuario) query.getSingleResult();
		return usuario;
	}
	

}
