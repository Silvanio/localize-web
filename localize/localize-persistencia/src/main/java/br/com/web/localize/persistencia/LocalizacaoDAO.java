package br.com.web.localize.persistencia;

import br.com.web.arquitetura.persistencia.DAO;
import br.com.web.localize.modelo.dto.LocalizacaoDTO;
import br.com.web.localize.modelo.entidade.Localizacao;

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
 * <b>Company: </b> Fábrica de Software - localize
 * </p>
 * 
 * @author Silvanio Junior
 * 
 * @version 1.0.0
 */
public interface LocalizacaoDAO extends DAO<Localizacao> {

	/**
	 * Método responsável por a localizacao pelo id do fornecedor.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param idFornecedor
	 * 
	 * @return LocalizacaoDTO
	 */
	LocalizacaoDTO obterLocalizacaoPorIdFornecedor(Long idFornecedor);

}
