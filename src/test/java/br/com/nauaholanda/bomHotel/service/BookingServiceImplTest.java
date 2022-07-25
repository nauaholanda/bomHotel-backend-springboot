package br.com.nauaholanda.bomHotel.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.nauaholanda.bomHotel.dto.input.BookingInputDTO;
import br.com.nauaholanda.bomHotel.exception.AccommodationNotFoundException;
import br.com.nauaholanda.bomHotel.exception.UserNotFoundException;
import br.com.nauaholanda.bomHotel.model.Accommodation;
import br.com.nauaholanda.bomHotel.model.Booking;
import br.com.nauaholanda.bomHotel.model.User;
import br.com.nauaholanda.bomHotel.repository.AccommodationRepository;
import br.com.nauaholanda.bomHotel.repository.BookingRepository;
import br.com.nauaholanda.bomHotel.repository.UserRepository;

@ExtendWith(SpringExtension.class)
public class BookingServiceImplTest {

	@Mock
	BookingRepository bookingRepository;

	@Mock
	UserRepository userRepository;

	@Mock
	AccommodationRepository accommodationRepository;

	@InjectMocks
	BookingServiceImpl bookingService;

	@DisplayName("Find by user id method should return repository Find by user id method result")
	@Test
	void findByUserIdMethodShouldReturnRepositoryFindByUserIdMethodResult() {
		List<Booking> bookingsOnDB = Arrays.asList(new Booking(), new Booking(), new Booking());

		Long userIdToSearch = 1L;

		Mockito.when(bookingRepository.findByUserId(userIdToSearch)).thenReturn(bookingsOnDB);

		Assertions.assertEquals(bookingsOnDB, bookingService.findByUserId(userIdToSearch));
	}

	@DisplayName("Create method should return repository Save method result")
	@Test
	void createMethodShouldReturnRepositorySaveMethodResult() {
		Booking bookingToSave = new Booking(null, new Date(), new Date(), new User(), new Accommodation());
		Booking bookingCreated = new Booking(1L, new Date(), new Date(), new User(), new Accommodation());

		Mockito.when(bookingRepository.save(bookingToSave)).thenReturn(bookingCreated);

		Assertions.assertEquals(bookingCreated, bookingService.create(bookingToSave));
	}

	@DisplayName("Convert input dto to entity method should return a filled entity")
	@Test
	void convertInputDTOtoEnttiyMethodShouldReturnAFilledEntity() {
		BookingInputDTO bookingInputDTO = new BookingInputDTO(new Date(), new Date(), 1L, 1L);

		User bookingUser = new User(1L, "username", "password", "Name", new ArrayList<>(), null);
		Accommodation bookingAccommodation = new Accommodation(1L, "name", "description", "imageURL", 2.5D, 2,
				"address", "60000-000", "city", "state", "country", new ArrayList<>());

		Mockito.when(userRepository.findById(bookingInputDTO.getUserId())).thenReturn(Optional.of(bookingUser));
		Mockito.when(accommodationRepository.findById(bookingInputDTO.getAccommodationId()))
				.thenReturn(Optional.of(bookingAccommodation));

		Booking expectedBooking = new Booking(null, bookingInputDTO.getCheckinDate(), bookingInputDTO.getCheckoutDate(),
				bookingUser, bookingAccommodation);

		Assertions.assertEquals(expectedBooking, bookingService.convertInputDTOtoEntity(bookingInputDTO));
	}

	@DisplayName("Convert input dto to entity method should throw User not found exception")
	@Test
	void convertInputDTOtoEnttiyMethodShouldThowUserNotFoundException() {
		BookingInputDTO bookingInputDTO = new BookingInputDTO(new Date(), new Date(), 1L, 1L);

		Accommodation bookingAccommodation = new Accommodation(1L, "name", "description", "imageURL", 2.5D, 2,
				"address", "60000-000", "city", "state", "country", new ArrayList<>());

		Mockito.when(userRepository.findById(bookingInputDTO.getUserId())).thenReturn(Optional.empty());
		Mockito.when(accommodationRepository.findById(bookingInputDTO.getAccommodationId()))
				.thenReturn(Optional.of(bookingAccommodation));

		String returnedMessage = "";
		try {
			bookingService.convertInputDTOtoEntity(bookingInputDTO);
		} catch (UserNotFoundException e) {
			returnedMessage = e.getMessage();
		}

		String expectedMessage = "User with id " + bookingInputDTO.getUserId() + " not found!";
		Assertions.assertEquals(expectedMessage, returnedMessage);
	}

	@DisplayName("Convert input dto to entity method should throw Accommodation not found exception")
	@Test
	void convertInputDTOtoEnttiyMethodShouldThowAccommodationNotFoundException() {
		BookingInputDTO bookingInputDTO = new BookingInputDTO(new Date(), new Date(), 1L, 1L);

		User bookingUser = new User(1L, "username", "password", "Name", new ArrayList<>(), null);

		Mockito.when(userRepository.findById(bookingInputDTO.getUserId())).thenReturn(Optional.of(bookingUser));
		Mockito.when(accommodationRepository.findById(bookingInputDTO.getAccommodationId())).thenReturn(Optional.empty());

		String returnedMessage = "";
		try {
			bookingService.convertInputDTOtoEntity(bookingInputDTO);
		} catch (AccommodationNotFoundException e) {
			returnedMessage = e.getMessage();
		}

		String expectedMessage = "Accommodation with id " + bookingInputDTO.getAccommodationId() + " not found!";
		Assertions.assertEquals(expectedMessage, returnedMessage);
	}

}
