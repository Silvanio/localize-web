package br.com.web.localize.modelo.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * <b>Title:</b> TrocarSenhaDTO.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe para tráfego de informações de troca de senha.
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
@XmlRootElement
public class TrocarSenhaDTO implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -5391380814426748937L;

	/** Atributo senha. */
	private String senha;

	/** Atributo novaSenha. */
	private String novaSenha;

	/** Atributo repetirNovaSenha. */
	private String repetirNovaSenha;

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
	 * Retorna o valor do atributo <code>novaSenha</code>
	 *
	 * @return <code>String</code>
	 */
	public String getNovaSenha() {

		return this.novaSenha;
	}

	/**
	 * Define o valor do atributo <code>novaSenha</code>.
	 *
	 * @param novaSenha
	 */
	public void setNovaSenha(final String novaSenha) {

		this.novaSenha = novaSenha;
	}

	/**
	 * Retorna o valor do atributo <code>repetirNovaSenha</code>
	 *
	 * @return <code>String</code>
	 */
	public String getRepetirNovaSenha() {

		return this.repetirNovaSenha;
	}

	/**
	 * Define o valor do atributo <code>repetirNovaSenha</code>.
	 *
	 * @param repetirNovaSenha
	 */
	public void setRepetirNovaSenha(final String repetirNovaSenha) {

		this.repetirNovaSenha = repetirNovaSenha;
	}

}
