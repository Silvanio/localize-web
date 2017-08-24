package br.com.web.localize.modelo.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * <b>Title:</b> Fornecedor.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe de negocio para o Localize.
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
@Table(name = "tb_fornecedor")
@XmlRootElement
public class Fornecedor extends EntidadeLocalize {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo id. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** Atributo informacoes. */
	@OneToOne(mappedBy = "fornecedor")
	private DadosServico dadosServico;

	/** Atributo informacoes. */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_informacoes")
	private Informacoes informacoes;

	/** Atributo localizacao. */
	@OneToOne(mappedBy = "fornecedor")
	private Localizacao localizacao;

	/** Atributo publicar. */
	@Column(name = "publicar")
	private boolean publicar;

	/**
	 * Descrição Padrão: <br>
	 * Identificador.<br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.web.localize.modelo.entidade.EntidadeLocalize#getId()
	 */
	@Override
	public Long getId() {

		return this.id;
	}

	/**
	 * Descrição Padrão: <br>
	 * <br>
	 *
	 * {@inheritDoc}
	 *
	 * @see br.com.web.localize.modelo.entidade.EntidadeLocalize#setId(java.lang.Long)
	 */
	@Override
	public void setId(final Long id) {

		this.id = id;

	}

	/**
	 * Retorna o valor do atributo <code>informacoes</code>
	 *
	 * @return <code>Informacoes</code>
	 */
	public Informacoes getInformacoes() {

		return this.informacoes;
	}

	/**
	 * Define o valor do atributo <code>informacoes</code>.
	 *
	 * @param informacoes
	 */
	public void setInformacoes(final Informacoes informacoes) {

		this.informacoes = informacoes;
	}

	/**
	 * Retorna o valor do atributo <code>publicar</code>
	 *
	 * @return <code>boolean</code>
	 */
	public boolean isPublicar() {

		return this.publicar;
	}

	/**
	 * Define o valor do atributo <code>publicar</code>.
	 *
	 * @param publicar
	 */
	public void setPublicar(final boolean publicar) {

		this.publicar = publicar;
	}

	/**
	 * Retorna o valor do atributo <code>localizacao</code>
	 *
	 * @return <code>Localizacao</code>
	 */
	public Localizacao getLocalizacao() {

		return this.localizacao;
	}

	/**
	 * Define o valor do atributo <code>localizacao</code>.
	 *
	 * @param localizacao
	 */
	public void setLocalizacao(final Localizacao localizacao) {

		this.localizacao = localizacao;
	}

	/**
	 * Retorna o valor do atributo <code>dadosServico</code>
	 *
	 * @return <code>DadosServico</code>
	 */
	public DadosServico getDadosServico() {

		return dadosServico;
	}

	/**
	 * Define o valor do atributo <code>dadosServico</code>.
	 *
	 * @param dadosServico
	 */
	public void setDadosServico(DadosServico dadosServico) {

		this.dadosServico = dadosServico;
	}

}
