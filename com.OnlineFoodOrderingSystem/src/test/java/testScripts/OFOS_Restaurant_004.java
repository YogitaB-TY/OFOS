package testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pomScripts.CheckOutPage;
import pomScripts.DishesPage;
import pomScripts.HomePage;import pomScripts.MyOrdersPage;
import pomScripts.RestaurantsPage;

public class OFOS_Restaurant_004 extends OFOS_Login_002 {
		@Test()
		 public synchronized void testCase_004() {

			HomePage home=new HomePage(driver);
			DishesPage dish=new DishesPage(driver);
			RestaurantsPage restaurant =new RestaurantsPage(driver);
			CheckOutPage checkout=new CheckOutPage(driver);
			
			
			//Get the count of dishes available in the home page
			int itemCount=home.getOrderNowButtonOfAllDishes().size();
			//Click on the order now button of any Dish
					for(int i=0;i<itemCount;i++) {
						
						//Click on the name of any dish
						test.log(LogStatus.INFO, "Clicking on the dish "+home.getNameOfAllDishes().get(i).getText());
						clickAction(home.getNameOfAllDishes().get(i));
						
						//Verify the dish page is displayed
						try {
							Assert.assertEquals(driver.getTitle(), "Dishes");
							test.log(LogStatus.INFO, "Dishes page is displayed upon clicking on  name of the dish");
						} catch (Exception e) {
							test.log(LogStatus.FAIL, "Dishes page is not displayed upon clicking on the name of the dish");
						}
						driver.navigate().back();
						
						//Click on the Order Now button of the dish
						test.log(LogStatus.INFO, "Clicking on order now button of "+home.getOrderNowButtonOfAllDishes().get(i).getText());
						clickAction(home.getOrderNowButtonOfAllDishes().get(i));
						
						//Verify the dish page is displayed
						try {
							Assert.assertEquals(driver.getTitle(), "Dishes");
							test.log(LogStatus.INFO, "Dishes page is displayed upon clicking on ordernow button of dish in the home page");
						} catch (Exception e) {
							test.log(LogStatus.FAIL, "Dishes page is not displayed upon clicking on ordernow button of dish in the home pagge ");
						}
						driver.navigate().back();
						
						if(i>=0 && i<home.getAllRestaurantsName().size()) {
						//Click on the Restaurants name present in the featured restaurants list in the home page
							test.log(LogStatus.INFO, "Clicking on name of "+home.getAllRestaurantsName().get(i).getText());
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
							Assert.assertEquals(driver.getTitle(), "Dishes");
							test.log(LogStatus.INFO, "Dishes page is displayed upon clicking on Restaurant's image from features restaurants list");
						} catch (Exception e) {
							test.log(LogStatus.FAIL, "Dishes page is not displayed upon clicking on Restaurant's image from features restaurants list");
						}
						driver.navigate().back();
						
						
						//Click on the Restaurants Link
						test.log(LogStatus.INFO, "Clicking on the Restaurant link in home page");
						clickAction(home.getRestaurantsLink());
						}
						else {
							driver.navigate().forward();
							//continue;
						}
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
						
						//Verify the dish page is displayed
						try {
							Assert.assertEquals(driver.getTitle(), "Dishes");
							test.log(LogStatus.INFO, "Dishes page is displayed upon clicking on image of the restaurant in restaurant page");
						} catch (Exception e) {
							test.log(LogStatus.FAIL, "Dishes page is not displayed upon clicking on image of the restaurant in restaurant page");
						}
						
						}
						else {
							driver.navigate().forward();
							//continue;
						}
						
						
						for(int j=0;j<dish.getAllItemsName().size();j++) {
							if(dish.getAllItems().size()>0) {
							//Enter quantity
							test.log(LogStatus.INFO, "Entering quantity as "+(j+2)+" in "+dish.getAllItemsName().get(j).getText()+" Quantity text field.");
							enter_value(dish.getQuantityTextfieldOfAllItems().get(j), (j+2)+"");
							
							//Click on add to cart button
							test.log(LogStatus.INFO, "Clicking on the Add To cart button of "+dish.getAllItemsName().get(j).getText());
							clickAction(dish.getAddToCartButtonOfAllItems().get(j));	
											
						}else {
							test.log(LogStatus.FAIL, "No items are displayed in "+dish.getAllItemsName().get(j).getText()+" restaurant.");
					
						}
						}
						
						for(int j=dish.getDeleteButtonsOfAllYourcartItems().size()-1;j>=0;j--) {

							//Click on delete button of your cart item
							js.executeScript("arguments[0].scrollIntoView(false);",dish.getDeleteButtonsOfAllYourcartItems().get(j));
							
							test.log(LogStatus.INFO, "Clicked on delete button of item "+dish.getAllItemsNameInYourCartItems().get(j).getText());
							clickAction(dish.getDeleteButtonsOfAllYourcartItems().get(j));
							test.log(LogStatus.PASS, test.addScreenCapture(getPhoto(driver)));
							}
						
						js.executeScript("arguments[0].scrollIntoView(false);", dish.getMenuHeading());
						try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						clickAction(home.getHomeLink());
					
					}
					
					
					
		}
}
