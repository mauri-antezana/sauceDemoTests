import com.google.common.collect.Ordering;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BaseTest_HomePage{

    @Test
    public void orderPriceHighToLow(){
        WebElement sortComboBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("product_sort_container")));

        Select selectObject = new Select(sortComboBox);
        selectObject.selectByVisibleText("Price (high to low)");

        List<WebElement> productsList = driver.findElements(By.className("inventory_item_price"));

        List<String> actualProductOrder = new ArrayList<>();
        List<Double> priceList = new ArrayList<>();

        for(WebElement product : productsList) {
            actualProductOrder.add(product.getText());
        }

        for (String s : actualProductOrder) {

            String noSymbol = s.replace("$", "");
            double price = Double.parseDouble(noSymbol);

            priceList.add(price);
        }

        boolean isSort = Ordering.natural().reverse().isOrdered(priceList);
        Assertions.assertTrue(isSort);
    }

    @Test
    public void cartButton(){
        WebElement cartButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#shopping_cart_container > a > svg > path")));

        cartButton.click();

        WebElement cartHeader = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("subheader")));

        Assertions.assertTrue(cartHeader.isDisplayed());
    }
}
