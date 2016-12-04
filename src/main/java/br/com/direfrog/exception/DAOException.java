package br.com.direfrog.exception;

public class DAOException extends Exception {
	
	public DAOException(String msg, Exception e){
		super(msg, e);
	}

}
