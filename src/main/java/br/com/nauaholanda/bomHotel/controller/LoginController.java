package br.com.nauaholanda.bomHotel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nauaholanda.bomHotel.dto.input.UserLoginInputDTO;
import br.com.nauaholanda.bomHotel.dto.output.UserOutputDTO;
import br.com.nauaholanda.bomHotel.model.User;
import br.com.nauaholanda.bomHotel.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping
	public ResponseEntity<UserOutputDTO> login(@RequestBody @Valid UserLoginInputDTO userLoginDTO) {
		User user = loginService.login(new User(userLoginDTO));
		UserOutputDTO userOutputDTO = new UserOutputDTO(user);
		return ResponseEntity.ok(userOutputDTO);
	}
}
