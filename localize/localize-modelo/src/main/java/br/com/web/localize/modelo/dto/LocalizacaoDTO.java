package br.com.web.localize.modelo.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * <b>Title:</b> LocalizacaoDTO.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> LocalizacaoDTO
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - Localize TI.
 * </p>
 * 
 * @author Silânio Júnior
 * 
 * @version 1.0.0
 */
@XmlRootElement
public class LocalizacaoDTO implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -244281949561973423L;

	/** Atributo id. */
	private Long id;

	/** Atributo latitude. */
	private String latitude;

	/** Atributo longitude. */
	private String longitude;

	/** Atributo descricao. */
	private String descricao;

	/** Atributo idFornecedor. */
	private Long idFornecedor;

	/**
	 * Retorna o valor do atributo <code>latitude</code>
	 *
	 * @return <code>String</code>
	 */
	public String getLatitude() {

		return latitude;
	}

	/**
	 * Define o valor do atributo <code>latitude</code>.
	 *
	 * @param latitude
	 */
	public void setLatitude(String latitude) {

		this.latitude = latitude;
	}

	/**
	 * Retorna o valor do atributo <code>longitude</code>
	 *
	 * @return <code>String</code>
	 */
	public String getLongitude() {

		return longitude;
	}

	/**
	 * Define o valor do atributo <code>longitude</code>.
	 *
	 * @param longitude
	 */
	public void setLongitude(String longitude) {

		this.longitude = longitude;
	}

	/**
	 * Retorna o valor do atributo <code>idFornecedor</code>
	 *
	 * @return <code>Long</code>
	 */
	public Long getIdFornecedor() {

		return idFornecedor;
	}

	/**
	 * Define o valor do atributo <code>idFornecedor</code>.
	 *
	 * @param idFornecedor
	 */
	public void setIdFornecedor(Long idFornecedor) {

		this.idFornecedor = idFornecedor;
	}

	/**
	 * Retorna o valor do atributo <code>id</code>
	 *
	 * @return <code>Long</code>
	 */
	public Long getId() {

		return id;
	}

	/**
	 * Define o valor do atributo <code>id</code>.
	 *
	 * @param id
	 */
	public void setId(Long id) {

		this.id = id;
	}

	/**
	 * Retorna o valor do atributo <code>descricao</code>
	 *
	 * @return <code>String</code>
	 */
	public String getDescricao() {

		return descricao;
	}

	/**
	 * Define o valor do atributo <code>descricao</code>.
	 *
	 * @param descricao
	 */
	public void setDescricao(String descricao) {

		this.descricao = descricao;
	}

}
