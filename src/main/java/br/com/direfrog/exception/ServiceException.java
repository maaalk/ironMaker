package br.com.direfrog.exception;

public class ServiceException extends Exception {
	public ServiceException(String msg, Exception e){
		super(msg, e);
	}
}
