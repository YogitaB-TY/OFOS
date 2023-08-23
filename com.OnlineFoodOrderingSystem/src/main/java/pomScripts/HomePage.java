package pomScripts;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	//Home page link
	@FindBy(xpath = "//a[text()='Home ']")
	private WebElement homeLink;

	//Restaurants link
	@FindBy(xpath = "//a[text()='Restaurants ']")
	private WebElement restaurantsLink;

	//Login link
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement loginLink;

	//Register link
	@FindBy(xpath = "//a[text()='Register']")
	private WebElement registerLink;


	//MyOrders link link
	@FindBy(xpath = "//a[text()='My Orders']")
	private WebElement myOrdersLink;

	//Logout link
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logOutLink;

	//Yorkshire Lamb Patties link
	@FindBy(xpath = "//a[text()='Yorkshire Lamb Patties']")
	private WebElement yorkshireLambPattiesLink;

	//Order now button of Yorkshire Lamb Patties
	@FindBy(xpath = "//a[text()='Yorkshire Lamb Patties']/../..//a[text()='Order Now']")
	private WebElement orderNowYorkshireLambPatties;

	//Lobster Thermidor link
	@FindBy(xpath = "//a[text()='Lobster Thermidor']")
	private WebElement lobsterThermidor;

	//Order now button of Lobster Thermidor
	@FindBy(xpath = "//a[text()='Lobster Thermidor']/../..//a[text()='Order Now']")
	private WebElement orderLobsterThermidor;

	//Chicken Madeira link
	@FindBy(xpath = "//a[text()='Chicken Madeira']")
	private WebElement chickenMadeira;

	//Order now button of Chicken Madeira
	@FindBy(xpath = "//a[text()='Chicken Madeira']/../..//a[text()='Order Now']")
	private WebElement orderChickenMadeira;

	//Stuffed Jacket Potatoes link
	@FindBy(xpath = "//a[text()='Stuffed Jacket Potatoes']")
	private WebElement stuffedJacketPotatoes;

	//Order now button of Stuffed Jacket Potatoes
	@FindBy(xpath = "//a[text()='Stuffed Jacket Potatoes']/../..//a[text()='Order Now']")
	private WebElement orderNowStuffedJacketPotatoes;

	//Pink Spaghetti Gamberoni link
	@FindBy(xpath = "//a[text()='Pink Spaghetti Gamberoni']")
	private WebElement pinkSpaghettiGamberoni;

	//Order now button of Pink Spaghetti Gamberoni
	@FindBy(xpath = "//a[text()='Yorkshire Lamb Patties']/../..//a[text()='Order Now']")
	private WebElement orderNowPinkSpaghettiGamberoni;

	//Cheesy Mashed Potato link
	@FindBy(xpath = "//a[text()='Cheesy Mashed Potato']")
	private WebElement cheesyMashedPotato;

	//Order now button of Cheesy Mashed Potato
	@FindBy(xpath = "//a[text()='Cheesy Mashed Potato']/../..//a[text()='Order Now']")
	private WebElement orderNowCheesyMashedPotato;

	//name of all dishes
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 col-md-4 food-item']//div[@class='content']/h5//a")
	private List<WebElement> nameOfAllDishes;

	//Oder now button of all dishes
	@FindBy(xpath = "//div[@class='col-xs-12 col-sm-6 col-md-4 food-item']//div[@class='content']//div[@class='price-btn-block']//a")
	private List<WebElement> orderNowButtonOfAllDishes;

	//North street tavern restaurant name
	@FindBy(xpath = "//a[text()='North Street Tavern']")
	private WebElement northStreetTavernName;

	//North Street Tavern restaurant image
	@FindBy(xpath = "//a[text()='North Street Tavern']/../../..//img")
	private WebElement northStreetTavernImage;

	//Eataly restaurant name
	@FindBy(xpath = "//a[text()='Eataly']")
	private WebElement eatalyName;

	//Eataly restaurant name
	@FindBy(xpath = "//a[text()='Eataly']/../../..//img")
	private WebElement eatalyImage;

	//Nan Xiang Xiao Long Bao restaurant name
	@FindBy(xpath = "//a[text()='Nan Xiang Xiao Long Bao']")
	private WebElement nanXiangXiaoLongBaoName;

	//Nan Xiang Xiao Long Bao restaurant name
	@FindBy(xpath = "//a[text()='Nan Xiang Xiao Long Bao']/../../..//img")
	private WebElement nanXiangXiaoLongBaoImage;

	//Highlands Bar & Grill restaurant name
	@FindBy(xpath = "//a[text()='Highlands Bar & Grill']")
	private WebElement highlandsBarAndGrillName;


	//Highlands Bar & Grill restaurant name
	@FindBy(xpath = "//a[text()='Highlands Bar & Grill']/../../..//img")
	private WebElement highlandsBarAndGrillImage;

	//New Ruchi restaurant name
	@FindBy(xpath = "//a[text()='New Ruchi']")
	private WebElement newRuchiName;

	//New Ruchi restaurant name
	@FindBy(xpath = "//a[text()='New Ruchi']/../../..//img")
	private WebElement newRuchiImage;


	//All retsaurants name
	@FindBy(xpath = "//div[@class='restaurant-listing']//h5/a")
	private List<WebElement> allRestaurantsName;

	//All restaurants images
	@FindBy(xpath = "//div[@class='restaurant-listing']//img")
	private List<WebElement> allRestaurantsImage;

	// Continental link
	@FindBy(xpath = "//a[text()=' Continental']")
	private WebElement continentalLink;

	// Italian link
	@FindBy(xpath = "//a[text()=' Italian']")
	private WebElement italianLink;

	// Chinese link
	@FindBy(xpath = "//a[text()=' Chinese']")
	private WebElement chineseLink;

	// American link
	@FindBy(xpath = "//a[text()=' American']")
	private WebElement americanLink;

	// South Indian link
	@FindBy(xpath = "//a[text()=' South Indian']")
	private WebElement  southIndianLink;

	// North Indian link
	@FindBy(xpath = "//a[text()=' North Indian']")
	private WebElement  northIndianLink;

	// HELL link
	@FindBy(xpath = "//a[text()=' HELL']")
	private WebElement  hellLink;

	// HEAVENLY FOOD link
	@FindBy(xpath = "//a[text()=' HEAVENLY FOOD']")
	private WebElement  heavenlyFoodLink;

	// kiki link
	@FindBy(xpath = "//a[text()=' kiki']")
	private WebElement  kikiLink;

	//All link
	@FindBy(xpath = "//a[text()='all']")
	private WebElement allLink;

	//All restaurants type list
	@FindBy(xpath = "//div[@class='col-sm-8']//a")
	private List<WebElement> allRestaurantTypesLinks;

	public WebElement getHomeLink() {
		return homeLink;
	}

	public void setHomeLink(WebElement homeLink) {
		this.homeLink = homeLink;
	}

	public WebElement getRestaurantsLink() {
		return restaurantsLink;
	}

	public void setRestaurantsLink(WebElement restaurantsLink) {
		this.restaurantsLink = restaurantsLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public void setLoginLink(WebElement loginLink) {
		this.loginLink = loginLink;
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public void setRegisterLink(WebElement registerLink) {
		this.registerLink = registerLink;
	}

	public WebElement getMyOrdersLink() {
		return myOrdersLink;
	}

	public void setMyOrdersLink(WebElement myOrdersLink) {
		this.myOrdersLink = myOrdersLink;
	}

	public WebElement getLogOutLink() {
		return logOutLink;
	}

	public void setLogOutLink(WebElement logOutLink) {
		this.logOutLink = logOutLink;
	}

	public WebElement getYorkshireLambPattiesLink() {
		return yorkshireLambPattiesLink;
	}

	public void setYorkshireLambPattiesLink(WebElement yorkshireLambPattiesLink) {
		this.yorkshireLambPattiesLink = yorkshireLambPattiesLink;
	}

	public WebElement getOrderNowYorkshireLambPatties() {
		return orderNowYorkshireLambPatties;
	}

	public void setOrderNowYorkshireLambPatties(WebElement orderNowYorkshireLambPatties) {
		this.orderNowYorkshireLambPatties = orderNowYorkshireLambPatties;
	}

	public WebElement getLobsterThermidor() {
		return lobsterThermidor;
	}

	public void setLobsterThermidor(WebElement lobsterThermidor) {
		this.lobsterThermidor = lobsterThermidor;
	}

	public WebElement getOrderLobsterThermidor() {
		return orderLobsterThermidor;
	}

	public void setOrderLobsterThermidor(WebElement orderLobsterThermidor) {
		this.orderLobsterThermidor = orderLobsterThermidor;
	}

	public WebElement getChickenMadeira() {
		return chickenMadeira;
	}

	public void setChickenMadeira(WebElement chickenMadeira) {
		this.chickenMadeira = chickenMadeira;
	}

	public WebElement getOrderChickenMadeira() {
		return orderChickenMadeira;
	}

	public void setOrderChickenMadeira(WebElement orderChickenMadeira) {
		this.orderChickenMadeira = orderChickenMadeira;
	}

	public WebElement getStuffedJacketPotatoes() {
		return stuffedJacketPotatoes;
	}

	public void setStuffedJacketPotatoes(WebElement stuffedJacketPotatoes) {
		this.stuffedJacketPotatoes = stuffedJacketPotatoes;
	}

	public WebElement getOrderNowStuffedJacketPotatoes() {
		return orderNowStuffedJacketPotatoes;
	}

	public void setOrderNowStuffedJacketPotatoes(WebElement orderNowStuffedJacketPotatoes) {
		this.orderNowStuffedJacketPotatoes = orderNowStuffedJacketPotatoes;
	}

	public WebElement getPinkSpaghettiGamberoni() {
		return pinkSpaghettiGamberoni;
	}

	public void setPinkSpaghettiGamberoni(WebElement pinkSpaghettiGamberoni) {
		this.pinkSpaghettiGamberoni = pinkSpaghettiGamberoni;
	}

	public WebElement getOrderNowPinkSpaghettiGamberoni() {
		return orderNowPinkSpaghettiGamberoni;
	}

	public void setOrderNowPinkSpaghettiGamberoni(WebElement orderNowPinkSpaghettiGamberoni) {
		this.orderNowPinkSpaghettiGamberoni = orderNowPinkSpaghettiGamberoni;
	}

	public WebElement getCheesyMashedPotato() {
		return cheesyMashedPotato;
	}

	public void setCheesyMashedPotato(WebElement cheesyMashedPotato) {
		this.cheesyMashedPotato = cheesyMashedPotato;
	}

	public WebElement getOrderNowCheesyMashedPotato() {
		return orderNowCheesyMashedPotato;
	}

	public void setOrderNowCheesyMashedPotato(WebElement orderNowCheesyMashedPotato) {
		this.orderNowCheesyMashedPotato = orderNowCheesyMashedPotato;
	}

	public List<WebElement> getNameOfAllDishes() {
		return  nameOfAllDishes;
	}

	public List<WebElement> getOrderNowButtonOfAllDishes() {
		return orderNowButtonOfAllDishes;
	}
	public WebElement getNorthStreetTavernName() {
		return northStreetTavernName;
	}

	public void setNorthStreetTavernName(WebElement northStreetTavernName) {
		this.northStreetTavernName = northStreetTavernName;
	}

	public WebElement getNorthStreetTavernImage() {
		return northStreetTavernImage;
	}

	public void setNorthStreetTavernImage(WebElement northStreetTavernImage) {
		this.northStreetTavernImage = northStreetTavernImage;
	}

	public WebElement getEatalyName() {
		return eatalyName;
	}

	public void setEatalyName(WebElement eatalyName) {
		this.eatalyName = eatalyName;
	}

	public WebElement getEatalyImage() {
		return eatalyImage;
	}

	public void setEatalyImage(WebElement eatalyImage) {
		this.eatalyImage = eatalyImage;
	}

	public WebElement getNanXiangXiaoLongBaoName() {
		return nanXiangXiaoLongBaoName;
	}

	public void setNanXiangXiaoLongBaoName(WebElement nanXiangXiaoLongBaoName) {
		this.nanXiangXiaoLongBaoName = nanXiangXiaoLongBaoName;
	}

	public WebElement getNanXiangXiaoLongBaoImage() {
		return nanXiangXiaoLongBaoImage;
	}

	public void setNanXiangXiaoLongBaoImage(WebElement nanXiangXiaoLongBaoImage) {
		this.nanXiangXiaoLongBaoImage = nanXiangXiaoLongBaoImage;
	}

	public WebElement getHighlandsBarAndGrillName() {
		return highlandsBarAndGrillName;
	}

	public void setHighlandsBarAndGrillName(WebElement highlandsBarAndGrillName) {
		this.highlandsBarAndGrillName = highlandsBarAndGrillName;
	}

	public WebElement getHighlandsBarAndGrillImage() {
		return highlandsBarAndGrillImage;
	}

	public void setHighlandsBarAndGrillImage(WebElement highlandsBarAndGrillImage) {
		this.highlandsBarAndGrillImage = highlandsBarAndGrillImage;
	}

	public WebElement getNewRuchiName() {
		return newRuchiName;
	}

	public void setNewRuchiName(WebElement newRuchiName) {
		this.newRuchiName = newRuchiName;
	}

	public WebElement getNewRuchiImage() {
		return newRuchiImage;
	}

	public void setNewRuchiImage(WebElement newRuchiImage) {
		this.newRuchiImage = newRuchiImage;
	}

	public List<WebElement> getAllRestaurantsName() {
		return allRestaurantsName;
	}



	public List<WebElement> getAllRestaurantsImage() {
		return allRestaurantsImage;
	}


	public WebElement getContinentalLink() {
		return continentalLink;
	}

	public void setContinentalLink(WebElement continentalLink) {
		this.continentalLink = continentalLink;
	}

	public WebElement getItalianLink() {
		return italianLink;
	}

	public void setItalianLink(WebElement italianLink) {
		this.italianLink = italianLink;
	}

	public WebElement getChineseLink() {
		return chineseLink;
	}

	public void setChineseLink(WebElement chineseLink) {
		this.chineseLink = chineseLink;
	}

	public WebElement getAmericanLink() {
		return americanLink;
	}

	public void setAmericanLink(WebElement americanLink) {
		this.americanLink = americanLink;
	}

	public WebElement getSouthIndianLink() {
		return southIndianLink;
	}

	public void setSouthIndianLink(WebElement southIndianLink) {
		this.southIndianLink = southIndianLink;
	}

	public WebElement getNorthIndianLink() {
		return northIndianLink;
	}

	public void setNorthIndianLink(WebElement northIndianLink) {
		this.northIndianLink = northIndianLink;
	}

	public WebElement getHellLink() {
		return hellLink;
	}

	public void setHellLink(WebElement hellLink) {
		this.hellLink = hellLink;
	}

	public WebElement getHeavenlyFoodLink() {
		return heavenlyFoodLink;
	}

	public void setHeavenlyFoodLink(WebElement heavenlyFoodLink) {
		this.heavenlyFoodLink = heavenlyFoodLink;
	}

	public WebElement getKikiLink() {
		return kikiLink;
	}

	public void setKikiLink(WebElement kikiLink) {
		this.kikiLink = kikiLink;
	}

	public WebElement getAllLink() {
		return allLink;
	}

	public void setNameOfAllDishes(List<WebElement> nameOfAllDishes) {
		this.nameOfAllDishes = nameOfAllDishes;
	}

	public void setOrderNowButtonOfAllDishes(List<WebElement> orderNowButtonOfAllDishes) {
		this.orderNowButtonOfAllDishes = orderNowButtonOfAllDishes;
	}

	public void setAllRestaurantsName(List<WebElement> allRestaurantsName) {
		this.allRestaurantsName = allRestaurantsName;
	}

	public void setAllRestaurantsImage(List<WebElement> allRestaurantsImage) {
		this.allRestaurantsImage = allRestaurantsImage;
	}

	public void setAllRestaurantTypesLinks(List<WebElement> allRestaurantTypesLinks) {
		this.allRestaurantTypesLinks = allRestaurantTypesLinks;
	}

	public void setAllLink(WebElement allLink) {
		this.allLink = allLink;
	}

	public List<WebElement> getAllRestaurantTypesLinks() {
		return allRestaurantTypesLinks;
	}

}
