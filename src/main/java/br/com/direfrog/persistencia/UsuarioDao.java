package br.com.direfrog.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public void salvar(Usuario user) {
		if (user.getId()!=null){
			alterar(user);
		}else{
			cadastrar(user);
		}
	}
	
	
	
	/**
	 * Busca usuario por id
	 * @param id é um inteiro que representa a chave primária id da tabela usuario
	 * @return objeto usuario com os campos preenchidos ou null se a entrada não existir 
	 */
	public Usuario buscaPorId(int id) {
		Usuario userRetorno = null;
		
		String sql="select * from usuario where id=?";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)){
			//Prepara statement
			preparador.setInt(1,id);
			//executa statement e recupera resultado
			ResultSet resultado = preparador.executeQuery();
			if (resultado.next()){
				userRetorno = new Usuario();
				userRetorno.setId(resultado.getInt("id"));
				userRetorno.setNome(resultado.getString("nome"));
				userRetorno.setLogin(resultado.getString("login"));
				userRetorno.setSenha(resultado.getString("senha"));
			}else{
				System.out.println("Usuário inexistente");
			}
			
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return userRetorno;
	}

	/**
	 * Realiza a busca de todos os registros da tabela usuario
	 * @return Lista de objetos usuário com 0 elementos se não houver registros ou n elementos se houver resultado
	 */
	public List<Usuario> buscaTodos() {
		Usuario userRetorno = null;
		List<Usuario> lista = new ArrayList<Usuario>();
		String sql="select * from usuario";
		try (PreparedStatement preparador = conexao.prepareStatement(sql)){
			//executa statement e recupera resultado
			ResultSet resultado = preparador.executeQuery();
			while (resultado.next()){
				userRetorno = new Usuario();
				userRetorno.setId(resultado.getInt("id"));
				userRetorno.setNome(resultado.getString("nome"));
				userRetorno.setLogin(resultado.getString("login"));
				userRetorno.setSenha(resultado.getString("senha"));
				lista.add(userRetorno);
			}
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
}
