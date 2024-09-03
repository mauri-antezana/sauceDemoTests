import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Checkout_Information extends BaseTest_CheckoutInformation{

    @Test
    public void notEmptyFields(){
        WebElement continueButton = driver.findElement(By.cssSelector("*[value='CONTINUE']"));

        continueButton.click();

        WebElement errorMessage = driver.findElement((By.xpath("//*[@id=\"checkout_info_container\"]/div/form/h3")));

        Assertions.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void continueButton(){
        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement postalCode = driver.findElement(By.id("postal-code"));
        WebElement continueButton = driver.findElement(By.cssSelector("*[value='CONTINUE']"));

        firstName.sendKeys("First Name");
        lastName.sendKeys("Last Name");
        postalCode.sendKeys("00000");
        continueButton.click();

        WebElement checkoutHeader = driver.findElement(By.xpath("//*[@id=\"contents_wrapper\"]/div[2]"));

        Assertions.assertTrue((checkoutHeader.isDisplayed()));
    }
}
