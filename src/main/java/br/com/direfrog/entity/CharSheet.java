package br.com.direfrog.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;

import javax.persistence.Entity;

@Entity
public class CharSheet implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String race; 
	
	private Integer xp;
	
	//primary and secondary attibutes
		private Integer phy;
		private Integer spd;
		private Integer str;
		private Integer agi;
		private Integer prw;
		private Integer poi;
		private Integer intel;
		private Integer arc;
		private Integer per;
		
		
		private Integer[] maxPhy;
		private Integer[] maxSpd;
		private Integer[] maxStr;
		private Integer[] maxAgi;
		private Integer[] maxPrw;
		private Integer[] maxPoi;
		private Integer[] maxIntel;
		private Integer[] maxArc;
		private Integer[] maxPer;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public Integer getXp() {
		return xp;
	}
	public void setXp(Integer xp) {
		this.xp = xp;
	}
	public Integer getPhy() {
		return phy;
	}
	public void setPhy(Integer phy) {
		this.phy = phy;
	}
	public Integer getSpd() {
		return spd;
	}
	public void setSpd(Integer spd) {
		this.spd = spd;
	}
	public Integer getStr() {
		return str;
	}
	public void setStr(Integer str) {
		this.str = str;
	}
	public Integer getAgi() {
		return agi;
	}
	public void setAgi(Integer agi) {
		this.agi = agi;
	}
	public Integer getPrw() {
		return prw;
	}
	public void setPrw(Integer prw) {
		this.prw = prw;
	}
	public Integer getPoi() {
		return poi;
	}
	public void setPoi(Integer poi) {
		this.poi = poi;
	}
	public Integer getIntel() {
		return intel;
	}
	public void setIntel(Integer intel) {
		this.intel = intel;
	}
	public Integer getArc() {
		return arc;
	}
	public void setArc(Integer arc) {
		this.arc = arc;
	}
	public Integer getPer() {
		return per;
	}
	public void setPer(Integer per) {
		this.per = per;
	}
	public Integer[] getMaxPhy() {
		return maxPhy;
	}
	public void setMaxPhy(Integer[] maxPhy) {
		this.maxPhy = maxPhy;
	}
	public Integer[] getMaxSpd() {
		return maxSpd;
	}
	public void setMaxSpd(Integer[] maxSpd) {
		this.maxSpd = maxSpd;
	}
	public Integer[] getMaxStr() {
		return maxStr;
	}
	public void setMaxStr(Integer[] maxStr) {
		this.maxStr = maxStr;
	}
	public Integer[] getMaxAgi() {
		return maxAgi;
	}
	public void setMaxAgi(Integer[] maxAgi) {
		this.maxAgi = maxAgi;
	}
	public Integer[] getMaxPrw() {
		return maxPrw;
	}
	public void setMaxPrw(Integer[] maxPrw) {
		this.maxPrw = maxPrw;
	}
	public Integer[] getMaxPoi() {
		return maxPoi;
	}
	public void setMaxPoi(Integer[] maxPoi) {
		this.maxPoi = maxPoi;
	}
	public Integer[] getMaxIntel() {
		return maxIntel;
	}
	public void setMaxIntel(Integer[] maxIntel) {
		this.maxIntel = maxIntel;
	}
	public Integer[] getMaxArc() {
		return maxArc;
	}
	public void setMaxArc(Integer[] maxArc) {
		this.maxArc = maxArc;
	}
	public Integer[] getMaxPer() {
		return maxPer;
	}
	public void setMaxPer(Integer[] maxPer) {
		this.maxPer = maxPer;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agi == null) ? 0 : agi.hashCode());
		result = prime * result + ((arc == null) ? 0 : arc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((intel == null) ? 0 : intel.hashCode());
		result = prime * result + Arrays.hashCode(maxAgi);
		result = prime * result + Arrays.hashCode(maxArc);
		result = prime * result + Arrays.hashCode(maxIntel);
		result = prime * result + Arrays.hashCode(maxPer);
		result = prime * result + Arrays.hashCode(maxPhy);
		result = prime * result + Arrays.hashCode(maxPoi);
		result = prime * result + Arrays.hashCode(maxPrw);
		result = prime * result + Arrays.hashCode(maxSpd);
		result = prime * result + Arrays.hashCode(maxStr);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((per == null) ? 0 : per.hashCode());
		result = prime * result + ((phy == null) ? 0 : phy.hashCode());
		result = prime * result + ((poi == null) ? 0 : poi.hashCode());
		result = prime * result + ((prw == null) ? 0 : prw.hashCode());
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		result = prime * result + ((spd == null) ? 0 : spd.hashCode());
		result = prime * result + ((str == null) ? 0 : str.hashCode());
		result = prime * result + ((xp == null) ? 0 : xp.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharSheet other = (CharSheet) obj;
		if (agi == null) {
			if (other.agi != null)
				return false;
		} else if (!agi.equals(other.agi))
			return false;
		if (arc == null) {
			if (other.arc != null)
				return false;
		} else if (!arc.equals(other.arc))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (intel == null) {
			if (other.intel != null)
				return false;
		} else if (!intel.equals(other.intel))
			return false;
		if (!Arrays.equals(maxAgi, other.maxAgi))
			return false;
		if (!Arrays.equals(maxArc, other.maxArc))
			return false;
		if (!Arrays.equals(maxIntel, other.maxIntel))
			return false;
		if (!Arrays.equals(maxPer, other.maxPer))
			return false;
		if (!Arrays.equals(maxPhy, other.maxPhy))
			return false;
		if (!Arrays.equals(maxPoi, other.maxPoi))
			return false;
		if (!Arrays.equals(maxPrw, other.maxPrw))
			return false;
		if (!Arrays.equals(maxSpd, other.maxSpd))
			return false;
		if (!Arrays.equals(maxStr, other.maxStr))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (per == null) {
			if (other.per != null)
				return false;
		} else if (!per.equals(other.per))
			return false;
		if (phy == null) {
			if (other.phy != null)
				return false;
		} else if (!phy.equals(other.phy))
			return false;
		if (poi == null) {
			if (other.poi != null)
				return false;
		} else if (!poi.equals(other.poi))
			return false;
		if (prw == null) {
			if (other.prw != null)
				return false;
		} else if (!prw.equals(other.prw))
			return false;
		if (race == null) {
			if (other.race != null)
				return false;
		} else if (!race.equals(other.race))
			return false;
		if (spd == null) {
			if (other.spd != null)
				return false;
		} else if (!spd.equals(other.spd))
			return false;
		if (str == null) {
			if (other.str != null)
				return false;
		} else if (!str.equals(other.str))
			return false;
		if (xp == null) {
			if (other.xp != null)
				return false;
		} else if (!xp.equals(other.xp))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CharSheet [name=" + name + ", id=" + id + ", race=" + race + ", xp=" + xp + ", phy=" + phy + ", spd="
				+ spd + ", str=" + str + ", agi=" + agi + ", prw=" + prw + ", poi=" + poi + ", intel=" + intel
				+ ", arc=" + arc + ", per=" + per + "]";
	}
	
	
	

}
