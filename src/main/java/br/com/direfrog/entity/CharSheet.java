package br.com.direfrog.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import java.util.Set;


@Entity
public class CharSheet implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String race; 
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Race stats;
	
	private Integer xp;
	

	//Added by God666
	@ManyToOne
	@JoinColumn(name="archetype_id")
	private Archetype archetype;
	
	//@ManyToMany(mappedBy="charSheetList")
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "charsheet_archetypebenefit", joinColumns = @JoinColumn(name = "charsheet_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name="archetypebenefit_id", referencedColumnName="id"))
	private Set<ArchetypeBenefit> benefitList;

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

	//Add by God666
	public Set<ArchetypeBenefit> getBenefitList() {
		return benefitList;
	}
	public void setBenefitList(Set<ArchetypeBenefit> benefitList) {
		this.benefitList = benefitList;
	}
	public Archetype getArchetype() {
		return archetype;
	}
	public void setArchetype(Archetype archetype) {
		this.archetype = archetype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((archetype == null) ? 0 : archetype.hashCode());
		result = prime * result + ((benefitList == null) ? 0 : benefitList.hashCode());
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
		if (archetype == null) {
			if (other.archetype != null)
				return false;
		} else if (!archetype.equals(other.archetype))
			return false;
		if (benefitList == null) {
			if (other.benefitList != null)
				return false;
		} else if (!benefitList.equals(other.benefitList))
			return false;
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

	@Override
	public String toString() {
		return "CharSheet [id=" + id + ", name=" + name + ", race=" + race + ", stats=" + stats + ", xp=" + xp
				+ ", archetype=" + archetype + ", benefitList=" + benefitList + "]";
	}

}
