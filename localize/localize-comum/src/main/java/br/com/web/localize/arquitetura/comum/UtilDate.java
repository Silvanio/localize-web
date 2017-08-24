package br.com.web.localize.arquitetura.comum;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * <b>Title:</b> UtilDate
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe utilitária para trabalhar com Data.
 * </p>
 * 
 * <p>
 * <b>Company: </b> ITSS Soluções em Tecnologia
 * </p>
 * 
 * @author Silvânio Júnior
 * 
 * @version 1.0.0
 */
public class UtilDate {

	/** Atributo PATTERN. */
	private static final String	PATTERN	= "dd/MM/yyyy";

	/**
	 * Método responsável por formatar data.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param data
	 * 
	 * @return <code>String</code>
	 */
	public static String format(final Date data) {

		return UtilDate.format(data, UtilDate.PATTERN);
	}

	/**
	 * Método responsável por formatar data.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param data
	 * 
	 * @return <code>String</code>
	 */
	public static String format(final Date data, final String pattern) {

		final SimpleDateFormat dt = new SimpleDateFormat(pattern);

		return dt.format(data);

	}

}
