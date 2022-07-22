package br.com.nauaholanda.bomHotel.dto.output;

import br.com.nauaholanda.bomHotel.enumeration.UserRole;
import lombok.Data;

@Data
public class UserOutputDTO {
	
	private Long id;
	
	private String username;
	
	private String name;
	
	private UserRole role;
	
}
