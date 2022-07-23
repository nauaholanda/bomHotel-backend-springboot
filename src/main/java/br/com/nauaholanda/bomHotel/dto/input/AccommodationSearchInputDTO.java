package br.com.nauaholanda.bomHotel.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AccommodationSearchInputDTO {
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String state;

	@NotBlank
	private String country;
	
}
