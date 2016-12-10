package br.com.direfrog.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.direfrog.entity.Archetype;
import br.com.direfrog.entity.ArchetypeBenefit;
import br.com.direfrog.service.ArchetypeBenefitService;
import br.com.direfrog.service.ArchetypeService;

@Controller
public class ArchetypeBenefitController {

	@Autowired
	private ArchetypeBenefitService service;
	
	private List<ArchetypeBenefit> benefitList = new ArrayList<ArchetypeBenefit>();
	private Archetype archetype;

	private List<ArchetypeBenefit> benefitSource = new ArrayList<ArchetypeBenefit>();
    private List<ArchetypeBenefit> benefitTarget = new ArrayList<ArchetypeBenefit>();
    
	private DualListModel<ArchetypeBenefit> benefitDualList;
	
	@PostConstruct
	public void init(){

		benefitSource = new ArrayList<ArchetypeBenefit>();
		benefitTarget = new ArrayList<ArchetypeBenefit>();
		benefitDualList = new DualListModel<ArchetypeBenefit>(benefitSource, benefitTarget);
		
	}

	
	public void save(ArchetypeBenefit benefit){
		service.save(benefit);
	}
	

	//Reload the table using the Character Archetype
	public void loadBenefitList(){
		
		benefitSource = new ArrayList<ArchetypeBenefit>();
		benefitTarget = new ArrayList<ArchetypeBenefit>();
		benefitDualList = new DualListModel<ArchetypeBenefit>(benefitSource, benefitTarget);
		
		benefitSource.addAll(service.findByArchetype(archetype));
		
	}

	
	//GETs and SETs
	public List<ArchetypeBenefit> getBenefitList() {
		return benefitList;
	}

	public void setBenefitList(List<ArchetypeBenefit> benefitList) {
		this.benefitList = benefitList;
	}

	public Archetype getArchetype() {
		return archetype;
	}

	public void setArchetype(Archetype archetype) {
		this.archetype = archetype;
	}


	public DualListModel<ArchetypeBenefit> getBenefitDualList() {
		return benefitDualList;
	}

	public void setBenefitDualList(DualListModel<ArchetypeBenefit> benefitDualList) {
		this.benefitDualList = benefitDualList;
	}



	
}
