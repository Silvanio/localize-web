package br.com.web.localize.persistencia;

import java.util.Collection;

import br.com.web.arquitetura.persistencia.DAO;
import br.com.web.localize.modelo.dto.SeguimentoDTO;
import br.com.web.localize.modelo.entidade.Seguimento;

/**
 * <p>
 * <b>Title:</b> SeguimentoDAO
 * </p>
 * 
 * <p>
 * <b>Description:</b>Interface da camada de persistência da Entidade <code>Seguimento</code>
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
public interface SeguimentoDAO extends DAO<Seguimento> {
	
	/**
	 * Método responsável por retornar uma lista de Seguimento através do tipoServiço
	 *
	 * @author Rogério Gomes
	 *
	 * @return Collection<Seguimento>
	 */
	Collection<SeguimentoDTO> listarSeguimentoPorTipoServico(final Long idTipoServico);

}
