package br.com.direfrog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.direfrog.entity.Stats;
import br.com.direfrog.service.StatsService;


@Controller(value="statsCtrl")
public class StatsController {
	
	@Autowired
	private StatsService statsService;
		
	private Stats stats = new Stats();
		

	public Stats getCs() {
		return stats;
	}

	public void setCs(Stats stats) {
		this.stats = stats;
	}
		
	

}
