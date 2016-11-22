package br.com.direfrog.entidade;

public class Character {
	private String name;
	private Usuario user;
	
	//primary and secondary attibutes
	private int phy;
	private int spd;
	private int str;
	private int agi;
	private int prw;
	private int poi;
	private int intel;
	private int arc;
	private int per;
	
	//derived attributes
	private int baseDefense;
	private int baseArmor;
	private int baseInitiative;
	private int baseWillPower;
	private int baseCommandArea;
	
	
	//setters and getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Usuario getUser() {
		return user;
	}
	public void setUser(Usuario user) {
		this.user = user;
	}
	public int getPhysic() {
		return phy;
	}
	public void setPhysic(int physic) {
		this.phy = physic;
		this.setBaseWillPower();
		this.setBaseArmor();
	}
	public int getSpeed() {
		return spd;
	}
	public void setSpeed(int speed) {
		this.spd = speed;
		this.setBaseDefense();
		this.setBaseInitiative();
	}
	public int getStrength() {
		return str;
	}
	public void setStrength(int strength) {
		this.str = strength;
	}
	public int getAgility() {
		return agi;
	}
	public void setAgility(int agility) {
		this.agi = agility;
		this.setBaseDefense();
	}
	public int getProwess() {
		return prw;
	}
	public void setProwess(int prowess) {
		this.prw = prowess;
	}
	public int getPoise() {
		return poi;
	}
	public void setPoise(int poise) {
		this.poi = poise;
		this.setBaseInitiative();
	}
	public int getIntelect() {
		return intel;
	}
	public void setIntelect(int intelect) {
		this.intel = intelect;
		this.setBaseWillPower();
		this.setBaseCommandArea();
	}
	public int getArcane() {
		return arc;
	}
	public void setArcane(int arcane) {
		this.arc = arcane;
	}
	public int getPerception() {
		return per;
	}
	public void setPerception(int perception) {
		this.per = perception;
		this.setBaseDefense();
		this.setBaseInitiative();
	}
	public int getBaseDefense() {
		return baseDefense;
	}
	
	private void setBaseDefense() {
		this.baseDefense = this.getSpeed()+this.getAgility()+this.getPerception();
	}
	
	public int getBaseArmor() {
		return baseArmor;
	}
	private void setBaseArmor() {
		//falta modificadores de armadura
		this.baseArmor = this.getPhysic();
	}
	public int getBaseInitiative() {
		return baseInitiative;
	}
	private void setBaseInitiative() {
		this.baseInitiative = this.getSpeed()+this.getPerception()+this.getProwess();
	}
	public int getBaseWillPower() {
		return baseWillPower;
	}
	
	private void setBaseWillPower() {
		this.baseWillPower = this.getPhysic()+this.getIntelect();
	}
	
	public int getBaseCommandArea() {
		return baseCommandArea;
	}
	
	private void setBaseCommandArea() {
		//falta adicionar outros elementos
		this.baseCommandArea = this.getIntelect();
	}

	
	
	

}
