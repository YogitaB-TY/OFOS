package pom_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='username']")
	public WebElement userNameTextField;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement passwordTextField;
	
	@FindBy(xpath="//input[@value='Login']")
	public WebElement loginButton;
	
	@FindBy(xpath="//a[text()=' Create an account']")
	public WebElement createAccountLink;
	
	
}
