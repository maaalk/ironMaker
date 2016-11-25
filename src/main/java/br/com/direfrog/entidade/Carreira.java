package br.com.direfrog.entidade;

import java.util.ArrayList;
import java.util.List;

public class Carreira {

	private int id;
	private String nome;
	private List<Habilidade> listaHabilidades;
	private List<Pericia> listaPericias;
	private List<Conexao> listaConexoes;
	
	//TODO vai precisar dos bens iniciais?
	//private List<Equipamento> listaEquipamentos;
	
	public Carreira(){
		
	}

	
	
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

	public List<Habilidade> getListaHabilidades() {
		return listaHabilidades;
	}

	public void setListaHabilidades(List<Habilidade> listaHabilidades) {
		this.listaHabilidades = listaHabilidades;
	}

	public List<Pericia> getListaPericias() {
		return listaPericias;
	}

	public void setListaPericias(List<Pericia> listaPericias) {
		this.listaPericias = listaPericias;
	}

	public List<Conexao> getListaConexoes() {
		return listaConexoes;
	}

	public void setListaConexoes(List<Conexao> listaConexoes) {
		this.listaConexoes = listaConexoes;
	}

		
}
