package pomScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class CheckOutPage extends BasePage {

	public CheckOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Cash on delivery radio button
	@FindBy(xpath = "//span[text()='Cash on Delivery']")
	private WebElement cashOnDeliveryradioButton;

	//Online payment radio button
	@FindBy(xpath = "//label[@class='custom-control custom-radio  m-b-10']")
	private WebElement onlinePayElementRadioButton;


	//Order Now button
	@FindBy(xpath = "//input[@value='Order Now']")
	private WebElement orderNowButton;


	public WebElement getCashOnDeliveryradioButton() {
		return cashOnDeliveryradioButton;
	}


	public void setCashOnDeliveryradioButton(WebElement cashOnDeliveryradioButton) {
		this.cashOnDeliveryradioButton = cashOnDeliveryradioButton;
	}


	public WebElement getOnlinePayElementRadioButton() {
		return onlinePayElementRadioButton;
	}


	public void setOnlinePayElementRadioButton(WebElement onlinePayElementRadioButton) {
		this.onlinePayElementRadioButton = onlinePayElementRadioButton;
	}


	public WebElement getOrderNowButton() {
		return orderNowButton;
	}


	public void setOrderNowButton(WebElement orderNowButton) {
		this.orderNowButton = orderNowButton;
	}


}
