package br.com.web.localize.persistencia;

import java.util.Collection;
import java.util.List;

import br.com.web.arquitetura.persistencia.DAO;
import br.com.web.localize.modelo.dto.TipoServicoDTO;
import br.com.web.localize.modelo.entidade.TipoServico;

/**
 * <p>
 * <b>Title:</b> TipoServicoDAO
 * </p>
 * 
 * <p>
 * <b>Description:</b>Interface da camada de persistência da Entidade <code>TipoServico</code>
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
public interface TipoServicoDAO extends DAO<TipoServico> {

	/**
	 * Método responsável por listar os tipos serviços.
	 *
	 * @author silvanio
	 *
	 * @return <code>Collection</code>
	 */
	Collection<TipoServicoDTO> listarTipoServico();

	/**
	 * Método responsável por listar os tipos servicos pelo id do fornecedor.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param idFornecedor
	 * 
	 * @return List
	 */
	List<TipoServicoDTO> listarPorIdFornecedor(Long idFornecedor);

}
