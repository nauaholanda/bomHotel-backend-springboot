package br.com.nauaholanda.bomHotel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.nauaholanda.bomHotel.dto.input.UserInputDTO;
import br.com.nauaholanda.bomHotel.dto.input.UserLoginInputDTO;
import br.com.nauaholanda.bomHotel.enumeration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String username;
	
	private String password;
	
	private String name;
	
	@Transient
	private UserRole role;
	
	public User(UserInputDTO userInputDTO) {
		this.username = userInputDTO.getUsername();
		this.password = userInputDTO.getPassword();
		this.name = userInputDTO.getName();
	}
	
	public User(UserLoginInputDTO userLoginInputDTO) {
		this.username = userLoginInputDTO.getUsername();
		this.password = userLoginInputDTO.getPassword();
	}
}
