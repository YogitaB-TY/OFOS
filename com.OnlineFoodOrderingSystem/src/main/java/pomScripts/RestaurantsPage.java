package pomScripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class RestaurantsPage extends BasePage {

	public RestaurantsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//View Menu button of all restaurants
	@FindBy(xpath = "//a[text()='View Menu']")
	private List<WebElement> viewMenuButtons;
	
	//Name of all restaurants
	@FindBy(xpath = "//div[@class='entry-dscr']//h5//a")
	private List<WebElement> nameofAllRestaurants;
	
	//Image of all restaurants
	@FindBy(xpath = "//div[@class='entry-dscr']/..//img")
	private List<WebElement> imageOfAllRestaurants;

	public List<WebElement> getViewMenuButtons() {
		return viewMenuButtons;
	}

	public void setViewMenuButtons(List<WebElement> viewMenuButtons) {
		this.viewMenuButtons = viewMenuButtons;
	}

	public List<WebElement> getNameofAllRestaurants() {
		return nameofAllRestaurants;
	}

	public void setNameofAllRestaurants(List<WebElement> nameofAllRestaurants) {
		this.nameofAllRestaurants = nameofAllRestaurants;
	}

	public List<WebElement> getImageOfAllRestaurants() {
		return imageOfAllRestaurants;
	}

	public void setImageOfAllRestaurants(List<WebElement> imageOfAllRestaurants) {
		this.imageOfAllRestaurants = imageOfAllRestaurants;
	}
	
	

}
