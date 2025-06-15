package factory;

import models.Booking;
import models.Booking.BookingDates;

public class BookingFactory 
{
	
	public static Booking generateBookingData(String firstName,String lastName)
	{
		Booking user=new Booking(firstName, lastName, 500, false, "Dinner", new BookingDates("2018-01-01", "2019-01-01"));
		
		return user;
	}

}
