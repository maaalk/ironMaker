package br.com.direfrog.entidade;

import java.util.List;

public class Raca {

	private int id;
	private String nome;
	private String descricao;
	
	/*TODO pode ficar melhor criar uma classe chamada 
	BeneficioRacial contendo estas duas listas?*/
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

	
}
