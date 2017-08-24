package br.com.web.localize.apresentacao.util;

/**
 * <p>
 * <b>Title:</b> MensagemEnum.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Enum de Mensagem.
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
public enum MensagemEnum {

	INFO(1, ""), SUCESS(2, "Operação realizada com sucesso"), ERROR(3, "Ops..erro inexperado, Contate o administrador do sistema");

	/** Atributo codigo. */
	private Integer codigo;

	/** Atributo descricao. */
	private String descricao;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param codigo
	 * 
	 * @param descricao
	 */
	private MensagemEnum( final Integer codigo, final String descricao ) {

		this.codigo = codigo;

		this.descricao = descricao;
	}

	/**
	 * Retorna o valor do atributo <code>codigo</code>
	 *
	 * @return <code>Integer</code>
	 */
	public Integer getCodigo() {

		return this.codigo;
	}

	/**
	 * Retorna o valor do atributo <code>descricao</code>
	 *
	 * @return <code>String</code>
	 */
	public String getDescricao() {

		return this.descricao;
	}

}
