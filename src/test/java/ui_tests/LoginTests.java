package ui_tests;

import dto.User;
import manager.ApplicationManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends ApplicationManager {
    @BeforeMethod
    public void goToLogin(){
        new HomePage(getDriver()).clickBtnLoginHeader();
    }

    @Test
    public void loginPositiveTest(){
        User user = User.builder().username("bilbo_baggins_12345@mail.com").password("Password123!").build();
        new LoginPage(getDriver()).typeLoginForm(user);
    }

}
