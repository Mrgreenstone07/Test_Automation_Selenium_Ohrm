package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginToOrangeHRM() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        loginPage.open();
        loginPage.login(validUsername, validPassword);

        dashboardPage.verifyIsDashboardVisible();
    }
    // Login with invalid creds and verify validation message in login screen
    @Test 
    public void loginWithInvalidPasswordAndVerify() {
        LoginPage loginPage = new LoginPage(driver);
        //DashboardPage dashboardPage = new DashboardPage(driver);
         //test
        loginPage.open();
        loginPage.login(validUsername, "Inavlid1234");

       loginPage.verifyInvalidPasswordError();
    }
}
