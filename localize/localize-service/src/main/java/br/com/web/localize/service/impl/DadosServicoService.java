package br.com.web.localize.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.localize.exceptions.NegocioException;
import br.com.web.localize.arquitetura.comum.UtilColecao;
import br.com.web.localize.arquitetura.comum.UtilObjeto;
import br.com.web.localize.arquitetura.service.Service;
import br.com.web.localize.modelo.dto.DadosServicoDTO;
import br.com.web.localize.modelo.dto.SeguimentoDTO;
import br.com.web.localize.modelo.dto.TipoServicoDTO;
import br.com.web.localize.modelo.entidade.DadosServico;
import br.com.web.localize.modelo.entidade.Fornecedor;
import br.com.web.localize.modelo.entidade.Seguimento;
import br.com.web.localize.persistencia.DadosServicoDAO;
import br.com.web.localize.persistencia.FornecedorDAO;
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
public class DadosServicoService extends Service<DadosServico, DadosServicoDAO> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -6164402589444981331L;

	@Autowired
	/** Atributo dao. */
	private DadosServicoDAO dao;

	@Autowired
	/** Atributo dao. */
	private SeguimentoDAO seguimentoDao;

	@Autowired
	/** Atributo dao. */
	private FornecedorDAO fornecedorDao;

	@Autowired
	/** Atributo dao. */
	private TipoServicoDAO tipoServicoDao;

	public void salvar(DadosServicoDTO dadosServicoDTO) {

		validarSalvar(dadosServicoDTO);

		removerSeguimentosInvalidos(dadosServicoDTO);

		DadosServico dadosServico = dao.obterPorFornecedor(dadosServicoDTO.getIdFornecedor());

		DadosServico novoDadosServico = montarDadosServico(dadosServicoDTO);

		if (UtilObjeto.isNotNull(dadosServico)) {

			for (Seguimento seguimento : dadosServico.getSeguimentos()) {

				if (!seguimento.getTipoServico().getId().equals(dadosServicoDTO.getTipoServico().getId())) {

					novoDadosServico.getSeguimentos().add(seguimento);

				}
			}

			dadosServico.setSeguimentos(novoDadosServico.getSeguimentos());

			dao.merge(dadosServico);

		} else {

			Fornecedor fornecedor = fornecedorDao.obter(novoDadosServico.getFornecedor().getId());

			novoDadosServico.setFornecedor(fornecedor);

			dao.salvar(novoDadosServico);
		}

	}

	/**
	 * Método responsável por remover seguimentos inválidos.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param seguimentosSelecionados
	 */
	private void removerSeguimentosInvalidos(DadosServicoDTO dadosServicoDTO) {

		List<SeguimentoDTO> seguimentos = new ArrayList<SeguimentoDTO>();

		for (SeguimentoDTO dto : dadosServicoDTO.getSeguimentosSelecionados()) {

			if (!seguimentos.contains(dto)) {

				seguimentos.add(dto);
			}

		}
		dadosServicoDTO.setSeguimentosSelecionados(seguimentos);
	}

	/**
	 * Método responsável por validar dados servicos.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param dadosServicoDTO
	 */
	private void validarSalvar(DadosServicoDTO dadosServicoDTO) {

		if (UtilObjeto.isNull(dadosServicoDTO) || UtilObjeto.isNull(dadosServicoDTO.getTipoServico()) || UtilObjeto.isNull(dadosServicoDTO.getTipoServico().getId())) {

			throw new NegocioException("O Campo Tipo Serviço é Obrigatório");

		}

		if (UtilObjeto.isNull(dadosServicoDTO) || UtilColecao.isEmpty(dadosServicoDTO.getSeguimentosSelecionados())|| UtilObjeto.isNull(UtilColecao.getElementoDoIndice(dadosServicoDTO.getSeguimentosSelecionados(), 0).getId())) {

			throw new NegocioException("Informe pelomenos um seguimento");

		}

	}

	/**
	 * Método responsável por montar os dados Servico.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param dadosServicoDTO
	 * 
	 * @return DadosServico
	 */
	private DadosServico montarDadosServico(DadosServicoDTO dadosServicoDTO) {

		DadosServico dadosServico = new DadosServico();

		List<Seguimento> seguimentos = new ArrayList<Seguimento>();

		if (!UtilColecao.isEmpty(dadosServicoDTO.getSeguimentosSelecionados())) {

			for (SeguimentoDTO dto : dadosServicoDTO.getSeguimentosSelecionados()) {

				Seguimento seguimento = new Seguimento();

				seguimento.setId(dto.getId());

				seguimento.setDescricao(dto.getDescricao());

				seguimento.setTipoServico(tipoServicoDao.obter(dadosServicoDTO.getTipoServico().getId()));

				seguimentos.add(seguimento);
			}

		}

		Fornecedor fornecedor = new Fornecedor();

		fornecedor.setId(dadosServicoDTO.getIdFornecedor());

		dadosServico.setFornecedor(fornecedor);

		dadosServico.setSeguimentos(seguimentos);

		return dadosServico;
	}

	/**
	 * Método responsável por listar os tipos servicos do dados servico.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param fornecedorLogado
	 * 
	 * @return
	 */
	public Collection<TipoServicoDTO> listarTipoServicoPorDadosServico(Fornecedor fornecedorLogado) {

		DadosServico dadosServico = dao.obterPorFornecedor(fornecedorLogado.getId());

		if (UtilObjeto.isNotNull(dadosServico) && !UtilColecao.isEmpty(dadosServico.getSeguimentos())) {

			List<TipoServicoDTO> tipoServicoDtoList = tipoServicoDao.listarPorIdFornecedor(fornecedorLogado.getId());

			return tipoServicoDtoList;

		}

		return null;
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
	public void excluirDadosServicoPorTipoServicoEFornecedor(Long idTipoServico, Long idFornecedor) {

		DadosServico entidade = dao.obterDadoServicoPorTipoServicoEFornecedor(idTipoServico, idFornecedor);

		if (UtilObjeto.isNotNull(entidade) && !UtilColecao.isEmpty(entidade.getSeguimentos())) {

			List<Seguimento> seguimentos = new ArrayList<Seguimento>();

			for (Seguimento seguimento : entidade.getSeguimentos()) {

				if (!idTipoServico.equals(seguimento.getTipoServico().getId())) {

					seguimentos.add(seguimento);

				}

			}

			entidade.setSeguimentos(seguimentos);
			
			if(UtilColecao.isEmpty(seguimentos)){
				
				throw new NegocioException("Não é possível excluir todos seguimentos");
				
			}

			dao.merge(entidade);

		}

	}

	public DadosServicoDTO obterDadosServico(Long idTipoServico, Long idFornecedor) {

		DadosServico entidade = dao.obterDadoServicoPorTipoServicoEFornecedor(idTipoServico, idFornecedor);

		DadosServicoDTO dto = new DadosServicoDTO();

		dto.setSeguimentosSelecionados(new ArrayList<SeguimentoDTO>());

		dto.setIdFornecedor(idFornecedor);

		if (UtilObjeto.isNotNull(entidade) && !UtilColecao.isEmpty(entidade.getSeguimentos())) {

			for (Seguimento seguimento : entidade.getSeguimentos()) {

				if (idTipoServico.equals(seguimento.getTipoServico().getId())) {

					SeguimentoDTO seguimentoDto = new SeguimentoDTO();

					seguimentoDto.setId(seguimento.getId());

					seguimentoDto.setDescricao(seguimento.getDescricao());

					dto.getSeguimentosSelecionados().add(seguimentoDto);

					TipoServicoDTO tipoServicoDTO = new TipoServicoDTO();

					tipoServicoDTO.setId(seguimento.getTipoServico().getId());

					tipoServicoDTO.setNome(seguimento.getTipoServico().getDescricao());

					dto.setTipoServico(tipoServicoDTO);
				}

			}

		}

		return dto;
	}

	@Override
	public DadosServicoDAO getDao() {

		return this.dao;
	}

}
