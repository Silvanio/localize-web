package br.com.web.localize.persistencia.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.web.localize.modelo.entidade.Fornecedor;
import br.com.web.localize.modelo.entidade.Informacoes;
import br.com.web.localize.persistencia.InformacoesDAO;

/**
 * <p>
 * <b>Title:</b> FornecedorDAOImpl
 * </p>
 * 
 * <p>
 * <b>Description:</b>Classe de persistencia da entidade<code>Informacoes</code>
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software
 * </p>
 * 
 * @author Silvânio Júnior
 * 
 * @version 1.0.0
 */
@Repository
public class InformacoesDAOImpl extends LocalizeDAOImpl<Informacoes> implements InformacoesDAO {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -2896313573857978565L;

	@Override
	public Informacoes obterPorCnpj(String cnpj) {
		
		Criteria criteria = this.createCriteria();
		
		criteria.add(Restrictions.eq("cnpj", cnpj));

		return this.obter(criteria);
	}

	@Override
	public Informacoes obterPorIdFornecedor(Fornecedor entidade) {
	
		Criteria criteria = this.createCriteria();
		
		criteria.createAlias("fornecedor", "fornecedor");
		
		criteria.add(Restrictions.eq("fornecedor.id", entidade.getId()));
		
		return this.obter(criteria);
	}




}
