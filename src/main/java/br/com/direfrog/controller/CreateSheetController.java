package br.com.direfrog.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.direfrog.entity.Archetype;
import br.com.direfrog.entity.ArchetypeBenefit;
import br.com.direfrog.entity.CharSheet;
import br.com.direfrog.entity.Race;
import br.com.direfrog.entity.Stats;
import br.com.direfrog.entity.raceFactory;
import br.com.direfrog.exception.ControllerException;
import br.com.direfrog.exception.ServiceException;
import br.com.direfrog.service.ArchetypeBenefitService;
import br.com.direfrog.service.ArchetypeService;
import br.com.direfrog.service.CharSheetService;

@Controller
public class CreateSheetController {
	
	@Autowired
	private ArchetypeBenefitService benefitService;	
	@Autowired
	private CharSheetService csService;	
	@Autowired
	private ArchetypeService archetypeService;
	
	/*BEGIN: Archetype Benefit Properties*/
	private Archetype archetype = new Archetype("");
	private List<ArchetypeBenefit> benefitSource = new ArrayList<ArchetypeBenefit>();
    private List<ArchetypeBenefit> benefitTarget = new ArrayList<ArchetypeBenefit>();    
	private DualListModel<ArchetypeBenefit> benefitDualList;
	/*END: Archetype Benefit Properties*/
		
	/*BEGIN: Archetype Properties*/
	private List<Archetype> archetypeList = new ArrayList<Archetype>();
	/*END: Archetype Properties*/
	
	/*BEGIN: Charsheet Properties*/
	private Stats stats = new Stats();
	private CharSheet cs = new CharSheet();
	private Integer level;	
	private Race race;
	/*END: Charsheet Properties*/
	
	@PostConstruct
	public void init(){

		level = 0;
		//race = raceFactory.generateRace("empty");
		race = raceFactory.generateRace("empty", null);
		
		archetypeList = archetypeService.findAll();
		
		newBenefitSource();
		newBenefitTarget();
		newBenefitDualList();
		
	}

	public void loadTrait(){
		System.out.println("LOAD TRAIT");
		newBenefitSource();
		newBenefitTarget();
		newBenefitDualList();
		
		defineRacialStats();

		benefitTarget.addAll(race.getBenefitList());
		
		if(!archetype.getName().equals("")){
			benefitSource.addAll(benefitService.findByArchetype(archetype));
			benefitSource.removeAll(benefitTarget);
		}	
		
		
		//benefitTarget.addAll(race.getBenefitList());
		System.out.println("Benefit LIST: "+race.getBenefitList());
	}
	
	//Reload the table using the Character Archetype
	public void loadBenefitList(){
		
		newBenefitSource();
		newBenefitDualList();
		
		if(archetype.getName().equals("")){
			System.out.println("LOAD BENEFIT LIST");
			benefitSource.addAll(benefitService.findByArchetype(archetype));
		}			
		defineRacialStats();
	}

	public void save() throws ControllerException{
		try{
			//Convert from List to Set in order to add the CharSheet
			Set<ArchetypeBenefit> selectedBenefit = new HashSet<ArchetypeBenefit>();
			selectedBenefit.addAll(benefitDualList.getTarget());
			
			cs.addAllArchetypeBenefit(selectedBenefit);
			cs.setArchetype(archetype);
			
			cs.setStats(stats);
			csService.save(cs);
		}catch (ServiceException e){
			throw new ControllerException("Não salvou",e);
		}
		
	}

	public void loadRace() {
		System.out.println("EVENT: selected race:" + cs.getRace());
		//this.race = raceFactory.generateRace(cs.getRace());
		/*this.race = raceFactory.generateRace(cs.getRace(), archetype);
		this.stats=race.getStats();*/
		//this.benefitList=race.getBenefitList();

		defineRacialStats();
		
		newBenefitTarget();
		newBenefitDualList();

		benefitTarget.addAll(race.getBenefitList());
		System.out.println("Benefit LIST: "+race.getBenefitList());
	}

	/*
	public void defineLevel(ValueChangeEvent e) {
		Integer lvl = Integer.parseInt(e.getNewValue().toString());
		System.out.println("EVENT: lvl:" + lvl);
		if (lvl >= 100) {
			this.level = 2;
		} else if (lvl >= 50) {
			this.level = 1;
		} else
			this.level = 0;
	}
*/
	public void defineLevel() {
		int lvl = cs.getXp();
		System.out.println("EVENT: lvl:" + lvl);
		if (lvl >= 100) {
			this.level = 2;
		} else if (lvl >= 50) {
			this.level = 1;
		} else
			this.level = 0;
	}

	
	public void clear(){
		cs=new CharSheet();
		//race = raceFactory.generateRace("empty");
		race = raceFactory.generateRace("empty", null);
		level = 0;
		
	}


	public ArchetypeBenefitService getBenefitService() {
		return benefitService;
	}


	public void setBenefitService(ArchetypeBenefitService benefitService) {
		this.benefitService = benefitService;
	}


	public CharSheetService getCsService() {
		return csService;
	}


	public void setCsService(CharSheetService csService) {
		this.csService = csService;
	}


	public ArchetypeService getArchetypeService() {
		return archetypeService;
	}


	public void setArchetypeService(ArchetypeService archetypeService) {
		this.archetypeService = archetypeService;
	}

	public Archetype getArchetype() {
		return archetype;
	}


	public void setArchetype(Archetype archetype) {
		this.archetype = archetype;
	}


	public List<ArchetypeBenefit> getBenefitSource() {
		return benefitSource;
	}


	public void setBenefitSource(List<ArchetypeBenefit> benefitSource) {
		this.benefitSource = benefitSource;
	}


	public List<ArchetypeBenefit> getBenefitTarget() {
		return benefitTarget;
	}


	public void setBenefitTarget(List<ArchetypeBenefit> benefitTarget) {
		this.benefitTarget = benefitTarget;
	}


	public DualListModel<ArchetypeBenefit> getBenefitDualList() {
		return benefitDualList;
	}


	public void setBenefitDualList(DualListModel<ArchetypeBenefit> benefitDualList) {
		this.benefitDualList = benefitDualList;
	}


	public List<Archetype> getArchetypeList() {
		return archetypeList;
	}


	public void setArchetypeList(List<Archetype> archetypeList) {
		this.archetypeList = archetypeList;
	}


	public Stats getStats() {
		return stats;
	}


	public void setStats(Stats stats) {
		this.stats = stats;
	}


	public CharSheet getCs() {
		return cs;
	}


	public void setCs(CharSheet cs) {
		this.cs = cs;
	}


	public Integer getLevel() {
		return level;
	}


	public void setLevel(Integer level) {
		this.level = level;
	}


	public Race getRace() {
		return race;
	}


	public void setRace(Race race) {
		this.race = race;
	}
	 
	//Private methods
	private void newBenefitSource(){
		benefitSource = new ArrayList<ArchetypeBenefit>();
	}
	private void newBenefitTarget(){
		benefitTarget = new ArrayList<ArchetypeBenefit>();
	}
	private void newBenefitDualList(){
		benefitDualList = new DualListModel<ArchetypeBenefit>(benefitSource, benefitTarget);
	}
	
	private void defineRacialStats(){
		this.race = raceFactory.generateRace(cs.getRace(), archetype);
		this.stats=race.getStats();
	}
	
}
