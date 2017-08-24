package br.com.web.localize.service.impl;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.localize.exceptions.NegocioException;
import br.com.web.localize.arquitetura.comum.UtilCPFCNPJ;
import br.com.web.localize.arquitetura.comum.UtilColecao;
import br.com.web.localize.arquitetura.comum.UtilObjeto;
import br.com.web.localize.arquitetura.comum.UtilSecurity;
import br.com.web.localize.arquitetura.comum.UtilString;
import br.com.web.localize.arquitetura.service.Service;
import br.com.web.localize.modelo.dto.FornecedorDTO;
import br.com.web.localize.modelo.dto.LocalizacaoDTO;
import br.com.web.localize.modelo.dto.TipoServicoDTO;
import br.com.web.localize.modelo.dto.TrocarSenhaDTO;
import br.com.web.localize.modelo.entidade.Fornecedor;
import br.com.web.localize.modelo.entidade.Informacoes;
import br.com.web.localize.modelo.entidade.Seguimento;
import br.com.web.localize.modelo.entidade.TipoServico;
import br.com.web.localize.persistencia.FornecedorDAO;
import br.com.web.localize.persistencia.InformacoesDAO;
import br.com.web.localize.persistencia.LocalizacaoDAO;
import br.com.web.localize.persistencia.SeguimentoDAO;
import br.com.web.localize.persistencia.TipoServicoDAO;
import br.com.web.localize.service.util.UtilArquivo;
import br.com.web.localize.service.util.UtilGeometry;

import com.vividsolutions.jts.operation.distance.DistanceOp;

