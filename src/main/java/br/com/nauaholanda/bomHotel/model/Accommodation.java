package br.com.nauaholanda.bomHotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.nauaholanda.bomHotel.dto.input.AccommodationInputDTO;
import br.com.nauaholanda.bomHotel.dto.input.AccommodationSearchInputDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Accommodation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(length = 2048)	
	private String description;
	
	private String imageURL;
	
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
		this.imageURL = accommodationInputDTO.getImageURL();
		this.dailyCost = accommodationInputDTO.getDailyCost();
		this.occupancy = accommodationInputDTO.getOccupancy();
		this.address = accommodationInputDTO.getAddress();
		this.zipCode = accommodationInputDTO.getZipCode();
		this.city = accommodationInputDTO.getCity();
		this.state = accommodationInputDTO.getState();
		this.country = accommodationInputDTO.getCountry();
	}

	public Accommodation(AccommodationSearchInputDTO accommodationSearchInputDTO) {
		this.city = accommodationSearchInputDTO.getCity();
		this.state = accommodationSearchInputDTO.getState();
		this.country = accommodationSearchInputDTO.getCountry();
	}
	
}
