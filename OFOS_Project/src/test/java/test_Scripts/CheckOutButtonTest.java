package test_Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.Base_Test;
import generic.JavaScriptUtil;
import generic.UtilityMethods;
import module.CommonUtility;
import pom_scripts.DishesPage;
import pom_scripts.HomePage;
import pom_scripts.RestaurantsPage;

public class CheckOutButtonTest extends Base_Test {
	@Test
	public void CheckOutButton_TestCase() throws Throwable {

		CommonUtility cu = new CommonUtility();
		// to perform login
		cu.startLoginMethod();
		UtilityMethods um = new UtilityMethods();
		HomePage hp = new HomePage(driver);
		um.clickAction(hp.restaurantsLink);
		JavaScriptUtil js = new JavaScriptUtil();
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
					test.log(Status.INFO, "Dishes page of " + restaurantsName + " displayed");
					test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " : Dishes page");
					DishesPage dp = new DishesPage(driver);

					// adding all the dishes to cart
					cu.addAllDishesToCart(dp);

					js.jsScrollIntoView(false, dp.checkOutButton);
					// verifying that checkout button is enabled or not
					try {
						Assert.assertEquals(dp.checkOutButton.isEnabled(), true);
						test.log(Status.INFO, restaurantsName + " : CheckOut Button is Enabled");
						test.addScreenCaptureFromPath(um.getPhoto(driver),
								restaurantsName + " : CheckOut Button is Enabled");

						// deleting all the items from the cart
						cu.emptyTheCart(dp);

						// verifying checkout button is enabled or not
						try {
							um.clickAction(dp.checkOutButton);
							test.log(Status.FAIL, restaurantsName + " : ChechOut Button Test Case Fail");
							test.addScreenCaptureFromPath(um.getPhoto(driver),
									restaurantsName + " : ChechOut Button Test Case Fail");
						} catch (Exception e) {
							test.log(Status.PASS, restaurantsName + " : ChechOut Button Test Case Pass");
							test.addScreenCaptureFromPath(um.getPhoto(driver),
									restaurantsName + " : ChechOut Button Test Case Pass");
						}
					} catch (AssertionError e) {
						test.log(Status.FAIL, restaurantsName + " : CheckOut Button is Disabled");
						test.addScreenCaptureFromPath(um.getPhoto(driver),
								restaurantsName + " : CheckOut Button is Disabled");
					}
				} catch (AssertionError e) {
					test.log(Status.FAIL, "Dishes page of " + restaurantsName + " not displayed");
					test.addScreenCaptureFromPath(um.getPhoto(driver),
							restaurantsName + " : Dishes page not Displayed");
				}
				js.jsScrollIntoView(false, hp.restaurantsLink);
				js.jsClick(hp.restaurantsLink);
			}
			// to logout the user
			um.clickAction(hp.logoutLink);
			// to verify login page is displayed
			cu.verifyLoginPageIsDisplayed();
		} catch (AssertionError e) {
			test.log(Status.FAIL, "Restaurants Page is not displayed");
			test.addScreenCaptureFromPath(um.getPhoto(driver), "Restaurants Page is displayed");
		}
	}
}
