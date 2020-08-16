package util;


import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods {
	
	/**
	 * Method to click on an element
	 * @param accessType: String : Locator type (id, name, className, xpath, css etc..)        
	 * @param accessName: String : Locator value          
	 * @param driver: WebDriver : driver           
	 * @param wait: WebDriverWait : explicit wait           
	 */
	public static void click(String accessType, String accessName, WebDriver driver, WebDriverWait wait) {
		try {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to press enter key
	 * @param accessType: String : Locator type (id, name, className, xpath, css etc..)         
	 * @param accessName: String : Locator value           
	 * @param driver: WebDriver : driver        
	 * @param wait: WebDriverWait : explicit wait 
	 */
	public static void pressEnter(String accessType, String accessName, WebDriver driver, WebDriverWait wait) {
		try {
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
			element.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static By getelementbytype(String type, String access_name) {
		switch (type) {
		case "id":
			return By.id(access_name);
		case "name":
			return By.name(access_name);
		case "className":
			return By.className(access_name);
		case "xpath":
			return By.xpath(access_name);
		case "css":
			return By.cssSelector(access_name);
		case "linkText":
			return By.linkText(access_name);
		case "partialLinkText":
			return By.partialLinkText(access_name);
		case "tagName":
			return By.tagName(access_name);
		default:
			return null;

		}
	}
	
	/**
	 * Method to check check-box
	 * @param accessType: String : Locator type (id, name, className, xpath, css)           
	 * @param accessName: String : Locator value          
	 * @param driver: WebDriver : driver           
	 * @param wait: WebDriverWait : explicit wait          
	 */
	public void checkCheckbox(String accessType, String accessName, WebDriver driver, WebDriverWait wait) {
		try {
			WebElement checkbox = wait
					.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
			if (!checkbox.isSelected())
				checkbox.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to enter text into text field
	 * @param accessType: String : Locator type (id, name, class, xpath, css)     
	 * @param text: String : Text value to enter in field     
	 * @param accessName: String : Locator value      
	 * @param driver: WebDriver : driver       
	 * @param wait: WebDriverWait : explicit wait        
	 */
	public static void enterText(String accessType, String text, String accessName, WebDriver driver, WebDriverWait wait) {
		try {
			WebElement textBox = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
			textBox.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to verify text
	 * @param accessType: String : Locator type (id, name, className, xpath, css)     
	 * @param expectedValue: String : Expected text value          
	 * @param accessName: String : Locator value          
	 * @param driver: WebDriver : driver          
	 * @param wait: WebDriverWait : explicit wait           
	 */
	public static void checkElementText(String accessType, String expectedValue, String accessName,  WebDriver driver, WebDriverWait wait){
		String elementText = getElementText(accessType, accessName, driver, wait);
		Assert.assertTrue(elementText.equals(expectedValue));
	}
	
	/**
	 * Method to verify if text is in actual value
	 * @param accessType: String : Locator type (id, name, className, xpath, css)           
	 * @param expectedValue: String : Expected text value          
	 * @param accessName: String : Locator value         
	 * @param driver: WebDriver : driver          
	 * @param wait: WebDriverWait : explicit wait            
	 */
	public static void checkElementPartialText(String accessType, String expectedValue, String accessName,  WebDriver driver, WebDriverWait wait) {
		String elementText = getElementText(accessType, accessName, driver, wait);
		Assert.assertTrue(elementText.contains(expectedValue));
	}
	
	/**
	 * Method to retrieve text  of an element
	 * @param accessType: String : Locator type (id, name, className, xpath, css)         
	 * @param accessName: String : Locator value          
	 * @param driver: WebDriver : driver         
	 * @param wait: WebDriverWait : explicit wait       
	 */
	public static String getElementText(String accessType, String accessName, WebDriver driver, WebDriverWait wait) {
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(getelementbytype(accessType, accessName)));
		return element.getText();
	}
	
	/**
	 * Method to navigate to a page
	 * @param url : String : Url address        
	 */
	public static void navigateTo(WebDriver driver, String url) {
		driver.get(url);
	}
	
	/**
	 * Method to scroll to bottom of a page
	 * @param driver: WebDriver : driver       
	 */
	public static void scrollToBottom(WebDriver driver) {
		WebElement body = driver.findElement(By.tagName("body")); 
		body.sendKeys(Keys.END);
	}
	
	/**
	 * Method to generate a random string of alphabets
	 */
	public static String generateRandomString() {
	    int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	 
	    System.out.println(generatedString);
	    return generatedString;
	}
	
	/**
	 * Method to capture screenshot
	 * @param driver: WebDriver : driver
	 * @param String: dest : destination folder
	 */
	public static void captureScreenShot(WebDriver driver, String dest) throws IOException {
		TakesScreenshot screen = (TakesScreenshot)driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		File target =new File(dest);
		FileUtils.copyFile(src, target);
	}
	
}