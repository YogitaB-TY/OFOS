package testScripts;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pomScripts.CheckOutPage;
import pomScripts.DishesPage;
import pomScripts.HomePage;
import pomScripts.MyOrdersPage;
import pomScripts.RestaurantsPage;

public class OFOS_MyOrders_007 extends OFOS_Login_002 {
	@Test()
	public synchronized void testCase_007() throws InterruptedException {

		HomePage home = new HomePage(driver);
		DishesPage dish = new DishesPage(driver);
		RestaurantsPage restaurant = new RestaurantsPage(driver);
		CheckOutPage checkout = new CheckOutPage(driver);
		MyOrdersPage myOrdersPage = new MyOrdersPage(driver);

		// Get the count of dishes available in the home page
		int itemCount = home.getOrderNowButtonOfAllDishes().size();
		// Click on the order now button of any Dish
		for (int i = 0; i < itemCount; i++) {

			// Click on the name of any dish
			test.log(LogStatus.INFO, "Clicking on " + home.getNameOfAllDishes().get(i).getText());
			clickAction(home.getNameOfAllDishes().get(i));

			// Verify the dish page is displayed
			try {
				Assert.assertEquals(driver.getTitle(), "Dishes");
				test.log(LogStatus.INFO,
						"Dishes page is displayed upon clicking on Name of the dish from home page   " + i);
			} catch (AssertionError e) {
				test.log(LogStatus.FAIL,
						"Dishes page is not displayed upon clicking on Name of the dish from home page");
			}
			driver.navigate().back();

			// Click on the Order Now button of the dish
			test.log(LogStatus.INFO,
					"Clicking on the Order No button of " + home.getNameOfAllDishes().get(i).getText());
			clickAction(home.getOrderNowButtonOfAllDishes().get(i));

			// Verify the dish page is displayed
			try {
				Assert.assertEquals(driver.getTitle(), "Dishes");
				test.log(LogStatus.INFO,
						"Dishes page is displayed upon clicking on Order Now button of the dish from home page");
			} catch (AssertionError e) {
				test.log(LogStatus.FAIL,
						"Dishes page is not displayed upon clicking on Order Now button of the dish from home page");
			}
			driver.navigate().back();

			if (i >= 0 && i < home.getAllRestaurantsName().size()) {
				// Click on the Restaurants name present in the featured restaurants list in the
				// home page
				test.log(LogStatus.INFO, "In featured restaurants list cicking on restaurant name of "
						+ home.getAllRestaurantsName().get(i).getText());
				clickAction(home.getAllRestaurantsName().get(i));

				// Verify the dish page is displayed
				try {
					Assert.assertEquals(driver.getTitle(), "Dishes");
					test.log(LogStatus.INFO,
							"Dishes page is displayed upon clicking on Restaurant's name from features restaurants list");
				} catch (AssertionError e) {
					test.log(LogStatus.FAIL,
							"Dishes page is not displayed upon clicking on Restaurant's name from features restaurants list");
				}
				driver.navigate().back();

				// Click on the Restaurants Image present in the featured restaurants list in
				// the home page
				test.log(LogStatus.INFO, "In featured restaurants list clicking on the image of "
						+ home.getAllRestaurantsImage().get(i).getText());
				clickAction(home.getAllRestaurantsImage().get(i));

				// Verify the dish page is displayed
				try {
					 Assert.assertEquals(driver.getTitle(), "Dishes");
					test.log(LogStatus.INFO,
							"Dishes page is displayed upon clicking on Restaurant's image from features restaurants list");
				} catch (AssertionError e) {
					test.log(LogStatus.FAIL,
							"Dishes page is not displayed upon clicking on Restaurant's image from features restaurants list");
				}
				driver.navigate().back();
			}

			// Click on the Restaurants Link
			test.log(LogStatus.INFO, "Clicking on \"Restaurant\" link in home");
			clickAction(home.getRestaurantsLink());

			if (i >= 0 && i < restaurant.getNameofAllRestaurants().size()) {
				// Click on View Menu Button
				test.log(LogStatus.INFO,
						"Clicking on the View menu butoon of " + restaurant.getNameofAllRestaurants().get(i).getText());
				clickAction(restaurant.getViewMenuButtons().get(i));

				// Verify the dish page is displayed
				try {
					Assert.assertEquals(driver.getTitle(), "Dishes");
					test.log(LogStatus.INFO,
							"Dishes page is displayed upon clicking on View Menu Button in restaurant page");
				} catch (AssertionError e) {
					test.log(LogStatus.FAIL,
							"Dishes page is not displayed upon clicking on View Menu Button in restaurant page");
				}
				driver.navigate().back();

				// Click on restaurant name in restaurant page
				test.log(LogStatus.INFO, "Clicked on name of " + restaurant.getNameofAllRestaurants().get(i).getText());
				clickAction(restaurant.getNameofAllRestaurants().get(i));

				// Verify the dish page is displayed
				try {
					Assert.assertEquals(driver.getTitle(), "Dishes");
					test.log(LogStatus.INFO,
							"Dishes page is displayed upon clicking on name of the restaurant in restaurant page");
				} catch (AssertionError e) {
					test.log(LogStatus.FAIL,
							"Dishes page is not displayed upon clicking on name of the restaurant in restaurant page");
				}
				driver.navigate().back();

				// Click on the image of restaurant in restaurant page
				test.log(LogStatus.INFO,
						"Clicked on the image of " + restaurant.getNameofAllRestaurants().get(i).getText());
				clickAction(restaurant.getImageOfAllRestaurants().get(i));

				if (dish.getAddToCartButtonOfAllItems().size() > 0) {
					// Verify the dish page is displayed
					try {
						Assert.assertEquals(driver.getTitle(), "Dishes");
						test.log(LogStatus.INFO,
								"Dishes page is displayed upon clicking on image of the restaurant in restaurant page");
					} catch (AssertionError e) {
						test.log(LogStatus.FAIL,
								"Dishes page is not displayed upon clicking on image of the restaurant in restaurant page");
					}
				}
			} else {
				clickAction(home.getHomeLink());
				clickAction(home.getOrderNowButtonOfAllDishes().get(i));
				for (int j = 0; j < dish.getAllItemsName().size(); j++) {

					// Enter quantity
					test.log(LogStatus.INFO, "Entering value " + j + 2 + " in "
							+ dish.getAllItemsName().get(j).getText() + " quantity text field");
					enter_value(dish.getQuantityTextfieldOfAllItems().get(j), (j + 2) + "");

					// Click on add to cart button
					test.log(LogStatus.INFO,
							"Clicked on Add To cart button of " + dish.getAllItemsName().get(j).getText());
					clickAction(dish.getAddToCartButtonOfAllItems().get(j));

				}
			}

			if (dish.getAllItemsName().size() > 0) {

				for (int j = 0; j < dish.getAllItemsName().size(); j++) {

					// Enter quantity
					test.log(LogStatus.INFO, "Entered value " + j + 2 + " in " + dish.getAllItemsName().get(j).getText()
							+ " quantity text field");
					enter_value(dish.getQuantityTextfieldOfAllItems().get(j), (j + 2) + "");

					// Click on add to cart button
					test.log(LogStatus.INFO,
							"Clicked on Add To cart button of " + dish.getAllItemsName().get(j).getText());
					clickAction(dish.getAddToCartButtonOfAllItems().get(j));

				}
			} else {
				clickAction(home.getHomeLink());
				test.log(LogStatus.INFO, "Clicked on the Order Now button of " + home.getNameOfAllDishes().get(i).getText());
				clickAction(home.getOrderNowButtonOfAllDishes().get(i));

				for (int j = 0; j < dish.getAllItemsName().size(); j++) {

					// Enter quantity
					test.log(LogStatus.INFO, "Entering value " + j + 2 + " in "
							+ dish.getAllItemsName().get(j).getText() + " quantity text field");
					enter_value(dish.getQuantityTextfieldOfAllItems().get(j), (j + 2) + "");

					// Click on add to cart button
					test.log(LogStatus.INFO,
							"Clicking on Add To cart button of " + dish.getAllItemsName().get(j).getText());
					clickAction(dish.getAddToCartButtonOfAllItems().get(j));

				}
			}
			if (dish.getDeleteButtonsOfAllYourcartItems().size() > 0) {
				// Click on checkout button
				test.log(LogStatus.INFO, "Clicked on checkout button");
				clickAction(dish.getCheckoutButton());

			}

			// Verify Checkout page is displayed
			try {
				Assert.assertEquals(checkout.getOrderNowButton().isDisplayed(), true);
				test.log(LogStatus.INFO, "Checkout page is displayed");
			} catch (AssertionError e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(getPhoto(driver)));
			}

			// Click on Cash on delivery radio button
			try {
				test.log(LogStatus.INFO, "Clicking on Cash On delivery radio button");
				clickAction(checkout.getCashOnDeliveryradioButton());

			} catch (NoSuchElementException e) {
				test.log(LogStatus.FAIL, "Can not click on Cash on delivery method");
			}

			// Click on Online payment method
			test.log(LogStatus.INFO, "clicking on Online delivery radio button");
			clickAction(checkout.getOnlinePayElementRadioButton());

			// Click on Order Now button
			try {
				test.log(LogStatus.INFO, "Clicking on Order Now button");
				clickAction(checkout.getOrderNowButton());

				driver.switchTo().alert().accept();
				driver.switchTo().alert().accept();
			} catch (NoAlertPresentException e) {
				test.log(LogStatus.INFO, "No alert found");
			}

			// Verify My Orders Page is displayed
			try {
				Assert.assertEquals(driver.getTitle(), "My Orders");
				test.log(LogStatus.INFO, "My Orders page is displayed");
			} catch (AssertionError e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(getPhoto(driver)));
			}

			try {

				for (int j = 0; j < myOrdersPage.getDeleteButtonofAllItems().size(); j++) {

					// Click on the dispatch button of All items present in the My orders list
					test.log(LogStatus.INFO,
							"Clicking on the Dispatch button of " + myOrdersPage.getNameOfAllItems().get(j).getText());
					
					clickAction(myOrdersPage.getDispatchButtons().get(j));
					test.log(LogStatus.INFO, test.addScreenCapture(getPhoto(driver)));

					try {
						Assert.assertEquals(driver.getTitle().equals("Dispatch"), true);
						test.log(LogStatus.PASS, test.addScreenCapture(getPhoto(driver)));
					} catch (AssertionError e) {
						test.log(LogStatus.FAIL,
								"Dispath page is not displayed. User is unable to dispatch the product.");
					}

				}

			} catch (NoAlertPresentException e) {
				test.log(LogStatus.FAIL, "User is unable to click on dispatch button");
			}

			try {
				js.executeScript("arguments[0].scrollIntoView(false);", myOrdersPage.getTableHeaderItem());
				
				clickAction(home.getHomeLink());
			} catch (Exception e) {
				System.out.println("Home button can not click");
			}

		}

	}

}
