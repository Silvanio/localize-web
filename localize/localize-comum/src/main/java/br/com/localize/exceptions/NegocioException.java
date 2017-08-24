package br.com.localize.exceptions;

/**
 * <p>
 * <b>Title:</b> NegocioException
 * </p>
 * 
 * <p>
 * <b>Description:</b> Exceção para erros relacionados a regra de negócio.
 * </p>
 * 
 * <p>
 * <b>Company: </b>
 * </p>
 * 
 * @author Rogério Gomes
 * 
 * @version 1.0
 */
public class NegocioException extends RuntimeException {

	private static final long serialVersionUID = -9183688298291516514L;

	/** Atributo args. */
	private String[] args;

	/**
	 * Cria uma instância de NegocioException.
	 */
	public NegocioException() {

		super();
	}

	/**
	 * Cria o objeto e atribui a mensagem da exceção.
	 * 
	 * @param mensagem
	 *            Mensagem da exceção
	 */
	public NegocioException( final String mensagem ) {

		super(mensagem);
	}

	/**
	 * Cria o objeto e atribui a mensagem e a causa da exceção.
	 * 
	 * @param mensagem
	 *            Mensagem da exceção
	 * @param causa
	 *            Causa da exceção
	 */
	public NegocioException( final String mensagem, final Throwable causa ) {

		super(mensagem, causa);
	}

	/**
	 * Cria o objeto e atribui a causa da exceção.
	 * 
	 * @param causa
	 *            Causa da exceção
	 */
	public NegocioException( final Throwable causa ) {

		super(causa);
	}

	/**
	 * Cria o objeto e atribui a referencia ao arquivo de propriedades.
	 * 
	 * @param mensagem
	 *            Chave no arquivo de propriedades
	 * @param args
	 *            Valores relacionados a chave
	 */
	public NegocioException( final String mensagem, final String... args ) {

		super(mensagem);

		this.args = args;
	}

	/**
	 * @return O valor do atributo args.
	 */
	public String[] getArgs() {

		return this.args;
	}

}
