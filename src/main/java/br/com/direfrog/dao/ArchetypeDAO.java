package br.com.direfrog.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.direfrog.entity.Archetype;

@Repository
public class ArchetypeDAO extends GenericDAO<Archetype>{

	String className = param.getSimpleName();
	
	public Archetype findByName(String name) {
		Query q = em.createQuery("select obj from "+className+" obj where obj.name=:nameParam");
		q.setParameter("nameParam", name);
		Archetype arch = (Archetype) q.getSingleResult();
		return arch;
	}

}
