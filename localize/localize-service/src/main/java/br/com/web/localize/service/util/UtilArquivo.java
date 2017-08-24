package br.com.web.localize.service.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import br.com.web.localize.arquitetura.comum.UtilObjeto;

import com.google.common.io.Files;

/**
 * <p>
 * <b>Title:</b> UtilArquivo
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe utilitária para trabalhar com arquivo.
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
public class UtilArquivo {

	/**
	 * Método responsável por converter arquivo (File) em byte[].
	 *
	 * @author Silvânio Júnior
	 *
	 * @param arquivo
	 * 
	 * @return <code>byte[]</code>
	 */
	public static byte[] converterFileEmByteArray(final File arquivo) {

		byte[] file = null;

		try {

			file = Files.toByteArray(arquivo);

		} catch (final IOException e) {

			e.printStackTrace();
		}

		return file;

	}

	/**
	 * Método responsável por retornar os dados do byte.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param file
	 * 
	 * @return <code>String</code>
	 */
	public static String converterByteArrayEmString(final byte[] file) {

		return new String(file);

	}

	/**
	 * Método responsável por remover arquivo.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param arquivo
	 * 
	 * @return boolean
	 */
	public static boolean remover(final File arquivo) {

		if (UtilObjeto.isNotNull(arquivo) && arquivo.exists()) {

			return arquivo.delete();

		}

		return false;

	}

	/**
	 * Método responsável por remover arquivo.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param arquivo
	 * 
	 * @return boolean
	 */
	public static boolean remover(final String arquivo) {

		final File file = new File(arquivo);

		return UtilArquivo.remover(file);
	}

	/**
	 * Método responsável por transformar inputStream em byte array.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param is
	 * 
	 * @returnbyte
	 */
	public static byte[] getBytesFromInputStream(final InputStream is) {

		try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {

			final byte[] buffer = new byte[0xFFFF];

			for (int len; ( len = is.read(buffer) ) != -1;) {

				os.write(buffer, 0, len);

			}

			os.flush();

			return os.toByteArray();

		} catch (final IOException e) {

			e.printStackTrace();

			return null;

		}
	}

}
