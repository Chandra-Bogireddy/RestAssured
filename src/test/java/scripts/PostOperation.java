package scripts;
import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLib.IEndPoints;
import genericLib.JavaUtility;
import github_pojoLib.Project;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class PostOperation extends Baseclass{
	@Test
	public void tc2() throws FileNotFoundException, IOException {
		String name = pfile.getPropertyData("repoName")+JavaUtility.getRandomnumber();
		Project p = new Project(name,pfile.getPropertyData("description"));
		
		Response resp=given()
		.auth().oauth2("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")
		.contentType(ContentType.JSON)
		.body(p)
		
		.when()
		.post(IEndPoints.postoperation);
		
		resp.then().log().all()
		.assertThat().statusCode(201)
		.contentType(ContentType.JSON);
		String gitreponame = resp.jsonPath().get("name");
		Reporter.log("post operation is successful :"+gitreponame,true);
		
		//patch operation on dynamic created repository
		Project pobj= new Project(name,"Hello dummy Project");
		
		given()
		.auth().oauth2("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")
		.contentType(ContentType.JSON)
		.body(pobj)
		.pathParam("owner",pfile.getPropertyData("ownername"))
		.pathParam("repo",gitreponame)
		
		.when()
		.patch("/repos/{owner}/{repo}")
		
		.then().log().all();
		Reporter.log("patch operation is successful",true);
		
		//delete operation on dynamic created repository
				
				given()
				.auth().oauth2("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")
				.pathParam("owner",pfile.getPropertyData("ownername"))
				.pathParam("repo1",gitreponame)
				
				.when()
				.patch("/repos/{owner}/{repo1}")
				
				.then().log().all();
				Reporter.log("delete operation is successful",true);
		
		
	}

}
