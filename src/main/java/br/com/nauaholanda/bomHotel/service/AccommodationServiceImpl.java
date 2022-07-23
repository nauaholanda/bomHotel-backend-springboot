package br.com.nauaholanda.bomHotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nauaholanda.bomHotel.exception.AccommodationNotFoundException;
import br.com.nauaholanda.bomHotel.model.Accommodation;
import br.com.nauaholanda.bomHotel.repository.AccommodationRepository;

@Service
public class AccommodationServiceImpl implements AccommodationService {
	
	@Autowired
	AccommodationRepository accommodationRepository;
	
	@Override
	public List<Accommodation> findAll() {
		return accommodationRepository.findAll();
	}
	
	@Override
	public List<Accommodation> find5Newest(){
		return accommodationRepository.findFirst5ByOrderByIdDesc();
	}
	
	@Override
	public List<Accommodation> search(String city, String state, String country) {
		city = city == null ? "" : city;
		state = state == null ? "" : state;
		country = country == null ? "" : country;
		
		return accommodationRepository
				.findByCityContainingIgnoreCaseAndStateContainingIgnoreCaseAndCountryContainingIgnoreCase(city, state, country);
	}
	
	@Override
	public Accommodation findById(Long id) {
		Optional<Accommodation> accommodationFoundOptional = accommodationRepository.findById(id);
		
		if (accommodationFoundOptional.isEmpty()) throw new AccommodationNotFoundException(id);
		
		return accommodationFoundOptional.get();
	}

	@Override
	public Accommodation create(Accommodation accommodation) {
		return accommodationRepository.save(accommodation);
	}

	@Override
	public Accommodation update(Accommodation accommodation) {
		return accommodationRepository.save(accommodation);
	}
	
	@Override
	public void deleteById(Long id) {
		accommodationRepository.deleteById(id);
	}

}
