package br.com.nauaholanda.bomHotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nauaholanda.bomHotel.dto.input.BookingInputDTO;
import br.com.nauaholanda.bomHotel.exception.AccommodationNotFoundException;
import br.com.nauaholanda.bomHotel.exception.UserNotFoundException;
import br.com.nauaholanda.bomHotel.model.Booking;
import br.com.nauaholanda.bomHotel.repository.AccommodationRepository;
import br.com.nauaholanda.bomHotel.repository.BookingRepository;
import br.com.nauaholanda.bomHotel.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService{
	
	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AccommodationRepository accommodationRepository;
	
	@Override
	public List<Booking> findByUserId(Long userId) {
		return bookingRepository.findByUserId(userId);
	}

	@Override
	public Booking convertInputDTOtoEntity(BookingInputDTO inputDTO) {
		Booking bookingConverted = new Booking();
		
		bookingConverted.setCheckinDate(inputDTO.getCheckinDate());
		bookingConverted.setCheckoutDate(inputDTO.getCheckoutDate());
		bookingConverted.setTotalCost(inputDTO.getTotalCost());
		
		bookingConverted.setUser(userRepository.findById(inputDTO.getUserId())
				.orElseThrow(() -> new UserNotFoundException(inputDTO.getUserId())));
		
		bookingConverted.setAccommodation(accommodationRepository.findById(inputDTO.getAccommodationId())
				.orElseThrow(() -> new AccommodationNotFoundException(inputDTO.getAccommodationId())));

		return bookingConverted;
	}

	@Override
	public Booking create(Booking booking) {
		return bookingRepository.save(booking);
	}
	
}
