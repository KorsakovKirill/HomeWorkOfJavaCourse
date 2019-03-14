package ru.mera.korsakovkirill.postman;

public class MiJeDogovarivalisDomaNePryatException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MiJeDogovarivalisDomaNePryatException() {
	
	}
	
	public MiJeDogovarivalisDomaNePryatException(String message){
		super(message);
	}
	public MiJeDogovarivalisDomaNePryatException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public MiJeDogovarivalisDomaNePryatException( Throwable cause) {
		super( cause);
	}
	
}
