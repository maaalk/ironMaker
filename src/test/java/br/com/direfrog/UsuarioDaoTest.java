package br.com.direfrog;

import java.util.ArrayList;
import java.util.List;

import br.com.direfrog.entidade.Usuario;
import br.com.direfrog.persistencia.UsuarioDao;

public class UsuarioDaoTest {

	public static void main(String[] args) {
//		testeBuscaPorId(10);
		testeBuscaTodos();
	}
	
	
	private static void testeBuscaTodos() {
		List<Usuario> lista = new UsuarioDao().buscaTodos();
		for (Usuario u: lista ){
			System.out.println(u);
		}
		
		
		
	}


	private static void testeBuscaPorId(int id) {
		Usuario user = new Usuario();
		UsuarioDao userDao = new UsuarioDao();
		user=userDao.buscaPorId(id);
		System.out.println(user);
		
	}


	public static void testeAlterar(){
		// criando usuario
		Usuario user = new Usuario();
		user.setNome("Jesus Cristo");
		user.setLogin("INRI");
		user.setSenha("777777");
		user.setId(3);
		
		UsuarioDao userDao = new UsuarioDao();
		userDao.alterar(user);
		System.out.println("Alterado com sucesso!");
		
	}
	
	public static void testeCadastrar(){
		// criando usuario
		Usuario user = new Usuario();
		user.setNome("Jesus");
		user.setLogin("inri");
		user.setSenha("777");
		
		UsuarioDao userDao = new UsuarioDao();
		userDao.cadastrar(user);
		System.out.println("Cadastrado com sucesso!");
		
	}

	public static void testeExcluir(){
		// criando usuario
		Usuario user = new Usuario();
		user.setId(3);
		
		UsuarioDao userDao = new UsuarioDao();
		userDao.excluir(user);
		System.out.println("Excluido com sucesso!");
		
	}
	
	public static void testeSalvar(){
		// criando usuario
		Usuario user = new Usuario();
		user.setNome("Jesus Cristo");
		user.setLogin("inri");
		user.setSenha("777");
		user.setId(4);
		UsuarioDao userDao = new UsuarioDao();
		userDao.salvar(user);
		System.out.println("Criado com sucesso!");
//		user.setNome("Jesus Cristo");
//		user.setId(3);
//		userDao.salvar(user);
		
	}
	
	
	
	
	
	
}
