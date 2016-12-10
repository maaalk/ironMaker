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
	private ArchetypeBenefitDAO benefitDAO;
	@Autowired
	private CharSheetDAO charDAO;
	@Autowired
	private BookDAO bookDAO;
	@Autowired
	private ArchetypeDAO archetypeDAO;
	
	public void populate() {
		Archetype archA = new Archetype("SKILLED");
		Archetype archB = new Archetype("GIFTED");
		Archetype archC = new Archetype("MIGHTY");
		
		ArchetypeBenefit benefitA = new ArchetypeBenefit("Vendetta", "Descrição Vendetta", archC);
		benefitDAO.save(benefitA);
		ArchetypeBenefit benefitB = new ArchetypeBenefit("Cagey", "Descrição Cagey", archA);
		benefitDAO.save(benefitB);
		
		//Relacionado ao TROLLKIN só para teste
		ArchetypeBenefit benefitC= new ArchetypeBenefit("RACIAL", "Descrição RACIAL", archB);
		benefitDAO.save(benefitC);
		
	}
		       
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = 
	            new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/springbeans.xml");
		Populate p = context.getBean(Populate.class);

		p.populate();

	}

}
