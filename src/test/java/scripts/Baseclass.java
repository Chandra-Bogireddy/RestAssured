package scripts;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.*;

import genericLib.Propertyfile;

public class Baseclass {
	public Propertyfile pfile= new Propertyfile();
	
	@BeforeMethod
	public void openApp() {
		baseURI = "https://api.github.com";
	}
	
	@AfterMethod
	public void closeApp() {
		Reporter.log("we are closing");
	}

}
