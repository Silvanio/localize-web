package br.com.web.arquitetura.persistencia;

import java.io.Serializable;
import java.util.Collection;

import br.com.web.localize.arquitetura.modelo.Entidade;

/**
 * <p>
 * <b>Title:</b> DAO
 * </p>
 * 
 * <p>
 * <b>Description:</b> Interface responsável por definir as funções padrão da camada de persistência.
 * </p>
 * 
 * <p>
 * <b>Company:</b> ITSS Factory
 * </p>
 * 
 * @author Bruno Zafalão
 * 
 * @version 1.0.0
 */
public interface DAO<E extends Entidade> {

	/** Atributo UNIT_NAME. */
	String	UNIT_NAME	= "default";

	/**
	 * Método responsável por inserir uma entidade no sistema.
	 * 
	 * @author Bruno Zafalão
	 * 
	 * @param entidade
	 * 
	 * @return <code>String</code>
	 */
	E salvar(final E entidade);
	E merge(final E entidade);

	/**
	 * Método responsável por inserir uma entidade no sistema.
	 * 
	 * @author Bruno Zafalão
	 * 
	 * @param entidade
	 * 
	 * @return <code>String</code>
	 */
	E alterar(final E entidade);

	/**
	 * Método responsável por remover uma entidade do sistema.
	 * 
	 * @author Bruno Zafalão
	 * 
	 * @param entidade
	 * 
	 * @return <code>String</code>
	 */
	void remover(final E entidade);

	/**
	 * Método responsável por remover uma lista de entidades do sistema.
	 * 
	 * @author Bruno Zafalão
	 * 
	 * @param entidades
	 * 
	 * @return <code>String</code>
	 */
	void removerTodos(final Collection<E> entidades);

	/**
	 * Método responsável por obter uma entidade pelo seu identificador.
	 * 
	 * @author Bruno Zafalão
	 * 
	 * @param identificador
	 * 
	 * @return <code>E</code>
	 */
	E obter(final Serializable identificador);

	/**
	 * Método responsável por consultar uma lista de entidades no sistema.
	 * 
	 * @author Bruno Zafalão
	 * 
	 * @param entidade
	 * 
	 * @return <code>Collection</code>
	 */
	Collection<E> consultar(final E entidade);

	/**
	 * Método responsável por listar as entidades do sistema.
	 * 
	 * @author Bruno Zafalão
	 * 
	 * @return <code>Collection</code>
	 */
	Collection<E> listar();
}
