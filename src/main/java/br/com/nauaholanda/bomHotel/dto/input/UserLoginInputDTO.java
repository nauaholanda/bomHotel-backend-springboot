package br.com.nauaholanda.bomHotel.dto.input;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserLoginInputDTO {
	
	@NotBlank
	private String username;
	
	@NotBlank
	private String password;
	
}
