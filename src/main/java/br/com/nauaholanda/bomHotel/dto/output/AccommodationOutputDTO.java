package br.com.nauaholanda.bomHotel.dto.output;

import br.com.nauaholanda.bomHotel.model.Accommodation;
import lombok.Data;

@Data
public class AccommodationOutputDTO {
	
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
	
	public AccommodationOutputDTO(Accommodation accommodation) {
		this.id = accommodation.getId();
		this.name = accommodation.getName();
		this.description = accommodation.getDescription();
		this.dailyCost = accommodation.getDailyCost();
		this.occupancy = accommodation.getOccupancy();
		this.address = accommodation.getAddress();
		this.zipCode = accommodation.getZipCode();
		this.city = accommodation.getCity();
		this.state = accommodation.getState();
		this.country = accommodation.getCountry();
	}
}
