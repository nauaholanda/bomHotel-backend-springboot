package br.com.nauaholanda.bomHotel.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nauaholanda.bomHotel.dto.input.UserInputDTO;
import br.com.nauaholanda.bomHotel.dto.output.UserOutputDTO;
import br.com.nauaholanda.bomHotel.model.User;
import br.com.nauaholanda.bomHotel.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService; 
	
	@PostMapping
	public ResponseEntity<UserOutputDTO> create(@RequestBody @Valid UserInputDTO userInputDTO) {
		User userCreated = userService.create(new User(userInputDTO));
		
		UserOutputDTO userOutputDTO = new UserOutputDTO(userCreated);
		return ResponseEntity.created(URI.create("/user/" + userOutputDTO.getId())).body(userOutputDTO);
	}
}
