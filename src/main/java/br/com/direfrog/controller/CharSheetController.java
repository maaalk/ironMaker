package br.com.direfrog.controller;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.direfrog.entity.ArchetypeBenefit;
import br.com.direfrog.entity.CharSheet;
import br.com.direfrog.entity.Race;
import br.com.direfrog.entity.Stats;
import br.com.direfrog.entity.raceFactory;
import br.com.direfrog.exception.ControllerException;
import br.com.direfrog.exception.ServiceException;
import br.com.direfrog.service.ArchetypeService;
import br.com.direfrog.service.CharSheetService;
import br.com.direfrog.service.StatsService;

@Controller(value = "csCtrl")
public class CharSheetController {

	@Autowired
	private CharSheetService csService;
	
	private Stats stats = new Stats();

	Set<ArchetypeBenefit> benefitList = new HashSet<ArchetypeBenefit>();
	
	private CharSheet cs = new CharSheet();

	private Integer level;
	
	private Race race;
	
	
	public CharSheetController() {

	}

	@PostConstruct
	public void init() {
		level = 0;
		race = raceFactory.generateRace("empty");
	}


	public void save() throws ControllerException{
		try{
			cs.setStats(stats);
			csService.save(cs);
		}catch (ServiceException e){
			throw new ControllerException("Não salvou",e);
		}
		
	}
	
	public void saveBenefit(ArchetypeBenefit archeBenefit) throws ControllerException {
		try {
			Set<ArchetypeBenefit> list = new HashSet<ArchetypeBenefit>();
			list.add(archeBenefit);
			cs.addArchetypeBenefit(archeBenefit);
			//cs.setBenefitList(list);
			cs.setArchetype(archeBenefit.getArchetype());
			csService.save(cs);
			
		} catch (ServiceException e) {
			throw new ControllerException("Não salvou", e);
		}

	}

	
	public void loadRace() {
		System.out.println("EVENT: selected race:" + cs.getRace());
		this.race = raceFactory.generateRace(cs.getRace());
		this.stats=race.getStats();
		this.benefitList=race.getBenefitList();
	}

	
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

	public void clear(){
		cs=new CharSheet();
		race = raceFactory.generateRace("empty");
		level = 0;
		
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}

	public Set<ArchetypeBenefit> getBenefitList() {
		return benefitList;
	}

	public void setBenefitList(Set<ArchetypeBenefit> benefitList) {
		this.benefitList = benefitList;
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
	
	


}
