package StepDefinition;

import java.util.ArrayList;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import util.Methods;

public class fillContactForm {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private int i = 0;
	
	@Given("^user navigates to \"([^\"]*)\" page$")
	public void user_navigates_to_page(String arg1) throws Throwable {			
		System.setProperty("webdriver.chrome.driver", "BrowserDriver//chromedriver.exe");					
	    driver= new ChromeDriver();
	    wait = new WebDriverWait(driver, 30);
	    driver.manage().window().maximize();	
		Methods.navigateTo(driver, "https://room5.trivago.com");	
		Methods.captureScreenShot(driver, "screenshots//" + getClass().getSimpleName()+ i +".png");
	    i += 1;
	}
	
	@When("^user clicks on \"([^\"]*)\" link in the footer$")
	public void user_clicks_on_link_in_the_footer(String arg1) throws Throwable {
		Methods.scrollToBottom(driver);
		Methods.captureScreenShot(driver, "screenshots//" + getClass().getSimpleName()+ i +".png");
	    i += 1;
		Methods.click("xpath", "/html/body/div[1]/div/div/div/div[4]/footer/div[1]/div[3]/div[1]/div[2]/a", driver, wait);
	}
	
	@Then("^new tab is opened$")
	public void new_tab_is_opened() throws Throwable {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Assert.assertEquals("https://magazine.trivago.com.au/contact/", driver.getCurrentUrl());
		Methods.captureScreenShot(driver, "screenshots//" + getClass().getSimpleName()+ i +".png");
	    i += 1;
	}
	
	@When("^user fills the contact form and submits it$")
	public void user_fills_the_contact_form_and_submits_it() throws Throwable {
		Methods.enterText("className", "I want to know more about Indian destinations", "contact-msg", driver, wait);
        Methods.enterText("className", "Likith", "contact-input", driver, wait);
        Methods.enterText("id", "xyz@gmail.com", "contact-email", driver, wait);
        Methods.click("id", "confirm", driver, wait);
        Methods.captureScreenShot(driver, "screenshots//" + getClass().getSimpleName()+ i +".png");
	    i += 1;
        Methods.click("className", "contact-submit", driver, wait);
	}
	
	@Then("^message \"([^\"]*)\" should be displayed$")
	public void message_should_be_displayed(String arg1) throws Throwable {
		Methods.checkElementText("className", "Message Sent Successfully!", "feedback", driver, wait);
		Methods.captureScreenShot(driver, "screenshots//" + getClass().getSimpleName()+ i +".png");
		driver.close();
		driver.quit();
	}

}
