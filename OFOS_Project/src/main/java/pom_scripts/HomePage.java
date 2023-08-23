package pom_scripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//a[text()='Register']")
	public WebElement registerLink;
	
	@FindBy(xpath="//a[text()='Login']")
	public WebElement loginLink;
	
	@FindBy(xpath="//a[text()='Home ']")
	public WebElement homeLink;

	@FindBy(xpath="//a[text()='Restaurants ']")
	public WebElement restaurantsLink;
	
	@FindBy(xpath="//a[text()='My Orders']")
	public WebElement myOrdersLink;
	
	@FindBy(xpath="//a[text()='Logout']")
	public WebElement logoutLink;
	
	@FindBy(xpath="//a[text()='Order Now']")
	public List<WebElement> allOrderNowButtons;
	
	@FindBy(xpath="//div[@class='content']/h5/a")
	public List<WebElement> allDishesName;
	
	@FindBy(xpath="//div[@class='restaurant-listing']//div[@class='restaurant-wrap']/div/div[2]//a")
	public List<WebElement> allRestaurantsName;
	
}
