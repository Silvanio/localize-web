package br.com.web.arquitetura.persistencia.impl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;

import sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl;
import br.com.web.arquitetura.persistencia.DAO;
import br.com.web.localize.arquitetura.comum.UtilColecao;
import br.com.web.localize.arquitetura.comum.UtilObjeto;
import br.com.web.localize.arquitetura.comum.UtilString;
import br.com.web.localize.arquitetura.modelo.Entidade;

/**
 * <p>
 * <b>Title:</b> HibernateDAO
 * </p>
 *
 * <p>
 * <b>Description:</b> Classe responsável por implementar a camada de persistência utilizando a tecnologia <code>Hibernate</code>
 * </p>
 *
 * <p>
 * <b>Company:</b> ITSS Factory
 * </p>
 *
 * @author Silvânio Junior
 *
 * @version 1.0.0
 */
@SuppressWarnings({ "unchecked", "restriction" })
public abstract class HibernateDAO<E extends Entidade> implements DAO<E> {


	/**
	 * Método responsável por obter a sessão do Hibernate.
	 *
	 * @author Silvânio Junior
	 *
	 * @return <code>Session</code>
	 */
	public Session getSession() {

		return (Session) this.getEntityManager().getDelegate();
	}

	/**
	 * Método responsável por inserir uma entidade no sistema.
	 *
	 * @author Silvânio Junior
	 *
	 * @param entidade
	 *
	 * @return <code>String</code>
	 */
	@Override
	public E merge(E entidade) {
		
		if (!UtilObjeto.isNull(entidade)) {
			
			entidade = (E) this.getSession().merge(entidade);
			
		}
		
		return entidade;
	}
	/**
	 * Método responsável por inserir uma entidade no sistema.
	 *
	 * @author Silvânio Junior
	 *
	 * @param entidade
	 *
	 * @return <code>String</code>
	 */
	@Override
	public E salvar(E entidade) {

		if (!UtilObjeto.isNull(entidade)) {

			entidade = (E) this.getSession().merge(entidade);

		}

		return entidade;
	}

	/**
	 * Método responsável por inserir uma entidade no sistema.
	 *
	 * @author Silvânio Junior
	 *
	 * @param entidade
	 *
	 * @return <code>String</code>
	 */
	@Override
	public E alterar(final E entidade) {

		E entidadeSalva = null;

		if (!UtilObjeto.isNull(entidade)) {

			entidadeSalva = (E) this.getSession().merge(entidade);

		}

		return entidadeSalva;
	}

	/**
	 * Método responsável por popular uma nova instância da entidade.
	 *
	 * @author Silvânio Junior
	 *
	 * @param id
	 *
	 * @return <code>E</code>
	 */
	@SuppressWarnings("unused")
	private E populate(final Long id, final E values) {

		final E entity = this.obter(id);

		try {

			final Class<?> clazz = this.getEntidadeClass();

			for (final Field field : clazz.getDeclaredFields()) {

				field.setAccessible(Boolean.TRUE);

				final Object value = field.get(values);

				if (!UtilObjeto.isNull(value) || ( value instanceof String && !UtilString.isEmpty(value.toString()) )) {

					BeanUtils.setProperty(entity, field.getName(), value);
				}
			}

		} catch (final Exception e) {

			e.printStackTrace();
		}

		return entity;
	}

	/**
	 * Método responsável por remover uma entidade do sistema.
	 *
	 * @author Silvânio Junior
	 *
	 * @param entidade
	 *
	 * @return <code>String</code>
	 */
	@Override
	public void remover(final E entidade) {

		if (!UtilObjeto.isNull(entidade)) {

			this.carregarEntidadePersistente(entidade);

			this.getSession().delete(entidade);

		}
	}

	/**
	 * Método responsável por remover uma lista de entidades do sistema.
	 *
	 * @author Silvânio Junior
	 *
	 * @param entidades
	 *
	 * @return <code>String</code>
	 */
	@Override
	public void removerTodos(final Collection<E> entidades) {

		if (!UtilObjeto.isNull(entidades)) {

			for (final E entidade : entidades) {

				this.remover(entidade);
			}
		}
	}

