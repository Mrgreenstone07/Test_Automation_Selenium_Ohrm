package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {

    private final WebDriver driver;
    private final By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardVisible() {
        return driver.findElement(dashboardHeader).isDisplayed();
        
    }

    public void verifyIsDashboardVisible(){
        Assert.assertTrue(this.isDashboardVisible(), "Login failed. Dashboard is not visible.");
    }
}


