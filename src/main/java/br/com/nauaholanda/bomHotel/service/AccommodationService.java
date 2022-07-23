package br.com.nauaholanda.bomHotel.service;

import java.util.List;

import br.com.nauaholanda.bomHotel.model.Accommodation;

public interface AccommodationService {

	List<Accommodation> findAll();
	
	Accommodation findById(Long id);

	Accommodation create(Accommodation accommodation);

	Accommodation update(Accommodation accommodation);
	
	void deleteById(Long id);

}
