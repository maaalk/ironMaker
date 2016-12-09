package br.com.direfrog.entity;

import java.util.HashSet;
import java.util.Set;


public class Race {
	private String name;
	private Stats stats= new Stats();
	private Set<ArchetypeBenefit> benefitList = new HashSet<ArchetypeBenefit>();
	
	
	public Race(String name){
		this.name=name;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
	
	

	
	
}
