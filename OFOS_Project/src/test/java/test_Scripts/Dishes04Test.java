package test_Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.Base_Test;
import generic.UtilityMethods;
import pom_scripts.HomePage;

public class Dishes04Test extends Base_Test {
	@Test
	public void dishesPage_WithOutLogin_TestCase02() {
		UtilityMethods um = new UtilityMethods();
		HomePage hp = new HomePage(driver);
		try {
			Assert.assertEquals(um.get_title().equals("Home"), true);
			test.log(Status.INFO, "Home Page is Displayed");

			// to click on restaurants name in the home page
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
		} catch (AssertionError e) {
			test.log(Status.FAIL, "Home Page is not Displayed");
		}
	}

}
