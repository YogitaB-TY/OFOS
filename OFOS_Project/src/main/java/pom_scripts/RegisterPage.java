package pom_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
	
	
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='username']")
	public WebElement userNameTextField;
	
	@FindBy(xpath="//input[@name='firstname']")
	public WebElement FirstNameField;
	
	@FindBy(xpath="//input[@name='lastname']")
	public WebElement lastNameField;
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement emailTextField;
	
	@FindBy(xpath="//input[@name='phone']")
	public WebElement phoneNumberField;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement passwordField;
	
	@FindBy(xpath="//input[@name='cpassword']")
	public WebElement confirmPasswordField;
	
	@FindBy(xpath="//textarea[@name='address']")
	public WebElement addressField;
	
	@FindBy(xpath="//input[@value='Register']")
	public WebElement registerButton;
	
	
	
	

	
}
