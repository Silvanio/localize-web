package br.com.web.localize.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.localize.exceptions.NegocioException;
import br.com.web.arquitetura.persistencia.DAO;
import br.com.web.localize.arquitetura.comum.UtilObjeto;
import br.com.web.localize.arquitetura.comum.UtilString;
import br.com.web.localize.arquitetura.service.Service;
import br.com.web.localize.modelo.dto.LocalizacaoDTO;
import br.com.web.localize.modelo.entidade.Localizacao;
import br.com.web.localize.persistencia.LocalizacaoDAO;
import br.com.web.localize.service.util.UtilGeometry;

/**
 * <p>
 * <b>Title:</b> LocalizacaoServiceImpl.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> LocalizacaoServiceImpl
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - Localize TI.
 * </p>
 * 
 * @author Silânio Júnior
 * 
 * @version 1.0.0
 */
@Transactional
@org.springframework.stereotype.Service
public class LocalizacaoService extends Service<Localizacao, LocalizacaoDAO> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -3332216143778766487L;

	@Autowired
	/** Atributo dao. */
	private LocalizacaoDAO dao;

	/**
	 * Descrição Padrão: <br>
	 * Salvar Localizacao<br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.web.localize.arquitetura.service.Service#salvar(br.com.web.localize.arquitetura.modelo.Entidade)
	 */
	@Override
	public Localizacao salvar(final Localizacao entidade) {

		this.validarSalvar(entidade);

		final LocalizacaoDTO localizacao = this.dao.obterLocalizacaoPorIdFornecedor(entidade.getFornecedor().getId());

		entidade.setLocalizacao(UtilGeometry.converterEmPoint(entidade.getLongitude(), entidade.getLatitude()));

		if (UtilObjeto.isNotNull(localizacao)) {

			entidade.setId(localizacao.getId());

			return this.dao.merge(entidade);
		}

		return this.dao.salvar(entidade);
	}

	/**
	 * Descrição Padrão: <br>
	 * Método responsável por validar Localizacao<br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.web.localize.arquitetura.service.Service#validarSalvar(br.com.web.localize.arquitetura.modelo.Entidade)
	 */
	@Override
	protected void validarSalvar(final Localizacao entidade) {

		if (UtilObjeto.isNull(entidade) || UtilString.isEmpty(entidade.getLatitude()) || UtilString.isEmpty(entidade.getLongitude()) || UtilString.isEmpty(entidade.getDescricao())) {

			throw new NegocioException("É obrigatório infomar a localização");

		}

	}

	/**
	 * Método responsável por a localizacao pelo id do fornecedor.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param idFornecedor
	 * 
	 * @return LocalizacaoDTO
	 */
	public LocalizacaoDTO obterLocalizacaoPorIdFornecedor(final Long idFornecedor) {

		return this.dao.obterLocalizacaoPorIdFornecedor(idFornecedor);
	}

	/**
	 * Descrição Padrão: <br>
	 * obter instancia do DAO<br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.web.localize.arquitetura.service.Service#getDao()
	 */
	@Override
	public DAO<Localizacao> getDao() {

		return this.dao;
	}

}
