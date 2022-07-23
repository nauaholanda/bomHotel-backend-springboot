package br.com.nauaholanda.bomHotel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class Accommodation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Lob
	private String description;
	
	private Double dailyCost;
	
	private Integer numberOfPeople;
	
	private String address;
	
	private String zipCode;
	
	private String city;
	
	private String country;
	
}
