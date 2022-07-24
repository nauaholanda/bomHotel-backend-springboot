package br.com.nauaholanda.bomHotel.service;

import java.util.Arrays;
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

import br.com.nauaholanda.bomHotel.model.Accommodation;
import br.com.nauaholanda.bomHotel.repository.AccommodationRepository;

@ExtendWith(SpringExtension.class)
public class AccommodationServiceImplTest {
	
	@Mock
	AccommodationRepository accommodationRepository;
	
	@InjectMocks
	AccommodationServiceImpl accommodationService;
	
	@DisplayName("Find all method should return repository Find all method result")
	@Test
	void findAllMethodShouldReturnRepositoryFindAllMethodResult() {
		List<Accommodation> accommodationsOnDB = Arrays.asList(new Accommodation(), new Accommodation(), new Accommodation());
		
		Mockito.when(accommodationRepository.findAll()).thenReturn(accommodationsOnDB);
		
		Assertions.assertEquals(accommodationsOnDB, accommodationService.findAll());
	}
	
	@DisplayName("Find 5 newest method should return repository Find first 5 by order by id desc method result")
	@Test
	void find5NewestMethodShouldReturnRepositoryFindFirst5ByOrderByIdDescMethodResult() {
		List<Accommodation> accommodationsOnDB = Arrays.asList(new Accommodation(), new Accommodation(), new Accommodation());
		
		Mockito.when(accommodationRepository.findFirst5ByOrderByIdDesc()).thenReturn(accommodationsOnDB);
		
		Assertions.assertEquals(accommodationsOnDB, accommodationService.find5Newest());
	}
	
	@DisplayName("Search method with params should return repository Search by city, state and country method result")
	@Test
	void SearchMethodWithParamsShouldReturnRepositorySearchByCityStateAndCountryMethodResult() {
		List<Accommodation> accommodationsOnDB = Arrays.asList(new Accommodation(1L, "name", "description", "imageURL", 2.5D, 2, "address", "60000-000", "city", "state", "country"));
		
		String cityToSearch = "city";
		String stateToSearch = "state";
		String countryToSearch = "country";
		Integer occupancyToSearch = 2;
		
		Mockito.when(accommodationRepository
				.findByCityContainingAndStateContainingAndCountryContainingAllIgnoreCaseAndOccupancyGreaterThanEqual(cityToSearch, stateToSearch, countryToSearch, occupancyToSearch))
				.thenReturn(accommodationsOnDB);
		
		Assertions.assertEquals(accommodationsOnDB, accommodationService.search(cityToSearch, stateToSearch, countryToSearch, occupancyToSearch));
	}
	
	@DisplayName("Search method with null params should return repository Search by city, state and country method result")
	@Test
	void SearchMethodWithNullParamsShouldReturnRepositorySearchByCityStateAndCountryMethodResult() {
		List<Accommodation> accommodationsOnDB = Arrays.asList(new Accommodation(1L, "name", "description", "imageURL", 0D, 0, "address", "60000-000", "city", "state", "country"));
		
		String cityToSearch = null;
		String stateToSearch = null;
		String countryToSearch = null;
		Integer occupancyToSearch = null;
		
		Mockito.when(accommodationRepository
				.findByCityContainingAndStateContainingAndCountryContainingAllIgnoreCaseAndOccupancyGreaterThanEqual("", "", "", 0))
				.thenReturn(accommodationsOnDB);
		
		Assertions.assertEquals(accommodationsOnDB, accommodationService.search(cityToSearch, stateToSearch, countryToSearch, occupancyToSearch));
	}
	
	@DisplayName("Find by id method should throw Accommodation not found exception")
	@Test
	void findByIdMethodShouldThrowAccomodationNotFoundException() {
		Long idToSearch = 1L;
		
		Mockito.when(accommodationRepository.findById(idToSearch)).thenReturn(Optional.empty());
		
		try {
			accommodationService.findById(idToSearch);
		} catch (Exception e) {
			String expectedMessage = "Accommodation with id " + idToSearch + " not found!";
			Assertions.assertEquals(expectedMessage, e.getMessage());
		}
	}
	
	@DisplayName("Find by id method should return a registered accommodation")
	@Test
	void findByIdMethodShouldReturnARegisteredAccommodation() {
		Accommodation accommodationOnDB = new Accommodation(1L, "name", "description", "imageURL", 0D, 0, "address", "60000-000", "city", "state", "country");
		
		Long idToSearch = 1L;
		
		Mockito.when(accommodationRepository.findById(idToSearch)).thenReturn(Optional.of(accommodationOnDB));
		
		try {
			accommodationService.findById(idToSearch);
		} catch (Exception e) {
			String expectedMessage = "Accommodation with id " + idToSearch + " not found!";
			Assertions.assertEquals(expectedMessage, e.getMessage());
		}
	}
	
	@DisplayName("Create method should return repository Save method result")
	@Test
	void CreateMethodShouldReturnRepositorySaveMethodResult() {
		Accommodation accommodationToSave = new Accommodation(null, "name", "description", "imageURL", 0D, 0, "address", "60000-000", "city", "state", "country");
		Accommodation registeredAccommodation = new Accommodation(1L, "name", "description", "imageURL", 0D, 0, "address", "60000-000", "city", "state", "country");
		
		Mockito.when(accommodationRepository.save(accommodationToSave))
				.thenReturn(registeredAccommodation);
		
		Assertions.assertEquals(registeredAccommodation, accommodationService.create(accommodationToSave));
	}
	
	@DisplayName("Update method should return repository Save method result")
	@Test
	void UpdateMethodShouldReturnRepositorySaveMethodResult() {
		Accommodation accommodationToUpdate = new Accommodation(1L, "name", "description", "imageURL", 0D, 0, "address", "60000-000", "city", "state", "country");
		Accommodation updatedAccommodation = new Accommodation(1L, "name", "description", "imageURL", 0D, 0, "address", "60000-000", "city", "state", "country");
		
		Mockito.when(accommodationRepository.save(accommodationToUpdate))
				.thenReturn(updatedAccommodation);
		
		Assertions.assertEquals(updatedAccommodation, accommodationService.create(accommodationToUpdate));
	}
	
	@DisplayName("Delete method should don't throw any exception")
	@Test
	void deleteMethodShouldDontThrowAnyException() {
		Long idToDelete = 1L;
		
		Mockito.doNothing().when(accommodationRepository).deleteById(idToDelete);
		
		try {
			accommodationService.deleteById(idToDelete);
		} catch (Exception e) {
			Assertions.fail();
		}
	}
	
}
