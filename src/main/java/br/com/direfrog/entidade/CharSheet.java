package br.com.direfrog.entidade;

public class CharSheet {
	private String name;
	private Usuario user;
	private Integer id;
	
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
		/*private int baseDefense;
		private int baseArmor;
		private int baseInitiative;
		private int baseWillPower;
		private int baseCommandArea;*/
		
	
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
	public int getPhy() {
		return phy;
	}
	public void setPhy(int phy) {
		this.phy = phy;
	}
	public int getSpd() {
		return spd;
	}
	public void setSpd(int spd) {
		this.spd = spd;
	}
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	public int getAgi() {
		return agi;
	}
	public void setAgi(int agi) {
		this.agi = agi;
	}
	public int getPrw() {
		return prw;
	}
	public void setPrw(int prw) {
		this.prw = prw;
	}
	public int getPoi() {
		return poi;
	}
	public void setPoi(int poi) {
		this.poi = poi;
	}
	public int getIntel() {
		return intel;
	}
	public void setIntel(int intel) {
		this.intel = intel;
	}
	public int getArc() {
		return arc;
	}
	public void setArc(int arc) {
		this.arc = arc;
	}
	public int getPer() {
		return per;
	}
	public void setPer(int per) {
		this.per = per;
	}
	public Integer getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return "CharSheet [name=" + name + ", user=" + user + ", id=" + id + ", phy=" + phy + ", spd=" + spd + ", str="
				+ str + ", agi=" + agi + ", prw=" + prw + ", poi=" + poi + ", intel=" + intel + ", arc=" + arc
				+ ", per=" + per + "]";
	}
	
	
	
	
	
	

}
