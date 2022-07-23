package br.com.nauaholanda.bomHotel.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nauaholanda.bomHotel.dto.input.AccommodationInputDTO;
import br.com.nauaholanda.bomHotel.dto.output.AccommodationOutputDTO;
import br.com.nauaholanda.bomHotel.model.Accommodation;
import br.com.nauaholanda.bomHotel.service.AccommodationService;

@RestController
@RequestMapping("/accommodation")
public class AccommodationController {
	
	@Autowired
	AccommodationService acommodationService;
	
	@GetMapping
	public ResponseEntity<List<AccommodationOutputDTO>> findAll(){
		List<AccommodationOutputDTO> accommodationDTOList = acommodationService.findAll().stream()
				.map(accommodation -> new AccommodationOutputDTO(accommodation)).collect(Collectors.toList());
		
		return ResponseEntity.ok(accommodationDTOList);
	}
	
	@PostMapping
	public ResponseEntity<AccommodationOutputDTO> create(@RequestBody @Valid AccommodationInputDTO accommodationInputDTO) {
		Accommodation accommodationCreated = acommodationService.create(new Accommodation(accommodationInputDTO));
		
		return ResponseEntity.ok(new AccommodationOutputDTO(accommodationCreated));
	}
}
