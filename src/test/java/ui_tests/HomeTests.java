package ui_tests;

import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.*;
import utils.HeaderMenuItem;

import static pages.BasePage.clickButtonHeader;

public class HomeTests extends ApplicationManager {
    @Test
    public void firstTest(){
        HomePage homePage= new HomePage(getDriver());
    }
    @Test
    public void SecondTest(){
        HomePage homePage= new HomePage(getDriver());
        TermsOfUsePage termsOfUsePage=clickButtonHeader(HeaderMenuItem.TERMS_OF_USE);
    }

}
