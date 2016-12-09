package br.com.direfrog.dao;



import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.direfrog.entity.CharSheet;
import br.com.direfrog.entity.raceFactory;
import br.com.direfrog.exception.DAOException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(defaultRollback = true , transactionManager = "transactionManager")
public class CharSheetDAOTest {
	@Autowired
	CharSheetDAO dao;
	
	
	@Test
	@Transactional
	public void testSaveNew() {
		CharSheet cs = new CharSheet();
		cs.setName("Teste");
		cs.setRace("human");
		cs.setXp((int) Math.random());
		
		CharSheet csSalvo=dao.save(cs);
		
		Assert.assertEquals(csSalvo.getName(),cs.getName());
		Assert.assertEquals(csSalvo.getRace(),cs.getRace());
		Assert.assertEquals(csSalvo.getXp(),cs.getXp());
		
	}
	
	@Test
	@Transactional
	public void testSaveWithStats() {
		CharSheet cs = new CharSheet();
		cs.setName("Teste");
		cs.setRace("human");
		cs.setXp((int) Math.random());
		cs.setStats(raceFactory.generateRace(cs.getRace()));
		
		CharSheet csSalvo=dao.save(cs);
		
		Assert.assertEquals(csSalvo.getName(),cs.getName());
		Assert.assertEquals(csSalvo.getRace(),cs.getRace());
		Assert.assertEquals(csSalvo.getXp(),cs.getXp());
		Assert.assertEquals(cs.getStats().getBaseAgi(),csSalvo.getStats().getBaseAgi());
		Assert.assertEquals(cs.getStats().getMaxAgi(),csSalvo.getStats().getMaxAgi());
		
	}
	
	@Test
	@Transactional
	public void testUpdate(){
		CharSheet cs = new CharSheet();
		cs.setName("Teste");
		cs.setRace("human");
		cs.setXp((int) Math.random());
		
		cs=dao.save(cs);
		
		cs.setName("atualizado");
		cs.setRace("atualizado");
		cs.setXp(10);
		
		CharSheet csSalvo = dao.save(cs);
		
		Assert.assertEquals(csSalvo.getName(),"atualizado");
		Assert.assertEquals(csSalvo.getRace(),"atualizado");
		Assert.assertEquals(csSalvo.getXp().toString(),"10");
		Assert.assertEquals(csSalvo.getId(),cs.getId());
		
	}
	
	@Test
	@Transactional
	public void testUpdateStats(){
		CharSheet cs = new CharSheet();
		cs.setStats(raceFactory.generateRace("human"));
		
		cs=dao.save(cs);
		
		cs.setStats(raceFactory.generateRace("trollkin"));
		CharSheet csSalvo = dao.save(cs);
		
		Assert.assertEquals(csSalvo.getStats().getBasePhy().toString(),"6");
		Assert.assertEquals(csSalvo.getStats().getId(),cs.getStats().getId());
		Assert.assertEquals(csSalvo.getId(),cs.getId());
		System.out.println(csSalvo.getStats().getId()+"=="+cs.getStats().getId());
	}
	
	@Test
	@Transactional
	public void testFindByIdOk(){
		CharSheet cs = new CharSheet();
		cs.setName("Teste");
		cs.setRace("human");
		cs.setXp((int) Math.random());
		cs.setStats(raceFactory.generateRace("human"));
		
		cs=dao.save(cs);
		
		CharSheet csFound = dao.findById(cs.getId());
		
		Assert.assertEquals(csFound,cs);
	}
	
	@Test
	@Transactional
	public void testFindByIdNotOk(){
				
		CharSheet csFound = dao.findById(999);
		
		Assert.assertEquals(csFound,null);
	}
	
	
	@Test
	@Transactional
	public void testDelete() throws DAOException{
		CharSheet cs = new CharSheet();
		cs.setName("Teste");
		cs.setRace("human");
		cs.setXp((int) Math.random());
		cs.setStats(raceFactory.generateRace("human"));
		
		cs=dao.save(cs);
		
		
		dao.delete(cs);
		
		CharSheet csFound = dao.findById(cs.getId());
		
		Assert.assertEquals(csFound,null);

	}
	
	@Test
	@Transactional
	public void testNotDelete(){
		CharSheet cs = new CharSheet();
		cs.setName("Teste");
		cs.setRace("human");
		cs.setXp((int) Math.random());
		cs.setStats(raceFactory.generateRace("human"));
		
		cs=dao.save(cs);
		
		try{
			dao.delete(cs);
			System.out.println("DELETOU");
			dao.delete(cs);
			System.out.println("deletou?");
		} catch(Exception e){
			System.out.println("DELETE:"+e.getMessage());
			
		} 		

	}
	
	@Test
	@Transactional
	public void testFindAll(){
		List<CharSheet> list = dao.findAll();
		CharSheet cs = new CharSheet();
		dao.save(cs);
		List<CharSheet> list2 = dao.findAll();
		
		Assert.assertEquals(list.size()+1, list2.size());
	}
	
}
