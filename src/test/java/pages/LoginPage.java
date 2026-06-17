package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.ConfigReader;

public class LoginPage {

    private final WebDriver driver;

    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.xpath("//button[@type='submit']");
    private final By validationMessage = By.xpath("//p[@class = 'oxd-text oxd-text--p oxd-alert-content-text']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(ConfigReader.get("baseUrl"));
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public void verifyInvalidPasswordError(){
        String messageInvalid = driver.findElement(validationMessage).getText();
        Assert.assertEquals(messageInvalid, "Invalid credentials-1");
    }

    
}
