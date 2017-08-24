package br.com.web.localize.persistencia;

import br.com.web.arquitetura.persistencia.DAO;
import br.com.web.localize.modelo.entidade.Fornecedor;
import br.com.web.localize.modelo.entidade.Informacoes;


/**
 * <p>
 * <b>Title:</b> FornecedorDAO
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - Rogério Gomes
 * </p>
 * 
 * @author Silvânio Júnior
 * 
 * @version 1.0.0
 */
public interface InformacoesDAO extends DAO<Informacoes> {

	/**
	 * Método responsável por obter Fornecedor por cnpj.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param cnpj
	 * 
	 * @return Fornecedor
	 */
	Informacoes obterPorCnpj(String cnpj);

	Informacoes obterPorIdFornecedor(Fornecedor entidade);


}
