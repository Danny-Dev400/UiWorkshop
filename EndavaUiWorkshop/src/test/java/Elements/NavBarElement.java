package Elements;

import Pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavBarElement extends BasePage {
    private final By goToCartBtn = By.id("shopping_cart_container");

    public  NavBarElement(WebDriver driver){
        super(driver);
    }

    public void goToShoppingCart(){
        driver.findElement(goToCartBtn).click();
    }

}
