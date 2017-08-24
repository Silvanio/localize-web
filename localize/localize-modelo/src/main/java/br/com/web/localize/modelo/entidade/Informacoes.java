package br.com.web.localize.modelo.entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * <b>Title:</b> Informacoes.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Informações do fornecedor.
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
@Table(name = "tb_informacoes")
@XmlRootElement
public class Informacoes extends EntidadeLocalize {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo id. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** Atributo caminhoIcon. */
	@Column(name = "caminhoImagem")
	private String caminhoImagem;

	/** Atributo nomeImagem. */
	@Column(name = "nomeImagem")
	private String nomeImagem;

	/** Atributo cnpj. */
	@Column(name = "cnpj")
	private String cnpj;

	/** Atributo nomeFantasia. */
	@Column(name = "nomeFantasia")
	private String nomeFantasia;

	/** Atributo razaoSocial. */
	@Column(name = "razaoSocial")
	private String razaoSocial;

	/** Atributo email. */
	@Column(name = "email")
	private String email;

	/** Atributo senha. */
	@Column(name = "senha")
	private String senha;

	/** Atributo telefone. */
	@Column(name = "telefone")
	private String telefone;

	/** Atributo celular. */
	@Column(name = "celular")
	private String celular;

	/** Atributo descricao. */
	@Column(name = "descricao")
	private String descricao;

	/** Atributo fornecedor. */
	@OneToOne(mappedBy = "informacoes")
	private Fornecedor fornecedor;

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
	 * Retorna o valor do atributo <code>cnpj</code>
	 *
	 * @return <code>String</code>
	 */
	public String getCnpj() {

		return this.cnpj;
	}

	/**
	 * Define o valor do atributo <code>cnpj</code>.
	 *
	 * @param cnpj
	 */
	public void setCnpj(final String cnpj) {

		this.cnpj = cnpj;
	}

	/**
	 * Retorna o valor do atributo <code>nomeFantasia</code>
	 *
	 * @return <code>String</code>
	 */
	public String getNomeFantasia() {

		return this.nomeFantasia;
	}

	/**
	 * Define o valor do atributo <code>nomeFantasia</code>.
	 *
	 * @param nomeFantasia
	 */
	public void setNomeFantasia(final String nomeFantasia) {

		this.nomeFantasia = nomeFantasia;
	}

	/**
	 * Retorna o valor do atributo <code>razaoSocial</code>
	 *
	 * @return <code>String</code>
	 */
	public String getRazaoSocial() {

		return this.razaoSocial;
	}

	/**
	 * Define o valor do atributo <code>razaoSocial</code>.
	 *
	 * @param razaoSocial
	 */
	public void setRazaoSocial(final String razaoSocial) {

		this.razaoSocial = razaoSocial;
	}

	/**
	 * Retorna o valor do atributo <code>email</code>
	 *
	 * @return <code>String</code>
	 */
	public String getEmail() {

		return this.email;
	}

	/**
	 * Define o valor do atributo <code>email</code>.
	 *
	 * @param email
	 */
	public void setEmail(final String email) {

		this.email = email;
	}

	/**
	 * Retorna o valor do atributo <code>telefone</code>
	 *
	 * @return <code>String</code>
	 */
	public String getTelefone() {

		return this.telefone;
	}

	/**
	 * Define o valor do atributo <code>telefone</code>.
	 *
	 * @param telefone
	 */
	public void setTelefone(final String telefone) {

		this.telefone = telefone;
	}

	/**
	 * Retorna o valor do atributo <code>celular</code>
	 *
	 * @return <code>String</code>
	 */
	public String getCelular() {

		return this.celular;
	}

	/**
	 * Define o valor do atributo <code>celular</code>.
	 *
	 * @param celular
	 */
	public void setCelular(final String celular) {

		this.celular = celular;
	}

	/**
	 * Retorna o valor do atributo <code>caminhoImagem</code>
	 *
	 * @return <code>String</code>
	 */
	public String getCaminhoImagem() {

		return this.caminhoImagem;
	}

	/**
	 * Define o valor do atributo <code>caminhoImagem</code>.
	 *
	 * @param caminhoImagem
	 */
	public void setCaminhoImagem(final String caminhoImagem) {

		this.caminhoImagem = caminhoImagem;
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
	 * Retorna o valor do atributo <code>senha</code>
	 *
	 * @return <code>String</code>
	 */
	public String getSenha() {

		return senha;
	}

	/**
	 * Define o valor do atributo <code>senha</code>.
	 *
	 * @param senha
	 */
	public void setSenha(String senha) {

		this.senha = senha;
	}

	/**
	 * Retorna o valor do atributo <code>nomeImagem</code>
	 *
	 * @return <code>String</code>
	 */
	public String getNomeImagem() {

		return nomeImagem;
	}

	/**
	 * Define o valor do atributo <code>nomeImagem</code>.
	 *
	 * @param nomeImagem
	 */
	public void setNomeImagem(String nomeImagem) {

		this.nomeImagem = nomeImagem;
	}

}
