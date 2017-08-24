package br.com.web.localize.apresentacao.rest;

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
import br.com.web.localize.modelo.dto.LocalizacaoDTO;
import br.com.web.localize.modelo.entidade.Localizacao;
import br.com.web.localize.service.impl.FornecedorService;
import br.com.web.localize.service.impl.LocalizacaoService;

/**
 * <p>
 * <b>Title:</b> WsMobile.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Serviço para WsLocalizacao.
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
@Path("/wslocalizacao")
@Component
public class WsLocalizacao extends WsLocalize {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 7349909819395728563L;

	@Autowired
	/** Atributo tipoServico. */
	private LocalizacaoService service;
	@Autowired
	/** Atributo tipoServico. */
	private FornecedorService fornecedorService;

	/**
	 * Método responsável por registrar o fornecedor.
	 *
	 * @author Silvânio Júnior
	 *
	 * @return <code>String</code> Mensagem.
	 */
	@POST
	@Path("/abrirLocalizacao")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public LocalizacaoDTO abrirLocalizacao(@Context final HttpServletRequest request) {
		
		return this.service.obterLocalizacaoPorIdFornecedor(getFornecedorLogado(request).getId());
		
	}

	/**
	 * Método responsável salvar a localidade.
	 *
	 * @author Silvânio Júnior
	 *
	 * @return <code>String</code> Mensagem.
	 */
	@POST
	@Path("/salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Mensagem salvar(LocalizacaoDTO localizacaoDTO,@Context final HttpServletRequest request) {
		
		try{
			Localizacao localizacao = new Localizacao();
			
			localizacao.setFornecedor(fornecedorService.obter(getFornecedorLogado(request).getId()));
			
			localizacao.setLatitude(localizacaoDTO.getLatitude());
			
			localizacao.setLongitude(localizacaoDTO.getLongitude());
			
			localizacao.setDescricao(localizacaoDTO.getDescricao());
			
			service.salvar(localizacao);

			Mensagem mensagem = new Mensagem(MensagemEnum.SUCESS, MensagemEnum.SUCESS.getDescricao());
			
			return mensagem;

		}catch(NegocioException e){
			
			Mensagem mensagem = new Mensagem(MensagemEnum.INFO, e.getMessage());
			
			return mensagem;
			
			
		}
		
	}

}
