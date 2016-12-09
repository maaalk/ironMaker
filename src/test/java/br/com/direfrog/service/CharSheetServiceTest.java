package br.com.direfrog.service;



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
import br.com.direfrog.exception.ServiceException;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/springbeans.xml")
@TransactionConfiguration(defaultRollback = true , transactionManager = "transactionManager")
public class CharSheetServiceTest {
	@Autowired
	CharSheetService svc;
	
	
	@Test
	@Transactional
	public void testSaveNew() throws ServiceException {
		CharSheet cs = new CharSheet();
		cs.setName("Teste");
		cs.setRace("human");
		cs.setXp((int) Math.random());
		
		CharSheet csSalvo=svc.save(cs);
		
		Assert.assertEquals(csSalvo.getName(),cs.getName());
		Assert.assertEquals(csSalvo.getRace(),cs.getRace());
		Assert.assertEquals(csSalvo.getXp(),cs.getXp());
		
	}
	
	
	
	@Test
	@Transactional
	public void testSaveWithStats() throws ServiceException {
		CharSheet cs = new CharSheet();
		cs.setName("Teste");
		cs.setRace("human");
		cs.setXp((int) Math.random());
		cs.setStats(raceFactory.generateRace(cs.getRace()));
		
		CharSheet csSalvo=svc.save(cs);
		
		Assert.assertEquals(csSalvo.getName(),cs.getName());
		Assert.assertEquals(csSalvo.getRace(),cs.getRace());
		Assert.assertEquals(csSalvo.getXp(),cs.getXp());
		Assert.assertEquals(cs.getStats().getBaseAgi(),csSalvo.getStats().getBaseAgi());
		Assert.assertEquals(cs.getStats().getMaxAgi(),csSalvo.getStats().getMaxAgi());
		
	}
	
	
	
	@Test
	@Transactional
	public void testUpdate() throws ServiceException{
		CharSheet cs = new CharSheet();
		cs.setName("Teste");
		cs.setRace("human");
		cs.setXp((int) Math.random());
		
		cs=svc.save(cs);
		
		cs.setName("atualizado");
		cs.setRace("atualizado");
		cs.setXp(10);
		
		CharSheet csSalvo = svc.save(cs);
		
		Assert.assertEquals(csSalvo.getName(),"atualizado");
		Assert.assertEquals(csSalvo.getRace(),"atualizado");
		Assert.assertEquals(csSalvo.getXp().toString(),"10");
		Assert.assertEquals(csSalvo.getId(),cs.getId());
		
	}
	
	
	@Test
	@Transactional
	public void testUpdateStats() throws ServiceException{
		CharSheet cs = new CharSheet();
		cs.setStats(raceFactory.generateRace("human"));
		
		cs=svc.save(cs);
		
		cs.setStats(raceFactory.generateRace("trollkin"));
		CharSheet csSalvo = svc.save(cs);
		
		Assert.assertEquals(csSalvo.getStats().getBasePhy().toString(),"6");
		Assert.assertEquals(csSalvo.getStats().getId(),cs.getStats().getId());
		Assert.assertEquals(csSalvo.getId(),cs.getId());
		System.out.println(csSalvo.getStats().getId()+"=="+cs.getStats().getId());
	}
	
	@Test
	@Transactional
	public void testFindByIdOk() throws ServiceException{
		CharSheet cs = new CharSheet();
		cs.setName("Teste");
		cs.setRace("human");
		cs.setXp((int) Math.random());
		cs.setStats(raceFactory.generateRace("human"));
		
		cs=svc.save(cs);
		
		CharSheet csFound = svc.findById(cs.getId());
		
		Assert.assertEquals(csFound,cs);
	}
	
	@Test
	@Transactional
	public void testFindByIdNotOk(){
				
		CharSheet csFound = svc.findById(999);
		
		Assert.assertEquals(csFound,null);
	}
	
	
	@Test
	@Transactional
	public void testDelete() throws ServiceException{
		CharSheet cs = new CharSheet();
		cs.setName("Teste");
		cs.setRace("human");
		cs.setXp((int) Math.random());
		cs.setStats(raceFactory.generateRace("human"));
		
		cs=svc.save(cs);
		
		
		svc.delete(cs);
		
		CharSheet csFound = svc.findById(cs.getId());
		
		Assert.assertEquals(csFound,null);

	}
	
	@Test
	@Transactional
	public void testNotDelete() throws ServiceException{
		String erro="";
		CharSheet cs = new CharSheet();
		cs.setName("Teste");
		cs.setRace("human");
		cs.setXp((int) Math.random());
		cs.setStats(raceFactory.generateRace("human"));
		
		cs=svc.save(cs);
		
		svc.delete(cs);
		System.out.println("DELETOU");
		try{
			svc.delete(cs);
		}catch (Exception e){
			System.out.println("deletou?");
			System.out.println("DELETE:"+e.getMessage());
			Assert.assertEquals(e.getMessage(),"Não foi Possivel Excluir");
			erro=e.getMessage();
		}
				
		Assert.assertEquals(erro,"Não foi Possivel Excluir");
	}
	
	
}
