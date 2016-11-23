package br.com.direfrog;

import java.util.List;

import br.com.direfrog.entidade.CharSheet;
import br.com.direfrog.persistencia.CharSheetDao;

public class CharacterDaoTest {

	public static void main(String[] args) {

		CharSheet c = new CharSheet();
		c.setAgi(5);
		c.setArc(5);
		c.setIntel(5);
		c.setName("Morgorth");
		c.setPer(5);
		c.setPhy(5);
		c.setPoi(5);
		c.setPrw(5);
		c.setSpd(5);
		c.setStr(5);
		
		c.setId(3);
		
		testaCadastro(c);
		//testaAlterar(c);
		//testaBuscar(c);
		//testaBuscaTodos();
		//testaSalvar(c);
		//testaExcluir(c);

	}
	
	public static void testaCadastro(CharSheet c){
		CharSheetDao cdao = new CharSheetDao();
		cdao.cadastrar(c);
		System.out.println("Cadastro");
	}
	
	public static void testaAlterar(CharSheet c){
		CharSheetDao cdao = new CharSheetDao();
		cdao.alterar(c);
		System.out.println("Alteração");
	}
	
	public static void testaBuscar(CharSheet c){
		CharSheetDao cdao = new CharSheetDao();
		System.out.println(cdao.buscar(c.getId()));
		System.out.println("Busca");
	}
	
	public static void testaBuscaTodos(){
		CharSheetDao cdao = new CharSheetDao();
		List<CharSheet> lista = cdao.buscaTodos();
		for (CharSheet c: lista){
			System.out.println(c);
		}
		System.out.println("BuscaTodos");
	}
	
	public static void testaSalvar(CharSheet c){
		CharSheetDao cdao = new CharSheetDao();
		if(c.getId()!=null && c.getId()!=0){
			System.out.println("alterou");
		}else{
			System.out.println("salvou");
		}
		cdao.salvar(c);
		System.out.println("salvar");
	}
	
	public static void testaExcluir(CharSheet c){
		CharSheetDao cdao = new CharSheetDao();
		cdao.excluir(c);
		System.out.println("Excluir");
	}

}
