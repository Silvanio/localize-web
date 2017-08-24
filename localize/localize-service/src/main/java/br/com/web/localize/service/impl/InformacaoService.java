package br.com.web.localize.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.localize.exceptions.NegocioException;
import br.com.web.localize.arquitetura.comum.UtilCPFCNPJ;
import br.com.web.localize.arquitetura.comum.UtilObjeto;
import br.com.web.localize.arquitetura.comum.UtilString;
import br.com.web.localize.arquitetura.service.Service;
import br.com.web.localize.modelo.entidade.Informacoes;
import br.com.web.localize.persistencia.InformacoesDAO;


/**
 * <p>
 * <b>Title:</b> InformacaoService.java
 * </p>
 * 
 * <p>
 * <b>Description:</b>
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
@Transactional
@org.springframework.stereotype.Service
public class InformacaoService extends Service<Informacoes, InformacoesDAO>{

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -4125555458539394034L;
	
	@Autowired
	/** Atributo informacoesDAO. */
	private InformacoesDAO informacoesDAO;
	
	@Override
	public void alterar(Informacoes entidade) {
		super.alterar(entidade);
	}
	
	@Override
	protected void validarAlterar(Informacoes entidade) {

		if (UtilObjeto.isNull(entidade) || UtilString.isEmpty(entidade.getNomeFantasia(), entidade.getCnpj(), entidade.getEmail(), entidade.getSenha())) {

			throw new NegocioException("Campos obrigatórios não informados");

		}
		
		if(!UtilCPFCNPJ.isValid(entidade.getCnpj())){
			
			throw new NegocioException("CNPJ Inválido.");
			
		}

		Informacoes entidadeOld = this.getDao().obterPorCnpj(entidade.getCnpj());

		if(UtilObjeto.isNotNull(entidadeOld) && !entidadeOld.getCnpj().equals(entidade.getCnpj())){
			
			throw new NegocioException("CNPJ existente.");
			
		}
	}
	
	

	/**
	 * Descrição Padrão: <br> Informacoes<br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.web.localize.arquitetura.service.Service#getDao()
	 */
	@Override
	public InformacoesDAO getDao() {

		return informacoesDAO;
	}

}
