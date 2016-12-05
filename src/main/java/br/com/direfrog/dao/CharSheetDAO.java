package br.com.direfrog.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.com.direfrog.entity.CharSheet;
import br.com.direfrog.exception.DAOException;


@Repository
public class CharSheetDAO{

	@PersistenceContext
	EntityManager em;
	
	public CharSheetDAO(EntityManager em){
		this.em = em;
		
	}
	
	public CharSheetDAO() {
		// TODO Auto-generated constructor stub
	}
	

	
	@Transactional
	public CharSheet salvar(CharSheet entrada) {
		CharSheet sheet= em.merge(entrada);
		return sheet;
	}
	
	@Transactional
	public void excluir(CharSheet entrada) throws DAOException{		
		try{
			em.remove(entrada);
		}catch (Exception e){
			throw new DAOException("Não foi possível excluir",e);
		}
	}

	public List<CharSheet> buscarTodos() {
		Query q = em.createQuery("select u from CharSheet u");
		return q.getResultList();
	}

	public CharSheet buscar(int id) {
		return em.find(CharSheet.class, id);
	}
}
