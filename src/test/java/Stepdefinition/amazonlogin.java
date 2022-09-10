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

public class amazonlogin {
	
	WebDriver driver;
@Given("^Launch Application Amazon URL$")
public void launch_Application_Amazon_URL() throws Throwable {
	System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.amazon.com/");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);//page loading wait
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// implisicy wait to load web element
}

@When("^Click on Amazon Login link$")
public void click_on_Amazon_Login_link() throws Throwable {
	WebElement amazonlink =driver.findElement(By.id("nav-link-accountList-nav-line-1"));
	amazonlink.click();
}

@When("^Enter Amazon email$")
public void enter_Amazon_email() throws Throwable {
	WebElement amazonemail =driver.findElement(By.id("ap_email"));
	amazonemail.sendKeys("bonychowdhury@yahoo.com");
	Thread.sleep(3000);
}


@When("^click on continue$")
public void click_on_continue() throws Throwable {
	WebElement amazoncont =driver.findElement(By.xpath("//input[@class='a-button-input']"));
	amazoncont.click(); 
}


@When("^Enter Amazon Password$")
public void enter_Amazon_Password() throws Throwable {
	WebElement amazonpass =driver.findElement(By.id("ap_password"));
	amazonpass.sendKeys("Suravee786!");
}

@When("^Click on Amazon Login button$")
public void click_on_Amazon_Login_button() throws Throwable {
	WebElement amazonlogin =driver.findElement(By.id("signInSubmit"));
	amazonlogin.click();
}

@Then("^Verify Amazon login successfully$")
public void verify_Amazon_login_successfully() throws Throwable {
	boolean loginaresult=	driver.findElement(By.id("nav-link-accountList-nav-line-1")).isDisplayed();
	Assert.assertTrue(loginaresult);
	
	Thread.sleep(300);
		driver.close();
}



}
