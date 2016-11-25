package br.com.direfrog.entidade;

public class Pericia {
	
	private int id;
	private String nome;
	private String descricao;
	//vai precisar separar as perícias militares e profissionais?
	//Acho que heraça deixaria muito pesado aqui.
	private String tipo;  //MILITAR ou PROFISSIONAL
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
