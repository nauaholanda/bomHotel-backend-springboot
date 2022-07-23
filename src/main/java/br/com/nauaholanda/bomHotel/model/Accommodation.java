package br.com.nauaholanda.bomHotel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.nauaholanda.bomHotel.dto.input.AccommodationInputDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Accommodation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String description;
	
	private Double dailyCost;
	
	private Integer occupancy;
	
	private String address;
	
	private String zipCode;
	
	private String city;
	
	private String state;
	
	private String country;
	
	public Accommodation(AccommodationInputDTO accommodationInputDTO) {
		this.id = accommodationInputDTO.getId();
		this.name = accommodationInputDTO.getName();
		this.description = accommodationInputDTO.getDescription();
		this.dailyCost = accommodationInputDTO.getDailyCost();
		this.occupancy = accommodationInputDTO.getOccupancy();
		this.address = accommodationInputDTO.getAddress();
		this.zipCode = accommodationInputDTO.getZipCode();
		this.city = accommodationInputDTO.getCity();
		this.state = accommodationInputDTO.getState();
		this.country = accommodationInputDTO.getCountry();
	}
	
}
