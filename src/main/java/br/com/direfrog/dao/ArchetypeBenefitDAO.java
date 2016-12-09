package br.com.direfrog.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.direfrog.entity.ArchetypeBenefit;

@Repository
public class ArchetypeBenefitDAO extends GenericDAO<ArchetypeBenefit> {

	public Set<ArchetypeBenefit> findAllBySet() {
		String className = param.getSimpleName();

		Query q = em.createQuery("select obj from " + className + " obj");
		List<ArchetypeBenefit> resultList = q.getResultList();
		Set<ArchetypeBenefit> resultSet = new HashSet<ArchetypeBenefit>();
		resultSet.addAll(resultList);
		return resultSet;
	}

	public Set<ArchetypeBenefit> findByArchetypeId(Integer id) {
		String className = param.getSimpleName();

		Query q = em.createQuery("select obj from " + className + " obj where obj.archetype.id=:idParam");
		q.setParameter("idParam", id);
		List<ArchetypeBenefit> resultList = q.getResultList();

		Set<ArchetypeBenefit> resultSet = new HashSet<ArchetypeBenefit>();
		resultSet.addAll(resultList);
		return resultSet;
	}

	public ArchetypeBenefit findByName(String name) {
		String className = param.getSimpleName();

		Query q = em.createQuery("select obj from " + className + " obj where obj.name=:nameParam");
		q.setParameter("nameParam", name);
		return (ArchetypeBenefit) q.getSingleResult();
	}

}
