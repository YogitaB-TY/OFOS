package pom_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//table[@class='table']//tr[3]/td[2]/strong")
	public WebElement totalCheckoutPrice;
	
	@FindBy(xpath="//input[@value='Order Now']")
	public WebElement orderNowButton;
	

}
