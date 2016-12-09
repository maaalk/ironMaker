package br.com.direfrog.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.direfrog.dao.ArchetypeBenefitDAO;
import br.com.direfrog.entity.Archetype;
import br.com.direfrog.entity.ArchetypeBenefit;

public class ArchetypeBenefitFactory {

	@Autowired
	private static ArchetypeBenefitDAO dao;
	
	/*public static Set<ArchetypeBenefit> createBenefit (String archetype){
		
		return dao.findByArchetype(archetype);
	}*/
	
}
