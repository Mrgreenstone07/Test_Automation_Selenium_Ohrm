package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

public class AdminPage {

    private final WebDriver driver;
    
    private final By adminHeader = By.xpath("//h6[text()='Admin']");
    private final By adminMenu = By.xpath("//span[text()='Admin']");
    private final By addButton = By.xpath("//button[text()=' Add ']");
    private final By addUserHeader = By.xpath("//h6[text()='Add User']");
     private final By employeeNameinputfield = By.xpath("//input[@placeholder = 'Type for hints...']");
     private final By EmpStatus = By.xpath("//label[text() = 'Status']//ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//div[contains(@class,'oxd-select-text oxd-select-text')]");
     private final By EmpStatusEnabled = By.xpath("//div[@role = 'listbox']//*[text()='Enabled']") ;
     private final By EmpStatusDisabled = By.xpath("//div[@role = 'listbox']//*[text()='Disabled']") ;
     private final By usernameField = By.xpath("//label[text() = 'Username']//ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input[contains(@class,'oxd-input')]");
     private final By searchButton = By.xpath("//button[text() = ' Search ']");
     private final By searchTotalHeader = By.xpath("(//span[@class = 'oxd-text oxd-text--span'])[1]");
     private final By  usernameRow1Data = By.xpath("(//div[@class = 'oxd-table-card'])[1]//*[@role='cell'][2]");
     private final By  UserRoleRow1Data = By.xpath("(//div[@class = 'oxd-table-card'])[1]//*[@role='cell'][3]");
      private final By  EmployeeNameRow1Data = By.xpath("(//div[@class = 'oxd-table-card'])[1]//*[@role='cell'][4]");
      private final By  statusRow1Data = By.xpath("(//div[@class = 'oxd-table-card'])[1]//*[@role='cell'][5]");
      
     
     public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openAdminMenu() {
        driver.findElement(adminMenu).click();
    }

    public boolean isAddButtonVisible() {
        return driver.findElement(addButton).isDisplayed();
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public boolean isAddUserPageVisible() {
        return driver.findElement(addUserHeader).isDisplayed();
    }

    public boolean isAdminHeadVisible(){
        return driver.findElement(adminHeader).isDisplayed();
    }
    
    public void clickAdminIfNotVisible(){
        if(isAdminHeadVisible() != true) {
           driver.findElement(adminMenu).click();
        }
        else{
            System.out.println("Admin page already visible");
        }
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

   public void clickSearchButton(){
    driver.findElement(searchButton).click();
   }

   public void totalNumberOfRecords(){
     String records = driver.findElement(searchTotalHeader).getText();
     Assert.assertEquals(records,"(1) Record Found");
   }

   public void verifyFirstRecord(String r1,String r2,String r3,String r4){
    String records1 = driver.findElement(usernameRow1Data).getText();
    String records2 = driver.findElement(UserRoleRow1Data).getText();
    String records3 = driver.findElement(EmployeeNameRow1Data).getText();
    String records4 = driver.findElement(statusRow1Data).getText();
    Assert.assertEquals(records1,r1);
    Assert.assertEquals(records2,r2);
    Assert.assertEquals(records3,r3);
    Assert.assertEquals(records4,r4);
    

   }

}
