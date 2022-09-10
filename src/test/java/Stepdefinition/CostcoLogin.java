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

public class CostcoLogin {
	WebDriver driver;
	@Given("^Launch Costco Application(\\d+) URL$")
	public void launch_Costco_Application_URL(int arg1) throws Throwable {
	System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.costco.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Thread.sleep(3000);
	}	
	@Then("^Click on Signin link$")
	public void click_on_Signin_link() throws Throwable {
	WebElement sign = driver.findElement(By.linkText("Sign In / Register"));
	sign.click();
	}

	@Then("^Enter Email Address$")
	public void enter_Email_Address() throws Throwable {
	WebElement email = driver.findElement(By.id("signInName"));// type email
	email.sendKeys("bonychowdhury@yahoo.com");    
	}

	@Then("^Enter Password$")
	public void enter_Password() throws Throwable {
	WebElement pass = driver.findElement(By.id("password"));// type pass
	pass.sendKeys("Suravee786!");    
	}
	@When("^Click on Sign in button$")
	public void click_on_Sign_in_button() throws Throwable {
	WebElement sigininclick = driver.findElement(By.id("next"));//click sign in button
	sigininclick.click(); 
	Thread.sleep(3000);
	}

	@Then("^Verify member login sucessfully$")
	public void verify_member_login_sucessfully() throws Throwable {
	WebElement myacc = driver.findElement(By.id("myaccount-react-d"));// click myaccount detail
	myacc.click();
	WebElement myaccdetails = driver.findElement(By.xpath("//span[text()='Account Details']"));
	myaccdetails.click();
	Thread.sleep(5000);
	boolean membershipno = driver.findElement(By.id("membership-number-value")).isDisplayed();
	Assert.assertTrue(membershipno);// check if profile is there
	driver.quit();
	}

}
