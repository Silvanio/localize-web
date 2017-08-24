package br.com.web.localize.modelo.entidade;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

import br.com.web.localize.arquitetura.modelo.Entidade;

/**
 * <p>
 * <b>Title:</b> EntidadeLocalize
 * </p>
 * 
 * <p>
 * <b>Description:</b>Entidade Super-class <code>EntidadeLocalize</code>
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
@MappedSuperclass
public abstract class EntidadeLocalize extends Entidade {


	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 4182277325600296695L;

	/**
	 * Retorna o valor do atributo <code>id</code>
	 * 
	 * @return <code>Long</code>
	 */
	public abstract Long getId();

	/**
	 * Define o valor do atributo <code>id</code>.
	 * 
	 * @param id
	 */
	public abstract void setId(Long id);

	/**
	 * Retorna o valor do atributo <code>id</code>
	 * 
	 * @return <code>Long</code>
	 */
	public Serializable getIdentificador() {

		return this.getId();
	}

	public boolean isNew() {

		return this.getId() == null;
	}

}
