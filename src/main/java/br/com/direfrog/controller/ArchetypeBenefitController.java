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
	//private String result;
	
	//TESTES
	private DualListModel<ArchetypeBenefit> benefitDualList;
	//TESTE
	
	@PostConstruct
	public void init(){
		//TESTE
		List<ArchetypeBenefit> benefitSource = new ArrayList<ArchetypeBenefit>();
        List<ArchetypeBenefit> benefitTarget = new ArrayList<ArchetypeBenefit>();
         
        benefitSource.add(service.findById(1));
        benefitSource.add(service.findById(2));
        benefitDualList = new DualListModel<ArchetypeBenefit>(benefitSource, benefitTarget);
		//TESTE
		
		
		
		//Set<ArchetypeBenefit> benefitSet = new HashSet<ArchetypeBenefit>();
		//benefitSet=service.findAll();
		
		//benefitList = new ArrayList<ArchetypeBenefit>();
		//benefitList.addAll(service.findByArchetype(archetype));
		
		//benefitList.addAll(benefitSet);
	}
	
	public void save(ArchetypeBenefit benefit){
		service.save(benefit);
	}
	

	//Reload the table using the Character Archetype
	public void loadBenefitList(){
		
		try {
			//String race = e.getNewValue().toString();
			System.out.println("ddddddddddddddddddddddddddddddddddddddd");
//			result = "called by " + event.getComponent().getClass().getName();
			benefitList = new ArrayList<ArchetypeBenefit>();
			benefitList.addAll(service.findByArchetype(archetype));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("44444444444444444444444444444");
		}
		
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
