package com.global.fis.ebay.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.global.fis.ebay.AbstractComponents.AbstractComponent;


public class ProductPage extends AbstractComponent {

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

		
	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//i[@id='gh-cart-n']")
	WebElement cartUpdatedValue;

	By cartValue = By.xpath("//i[@id='gh-cart-n']");
	
	
	public void addProductToCart() throws InterruptedException
	{
		addToCartButton.click();
		waitForElementToAppear(cartValue);
		

	}
	
	public String productCountAddedToCart() {
		
		return cartUpdatedValue.getText();
	}

	

}
