package scripts;
import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class GetOperation extends Baseclass {
	@Test
	public void tc1() throws FileNotFoundException, IOException {
		given()
		.pathParam("owner", pfile.getPropertyData("ownername"))
		.pathParam("repo", pfile.getPropertyData("reponame"))
		
		.when()
		.get("/repos/{owner}/{repo}")
		.then().log().all()
		
		.assertThat().statusCode(200)
		.contentType(ContentType.JSON);
		
		Reporter.log("Get operation is successful",true);
		
	}

}
