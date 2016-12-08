package br.com.direfrog.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import java.util.Arrays;

import javax.persistence.Entity;

@Entity
public class CharSheet implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String race; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Race stats;
	
	private Integer xp;
	
	/*//primary and secondary attibutes
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
		private Integer[] maxPer;*/
	
	
	
	
	@Override
	public String toString() {
		return "CharSheet [name=" + name + ", id=" + id + ", race=" + race + ", xp=" + xp +/* ", phy=" + phy + ", spd="
				+ spd + ", str=" + str + ", agi=" + agi + ", prw=" + prw + ", poi=" + poi + ", intel=" + intel
				+ ", arc=" + arc + ", per=" + per +*/ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}


	public Race getStats() {
		return stats;
	}

	public void setStats(Race stats) {
		this.stats = stats;
	}

	public Integer getXp() {
		return xp;
	}

	public void setXp(Integer xp) {
		this.xp = xp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		result = prime * result + ((stats == null) ? 0 : stats.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (race == null) {
			if (other.race != null)
				return false;
		} else if (!race.equals(other.race))
			return false;
		if (stats == null) {
			if (other.stats != null)
				return false;
		} else if (!stats.equals(other.stats))
			return false;
		if (xp == null) {
			if (other.xp != null)
				return false;
		} else if (!xp.equals(other.xp))
			return false;
		return true;
	}
	
	
	

}
