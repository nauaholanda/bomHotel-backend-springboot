package br.com.nauaholanda.bomHotel.service;

import java.util.List;

import br.com.nauaholanda.bomHotel.model.Accommodation;

public interface AccommodationService {

	List<Accommodation> findAll();
	
	List<Accommodation> find5Newest();
	
	List<Accommodation> search(String city, String state, String country);
	
	Accommodation findById(Long id);

	Accommodation create(Accommodation accommodation);

	Accommodation update(Accommodation accommodation);
	
	void deleteById(Long id);

}
