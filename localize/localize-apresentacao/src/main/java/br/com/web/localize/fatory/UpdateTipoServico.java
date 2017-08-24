package br.com.web.localize.fatory;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.web.localize.service.util.UtilArquivo;

public class UpdateTipoServico {

	public static void main(String[] args) throws SQLException {

		//alterICON();
		
		alterPanel();
		
	}
	
	private static void alterPanel() throws SQLException {
		
		File file = new File("C:/Users/silvanio/Desktop/img/restaurantes.png");
		
		byte[] arquivo = UtilArquivo.converterFileEmByteArray(file);
		
		Connection conn = FabricaConexao.getConexao();
		
		PreparedStatement ps = conn.prepareStatement("UPDATE tb_tipoServico SET panel=? where nome ='Restaurantes';");
		
		ps.setObject(1, arquivo);
		
		int modificados = ps.executeUpdate();
		
	}

	
	
	private static void alterICON() throws SQLException {

		File file = new File("C:/Users/silvanio/Desktop/images/restaurantes.png");

		byte[] arquivo = UtilArquivo.converterFileEmByteArray(file);

		Connection conn = FabricaConexao.getConexao();

		PreparedStatement ps = conn.prepareStatement("UPDATE tb_tipoServico SET icon=? where nome ='Restaurantes';");

		ps.setObject(1, arquivo);

		int modificados = ps.executeUpdate();

		System.out.println(modificados);
	}
	
	

}
