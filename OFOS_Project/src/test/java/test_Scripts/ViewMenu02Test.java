package test_Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.Base_Test;
import generic.UtilityMethods;
import pom_scripts.HomePage;
import pom_scripts.RestaurantsPage;

public class ViewMenu02Test extends Base_Test {
	@Test
	public void viewMenu_WithOutLogin_TestCase() {
		UtilityMethods um = new UtilityMethods();
		HomePage hp = new HomePage(driver);
		// clicking on Restaurants link in the home page
		hp.restaurantsLink.click();
		// verifying Restaurants page is displayed or not
		try {
			Assert.assertEquals(um.get_title().equals("Restaurants"), true);
			test.log(Status.INFO, "Restaurants Page is displayed");
			test.addScreenCaptureFromPath(um.getPhoto(driver), "Restaurants Page is displayed");

			RestaurantsPage rp = new RestaurantsPage(driver);
			// clicking on view menu buttons of each restaurants
			for (int i = 0; i < rp.viewMenuButton.size(); i++) {
				String restaurantsName = rp.allRestaurantsName.get(i).getText();
				rp.viewMenuButton.get(i).click();
				test.log(Status.INFO, "Clicking on View Menu button of " + restaurantsName);
				// verifying dishes page is displayed or not
				try {
					Assert.assertEquals(um.get_title().equals("Dishes"), true);
					test.log(Status.PASS, "Dishes page of " + restaurantsName + " displayed");
					test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " : Dishes page");
				} catch (AssertionError e) {
					test.log(Status.FAIL, "Dishes page of " + restaurantsName + " not displayed");
					test.addScreenCaptureFromPath(um.getPhoto(driver),
							restaurantsName + " : Dishes page not Displayed");
				}
				driver.navigate().back();
			}
		} catch (AssertionError e) {
			test.log(Status.FAIL, "Restaurants Page is not displayed");
			test.addScreenCaptureFromPath(um.getPhoto(driver), "Restaurants Page is displayed");
		}
	}
}