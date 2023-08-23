package test_Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.Base_Test;
import generic.UtilityMethods;
import module.CommonUtility;
import pom_scripts.CheckoutPage;
import pom_scripts.DishesPage;
import pom_scripts.HomePage;
import pom_scripts.RestaurantsPage;

public class PlaceOrderTest extends Base_Test {
	@Test
	public void placeOrder_TestCase() throws Throwable {
		CommonUtility cu = new CommonUtility();
		// to perform login
		cu.startLoginMethod();
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
					test.log(Status.INFO, "Dishes page of " + restaurantsName + " displayed");
					test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " : Dishes page");
					DishesPage dp = new DishesPage(driver);
					
					// add to your cart
					cu.addAllDishesToCart(dp);

					// clicking on check out button
					um.clickAction(dp.checkOutButton);
					// verifying checkout page is displayed or not
					try {
						Assert.assertEquals(um.get_title().equals("Checkout"), true);
						test.log(Status.INFO, restaurantsName + " : Checkout Page displayed");
						test.addScreenCaptureFromPath(um.getPhoto(driver),
								restaurantsName + " : Checkout Page displayed");
					} catch (AssertionError e) {
						test.log(Status.FAIL, restaurantsName + " : Checkout Page not displayed");
						test.addScreenCaptureFromPath(um.getPhoto(driver),
								restaurantsName + " : Checkout Page not displayed");
					}
					CheckoutPage cp = new CheckoutPage(driver);
					um.clickAction(cp.orderNowButton);

					driver.switchTo().alert().accept();

					try {
						String message = driver.switchTo().alert().getText();
						driver.switchTo().alert().accept();
						test.log(Status.PASS, message);
						test.addScreenCaptureFromPath(um.getPhoto(driver), message);
					} catch (Exception e) {
						test.log(Status.INFO, "Order not placed");
						try {
							driver.switchTo().alert().accept();
							test.addScreenCaptureFromPath(um.getPhoto(driver), "Order not placed");
						} catch (Exception e1) {
							test.log(Status.SKIP, "Alert pop-up not displayed");
						}
					}

					try {
						Assert.assertEquals(um.get_title().equals("My Orders"), true);
						test.log(Status.PASS, restaurantsName + " : Order is placed");
						test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " : Order is placed");
					} catch (Exception e) {
						test.log(Status.FAIL, restaurantsName + " : Order is not placed");
						test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " : Order is not placed");
					}
					um.clickAction(hp.restaurantsLink);
				} catch (AssertionError e) {
					test.log(Status.FAIL, "Dishes page of " + restaurantsName + " not displayed");
					test.addScreenCaptureFromPath(um.getPhoto(driver),
							restaurantsName + " : Dishes page not Displayed");
				}
			}
			um.clickAction(hp.logoutLink);
			// to verify login page is displayed
			cu.verifyLoginPageIsDisplayed();
		} catch (AssertionError e) {
			test.log(Status.FAIL, "Restaurants Page is not displayed");
			test.addScreenCaptureFromPath(um.getPhoto(driver), "Restaurants Page is displayed");
		}
	}
}
