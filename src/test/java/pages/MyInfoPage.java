package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.openqa.selenium.Keys;

public class MyInfoPage {
    
    private final WebDriver driver;

    private final By myInfoMenu = By.xpath("//span[text()='My Info']");
    private final By myInfoHeader = By.xpath("//div[@class = 'orangehrm-edit-employee-imagesection']");
    private final By pdFirstName = By.xpath("//input[@name = 'firstName']");
    private final By pdMiddleName = By.xpath("//input[@name = 'middleName']");
    private final By pdLastName = By.xpath("//input[@name = 'lastName']");
    private final By pdEmpId = By.xpath("//label[normalize-space()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By otherEmpId = By.xpath("//label[normalize-space()='Other Id']/ancestor::div[contains(@class,'oxd-input-group')]//input");

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void clickMyInfoMenu(){
        driver.findElement(myInfoMenu).click();
    }

    public boolean myInfoPageIsDisplayed(){
        return driver.findElement(myInfoHeader).isDisplayed();
    }

    public void pdFillEmployeeName(String firstName,String middleName, String lastName) throws InterruptedException{
         driver.findElement(pdFirstName).sendKeys(Keys.CONTROL + "a");
         driver.findElement(pdFirstName).sendKeys(Keys.DELETE);
         driver.findElement(pdFirstName).sendKeys(firstName);
         driver.findElement(pdMiddleName).sendKeys(Keys.CONTROL + "a");
         driver.findElement(pdMiddleName).sendKeys(Keys.DELETE);
         driver.findElement(pdMiddleName).sendKeys(middleName);
         driver.findElement(pdLastName).sendKeys(Keys.CONTROL + "a");
         driver.findElement(pdLastName).sendKeys(Keys.DELETE);
         driver.findElement(pdLastName).sendKeys(lastName);

    }

    public void fillEmpIdAndOtherId(String EmpId,String OtherId){
        driver.findElement(pdEmpId).sendKeys(Keys.CONTROL + "a");
         driver.findElement(pdEmpId).sendKeys(Keys.DELETE);
         driver.findElement(pdEmpId).sendKeys(EmpId);

         driver.findElement(otherEmpId).sendKeys(Keys.CONTROL + "a");
         driver.findElement(otherEmpId).sendKeys(Keys.DELETE);
         driver.findElement(otherEmpId).sendKeys(OtherId);
    }
}
