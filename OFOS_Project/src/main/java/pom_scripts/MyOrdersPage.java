package pom_scripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyOrdersPage extends BasePage {
	
	public MyOrdersPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover']//td[@data-column='Item']")
	public List<WebElement> allDishesName;

	@FindBy(xpath="//table[@class='table table-bordered table-hover']//td[@data-column='Action']/a/i")
	public List<WebElement> allDishesDeleteButton;
	
	
}
