package sit707_week2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void officeworks_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/Users/sandalisamarawickrama/IdeaProjects/chromedriver-mac-arm64/chromedriver");
		
		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		
		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		driver.get(url);
		
		/*
		 * How to identify a HTML input field -
		 * Step 1: Inspect the webpage, 
		 * Step 2: locate the input field, 
		 * Step 3: Find out how to identify it, by id/name/...
		 */
		
		// Find first input field which is firstname
		WebElement element = driver.findElement(By.id("firstname"));
		System.out.println("Found element: " + element);
		// Send first name
		element.sendKeys("Sandali");
		
		/*
		 * Find following input fields and populate with values
		 */
		WebElement lastName = driver.findElement(By.id("lastname"));
		lastName.sendKeys("Samarawickrama");

		WebElement phoneNumber = driver.findElement(By.id("phoneNumber"));
		phoneNumber.sendKeys("0466936510");

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("wathmali123@gmail.com");

		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("testPassword");

		WebElement conPassword = driver.findElement(By.id("confirmPassword"));
		conPassword.sendKeys("testPassword");
		
		/*
		 * Identify button 'Create account' and click to submit using Selenium API.
		 */
		WebElement createBtn = driver.findElement(By.cssSelector("[data-testid='account-action-btn']"));
		createBtn.click();

		takeScreenshot(driver, "/Users/sandalisamarawickrama/Projects/SIT707/SIT707-Software-Quality-and-Testing/task2_1P_224390537/officeworks.png");

		// Sleep a while
		sleep(2);
		
		// close chrome driver
		driver.close();	
	}

	public static void toolsQA_registration_page(String url) {
		// Step 1: Locate chrome driver folder in the local drive.
		System.setProperty("webdriver.chrome.driver", "/Users/sandalisamarawickrama/IdeaProjects/chromedriver-mac-arm64/chromedriver");

		// Step 2: Use above chrome driver to open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(2);

		// Load a webpage in chromium browser.
		driver.get(url);

		WebElement element = driver.findElement(By.id("first-name"));
		element.sendKeys("Sandali");

		WebElement lastName = driver.findElement(By.id("last-name"));
		lastName.sendKeys("Samarawickrama");

		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("wathmali123@gmail.com");

		WebElement phoneNumber = driver.findElement(By.id("mobile"));
		phoneNumber.sendKeys("0466936510");

		Select countrySelect = new Select(driver.findElement(By.id("country")));
		countrySelect.selectByVisibleText("Austria");

		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("melbourne");

		WebElement message = driver.findElement(By.id("message"));
		message.sendKeys("test message");

		WebElement code = driver.findElement(By.id("code"));
		code.sendKeys("test code");

		WebElement sendBtn = driver.findElement(By.cssSelector(".btn.btn-block.btn-primary"));
		sendBtn.click();

		sleep(2);

		takeScreenshot(driver, "/Users/sandalisamarawickrama/Projects/SIT707/SIT707-Software-Quality-and-Testing/task2_1P_224390537/qaTools.png");

		sleep(2);

		driver.close();
	}

	/*
	 * Take screenshot using selenium API and save it to the given file 
	 */
	private static void takeScreenshot(WebDriver driver, String filePathName){
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(scrFile, new File(filePathName));
		}catch (IOException ex){
			System.out.println("Failed to save the screenshot"+ ex.getMessage());
		}
	}
	
	
}
