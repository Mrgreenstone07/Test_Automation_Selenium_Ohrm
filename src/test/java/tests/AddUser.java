package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.AddUserPage;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;

public class AddUser extends BaseTest {
    @Test
     public void addUserPageShouldOpen() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        AdminPage adminPage = new AdminPage(driver);
        AddUserPage addUserPage = new AddUserPage(driver);
        
         String EmpName = "aniket";
         String optionAdmin = "Admin";
         String uniqueUsername = "TestAutomation" + System.currentTimeMillis();


        loginPage.open();
        loginPage.login(validUsername, validPassword);

        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard is not visible after login.");

        adminPage.openAdminMenu();
        Assert.assertTrue(adminPage.isAddButtonVisible(), "Add button is not visible on Admin page.");

        adminPage.clickAddButton();
        Assert.assertTrue(addUserPage.isAddUserPageVisible(), "Add User page did not open.");

       // addUserPage.openUserRoleDropdown();
        //addUserPage.selectAdminRole();
        addUserPage.selectOptionFromUserRoleDropdown(optionAdmin);
        addUserPage.fillAndSelectEmpName(EmpName);
        addUserPage.clickStatusDropdown();
        addUserPage.selectEmpStatusDisabled();
        addUserPage.fillUsernameField(uniqueUsername);
        addUserPage.fillNewPassword("Bluestone1234");
        addUserPage.confirmNewPassword("Bluestone1234");
        addUserPage.clickSaveButton();
       Assert.assertEquals(addUserPage.getSuccessMessageText(), "Successfully Saved");
        Thread.sleep(5000);
        adminPage.fillUsernameField(uniqueUsername);
        adminPage.clickSearchButton();
        adminPage.totalNumberOfRecords();
        adminPage.verifyFirstRecord(uniqueUsername,optionAdmin,"aniket patil","Disabled");
}      


}
