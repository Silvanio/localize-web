package br.com.web.localize.persistencia.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import br.com.web.localize.modelo.dto.SeguimentoDTO;
import br.com.web.localize.modelo.entidade.Seguimento;
import br.com.web.localize.persistencia.SeguimentoDAO;

/**
 * <p>
 * <b>Title:</b> SeguimentoDAOImpl
 * </p>
 * 
 * <p>
 * <b>Description:</b>Classe de persistencia da entidade<code>Seguimento</code>
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - Rogério Gomes
 * </p>
 * 
 * @author Rogério Gomes
 * 
 * @version 1.0.0
 */
@Repository
public class SeguimentoDAOImpl extends LocalizeDAOImpl<Seguimento> implements SeguimentoDAO {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 6176787429672126400L;

	/**
	 * Método responsável por retornar uma lista de Seguimento através do tipoServiço
	 *
	 * @author Rogério Gomes
	 *
	 * @return Collection<Seguimento>
	 */
	@SuppressWarnings("unchecked")
	public Collection<SeguimentoDTO> listarSeguimentoPorTipoServico(final Long idTipoServico) {

		final Criteria criteria = this.createCriteria();
		
		criteria.createAlias("tipoServico", "tipoServico");

		criteria.add(Restrictions.eq("tipoServico.id", idTipoServico));
		
		final ProjectionList projList = Projections.projectionList();

		projList.add(Projections.property("id"), "id");

		projList.add(Projections.property("descricao"), "descricao");

		criteria.setProjection(Projections.distinct(projList)).setResultTransformer(Transformers.aliasToBean(SeguimentoDTO.class));

		return criteria.list();

	}


}
