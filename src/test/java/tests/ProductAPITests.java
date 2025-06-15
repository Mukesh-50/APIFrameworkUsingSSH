package tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import enums.APIEndPoints;
import io.restassured.response.Response;
import models.Product;
import models.ProductData;
import utility.APIUtils;

public class ProductAPITests extends BaseTest {

	
	String objectId;
	
    @Test(priority = 1)
    public void createNewProductTest() {

       
        Product product = new Product();
        product.setName("Apple MacBook Pro 16");

        ProductData data = new ProductData();
        data.setYear(2019);
        data.setPrice(1849.99);
        data.setCPUmodel("Intel Core i9");
        data.setHarddisksize("1 TB");

        product.setData(data);

        // Call API
        Response resp = APIUtils.post(req_specfication, APIEndPoints.CREATE_PRODUCT.getPath(), product);

        resp.then().spec(resp_specfication);

        // Log response
        //System.out.println(resp.asPrettyString());

        // Validate
        Assert.assertEquals(resp.getStatusCode(), 200, "Expected status code is 200");
        
        objectId = resp.jsonPath().getString("id");
        
        
        System.out.println("Object id is "+objectId);
        
        

    }
    
    @Test(priority = 2, description = "Update product and verify fields updated")
    public void updateProductTest() {

      
       

        // Build updated payload
        Product product = new Product();
        product.setName("Apple MacBook Pro 16");

        ProductData data = new ProductData();
        data.setYear(2019);
        data.setPrice(2049.99); // ✅ Updated price
        data.setCPUmodel("Intel Core i9");
        data.setHarddisksize("1 TB");
        data.setColor("silver");  // ✅ New field

        product.setData(data);

        // Build path param
        Map<String, Object> pathParams = Map.of("id", objectId);

        // Build headers
        Map<String, Object> headers = Map.of(
                "Content-Type", "application/json"
        );

        
        Response resp= APIUtils.put(req_specfication, APIEndPoints.UPDATE_PRODUCT.getPath(),product,pathParams, null, headers);
        
        // Call PUT API
       // Response resp = APIUtils.put(req_specfication, APIEndPoints.UPDATE_PRODUCT.getPath(), pathParams, null, headers);

        resp.then().spec(resp_specfication);

        System.out.println(resp.asPrettyString());

        // ✅ Assertions
        Assert.assertEquals(resp.getStatusCode(), 200, "Expected status code 200");

        // You can also deserialize if needed — OR do inline JsonPath checks:

        Assert.assertEquals(resp.jsonPath().getDouble("data.price"), 2049.99, "Price not updated");
        Assert.assertEquals(resp.jsonPath().getString("data.color"), "silver", "Color not updated");
    }
    
    @Test(priority = 3, description = "Delete product and verify")
    public void deleteProductTest() {

        // Example → Object id to delete
       // String objectId = "6";

        // Path param
        Map<String, Object> pathParams = Map.of("id", objectId);

        // Headers → for this API, Content-Type is usually fine
        Map<String, String> headers = Map.of(
                "Content-Type", "application/json"
        );

        // Call DELETE
        Response resp = APIUtils.delete(req_specfication, APIEndPoints.DELETE_PRODUCT.getPath(), pathParams, null, null);

        // Log response
        System.out.println(resp.asPrettyString());

        // Validate
        // Usually 200 or 204 → this API returns 200 OK with message
        Assert.assertEquals(resp.getStatusCode(), 200, "Expected status code 200");

        // Optional: Verify message
        String message = resp.jsonPath().getString("message");
        Assert.assertTrue(message.contains("Object with id = " + objectId + " has been deleted"), "Delete message mismatch");
    }


}
