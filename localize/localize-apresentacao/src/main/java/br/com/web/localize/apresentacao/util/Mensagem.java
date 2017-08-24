package br.com.web.localize.apresentacao.util;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * <b>Title:</b> Mensagem.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe responsável por retonar mensagem.
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
public class Mensagem implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -8212710649950610929L;

	/** Atributo tipo. */
	private MensagemEnum tipo;

	/** Atributo descricao. */
	private String descricao;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public Mensagem() {

	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param tipo
	 */
	public Mensagem( final MensagemEnum tipo ) {

		this.tipo = tipo;
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param tipo
	 * 
	 * @param descricao
	 */
	public Mensagem( final MensagemEnum tipo, final String descricao ) {

		this(tipo);

		this.descricao = descricao;
	}

	/**
	 * Retorna o valor do atributo <code>tipo</code>
	 *
	 * @return <code>MensagemEnum</code>
	 */
	public MensagemEnum getTipo() {

		return this.tipo;
	}

	/**
	 * Define o valor do atributo <code>tipo</code>.
	 *
	 * @param tipo
	 */
	public void setTipo(final MensagemEnum tipo) {

		this.tipo = tipo;
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

}
