package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

public class MyInfoPage {
    
    private final WebDriver driver;

    private final By myInfoMenu = By.xpath("//span[text()='My Info']");
    private final By myInfoHeader = By.xpath("//div[@class = 'orangehrm-edit-employee-imagesection']");
    
    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickMyInfoMenu(){
        driver.findElement(myInfoMenu).click();
    }

    public boolean myInfoPageIsDisplayed(){
        return driver.findElement(myInfoHeader).isDisplayed();
    }
}
