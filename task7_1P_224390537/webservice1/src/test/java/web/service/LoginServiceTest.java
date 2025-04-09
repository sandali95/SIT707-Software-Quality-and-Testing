package web.service;

import java.time.Duration;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginServiceTest {

	private WebDriver driver;


	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"/Users/sandalisamarawickrama/IdeaProjects/chromedriver-mac-arm64/chromedriver");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}


	private String getLoginPagePath() {
		return "file:///Users/sandalisamarawickrama/Projects/SIT707/SIT707-Software-Quality-and-Testing/task7_1P_224390537/pages/login.html";
	}


	private String waitForTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.or(
				ExpectedConditions.titleIs("success"),
				ExpectedConditions.titleIs("fail")
		));
		return driver.getTitle();
	}

	@Test
	public void testLoginSuccess() {
		driver.navigate().to(getLoginPagePath());

		// Enter valid credentials.
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.clear();
		usernameField.sendKeys("ahsan");

		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.clear();
		passwordField.sendKeys("ahsan_pass");

		WebElement dobField = driver.findElement(By.id("dob"));
		dobField.clear();
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '2000-03-08';", dobField);

		// Submit the form.
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
		submitButton.submit();

		// Wait for the title to be updated and verify a successful login.
		String title = waitForTitle();
		System.out.println("Test Login Success - Title: " + title);
		Assert.assertEquals("success", title);
	}


	@Test
	public void testLoginFailure_WrongUsername() {
		driver.navigate().to(getLoginPagePath());

		// Enter an incorrect username.
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.clear();
		usernameField.sendKeys("wronguser");

		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.clear();
		passwordField.sendKeys("ahsan_pass");

		WebElement dobField = driver.findElement(By.id("dob"));
		dobField.clear();
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '2000-03-08';", dobField);

		// Submit the form.
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
		submitButton.submit();

		String title = waitForTitle();
		System.out.println("Test Login Failure Wrong Username - Title: " + title);
		Assert.assertEquals("fail", title);
	}


	@Test
	public void testLoginFailure_WrongPassword() {
		driver.navigate().to(getLoginPagePath());

		// Enter an incorrect password.
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.clear();
		usernameField.sendKeys("ahsan");

		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.clear();
		passwordField.sendKeys("wrong_pass");

		WebElement dobField = driver.findElement(By.id("dob"));
		dobField.clear();
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '2000-03-08';", dobField);

		// Submit the form.
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
		submitButton.submit();

		String title = waitForTitle();
		System.out.println("Test Login Failure Wrong Password - Title: " + title);
		Assert.assertEquals("fail", title);
	}

	@Test
	public void testLoginFailure_WrongDob() {
		driver.navigate().to(getLoginPagePath());

		// Enter an incorrect date of birth.
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.clear();
		usernameField.sendKeys("ahsan");

		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.clear();
		passwordField.sendKeys("ahsan_pass");

		WebElement dobField = driver.findElement(By.id("dob"));
		dobField.clear();
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '1999-03-08';", dobField);

		// Submit the form.
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
		submitButton.submit();

		String title = waitForTitle();
		System.out.println("Test Login Failure Wrong DOB - Title: " + title);
		Assert.assertEquals("fail", title);
	}

	@Test
	public void testLoginFailure_EmptyFields() {
		driver.navigate().to(getLoginPagePath());

		// Submit the form with all fields empty.
		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
		submitButton.submit();

		String title = waitForTitle();
		System.out.println("Test Login Failure Empty Fields - Title: " + title);
		Assert.assertEquals("fail", title);
	}

	@Test
	public void testLoginFailure_ExtraWhitespaceInUsername() {
		driver.navigate().to(getLoginPagePath());

		// Enter username with extra whitespace.
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.clear();
		usernameField.sendKeys(" ahsan ");

		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.clear();
		passwordField.sendKeys("ahsan_pass");

		WebElement dobField = driver.findElement(By.id("dob"));
		dobField.clear();
		((JavascriptExecutor) driver).executeScript("arguments[0].value = '2000-03-08';", dobField);

		WebElement submitButton = driver.findElement(By.cssSelector("[type=submit]"));
		submitButton.submit();

		String title = waitForTitle();
		System.out.println("Test Login Failure Extra Whitespace in Username - Title: " + title);
		Assert.assertEquals("fail", title);
	}
}
