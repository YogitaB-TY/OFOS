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

public class CheckOutPage02Test extends Base_Test {
	@Test
	public void checkOutPage_TestCase_ByChangingQuantity() throws Throwable {
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

					// to change the quantity and add to your cart
					for (int j = 0; j < dp.allAddToCartButtons.size(); j++) {
						String dishName = dp.allDishesName.get(j).getText();
						dp.allQuantityTextField.get(j).clear();
						// changing the quantity of dish
						um.enter_value(dp.allQuantityTextField.get(j), "2");
						test.log(Status.INFO, "Changing the quantity of " + dishName);
						// clicking on add to cart button
						um.clickAction(dp.allAddToCartButtons.get(j));
						test.log(Status.INFO, "Clicking on Add to cart button of " + dishName);
					}
					JavaScriptUtil js = new JavaScriptUtil();
					js.jsScrollIntoView(false, dp.checkOutButton);
					test.log(Status.INFO, restaurantsName + " : Dishes added to cart");
					test.addScreenCaptureFromPath(um.getPhoto(driver), restaurantsName + " : Dishes added to cart");
					um.clickAction(dp.checkOutButton);
					// verifying checkout page is displayed or not
					try {
						Assert.assertEquals(um.get_title().equals("Checkout"), true);
						test.log(Status.PASS, restaurantsName + " : Checkout Page displayed");
						test.addScreenCaptureFromPath(um.getPhoto(driver),
								restaurantsName + " : Checkout Page displayed");
					} catch (AssertionError e) {
						test.log(Status.FAIL, restaurantsName + " : Checkout Page not displayed");
						test.addScreenCaptureFromPath(um.getPhoto(driver),
								restaurantsName + " : Checkout Page not displayed");
					}
					driver.navigate().back();

					driver.navigate().refresh();

					// deleting all the items from the cart
					cu.emptyTheCart(dp);

				} catch (AssertionError e) {
					test.log(Status.FAIL, "Dishes page of " + restaurantsName + " not displayed");
					test.addScreenCaptureFromPath(um.getPhoto(driver),
							restaurantsName + " : Dishes page not Displayed");
				}
				hp.restaurantsLink.click();
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