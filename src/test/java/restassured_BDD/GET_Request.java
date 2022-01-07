package restassured_BDD;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.collection.IsArrayContaining;
import org.testng.annotations.Test;

public class GET_Request {
	
	/*
	 * 1. assertion hasItems validating some of the users emails. 
	 * 2. assertion for users with departmentID 1
	 */
	
	@Test
	
	public void GetRequest() {
		
		given()
		.when()
		.get("http://localhost:3000/users")
		.then()
		.statusCode(200)
		.contentType("application/json")
		.assertThat().body("email",hasItems("rtrevillion0@com.com","ggavin2@blogtalkradio.com","hwiffler3@earthlink.net","kmilroy4@sbwire.com","tcostar5@list-manage.com"))
		.body("[2].departmentId",equalTo(7));
	}
	
	@Test
	
	public void GetUserDepartmentId() {
		
		given()
		.when()
		.get("http://localhost:3000/department/1/users")
		.then()
		.statusCode(200)
		.contentType("application/json")
		.assertThat().body("email",hasItems("rtrevillion0@com.com", "mbourdas8@domainmarket.com"))
		.assertThat().body("first_name",hasItems("Rafi","Milzie"))
		.body("departmentId",hasItems(1, 1));
	}

}
