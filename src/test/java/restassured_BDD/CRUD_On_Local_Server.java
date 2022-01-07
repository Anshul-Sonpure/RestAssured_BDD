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
		.body("[3].email",equalTo("kmilroy4@sbwire.com"));


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
		.statusCode(201)
		.log().all();
		
		}
	
	
	@Test
	private void PutRequest() {
		
		JSONObject request = new JSONObject();
		request.put("first_name", "NameSake");
		request.put("last_name", "Kenndy");
		request.put("email", "kKenndy@mail.com");
		request.put("gender", "Male");
		request.put("departmentId", "3");
		given()
		.contentType("application/json")
		.body(request.toJSONString())
		.when()
		.put("http://localhost:3000/users/6")
		.then()
		.statusCode(200)
		.log().all();
		
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
