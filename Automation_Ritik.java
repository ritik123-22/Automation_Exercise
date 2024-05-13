import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddPackageTest {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://ecs-qa.kloudship.com");
    }

    @Test
    public void testAddPackage() {
        // Step 01: Login to the application
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        username.sendKeys("kloudship.qa.automation@mailinator.com");
        password.sendKeys("Password1");
        loginButton.click();

        // Step 02: Navigate to Package Types
        WebElement packageTypesLink = driver.findElement(By.linkText("Package Types"));
        packageTypesLink.click();

        // Step 03: Click on Add Manually button
        WebElement addManuallyButton = driver.findElement(By.id("add-manually-button"));
        addManuallyButton.click();

        // Step 04: Add a package with Name and Dimensions
        WebElement nameInput = driver.findElement(By.id("name"));
        WebElement dimensionsInput = driver.findElement(By.id("dimensions"));
        WebElement saveButton = driver.findElement(By.id("save-button"));

        nameInput.sendKeys("FirstName_LastName");
        dimensionsInput.sendKeys(String.valueOf(new Random().nextInt(20)));
        saveButton.click();

        // Step 06: Logout the application
        WebElement logoutLink = driver.findElement(By.linkText("Logout"));
        logoutLink.click();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
