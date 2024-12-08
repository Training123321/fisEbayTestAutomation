package com.global.fis.TestCases;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://ebay.com");
		// LandingPage landingPage = new LandingPage(driver);
		driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys("book");
		driver.findElement(By.xpath("//table[@class='gh-tbl']//input[@value='Search' and @id='gh-btn']")).click();

		/*
		 * wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
		 * "//div[@id='gAC']/ul/li/a")));
		 * 
		 * List<WebElement> products =
		 * driver.findElements(By.xpath("//div[@id='gAC']/ul/li/a"));
		 * 
		 * products.get(0).click();
		 */
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@id='srp-river-results']/ul/li[contains(@id,'item')][1]//a[@class='s-item__link']")));

		String parentWindoowString = driver.getWindowHandle();
		String parentTitleString = driver.getTitle();
		System.out.println(parentTitleString);
		driver.findElement(
				By.xpath("//div[@id='srp-river-results']/ul/li[contains(@id,'item')][1]//a[@class='s-item__link']"))
				.click();

		Set<String> windowHandles = driver.getWindowHandles();
		for (String win : windowHandles) {
			if (driver.switchTo().window(win).getTitle().equalsIgnoreCase(parentTitleString)) {

			} else {
				driver.switchTo().window(win);
			}
		}

		String childWindowForProduct = driver.getWindowHandle();
		System.out.println(childWindowForProduct);
		// driver.switchTo().window(childWindowForProduct);

		// div[@id='gh-top']//a[contains(@aria-label,'cart')]

		// System.out.println("Cart value before add to cart is ==> " +
		// driver.findElement(By.xpath("//i[@id='gh-cart-n']")).getText());

		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
		System.out.println("Cart value after add to cart is ==> "
				+ driver.findElement(By.xpath("//i[@id='gh-cart-n']")).getText());
		driver.close();
		driver.switchTo().window(parentWindoowString);

		// products.get(0).click();

		// driver.findElement(By.xpath("//div[@id='srp-river-main']/div[3]/ul/li[contains(@id,'item')][1]")).click();

	}

}
