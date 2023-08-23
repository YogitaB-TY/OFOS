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

public class PlaceOrder_FromHomePage01_Test extends Base_Test {

	@Test
	public void placeOrder_FromHomePage_TestCase01() throws Throwable {
		CommonUtility cu = new CommonUtility();
		cu.startLoginMethod();
		UtilityMethods um = new UtilityMethods();
		HomePage hp = new HomePage(driver);
		DishesPage dp = new DishesPage(driver);

		// to click on orderNow button of the popular dishes of month
		for (int i = 0; i < hp.allOrderNowButtons.size(); i++) {
			String dishName = hp.allDishesName.get(i).getText();
			test.log(Status.INFO, "Clicking on OrderNow Button of " + dishName);
			hp.allOrderNowButtons.get(i).click();
			// verifying dishes page is displayed or not
			try {
				Assert.assertEquals(um.get_title().equals("Dishes"), true);
				test.log(Status.INFO, "Dishes page of " + dishName + " displayed");
				test.addScreenCaptureFromPath(um.getPhoto(driver), dishName + " : Dishes page");
				String restaurantsName = dp.restaurantsName.getText();
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
					test.log(Status.INFO, "Alert pop-up not displayed");
					try {
						driver.switchTo().alert().accept();
						test.addScreenCaptureFromPath(um.getPhoto(driver), "Alert pop-up not displayed");
					} catch (Exception e1) {
						test.log(Status.INFO, "Alert pop-up not displayed");
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
				test.log(Status.FAIL, "Dishes page of " + dishName + " not displayed");
				test.addScreenCaptureFromPath(um.getPhoto(driver), dishName + " : Dishes page not Displayed");
			}
			um.clickAction(hp.homeLink);
		}
		um.clickAction(hp.logoutLink);

		// to verify login page is displayed
		cu.verifyLoginPageIsDisplayed();
	}
}
