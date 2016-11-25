package br.com.direfrog.entidade;

public class Habilidade {
	
	private int id;
	private String nome;
	//prerequisito vai ser uma string ou uma lista?
	private String prerequisito;
	private String descricao;
	
	
	
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
	public String getPrerequisito() {
		return prerequisito;
	}
	public void setPrerequisito(String prerequisito) {
		this.prerequisito = prerequisito;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
