package br.com.nauaholanda.bomHotel.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nauaholanda.bomHotel.dto.input.BookingInputDTO;
import br.com.nauaholanda.bomHotel.dto.output.BookingOutputDTO;
import br.com.nauaholanda.bomHotel.model.Booking;
import br.com.nauaholanda.bomHotel.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<BookingOutputDTO>> findByUserId(@PathVariable Long userId) {
		List<BookingOutputDTO> bookingOutputDTOList = bookingService.findByUserId(userId).stream()
				.map(booking -> new BookingOutputDTO(booking)).collect(Collectors.toList());
		return ResponseEntity.ok(bookingOutputDTOList);
	}
	
	@PostMapping
	public ResponseEntity<BookingOutputDTO> create(@RequestBody @Valid BookingInputDTO bookingInputDTO) {
		Booking bookingCreated = bookingService.create(bookingService.convertInputDTOtoEntity(bookingInputDTO));
		return ResponseEntity.created(URI.create("/booking/" + bookingCreated.getId())).body(new BookingOutputDTO(bookingCreated));
	}
	
}
