package br.com.direfrog.entidade;

import java.util.List;

public class Raca {

	private int id;
	private String nome;
	private String descricao;

	// Atributos iniciais das raças
	private int phy;
	private int spd;
	private int str;
	private int agi;
	private int prw;
	private int poi;
	private int intel;
	private int arc;
	private int per;

	/*
	 * TODO pode ficar melhor criar uma classe chamada BeneficioRacial contendo
	 * estas duas listas?
	 */
	private List<Habilidade> listaHabilidades;
	private List<BeneficioArquetipo> listaBeneficioArquetipos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Habilidade> getListaHabilidades() {
		return listaHabilidades;
	}

	public void setListaHabilidades(List<Habilidade> listaHabilidades) {
		this.listaHabilidades = listaHabilidades;
	}

	public List<BeneficioArquetipo> getListaBeneficioArquetipos() {
		return listaBeneficioArquetipos;
	}

	public void setListaBeneficioArquetipos(List<BeneficioArquetipo> listaBeneficioArquetipos) {
		this.listaBeneficioArquetipos = listaBeneficioArquetipos;
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

	
	
}
