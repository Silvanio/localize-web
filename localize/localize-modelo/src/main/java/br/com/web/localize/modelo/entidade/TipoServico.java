package br.com.web.localize.modelo.entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * <b>Title:</b> TipoServico.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe para Tipo de Servico.
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
@Table(name = "tb_tipo_servico")
@XmlRootElement
public class TipoServico extends EntidadeLocalize {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 156126541144334231L;

	/** Atributo id. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** Atributo descricao. */
	@Column(name = "descricao")
	private String descricao;

	/** Atributo identificadorImagem. */
	@Column(name = "identificador_imagem")
	private String identificadorImagem;

	/** Atributo identificadorImagem. */
	@Column(name = "identificador_painel")
	private String identificadorPainel;

	/** Atributo seguimentos. */
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoServico", targetEntity = Seguimento.class)
	private List<Seguimento> seguimentos;

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
	 * Retorna o valor do atributo <code>seguimentos</code>
	 *
	 * @return <code>List<Seguimento></code>
	 */
	public List<Seguimento> getSeguimentos() {

		return this.seguimentos;
	}

	/**
	 * Define o valor do atributo <code>seguimentos</code>.
	 *
	 * @param seguimentos
	 */
	public void setSeguimentos(final List<Seguimento> seguimentos) {

		this.seguimentos = seguimentos;
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

		return identificadorPainel;
	}

	/**
	 * Define o valor do atributo <code>identificadorPainel</code>.
	 *
	 * @param identificadorPainel
	 */
	public void setIdentificadorPainel(String identificadorPainel) {

		this.identificadorPainel = identificadorPainel;
	}
}
