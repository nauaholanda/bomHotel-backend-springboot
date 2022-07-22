package br.com.nauaholanda.bomHotel.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nauaholanda.bomHotel.enumeration.UserRole;
import br.com.nauaholanda.bomHotel.exception.UserAuthenticationFailedException;
import br.com.nauaholanda.bomHotel.exception.UserNotFoundException;
import br.com.nauaholanda.bomHotel.model.User;
import br.com.nauaholanda.bomHotel.repository.UserRepository;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User login(User userToLogin) {
		if ("admin".equalsIgnoreCase(userToLogin.getUsername())
				&& "admin".equalsIgnoreCase(userToLogin.getPassword())) {
			return new User(0L, userToLogin.getUsername(), userToLogin.getPassword(), "Admin", UserRole.ADMIN);
		}

		Optional<User> userInDBOptional = userRepository.findByUsername(userToLogin.getUsername());

		if (userInDBOptional.isPresent()) {
			User userInDB = userInDBOptional.get();

			if (userInDB.getPassword() != null && userToLogin.getPassword().equals(userInDB.getPassword())) {
				userInDB.setRole(UserRole.CUSTOMER);

				return userInDB;
			} else {
				throw new UserAuthenticationFailedException(userToLogin.getUsername());
			}

		} else {
			throw new UserNotFoundException(userToLogin.getUsername());
		}

	}
}
