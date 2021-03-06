package br.com.direfrog.test.dao;

import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SpringJtaSessionContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.direfrog.dao.ArchetypeBenefitDAO;
import br.com.direfrog.entity.ArchetypeBenefit;
import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
public class TestArchetypeBenefit {
	
	@Autowired
	private ArchetypeBenefitDAO dao;
	
	@Test
	public void testSave(){
		
		ArchetypeBenefit benefit = new ArchetypeBenefit();
		benefit.setDescription("lalal");
		benefit.setName("vendeta");
		
		dao.save(benefit);
	}
	
	@Test
	public void testFindAllBySet(){
		
		ArchetypeBenefit benefit = new ArchetypeBenefit();
		benefit.setDescription("lalal");
		benefit.setName("vendeta");
		
		ArchetypeBenefit retorno = dao.save(benefit);
		
		Set<ArchetypeBenefit> lista = dao.findAllBySet();
		
		Assert.assertTrue(lista.size()>0);
	}
	
	@Test
	public void testFindByArchetypeId(){
		Set<ArchetypeBenefit> lista = dao.findByArchetypeId(1);
		Assert.assertTrue(lista.size()>0);
	}
	
	@Test
	public void testFindByName(){
		String name = "testando";
		ArchetypeBenefit benefit = new ArchetypeBenefit();
		benefit.setDescription("lalal");
		benefit.setName(name);
		
		ArchetypeBenefit benefitSaved = dao.save(benefit);
		
		ArchetypeBenefit result = dao.findByName(name);
		Assert.assertEquals(benefitSaved.getName(), result.getName());
		Assert.assertEquals(benefitSaved.getDescription(), result.getDescription());
		Assert.assertEquals(benefitSaved.getId(), result.getId());
	}

}
