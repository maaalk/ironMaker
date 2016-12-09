package br.com.direfrog.entity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.direfrog.dao.ArchetypeBenefitDAO;

@Component
public class raceFactory {
	
	private static ArchetypeBenefitDAO dao;
	
	@Autowired
	private ArchetypeBenefitDAO dao0;
	
	 @PostConstruct     
	  public void initStaticDao () {
	     dao = this.dao0;
	 }
	
	public static Race generateRace(String raceName){
	
		Race race = new Race(raceName);
		
		if (raceName.equals("human")){
			race.getStats().setBasePhy(5);
			race.getStats().setBaseSpd(6);
			race.getStats().setBaseStr(4);
			race.getStats().setBaseAgi(3);
			race.getStats().setBasePrw(4);
			race.getStats().setBasePoi(4);
			race.getStats().setBaseIntel(3);
			race.getStats().setBaseArc(0);
			race.getStats().setBasePer(3);
			
			race.getStats().setMaxPhy((new Integer[]{7,8,8}));
			race.getStats().setMaxSpd((new Integer[]{7,7,7}));
			race.getStats().setMaxStr((new Integer[]{6,7,8}));
			race.getStats().setMaxAgi((new Integer[]{5,6,7}));
			race.getStats().setMaxPrw((new Integer[]{5,6,7}));
			race.getStats().setMaxPoi((new Integer[]{5,6,7}));
			race.getStats().setMaxIntel((new Integer[]{5,6,7}));
			race.getStats().setMaxArc((new Integer[]{4,6,8}));
			race.getStats().setMaxPer((new Integer[]{5,6,7}));			
		}
		
		if (raceName.equals("trollkin")){
			race.getStats().setBasePhy(6);
			race.getStats().setBaseSpd(5);
			race.getStats().setBaseStr(5);
			race.getStats().setBaseAgi(3);
			race.getStats().setBasePrw(4);
			race.getStats().setBasePoi(2);
			race.getStats().setBaseIntel(3);
			race.getStats().setBaseArc(0);
			race.getStats().setBasePer(3);
			
			race.getStats().setMaxPhy((new Integer[]{8,9,10}));
			race.getStats().setMaxSpd((new Integer[]{6,6,6}));
			race.getStats().setMaxStr((new Integer[]{7,8,9}));
			race.getStats().setMaxAgi((new Integer[]{5,6,7}));
			race.getStats().setMaxPrw((new Integer[]{5,6,7}));
			race.getStats().setMaxPoi((new Integer[]{5,6,7}));
			race.getStats().setMaxIntel((new Integer[]{4,5,6}));
			race.getStats().setMaxArc((new Integer[]{4,6,7}));
			race.getStats().setMaxPer((new Integer[]{4,5,6}));
			
			race.getBenefitList().add(dao.findByName("Vendetta"));
			
		}
		
		return race;
	}

}
