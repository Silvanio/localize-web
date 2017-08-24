package br.com.web.localize.persistencia.impl;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.spatial.criterion.SpatialRestrictions;
import org.springframework.stereotype.Repository;

import br.com.web.localize.modelo.entidade.Fornecedor;
import br.com.web.localize.persistencia.FornecedorDAO;

import com.vividsolutions.jts.geom.Geometry;

/**
 * <p>
 * <b>Title:</b> FornecedorDAOImpl
 * </p>
 * 
 * <p>
 * <b>Description:</b>Classe de persistencia da entidade<code>Fornecedor</code>
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
public class FornecedorDAOImpl extends LocalizeDAOImpl<Fornecedor> implements FornecedorDAO {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -2896313573857978565L;

	/**
	 * Descrição Padrão: <br>
	 * Método responsável por retornar uma lista de fornecedores por figura geometrica. <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.localize.persistencia.facade.FornecedorDAO#listarFornecedorPorFiguraGeometrica(com.vividsolutions.jts.geom.Geometry)
	 */
	@Override
	public Collection<Fornecedor> listarFornecedorPorFiguraGeometrica(final Long idTipoServico, final Geometry circulo) {

		final Criteria criteria = this.createCriteria();

		criteria.createAlias("localizacao", "localizacao");

		criteria.createAlias("dadosServico", "dadosServico");

		criteria.createAlias("dadosServico.seguimentos", "seguimentos");

		criteria.createAlias("seguimentos.tipoServico", "tipoServico");

		criteria.add(Restrictions.eq("tipoServico.id", idTipoServico));

		criteria.add(SpatialRestrictions.within("localizacao.localizacao", circulo));
		
		criteria.add(Restrictions.eq("publicar", true));

		return this.consultar(criteria);
	}

	@Override
	public Fornecedor obterPorCnpjESenha(final String cnpj, final String senha) {

		final Criteria criteria = this.createCriteria();

		criteria.createAlias("informacoes", "informacoes");

		criteria.add(Restrictions.eq("informacoes.cnpj", cnpj));

		criteria.add(Restrictions.eq("informacoes.senha", senha));

		return this.obter(criteria);
	}

	@Override
	public Fornecedor obterPorCnpj(String cnpj) {

		final Criteria criteria = this.createCriteria();

		criteria.createAlias("informacoes", "informacoes");

		criteria.add(Restrictions.eq("informacoes.cnpj", cnpj));

		return this.obter(criteria);
	}

}
