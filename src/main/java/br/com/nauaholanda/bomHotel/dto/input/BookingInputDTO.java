package br.com.nauaholanda.bomHotel.dto.input;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class BookingInputDTO {
	
	@NotNull
	private Date checkinDate;
	
	@NotNull
	private Date checkoutDate;
	
	@NotNull
	private Long userId;
	
	@NotNull
	private Long accommodationId;
	
}
