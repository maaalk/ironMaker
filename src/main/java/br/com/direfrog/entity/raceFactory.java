package br.com.direfrog.entity;

public class raceFactory {
	public static Race generateRace(String raceName){
		Race race = new Race();
		if (raceName.equals("human")){
			race.setBasePhy(5);
			race.setBaseSpd(6);
			race.setBaseStr(4);
			race.setBaseAgi(3);
			race.setBasePrw(4);
			race.setBasePoi(4);
			race.setBaseIntel(3);
			race.setBaseArc(0);
			race.setBasePer(3);
			
			race.setMaxPhy((new Integer[]{7,8,8}));
			race.setMaxSpd((new Integer[]{7,7,7}));
			race.setMaxStr((new Integer[]{6,7,8}));
			race.setMaxAgi((new Integer[]{5,6,7}));
			race.setMaxPrw((new Integer[]{5,6,7}));
			race.setMaxPoi((new Integer[]{5,6,7}));
			race.setMaxIntel((new Integer[]{5,6,7}));
			race.setMaxArc((new Integer[]{4,6,8}));
			race.setMaxPer((new Integer[]{5,6,7}));
			
		}
		
		if (raceName.equals("trollkin")){
			race.setBasePhy(6);
			race.setBaseSpd(5);
			race.setBaseStr(5);
			race.setBaseAgi(3);
			race.setBasePrw(4);
			race.setBasePoi(2);
			race.setBaseIntel(3);
			race.setBaseArc(0);
			race.setBasePer(3);
			
			race.setMaxPhy((new Integer[]{8,9,10}));
			race.setMaxSpd((new Integer[]{6,6,6}));
			race.setMaxStr((new Integer[]{7,8,9}));
			race.setMaxAgi((new Integer[]{5,6,7}));
			race.setMaxPrw((new Integer[]{5,6,7}));
			race.setMaxPoi((new Integer[]{5,6,7}));
			race.setMaxIntel((new Integer[]{4,5,6}));
			race.setMaxArc((new Integer[]{4,6,7}));
			race.setMaxPer((new Integer[]{4,5,6}));
			
		}
		
		return race;
	}

}
