package br.com.nauaholanda.bomHotel.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.nauaholanda.bomHotel.enumeration.UserRole;
import br.com.nauaholanda.bomHotel.model.User;
import br.com.nauaholanda.bomHotel.repository.UserRepository;

@ExtendWith(SpringExtension.class)
public class LoginServiceImplTest {
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	LoginServiceImpl LoginService;
	
	@DisplayName("Login method should return a registered user")
	@Test
	void loginMethodShouldReturnARegisteredUser() {
		User userToLogin = new User(null, "username", "password", null, null);
		User userInDB = new User(1L, userToLogin.getUsername(), userToLogin.getPassword(), "Name", null);
		
		Mockito.when(userRepository.findByUsername(userToLogin.getUsername())).thenReturn(Optional.of(userInDB));
		
		User expectedUser = new User(1L, userToLogin.getUsername(), userToLogin.getPassword(), "Name", UserRole.CUSTOMER);
		Assertions.assertEquals(expectedUser, LoginService.login(userToLogin));
	}
	
	@DisplayName("Login method should throw a User not found exception")
	@Test
	void loginMethodShouldThrowAUserNotFoundException() {
		User userToLogin = new User(null, "username", "password", null, null);
		
		Mockito.when(userRepository.findByUsername(userToLogin.getUsername())).thenReturn(Optional.empty());
		
		try {
			LoginService.login(userToLogin);
		} catch (Exception e) {
			String expectedMessage = "User " + userToLogin.getUsername() + " not found!";
			Assertions.assertEquals(expectedMessage, e.getMessage());
		}
	}
	
	@DisplayName("Login method should throw a User authentication failed exception")
	@Test
	void loginMethodShouldThrowAUserAuthenticationException() {
		User userToLogin = new User(null, "username", "password", null, null);
		User userInDB = new User(1L, userToLogin.getUsername(), "another_password", "Name", null);
		
		Mockito.when(userRepository.findByUsername(userToLogin.getUsername())).thenReturn(Optional.of(userInDB));
		
		try {
			LoginService.login(userToLogin);
		} catch (Exception e) {
			String expectedMessage = "Authentication failed for user " + userToLogin.getUsername() + "!";
			Assertions.assertEquals(expectedMessage, e.getMessage());
		}
	}
	
}
