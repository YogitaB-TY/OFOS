package testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Test;
import generic.ReadExcel;
import pomScripts.HomePage;
import pomScripts.LoginPage;

public class OFOS_Login_002 extends Base_Test {
	
	@DataProvider(name="LoginData")
	public Object[][] loginData() {
		try {
			return ReadExcel.getMultipleData("Login");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@Test(dataProvider = "LoginData")
	public synchronized  void test_002(Object userName, Object password) {
		HomePage home=new HomePage(driver);
		LoginPage loginPage=new LoginPage(driver);
		
		//Click on login link
		test.log(LogStatus.INFO, "Clicking on \"Login\" link");
		clickAction(home.getLoginLink());
		
		//Enter user name
		test.log(LogStatus.INFO, "Entering user name as "+userName.toString());
		enter_value(loginPage.getUsernameTF(), userName.toString());
		
		//Enter password
		test.log(LogStatus.INFO, "Entering Password as "+password.toString());
		enter_value(loginPage.getPasswordTF(), password.toString());
		
		//Click on login button
		test.log(LogStatus.INFO, "Clicking on Login button");
		clickAction(loginPage.getLoginButton());
		
		try {
			Assert.assertEquals(home.getLogOutLink().isDisplayed(), true);
			test.log(LogStatus.PASS, "Logged in Home page is diplayed, with \"Log\" out And \"My Orders\" links");
			test.log(LogStatus.PASS, test.addScreenCapture(getPhoto(driver)));
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Logged in home page is not displayed");
			test.log(LogStatus.FAIL, test.addScreenCapture(getPhoto(driver)));
		}
	}

}
