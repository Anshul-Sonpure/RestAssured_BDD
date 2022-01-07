package restassured_BDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

import org.testng.annotations.Test;

public class SchemaValidator {
	
	@Test
	private void schemaValidator() {
		
		given()
		.when()
		.get("http://localhost:3000/users")
		.then()
		.statusCode(200)
		.assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
		

	}

}
