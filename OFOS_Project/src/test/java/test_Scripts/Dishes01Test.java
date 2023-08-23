package test_Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import generic.Base_Test;
import generic.UtilityMethods;
import module.CommonUtility;
import pom_scripts.HomePage;

public class Dishes01Test extends Base_Test {
	@Test
	public void dishesPage_TestCase01() throws Throwable {
		HomePage hp = new HomePage(driver);
		CommonUtility cu = new CommonUtility();

		// to perform login
		cu.startLoginMethod();
		UtilityMethods um = new UtilityMethods();

		// to click on orderNow button of the popular dishes of month
		for (int i = 0; i < hp.allOrderNowButtons.size(); i++) {
			String dishName = hp.allDishesName.get(i).getText();
			test.log(Status.INFO, "Clicking on OrderNow Button of " + dishName);
			hp.allOrderNowButtons.get(i).click();
			// verifying dishes page is displayed or not
			try {
				Assert.assertEquals(um.get_title().equals("Dishes"), true);
				test.log(Status.PASS, "Dishes page of " + dishName + " displayed");
				test.addScreenCaptureFromPath(um.getPhoto(driver), dishName + " : Dishes page");
			} catch (AssertionError e) {
				test.log(Status.FAIL, "Dishes page of " + dishName + " not displayed");
				test.addScreenCaptureFromPath(um.getPhoto(driver), dishName + " : Dishes page not Displayed");
			}
			driver.navigate().back();
		}
		um.clickAction(hp.logoutLink);

		// to verify login page is displayed
		cu.verifyLoginPageIsDisplayed();
	}
}