package br.com.direfrog.dao;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.direfrog.exception.DAOException;


@Repository
public abstract class GenericDAO <Objeto>{

	@PersistenceContext
	protected EntityManager em;
	
	protected Class<Objeto> param;
	
	public GenericDAO (EntityManager em){
		this.em = em;
	}
	
	public GenericDAO(){
		//This code will get the object inside the class parameter <Objeto>
		param = ((Class) ((ParameterizedType) getClass().
				getGenericSuperclass()).getActualTypeArguments()[0]);

	}
	
	@Transactional
	public Objeto save(Objeto obj) {
		return em.merge(obj);
	}

	@Transactional
	public void delete(Objeto obj) throws DAOException {
		//Realocate the object into the Spring Context
		Objeto managedObj = em.merge(obj);
		try{
			em.remove(managedObj);
		}catch (Exception e) {
			throw new DAOException("N�o foi poss�vel excluir", e);
		}
		
	}

	public Objeto findById(Integer id) {
		return em.find(param, id);
	}

	public List<Objeto> findAll() {
		/*It will return the param class name. 
		Ex: If param was Usuario.class, it will return Usuario*/
		String className = param.getSimpleName();
		
		Query q = em.createQuery("select obj from "+className+" obj");
		return q.getResultList();
	}

}
