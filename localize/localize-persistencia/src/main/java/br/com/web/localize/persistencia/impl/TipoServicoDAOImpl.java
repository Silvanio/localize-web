package br.com.web.localize.persistencia.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import br.com.web.localize.modelo.dto.TipoServicoDTO;
import br.com.web.localize.modelo.entidade.TipoServico;
import br.com.web.localize.persistencia.TipoServicoDAO;

/**
 * <p>
 * <b>Title:</b> TipoServicoDAOImpl
 * </p>
 * 
 * <p>
 * <b>Description:</b>Classe de persistencia da entidade<code>TipoServico</code>
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software
 * </p>
 * 
 * @author Rogério Gomes
 * 
 * @version 1.0.0
 */
@Repository
public class TipoServicoDAOImpl extends LocalizeDAOImpl<TipoServico> implements TipoServicoDAO {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1392840926487151738L;


	/**
	 * Método responsável por listar os tipos serviços.
	 *
	 * @author silvanio
	 *
	 * @return <code>Collection</code>
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Collection<TipoServicoDTO> listarTipoServico() {

		final Criteria criteria = this.createCriteria();

		final ProjectionList projList = Projections.projectionList();

		projList.add(Projections.property("id"), "id");

		projList.add(Projections.property("descricao"), "nome");

		projList.add(Projections.property("identificadorImagem"), "identificadorImagem");

		projList.add(Projections.property("identificadorPainel"), "identificadorPainel");

		criteria.setProjection(Projections.distinct(projList)).setResultTransformer(Transformers.aliasToBean(TipoServicoDTO.class));

		return criteria.list();
	}


	/**
	 * Descrição Padrão: <br>Método responsável por listar os tipos servicos selecionados em fornecedor. <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.web.localize.persistencia.TipoServicoDAO#listarPorIdFornecedor(java.lang.Long)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<TipoServicoDTO> listarPorIdFornecedor(Long id) {
		
		final Criteria criteria = this.createCriteria();

		criteria.createAlias("seguimentos", "seguimentos");
		
		criteria.createAlias("seguimentos.dadosServicoList", "dadosServicoList");
		
		criteria.createAlias("dadosServicoList.fornecedor", "fornecedor");

		criteria.add(Restrictions.eq("fornecedor.id", id));
		
		final ProjectionList projList = Projections.projectionList();

		projList.add(Projections.property("id"), "id");

		projList.add(Projections.property("descricao"), "nome");

		projList.add(Projections.property("identificadorImagem"), "identificadorImagem");

		projList.add(Projections.property("identificadorPainel"), "identificadorPainel");

		criteria.setProjection(Projections.distinct(projList)).setResultTransformer(Transformers.aliasToBean(TipoServicoDTO.class));

		return criteria.list();
	}

}
