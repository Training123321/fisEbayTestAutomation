package com.global.fis.TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.global.fis.TestComponents.BaseTest;
import com.global.fis.TestComponents.Listeners;
import com.global.fis.ebay.pageobjects.ProductPage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import org.testng.Assert;


public class SearchTest extends BaseTest {
	
	ProductPage products;
	

	@Test(dataProvider = "getData")
	public void searchProductTest(HashMap<String, String> input) throws IOException, InterruptedException {

		landingPage.enterTextInSearchBox(input.get("product"));
		Listeners.extentTest.get().log(Status.INFO, "User entered the product as ==> " + input.get("product"));
		landingPage.clickOnSearchButton();
		Listeners.extentTest.get().log(Status.INFO, "User clicks on Search button");

		String parentTitleString = driver.getTitle();
		products = landingPage.selectFirstListedProduct();
		Listeners.extentTest.get().log(Status.INFO, "Clicks on the first listed product");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String childWin : windowHandles) {
			if (driver.switchTo().window(childWin).getTitle().equalsIgnoreCase(parentTitleString)) {

			} else {
				driver.switchTo().window(childWin);
			}
		}
		products.addProductToCart();
		Listeners.extentTest.get().log(Status.INFO, "User clicks on Add to cart button");
		Assert.assertEquals(products.productCountAddedToCart(), "1");

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//com//global//fis//data//Product.json");
		return new Object[][] { { data.get(0) },{data.get(1)} };

	}

}
