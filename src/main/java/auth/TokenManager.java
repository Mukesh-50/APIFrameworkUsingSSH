package auth;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TokenManager {

	private static String token;

	public static String getToken() {

		AuthRequest request = new AuthRequest("admin", "password123");

		if (token == null) 
		{
			Response resp = RestAssured
					.given()
					.body(request)
					.contentType(ContentType.JSON)
					.when()
					.post("https://restful-booker.herokuapp.com/auth");

			token = resp.jsonPath().get("token");
		}

		return token;
	}

}
