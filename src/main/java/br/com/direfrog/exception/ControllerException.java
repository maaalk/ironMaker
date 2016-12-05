package br.com.direfrog.exception;

public class ControllerException extends Exception {
	
	public ControllerException(String msg, Exception causa){
		super(msg,causa);
	}
}
