package br.com.direfrog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import br.com.direfrog.entity.Race;
import br.com.direfrog.entity.Race;
import br.com.direfrog.entity.raceFactory;
import br.com.direfrog.exception.ControllerException;
import br.com.direfrog.exception.ServiceException;
import br.com.direfrog.service.RaceService;


@Controller(value="raceCtrl")
public class RaceController {
	
	@Autowired
	private RaceService raceService;
		
	private Race race = new Race();
		

	public Race getCs() {
		return race;
	}

	public void setCs(Race race) {
		this.race = race;
	}
		
	

}
