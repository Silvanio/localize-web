package br.com.web.localize.apresentacao.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import br.com.web.localize.modelo.dto.TrocarSenhaDTO;
import br.com.web.localize.modelo.entidade.Fornecedor;
import br.com.web.localize.service.impl.FornecedorService;

/**
 * <p>
 * <b>Title:</b> WsRegistrar.java
 * </p>
 * 
 * <p>
 * <b>Description:</b>Serviço responsável por registrar fornecedor.
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
@Path("/wsregistrar")
@Component
public class WsRegistrar extends WsLocalize{

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -7465698533575522276L;
	
	@Autowired
	/** Atributo service. */
	private FornecedorService service;

	/**
	 * Método responsável por registrar o fornecedor.
	 *
	 * @author Silvânio Júnior
	 *
	 * @return <code>String</code> Mensagem.
	 */
	@POST
	@Path("/registrar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Mensagem registrar(Fornecedor fornecedor,@Context HttpServletRequest request	) {

		try {

			fornecedor = this.service.registrar(fornecedor);
			
			 HttpSession session = request.getSession();
			 
			 session.setAttribute("usuario", fornecedor);

			return new Mensagem(MensagemEnum.SUCESS, MensagemEnum.SUCESS.getDescricao());

		} catch (final NegocioException e) {

			return new Mensagem(MensagemEnum.INFO, e.getMessage());

		}

	}

	/**
	 * Método responsável por registrar o fornecedor.
	 *
	 * @author Silvânio Júnior
	 *
	 * @return <code>String</code> Mensagem.
	 */
	@POST
	@Path("/enviarEmailSenha")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Mensagem enviarEmailSenha(String cnpj) {
		
		try {
			
			String email = service.enviarSenhaPorEmail(cnpj);
			
			System.out.println(email);
			
			return new Mensagem(MensagemEnum.SUCESS, "Funcionalidade de enviar e-mail ainda não foi desenvolvida, sua nova senha é 'inicial01' " );
			
		} catch (final NegocioException e) {
			
			return new Mensagem(MensagemEnum.INFO, e.getMessage());
			
		}
		
	}

	/**
	 * Método responsável por registrar o fornecedor.
	 *
	 * @author Silvânio Júnior
	 *
	 * @return <code>String</code> Mensagem.
	 */
	@POST
	@Path("/logar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Mensagem logar(Fornecedor fornecedor,@Context HttpServletRequest request	) {
		
		try {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("usuario", this.service.logar(fornecedor.getInformacoes().getCnpj(),fornecedor.getInformacoes().getSenha()));
			
			return new Mensagem(MensagemEnum.SUCESS, MensagemEnum.SUCESS.getDescricao());
			
		} catch (final NegocioException e) {
			
			return new Mensagem(MensagemEnum.INFO, e.getMessage());
			
		}
		
	}
	
	/**
	 * Método responsável por deslogar do sistema
	 *
	 * @author Silvânio Júnior
	 *
	 * @param request
	 * 
	 * @return Mensagem.
	 */
	@POST
	@Path("/sair")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Mensagem logar(@Context HttpServletRequest request) {
		
			
			HttpSession session = request.getSession();
			
			session.invalidate();
			
			return new Mensagem(MensagemEnum.SUCESS, MensagemEnum.SUCESS.getDescricao());
		
	}

	@POST
	@Path("/trocarSenha")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Mensagem trocarSenha(TrocarSenhaDTO trocarSenhaDTO ,@Context HttpServletRequest request) {
		
		try {
			
			Fornecedor fornecedorLogado = getFornecedorLogado(request);
			
			this.service.trocarSenha(fornecedorLogado, trocarSenhaDTO);
			
			return new Mensagem(MensagemEnum.SUCESS, MensagemEnum.SUCESS.getDescricao());
			
		} catch (final NegocioException e) {
			
			return new Mensagem(MensagemEnum.INFO, e.getMessage());
			
		}
		
	}

}
