package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends BasePage{
    private final By inputUsarname = By.cssSelector("input#user-name");
    private final By inputPassword = By.id("password");
    private final By loginBtn = By.xpath("//input[@id='login-button']");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void sendUsername(String query){
        this.driver.findElement(this.inputUsarname).sendKeys(query);
    }
    public void sendPassword(String query){
        this.driver.findElement(this.inputPassword).sendKeys(query);
    }
    public void login(){
        this.driver.findElement(this.loginBtn).click();
    }
}
