package br.com.direfrog.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.Attributes.Name;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.direfrog.entity.Archetype;
import br.com.direfrog.entity.ArchetypeBenefit;
import br.com.direfrog.entity.CharSheet;
import br.com.direfrog.service.ArchetypeBenefitService;

@Controller
public class ArchetypeBenefitController {

	@Autowired
	private ArchetypeBenefitService service;
	
	@Autowired
	private ArchetypeController archController;
	
	private List<ArchetypeBenefit> benefitList = new ArrayList<ArchetypeBenefit>();
	
	@PostConstruct
	public void init(){
		Set<ArchetypeBenefit> benefitSet = new HashSet<ArchetypeBenefit>();
		benefitSet=service.findAll();
		benefitList.addAll(benefitSet);
	}
	
	public void save(ArchetypeBenefit benefit){
		service.save(benefit);
	}
	
	public void loadArchBenefitList(CharSheet cs){
		Archetype archetype = cs.getArchetype();
		service.loadArchBenefitList(archetype);
	}

	public List<ArchetypeBenefit> getBenefitList() {
		return benefitList;
	}

	public void setBenefitList(List<ArchetypeBenefit> benefitList) {
		this.benefitList = benefitList;
	}


	
	
}
