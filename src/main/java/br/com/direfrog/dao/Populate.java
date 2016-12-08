package br.com.direfrog.dao;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.ArgumentConvertingMethodInvoker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.direfrog.entity.Archetype;
import br.com.direfrog.entity.ArchetypeBenefit;
import br.com.direfrog.entity.Book;
import br.com.direfrog.entity.CharSheet;
import br.com.direfrog.exception.DAOException;

@Component
public class Populate {

	@Autowired
	private ArchetypeBenefitDAO archDao;
	@Autowired
	private CharSheetDAO charDAO;
	@Autowired
	private BookDAO bookDAO;
	@Autowired
	private ArchetypeDAO archetypeDAO;
	
	public void preencher() {
		       
		

		Book book = new Book();
		book.setName("FMF - CORE");
		Book returnBook = bookDAO.save(book);
		
		ArchetypeBenefit benefit = new ArchetypeBenefit();
		benefit.setDescription("descricao vendetta");
		benefit.setName("Vendetta");
		benefit.setBook(returnBook);

		// ArchetypeBenefit retorno = daoB.save(benefit);

		// benefit = daoB.findById(retorno.getId());
		
		
		
		ArchetypeBenefit returnBenefit = archDao.save(benefit);

		//ArchetypeBenefit returnBenefit2 = archDao.findById(returnBenefit.getId());
		
		Set<ArchetypeBenefit> lista = new HashSet<ArchetypeBenefit>();
		lista.add(returnBenefit);

		CharSheet c = new CharSheet();
		c.setRace("ELFO");
		c.setBenefitList(lista);

		charDAO.save(c);

		
		
		//Set<CharSheet> listaC = new HashSet<CharSheet>();
		//listaC.add(c);

		//benefit.setCharSheetList(listaC);
		//archDao.save(benefit);
		
		
	}
	
	public void atualizar(){
		CharSheet ch = new CharSheet();
		ch = charDAO.findById(1);
		Set<CharSheet> listaC = new HashSet<CharSheet>();
		listaC.add(ch);
		
		ArchetypeBenefit arch = new ArchetypeBenefit();
		arch = archDao.findById(1);
		Set<ArchetypeBenefit> listaB = new HashSet<ArchetypeBenefit>();
		listaB.add(arch);
		
		ch.setBenefitList(listaB);
		charDAO.save(ch);
		
		
		
	}
	

	public void novo(){
		ArchetypeBenefit arch = new ArchetypeBenefit();
		arch = archDao.findById(1);
		Set<ArchetypeBenefit> listaB = new HashSet<ArchetypeBenefit>();
		listaB.add(arch);
		
		CharSheet c = new CharSheet();
		c.setRace("HUMANO");
		c.setBenefitList(listaB);
		
		charDAO.save(c);
	}
	
	public void test(){
		Set<ArchetypeBenefit> listaB = new HashSet<ArchetypeBenefit>();
		listaB = archDao.findAllBySet();
		System.out.println(listaB);
	}

	public void delete(){
		ArchetypeBenefit arch = new ArchetypeBenefit();
		arch = archDao.findById(1);
		
		try {
			archDao.delete(arch);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteBook(){
		Book b = new Book();
		b = bookDAO.findById(1);
		
		try {
			bookDAO.delete(b);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void novoA(){
		Archetype a = new Archetype();
		a.setName("SKILED");
		archetypeDAO.save(a);
		Archetype a2 = new Archetype();
		a2.setName("GIFTED");
		archetypeDAO.save(a2);
	}
	
	public void novoB(){
		ArchetypeBenefit arch = new ArchetypeBenefit();
		arch.setName("Cadey");
		archDao.save(arch);
	}
	
	public void findAll() {
		Set<ArchetypeBenefit> lista = archDao.findAllBySet();
		for (ArchetypeBenefit a : lista) {
			System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = 
	            new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
		Populate p = context.getBean(Populate.class);

	//p.preencher();
		p.novoB();
		//p.atualizar();
		//p.test();
		//p.deleteBook();
		//p.delete();
		//p.findAll();
	}

}
