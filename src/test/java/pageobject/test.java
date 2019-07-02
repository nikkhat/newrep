package pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class test {
	WebDriver driver;

	
	@Given("user opens login page in newtours application")
	public void user_opens_login_page_in_newtours_application() {
		System.setProperty("webdriver.chrome.driver", "C:\\NexGenTesting\\ChromeDriver.exe");
		driver=new ChromeDriver();
		driver.get("http://newtours.demoaut.com");
	}

	@When("user enter username as mercury and password as mercury")
	public void user_enter_username_as_mercury_and_password_as_mercury() {
		pageobject loginpage = PageFactory.initElements(driver, pageobject.class);
		loginpage.un.sendKeys("mercury");
		loginpage.psd.sendKeys("mercury");
		
	}

	@When("Click on Submit button")
	public void click_on_Submit_button() {
		pageobject loginpage = PageFactory.initElements(driver, pageobject.class);
		pageobject.ok.click();
	}

	@Then("verify login result")
	public void verify_login_result() {
		String title=driver.getTitle();
		Assert.assertEquals("Find a Flight: Mercury Tours:", title);
		driver.close();
	}

}

