package br.com.web.localize.apresentacao.rest;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.web.localize.modelo.dto.FornecedorDTO;
import br.com.web.localize.modelo.dto.TipoServicoDTO;
import br.com.web.localize.service.impl.FornecedorService;

/**
 * <p>
 * <b>Title:</b> WsMobile.java
 * </p>
 * 
 * <p>
 * <b>Description:</b>
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
@Path("/wsmobile")
@Component
public class WsMobile {

	@Autowired
	/** Atributo service. */
	private FornecedorService service;

	@GET
	@Path("/obterdados/{idTipoServico}/{longitude}/{latitude}/{raio}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<FornecedorDTO> obterDados(@PathParam("idTipoServico") final Long idTipoServico, @PathParam("longitude") final double longitude, @PathParam("latitude") final double latitude, @PathParam("raio") final int raio) {

		return this.service.listarFornecedorPorFiguraGeometrica(idTipoServico, latitude, longitude, raio);

	}

	@GET
	@Path("/listarTipoServico")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Collection<TipoServicoDTO> listarTipoServico() {	

		return this.service.listarTipoServicos();

	}


	/**
	 * Retorna o valor do atributo <code>service</code>
	 *
	 * @return <code>ManterFornecedorService</code>
	 */
	public FornecedorService getService() {

		return this.service;
	}

	/**
	 * Define o valor do atributo <code>service</code>.
	 *
	 * @param service
	 */
	public void setService(final FornecedorService service) {

		this.service = service;
	}

}
