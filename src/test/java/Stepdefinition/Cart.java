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

public class Cart {
	WebDriver driver;
	@Given("^Launch Application URL$")
	public void launch_Application_URL() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);//page loading wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// implisicy wait to load web element
	  
	}

	@Then("^Click on Samsung Galaxy s(\\d+)$")
	public void click_on_Samsung_Galaxy_s(int arg1) throws Throwable {
		WebElement samsunglink =driver.findElement(By.linkText("Samsung galaxy s6"));
		  samsunglink.click();
	}

	@When("^Click on Add to cart$")
	public void click_on_Add_to_cart() throws Throwable {
		WebElement AdtoCartButtons =driver.findElement(By.linkText("Add to cart"));
		  AdtoCartButtons.click();
		Thread.sleep(300);
		  driver.switchTo().alert().accept();
		
	}

	@Then("^Click on cart$")
	public void click_on_cart() throws Throwable {
		WebElement Cartlink =driver.findElement(By.linkText("Cart"));
		  Cartlink.click();
	}

	@Then("^Verify item added in cart$")
	public void verify_item_added_in_cart() throws Throwable {
	boolean cartresult=	driver.findElement(By.xpath("//td[text()='Samsung galaxy s6']")).isDisplayed();
	Assert.assertTrue(cartresult);
	
	Thread.sleep(300);
		driver.close();
	   
	}


}
