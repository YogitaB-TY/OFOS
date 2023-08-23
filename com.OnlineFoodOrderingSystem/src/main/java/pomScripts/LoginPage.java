package pomScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}



	//User name text field
	@FindBy(xpath = "//input[@name='username']")
	private WebElement usernameTF;

	//Password text field
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTF;

	//User name text field
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='form']//h2")
	private WebElement loginPageHeading;
	
	public WebElement getLoginPageHeading() {
		return loginPageHeading;
	}

	public void setLoginPageHeading(WebElement loginPageHeading) {
		this.loginPageHeading = loginPageHeading;
	}

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public void setUsernameTF(WebElement usernameTF) {
		this.usernameTF = usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public void setPasswordTF(WebElement passwordTF) {
		this.passwordTF = passwordTF;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}


}
