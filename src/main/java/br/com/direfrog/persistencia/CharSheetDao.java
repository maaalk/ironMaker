package br.com.direfrog.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.direfrog.entidade.CharSheet;

public class CharSheetDao implements InterfaceGenericDAO <CharSheet> {

	private Connection conexao = ConexaoFactory.getConnection();

	@Override
	public void cadastrar(CharSheet character) {
		
		//criando statement
		String sql="insert into charsheet (nome, phy, spd, str, agi, prw, poi, intel, arc, per)"
				+ " values (?,?,?,?,?,?,?,?,?,?)";
		
		//criando statement
		try (PreparedStatement preparador = conexao.prepareStatement(sql)){	
			preparador.setString(1, character.getName());
			preparador.setInt(2, character.getPhy());
			preparador.setInt(3, character.getSpd());
			preparador.setInt(4, character.getStr());
			preparador.setInt(5, character.getAgi());
			preparador.setInt(6, character.getPrw());
			preparador.setInt(7, character.getPoi());
			preparador.setInt(8, character.getIntel());
			preparador.setInt(9, character.getArc());
			preparador.setInt(10, character.getPer());
			//executando statement
			preparador.execute();
			//encerrando objeto preparador
			//preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void excluir(int id) {

		String sql="delete from charsheet where id="+id;
		//criando statement
		try (PreparedStatement preparador = conexao.prepareStatement(sql)){	

			//executando statement
			preparador.execute();
			//encerrando objeto preparador
			//preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void alterar(CharSheet character) {
		//criando statement
		String sql="update charsheet set nome=?, phy=?, spd=?, str=?, agi=?, prw=?, poi=?, intel=?, arc=?, per=? where id=?";
		
		//criando statement
		if (character.getId()!=null){
			try (PreparedStatement preparador = conexao.prepareStatement(sql)){	
				preparador.setString(1, character.getName());
				preparador.setInt(2, character.getPhy());
				preparador.setInt(3, character.getSpd());
				preparador.setInt(4, character.getStr());
				preparador.setInt(5, character.getAgi());
				preparador.setInt(6, character.getPrw());
				preparador.setInt(7, character.getPoi());
				preparador.setInt(8, character.getIntel());
				preparador.setInt(9, character.getArc());
				preparador.setInt(10, character.getPer());
				preparador.setInt(11, character.getId());
				//executando statement
				preparador.execute();
				//encerrando objeto preparador
				//preparador.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void salvar(CharSheet character) {
		if (character.getId()!=null && character.getId()!=0 ){
			alterar(character);
		}else{
			cadastrar(character);
		}
	}

	@Override
	public CharSheet buscar(int id) {
		CharSheet character = null;
		String sql="select * from charsheet where id=?";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)){	
			preparador.setInt(1, id);
			ResultSet resultado = preparador.executeQuery();
			if(resultado.next()){
				character=new CharSheet();
				character.setAgi(resultado.getInt("agi"));
				character.setArc(resultado.getInt("arc"));
				character.setId(resultado.getInt("id"));
				character.setIntel(resultado.getInt("intel"));
				character.setName(resultado.getString("nome"));
				character.setPer(resultado.getInt("per"));
				character.setPhy(resultado.getInt("phy"));
				character.setPoi(resultado.getInt("poi"));
				character.setPrw(resultado.getInt("prw"));
				character.setSpd(resultado.getInt("spd"));
				character.setStr(resultado.getInt("str"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return character;
	}
	
	public List<CharSheet> buscarTodos() {
		CharSheet character = null;
		List<CharSheet> lista = new ArrayList<CharSheet>();
		String sql="select * from charsheet";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)){
			//executa statement e recupera resultado
			ResultSet resultado = preparador.executeQuery();
			while(resultado.next()){
				character=new CharSheet();
				character.setAgi(resultado.getInt("agi"));
				character.setArc(resultado.getInt("arc"));
				character.setId(resultado.getInt("id"));
				character.setIntel(resultado.getInt("intel"));
				character.setName(resultado.getString("nome"));
				character.setPer(resultado.getInt("per"));
				character.setPhy(resultado.getInt("phy"));
				character.setPoi(resultado.getInt("poi"));
				character.setPrw(resultado.getInt("prw"));
				character.setSpd(resultado.getInt("spd"));
				character.setStr(resultado.getInt("str"));
				lista.add(character);
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return lista;
	}

}
