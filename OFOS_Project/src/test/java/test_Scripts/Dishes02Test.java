package test_Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.Base_Test;
import generic.UtilityMethods;
import module.CommonUtility;
import pom_scripts.HomePage;

public class Dishes02Test extends Base_Test {
	@Test
	public void dishesPage_TestCase02() throws Throwable {
		CommonUtility cu = new CommonUtility();

		// to perform login
		cu.startLoginMethod();
		UtilityMethods um = new UtilityMethods();
		HomePage hp = new HomePage(driver);

		for (int i = 0; i < hp.allRestaurantsName.size(); i++) {
			String restaurantsName = hp.allRestaurantsName.get(i).getText();
			hp.allRestaurantsName.get(i).click();
			test.log(Status.INFO, "Clicking on " + restaurantsName + " Restaurants Name");

			// Verifying Dishes page is displayed or not
			try {
				Assert.assertEquals(um.get_title().equals("Dishes"), true);
				test.log(Status.PASS, restaurantsName + " Dishes page displayed");
				test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " Dishes page displayed");
				driver.navigate().back();

			} catch (AssertionError e) {

				test.log(Status.FAIL, restaurantsName + " Dishes page not displayed");
				test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " Dishes page not displayed");
				driver.navigate().back();
			}
		}
		// to perform logout
		um.clickAction(hp.logoutLink);

		// to verify login page is displayed
		cu.verifyLoginPageIsDisplayed();
	}
}