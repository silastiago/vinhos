package br.com.interfaces;

import java.util.List;

import br.com.model.Usuario;


/** Esta � uma Interface que possui as assinaturas dos metodos da classe Usuario,
*   
* @author 
* @since 
*/
public interface IUsuario {
	
	
	public List<Usuario> listar();
	
	/** Este metodo pesquisa uma Usuario por seu id.
	*  	
	*  @param codigo, Este codigo � o id da Usuario que voc� est� procurando.
	*  @return retorna a Usuario daquele id que voc� est� pesquisando.
	*   	
	*/
	public Usuario porCodigo(Integer codigo);
	
	
	
	public Usuario porLogin(String login);
	
	/** Este metodo cria ou altera uma Usuario.
	*  	
	*  @param Usuario, Esta Usuario � o objeto Usuario que voc� ir� criar ou modificar.
	*   	
	*/
	public void salvar(Usuario usuario);
	
	/** Este metodo Remove uma Usuario.
	*  	
	*  @param Usuario, Esta Usuario � o objeto Usuario que voc� ir� remover.
	*   	
	*/
	public void remover(Usuario usuario);

}