/**
 * <p>
 * <b>Title:</b> FornecedorService
 * </p>
 * 
 * <p>
 * <b>Description:</b>Classe responsável pela regra de negocio da entidade<code>Fornecedor</code>
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
@Transactional
@org.springframework.stereotype.Service
public class FornecedorService extends Service<Fornecedor, FornecedorDAO> {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1458997922803870209L;

	@Autowired
	/** Atributo dao. */
	private FornecedorDAO fornecedorDAO;

	@Autowired
	/** Atributo tipoServicoDAO. */
	private TipoServicoDAO tipoServicoDAO;

	@Autowired
	/** Atributo seguimentoDAO. */
	private SeguimentoDAO seguimentoDAO;

	@Autowired
	/** Atributo informacoesDAO. */
	private InformacoesDAO informacoesDAO;

	@Autowired
	/** Atributo informacoesDAO. */
	private LocalizacaoDAO localizacaoDAO;

	/**
	 * Descrição Padrão: <br>
	 * Salvar<br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.web.localize.arquitetura.service.Service#salvar(br.com.web.localize.arquitetura.modelo.Entidade)
	 */
	public Fornecedor salvarPublicacao(Fornecedor entidade) {

		if (entidade.isPublicar()) {

			validarInformacoes(entidade);

			validarTipoServico(entidade);

			validarLocalizacao(entidade);

		}

		return super.salvar(entidade);
	}

	private void validarLocalizacao(Fornecedor entidade) {

		LocalizacaoDTO localizacao = localizacaoDAO.obterLocalizacaoPorIdFornecedor(entidade.getId());

		if (UtilObjeto.isNull(localizacao) || UtilString.isEmpty(localizacao.getLatitude()) || UtilString.isEmpty(localizacao.getLongitude())) {

			throw new NegocioException("É necessário informar a localização para publicar.");

		}

	}

	private void validarTipoServico(Fornecedor entidade) {

		List<TipoServicoDTO> listaTipoServico = tipoServicoDAO.listarPorIdFornecedor(entidade.getId());

		if (UtilObjeto.isNull(listaTipoServico) || UtilColecao.isEmpty(listaTipoServico) || UtilObjeto.isNull(listaTipoServico.get(0))) {

			throw new NegocioException("É necessário informar pelomenos um Tipo de Serviço para publicar.");
		}

	}

	private void validarInformacoes(Fornecedor entidade) {

		Informacoes informacoes = informacoesDAO.obterPorIdFornecedor(entidade);

		if (UtilObjeto.isNull(informacoes) || UtilString.isEmpty(informacoes.getCnpj()) || UtilString.isEmpty(informacoes.getNomeFantasia()) || UtilString.isEmpty(informacoes.getCaminhoImagem())) {

			throw new NegocioException("Os seguintes itens são obrigatórios na aba informações: CNPJ, Nome Fantasia, Imagem.");
		}

	}

	/**
	 * Método responsável por trocar a senha.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param fornecedorLogado
	 * 
	 * @param trocarSenhaDTO
	 */
	public void trocarSenha(Fornecedor fornecedorLogado, TrocarSenhaDTO trocarSenhaDTO) {

		fornecedorLogado = validarNovaSenha(fornecedorLogado, trocarSenhaDTO);

		fornecedorLogado.getInformacoes().setSenha(UtilSecurity.cript(trocarSenhaDTO.getNovaSenha()));

		this.getDao().salvar(fornecedorLogado);

	}

	/**
	 * Método responsável por validar a nova senha.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param fornecedorLogado
	 * 
	 * @param trocarSenhaDTO
	 * 
	 * @return <code>Fornecedor</code>
	 */
	private Fornecedor validarNovaSenha(Fornecedor fornecedorLogado, TrocarSenhaDTO trocarSenhaDTO) {

		if (UtilString.isEmpty(trocarSenhaDTO.getSenha()) || UtilString.isEmpty(trocarSenhaDTO.getNovaSenha()) || UtilString.isEmpty(trocarSenhaDTO.getRepetirNovaSenha())) {

			throw new NegocioException("Campos obrigatórios não informado.");

		}

		String senha = UtilSecurity.cript(trocarSenhaDTO.getSenha());

		fornecedorLogado = getDao().obter(fornecedorLogado.getId());

		if (!fornecedorLogado.getInformacoes().getSenha().equals(senha)) {

			throw new NegocioException("Senha atual inválida..");

		}

		if (trocarSenhaDTO.getNovaSenha().length() < 5) {

			throw new NegocioException("Senha inválida.");

		}

		if (!trocarSenhaDTO.getNovaSenha().equals(trocarSenhaDTO.getRepetirNovaSenha())) {

			throw new NegocioException("Os Campos 'Nova senha' e 'Repetir Nova Senha' não correspodem.");

		}
		return fornecedorLogado;
	}

	/**
	 * Método responsável por registrar o fornecedor.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param fornecedor
	 */
	public Fornecedor registrar(final Fornecedor fornecedor) {

		this.validarRegistrar(fornecedor);

		String senha = UtilSecurity.cript(fornecedor.getInformacoes().getSenha());

		fornecedor.getInformacoes().setSenha(senha);

		return this.getDao().merge(fornecedor);

	}

	/**
	 * Método responsável por logar.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param cnpj
	 * @param senha
	 * @return
	 */
	public Fornecedor logar(String cnpj, String senha) {

		if (UtilString.isEmpty(cnpj) || UtilString.isEmpty(senha)) {

			throw new NegocioException("CNPJ e senha são obrigatórios.");

		}

		senha = UtilSecurity.cript(senha);

		Fornecedor fornecedor = this.getDao().obterPorCnpjESenha(cnpj, senha);

		if (UtilObjeto.isNull(fornecedor)) {

			throw new NegocioException("CNPJ e(ou) senha não encontrado(s) ");

		}

		return fornecedor;
	}

	/**
	 * Método responsável por enviar senha por e-mail.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param cnpj
	 * 
	 * @return <code>String</code> E-mail.
	 */
	public String enviarSenhaPorEmail(String cnpj) {

		Fornecedor fornecedor = this.getDao().obterPorCnpj(cnpj);

		if (fornecedor != null) {

			enviarEmailNovaSenha(fornecedor);

			this.getDao().salvar(fornecedor);

		} else {

			throw new NegocioException("CNPJ não encontrado na base de dados.");

		}

		return fornecedor.getInformacoes().getEmail();
	}

	/**
	 * Método responsável por enviar email com a nova senha.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param fornecedor
	 */
	private void enviarEmailNovaSenha(Fornecedor fornecedor) {

		fornecedor.getInformacoes().setSenha(UtilSecurity.cript("inicial01"));
	}

	/**
	 * Método responsável por validar antes de registrar.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param fornecedor
	 */
	private void validarRegistrar(final Fornecedor fornecedor) {

		final Informacoes informacoes = fornecedor.getInformacoes();

		if (UtilObjeto.isNull(informacoes) || UtilString.isEmpty(informacoes.getNomeFantasia(), informacoes.getCnpj(), informacoes.getEmail(), informacoes.getSenha())) {

			throw new NegocioException("Campos obrigatórios não informados");

		}

		if (!UtilCPFCNPJ.isValid(fornecedor.getInformacoes().getCnpj())) {

			throw new NegocioException("CNPJ Inválido.");

		}

		Informacoes informacoesOld = this.informacoesDAO.obterPorCnpj(fornecedor.getInformacoes().getCnpj());

		if (UtilObjeto.isNotNull(informacoesOld)) {

			throw new NegocioException("CNPJ existente.");

		}

	}

	/**
	 * Método responsável por listar os tipos serviços.
	 *
	 * @author silvanio
	 *
	 * @return <code>Collection</code>
	 */
	public Collection<TipoServicoDTO> listarTipoServicos() {

		return this.tipoServicoDAO.listarTipoServico();
	}

	/**
	 * Método responsável por listar o fornecedor que esteja dentro de uma figura geometrica.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param latitude
	 * 
	 * @param longitude
	 * 
	 * @param raio
	 */
	public Collection<FornecedorDTO> listarFornecedorPorFiguraGeometrica(final Long idTipoServico, final double latitude, final double longitude, final double raio) {

		final Collection<Fornecedor> fornecedorList = this.getDao().listarFornecedorPorFiguraGeometrica(idTipoServico, UtilGeometry.converterEmCirculo(longitude, latitude, UtilGeometry.convertKmEmGraus(raio)));

		return this.montarListaFornecedoresDTO(idTipoServico, latitude, longitude, fornecedorList);

	}

	/**
	 * Método responsável por receber os seguimentos pai.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param idSeguimentoPai
	 * 
	 * @return <code>Seguimento</code>
	 */
	public Seguimento obterSeguimentoPai(final Long idSeguimentoPai) {

		return this.getSeguimentoDAO().obter(idSeguimentoPai);
	}

	@Override
	public Fornecedor obter(Long id) {

		return super.obter(id);
	}

	/**
	 * Método responsável por montar a lista de fornecedores.
	 *
	 * @author silvanio
	 *
	 * @param latitude
	 * 
	 * @param longitude
	 * 
	 * @param fornecedorList
	 *            lista de fornecedores.
	 * 
	 * @return <code>Collection</code>
	 */
	private List<FornecedorDTO> montarListaFornecedoresDTO(final Long idTipoServico, final double latitude, final double longitude, final Collection<Fornecedor> fornecedorList) {

		final List<FornecedorDTO> dtos = new ArrayList<FornecedorDTO>();

		for (final Fornecedor fornecedor : fornecedorList) {

			final FornecedorDTO dto = new FornecedorDTO();

			dto.setEmail(fornecedor.getInformacoes().getEmail());

			dto.setEndereco(fornecedor.getLocalizacao().getDescricao());

			dto.setNome(fornecedor.getInformacoes().getNomeFantasia());

			dto.setTelefone(fornecedor.getInformacoes().getTelefone());

			File file = new File(fornecedor.getInformacoes().getCaminhoImagem());
			
			if(file.exists()){
				
				dto.setIcon(UtilArquivo.converterFileEmByteArray(file));
				
			}

			dto.setDescricao(fornecedor.getInformacoes().getDescricao());

			final Double distancia = DistanceOp.distance(UtilGeometry.converterEmPoint(longitude, latitude), fornecedor.getLocalizacao().getLocalizacao());

			final BigDecimal bd = new BigDecimal(UtilGeometry.convertGrausEmKm(distancia)).setScale(2, RoundingMode.HALF_EVEN);

			dto.setDistancia(bd.doubleValue());

			dtos.add(dto);

		}

		final Comparator<FornecedorDTO> comparator = new Comparator<FornecedorDTO>() {

			@Override
			public int compare(final FornecedorDTO fornecedor, final FornecedorDTO fornecedor1) {

				return fornecedor.getDistancia().compareTo(fornecedor1.getDistancia());

			}

		};

		Collections.sort(dtos, comparator);

		return dtos;
	}

	/**
	 * Retorna o valor do atributo <code>dao</code>
	 * 
	 * @return <code>FornecedorDAO</code>
	 */
	@Override
	public FornecedorDAO getDao() {

		return this.fornecedorDAO;
	}

	/**
	 * Método responsável por listar tipoServico
	 * 
	 * @author Rogério Gomes
	 * 
	 * @return Collection<TipoServico>
	 */
	public Collection<TipoServico> listarTipoServico() {

		return this.getTipoServicoDAO().listar();

	}

	/**
	 * Retorna o valor do atributo <code>tipoServicoDAO</code>
	 * 
	 * @return <code>TipoServicoDAO</code>
	 */
	public TipoServicoDAO getTipoServicoDAO() {

		return this.tipoServicoDAO;
	}

	/**
	 * Retorna o valor do atributo <code>seguimentoDAO</code>
	 * 
	 * @return <code>SeguimentoDAO</code>
	 */
	public SeguimentoDAO getSeguimentoDAO() {

		return this.seguimentoDAO;
	}

}
