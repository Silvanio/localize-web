package br.com.web.localize.modelo.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.web.localize.arquitetura.comum.UtilObjeto;
import br.com.web.localize.arquitetura.comum.UtilString;

/**
 * <p>
 * <b>Title:</b> SeguimentoDTO.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe de transição para Seguimento.
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
public class SeguimentoDTO implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 9123467063186169799L;

	/** Atributo id. */
	private Long id;

	/** Atributo descricao. */
	private String descricao;
	
	/**
	 * Método responsável por comparar dois objetos.
	 * 
	 * @author Rogerio Gomes
	 * 
	 * @param object
	 * 
	 * @return <code>boolean</code>
	 */
	@Override
	public boolean equals(final Object object) {

		if (object == this) {

			return Boolean.TRUE;
		}

		if (UtilObjeto.isNull(object) || object.getClass() != this.getClass()) {

			return Boolean.FALSE;
		}

		final SeguimentoDTO entidade = (SeguimentoDTO) object;

		return ( !UtilObjeto.isNull(entidade.getId()) && !UtilObjeto.isNull(this.getId()) ) && UtilString.isEquals(this.getId().toString(), entidade.getId().toString());
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
