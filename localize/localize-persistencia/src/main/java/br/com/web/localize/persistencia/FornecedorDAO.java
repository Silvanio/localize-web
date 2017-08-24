package br.com.web.localize.persistencia;

import java.util.Collection;

import br.com.web.arquitetura.persistencia.DAO;
import br.com.web.localize.modelo.entidade.Fornecedor;

import com.vividsolutions.jts.geom.Geometry;


/**
 * <p>
 * <b>Title:</b> FornecedorDAO
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
public interface FornecedorDAO extends DAO<Fornecedor> {

	Collection<Fornecedor> listarFornecedorPorFiguraGeometrica(Long idTipoServico, Geometry point);

	Fornecedor obterPorCnpjESenha(String cnpj, String senha);

	Fornecedor obterPorCnpj(String cnpj);

}
