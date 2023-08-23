package pom_scripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RestaurantsPage extends BasePage{

	public RestaurantsPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//div[@class='entry-dscr']//a")
	public List<WebElement> allRestaurantsName;

	
	@FindBy(xpath="//a[text()='View Menu']")
	public List<WebElement> viewMenuButton;
	

}
