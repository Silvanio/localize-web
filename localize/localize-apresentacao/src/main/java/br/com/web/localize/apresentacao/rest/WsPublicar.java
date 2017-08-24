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
import br.com.web.localize.modelo.entidade.Fornecedor;
import br.com.web.localize.service.impl.FornecedorService;

/**
 * <p>
 * <b>Title:</b> WsPublicar.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> WsPublicar
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
@Path("/wspublicar")
@Component
public class WsPublicar extends WsLocalize {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 8798776254385161373L;

	@Autowired
	/** Atributo service. */
	private FornecedorService service;

	@POST
	@Path("/abrirPublicar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean abrirPublicar(@Context final HttpServletRequest request) {

		return service.obter(getFornecedorLogado(request).getId()).isPublicar();

	}

	@POST
	@Path("/salvar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Mensagem salvar(boolean publicar, @Context final HttpServletRequest request) {

		try {
			Fornecedor fornecedor =  service.obter(getFornecedorLogado(request).getId());

			fornecedor.setPublicar(publicar);

			service.salvarPublicacao(fornecedor);

			Mensagem mensagem = new Mensagem(MensagemEnum.SUCESS, MensagemEnum.SUCESS.getDescricao());

			return mensagem;

		} catch (NegocioException e) {

			Mensagem mensagem = new Mensagem(MensagemEnum.INFO, e.getMessage());

			return mensagem;

		}

	}
}
