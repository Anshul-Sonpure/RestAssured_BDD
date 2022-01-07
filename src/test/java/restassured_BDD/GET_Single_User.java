package restassured_BDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class GET_Single_User {
	
	@Test
	
	public void GetRequest() {
		
		given()
		.when()
		.get("http://localhost:3000/users/3")
		.then()
		.statusCode(200)
		.contentType("application/json")
		.body("email",equalTo("ggavin2@blogtalkradio.com"))
		.body("first_name", equalTo("Giffer"))
		.body("last_name", equalTo("Gavin"))
		.body("departmentId", equalTo("5"));
		
		
		
	}

}
