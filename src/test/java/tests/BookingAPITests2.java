package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import enums.APIEndPoints;
import factory.BookingFactory;
import io.restassured.response.Response;
import models.Booking;
import utility.APIUtils;

public class BookingAPITests2 extends BaseTest
{
	
	int bookingID;
	
	@Test(description = "This test verify the new booking using post call",priority = 1)
	public void createNewBookingTest()
	{
	Booking user=BookingFactory.generateBookingData("Vindhya","Sree");	
		
	Response resp=APIUtils.post(req_specfication, APIEndPoints.CREATE_BOOKING.getPath(), user);
	
	resp.then().spec(resp_specfication);

	bookingID=resp.jsonPath().get("bookingid");
	
	System.out.println("Booking ID "+bookingID);
	
	Assert.assertEquals(resp.statusCode(), 200,"Response code did not match");
		
	}
	
}
