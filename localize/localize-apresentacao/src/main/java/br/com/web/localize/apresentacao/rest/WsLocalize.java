package br.com.web.localize.apresentacao.rest;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import br.com.web.localize.modelo.entidade.Fornecedor;

/**
 * <p>
 * <b>Title:</b> WsLocalize.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe de arquitetura para os serviços.
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
public class WsLocalize implements Serializable{

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 7686002576362617126L;
	
	protected Fornecedor getFornecedorLogado(HttpServletRequest request){
		
		return (Fornecedor) request.getSession().getAttribute("usuario");
		
	}
}
