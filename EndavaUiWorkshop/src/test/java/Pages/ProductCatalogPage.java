package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductCatalogPage extends BasePage{
    By productsList = By.xpath("//div[@class='inventory_item_label']/a");
    public ProductCatalogPage(WebDriver driver){
        super(driver);
    }

    public void selectProductOfTheList(String itemName){
        this.driver.findElements(this.productsList).stream().filter(
                item -> item.getText().equals(itemName))
                .findFirst()
                .get()
                .click();
    }
}
