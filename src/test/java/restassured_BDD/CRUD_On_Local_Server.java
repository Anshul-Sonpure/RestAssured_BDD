package restassured_BDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class CRUD_On_Local_Server {
	
	@Test
	private void Get() {
		
		given()
		.when()
		.get("http://localhost:3000/users")
		.then()
		.statusCode(200)
		.contentType("application/json")
		.body("[3].email",equalTo("kmilroy4@sbwire.com")) //validate email id for user id=4
		.body("[3].first_name",equalTo("Kresten")) // Validate the first_name
		.body("[3].departmentId",equalTo(2)); // Validate the departmentID 

	}
	
	@Test
	private void PostRequest() {
		
		JSONObject request = new JSONObject();
		request.put("first_name", "morpheus");
		request.put("last_name", "kasey");
		request.put("email", "kaseymor@mail.com");
		request.put("gender", "Male");
		request.put("departmentId", "3");
		given()
		.contentType("application/json")
		.body(request.toJSONString())
		.when()
		.post("http://localhost:3000/users")
		.then()
		.statusCode(201)  //validates the StatusCode
		.log().all();
		
		}
	
	
	@Test
	private void PutRequest() {
		
		JSONObject request = new JSONObject();
		request.put("first_name", "NameSake");
		request.put("last_name", "Kenndy");
		request.put("email", "KennyJohn@outlook.com");
		request.put("gender", "Male");
		request.put("departmentId", "3");
		given()
		.contentType("application/json")
		.body(request.toJSONString())
		.when()
		.put("http://localhost:3000/users/6")
		.then()
		.statusCode(200)
		.body("email",equalTo("KennyJohn@outlook.com")) //validate email id for user id=4
		.body("first_name",equalTo("NameSake")); // Validate the first_name
		
	}
	
	@Test
	private void PatchRequest() {
		
		JSONObject request = new JSONObject();
		request.put("first_name", "John");
		given()
		.contentType("application/json")
		.body(request.toJSONString())
		.when()
		.patch("http://localhost:3000/users/6")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test
	private void DeleteRequest() {
		when()
		.delete("http://localhost:3000/users/6")
		.then()
		.statusCode(200)
		.log().all();
		
	}

}
