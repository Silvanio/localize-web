package br.com.web.localize.persistencia;

import br.com.web.arquitetura.persistencia.DAO;
import br.com.web.localize.modelo.entidade.DadosServico;

/**
 * <p>
 * <b>Title:</b> TipoServicoDAO
 * </p>
 * 
 * <p>
 * <b>Description:</b>Interface da camada de persistência da Entidade <code>DadosServicoDAO</code>
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - Rogério Gomes
 * </p>
 * 
 * @author Silvanio
 * 
 * @version 1.0.0
 */
public interface DadosServicoDAO extends DAO<DadosServico> {

	/**
	 * Método responsável por obter os dados servico por fornecedor.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param idFornecedor
	 * 
	 * @return
	 */
	public DadosServico obterPorFornecedor(Long idFornecedor);
	/**
	 * Método responsável por excluir dadosServico.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param idTipoServico
	 * 
	 * @param id
	 */
	public DadosServico obterDadoServicoPorTipoServicoEFornecedor(Long idTipoServico, Long idFornecedor);


}
