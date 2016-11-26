package br.com.direfrog.persistencia;

import java.sql.Connection;
import java.util.List;

import br.com.direfrog.entidade.Habilidade;

public class HabilidadeDAO implements InterfaceGenericDAO <Habilidade>{

	private String nomeTabela;
	private Connection connection = ConexaoFactory.getConnection();
	
	@Override
	public void cadastrar(Habilidade entrada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Habilidade entrada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void salvar(Habilidade entrada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Habilidade buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Habilidade> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
