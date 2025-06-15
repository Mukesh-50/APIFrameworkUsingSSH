package base;

import org.testng.annotations.BeforeClass;

import com.aventstack.chaintest.plugins.ChainTestListener;

import config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseTest 
{

	public RequestSpecification req_specfication;
	
	public RequestSpecification req_specfication_xml;

	public ResponseSpecification resp_specfication;

	public ResponseSpecification resp_specfication_201;

	@BeforeClass
	public void setup() 
	{

		ConfigReader config = new ConfigReader();

		String baseurl = config.get("baseURLProduct");
		
		ChainTestListener.log("LOG:INFO- Setting up RequestSpecification and ResponseSpecification For All API Test");

		req_specfication = new RequestSpecBuilder()
				.log(LogDetail.ALL)
				.setContentType(ContentType.JSON)
				.setBaseUri(baseurl)
				.build();
		
		req_specfication_xml = new RequestSpecBuilder().log(LogDetail.ALL).setContentType(ContentType.XML)
				.setBaseUri(baseurl).build();

		resp_specfication = new ResponseSpecBuilder().log(LogDetail.ALL).expectContentType(ContentType.JSON).expectStatusCode(200).build();

		resp_specfication_201 = new ResponseSpecBuilder().log(LogDetail.ALL).expectContentType(ContentType.JSON)
				.build();

	}

}
