package br.com.nauaholanda.bomHotel.dto.input;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AccommodationInputDTO {
	
	private Long id;
	
	@NotBlank
	private String name;

	@NotBlank
	private String description;

	@NotNull
	private Double dailyCost;

	@NotNull
	private Integer occupancy;

	@NotBlank
	private String address;

	@NotBlank
	private String zipCode;

	@NotBlank
	private String city;
	
	@NotBlank
	private String state;

	@NotBlank
	private String country;
	
}
