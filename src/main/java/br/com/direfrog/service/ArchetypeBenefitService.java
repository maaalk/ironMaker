package br.com.direfrog.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.direfrog.dao.ArchetypeBenefitDAO;
import br.com.direfrog.entity.Archetype;
import br.com.direfrog.entity.ArchetypeBenefit;

@Service
public class ArchetypeBenefitService {

	@Autowired
	private ArchetypeBenefitDAO dao;
	
	public void save(ArchetypeBenefit benefit){
		dao.save(benefit);
	}

	public void loadArchBenefitList(Archetype archetype) {
				
	}

	public Set<ArchetypeBenefit> findAll() {
		return dao.findAllBySet();
	}

	public ArchetypeBenefit findById(int id) {
		return dao.findById(id);
	}
	
	public Set<ArchetypeBenefit> findByType(String type) {
		return dao.findByType(type);
	}
	
}
