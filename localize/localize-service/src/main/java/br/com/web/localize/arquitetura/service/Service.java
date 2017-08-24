package br.com.web.localize.arquitetura.service;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.transaction.annotation.Transactional;

import br.com.localize.exceptions.RegistroNaoExisteException;
import br.com.web.arquitetura.persistencia.DAO;
import br.com.web.localize.arquitetura.modelo.Entidade;

/**
 * <p>
 * <b>Title:</b> Service
 * </p>
 *
 * <p>
 * <b>Description:</b> Responsável por padronizar métodos de CRUD.
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
@Transactional
public abstract class Service<T extends Entidade, D extends DAO<T>> implements IService<T>, Serializable {
	/** Atributo serialVersionUID. */
	private static final long	serialVersionUID	= 3645488175433555631L;

	/**
	 * Método responsável por salvar os dados.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param entidade
	 */
	@Override
	public T salvar(final T entidade) {

		this.validarSalvar(entidade);

		return this.getDao().salvar(entidade);
		

	}

	/**
	 * Método responsável por alterar os dados.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param entidade
	 */
	@Override
	public void alterar(final T entidade) {

		this.validarAlterar(entidade);

		this.getDao().alterar(entidade);
	}

	/**
	 * Método responsável por por remover os dados.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param entidade
	 */
	@Override
	public void remover(final T entidade) {

		this.getDao().remover(entidade);

	}
	
	/**
	 * Método responsávell por remover uma entidade da base de dados.
	 * 
	 * @author Rogério Gomes
	 * 
	 * @param identificador
	 *            - Identificador da entidade que será removida.
	 * 
	 * @return <code>Serializable</code>
	 */
	public void remover(final Serializable identificador) {

		final T entidade = this.getDao().obter(identificador);

		if (entidade == null) {

			throw new RegistroNaoExisteException();
		}

		this.getDao().remover(entidade);
	}

	/**
	 * Método responsável por obter os dados.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param id
	 *            identificador.
	 * 
	 * @return
	 */
	@Override
	public T obter(final Long id) {

		return this.getDao().obter(id);
	}

	/**
	 * Método responsável por listar os dados.
	 *
	 * @author Silvânio Júnior
	 *
	 * @return <code>Collection</code>
	 */
	@Override
	public Collection<T> listar() {

		return this.getDao().listar();
	}

	/**
	 * Método responsável por validar ao salvar.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param entidade
	 */
	protected void validarSalvar(final T entidade) {

	}

	/**
	 * Método responsável por validar ao alterar.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param entidade
	 */
	protected void validarAlterar(final T entidade) {

	}

	/**
	 * Método responsável por retornar uma instancia de dao.
	 *
	 * @author Silvânio Júnior
	 *
	 * @return <code>DAO</code>
	 */
	public abstract DAO<T> getDao();

}
