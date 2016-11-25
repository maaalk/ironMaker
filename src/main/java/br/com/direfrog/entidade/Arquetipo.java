package br.com.direfrog.entidade;

import java.util.List;

public class Arquetipo {
	
	private int id;
	private String nome;
	private String beneficio;
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
	public String getBeneficio() {
		return beneficio;
	}
	public void setBeneficio(String beneficio) {
		this.beneficio = beneficio;
	}
	public List<BeneficioArquetipo> getListaBeneficioArquetipos() {
		return listaBeneficioArquetipos;
	}
	public void setListaBeneficioArquetipos(List<BeneficioArquetipo> listaBeneficioArquetipos) {
		this.listaBeneficioArquetipos = listaBeneficioArquetipos;
	}

	
	
}
