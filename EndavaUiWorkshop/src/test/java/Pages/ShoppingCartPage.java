package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage{
    private final By goToCartBtn = By.id("shopping_cart_container");
    private final By cartItemsTitleList = By.cssSelector("div.cart_item div.inventory_item_name");

    public ShoppingCartPage(WebDriver driver){
        super(driver);
    }

    public boolean elementIsPresentInTheCart(String itemName){
        return driver.findElements(cartItemsTitleList).stream().filter(
                item -> item.getText().equals(itemName))
                .findFirst()
                .get()
                .getText()
                .equals(itemName);
    }
}
