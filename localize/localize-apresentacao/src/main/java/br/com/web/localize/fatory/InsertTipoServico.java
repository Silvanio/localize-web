package br.com.web.localize.fatory;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.web.localize.service.util.UtilArquivo;

public class InsertTipoServico {

	public static void main(String[] args) throws SQLException {

		insert(1l,"Restaurantes","C:/Users/silvanio/Desktop/icon/servico_restaurante.png","C:/Users/silvanio/Desktop/panel/restaurantes.png");
		insert(2l,"Bares","C:/Users/silvanio/Desktop/icon/servico_bares.png","C:/Users/silvanio/Desktop/panel/bares.png");
		insert(3l,"Diversão","C:/Users/silvanio/Desktop/icon/servico_diversao.png","C:/Users/silvanio/Desktop/panel/diversao.png");
		insert(4l,"Moteis","C:/Users/silvanio/Desktop/icon/servico_moteis.png","C:/Users/silvanio/Desktop/panel/moteis.png");
		insert(5l,"Hotelaria","C:/Users/silvanio/Desktop/icon/servico_hotelaria.png","C:/Users/silvanio/Desktop/panel/hotelaria.png");
		insert(6l,"Hotelaria","C:/Users/silvanio/Desktop/icon/servico_viagens.png","C:/Users/silvanio/Desktop/panel/viagens.png");
		
	}
	
	private static void insert(Long id, String nome, String iconStr, String panelStr) throws SQLException {
		
		File icon = new File(iconStr);
		
		byte[] arquivoicon = UtilArquivo.converterFileEmByteArray(icon);
		
		File panel = new File(panelStr);
		
		byte[] arquivopanel = UtilArquivo.converterFileEmByteArray(panel);
		
		Connection conn = FabricaConexao.getConexao();
		
		PreparedStatement ps = conn.prepareStatement("INSERT INTO tb_tiposervico(id,nome, icon, panel)VALUES (?,?, ?, ?);");
		
		ps.setLong(1, id);
		ps.setString(2, nome);
		ps.setObject(3, arquivoicon);
		ps.setObject(4, arquivopanel);
		
		boolean modificados = ps.execute();
		
		System.out.println(modificados);
		
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
