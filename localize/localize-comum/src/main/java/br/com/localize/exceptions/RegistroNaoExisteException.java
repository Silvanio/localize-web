package br.com.localize.exceptions;


/**
 * <p>
 * <b>Title:</b> RegistroNaoExisteException
 * </p>
 * 
 * <p>
 * <b>Description:</b> Exceção lançada quando um registro não é encontrado na base da dados.
 * </p>
 * 
 * @author Rogério Gomes
 * 
 * @version 1.0.0
 */
public class RegistroNaoExisteException extends RuntimeException {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 7653330979098370841L;
	
	/** Constante KEY_MESSAGE_REGISTRO_NAO_EXISTE. */
	public static final String KEY_MESSAGE_REGISTRO_NAO_EXISTE = "label.registronaoexiste";

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public RegistroNaoExisteException() {

		super(KEY_MESSAGE_REGISTRO_NAO_EXISTE);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param message
	 *            - Mensagem da exceção
	 */
	public RegistroNaoExisteException( final String message ) {

		super(message);
	}
}
