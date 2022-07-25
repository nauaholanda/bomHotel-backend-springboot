package br.com.nauaholanda.bomHotel.dto.output;

import java.util.Date;

import br.com.nauaholanda.bomHotel.model.Booking;
import lombok.Data;

@Data
public class BookingOutputDTO {
	
	private Date checkinDate;
	
	private Date checkoutDate;
	
	private Long userId;
	
	private Long accommodationId;
	
	public BookingOutputDTO(Booking booking) {
		this.checkinDate = booking.getCheckinDate();
		this.checkoutDate = booking.getCheckoutDate();
		this.userId = booking.getUser().getId();
		this.accommodationId = booking.getAccommodation().getId();
	}
	
}
