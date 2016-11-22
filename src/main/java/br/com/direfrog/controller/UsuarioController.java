package br.com.direfrog.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.direfrog.entidade.Usuario;
import br.com.direfrog.persistencia.UsuarioDao;

//http://localhost:8080/ironMaker/usuariocontroller.do
@WebServlet("/usuariocontroller.do")
public class UsuarioController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("Chamou Get");
		String action = req.getParameter("action");
		System.out.println(action);
		if (action.equals("list")){
			System.out.println("entrou");
			List<Usuario> lista = new UsuarioDao().buscaTodos();
			System.out.println("Action Listar");
			resp.getWriter().print("Lista!");
		}else if(action.equals("excluir")){
			Usuario user = new Usuario();
			user.setId(Integer.parseInt(req.getParameter("id")));
			new UsuarioDao().excluir(user);
			System.out.println("Action Excluir");
			resp.getWriter().print("Excluiu "+user);
			
		}
					
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("Chamou Post");
		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario user=new Usuario();
		if (req.getParameter("id")!=""){
			user.setId(Integer.parseInt(req.getParameter("id")));
		}
			
		System.out.println(user.getId());
		user.setNome(nome);
		user.setLogin(login);
		user.setSenha(senha);
		UsuarioDao userdao = new UsuarioDao();
		userdao.salvar(user);
		resp.getWriter().print("Sucesso!");
	}
	
}
