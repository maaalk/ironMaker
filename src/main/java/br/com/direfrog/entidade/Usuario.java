package br.com.direfrog.entidade;

public class Usuario {
	private Integer id;
	private String nome;
	private String login;
	private String senha;
	
	public Integer getId() {
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String toString(){
		String user="";
		user+="ID :"+getId()+"\n";
		user+="Nome :"+getNome()+"\n";
		user+="Login :"+getLogin()+"\n";
		user+="Senha :"+getSenha()+"\n";
		return user;
	}
	
	
}
