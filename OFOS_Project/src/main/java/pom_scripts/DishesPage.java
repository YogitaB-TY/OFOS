package pom_scripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DishesPage extends BasePage{

	public DishesPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='food-item']//h6/a")
	public List<WebElement> allDishesName;
	
	@FindBy(xpath="//input[@value='Add To Cart']")
	public List<WebElement> allAddToCartButtons;
	
	@FindBy(xpath="//input[@name='quantity']")
	public List<WebElement> allQuantityTextField;

	@FindBy(xpath="//i[@class='fa fa-trash pull-right']")
	public List<WebElement> allCartDeleteButtons;
	
	@FindBy(xpath="//a[text()='Checkout']")
	public WebElement checkOutButton;
	
	@FindBy(xpath="//h3[@class='value']/strong")
	public WebElement totalCartPrice;
	
	@FindBy(xpath="//div[@class='pull-left right-text white-txt']/h6/a")
	public WebElement restaurantsName;
	



}
