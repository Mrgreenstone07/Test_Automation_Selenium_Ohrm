package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyInfoPage {

    private final WebDriver driver;

    private final By myInfoMenu = By.xpath("//span[text()='My Info']");
    private final By myInfoHeader = By.xpath("//div[@class = 'orangehrm-edit-employee-imagesection']");
    private final By pdFirstName = By.xpath("//input[@name = 'firstName']");
    private final By pdMiddleName = By.xpath("//input[@name = 'middleName']");
    private final By pdLastName = By.xpath("//input[@name = 'lastName']");
    private final By pdEmpId = By
            .xpath("//label[normalize-space()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By pdOtherEmpId = By
            .xpath("//label[normalize-space()='Other Id']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By pdDrivingLicenceNmbr = By.xpath(
            "//label[normalize-space()=concat('Driver',\"'\",'s License Number')]/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By pdLicenceExpDate = By.xpath(
            "//label[normalize-space()='License Expiry Date']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By pdNationalityDrpdwn = By.xpath(
            "//label[normalize-space()='Nationality']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text--active')]");
    // private final By pdNationalityDrpdwnOptions =
    // By.xpath("//div[@role='listbox']//div[@role='option'][normalize-space()='\" +
    // nationality + \"']')]");
    private final By pdMaritalStatusDrpdwn = By.xpath(
            "//label[normalize-space()='Marital Status']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text')]");
    private final By pdDob = By.xpath(
            "//label[normalize-space()='Date of Birth']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By pdGenderMale = By.xpath("//label[normalize-space()='Male']");
    private final By pdGenderFeMale = By.xpath("//label[normalize-space()='Female']");
    private final By pdBloodType = By.xpath(
            "//label[normalize-space()='Blood Type']/ancestor::div[contains(@class,'oxd-input-group')]//div[contains(@class,'oxd-select-text--active')]");
    private final By pdPersonalSaveBtn = By.xpath("(//button[@type = 'submit'])[1]");
    private final By pdTestField = By
            .xpath("//label[normalize-space()='Test_Field']/ancestor::div[contains(@class,'oxd-input-group')]//input");
    private final By pdCustomSaveBtn = By.xpath("(//button[@type = 'submit'])[2]");
    private final By pdPhoto = By.xpath("//div[@class = 'orangehrm-edit-employee-image']");
    private final By menuNavigator3Bars = By.xpath("//div[contains(@class,'oxd-topbar-header-title')]");
    // private final By ProfilePicturePlusIconbtn = By.xpath("//button[@class =
    // 'oxd-icon-button oxd-icon-button--solid-main employee-image-action']");
    private final By profilePhotoUploadInput = By.xpath("//input[@type='file' and contains(@class,'oxd-file-input')]");
    private final By profilePictureSaveBtn = By.xpath("//button[@type = 'submit']");
    private final By formLoader = By.xpath("//div[contains(@class,'oxd-form-loader')]");
    // loacator for verifying success message
    private final By successToastMessage = By.xpath("//p[contains(@class,'oxd-text--toast-message')]");

    public MyInfoPage(WebDriver driver) {
        this.driver = driver;
    }
   
    public void waitForLoaderToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(formLoader));
    }

    // reusable helper method for inputs
    private void clearAndType(By locator, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        waitForLoaderToDisappear();

        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(locator));
        field.click();
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(Keys.DELETE);
        field.sendKeys(value);
    }

    // helper method for dropdown selection
    private void selectDropdownOption(By dropdownLocator, String optionText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        waitForLoaderToDisappear();

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
        dropdown.click();

        By optionLocator = By
                .xpath("//div[@role='listbox']//div[@role='option'][normalize-space()='" + optionText + "']");
        wait.until(ExpectedConditions.elementToBeClickable(optionLocator)).click();
    }

    // helper method for radio button click
    private void clickRadioOption(By radioLocator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        waitForLoaderToDisappear();

        WebElement radio = wait.until(ExpectedConditions.elementToBeClickable(radioLocator));
        radio.click();
    }

    public void clickMyInfoMenu() {
        driver.findElement(myInfoMenu).click();
    }

    public boolean myInfoPageIsDisplayed() {
        return driver.findElement(myInfoHeader).isDisplayed();
    }

    public void editProfilePicture() {
        driver.findElement(pdPhoto).click();
    }

    public void uploadProfilePicture(String fileName) {
        String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\images\\" + fileName;

        // driver.findElement(ProfilePicturePlusIconbtn).click();
        driver.findElement(profilePhotoUploadInput).sendKeys(filePath);
    }

    public void saveProfilePicture() {
        driver.findElement(profilePictureSaveBtn).click();
    }

    public void menuNavigator() {
        driver.findElement(menuNavigator3Bars).click();
    }

    public void pdFillEmployeeName(String firstName, String middleName, String lastName) {
        clearAndType(pdFirstName, firstName);
        clearAndType(pdMiddleName, middleName);
        clearAndType(pdLastName, lastName);
    }

    public void fillEmpIdAndOtherId(String empId, String otherId) {
        clearAndType(pdEmpId, empId);
        clearAndType(pdOtherEmpId, otherId);
    }

    public void fillDrivingLicenceNumAndExpDate(String dl, String dlExpDate) {
        clearAndType(pdDrivingLicenceNmbr, dl);
        clearAndType(pdLicenceExpDate, dlExpDate);
    }

    public void selectNationality(String nationality) {
        selectDropdownOption(pdNationalityDrpdwn, nationality);
    }

    public void selectMaritalStatus(String maritalStatus) {
        selectDropdownOption(pdMaritalStatusDrpdwn, maritalStatus);
    }

    public void selectDob(String dob) {
        clearAndType(pdDob, dob);
    }

    public void selectGenderMale() {
        clickRadioOption(pdGenderMale);
    }

    public void selectGenderFeMale() {
        clickRadioOption(pdGenderFeMale);
    }

    public void clickPersonalDetailsSavebtn() {
        driver.findElement(pdPersonalSaveBtn).click();
    }

    public void selectBloodType(String bloodType) {
        selectDropdownOption(pdBloodType, bloodType);
    }

    public void fillTestField(String testField) {
        clearAndType(pdTestField, testField);
    }

    public void clickCustomSaveBtn() {
        driver.findElement(pdCustomSaveBtn).click();
    }

    // Verify text input fields
    public String getFirstNameValue() {
        return driver.findElement(pdFirstName).getAttribute("value");
    }

    public String getMiddleNameValue() {
        return driver.findElement(pdMiddleName).getAttribute("value");
    }

    public String getLastNameValue() {
        return driver.findElement(pdLastName).getAttribute("value");
    }

    public String getEmployeeIdValue() {
        return driver.findElement(pdEmpId).getAttribute("value");
    }

    public String getOtherIdValue() {
        return driver.findElement(pdOtherEmpId).getAttribute("value");
    }

    public String getDrivingLicenceValue() {
        return driver.findElement(pdDrivingLicenceNmbr).getAttribute("value");
    }

    public String getLicenceExpiryDateValue() {
        return driver.findElement(pdLicenceExpDate).getAttribute("value");
    }

    public String getDobValue() {
        return driver.findElement(pdDob).getAttribute("value");
    }

    public String getTestFieldValue() {
        return driver.findElement(pdTestField).getAttribute("value");
    }

    // Verify selected dropdown values
    public String getSelectedNationality() {
        return driver.findElement(pdNationalityDrpdwn).getText().trim();
    }

    public String getSelectedMaritalStatus() {
        return driver.findElement(pdMaritalStatusDrpdwn).getText().trim();
    }

    public String getSelectedBloodType() {
        return driver.findElement(pdBloodType).getText().trim();
    }

    // Verify selected gender
    public boolean isMaleSelected() {
        return driver.findElement(pdGenderMale).getAttribute("class").contains("--checked")
                || driver.findElement(pdGenderMale).getText().contains("Male");
    }

    // Verify success message
    public String getSuccessToastMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successToastMessage)).getText().trim();
    }
}
