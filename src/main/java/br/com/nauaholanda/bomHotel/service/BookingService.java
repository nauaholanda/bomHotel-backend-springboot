package br.com.nauaholanda.bomHotel.service;

import java.util.List;

import br.com.nauaholanda.bomHotel.dto.input.BookingInputDTO;
import br.com.nauaholanda.bomHotel.model.Booking;

public interface BookingService {

	List<Booking> findByUserId(Long userId);
	
	Booking convertInputDTOtoEntity(BookingInputDTO inputDTO);

	Booking create(Booking booking);

}
