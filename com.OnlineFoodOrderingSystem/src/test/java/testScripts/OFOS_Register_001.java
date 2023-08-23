package testScripts;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import generic.Base_Test;
import generic.ReadExcel;
import pomScripts.HomePage;
import pomScripts.LoginPage;
import pomScripts.RegisterPage;

public class OFOS_Register_001 extends Base_Test {

	@DataProvider(name = "RegisterData")
	public Object[][] registerData() throws IOException {

		try {
			return ReadExcel.getMultipleData("Register");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

	@Test(dataProvider = "RegisterData")
	public synchronized void test_001(Object userName, Object firstName, Object lastName, Object email,
			Object phoneNumber, Object password, Object cpwd, Object address) {
		HomePage home = new HomePage(driver);
		RegisterPage register = new RegisterPage(driver);
		LoginPage login = new LoginPage(driver);

		// Click on register link
		test.log(LogStatus.INFO, "clicking on \"Register\" link");
		clickAction(home.getRegisterLink());

		// Enter user name
		test.log(LogStatus.INFO, "Entering User name as "+userName.toString());
		enter_value(register.getUserNameTF(), userName.toString());

		// Enter First name
		test.log(LogStatus.INFO, "Entering first name as "+firstName.toString());
		enter_value(register.getFirstNameTF(), firstName.toString());

		// Enter Last name
		test.log(LogStatus.INFO, "Entering last name as "+lastName.toString());
		enter_value(register.getLastNameTF(), lastName.toString());

		// Enter email address
		test.log(LogStatus.INFO, "Entering email  as "+email.toString());
		enter_value(register.getEmailTF(), email.toString());

		// Enter phone number
		test.log(LogStatus.INFO, "Entering Phone number as "+phoneNumber.toString());
		enter_value(register.getPhoneNumberTF(), phoneNumber.toString());

		// Enter password
		test.log(LogStatus.INFO, "Entering password as "+password.toString());
		enter_value(register.getPasswordTF(), password.toString());

		// Enter confirm password
		test.log(LogStatus.INFO, "Entering confirm password as "+cpwd.toString());
		enter_value(register.getConfirmPasswordTF(), cpwd.toString());

		// Click on Register button
		test.log(LogStatus.INFO, "clicking on \"Register\" button ");
		clickAction(register.getRegisterButton());
		
		try {
			try {
				
				test.log(LogStatus.PASS, driver.switchTo().alert().getText());
				
			} catch (Exception e) {

				try {
					if (login.getLoginPageHeading().isDisplayed()) {
						test.log(LogStatus.PASS, "Login page is displayed");
						test.log(LogStatus.PASS, test.addScreenCapture(getPhoto(driver)));
						
					}
				} catch (Exception e1) {
					test.log(LogStatus.FAIL, "Log in page is not displayed");
					test.log(LogStatus.FAIL, test.addScreenCapture(getPhoto(driver)));

				}
			}

		} catch (Exception e) {

			test.log(LogStatus.FAIL, "Log in page is not displayed");
			test.log(LogStatus.FAIL, test.addScreenCapture(getPhoto(driver)));

		}

	}
}
