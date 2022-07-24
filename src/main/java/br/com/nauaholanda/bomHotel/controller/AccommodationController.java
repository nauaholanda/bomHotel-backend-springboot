package br.com.nauaholanda.bomHotel.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<List<AccommodationOutputDTO>> findAll() {
		List<AccommodationOutputDTO> accommodationDTOList = acommodationService.findAll().stream()
				.map(accommodation -> new AccommodationOutputDTO(accommodation)).collect(Collectors.toList());
		
		return ResponseEntity.ok(accommodationDTOList);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AccommodationOutputDTO> findById(@PathVariable Long id) {
		Accommodation accommodationFound = acommodationService.findById(id);
		
		return ResponseEntity.ok(new AccommodationOutputDTO(accommodationFound));
	}
	
	@GetMapping("/newest")
	public ResponseEntity<List<AccommodationOutputDTO>> find5Newest() {
		List<AccommodationOutputDTO> accommodationDTOList = acommodationService.find5Newest().stream()
				.map(accommodation -> new AccommodationOutputDTO(accommodation)).collect(Collectors.toList());
		
		return ResponseEntity.ok(accommodationDTOList);
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<AccommodationOutputDTO>> search(@RequestParam String city, @RequestParam String state,
			@RequestParam String country, @RequestParam Integer occupancy) {
		List<AccommodationOutputDTO> accommodationDTOList = acommodationService.search(city, state, country, occupancy).stream()
				.map(accommodation -> new AccommodationOutputDTO(accommodation)).collect(Collectors.toList());
	
		return ResponseEntity.ok(accommodationDTOList);
	}
	
	@PostMapping
	public ResponseEntity<AccommodationOutputDTO> create(@RequestBody @Valid AccommodationInputDTO accommodationInputDTO) {
		Accommodation accommodationCreated = acommodationService.create(new Accommodation(accommodationInputDTO));
		
		return ResponseEntity.created(URI.create("/accommodation/" + accommodationCreated.getId())).body(new AccommodationOutputDTO(accommodationCreated));
	}
	
	@PutMapping
	public ResponseEntity<AccommodationOutputDTO> update(@RequestBody @Valid AccommodationInputDTO accommodationInputDTO) {
		Accommodation accommodationUpdated = acommodationService.update(new Accommodation(accommodationInputDTO));
		
		return ResponseEntity.ok(new AccommodationOutputDTO(accommodationUpdated));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		acommodationService.deleteById(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
