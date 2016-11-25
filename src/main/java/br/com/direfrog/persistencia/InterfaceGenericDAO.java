package br.com.direfrog.persistencia;

import java.util.List;

public interface InterfaceGenericDAO <Objeto>{
	
	public void cadastrar(Objeto entrada);
	public void excluir (int id);
	public void alterar(Objeto entrada);
	public void salvar(Objeto entrada);
	public Objeto buscar (int id);
	public List<Objeto> buscarTodos();
	

}
