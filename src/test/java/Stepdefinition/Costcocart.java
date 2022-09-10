package Stepdefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Costcocart {
WebDriver driver;
	@Given("^Launch Costco Application URL$")
	public void launch_Costco_Application_URL() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.costco.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
	}

	@Then("^Click on HotBuys$")
	public void click_on_HotBuys() throws Throwable {
	WebElement hotbuy = driver.findElement(By.xpath("//img[@alt='In-Warehouse Hot Buys. Valid 6/11/22 - 6/19/22 While Supplies Last']"));
	hotbuy.click();
	Thread.sleep(3000);
	}

	@Then("^Click on Vegetable tray$")
	public void click_on_Vegetable_tray() throws Throwable {
	WebElement vegetray = driver.findElement(By.xpath("//div[contains (text(),'Vegetable Tra')]"));
	vegetray.click();
	}
	@Then("^Enter Address$")
	public void enter_Address() throws Throwable {
	WebElement address = driver.findElement(By.id("shopping-selector-postal-code"));
	address.sendKeys("14 Via Amistosa, Rancho Santa Margarita, CA, USA");
	}

	@Then("^Click on Start shopping$")
	public void click_on_Start_shopping() throws Throwable {
	WebElement shopping = driver.findElement(By.xpath("//span[text()='Start Shopping']"));
	shopping.click();
	Thread.sleep(2000);
	}
	@When("^Click on Add to cart button$")
	public void click_on_Add_to_cart_button() throws Throwable {
	WebElement addtocart = driver.findElement(By.xpath("//span[text()='Add to Cart']"));
	addtocart.click();
	Thread.sleep(2000);
	}

	@Then("^Verify item added in Costcocart$")
	public void verify_item_added_in_Costcocart() throws Throwable {
    boolean inspectcart = driver.findElement(By.xpath("//span[@class='css-1tk3o5z']")).isDisplayed();
    Assert.assertTrue(inspectcart);
    Thread.sleep(3000);
	driver.close();
	}



}
