package pomScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Username text field
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameTF;



	//First name text field
	@FindBy(xpath = "//input[@name='firstname']")
	private WebElement firstNameTF;

	//Last name text field
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameTF;

	//email text field
	@FindBy(xpath = "//input[@name='email']")
	private WebElement emailTF;

	//phone number text field
	@FindBy(xpath = "//input[@name='phone']")
	private WebElement phoneNumberTF;

	//password text field
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTF;

	//Confirm password  text field
	@FindBy(xpath = "//input[@name='cpassword']")
	private WebElement confirmPasswordTF;

	//Address text Area
	@FindBy(xpath = "//textarea[@id='exampleTextarea']")
	private WebElement addressTextArea;


	//Address text Area
	@FindBy(xpath = "//input[@name='submit']")
	private WebElement registerButton;


	public WebElement getUserNameTF() {
		return userNameTF;
	}


	public void setUserNameTF(WebElement userNameTF) {
		this.userNameTF = userNameTF;
	}


	public WebElement getFirstNameTF() {
		return firstNameTF;
	}


	public void setFirstNameTF(WebElement firstNameTF) {
		this.firstNameTF = firstNameTF;
	}


	public WebElement getLastNameTF() {
		return lastNameTF;
	}


	public void setLastNameTF(WebElement lastNameTF) {
		this.lastNameTF = lastNameTF;
	}


	public WebElement getEmailTF() {
		return emailTF;
	}


	public void setEmailTF(WebElement emailTF) {
		this.emailTF = emailTF;
	}


	public WebElement getPhoneNumberTF() {
		return phoneNumberTF;
	}


	public void setPhoneNumberTF(WebElement phoneNumberTF) {
		this.phoneNumberTF = phoneNumberTF;
	}


	public WebElement getPasswordTF() {
		return passwordTF;
	}


	public void setPasswordTF(WebElement passwordTF) {
		this.passwordTF = passwordTF;
	}


	public WebElement getConfirmPasswordTF() {
		return confirmPasswordTF;
	}


	public void setConfirmPasswordTF(WebElement confirmPasswordTF) {
		this.confirmPasswordTF = confirmPasswordTF;
	}


	public WebElement getAddressTextArea() {
		return addressTextArea;
	}


	public void setAddressTextArea(WebElement addressTextArea) {
		this.addressTextArea = addressTextArea;
	}


	public WebElement getRegisterButton() {
		return registerButton;
	}


	public void setRegisterButton(WebElement registerButton) {
		this.registerButton = registerButton;
	}


}
