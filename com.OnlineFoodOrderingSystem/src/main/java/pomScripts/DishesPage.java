package pomScripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class DishesPage extends BasePage {

	public DishesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Menu Heading
	@FindBy(xpath = "(//div[@class='widget-heading']//h3)[2]")
	private WebElement menuHeading;

	//All items list
	@FindBy(xpath = "//div[@class='collapse in']//div[@class='food-item']")
	private List<WebElement> allItems;

	//All items names
	@FindBy(xpath = "//div[@class='collapse in']//div[@class='food-item']//div[@class='rest-descr']//a")
	private List<WebElement> allItemsName;

	//All items Images
	@FindBy(xpath = "//div[@class='collapse in']//div[@class='food-item']//img")
	private List<WebElement> allItemsImages;

	//Quantity textfield of all items
	@FindBy(xpath = "//div[@class='collapse in']//input[@name='quantity']")
	private List<WebElement> quantityTextfieldOfAllItems;

	//Add to cart button of all items
	@FindBy(xpath = "//div[@class='collapse in']//input[@value='Add To Cart']")
	private List<WebElement> addToCartButtonOfAllItems;

	//Delete button of all Your cart items
	@FindBy(xpath = "//div[@class='widget-body']//i")
	private List<WebElement> deleteButtonsOfAllYourcartItems;

	//Checkout button
	@FindBy(xpath = "//div[@class='widget-body']//a[text()='Checkout']")
	private WebElement checkoutButton;

	@FindBy(xpath = "//div[@class='order-row bg-white']//div[@class='title-row']")
	private List<WebElement> allItemsNameInYourCartItems;
	
	public List<WebElement> getAllItemsNameInYourCartItems() {
		return allItemsNameInYourCartItems;
	}

	public void setAllItemsNameInYourCartItems(List<WebElement> allItemsNameInYourCartItems) {
		this.allItemsNameInYourCartItems = allItemsNameInYourCartItems;
	}

	public List<WebElement> getAllItems() {
		return allItems;
	}

	public WebElement getMenuHeading() {
		return menuHeading;
	}

	public void setMenuHeading(WebElement menuHeading) {
		this.menuHeading = menuHeading;
	}

	public void setAllItems(List<WebElement> allItems) {
		this.allItems = allItems;
	}

	public List<WebElement> getAllItemsName() {
		return allItemsName;
	}

	public void setAllItemsName(List<WebElement> allItemsName) {
		this.allItemsName = allItemsName;
	}

	public List<WebElement> getAllItemsImages() {
		return allItemsImages;
	}

	public void setAllItemsImages(List<WebElement> allItemsImages) {
		this.allItemsImages = allItemsImages;
	}




	public List<WebElement> getQuantityTextfieldOfAllItems() {
		return quantityTextfieldOfAllItems;
	}

	public void setQuantityTextfieldOfAllItems(List<WebElement> quantityTextfieldOfAllItems) {
		this.quantityTextfieldOfAllItems = quantityTextfieldOfAllItems;
	}

	public void setCheckoutButton(WebElement checkoutButton) {
		this.checkoutButton = checkoutButton;
	}

	public List<WebElement> getAddToCartButtonOfAllItems() {
		return addToCartButtonOfAllItems;
	}

	public void setAddToCartButtonOfAllItems(List<WebElement> addToCartButtonOfAllItems) {
		this.addToCartButtonOfAllItems = addToCartButtonOfAllItems;
	}

	public List<WebElement> getDeleteButtonsOfAllYourcartItems() {
		return deleteButtonsOfAllYourcartItems;
	}

	public void setDeleteButtonsOfAllYourcartItems(List<WebElement> deleteButtonsOfAllYourcartItems) {
		this.deleteButtonsOfAllYourcartItems = deleteButtonsOfAllYourcartItems;
	}

	public WebElement getCheckoutButton() {
		return checkoutButton;
	}

}
