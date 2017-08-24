package br.com.web.localize.arquitetura.comum;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * <p>
 * <b>Title:</b> UtilSecurity.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Utilitario de criptoragrafia.
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
public class UtilSecurity {

	/** Atributo CADEIA. */
	private static final String	CADEIA	= " !\"#$%&()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";

	/**
	 * Método responsável por criptografar valores.
	 * 
	 * @author Silvânio Júnior
	 * 
	 * @param value
	 * 
	 * @return <code>String</code>
	 */
	public static String cript(final String value) {

		final StringBuilder str = new StringBuilder();

		final NumberFormat formatter = NumberFormat.getNumberInstance(new Locale("pt", "BR"));

		formatter.setMinimumIntegerDigits(3);

		formatter.setMaximumIntegerDigits(3);

		for (int i = 0; i < value.trim().length(); i++) {

			str.append(formatter.format(UtilSecurity.CADEIA.indexOf(value.trim().charAt(i))));
		}

		return str.toString();
	}

	/**
	 * Método responsável por decriptografar valores.
	 * 
	 * @author Silvânio Júnior
	 * 
	 * @param value
	 * 
	 * @return <code>String</code>
	 */
	public static String decript(final String value) {

		final StringBuilder str = new StringBuilder();

		int inicio = 0;

		int fim = 3;

		while (fim <= value.trim().length()) {

			str.append(UtilSecurity.CADEIA.charAt(Integer.parseInt(value.trim().substring(inicio, fim))));

			inicio += 3;

			fim += 3;
		}

		return str.toString();
	}
	
	public static void main(String[] args) {

		System.out.println(cript("inicial01"));
	}
}
