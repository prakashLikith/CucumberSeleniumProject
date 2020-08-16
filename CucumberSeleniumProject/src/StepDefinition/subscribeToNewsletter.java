package StepDefinition;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.Methods;


public class subscribeToNewsletter {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private int i = 0;
	
	@Given("^user enters \"([^\"]*)\" page$")
	public void user_enters_page(String arg1) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "BrowserDriver//chromedriver.exe");					
	    driver= new ChromeDriver();
	    wait = new WebDriverWait(driver, 30);
	    driver.manage().window().maximize();			
	    Methods.navigateTo(driver, "https://room5.trivago.com");
	    Methods.captureScreenShot(driver, "screenshots//" + getClass().getSimpleName()+ i +".png");
	    i += 1;
	}
	
	@When("^user enters email address in newsletter subscription textbox$")
	public void user_enters_email_address_in_newsletter_subscription_textbox() throws Throwable {
		Methods.enterText("className", Methods.generateRandomString()+"@gmail.com", "et-email", driver, wait);
		Methods.captureScreenShot(driver, "screenshots//" + getClass().getSimpleName()+ i +".png");
	    i += 1;
	}
	
	@When("^user clicks on \"([^\"]*)\" button$")
	public void user_clicks_on_button(String arg1) throws Throwable {
		Methods.click("className", "submit", driver, wait);
	}
	
	@Then("^Message \"([^\"]*)\" should be displayed$")
	public void message_should_be_displayed(String arg1) throws Throwable {
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.xpath("/html/body/div[1]/div/div/div/div[3]/div/div/div[4]/section/div/p")).getText().length() != 0;
            }
        });
		Methods.checkElementText("xpath", "You are now checked-in!", "/html/body/div[1]/div/div/div/div[3]/div/div/div[4]/section/div/p", driver, wait);
		Methods.captureScreenShot(driver, "screenshots//" + getClass().getSimpleName()+ i +".png");
		driver.close();
		driver.quit();
	}
}
