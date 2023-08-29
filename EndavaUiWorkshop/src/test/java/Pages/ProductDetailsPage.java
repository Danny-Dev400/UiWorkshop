package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{
    private final By productNameTittle = By.xpath("//div[@class='inventory_details_name large_size']");
    private final By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    public ProductDetailsPage(WebDriver driver){
        super(driver);
    }

    public String getProductNameTittle() {
        return driver.findElement(productNameTittle).getText();
    }
    public void addToCart(){
        By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
        driver.findElement(addToCartBtn).click();
    }

}
