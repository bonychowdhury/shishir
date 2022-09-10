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

public class Login {
	WebDriver driver;
	@Given("^Application(\\d+) URL$")
	public void application_URL(int arg1) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);//page loading wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// implisicy wait to load web element   
	}
	@Then("^Click on login link$")
	public void click_on_login_link() throws Throwable {
	WebElement loginlink = driver.findElement(By.id("login2"));
	loginlink.click();
	}

	@Then("^Enter user name$")
	public void enter_user_name() throws Throwable {
	WebElement username = driver.findElement(By.id("loginusername"));
	username.sendKeys("rokeya.");
	}

	@Then("^Enter user password$")
	public void enter_user_password() throws Throwable {
	WebElement password = driver.findElement(By.id("loginpassword"));
	password.sendKeys("arafehan");
	}

	@When("^Click on login button$")
	public void click_on_login_button() throws Throwable {
	WebElement loginbutton = driver.findElement(By.xpath("//button[text()='Log in']"));
	loginbutton.click();
	Thread.sleep(3000);
	}

	@Then("^Verify user login sucessfully$")
	public void verify_user_login_sucessfully() throws Throwable {
	boolean verifylogin = driver.findElement(By.linkText("Welcome rokeya.")).isDisplayed();
	Assert.assertTrue(verifylogin);
	Thread.sleep(3000);
	driver.close();
	}

}
