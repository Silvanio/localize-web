package br.com.web.localize.modelo.dto;

import java.io.Serializable;

/**
 * <p>
 * <b>Title:</b> InformacoesDTO.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Informacoes DTO.
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
public class InformacoesDTO implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Long id;

	/** Atributo caminhoIcon. */
	private String caminhoImagem;

	/** Atributo caminhoIcon. */
	private String nomeImagem;

	/** Atributo imagem. */
	private byte[] imagem;

	/** Atributo cnpj. */
	private String cnpj;

	/** Atributo nomeFantasia. */
	private String nomeFantasia;

	/** Atributo razaoSocial. */
	private String razaoSocial;

	/** Atributo email. */
	private String email;

	/** Atributo senha. */
	private String senha;

	/** Atributo telefone. */
	private String telefone;

	/** Atributo celular. */
	private String celular;

	/** Atributo descricao. */
	private String descricao;

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
	 * Retorna o valor do atributo <code>senha</code>
	 *
	 * @return <code>String</code>
	 */
	public String getSenha() {

		return this.senha;
	}

	/**
	 * Define o valor do atributo <code>senha</code>.
	 *
	 * @param senha
	 */
	public void setSenha(final String senha) {

		this.senha = senha;
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

	/**
	 * Retorna o valor do atributo <code>imagem</code>
	 *
	 * @return <code>byte[]</code>
	 */
	public byte[] getImagem() {

		return imagem;
	}

	/**
	 * Define o valor do atributo <code>imagem</code>.
	 *
	 * @param imagem
	 */
	public void setImagem(byte[] imagem) {

		this.imagem = imagem;
	}

}
