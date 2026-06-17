package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;

public class AdminTest extends BaseTest {

    @Test
    public void adminPageShouldOpenAfterLogin() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        AdminPage adminPage = new AdminPage(driver);

        loginPage.open();
        loginPage.login(validUsername, validPassword);

        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard is not visible after login.");

        adminPage.openAdminMenu();

        Assert.assertTrue(adminPage.isAddButtonVisible(), "Admin page did not open correctly.");
        
        adminPage.clickAddButton();

       //adminPage.fillUsernameField();

    

        
    }
}
