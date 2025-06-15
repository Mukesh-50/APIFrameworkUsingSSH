package models;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking 
{
	
	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private String additionalneeds;
	private BookingDates bookingdates;
	
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class BookingDates{
		
		private String checkin;
		private String checkout;
		
		
	}

}