	/**
	 * Método responsável por obter uma entidade pelo seu identificador.
	 *
	 * @author Silvânio Junior
	 *
	 * @param identificador
	 *
	 * @return <code>E</code>
	 */
	@Override
	public E obter(final Serializable identificador) {

		E resultado = null;

		if (!UtilObjeto.isNull(identificador)) {

			final Class<E> tipo = this.getEntidadeClass();

			resultado = (E) this.getSession().get(tipo, identificador);
		}

		return resultado;
	}

	/**
	 * Método responsável por obter uma entidade no sistema.
	 *
	 * @author Silvânio Junior
	 *
	 * @param criteria
	 *
	 * @return <code>Collection</code>
	 */
	protected E obter(final Criteria criteria) {

		final List<E> result = criteria.list();

		return UtilColecao.isEmpty(result) ? null : this.getEntidadeClass().cast(result.get(0));
	}

	/**
	 * Método responsável por consultar uma lista de entidades no sistema.
	 *
	 * @author Silvânio Junior
	 *
	 * @param entidade
	 *
	 * @return <code>Collection</code>
	 */
	@Override
	public Collection<E> consultar(final E entidade) {

		final Criteria criteria = this.createCriteria();

		if (!UtilObjeto.isNull(entidade)) {

			final Example example = Example.create(entidade);

			example.enableLike(MatchMode.ANYWHERE);

			example.ignoreCase();

			example.excludeZeroes();

			criteria.add(example);
		}

		return this.consultar(criteria);
	}

	/**
	 * Método responsável por consultar uma lista de entidades no sistema.
	 *
	 * @author Silvânio Junior
	 *
	 * @param criteria
	 *
	 * @return <code>Collection</code>
	 */
	protected Collection<E> consultar(final Criteria criteria) {

		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

		return criteria.list();
	}

	/**
	 * Método responsável por listar as entidades do sistema.
	 *
	 * @author Silvânio Junior
	 *
	 * @return <code>Collection</code>
	 */
	@Override
	public Collection<E> listar() {

		final Criteria criteria = this.createCriteria();

		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

		return criteria.list();
	}

	/**
	 * Método responsável por carregar a entidade mantida pelo Hibernate.
	 *
	 * @author Silvânio Junior
	 *
	 * @param entidade
	 */
	protected void carregarEntidadePersistente(final E entidade) {

		if (!UtilObjeto.isNull(entidade) && !this.isPersistente(entidade)) {

			final Serializable id = entidade.getId();

			this.getSession().load(entidade, id);
		}
	}

	/**
	 * Método responsável por verificar se entidade já se encontra na sessão do Hibernate.
	 *
	 * @author Silvânio Junior
	 *
	 * @param entidade
	 *
	 * @return <code>boolean</code>
	 */
	protected boolean isPersistente(final E entidade) {

		return this.getSession().contains(entidade);
	}

	/**
	 * Método responsável por obter o tipo de entidade que está sendo manipulada.
	 *
	 * @author Silvânio Junior
	 *
	 * @return <code>Class</code>
	 */
	protected Class<E> getEntidadeClass() {

		final Type type[] = ( (ParameterizedTypeImpl) this.getClass().getGenericSuperclass() ).getActualTypeArguments();

		return (Class<E>) type[0];
	}

	/**
	 * Método responsável por criar critérios de consulta.
	 *
	 * @author Silvânio Junior
	 *
	 * @return <code>Criteria</code>
	 */
	protected Criteria createCriteria() {

		final Class<E> clazz = this.getEntidadeClass();

		return this.getSession().createCriteria(clazz);
	}

	/**
	 * Retorna o valor do atributo <code>entityManager</code>
	 *
	 * @return <code>EntityManager</code>
	 */
	public abstract EntityManager getEntityManager();
}
