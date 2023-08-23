package test_Scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.Base_Test;
import generic.UtilityMethods;
import module.CommonUtility;
import pom_scripts.HomePage;
import pom_scripts.LoginPage;

public class Home02Test extends Base_Test {
	@Test
	public void HomePage_TestCase_02() throws Throwable {
		HomePage hp = new HomePage(driver);
		UtilityMethods um = new UtilityMethods();
		CommonUtility cu = new CommonUtility();

		for (int i = 0; i < hp.allRestaurantsName.size(); i++) {
			String restaurantsName = hp.allRestaurantsName.get(i).getText();
			um.clickAction(hp.allRestaurantsName.get(i));
			// to verify Dishes page is displayed or not
			try {
				Assert.assertEquals(um.get_title().equals("Dishes"), true);
				test.log(Status.INFO, restaurantsName + " : Dishes page is displayed");
				test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " : Dishes page is displayed");
				um.clickAction(hp.loginLink);
				// to verify login page is displayed or not
				try {
					Assert.assertEquals(um.get_title().equals("Login"), true);
					test.log(Status.INFO, "Login page is displayed");
					test.addScreenCaptureFromPath(um.getPhoto(driver), "Login page is displayed");
					// to perform login
					cu.toLoginMethod();
					wait.until(ExpectedConditions.titleContains("Home"));
					// to verify home page is displayed or not
					try {
						Assert.assertEquals(um.get_title().equals("Home"), true);
						test.log(Status.PASS, "Home page is displayed");
						test.addScreenCaptureFromPath(um.getPhoto(driver), "Home page is displayed");
						um.clickAction(hp.logoutLink);
					} catch (AssertionError e) {
						test.log(Status.FAIL, "Home page not displayed");
						test.addScreenCaptureFromPath(um.getPhoto(driver), "Home page not displayed");
					}
				} catch (AssertionError e) {
					test.log(Status.FAIL, "Login page not displayed");
					test.addScreenCaptureFromPath(um.getPhoto(driver), "Login page not displayed");
				}
			} catch (AssertionError e) {
				test.log(Status.FAIL, restaurantsName + " : Dishes page not displayed");
				test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " : Dishes page not displayed");
			}
			um.clickAction(hp.homeLink);
		}
	}
}
