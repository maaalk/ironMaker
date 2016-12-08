package br.com.direfrog.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.direfrog.entity.ArchetypeBenefit;

@Repository
public class ArchetypeBenefitDAO extends GenericDAO<ArchetypeBenefit> {

	public Set<ArchetypeBenefit> findAllBySet(){
		String className = param.getSimpleName();
		
		Query q = em.createQuery("select obj from "+className+" obj");
		List <ArchetypeBenefit> resultList = q.getResultList();
		Set<ArchetypeBenefit> resultSet = new HashSet<ArchetypeBenefit>();
		resultSet.addAll(resultList);
		return resultSet;
	}
	
	public Set<ArchetypeBenefit> findByType(String type){
		String className = param.getSimpleName();
		
		Query q = em.createQuery("select obj from "+className+" obj where obj.type:=typeParam");
		q.setParameter("typeParam", type);
		List <ArchetypeBenefit> resultList = q.getResultList();
		
		Set<ArchetypeBenefit> resultSet = new HashSet<ArchetypeBenefit>();
		resultSet.addAll(resultList);
		return resultSet;
	}
}
