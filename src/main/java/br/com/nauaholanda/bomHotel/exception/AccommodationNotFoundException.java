package br.com.nauaholanda.bomHotel.exception;

public class AccommodationNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6551777984297026153L;
	
	public AccommodationNotFoundException(Long id) {
		super("Accommodation with id " + id + " not found!");
	}
	
}
