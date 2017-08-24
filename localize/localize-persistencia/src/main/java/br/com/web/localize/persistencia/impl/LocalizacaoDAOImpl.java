package br.com.web.localize.persistencia.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import br.com.web.localize.modelo.dto.LocalizacaoDTO;
import br.com.web.localize.modelo.entidade.Localizacao;
import br.com.web.localize.persistencia.LocalizacaoDAO;

/**
 * <p>
 * <b>Title:</b> LocalizacaoDAOImpl
 * </p>
 * 
 * <p>
 * <b>Description:</b>Classe de persistencia da entidade<code>Localizacao</code>
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - Localize TI.
 * </p>
 * 
 * @author Silvânio Júnior
 * 
 * @version 1.0.0
 */
@Repository
public class LocalizacaoDAOImpl extends LocalizeDAOImpl<Localizacao> implements LocalizacaoDAO {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 6176787429672126400L;

	/**
	 * Método responsável por a localizacao pelo id do fornecedor.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param idFornecedor
	 * 
	 * @return LocalizacaoDTO
	 */
	@Override
	public LocalizacaoDTO obterLocalizacaoPorIdFornecedor(Long idFornecedor) {

		Criteria criteria = this.createCriteria();
		
		criteria.createAlias("fornecedor", "fornecedor");
		
		criteria.add(Restrictions.eq("fornecedor.id",idFornecedor));
		
		final ProjectionList projList = Projections.projectionList();

		projList.add(Projections.property("id"), "id");

		projList.add(Projections.property("latitude"), "latitude");

		projList.add(Projections.property("longitude"), "longitude");

		projList.add(Projections.property("descricao"), "descricao");

		criteria.setProjection(Projections.distinct(projList)).setResultTransformer(Transformers.aliasToBean(LocalizacaoDTO.class));

		criteria.setMaxResults(1);
		
		return (LocalizacaoDTO) criteria.uniqueResult();
	}

}
