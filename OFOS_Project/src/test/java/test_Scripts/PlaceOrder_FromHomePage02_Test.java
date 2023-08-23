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

public class PlaceOrder_FromHomePage02_Test extends Base_Test {

	@Test
	public void placeOrder_FromHomePage_TestCase02() throws Throwable {
		CommonUtility cu = new CommonUtility();

		// to perform login
		cu.startLoginMethod();
		UtilityMethods um = new UtilityMethods();
		HomePage hp = new HomePage(driver);
		DishesPage dp = new DishesPage(driver);

		for (int i = 0; i < hp.allRestaurantsName.size(); i++) {
			String restaurantsName = hp.allRestaurantsName.get(i).getText();
			hp.allRestaurantsName.get(i).click();
			test.log(Status.INFO, "Clicking on " + restaurantsName + " Restaurants Name");

			// Verifying Dishes page is displayed or not
			try {
				Assert.assertEquals(um.get_title().equals("Dishes"), true);
				test.log(Status.INFO, restaurantsName + " Dishes page displayed");
				test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " Dishes page displayed");

				// add to your cart
				cu.addAllDishesToCart(dp);

				// clicking on check out button
				um.clickAction(dp.checkOutButton);
				// verifying checkout page is displayed or not
				try {
					Assert.assertEquals(um.get_title().equals("Checkout"), true);
					test.log(Status.INFO, restaurantsName + " : Checkout Page displayed");
					test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " : Checkout Page displayed");
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
					test.log(Status.INFO, "Alert not Present");
					try {
						driver.switchTo().alert().accept();
						test.addScreenCaptureFromPath(um.getPhoto(driver), "Order not placed");
					} catch (Exception e1) {
						test.log(Status.SKIP, "Alert pop-up not displayed");
					}
				}
				// verifying My order page is displayed or not
				try {
					Assert.assertEquals(um.get_title().equals("My Orders"), true);
					test.log(Status.PASS, restaurantsName + " : Order is placed");
					test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " : Order is placed");
				} catch (Exception e) {
					test.log(Status.FAIL, restaurantsName + " : Order is not placed");
					test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " : Order is not placed");
				}

			} catch (AssertionError e) {

				test.log(Status.FAIL, restaurantsName + " Dishes page not displayed");
				test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " Dishes page not displayed");
				driver.navigate().back();

			}
			um.clickAction(hp.homeLink);
		}
		um.clickAction(hp.logoutLink);
		// to verify login page is displayed
		cu.verifyLoginPageIsDisplayed();
	}
}
