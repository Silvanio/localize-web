package br.com.web.localize.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.web.localize.arquitetura.service.Service;
import br.com.web.localize.modelo.dto.SeguimentoDTO;
import br.com.web.localize.modelo.dto.TipoServicoDTO;
import br.com.web.localize.modelo.entidade.TipoServico;
import br.com.web.localize.persistencia.SeguimentoDAO;
import br.com.web.localize.persistencia.TipoServicoDAO;

/**
 * <p>
 * <b>Title:</b> TipoServicoService.java
 * </p>
 * 
 * <p>
 * <b>Description:</b>Clase de Servico para TipoServico.
 * </p>
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
public class TipoServicoService extends Service<TipoServico, TipoServicoDAO> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -6164402589444981331L;

	@Autowired
	/** Atributo dao. */
	private TipoServicoDAO dao;

	@Autowired
	/** Atributo dao. */
	private SeguimentoDAO seguimentoDAO;;
	

	/**
	 * Método responsável por listar tipo de servico.
	 *
	 * @author Silvânio Júnior
	 *
	 * @return <code>Collection</code>
	 */
	public Collection<TipoServicoDTO> listarTipoServico() {

		return this.dao.listarTipoServico();
	}

	/**
	 * Método responsável por listar o tipo servico.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param idTipoServico
	 * 
	 * @return <code>Collection</code>
	 */
	public Collection<SeguimentoDTO> listarSeguimentoPorTipoServico(final Long idTipoServico) {

		return this.seguimentoDAO.listarSeguimentoPorTipoServico(idTipoServico);

	}

	@Override
	public TipoServicoDAO getDao() {

		return this.dao;
	}

}
