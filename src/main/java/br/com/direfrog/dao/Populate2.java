package br.com.direfrog.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.ArgumentConvertingMethodInvoker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.direfrog.entity.ArchetypeBenefit;
import br.com.direfrog.entity.Book;
import br.com.direfrog.entity.CharSheet;

@Component
public class Populate2 {

	@Autowired
	private ArchetypeBenefitDAO archDao;
	@Autowired
	private CharSheetDAO charDAO;
	@Autowired
	private BookDAO bookDAO;
	
	public void preencher() {
		       
			
		ArchetypeBenefit benefit = new ArchetypeBenefit();
		benefit.setDescription("descricao vendetta");
		benefit.setName("Vendetta");

		ArchetypeBenefit benefit2 = new ArchetypeBenefit();
		benefit2.setDescription("descricao vendetta2");
		benefit2.setName("Vendetta2");

		Set<ArchetypeBenefit> lista = new HashSet<ArchetypeBenefit>();
		lista.add(benefit);
		lista.add(benefit2);
		
		Book book = new Book();
		book.setName("FMF - CORE");
		List<Book> listBook = new ArrayList<Book>();
		//book.setBenefitList(benefit);
		Book returnBook = bookDAO.save(book);
		
		// ArchetypeBenefit retorno = daoB.save(benefit);

		// benefit = daoB.findById(retorno.getId());
		
		
		
		//ArchetypeBenefit returnBenefit = archDao.save(benefit);

		//ArchetypeBenefit returnBenefit2 = archDao.findById(returnBenefit.getId());
		
		/*Set<ArchetypeBenefit> lista = new HashSet<ArchetypeBenefit>();
		lista.add(returnBenefit);*/

		/*CharSheet c = new CharSheet();
		c.setRace("ELFO");
		c.setBenefitList(lista);

		charDAO.save(c);*/

		
		
		//Set<CharSheet> listaC = new HashSet<CharSheet>();
		//listaC.add(c);

		//benefit.setCharSheetList(listaC);
		//archDao.save(benefit);
		
		
	}
	
	public void preencher2() {
		Book book = new Book();
		book.setName("FMF - CORE");
		
		ArchetypeBenefit benefit = new ArchetypeBenefit();
		benefit.setDescription("descricao vendetta");
		benefit.setName("Vendetta");
		benefit.setBook(book);

		ArchetypeBenefit benefit2 = new ArchetypeBenefit();
		benefit2.setDescription("descricao vendetta2");
		benefit2.setName("Vendetta2");

		Set<ArchetypeBenefit> lista = new HashSet<ArchetypeBenefit>();
		lista.add(benefit);
		lista.add(benefit2);
		
		archDao.save(benefit);
		
		/*Book book = new Book();
		book.setName("FMF - CORE");
		//book.setBenefitList(benefit);
		Book returnBook = bookDAO.save(book);*/
		
		// ArchetypeBenefit retorno = daoB.save(benefit);

		// benefit = daoB.findById(retorno.getId());
		
		
		
		//ArchetypeBenefit returnBenefit = archDao.save(benefit);

		//ArchetypeBenefit returnBenefit2 = archDao.findById(returnBenefit.getId());
		
		/*Set<ArchetypeBenefit> lista = new HashSet<ArchetypeBenefit>();
		lista.add(returnBenefit);*/

		/*CharSheet c = new CharSheet();
		c.setRace("ELFO");
		c.setBenefitList(lista);

		charDAO.save(c);*/

		
		
		//Set<CharSheet> listaC = new HashSet<CharSheet>();
		//listaC.add(c);

		//benefit.setCharSheetList(listaC);
		//archDao.save(benefit);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = 
	            new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
		Populate2 p = context.getBean(Populate2.class);

		p.preencher2();
		//p.atualizar();
		//p.novo();
	}

}
