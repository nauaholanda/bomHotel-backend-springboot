package br.com.nauaholanda.bomHotel.exception;

public class UsernameAlreadyExistsException extends RuntimeException  {

	private static final long serialVersionUID = 4211490610993952055L;
	
	public UsernameAlreadyExistsException(String username) {
		super("Username " + username + " already exists!");
	}
	
}
