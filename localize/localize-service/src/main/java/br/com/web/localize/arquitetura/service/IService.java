package br.com.web.localize.arquitetura.service;

import java.util.Collection;

import br.com.web.localize.arquitetura.modelo.Entidade;

/**
 * <p>
 * <b>Title:</b> Service
 * </p>
 *
 * <p>
 * <b>Description:</b> Responsável por manter um padrão de Service.
 * </p>
 *
 * <p>
 * <b>Company: </b> ITSS Soluções em Tecnologia
 * </p>
 *
 * @author Silvânio Júnior
 * 
 * @param <T>
 *
 * @version 1.0.0
 */
public interface IService<T extends Entidade> {

	/**
	 * Método responsável por salvar uma entidade.
	 *
	 * @param entidade
	 */
	T salvar(T entidade);

	/**
	 * Método responsável por alterar uma entidade.
	 *
	 * @param entidade
	 */
	void alterar(T entidade);

	/**
	 * Método responsável por remover uma entidade.
	 *
	 * @param entidade
	 */
	void remover(T entidade);

	/**
	 * Método responsável por obter uma entidade.
	 *
	 * @param id
	 *
	 * @return T
	 */
	T obter(Long id);

	/**
	 * Método responsável por listar todas entidades.
	 *
	 * @return <code>Collection</code>
	 */
	Collection<T> listar();
}
