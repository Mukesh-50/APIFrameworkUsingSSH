package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import auth.TokenManager;
import base.BaseTest;
import enums.APIEndPoints;
import factory.BookingFactory;
import io.restassured.response.Response;
import models.Booking;
import utility.APIUtils;

public class BookingAPITests extends BaseTest
{
	
	int bookingID;
	
	@Test(description = "This test verify the new booking using post call",priority = 1)
	public void createNewBookingTest()
	{
		
	Booking user=BookingFactory.generateBookingData("Vindhya","Sree");	
	
	//Booking user=new Booking("Karma", "USA", 500, false, "Dinner", new BookingDates("2018-01-01", "2019-01-01"));

	//Response resp1=APIUtils.post("https://restful-booker.herokuapp.com/booking", user);
	

	Response resp=APIUtils.post(req_specfication, "/booking", user);
	
	resp.then().spec(resp_specfication);

	bookingID=resp.jsonPath().get("bookingid");
	
	System.out.println("Booking ID "+bookingID);
	
	Assert.assertEquals(resp.statusCode(), 200,"Response code did not match");
		
	}
	
	@Test(priority = 2)
	public void updateBookingID()
	{
		
		Booking user=BookingFactory.generateBookingData("Ramya","Sree");	
		
		Map<String, Object> pathparam=Map.of("id", bookingID);
		
		Map<String, Object> queryparam=Map.of();
		
		Map<String, Object> headers=Map.of("Content-Type", "application/json", "Accept", "application/json", "Cookie", "token="+TokenManager.getToken());

		Response resp=APIUtils.put(req_specfication, APIEndPoints.UPDATE_BOOKING.getPath(), user, pathparam, queryparam, headers);
		
		resp.then().spec(resp_specfication);
		
		Assert.assertEquals(resp.getStatusCode(), 200);		
		
	}
	
	@Test(priority = 3)
	public void deleteBooking()
	{
		Map<String, Object> queryparam=Map.of();
		
		Map<String, Object> pathparam=Map.of("id", bookingID);
		
		Map<String, Object> headers=Map.of("Content-Type", "application/json", "Cookie", "token="+TokenManager.getToken());
		
		Response resp=APIUtils.delete(req_specfication, APIEndPoints.DELETE_BOOKING.getPath(), pathparam, queryparam, headers);
	
		Assert.assertEquals(resp.getStatusCode(), 201);	
		
	}
	
	
	
	

}
