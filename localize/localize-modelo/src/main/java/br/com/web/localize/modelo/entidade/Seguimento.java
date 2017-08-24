package br.com.web.localize.modelo.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * <b>Title:</b> Seguimento.java
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
@Table(name = "tb_seguimento")
@XmlRootElement
public class Seguimento extends EntidadeLocalize {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo id. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** Atributo descricao. */
	@Column(name = "descricao")
	private String descricao;

	/** Atributo tipoServico. */
	@ManyToOne
	@JoinColumn(name = "id_tipo_servico")
	private TipoServico tipoServico;

	/** Atributo fornecedores. */
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "seguimentos", targetEntity = DadosServico.class)
	private List<DadosServico> dadosServicoList;

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
	 * Retorna o valor do atributo <code>tipoServico</code>
	 *
	 * @return <code>TipoServico</code>
	 */
	public TipoServico getTipoServico() {

		return tipoServico;
	}

	/**
	 * Define o valor do atributo <code>tipoServico</code>.
	 *
	 * @param tipoServico
	 */
	public void setTipoServico(TipoServico tipoServico) {

		this.tipoServico = tipoServico;
	}

	/**
	 * Retorna o valor do atributo <code>dadosServicoList</code>
	 *
	 * @return <code>List<DadosServico></code>
	 */
	public List<DadosServico> getDadosServicoList() {

		return dadosServicoList;
	}

	/**
	 * Define o valor do atributo <code>dadosServicoList</code>.
	 *
	 * @param dadosServicoList
	 */
	public void setDadosServicoList(List<DadosServico> dadosServicoList) {

		this.dadosServicoList = dadosServicoList;
	}

}
