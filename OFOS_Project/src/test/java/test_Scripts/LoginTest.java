package test_Scripts;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.Base_Test;
import generic.UtilityMethods;
import module.CommonUtility;
import pom_scripts.HomePage;

public class LoginTest extends Base_Test {

	@Test
	public void login_TestCase() throws Throwable {
		HomePage hp = new HomePage(driver);
		CommonUtility cu = new CommonUtility();
		// to perform login
		cu.startLoginMethod();
		UtilityMethods um = new UtilityMethods();
		try {
			um.waitTillVisibility(hp.logoutLink);
			test.log(Status.PASS, "Login Sucessfull");
			test.addScreenCaptureFromPath(um.getPhoto(driver), "Login Sucessfull");

		} catch (Exception e) {
			test.log(Status.FAIL, "Login Failed");
			test.addScreenCaptureFromPath(um.getPhoto(driver), "Login Failed");
		}
			
		um.clickAction(hp.logoutLink);
		try {
			Assert.assertEquals(um.get_title().equals("Login"), true);
			test.log(Status.INFO, "User Logout Sucessfull");
			test.addScreenCaptureFromPath(um.getPhoto(driver), "User Logout Sucessfull");
		} catch (AssertionError e) {
			test.log(Status.FAIL, "User Logout not Sucessfull");
			test.addScreenCaptureFromPath(um.getPhoto(driver), "User Logout not Sucessfull");
		}
	}
}
