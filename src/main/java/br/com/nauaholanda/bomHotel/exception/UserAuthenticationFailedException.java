package br.com.nauaholanda.bomHotel.exception;

public class UserAuthenticationFailedException extends RuntimeException {

	private static final long serialVersionUID = -2388174845227077040L;
	
	public UserAuthenticationFailedException(String username) {
		super("Authentication failed for user " + username + "!");
	}

}
