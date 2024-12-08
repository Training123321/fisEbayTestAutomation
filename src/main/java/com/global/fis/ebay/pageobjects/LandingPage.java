package com.global.fis.ebay.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.global.fis.ebay.AbstractComponents.AbstractComponent;


public class LandingPage extends AbstractComponent{

	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		//initialization
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		
	//WebElement userEmails = driver.findElement(By.id("userEmail"));
	//PageFactory
	
	@FindBy(xpath="//input[@placeholder='Search for anything']")
	WebElement searchTextBox;
	
	@FindBy(xpath="//table[@class='gh-tbl']//input[@value='Search' and @id='gh-btn']")
	WebElement searchButton;
	
	@FindBy(xpath="//div[@id='srp-river-results']/ul/li[contains(@id,'item')][1]//a[@class='s-item__link']")
	WebElement firstSearchedListedProduct;
	
	By productsBy = By.xpath("//div[@id='srp-river-results']/ul/li[contains(@id,'item')][1]//a[@class='s-item__link']");
		
	public void goTo()
	{
		driver.get("https://ebay.com");
	}
	
	public void enterTextInSearchBox(String productToSearch) {
		searchTextBox.sendKeys(productToSearch);
		
	}
	
	public void clickOnSearchButton() {
		searchButton.click();
		waitForElementToAppear(productsBy);
		
	}
	
	public ProductPage selectFirstListedProduct() {
		firstSearchedListedProduct.click();
		return new ProductPage(driver);
	}
	
	
	
	
	
	
	

	
	
	
	
	
	
	
}
