package br.com.web.localize.modelo.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * <b>Title:</b> FornecedorDTO.java
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
public class FornecedorDTO implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -1444166115428927564L;

	/** Atributo nome. */
	private String nome;

	/** Atributo telefone. */
	private String telefone;

	/** Atributo email. */
	private String email;

	/** Atributo endereco. */
	private String endereco;

	/** Atributo distancia. */
	private Double distancia;

	/** Atributo icon. */
	private byte[] icon;

	/** Atributo descricao. */
	private String descricao;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public FornecedorDTO() {

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
	 * Retorna o valor do atributo <code>endereco</code>
	 *
	 * @return <code>String</code>
	 */
	public String getEndereco() {

		return this.endereco;
	}

	/**
	 * Define o valor do atributo <code>endereco</code>.
	 *
	 * @param endereco
	 */
	public void setEndereco(final String endereco) {

		this.endereco = endereco;
	}

	/**
	 * Retorna o valor do atributo <code>distancia</code>
	 *
	 * @return <code>Double</code>
	 */
	public Double getDistancia() {

		return distancia;
	}

	/**
	 * Define o valor do atributo <code>distancia</code>.
	 *
	 * @param distancia
	 */
	public void setDistancia(Double distancia) {

		this.distancia = distancia;
	}

	/**
	 * Retorna o valor do atributo <code>icon</code>
	 *
	 * @return <code>byte[]</code>
	 */
	public byte[] getIcon() {

		return icon;
	}

	/**
	 * Define o valor do atributo <code>icon</code>.
	 *
	 * @param icon
	 */
	public void setIcon(byte[] icon) {

		this.icon = icon;
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
