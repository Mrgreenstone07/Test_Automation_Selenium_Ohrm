package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;

public class MyInfoTest extends BaseTest{
    
    @Test
    public void adminPageShouldOpenAfterLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        MyInfoPage myInfoPage = new MyInfoPage(driver);


         loginPage.open();
        loginPage.login(validUsername, validPassword);

        Assert.assertTrue(dashboardPage.isDashboardVisible(), "Dashboard is not visible after login.");

        myInfoPage.clickMyInfoMenu();
         
        Thread.sleep(5000);

        Assert.assertTrue(myInfoPage.myInfoPageIsDisplayed(),"My Info page is visible on clicking");
}
}