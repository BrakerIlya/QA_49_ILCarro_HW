package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import utils.HeaderMenuItem;

public class LoginTests extends ApplicationManager {
    LoginPage loginPage;
    @BeforeMethod
    public void goToLogin(){
        new HomePage(getDriver());
        loginPage= BasePage.clickButtonHeader(HeaderMenuItem.LOGIN);

    }

    @Test
    public void loginPositiveTest(){
        User user = User.builder().username("bilbo_baggins_12345@mail.com").password("Password123!").build();
        new LoginPage(getDriver()).typeLoginForm(user);
    }
    @Test
    public void loginNegativeWrongEmailTest(){
        User user = User.builder().username("bilbo_baggins_12345mail.com").password("Password123!").build();
        new LoginPage(getDriver()).typeLoginForm(user);
        Assert.assertTrue(loginPage.emailWrong());
    }
    @Test
    public void loginNegativeWrongPasswordTest(){
        User user = User.builder().username("bilbo_baggins_12345@mail.com").password("Password123").build();
        new LoginPage(getDriver()).typeLoginForm(user);
        Assert.assertTrue(loginPage.loginFailedIsPresent());

    }

}
