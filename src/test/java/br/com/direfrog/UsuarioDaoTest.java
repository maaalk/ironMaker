package br.com.direfrog;

import br.com.direfrog.entidade.Usuario;
import br.com.direfrog.persistencia.UsuarioDao;

public class UsuarioDaoTest {

	public static void main(String[] args) {
		testeExcluir();
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
}
