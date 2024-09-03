import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest_HomePage {
    WebDriver driver;

    @BeforeEach
    public void setup(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/v1/");
        driver.manage().window().maximize();

        WebElement usernameTextBox = driver.findElement(By.id("user-name"));
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameTextBox.sendKeys("standard_user");
        passwordTextBox.sendKeys("secret_sauce");
        loginButton.click();
    }

    @AfterEach
    public void cleanup(){
        driver.quit();
    }
}
