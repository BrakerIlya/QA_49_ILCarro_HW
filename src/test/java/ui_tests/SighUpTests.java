package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.SignUpPage;
import utils.HeaderMenuItem;
import utils.UserFactory;

public class SighUpTests extends ApplicationManager {
    HomePage homePage;
    SignUpPage signUpPage;
    @BeforeMethod
    public void goToRegistration(){
        homePage=new HomePage(getDriver());
        signUpPage= BasePage.clickButtonHeader(HeaderMenuItem.SIGN_UP);
    }
    @Test
    public void registrationNegativeTest(){
        User user=UserFactory.positiveUser();
        user.setUsername("1111");
        signUpPage.typeLoginForm(user);
        signUpPage.clickCheckBoxWithActions();
        Assert.assertFalse(signUpPage.btnYallaIsEnabled());

    }
}
