package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pomScripts.CheckOutPage;
import pomScripts.DishesPage;
import pomScripts.HomePage;
import pomScripts.MyOrdersPage;
import pomScripts.RestaurantsPage;

public class OFOS_Restaurant_005 extends OFOS_Login_002{


	@Test()
	public synchronized  void testCase_005() {

		HomePage home=new HomePage(driver);
		DishesPage dish=new DishesPage(driver);
		RestaurantsPage restaurant =new RestaurantsPage(driver);
		CheckOutPage checkout=new CheckOutPage(driver);


		//Get the count of dishes available in the home page
		int itemCount=home.getOrderNowButtonOfAllDishes().size();
		//Click on the order now button of any Dish
		for(int i=0;i<itemCount;i++) {

			//Click on the name of any dish
			test.log(LogStatus.INFO, "Clicking on the name of "+home.getNameOfAllDishes().get(i).getText());
			clickAction(home.getNameOfAllDishes().get(i));

			//Verify the dish page is displayed
			try {
				Assert.assertEquals(driver.getTitle(), "Dishes");
				test.log(LogStatus.INFO, "Dishes page is displayed upon clicking on Name of the dish from home page   "+i);
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Dishes page is not displayed upon clicking on Name of the dish from home page");
			}
			driver.navigate().back();

			//Click on the Order Now button of the dish
			test.log(LogStatus.INFO, "Clicking on the Order Now button of "+home.getNameOfAllDishes().get(i).getText());
			clickAction(home.getOrderNowButtonOfAllDishes().get(i));

			//Verify the dish page is displayed
			try {
				Assert.assertEquals(driver.getTitle(), "Dishes");
				test.log(LogStatus.INFO, "Dishes page is displayed upon clicking on Order Now button of the dish from home page");
			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Dishes page is not displayed upon clicking on Order Now button of the dish from home page");
			}
			driver.navigate().back();

			if(i>=0 && i<home.getAllRestaurantsName().size()) {
				//Click on the Restaurants name present in the featured restaurants list in the home page
				test.log(LogStatus.INFO, "In featured restaurants list clicking on the name of "+home.getAllRestaurantsName().get(i).getText());
				clickAction(home.getAllRestaurantsName().get(i));

				//Verify the dish page is displayed
				try {
					Assert.assertEquals(driver.getTitle(), "Dishes");
					test.log(LogStatus.INFO, "Dishes page is displayed upon clicking on Restaurant's name from features restaurants list");
				} catch (Exception e) {
					test.log(LogStatus.FAIL, "Dishes page is not displayed upon clicking on Restaurant's name from features restaurants list");
				}
				driver.navigate().back();

				//Click on the Restaurants Image present in the featured restaurants list in the home page
				test.log(LogStatus.INFO, "Clicking on the image of "+home.getAllRestaurantsName().get(i).getText());
				clickAction(home.getAllRestaurantsImage().get(i));

				//Verify the dish page is displayed
				try {
					//Assert.assertEquals(driver.getTitle(), "Dishes");
					test.log(LogStatus.INFO, "Dishes page is displayed upon clicking on Restaurant's image from features restaurants list");
				} catch (Exception e) {
					test.log(LogStatus.FAIL, "Dishes page is not displayed upon clicking on Restaurant's image from features restaurants list");
				}
				driver.navigate().back();
			}

			//Click on the Restaurants Link
			test.log(LogStatus.INFO, "Clicking on the restaurant link in the home page");
			clickAction(home.getRestaurantsLink());

			if(i>=0 && i<restaurant.getNameofAllRestaurants().size()) {
				//Click on View Menu Button
				test.log(LogStatus.INFO, "Clicking on the View Menu button of "+restaurant.getNameofAllRestaurants().get(i).getText());
				clickAction(restaurant.getViewMenuButtons().get(i));

				//Verify the dish page is displayed
				try {
					Assert.assertEquals(driver.getTitle(), "Dishes");
					test.log(LogStatus.INFO, "Dishes page is displayed upon clicking on View Menu Button in restaurant page");
				} catch (Exception e) {
					test.log(LogStatus.FAIL, "Dishes page is not displayed upon clicking on View Menu Button in restaurant page");
				}
				driver.navigate().back();

				//Click on restaurant name in restaurant page
				test.log(LogStatus.INFO, "Clicking on the name of "+restaurant.getNameofAllRestaurants().get(i).getText());
				clickAction(restaurant.getNameofAllRestaurants().get(i));

				//Verify the dish page is displayed
				try {
					Assert.assertEquals(driver.getTitle(), "Dishes");
					test.log(LogStatus.INFO, "Dishes page is displayed upon clicking on name of the restaurant in restaurant page");
				} catch (Exception e) {
					test.log(LogStatus.FAIL, "Dishes page is not displayed upon clicking on name of the restaurant in restaurant page");
				}
				driver.navigate().back();


				//Click on the image of restaurant in restaurant page
				test.log(LogStatus.INFO, "Clicking on the image of "+restaurant.getNameofAllRestaurants().get(i).getText());
				clickAction(restaurant.getImageOfAllRestaurants().get(i));
				
				if(dish.getAddToCartButtonOfAllItems().size()>0) {
				//Verify the dish page is displayed
				try {
					Assert.assertEquals(driver.getTitle(), "Dishes");
					test.log(LogStatus.INFO, "Dishes page is displayed upon clicking on image of the restaurant in restaurant page");
				} catch (Exception e) {
					test.log(LogStatus.FAIL, "Dishes page is not displayed upon clicking on image of the restaurant in restaurant page");
				}
				}
				}
			else {
				clickAction(home.getHomeLink());
				clickAction(home.getOrderNowButtonOfAllDishes().get(i));
				for(int j=0;j<dish.getAllItemsName().size();j++) {

					//Enter quantity
					enter_value(dish.getQuantityTextfieldOfAllItems().get(j), (j+2)+"");

					//Click on add to cart button
					clickAction(dish.getAddToCartButtonOfAllItems().get(j));	
				}
			}

			if(dish.getAllItemsName().size()>0) {
			
          	for(int j=0;j<dish.getAllItemsName().size();j++) {

				//Enter quantity
          		test.log(LogStatus.INFO, "Entering quantity as "+(j+2)+" in "+dish.getAllItemsName().get(j).getText()+" Quantity text field.");
				enter_value(dish.getQuantityTextfieldOfAllItems().get(j), (j+2)+"");

				//Click on add to cart button
				test.log(LogStatus.INFO, "Clicking on the Add To cart button of "+dish.getAllItemsName().get(j).getText());
				clickAction(dish.getAddToCartButtonOfAllItems().get(j));	
			}
			}
			else {
				clickAction(home.getHomeLink());
				clickAction(home.getOrderNowButtonOfAllDishes().get(i));
				for(int j=0;j<dish.getAllItemsName().size();j++) {

					//Enter quantity
					
					enter_value(dish.getQuantityTextfieldOfAllItems().get(j), (j+2)+"");
					test.log(LogStatus.INFO, "Entering quantity as "+(j+2)+" in "+dish.getAllItemsName().get(j).getText()+" Quantity text field.");
					//Click on add to cart button
					test.log(LogStatus.INFO, "Clicking on the Add To cart button of "+dish.getAllItemsName().get(j).getText());
					clickAction(dish.getAddToCartButtonOfAllItems().get(j));	
				}
			}
			if(dish.getDeleteButtonsOfAllYourcartItems().size()>0) {
				//Click on checkout button
				test.log(LogStatus.INFO, "Clicking on the Checkout button");
				clickAction(dish.getCheckoutButton());	
			}
				

			//Verify Checkout page is displayed
			try {
				Assert.assertEquals(checkout.getOrderNowButton().isDisplayed(), true);
				test.log(LogStatus.INFO, "Checkout page is displayed");
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(getPhoto(driver)));
			}

//			//Click on Cash on delivery radio button
			test.log(LogStatus.INFO, "Clicking on cash on delivery button");
			clickAction(checkout.getCashOnDeliveryradioButton());
			//driver.switchTo().alert().accept();
			//driver.navigate().back();

			//Click on Online payment method
			test.log(LogStatus.INFO, "clicking on Online delivery radio button");
			clickAction(checkout.getOnlinePayElementRadioButton());

			//Click on Order Now button
			test.log(LogStatus.INFO, "Clicking on Order now button");
			clickAction(checkout.getOrderNowButton());
			driver.switchTo().alert().accept();
			driver.switchTo().alert().accept();
		
			//Verify My Orders Page is displayed
			try {
				Assert.assertEquals(driver.getTitle(), "My Orders");
				test.log(LogStatus.PASS, test.addScreenCapture(getPhoto(driver)));
			} catch (Exception e) {
				test.log(LogStatus.FAIL, test.addScreenCapture(getPhoto(driver)));
			}
			
			clickAction(home.getHomeLink());
		}


	}

}
