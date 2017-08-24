/*
 * Copyright 2014 3Way Networks Informática LTDA
 * 
 * Licensed under the Apache License, Version 2.0 (the "License") you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 * 
 * Developed By Cézar Augusto Ferreira
 */
package br.com.web.localize.persistencia.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Repository;

import br.com.web.arquitetura.persistencia.DAO;
import br.com.web.arquitetura.persistencia.impl.HibernateDAO;
import br.com.web.localize.arquitetura.modelo.Entidade;

/**
 * <p>
 * <b>Title:</b> AppDAOImpl
 * </p>
 * 
 * <p>
 * <b>Description:</b> AppDAOImpl
 * </p>
 * 
 * @author Rogério Gomes
 * 
 * @version 1.0.0
 */
@Repository
public class LocalizeDAOImpl<E extends Entidade> extends HibernateDAO<E> implements DAO<E>, Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -2949608484916066755L;
	
	@PersistenceContext
	private EntityManager	entityManager;

	/**
	 * Define o valor do atributo <code>entityManager</code>.
	 *
	 * @param entityManager
	 */
	public void setEntityManager(EntityManager entityManager) {

		this.entityManager = entityManager;
	}

	@Override
	public EntityManager getEntityManager() {

		return this.entityManager;
	}

	/**
	 * Método responsável por obter a quantidade de dados
	 * 
	 * @author Rogério Gomes
	 * 
	 * @return <code>Long</code>
	 */
	public Long getQuantidadeDados() {

		final Criteria criteria = this.createCriteria();

		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);

		criteria.setProjection(Projections.count("id"));

		return (Long) criteria.uniqueResult();
	}

	/**
	 * @generated
	 */
	protected void definirPaginacao(final Integer offsetInicio, final Integer offsetFim, final Query query) {

		query.setMaxResults(offsetFim);

		query.setFirstResult(offsetInicio);
	}

	/**
	 * @generated
	 */
	protected void definirPaginacao(final Integer offsetInicio, final Integer offsetFim, final Criteria criteria) {

		criteria.setMaxResults(offsetFim);

		criteria.setFirstResult(offsetInicio);
	}

}
