package br.com.web.localize.arquitetura.comum;

import java.util.logging.Logger;

/**
 * <p>
 * <b>Title:</b> UtilLogger
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe responsável por logar as ações que ocorrem no sistema.
 * </p>
 * 
 * @author Bruno Zafalão
 * 
 * @version 1.0.0
 */
public final class UtilLogger {

	/** Atributo logger. */
	private static Logger	logger;

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 * 
	 * @param clazz
	 */
	private UtilLogger( final Class<?> clazz ) {

		UtilLogger.logger = Logger.getLogger(clazz.getName());
	}

	/**
	 * Método responsável por obter o logger responsável por logar as ações do sistema.
	 * 
	 * @author Bruno Zafalão
	 * 
	 * @param clazz
	 * 
	 * @return <code>UtilLogger</code>
	 */
	public static UtilLogger getLogger(final Class<?> clazz) {

		return new UtilLogger(clazz);
	}

	/**
	 * Método responsável por logar as ações do sistema.
	 * 
	 * @author Bruno Zafalão
	 * 
	 * @param message
	 */
	public static void info(final String message) {

		logger.info(message);
	}

	/**
	 * Método responsável por logar as ações do sistema.
	 * 
	 * @author Bruno Zafalão
	 * 
	 * @param message
	 */
	public static void warning(final String message) {

		logger.warning(message);
	}

	/**
	 * Método responsável por logar as ações do sistema.
	 * 
	 * @author Bruno Zafalão
	 * 
	 * @param message
	 */
	public static void severe(final String message) {

		logger.severe(message);
	}
}
