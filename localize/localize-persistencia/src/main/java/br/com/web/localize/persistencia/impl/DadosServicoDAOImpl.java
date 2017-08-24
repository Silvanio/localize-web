package br.com.web.localize.persistencia.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.web.localize.modelo.entidade.DadosServico;
import br.com.web.localize.persistencia.DadosServicoDAO;

/**
 * <p>
 * <b>Title:</b> TipoServicoDAOImpl
 * </p>
 * 
 * <p>
 * <b>Description:</b>Classe de persistencia da entidade<code>DadosServicoDAOImpl</code>
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software
 * </p>
 * 
 * @author Silvanio
 * 
 * @version 1.0.0
 */
@Repository
public class DadosServicoDAOImpl extends LocalizeDAOImpl<DadosServico> implements DadosServicoDAO {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1392840926487151738L;

	@Override
	public DadosServico obterPorFornecedor(Long idFornecedor) {

		Criteria criteria = this.createCriteria();
		
		criteria.createAlias("fornecedor", "fornecedor");
		
		criteria.add(Restrictions.eq("fornecedor.id", idFornecedor));
		
		return this.obter(criteria);
	}
	/**
	 * Método responsável por excluir dadosServico.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param idTipoServico
	 * 
	 * @param id
	 */
	@Override
	public DadosServico obterDadoServicoPorTipoServicoEFornecedor(Long idTipoServico, Long idFornecedor) {
	
		Criteria criteria = this.createCriteria();
		
		criteria.createAlias("fornecedor", "fornecedor");

		criteria.createAlias("seguimentos", "seguimentos");

		criteria.createAlias("seguimentos.tipoServico", "tipoServico");
		
		criteria.add(Restrictions.eq("fornecedor.id", idFornecedor));

		criteria.add(Restrictions.eq("tipoServico.id", idTipoServico));
		
		return this.obter(criteria);
	}


}
