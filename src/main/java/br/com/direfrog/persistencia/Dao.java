package br.com.direfrog.persistencia;

public interface Dao {
	public void cadastrar(Object obj);
	public void excluir(Object obj);
	public void alterar (Object obj);
	public Object buscar(int id);
}
	
