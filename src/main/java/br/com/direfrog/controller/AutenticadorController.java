package br.com.direfrog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.direfrog.UsuarioDaoTest;
import br.com.direfrog.entidade.Usuario;
import br.com.direfrog.persistencia.UsuarioDao;

@WebServlet("/autenticador.do")
public class AutenticadorController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//tenta acessar sessao, mas se nao achar, nao cria
		HttpSession sessao = req.getSession(false);
		if (sessao!=null){
			sessao.invalidate();
		}
		resp.sendRedirect("login.html");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		//captura dados da tela
		String login=req.getParameter("login");
		String senha=req.getParameter("senha");
		//coloca dados no objeto usuario
		Usuario user= new Usuario();
		user.setLogin(login);
		user.setSenha(senha);
		//verifica se existe registro com login e senha indicados e retorna usuario		
		UsuarioDao userDao=new UsuarioDao();
		Usuario usuarioAutenticado=userDao.autentica(user);
		//verifica se usuario foi encontrado
		if (usuarioAutenticado!=null){
			System.out.println("Login com sucesso!");
			//coloca usuario na sessão
			HttpSession sessao = req.getSession();
			sessao.setAttribute("usuarioAutenticado", usuarioAutenticado);
			//redirecionando usuario para tela principal
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);;
		} else{
			System.out.println("Login falhou!");
			resp.sendRedirect("login.html");
		}
		
	}
}
