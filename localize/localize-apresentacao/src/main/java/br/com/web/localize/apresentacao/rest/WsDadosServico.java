package br.com.web.localize.apresentacao.rest;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.localize.exceptions.NegocioException;
import br.com.web.localize.apresentacao.util.Mensagem;
import br.com.web.localize.apresentacao.util.MensagemEnum;
import br.com.web.localize.modelo.dto.DadosServicoDTO;
import br.com.web.localize.modelo.dto.SeguimentoDTO;
import br.com.web.localize.modelo.dto.TipoServicoDTO;
import br.com.web.localize.service.impl.DadosServicoService;
import br.com.web.localize.service.impl.TipoServicoService;

/**
 * <p>
 * <b>Title:</b> WsMobile.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Serviço para WsTipoServico.
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software Localize TI.
 * </p>
 * 
 * @author Silvânio Júnior
 * 
 * @version 1.0.0
 */
@Path("/wsdadosservico")
@Component
public class WsDadosServico extends WsLocalize {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 7349909819395728563L;

	@Autowired
	/** Atributo tipoServico. */
	private TipoServicoService service;

	@Autowired
	/** Atributo tipoServico. */
	private DadosServicoService dadosService;

	/**
	 * Método responsável por registrar o fornecedor.
	 *
	 * @author Silvânio Júnior
	 *
	 * @return <code>String</code> Mensagem.
	 */
	@POST
	@Path("/listarDadosServicos")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<TipoServicoDTO> listarDadosServicos(@Context final HttpServletRequest request) {
		
		return this.dadosService.listarTipoServicoPorDadosServico(getFornecedorLogado(request));
		
	}
	/**
	 * Método responsável por registrar o fornecedor.
	 *
	 * @author Silvânio Júnior
	 *
	 * @return <code>String</code> Mensagem.
	 */
	@POST
	@Path("/listarTipoServico")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<TipoServicoDTO> listarTipoServico() {

		return this.service.listarTipoServico();

	}

	/**
	 * Método responsável por registrar o fornecedor.
	 *
	 * @author Silvânio Júnior
	 *
	 * @return <code>String</code> Mensagem.
	 */
	@POST
	@Path("/listarSeguimento")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<SeguimentoDTO> listarSeguimentoPorTipoServico(long idTipoServico) {
		
		return this.service.listarSeguimentoPorTipoServico(idTipoServico);
		
	}

	/**
	 * Método responsável salvar os tipos de servico.
	 *
	 * @author Silvânio Júnior
	 *
	 * @return <code>String</code> Mensagem.
	 */
	@POST
	@Path("/salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Mensagem salvar(DadosServicoDTO dadosServicoForm,@Context final HttpServletRequest request) {
		
		try{
			
			dadosServicoForm.setIdFornecedor(getFornecedorLogado(request).getId());

			dadosService.salvar(dadosServicoForm);

			Mensagem mensagem = new Mensagem(MensagemEnum.SUCESS, MensagemEnum.SUCESS.getDescricao());
			
			return mensagem;

		}catch(NegocioException e){
			
			Mensagem mensagem = new Mensagem(MensagemEnum.INFO, e.getMessage());
			
			return mensagem;
			
			
		}
		
	}

	@POST
	@Path("/excluir")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Mensagem excluir(Long idTipoServico,@Context final HttpServletRequest request) {
		
		try{
			
			dadosService.excluirDadosServicoPorTipoServicoEFornecedor(idTipoServico,getFornecedorLogado(request).getId());
			
			Mensagem mensagem = new Mensagem(MensagemEnum.SUCESS, MensagemEnum.SUCESS.getDescricao());
			
			return mensagem;
			
		}catch(NegocioException e){
			
			Mensagem mensagem = new Mensagem(MensagemEnum.INFO, e.getMessage());
			
			return mensagem;
			
			
		}
		
	}

	@POST
	@Path("/abrirEditarDadosServico")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public DadosServicoDTO abrirEditarDadosServico(Long idTipoServico,@Context final HttpServletRequest request) {
		
			return dadosService.obterDadosServico(idTipoServico, getFornecedorLogado(request).getId());
			
	}


}
