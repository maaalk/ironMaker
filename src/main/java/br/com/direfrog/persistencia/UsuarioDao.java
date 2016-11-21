package br.com.direfrog.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.direfrog.entidade.Usuario;

public class UsuarioDao {

	private Connection conexao = ConexaoFactory.getConnection();
	public void cadastrar(Usuario user) {
		String sql="insert into usuario (nome, login, senha) values (?,?,?)";
		//criando statement
		try (PreparedStatement preparador = conexao.prepareStatement(sql)){	
			preparador.setString(1, user.getNome());
			preparador.setString(2, user.getLogin());
			preparador.setString(3, user.getSenha());
			//executando statement
			preparador.execute();
			//encerrando objeto preparador
			//preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void alterar(Usuario user) {
		String sql="update usuario set nome=?, login=?, senha=? where id=?";
		//criando statement
		try (PreparedStatement preparador = conexao.prepareStatement(sql)){	
			preparador.setString(1, user.getNome());
			preparador.setString(2, user.getLogin());
			preparador.setString(3, user.getSenha());
			preparador.setInt(4, user.getId());
			//executando statement
			preparador.execute();
			//encerrando objeto preparador
			//preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void excluir(Usuario user) {
		String sql="delete from usuario where id=?";
		//criando statement
		try (PreparedStatement preparador = conexao.prepareStatement(sql)){	
			preparador.setInt(1, user.getId());
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
