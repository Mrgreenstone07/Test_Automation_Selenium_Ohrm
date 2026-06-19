package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;

public class MyInfoTest extends BaseTest {

    @Test
    public void adminPageShouldOpenAfterLogin()  {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        MyInfoPage myInfoPage = new MyInfoPage(driver);

        String firstName = "Sudhanshu";
        String middleName = "Sekhar";
        String lastName = "Barah";

        String EmpId = "Sid";
        String OtherId = "E5858";

        String Dl = "D78787";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-dd-MM");

        LocalDate futureLicenseDate = LocalDate.now().plusYears(2);
        String dlExpDate = futureLicenseDate.format(formatter);


        LocalDate dob = LocalDate.now().minusYears(25);
        String dobDate = dob.format(formatter);

        // String DlExpDate = "2026-18-08";
        // String Dob = "1999-08-08";

        String Nationality = "Indian";

        String maritalStatus = "Single";

        String bloodType = "B+";

        String testField = "888";

        loginPage.open();
        loginPage.login(validUsername, validPassword);

        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard is not visible after login.");

        myInfoPage.clickMyInfoMenu();

        //Thread.sleep(5000);

        Assert.assertTrue(myInfoPage.myInfoPageIsDisplayed(), "My Info page is visible on clicking");

        // Thread.sleep(5000);

        myInfoPage.editProfilePicture();

        myInfoPage.uploadProfilePicture("profilePicture.png");
        myInfoPage.saveProfilePicture();
        myInfoPage.menuNavigator();
        myInfoPage.clickMyInfoMenu();

        myInfoPage.pdFillEmployeeName(firstName, middleName, lastName);
        Assert.assertEquals(myInfoPage.getFirstNameValue(), firstName, "First name did not update correctly.");
        Assert.assertEquals(myInfoPage.getMiddleNameValue(), middleName, "Middle name did not update correctly.");
        Assert.assertEquals(myInfoPage.getLastNameValue(), lastName, "Last name did not update correctly.");

        myInfoPage.fillEmpIdAndOtherId(EmpId, OtherId);
        Assert.assertEquals(myInfoPage.getEmployeeIdValue(), EmpId, "Employee Id did not update correctly.");
        Assert.assertEquals(myInfoPage.getOtherIdValue(), OtherId, "Other Id did not update correctly.");

        myInfoPage.fillDrivingLicenceNumAndExpDate(Dl, dlExpDate);
        Assert.assertEquals(myInfoPage.getDrivingLicenceValue(), Dl,
                "Driving License Number did not update correctly.");
        Assert.assertEquals(myInfoPage.getLicenceExpiryDateValue(), dlExpDate,
                "License Expiry Date did not update correctly.");

        myInfoPage.selectNationality(Nationality);
        Assert.assertEquals(myInfoPage.getSelectedNationality(), Nationality, "Nationality did not update correctly.");

        myInfoPage.selectMaritalStatus(maritalStatus);
        Assert.assertEquals(myInfoPage.getSelectedMaritalStatus(), maritalStatus,
                "Marital Status did not update correctly.");

        myInfoPage.selectDob(dobDate);
        Assert.assertEquals(myInfoPage.getDobValue(), dobDate, "Date of Birth did not update correctly.");

        myInfoPage.selectGenderMale();
        Assert.assertTrue(myInfoPage.isMaleSelected(), "Male gender option was not selected.");
        
        //Capture screenshot before save
        captureScreenshot("personal_details_before_save");

        myInfoPage.clickPersonalDetailsSavebtn();
        Assert.assertEquals(myInfoPage.getSuccessToastMessage(), "Successfully Updated", "Personal details save toast not shown.");

        myInfoPage.selectBloodType(bloodType);
        Assert.assertEquals(myInfoPage.getSelectedBloodType(), bloodType, "Blood Type did not update correctly.");
        myInfoPage.fillTestField(testField);
        Assert.assertEquals(myInfoPage.getTestFieldValue(), testField, "Test_Field did not update correctly.");
        // Capture screenshot before save
        captureScreenshot("custom_fields_before_save");
        myInfoPage.clickCustomSaveBtn();
        Assert.assertEquals(myInfoPage.getSuccessToastMessage(), "Successfully Saved", "Custom fields save toast not shown.");

    }
}