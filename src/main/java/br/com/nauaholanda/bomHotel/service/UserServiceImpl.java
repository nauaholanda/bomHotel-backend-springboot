package br.com.nauaholanda.bomHotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nauaholanda.bomHotel.exception.UsernameAlreadyExistsException;
import br.com.nauaholanda.bomHotel.model.User;
import br.com.nauaholanda.bomHotel.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User create(User userToCreate) {
		boolean usernameAlreadyExists = userRepository.findByUsername(userToCreate.getUsername()).isPresent();
		
		if (usernameAlreadyExists) throw new UsernameAlreadyExistsException(userToCreate.getUsername());
		
		return userRepository.save(userToCreate);
	}

}
