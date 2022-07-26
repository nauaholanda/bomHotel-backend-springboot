package br.com.nauaholanda.bomHotel.dto.output;

import java.util.Date;

import br.com.nauaholanda.bomHotel.model.Booking;
import lombok.Data;

@Data
public class BookingOutputDTO {
	
	private Date checkinDate;
	
	private Date checkoutDate;
	
	private double totalCost;
	
	private Long userId;
	
	private AccommodationOutputDTO accommodation;
	
	public BookingOutputDTO(Booking booking) {
		this.checkinDate = booking.getCheckinDate();
		this.checkoutDate = booking.getCheckoutDate();
		this.totalCost = booking.getTotalCost();
		this.userId = booking.getUser().getId();
		this.accommodation = new AccommodationOutputDTO(booking.getAccommodation());
	}
	
}
