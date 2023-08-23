package test_Scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.Base_Test;
import generic.UtilityMethods;
import module.CommonUtility;
import pom_scripts.HomePage;
import pom_scripts.MyOrdersPage;

public class RemoveOrdersTest extends Base_Test {

	@Test
	public void deleteOrders_TestCase() throws Throwable {
		CommonUtility cu = new CommonUtility();
		// to perform login
		cu.startLoginMethod();
		HomePage hp = new HomePage(driver);
		UtilityMethods um = new UtilityMethods();
		um.clickAction(hp.myOrdersLink);
		MyOrdersPage mop = new MyOrdersPage(driver);

		// to delete the orders
		do {
			for (int i = 0; i < mop.allDishesDeleteButton.size(); i++) {
				mop.allDishesDeleteButton.get(i).click();
				driver.switchTo().alert().accept();
			}
		} while (mop.allDishesDeleteButton.size() != 0);

		// to verify orders are deleted or not
		try {
			Assert.assertEquals(mop.allDishesDeleteButton.size() == 0, true);
			test.log(Status.PASS, "Delete order Test Case Pass");
			test.addScreenCaptureFromPath(um.getPhoto(driver), "Delete order Test Case Pass");
		} catch (AssertionError e) {
			test.log(Status.FAIL, "Delete order Test Case Fail");
			test.addScreenCaptureFromPath(um.getPhoto(driver), "Delete order Test Case Fail");
		}
	}
}
