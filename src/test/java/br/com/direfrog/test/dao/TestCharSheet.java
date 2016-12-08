package br.com.direfrog.test.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SpringJtaSessionContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.direfrog.dao.ArchetypeBenefitDAO;
import br.com.direfrog.dao.CharSheetDAO;
import br.com.direfrog.entity.ArchetypeBenefit;
import br.com.direfrog.entity.CharSheet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
public class TestCharSheet {
	
	@Autowired
	private CharSheetDAO dao;
	
	@Autowired
	private ArchetypeBenefitDAO daoB;
	
	@Transactional
	@Test
	public void test(){
		
		CharSheet c = new CharSheet();
		
		ArchetypeBenefit benefit = new ArchetypeBenefit();
		benefit.setDescription("lalal");
		benefit.setName("vendeta");
		
		//ArchetypeBenefit retorno = daoB.save(benefit);
				
		//benefit = daoB.findById(retorno.getId());
		
		Set<ArchetypeBenefit> lista = new HashSet<ArchetypeBenefit>();
		lista.add(benefit);
		
		c.setRace("hah");
		c.setBenefitList(lista);
		
		dao.save(c);
		
		Set<CharSheet> listaC = new HashSet<CharSheet>();
		listaC.add(c);
		
		/*benefit.setCharSheetList(listaC);
		daoB.save(benefit);	*/	
	}

}
