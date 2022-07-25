package br.com.nauaholanda.bomHotel.service;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.nauaholanda.bomHotel.model.User;
import br.com.nauaholanda.bomHotel.repository.UserRepository;

@ExtendWith(SpringExtension.class)
public class UserServiceImplTest {
	
	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl userService;
	
	@DisplayName("Create method should return the registered user")
	@Test
	void createMethodShouldReturnTheRegisteredUser() {
		User userToCreate = new User(null, "username", "password", "Name", new ArrayList<>(), null);
		User registeredUser = new User(1L, userToCreate.getUsername(), userToCreate.getPassword(), userToCreate.getName(), new ArrayList<>(), null);
		
		Mockito.when(userRepository.findByUsername(userToCreate.getUsername())).thenReturn(Optional.empty());
		
		Mockito.when(userRepository.save(userToCreate)).thenReturn(registeredUser);
		
		Assertions.assertEquals(registeredUser, userService.create(userToCreate));
	}
	
	@DisplayName("Create method should throw Username already exists exception")
	@Test
	void createMethodShouldThrowUsernameAlreadyExistsException() {
		User userToCreate = new User(null, "username", "password", "Name", new ArrayList<>(), null);
		User userInDB = new User(1L, userToCreate.getUsername(), userToCreate.getPassword(), userToCreate.getName(), new ArrayList<>(), null);
		
		Mockito.when(userRepository.findByUsername(userToCreate.getUsername())).thenReturn(Optional.of(userInDB));
		
		try {
			userService.create(userToCreate);
		} catch (Exception e) {
			String expectedMessage = "Username " + userToCreate.getUsername() + " already exists!";
			Assertions.assertEquals(expectedMessage, e.getMessage());
		}
		
	}
	
}
