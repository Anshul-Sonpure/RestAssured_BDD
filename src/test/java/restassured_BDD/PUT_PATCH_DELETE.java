package restassured_BDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PUT_PATCH_DELETE {
	
	@Test
	private void PutRequest() {
		
		JSONObject request = new JSONObject();
		request.put("name", "NameSake");
		request.put("job", "Teacher");
		given()
		.contentType("application/json")
		.body(request.toJSONString())
		.when()
		.put("https://reqres.in/api/users")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test
	private void PatchRequest() {
		
		JSONObject request = new JSONObject();
		request.put("name", "John");
		request.put("job", "Leader");
		given()
		.contentType("application/json")
		.body(request.toJSONString())
		.when()
		.patch("https://reqres.in/api/users")
		.then()
		.statusCode(200)
		.log().all();
		
	}
	
	@Test
	private void DeleteRequest() {
		
		
		when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204)
		.log().all();
		
	}
	

}
