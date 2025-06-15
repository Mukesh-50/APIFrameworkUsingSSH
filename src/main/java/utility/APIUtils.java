package utility;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIUtils 
{
	
	public static Response post(String apiendpoint,Object payload)
	{
	 Response resp=	given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.body(payload)
		.when()
		.post(apiendpoint);
	 
	 return resp;
	 
	}
	
	public static Response post(String apiendpoint,String payload)
	{
	 Response resp=	given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.body(payload)
		.when()
		.post(apiendpoint);
	 
	 return resp;
	 
	}
	
	public static Response post(String apiendpoint,File payload)
	{
	 Response resp=	given()
		.contentType(ContentType.JSON)
		.log()
		.all()
		.body(payload)
		.when()
		.post(apiendpoint);
	 
	 return resp;
	 
	}
	
	
	public static Response post(RequestSpecification spec,String path,Object payload)
	{
	 Response resp=	given()
		.spec(spec)
		.body(payload)
		.when()
		.post(path);
	 
	 return resp;
	 
	}
	
	public static Response post(RequestSpecification spec,String path,String payload)
	{
	 Response resp=	given()
		.spec(spec)
		.body(payload)
		.when()
		.post(path);
	 
	 return resp;
	 
	}
	
	public static Response post(RequestSpecification spec,String path,File payload)
	{
	 Response resp=	given()
		.spec(spec)
		.body(payload)
		.when()
		.post(path);
	 
	 return resp;
	 
	}
	
/*	
	public static Response put(RequestSpecification spec,String path,Object payload,String pathParam, Headers header, Cookies cookies)
	{
	 Response resp=	given()
		.spec(spec)
		.headers(header)
		.body(payload)
		.when()
		.put(path);
	 
	 return resp;
	 
	}
	*/
	public static Response put(RequestSpecification spec,String path,Object payload,Map<String, Object> pathparam,Map<String,Object> queryparam,Map<String, Object> headers)
	{
	 
		Response resp= given()
		.spec(spec)
		.headers(headers !=null ? headers: Map.of())
		.pathParams(pathparam !=null ? pathparam : Map.of())
		.queryParams(queryparam !=null? queryparam:Map.of())
		.body(payload)
		.when()
		.put(path);
		
	 return resp;
	}
	
	public static Response put(RequestSpecification spec,String path,Object payload,Map<String, Object> pathparam,Map<String, Object> headers)
	{
	 
		Response resp= given()
		.spec(spec)
		.headers(headers !=null ? headers: Map.of())
		.pathParams(pathparam !=null ? pathparam : Map.of())
		.body(payload)
		.when()
		.put(path);
		
	 return resp;
	}
	
	public static Response put(RequestSpecification spec,String path,Object payload,Map<String, Object> headers)
	{
	 
		Response resp= given()
		.spec(spec)
		.headers(headers !=null ? headers: Map.of())
		.body(payload)
		.when()
		.put(path);
		
	 return resp;
	}
	
	
	public static Response put(RequestSpecification spec,String path,Object payload, Map<String, String> headers, Map<String, Object> pathParams, Object object, Object object2)
	{
	 
		Response resp= given()
		.spec(spec)
		.body(payload)
		.when()
		.put(path);
		
	 return resp;
	}
	
	public static Response delete(RequestSpecification spec,String path,Map<String, Object> pathparam,Map<String,Object> queryparam,Map<String, Object> headers)
	{
	 
		Response resp= given()
		.spec(spec)
		.headers(headers !=null ? headers: Map.of())
		.pathParams(pathparam !=null ? pathparam : Map.of())
		.queryParams(queryparam !=null? queryparam:Map.of())
		.when()
		.delete(path);
		
	 return resp;
	}
	

}
