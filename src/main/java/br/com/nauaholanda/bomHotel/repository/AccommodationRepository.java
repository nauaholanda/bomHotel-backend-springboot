package br.com.nauaholanda.bomHotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.nauaholanda.bomHotel.model.Accommodation;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
	
	public List<Accommodation> findFirst5ByOrderByIdDesc();
	
	public List<Accommodation> findByCityContainingIgnoreCaseAndStateContainingIgnoreCaseAndCountryContainingIgnoreCase(String city, String state, String country);
	
}
