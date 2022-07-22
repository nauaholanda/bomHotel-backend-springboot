package br.com.nauaholanda.bomHotel.dto.output;

import br.com.nauaholanda.bomHotel.enumeration.UserRole;
import br.com.nauaholanda.bomHotel.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserOutputDTO {
	
	private Long id;
	
	private String username;
	
	private String name;
	
	private UserRole role;
	
	public UserOutputDTO(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.name = user.getName();
		this.role = user.getRole();
	}
	
}
