package br.com.localize.exceptions;


/**
 * <p>
 * <b>Title:</b> RegistroJaExisteException
 * </p>
 * 
 * <p>
 * <b>Description:</b> Exceção lançada quando o registro já existe na base de dados.
 * </p>
 * 
 * @author Rogério Gomes
 * 
 * @version 1.0.0
 */
public class RegistroJaExisteException extends RuntimeException {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = -5206637042085343515L;
	
	/** Constante KEY_MESSAGE_REGISTRO_JA_EXISTE. */
	public static final String KEY_MESSAGE_REGISTRO_JA_EXISTE = "label.registrojaexiste";

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	public RegistroJaExisteException() {

		super(KEY_MESSAGE_REGISTRO_JA_EXISTE);
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param message
	 *            - Mensagem da exceção
	 */
	public RegistroJaExisteException( final String message ) {

		super(message);
	}
}
