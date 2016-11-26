package br.com.direfrog.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.direfrog.entidade.CharSheet;

import br.com.direfrog.persistencia.CharSheetDao;


@WebServlet("/charsheet.do")
public class CharSheetController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action= req.getParameter("action");
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/sheetform.jsp");
		dispatcher.forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Chamou Post");
		String nome = req.getParameter("nome");
		int phy = Integer.parseInt(req.getParameter("phy"));
		int str = Integer.parseInt(req.getParameter("str"));
		int spd = Integer.parseInt(req.getParameter("spd"));
		int agi = Integer.parseInt(req.getParameter("agi"));
		int prw = Integer.parseInt(req.getParameter("prw"));
		int poi = Integer.parseInt(req.getParameter("poi"));
		int intel = Integer.parseInt(req.getParameter("intel"));
		int arc = Integer.parseInt(req.getParameter("arc"));
		int per = Integer.parseInt(req.getParameter("per"));
		CharSheet character=new CharSheet();
		/*System.out.println(req.getParameter("id")+"ID");
		if (req.getParameter("id")!=""){
			user.setId(Integer.parseInt(req.getParameter("id")));
		}*/
		character.setAgi(agi);
		character.setArc(arc);
		character.setIntel(intel);
		character.setName(nome);
		character.setPer(per);
		character.setPhy(phy);
		character.setPoi(poi);
		character.setPrw(prw);
		character.setSpd(spd);
		character.setStr(str);
		
		
		CharSheetDao cdao = new CharSheetDao();
		cdao.salvar(character);
		resp.sendRedirect("charsheet.do");
	}

}
