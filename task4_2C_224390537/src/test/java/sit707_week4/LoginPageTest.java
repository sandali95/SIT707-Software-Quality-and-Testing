package sit707_week4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Test class for bunnings login page
 * @author Sandali Samarawickrama
 */
public class LoginPageTest {

    private WebDriver driver;
    private org.openqa.selenium.support.ui.WebDriverWait wait;
    public static String BASE_URL = "https://www.bunnings.com.au/login";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/sandalisamarawickrama/IdeaProjects/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        wait = new WebDriverWait(driver, 10);


    }

    @Test
    public void testStudentIdentity() {
        String studentId = "224390537";
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Sandali Samarawickrama";
        Assert.assertNotNull("Student name is null", studentName);
    }


    @Test
    public void testEmptyPassword() {
        driver.findElement(By.id("username")).sendKeys("invalid@gmail.con");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-submit")).click();

        WebElement spanElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("password-error-message")));
        Assert.assertEquals("Error message should match",
                "This field is required",
                spanElement.getText());
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testEmptyEmail() {
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login-submit")).click();

        WebElement spanElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("username-error-message")));
        Assert.assertEquals("Error message should match",
                "This field is required",
                spanElement.getText());
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testInvalidEmailPattern() {
        driver.findElement(By.id("username")).sendKeys("invalid");
        driver.findElement(By.id("password")).sendKeys("anypassword");
        driver.findElement(By.id("login-submit")).click();

        WebElement spanElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("username-error-message")));
        Assert.assertEquals("Error message should match",
                "Please provide a valid email address",
                spanElement.getText());
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testInvalidEmail() {
        driver.findElement(By.id("username")).sendKeys("invalid@gmail.com");
        driver.findElement(By.id("password")).sendKeys("anypassword");
        driver.findElement(By.id("login-submit")).click();

        WebElement spanElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("div[role='alert'][data-locator='form-error-alert'] span")));
        Assert.assertEquals("Error message should match",
                "Your email address or password is incorrect",
                spanElement.getText());
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testInvalidPassword() {
        driver.findElement(By.id("username")).sendKeys("wathmali123@email.com");
        driver.findElement(By.id("password")).sendKeys("anypassword");
        driver.findElement(By.id("login-submit")).click();

        WebElement spanElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("div[role='alert'][data-locator='form-error-alert'] span")));
        Assert.assertEquals("Error message should match",
                "Your email address or password is incorrect",
                spanElement.getText());
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testInvalidPasswordAndInvalidEmail() {
        driver.findElement(By.id("username")).sendKeys("wathmali123@email.com");
        driver.findElement(By.id("password")).sendKeys("anypassword");
        driver.findElement(By.id("login-submit")).click();

        WebElement spanElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("div[role='alert'][data-locator='form-error-alert'] span")));
        Assert.assertEquals("Error message should match",
                "Your email address or password is incorrect",
                spanElement.getText());
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));
    }

    @Test
    public void testValidPasswordAndValidEmail() {
        driver.findElement(By.id("username")).sendKeys("wathmali123@gmail.com");
        driver.findElement(By.id("password")).sendKeys("myPassword@0");
        driver.findElement(By.id("login-submit")).click();

        wait.until(ExpectedConditions.urlToBe("https://www.bunnings.com.au/"));

        WebElement accountElement = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button[contains(@data-name, 'account')]")));
        Assert.assertTrue("Account button should be visible",
                accountElement.getText().contains("Account"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
