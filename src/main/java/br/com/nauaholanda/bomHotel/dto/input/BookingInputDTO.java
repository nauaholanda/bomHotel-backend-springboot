package br.com.nauaholanda.bomHotel.dto.input;

import java.util.Date;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingInputDTO {
	
	@NotNull
	private Date checkinDate;
	
	@NotNull
	private Date checkoutDate;
	
	@NotNull
	private double totalCost;
	
	@NotNull
	private Long userId;
	
	@NotNull
	private Long accommodationId;
	
}
