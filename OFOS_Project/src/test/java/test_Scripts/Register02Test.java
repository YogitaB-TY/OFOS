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
import pom_scripts.LoginPage;
import pom_scripts.RestaurantsPage;

public class Register02Test extends Base_Test {

	@Test
	public void registerPage_TestCase02() {
		UtilityMethods um = new UtilityMethods();
		CommonUtility cu = new CommonUtility();
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
					test.log(Status.INFO, "Dishes page of " + restaurantsName + " displayed");
					test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " : Dishes page");
					DishesPage dp = new DishesPage(driver);

					// adding all the dishes to cart
					cu.addAllDishesToCart(dp);

					JavaScriptUtil js = new JavaScriptUtil();
					js.jsScrollIntoView(false, dp.checkOutButton);
					test.log(Status.INFO, restaurantsName + " : Dishes added to cart");
					test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " : Dishes added to cart");
					um.clickAction(dp.checkOutButton);
					// verifying Login page is displayed or not
					try {
						Assert.assertEquals(um.get_title().equals("Login"), true);
						test.log(Status.INFO, "Login Page displayed");
						test.addScreenCaptureFromPath(um.getPhoto(driver), "Login Page displayed");
						LoginPage lp = new LoginPage(driver);
						um.clickAction(lp.createAccountLink);
						try {
							Assert.assertEquals(um.get_title().equals("Registration"), true);
							test.log(Status.PASS, "Registration Page Test Case Pass");
							test.addScreenCaptureFromPath(um.getPhoto(driver), "Registration Page Test Case Pass");

						} catch (AssertionError e) {
							test.log(Status.FAIL, "Registration Page Test Case Fail");
							test.addScreenCaptureFromPath(um.getPhoto(driver), "Registration Page Test Case Fail");

						}
						driver.navigate().back();
					} catch (AssertionError e) {
						test.log(Status.FAIL, "Login Page not displayed");
						test.addScreenCaptureFromPath(um.getPhoto(driver), "Login Page not displayed");
					}
					driver.navigate().back();
					driver.navigate().refresh();
					cu.emptyTheCart(dp);

				} catch (AssertionError e) {
					test.log(Status.FAIL, "Dishes page of " + restaurantsName + " not displayed");
					test.addScreenCaptureFromPath(um.getPhoto(driver),
							restaurantsName + " : Dishes page not Displayed");
				}
				hp.restaurantsLink.click();
			}
		} catch (AssertionError e) {
			test.log(Status.FAIL, "Restaurants Page is not displayed");
			test.addScreenCaptureFromPath(um.getPhoto(driver), "Restaurants Page is displayed");
		}
	}
}