package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

public class TestMathQuestionServiceFlow {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String baseUrl = "http://localhost:8080";
    private final String validUsername = "ahsan";
    private final String validPassword = "ahsan_pass";
    private final String validDob = "1990-01-01";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "/Users/sandalisamarawickrama/IdeaProjects/chromedriver-mac-arm64/chromedriver");        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Helper methods
    private void login(String username, String password, String dob) {
        driver.get(baseUrl + "/login");
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("passwd")).sendKeys(password);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    private void submitQ1Form(String num1, String num2, String result) {
        clearAndEnterText(By.name("number1"), num1);
        clearAndEnterText(By.name("number2"), num2);
        clearAndEnterText(By.name("result"), result);
        clickSubmit();

    }

    private void submitQ2Form(String num1, String num2, String result) {
        clearAndEnterText(By.name("number21"), num1);
        clearAndEnterText(By.name("number22"), num2);
        clearAndEnterText(By.name("result2"), result);
        clickSubmit();
    }

    private void submitQ3Form(String num1, String num2, String result) {
        clearAndEnterText(By.id("number31"), num1);
        clearAndEnterText(By.name("number32"), num2);
        clearAndEnterText(By.name("result3"), result);
        clickSubmit();
    }

    private void clearAndEnterText(By locator, String text) {
        wait.until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    private void clickSubmit() {
        driver.findElement(By.cssSelector("input[type='submit']")).click();
    }

    private String getErrorMessage() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(),'Wrong answer') or contains(text(),'Invalid input')]")));
        return errorMessage.getText();
    }

    private void verifyQuestionPage(String questionNumber) {
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[text()='" + questionNumber + "']")));
        assertTrue(header.isDisplayed());
    }

    // Test scenarios
    @Test
    public void UL_001() {
        login(validUsername, validPassword, validDob);

        verifyQuestionPage("Q1");
        submitQ1Form("5", "3", "8");  // 5 + 3 = 8

        verifyQuestionPage("Q2");
        submitQ2Form("10", "4", "6");  // 10 - 4 = 6

        verifyQuestionPage("Q3");
        submitQ3Form("3", "3", "9");  // 3 * 3 = 9

        wait.until(ExpectedConditions.urlContains("/completed"));
        assertTrue(driver.getPageSource().contains("Congratulation! You have completed the tasks"));
    }

    @Test
    public void UL_002() {
        login(validUsername, validPassword, validDob);

        submitQ1Form("5", "3", "7");  // Wrong answer
        assertTrue(getErrorMessage().contains("Wrong answer. Correct answer was: 8"));

        submitQ1Form("5", "3", "8");  // Correct answer

        submitQ2Form("10", "4", "6");
        submitQ3Form("3", "3", "9");

        wait.until(ExpectedConditions.urlContains("/completed"));
    }

    @Test
    public void UL_003() {
        login(validUsername, validPassword, validDob);

        submitQ1Form("abc", "xyz", "123");
        assertTrue(getErrorMessage().contains("Invalid input. Please enter valid numbers."));

        submitQ1Form("5", "3", "8");

        submitQ2Form("", "", "");
        assertTrue(getErrorMessage().contains("Invalid input. Please enter valid numbers."));

        submitQ2Form("10", "4", "6");
        submitQ3Form("3", "3", "9");

        wait.until(ExpectedConditions.urlContains("/completed"));
    }

    @Test
    public void UL_004() {
        login(validUsername, validPassword, validDob);

        submitQ1Form("5", "3", "9");  // Wrong
        assertTrue(getErrorMessage().contains("Wrong answer. Correct answer was: 8"));

        submitQ1Form("5", "3", "8");  // Correct

        submitQ2Form("10", "4", "5");  // Wrong
        assertTrue(getErrorMessage().contains("Wrong answer. Correct answer was: 6"));

        submitQ2Form("10", "4", "6");  // Correct

        submitQ3Form("3", "3", "8");  // Wrong
        assertTrue(getErrorMessage().contains("Wrong answer. Correct answer was: 9"));

        submitQ3Form("3", "3", "9");  // Correct

        wait.until(ExpectedConditions.urlContains("/completed"));
    }

    @Test
    public void UL_005() {
        login(validUsername, validPassword, validDob);

        submitQ1Form("5.5", "3.5", "9.0");

        submitQ2Form("3.5", "5.5", "-2.0");

        submitQ3Form("2.5", "4.2", "10.5");

        wait.until(ExpectedConditions.urlContains("/completed"));
    }
}