package br.com.direfrog.controller;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import br.com.direfrog.entity.CharSheet;
import br.com.direfrog.entity.Race;
import br.com.direfrog.entity.raceFactory;
import br.com.direfrog.exception.ControllerException;
import br.com.direfrog.exception.ServiceException;
import br.com.direfrog.service.CharSheetService;
import br.com.direfrog.service.RaceService;


@Controller(value="csCtrl")
public class CharSheetController {
	
	@Autowired
	private CharSheetService csService;
	
	@Autowired
	private RaceService raceService;
		
	private Race stats= new Race();
	
	private CharSheet cs = new CharSheet();
	
	private Integer level;
	
	public CharSheetController(){
		
	}
	
	@PostConstruct
	public void init(){
		cs.setXp(0);
	}
	
	
	
	public void save() throws ControllerException{
		try{
			cs.setStats(stats);
			csService.save(cs);
		}catch (ServiceException e){
			throw new ControllerException("Não salvou",e);
		}
		
	}
	
	
	public void loadStats(String race){
		System.out.println("selected race:"+race);
		this.stats = raceFactory.generateRace(race);
		System.out.println(stats);
	}
	
	public void loadStats2(ValueChangeEvent e){
		String race = e.getNewValue().toString();
		System.out.println("EVENT: selected race:"+race);
		this.stats = raceFactory.generateRace(race);
		System.out.println(stats);
		getStats();
	}
	 
	public void defineLevel(ValueChangeEvent e){
		Integer lvl = Integer.parseInt(e.getNewValue().toString());
		System.out.println("EVENT: lvl:"+lvl);
		if (lvl>=100){
			this.level=2;
		} else if (lvl>=50){
			this.level=1;
		} else this.level=0;
	}
	


	public CharSheet getCs() {
		return cs;
	}

	public void setCs(CharSheet cs) {
		this.cs = cs;
	}

	public Race getStats() {
		return stats;
	}

	public void setStats(Race stats) {
		this.stats = stats;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
	
	
	

}
