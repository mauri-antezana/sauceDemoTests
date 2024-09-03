import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BaseTest_CartPage{

    @Test
    public void notEmptyCart(){

        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        WebElement checkoutButton = driver.findElement(By.cssSelector("[href='./checkout-step-one.html']"));

        boolean notEmpty = false;

        if(cartItems.size() > 0){
            notEmpty = true;
        }

        checkoutButton.click();

        WebElement checkoutHeader = driver.findElement(By.className("subheader"));

        if (notEmpty){
            Assertions.assertTrue(checkoutHeader.isDisplayed());
        } else {
            Assertions.assertFalse(checkoutHeader.isDisplayed());
        }
    }
}
