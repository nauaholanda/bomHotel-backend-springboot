package br.com.nauaholanda.bomHotel.exception;

public class UserNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 5565555596885237284L;
	
	public UserNotFoundException(String username) {
		super("User " + username + " not found!");
	}

	public UserNotFoundException(Long id) {
		super("User with id " + id + " not found!");
	}

}
