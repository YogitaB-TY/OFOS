package module;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import generic.Base_Test;
import generic.JavaScriptUtil;
import generic.UtilityMethods;
import pom_scripts.DishesPage;
import pom_scripts.HomePage;
import pom_scripts.LoginPage;

public class CommonUtility extends Base_Test{
	public HomePage hp;
	public UtilityMethods um;
	public LoginPage lp;
	public JavaScriptUtil js;
	public void startLoginMethod() throws Throwable
	{
		hp=new HomePage(driver);
		um= new UtilityMethods();
		test.log(Status.INFO, "Home Page Displayed");
		//test.addScreenCaptureFromPath(UtilityMethods.getPhoto(driver), "HomePage");
		lp=new LoginPage(driver);
		um.clickAction(hp.loginLink);
		test.log(Status.INFO, "Login Page Displayed");
		um.enter_value(lp.userNameTextField,um.getValueProperty("un"));
		um.enter_value(lp.passwordTextField, um.getValueProperty("pwd"));
		um.clickAction(lp.loginButton);
		test.log(Status.INFO, "Clicking on Login Button");
	}
	
	public void toLoginMethod() throws Throwable
	{
		lp=new LoginPage(driver);
		um= new UtilityMethods();
		um.enter_value(lp.userNameTextField,um.getValueProperty("un"));
		um.enter_value(lp.passwordTextField, um.getValueProperty("pwd"));
		um.clickAction(lp.loginButton);
		test.log(Status.INFO, "Clicking on Login Button");
	}
	
	public void addAllDishesToCart(DishesPage dp)
	{
		for(int j=0;j<dp.allAddToCartButtons.size();j++)
		{
			String dishName=dp.allDishesName.get(j).getText();
			um= new UtilityMethods();
			//clicking on add to cart button
			um.clickAction(dp.allAddToCartButtons.get(j));
			test.log(Status.INFO, "Clicking on Add to cart button of "+dishName);
		}
	}
	
	public void emptyTheCart(DishesPage dp)
	{
		int repeat=dp.allCartDeleteButtons.size();
		for(int k=0;k<dp.allCartDeleteButtons.size();k++)
		{
		    js=new JavaScriptUtil();
			js.jsScrollTo(0, 0);
			do {
			um.clickAction(dp.allCartDeleteButtons.get(k));
			repeat--;
			}while(repeat!=0);
		}
	}
	
	public void verifyLoginPageIsDisplayed()
	{
		try {
			Assert.assertEquals(um.get_title().equals("Login"), true);
			test.log(Status.INFO, "User Logout Sucessfull");
			test.addScreenCaptureFromPath(um.getPhoto(driver),"User Logout Sucessfull");
		} catch (AssertionError e) {
			test.log(Status.FAIL, "User Logout not Sucessfull");
			test.addScreenCaptureFromPath(um.getPhoto(driver),"User Logout not Sucessfull");
		}
	}
}
