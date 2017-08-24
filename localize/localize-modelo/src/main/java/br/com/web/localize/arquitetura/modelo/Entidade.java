package br.com.web.localize.arquitetura.modelo;

import java.beans.Transient;
import java.io.Serializable;
import java.util.UUID;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import br.com.web.localize.arquitetura.comum.UtilObjeto;
import br.com.web.localize.arquitetura.comum.UtilString;

/**
 * <p>
 * <b>Title:</b> Entidade.java
 * </p>
 * 
 * <p>
 * <b>Description:</b>Entidade
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
public abstract class Entidade implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long	serialVersionUID	= 2325166658203959465L;
	
	
	private String uuid = UUID.randomUUID().toString();

	/**
	 * Método responsável por obter o identificador da Entidade.
	 * 
	 * @author Rogerio Gomes
	 * 
	 * @return <code>Long</code>
	 */
	public abstract Long getId();

	/**
	 * Método responsável por obter o identificador secundario da entidade.
	 * 
	 * @author Rogerio Gomes
	 * 
	 * @return <code>String</code>
	 */
	public String getUuid() {
		
		return uuid;
	}
	
	/**
	 * Define o valor do atributo <code>uuid</code>.
	 *
	 * @param uuid 
	 */
	@Transient
	public void setUuid(String uuid) {
	
		if(UtilString.isEmpty(uuid)){
			return;
		}
		
		this.uuid = uuid;
	}

	/**
	 * Método responsável por gerar o código hash para identificação da Entidade.
	 * 
	 * @author Rogerio Gomes
	 * 
	 * @return <code>int</code>
	 */
	@Override
	public int hashCode() {

		final int PRIMO = 31;

		return UtilObjeto.isNull(this.getId()) ? 0 : new HashCodeBuilder(this.getId() % 2 == 0 ? this.getId().intValue() + 1 : this.getId().intValue(), PRIMO).toHashCode();
	}

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

		if (UtilObjeto.isNull(object) || !( object instanceof Entidade ) || object.getClass() != this.getClass()) {

			return Boolean.FALSE;
		}

		final Entidade entidade = (Entidade) object;

		return ( !UtilObjeto.isNull(entidade.getId()) && !UtilObjeto.isNull(this.getId()) ) ? UtilString.isEquals(this.getId().toString(), entidade.getId().toString()) : UtilString.isEquals(this.getUuid(), entidade.getUuid());
	}
}
