package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.Methods;


public class magazineSearch {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private int i = 0;
	
	@Given("^user is in \"([^\"]*)\" page$")
	public void user_is_in_page(String arg1) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "BrowserDriver//chromedriver.exe");					
	    driver= new ChromeDriver();
	    wait = new WebDriverWait(driver, 30);
	    driver.manage().window().maximize();			
	    Methods.navigateTo(driver, "https://room5.trivago.com");
	    Methods.captureScreenShot(driver, "screenshots//" + getClass().getSimpleName()+ i +".png");
	    i += 1;
	}
	
	@When("^user enters any search keyword on search bar$")
	public void user_enters_any_search_keyword_on_search_bar() throws Throwable {
		Methods.click("className", "search-icon", driver, wait);
		Methods.enterText("xpath", "Paris", "/html/body/div[1]/div/div/div/div[2]/header/div/div/div[4]/div[1]/div[2]/input", driver, wait);
		Methods.captureScreenShot(driver, "screenshots//" + getClass().getSimpleName()+ i +".png");
	    i += 1;
	}
	
	@When("^user presses \"([^\"]*)\"$")
	public void user_presses(String arg1) throws Throwable {
		Methods.pressEnter("xpath", "/html/body/div[1]/div/div/div/div[2]/header/div/div/div[4]/div[1]/div[2]/input", driver, wait);
	}
	
	@Then("^user should be redirected to search results page$")
	public void user_should_be_redirected_to_search_results_page() throws Throwable {
        Methods.checkElementPartialText("xpath","Search Results", "/html/body/div[1]/div/div/div/div[2]/header/div/div/div[4]/div[1]/div[8]/h3", driver, wait);
        Methods.captureScreenShot(driver, "screenshots//" + getClass().getSimpleName()+ i +".png");
        driver.close();
		driver.quit();
	}

}
