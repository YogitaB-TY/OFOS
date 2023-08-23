package test_Scripts;

import java.io.IOException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import generic.Base_Test;
import generic.ReadExcel;
import generic.UtilityMethods;
import pom_scripts.HomePage;
import pom_scripts.RegisterPage;

public class Register01Test extends Base_Test {
	@Test(dataProvider = "dataExcel")
	public void register_TestCase01(String userName, String FirstName, String lastName, String email,
			String phoneNumber, String password, String confirmPassword, String address) throws InterruptedException {
		HomePage hp = new HomePage(driver);
		UtilityMethods um = new UtilityMethods();
		um.clickAction(hp.registerLink);
		RegisterPage rp = new RegisterPage(driver);
		um.enter_value(rp.userNameTextField, userName);
		um.enter_value(rp.FirstNameField, FirstName);
		um.enter_value(rp.lastNameField, lastName);
		um.enter_value(rp.emailTextField, email);
		um.enter_value(rp.phoneNumberField, phoneNumber);
		um.enter_value(rp.passwordField, password);
		um.enter_value(rp.confirmPasswordField, confirmPassword);
		um.enter_value(rp.addressField, address);
		um.clickAction(rp.registerButton);

		try {
			wait.until(ExpectedConditions.alertIsPresent());
			test.log(Status.PASS, driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			test.log(Status.PASS, "Registration Failed");
			test.addScreenCaptureFromPath(um.getPhoto(driver), "Registration Failed");
		} catch (Exception e) {
			try {
				Assert.assertEquals(um.get_title().contains("Login"), true);
				test.log(Status.FAIL, "Registration Sucessfull");
				test.addScreenCaptureFromPath(um.getPhoto(driver), "Registration Sucessfull");
			} catch (AssertionError e1) {
				test.log(Status.PASS, "Registration Failed");
				test.addScreenCaptureFromPath(um.getPhoto(driver), "Registration Failed");
			}
		}
	}

	@DataProvider(name = "dataExcel")
	public Object[][] dataExcel() throws IOException {
		return ReadExcel.getMultipleData(SHEET_NAME);
	}
}
