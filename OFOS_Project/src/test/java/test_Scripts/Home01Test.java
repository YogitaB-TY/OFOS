package test_Scripts;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.Base_Test;
import generic.UtilityMethods;
import module.CommonUtility;
import pom_scripts.HomePage;
import pom_scripts.LoginPage;

public class Home01Test extends Base_Test {
	@Test
	public void HomePage_TestCase_01() throws Throwable {
		HomePage hp = new HomePage(driver);
		CommonUtility cu = new CommonUtility();
		UtilityMethods um = new UtilityMethods();
		// to click on order now button in home page
		for (int i = 0; i < hp.allOrderNowButtons.size(); i++) {
			String dishName = hp.allDishesName.get(i).getText();
			um.clickAction(hp.allOrderNowButtons.get(i));
			// to verify dishes page is displayed or not
			try {
				Assert.assertEquals(um.get_title().equals("Dishes"), true);
				test.log(Status.INFO, dishName + " : Dishes page is displayed");
				test.addScreenCaptureFromPath(um.getPhoto(driver), dishName + " : Dishes page is displayed");
				// to perform login
				um.clickAction(hp.loginLink);
				cu.toLoginMethod();

				wait.until(ExpectedConditions.titleContains("Home"));
				// to verify home page is displayed or not
				try {
					Assert.assertEquals(um.get_title().equals("Home"), true);
					test.log(Status.PASS, "Home page is displayed");
					test.addScreenCaptureFromPath(um.getPhoto(driver), "Home page is displayed");
					um.clickAction(hp.logoutLink);
				} catch (AssertionError e) {
					test.log(Status.FAIL, "Home page not displayed");
					test.addScreenCaptureFromPath(um.getPhoto(driver), "Home page not displayed");
				}

			} catch (AssertionError e) {
				test.log(Status.FAIL, dishName + " : Dishes page not displayed");
				test.addScreenCaptureFromPath(um.getPhoto(driver), dishName + " : Dishes page not displayed");
			}
			um.clickAction(hp.homeLink);
		}
	}
}