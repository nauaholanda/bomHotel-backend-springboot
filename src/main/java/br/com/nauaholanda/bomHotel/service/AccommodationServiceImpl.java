package br.com.nauaholanda.bomHotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Accommodation create(Accommodation accommodation) {
		return accommodationRepository.save(accommodation);
	}

	@Override
	public Accommodation update(Accommodation accommodation) {
		return accommodationRepository.save(accommodation);
	}
}
