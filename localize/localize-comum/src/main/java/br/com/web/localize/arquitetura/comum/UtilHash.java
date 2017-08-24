package br.com.web.localize.arquitetura.comum;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * <p>
 * <b>Title:</b> UtilHash
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe responsável por prover funcionalidades utilitárias de hashing.
 * </p>
 * 
 * <p>
 * <b>Company:</b> ITSS Factory
 * </p>
 * 
 * @author Bruno Zafalão
 * 
 * @version 1.0.0
 */
public final class UtilHash {

	/** Constante NUM_DIGITS. */
	private static final int	NUM_DIGITS	= 16;

	/** Constante MD5. */
	private static final String	MD5			= "MD5";

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	private UtilHash() {

		super();
	}

	/**
	 * Método responsável por gerar o MD5 do arquivo submetido.
	 * 
	 * @author Bruno Zafalão
	 * 
	 * @param value
	 * 
	 * @return <code>String</code>
	 * 
	 * @throws IOException
	 */
	public static String md5(final String value) throws RuntimeException {

		try {

			final MessageDigest md = MessageDigest.getInstance(UtilHash.MD5);

			final byte[] md5 = md.digest(value.getBytes());

			final BigInteger bi = new BigInteger(1, md5);

			return bi.toString(UtilHash.NUM_DIGITS);

		} catch (final Exception e) {

			throw new RuntimeException(e);
		}
	}
}
