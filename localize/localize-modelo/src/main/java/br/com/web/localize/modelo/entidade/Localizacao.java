package br.com.web.localize.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Point;

/**
 * <p>
 * <b>Title:</b> Localizacao.java
 * </p>
 * 
 * <p>
 * <b>Description:</b>
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
@Entity
@Table(name = "tb_localizacao")
@XmlRootElement
public class Localizacao extends EntidadeLocalize {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -877136162232373510L;

	/** Atributo id. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "descricao")
	/** Atributo descricao. */
	private String descricao;

	@Column(name = "latitude")
	/** Atributo descricao. */
	private String latitude;

	@Column(name = "longitude")
	/** Atributo descricao. */
	private String longitude;

	/** Atributo localizacao. */
	@Type(type = "org.hibernate.spatial.GeometryType")
	@Column(name = "localizacao", columnDefinition = "Geometry")
	private Point localizacao;

	/** Atributo fornecedor. */
	@OneToOne
	@JoinColumn(name = "id_fornecedor")
	private Fornecedor fornecedor;

	/**
	 * Retorna o valor do atributo <code>id</code>
	 *
	 * @return <code>Long</code>
	 */
	@Override
	public Long getId() {

		return this.id;
	}

	/**
	 * Define o valor do atributo <code>id</code>.
	 *
	 * @param id
	 */
	@Override
	public void setId(final Long id) {

		this.id = id;
	}

	/**
	 * Retorna o valor do atributo <code>descricao</code>
	 *
	 * @return <code>String</code>
	 */
	public String getDescricao() {

		return this.descricao;
	}

	/**
	 * Define o valor do atributo <code>descricao</code>.
	 *
	 * @param descricao
	 */
	public void setDescricao(final String descricao) {

		this.descricao = descricao;
	}

	/**
	 * Retorna o valor do atributo <code>localizacao</code>
	 *
	 * @return <code>Point</code>
	 */
	public Point getLocalizacao() {

		return this.localizacao;
	}

	/**
	 * Define o valor do atributo <code>localizacao</code>.
	 *
	 * @param localizacao
	 */
	public void setLocalizacao(final Point localizacao) {

		this.localizacao = localizacao;
	}

	/**
	 * Retorna o valor do atributo <code>fornecedor</code>
	 *
	 * @return <code>Fornecedor</code>
	 */
	public Fornecedor getFornecedor() {

		return this.fornecedor;
	}

	/**
	 * Define o valor do atributo <code>fornecedor</code>.
	 *
	 * @param fornecedor
	 */
	public void setFornecedor(final Fornecedor fornecedor) {

		this.fornecedor = fornecedor;
	}

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

}
