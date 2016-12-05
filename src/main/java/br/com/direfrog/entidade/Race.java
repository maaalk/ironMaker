package br.com.direfrog.entidade;

import java.util.Arrays;
import java.util.List;

public class Race {

	//description
	private String name;
	private String description;

	// Starting Stats
	private Integer basePhy;
	private Integer baseSpd;
	private Integer baseStr;
	private Integer baseAgi;
	private Integer basePrw;
	private Integer basePoi;
	private Integer baseIntel;
	private Integer baseArc;
	private Integer basePer;

	//Max Stats
	private Integer[] maxPhy;
	private Integer[] maxSpd;
	private Integer[] maxStr;
	private Integer[] maxAgi;
	private Integer[] maxPrw;
	private Integer[] maxPoi;
	private Integer[] maxIntel;
	private Integer[] maxArc;
	private Integer[] maxPer;
	/*
	 * TODO pode ficar melhor criar uma classe chamada BeneficioRacial contendo
	 * estas duas listas?
	 * private List<Habilidade> listaHabilidades;
	 * private List<BeneficioArquetipo> listaBeneficioArquetipos;
	 */
	
	public String getName() {
		return name;
	}
	public void setNome(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String descricao) {
		this.description = descricao;
	}
	public Integer getBasePhy() {
		return basePhy;
	}
	public void setBasePhy(Integer basePhy) {
		this.basePhy = basePhy;
	}
	public Integer getBaseSpd() {
		return baseSpd;
	}
	public void setBaseSpd(Integer baseSpd) {
		this.baseSpd = baseSpd;
	}
	public Integer getBaseStr() {
		return baseStr;
	}
	public void setBaseStr(Integer baseStr) {
		this.baseStr = baseStr;
	}
	public Integer getBaseAgi() {
		return baseAgi;
	}
	public void setBaseAgi(Integer baseAgi) {
		this.baseAgi = baseAgi;
	}
	public Integer getBasePrw() {
		return basePrw;
	}
	public void setBasePrw(Integer basePrw) {
		this.basePrw = basePrw;
	}
	public Integer getBasePoi() {
		return basePoi;
	}
	public void setBasePoi(Integer basePoi) {
		this.basePoi = basePoi;
	}
	public Integer getBaseIntel() {
		return baseIntel;
	}
	public void setBaseIntel(Integer baseIntel) {
		this.baseIntel = baseIntel;
	}
	public Integer getBaseArc() {
		return baseArc;
	}
	public void setBaseArc(Integer baseArc) {
		this.baseArc = baseArc;
	}
	public Integer getBasePer() {
		return basePer;
	}
	public void setBasePer(Integer basePer) {
		this.basePer = basePer;
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
		result = prime * result + ((baseAgi == null) ? 0 : baseAgi.hashCode());
		result = prime * result + ((baseArc == null) ? 0 : baseArc.hashCode());
		result = prime * result + ((baseIntel == null) ? 0 : baseIntel.hashCode());
		result = prime * result + ((basePer == null) ? 0 : basePer.hashCode());
		result = prime * result + ((basePhy == null) ? 0 : basePhy.hashCode());
		result = prime * result + ((basePoi == null) ? 0 : basePoi.hashCode());
		result = prime * result + ((basePrw == null) ? 0 : basePrw.hashCode());
		result = prime * result + ((baseSpd == null) ? 0 : baseSpd.hashCode());
		result = prime * result + ((baseStr == null) ? 0 : baseStr.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Race other = (Race) obj;
		if (baseAgi == null) {
			if (other.baseAgi != null)
				return false;
		} else if (!baseAgi.equals(other.baseAgi))
			return false;
		if (baseArc == null) {
			if (other.baseArc != null)
				return false;
		} else if (!baseArc.equals(other.baseArc))
			return false;
		if (baseIntel == null) {
			if (other.baseIntel != null)
				return false;
		} else if (!baseIntel.equals(other.baseIntel))
			return false;
		if (basePer == null) {
			if (other.basePer != null)
				return false;
		} else if (!basePer.equals(other.basePer))
			return false;
		if (basePhy == null) {
			if (other.basePhy != null)
				return false;
		} else if (!basePhy.equals(other.basePhy))
			return false;
		if (basePoi == null) {
			if (other.basePoi != null)
				return false;
		} else if (!basePoi.equals(other.basePoi))
			return false;
		if (basePrw == null) {
			if (other.basePrw != null)
				return false;
		} else if (!basePrw.equals(other.basePrw))
			return false;
		if (baseSpd == null) {
			if (other.baseSpd != null)
				return false;
		} else if (!baseSpd.equals(other.baseSpd))
			return false;
		if (baseStr == null) {
			if (other.baseStr != null)
				return false;
		} else if (!baseStr.equals(other.baseStr))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
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
		return true;
	}
	@Override
	public String toString() {
		return "Race [name=" + name + ", description=" + description + ", basePhy=" + basePhy + ", baseSpd="
				+ baseSpd + ", baseStr=" + baseStr + ", baseAgi=" + baseAgi + ", basePrw=" + basePrw + ", basePoi="
				+ basePoi + ", baseIntel=" + baseIntel + ", baseArc=" + baseArc + ", basePer=" + basePer + ", maxPhy="
				+ Arrays.toString(maxPhy) + ", maxSpd=" + Arrays.toString(maxSpd) + ", maxStr="
				+ Arrays.toString(maxStr) + ", maxAgi=" + Arrays.toString(maxAgi) + ", maxPrw="
				+ Arrays.toString(maxPrw) + ", maxPoi=" + Arrays.toString(maxPoi) + ", maxIntel="
				+ Arrays.toString(maxIntel) + ", maxArc=" + Arrays.toString(maxArc) + ", maxPer="
				+ Arrays.toString(maxPer) + "]";
	}
	


	
	
}
