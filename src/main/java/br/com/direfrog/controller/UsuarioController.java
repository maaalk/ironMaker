package br.com.direfrog.controller;

import java.io.IOException;
import java.util.List;

import javax.print.attribute.standard.ReferenceUriSchemesSupported;
import javax.servlet.RequestDispatcher;
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
			List<Usuario> listaUsuario = new UsuarioDao().buscaTodos();
			req.setAttribute("listaUsuario", listaUsuario);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/listausuario.jsp");
			dispatcher.forward(req, resp);
		}	
		if(action.equals("excluir")){
			Usuario user = new Usuario();
			user.setId(Integer.parseInt(req.getParameter("id")));
			new UsuarioDao().excluir(user);
			System.out.println("Action Excluir");
			resp.sendRedirect("usuariocontroller.do?action=list");
		}
		if (action.equals("editar")){
			Usuario user = new Usuario();
			UsuarioDao userDao = new UsuarioDao();
			user = userDao.buscar(Integer.parseInt(req.getParameter("id")));
			req.setAttribute("user", user);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/editausuario.jsp");
			dispatcher.forward(req, resp);
		}
		if (action.equals("novo")){
			Usuario user = new Usuario();
			user.setId(0);
			user.setLogin("");
			user.setNome("");
			user.setSenha("");
			req.setAttribute("user", user);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/editausuario.jsp");
			dispatcher.forward(req, resp);
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
		System.out.println(req.getParameter("id")+"ID");
		if (req.getParameter("id")!=""){
			user.setId(Integer.parseInt(req.getParameter("id")));
		}
			
		System.out.println(user.getId());
		user.setNome(nome);
		user.setLogin(login);
		user.setSenha(senha);
		UsuarioDao userdao = new UsuarioDao();
		userdao.salvar(user);
		resp.sendRedirect("usuariocontroller.do?action=list");
	}
	
}
