package UITests;

import Elements.NavBarElement;
import Pages.LoginPage;
import Pages.ProductCatalogPage;
import Pages.ProductDetailsPage;
import Pages.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class Tests extends Hooks{

    //@Test()
    public void AddToShoppingCart(){

        String itemName = "Sauce Labs Backpack";

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        By inputUsarname = By.cssSelector("input#user-name");
        driver.findElement(inputUsarname).sendKeys("standard_user");

        By inputPassword = By.id("password");
        driver.findElement(inputPassword).sendKeys("secret_sauce");

        By loginBtn = By.xpath("//input[@id='login-button']");
        driver.findElement(loginBtn).click();

        By productsList = By.xpath("//div[@class='inventory_item_label']/a");
        driver.findElements(productsList).stream().filter(
                item -> item.getText().equals(itemName))
                .findFirst()
                .get()
                .click();

        By productNameTittle = By.xpath("//div[@class='inventory_details_name large_size']");

        assertThat("The Product Name is incorrect",
                driver.findElement(productNameTittle).getText().equals(itemName));

        By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
        driver.findElement(addToCartBtn).click();

        By goToCartBtn = By.id("shopping_cart_container");
        driver.findElement(goToCartBtn).click();

        By cartItemsTitleList = By.cssSelector("div.cart_item div.inventory_item_name");
        String cartItemText = driver.findElements(cartItemsTitleList).stream().filter(
                item -> item.getText().equals(itemName))
                .findFirst()
                .get()
                .getText();

        assertThat("The Product Name is incorrect or te product is not in the cart",
                cartItemText.equals(itemName));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

    @Test()
    public void AddToShoppingCart2(){
        String itemName = "Sauce Labs Backpack";

        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendUsername("standard_user");
        loginPage.sendPassword("secret_sauce");
        loginPage.login();

        ProductCatalogPage productCatalogPage = new ProductCatalogPage(driver);
        productCatalogPage.selectProductOfTheList(itemName);

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        assertThat("The Product Name is incorrect",
                productDetailsPage.getProductNameTittle().equals(itemName));

        productDetailsPage.addToCart();

        NavBarElement navBarElement = new NavBarElement(driver);
        navBarElement.goToShoppingCart();

        ShoppingCartPage shoppingCartPage =  new ShoppingCartPage(driver);

        assertThat("The Product Name is incorrect or te product is not in the cart",
                shoppingCartPage.elementIsPresentInTheCart(itemName));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
