package br.com.web.localize.modelo.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * <b>Title:</b> TipoServicoDTO.java
 * </p>
 * 
 * <p>
 * <b>Description:</b>
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - Red & White IT Solution
 * </p>
 * 
 * @author Silvânio Júnior
 * 
 * @version 1.0.0
 */
@XmlRootElement
public class TipoServicoDTO implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -6566410610033926901L;

	/** Atributo id */
	private Long id;

	/** Atributo nome. */
	private String nome;

	/** Atributo icon. */
	private String identificadorImagem;

	/** Atributo icon. */
	private String identificadorPainel;

	/**
	 * Retorna o valor do atributo <code>id</code>
	 *
	 * @return <code>Long</code>
	 */
	public Long getId() {

		return this.id;
	}

	/**
	 * Define o valor do atributo <code>id</code>.
	 *
	 * @param id
	 */
	public void setId(final Long id) {

		this.id = id;
	}

	/**
	 * Retorna o valor do atributo <code>nome</code>
	 *
	 * @return <code>String</code>
	 */
	public String getNome() {

		return this.nome;
	}

	/**
	 * Define o valor do atributo <code>nome</code>.
	 *
	 * @param nome
	 */
	public void setNome(final String nome) {

		this.nome = nome;
	}

	/**
	 * Retorna o valor do atributo <code>identificadorImagem</code>
	 *
	 * @return <code>String</code>
	 */
	public String getIdentificadorImagem() {

		return this.identificadorImagem;
	}

	/**
	 * Define o valor do atributo <code>identificadorImagem</code>.
	 *
	 * @param identificadorImagem
	 */
	public void setIdentificadorImagem(final String identificadorImagem) {

		this.identificadorImagem = identificadorImagem;
	}

	/**
	 * Retorna o valor do atributo <code>identificadorPainel</code>
	 *
	 * @return <code>String</code>
	 */
	public String getIdentificadorPainel() {

		return this.identificadorPainel;
	}

	/**
	 * Define o valor do atributo <code>identificadorPainel</code>.
	 *
	 * @param identificadorPainel
	 */
	public void setIdentificadorPainel(final String identificadorPainel) {

		this.identificadorPainel = identificadorPainel;
	}

}
