package pages;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddUserPage {
    
  private final WebDriver driver;
  
  private final By addUserHeader = By.xpath("//h6[text()='Add User']");
  private final By userRoleDropdown = By.xpath("//label[text()='User Role']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text-input')]");
  private final By adminOption = By.xpath("//div[@role='listbox']//*[text()='Admin']");
  private final By essOption = By.xpath("//div[@role='listbox']//*[text()='ESS']");
  private final By employeeNameinputfield = By.xpath("//input[@placeholder = 'Type for hints...']");
  private final By EmpStatus = By.xpath("//label[text() = 'Status']//ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//div[contains(@class,'oxd-select-text oxd-select-text')]");
  private final By EmpStatusEnabled = By.xpath("//div[@role = 'listbox']//*[text()='Enabled']") ;
  private final By EmpStatusDisabled = By.xpath("//div[@role = 'listbox']//*[text()='Disabled']") ;
  private final By usernameField = By.xpath("//label[text() = 'Username']//ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input[contains(@class,'oxd-input')]");
  private final By passwordField = By.xpath("(//input[@type = 'password'])[1]");
  private final By confirmPasswordField = By.xpath("(//input[@type = 'password'])[2]");
  private final By saveButton = By.xpath("//button[@type = 'submit']");
  private final By verifySave = By.xpath("//div[@id='oxd-toaster_1']//p[contains(@class,'oxd-text--toast-message')]");
  
  
  public AddUserPage(WebDriver driver){
      this.driver = driver;
  }

  public boolean isAddUserPageVisible() {
        return driver.findElement(addUserHeader).isDisplayed();
    }

  public void openUserRoleDropdown(){
    driver.findElement(userRoleDropdown).click();
  }

  public void selectAdminRole(){
    openUserRoleDropdown();
    driver.findElement(adminOption).click();
  }

  public void selectEssRole(){
    openUserRoleDropdown();
    driver.findElement(essOption).click();
  }

  public void selectOptionFromUserRoleDropdown(String OptionName){
     openUserRoleDropdown();
    WebElement Option = driver.findElement(By.xpath("//div[@role='listbox']//*[text()='"+OptionName+"']"));
    //WebElement option = driver.findElement(By.xpath("//div[@role='listbox']//*[text()='" + OptionName + "']"));
    Option.click();
  }

   public void fillEmployeeField(String EmpName){
    driver.findElement(employeeNameinputfield).sendKeys(EmpName);
   }
   
   public void selectEmployeeNameWithHints(String SelectEmp){
    WebElement Option = driver.findElement(By.xpath("//div[@role='listbox']//*[contains(text(),'"+SelectEmp+"')]"));
    Option.click();
   }

   public void fillAndSelectEmpName(String name){
    this.fillEmployeeField(name);
    this.selectEmployeeNameWithHints(name);
   }

   public void clickStatusDropdown(){
    driver.findElement(EmpStatus).click();
   }

   public void selectEmpStatusEnabled(){
    driver.findElement(EmpStatusEnabled).click();
   }

   public void selectEmpStatusDisabled(){
    driver.findElement(EmpStatusDisabled).click();
   }

   public void fillUsernameField(String user){
    driver.findElement(usernameField).sendKeys(user);
   }

   public void fillNewPassword(String pswrd){
    driver.findElement(passwordField).sendKeys(pswrd);
   }

    public void confirmNewPassword(String cpswrd){
    driver.findElement(confirmPasswordField).sendKeys(cpswrd);
   }

   public void clickSaveButton(){
    driver.findElement(saveButton).click();
   }

   public String getSuccessMessageText() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(verifySave)).getText();
}
}
